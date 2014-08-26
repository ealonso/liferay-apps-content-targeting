AUI.add(
	'liferay-ct-form-builder',
	function(A) {
		var AVAILABLE_FIELD_LABEL_TPL = '<div class="row"><div class="field-title">{name}</div><div class="field-description">{description}</div></div>';

		var FIELD_LABEL_TPL = '{name}';

		var ITEM_FIELD_TPL = '<div>' +
			'<div class="field-header">' +
				'<div class="field-icon">' +
					'<i class="{icon}"></i>' +
				'</div>' +
				'<div class="row field-info">' +
					'<div class="field-title">{name}</div>' +
					'<div class="field-description">{description}</div>' +
				'</div>' +
			'</div>' +
			'<div class="field-editor">{editor}</div>' +
		'</div>';

		var ITEM_CATEGORY_HEADER_TPL = '<div class="category-header toggler-header toggler-header-collapsed">' +
			'<span class="category-icon icon {icon}"></span>' +
			'<div class="category-info"> ' +
				'<div class="category-title">{name}</div>' +
				'<div class="category-description">{description}</div>' +
			'</div>' +
		'</div>';

		var ITEM_CATEGORY_CONTENT_TPL = '<div class="category-content toggler-content toggler-content-collapsed"></div>';

		var LiferayCTFormItemSearch = A.Base.create(
			'Search',
			A.Base,
			[A.AutoCompleteBase],
			{
				initializer: function() {
					this._bindUIACBase();
					this._syncUIACBase();
				}
			}
		);

		var LiferayCTFormBuilder = A.Component.create(
			{
				ATTRS: {
					searchBox: {
						setter: A.one
					}
				},

				EXTENDS: A.FormBuilder,

				NAME: 'liferay-ct-form-builder',

				prototype: {
					initializer: function() {
						var instance = this;

						var eventHandles = [];

						instance._parseFields();

						if (instance.get('searchBox')) {
							var fieldsFilter = instance._createItemFilter();

							eventHandles.push(
								fieldsFilter.on('results', instance._onItemFilterResults, instance),
								instance.on('fieldsChange', instance._onFieldsChange, instance)
							);
						}

						instance.after(instance._afterUiSetAvailableFields, instance, '_uiSetAvailableFields');

						instance._eventHandles = eventHandles;
					},

					destructor: function() {
						var instance = this;

						(new A.EventHandle(instance._eventHandles)).detach();
					},

					_afterUiSetAvailableFields: function(event) {
						var instance = this;

						var fieldsContainer = A.one('.diagram-builder-fields-container');

						var searchBox = instance.get('searchBox');

						if (searchBox) {
							A.one('.tab-pane.active').insertBefore(
								searchBox,
								fieldsContainer
							).removeClass('hide');
						}

						var categories = {};

						A.Array.each(
							instance.get('availableFields'),
							function(item) {
								var title = item.labelNode.one('.field-title').text();

								var itemNode = item.get('node');

								itemNode.attr('title', title);

								var category = item.get('options').category;

								var categoryKey = category.key;

								if (category && categoryKey) {
									if (!categories[categoryKey]) {
										categories[categoryKey] = {
											category: category,
											fields: []
										};
									}

									categories[categoryKey].fields.push(itemNode);
								}
							}
						);

						instance._groupFields(categories, fieldsContainer);
					},

					_createItemFilter: function() {
						var instance = this;

						var fieldSearch = new LiferayCTFormItemSearch(
							{
								inputNode: instance.get('searchBox').one('input'),
								minQueryLength: 0,
								queryDelay: 0,
								resultFilters: 'phraseMatch',
								resultTextLocator: 'searchData',
								source: (function() {
									return A.Array.map(
										instance.get('availableFields'),
										function(field) {
											return {
												node: field.labelNode,
												searchData: field.labelNode.one('.field-title').text()
											};
										}
									);
								}())
							}
						);

						return fieldSearch;
					},

					_groupFields: function(categories, fieldsContainer) {
						var instance = this;

						A.Object.each(
							categories,
							function(item) {
								var categoryHeader = A.Node.create(
									A.Lang.sub(
										ITEM_CATEGORY_HEADER_TPL,
										{
											description: item.category.description,
											icon: item.category.icon,
											name: item.category.name
										}
									)
								);

								var categoryContent = A.Node.create(
									A.Lang.sub(
										ITEM_CATEGORY_CONTENT_TPL
									)
								);

								A.Array.each(
									item.fields,
									function(field) {
										categoryContent.append(field);
									}
								);

								var categoryWrapper = A.Node.create('<div class="category-wrapper"></div>');

								categoryWrapper.append(categoryHeader);
								categoryWrapper.append(categoryContent);

								fieldsContainer.append(categoryWrapper);
							}
						);

						if (!instance._togglerDelegate) {
							instance._togglerDelegate = new A.TogglerDelegate(
								{
									animated: true,
									closeAllOnExpand: true,
									container: fieldsContainer,
									content: '.category-content',
									expanded: true,
									header: '.category-header'
								}
							);
						}
					},

					_onClickField: function(event) {
						var instance = this;

						var field = A.Widget.getByNode(event.target);

						instance.simulateFocusField(field, event.target);

						event.stopPropagation();
					},

					_onFieldsChange: function(event) {
						var instance = this;

						instance.get('canvas').toggleClass('has-items', instance.get('fields').size());
					},

					_onItemFilterResults: function(event) {
						var instance = this;

						var contentBox = instance.get('contentBox');

						var availableFieldsContainer = contentBox.one('.diagram-builder-fields-container');

						var categories = availableFieldsContainer.all('.category-wrapper');

						var query = event.query;

						if (!instance._collapsedCategories) {
							instance._collapsedCategories = [];

							categories.each(
								function(item, index) {
									var header = item.one('.toggler-header');

									if (header && header.hasClass('toggler-header-collapsed')) {
										instance._collapsedCategories.push(item);
									}
								}
							);
						}

						if (!query) {
							availableFieldsContainer.all('.category-wrapper, .diagram-builder-field').removeClass('hide');

							if (instance._collapsedCategories) {
								A.each(
									instance._collapsedCategories,
									function(item, index) {
										var categoryIndex = categories.indexOf(item);

										var togglerItems = instance._togglerDelegate.items;

										togglerItems[categoryIndex].collapse(
											{
												silent: true
											}
										);
									}
								);

								instance._collapsedCategories = null;
							}
						}
						else {
							availableFieldsContainer.all('.category-wrapper, .diagram-builder-field').addClass('hide');

							A.Array.each(
								event.results,
								function(result) {
									result.raw.node.ancestor('.diagram-builder-field').removeClass('hide');
									result.raw.node.ancestor('.category-wrapper').removeClass('hide');
								}
							);

							instance._togglerDelegate.expandAll(
								{
									silent: true
								}
							);
						}
					},

					_parseFieldContainer: function(fieldsContainer, labelTpl) {
						var instance = this;

						var fields = [];

						fieldsContainer.all('.form-builder-field').each(
							function(field) {
								var categoryDescription = field.attr('data-categorydescription');
								var categoryIcon = field.attr('data-categoryicon');
								var categoryKey = field.attr('data-categorykey');
								var categoryName = field.attr('data-categoryname');
								var description = field.one('.field-description').text();
								var editor = field.attr('data-template');
								var icon = field.attr('data-icon');
								var key = field.attr('data-key');
								var fieldData = /^([^_]*)(?:_(.*))?$/.exec(key);
								var name = field.one('.field-title').text();
								var unique = field.attr('data-unique') === 'true';

								A.LiferayCTFormBuilder.registerField(
									{
										description: description,
										editor: editor,
										icon: icon,
										id: fieldData[2] ? key : '',
										key: key,
										name: name
									}
								);

								fields.push(
									{
										iconClass: icon,
										id: fieldData[1],
										label: A.Lang.sub(
											labelTpl,
											{
												description: description,
												name: name
											}
										),
										options: {
											category: {
												description: categoryDescription,
												icon: categoryIcon,
												key: categoryKey,
												name: categoryName
											}
										},
										type: key,
										unique: unique
									}
								);
							}
						);

						return fields;
					},

					_parseFields: function() {
						var instance = this;

						var contentBox = instance.get('contentBox');
						var availableFieldsContainer = contentBox.one('.diagram-builder-fields-container');
						var availableFields = [];

						if (availableFieldsContainer) {
							availableFields = instance._parseFieldContainer(availableFieldsContainer, AVAILABLE_FIELD_LABEL_TPL);
						}

						var fieldsContainer = contentBox.one('.form-builder-drop-container');
						var fields = [];

						if (fieldsContainer) {
							fields = instance._parseFieldContainer(fieldsContainer, FIELD_LABEL_TPL);
						}

						instance.set('availableFields', availableFields);
						instance.set('fields', fields);
					},

					exportAsJSON: function() {
						var instance = this;

						var fields = {
							fields: []
						};

						instance.get('fields').each(
							function(item) {
								var field = {
									data: [],
									id: item.get('fieldId'),
									type: item.get('type')
								};

								var contentBox = item.get('contentBox');

								contentBox.all('input, select, textarea').each(
									function(input) {
										if (input.attr('type') !== 'radio' || input.attr('checked')) {
											field.data.push(
												{
													name: input.attr('name'),
													value: input.val()
												}
											);
										}
									}
								);

								fields.fields.push(field);
							}
						);

						return JSON.stringify(fields);
					},

					simulateFocusField: function(field, target) {
						var instance = this;

						var lastFocusedField = instance.lastFocusedField;

						if (lastFocusedField) {
							lastFocusedField.blur();
						}

						instance.lastFocusedField = field.focus();

						if (target) {
							target.focus();
						}
					}
				}
			}
		);

		LiferayCTFormBuilder.registerField = function(field) {
			var fieldName = 'ct-' + field.key + '-field-field';

			var ctFormField = A.Component.create(
				{
					ATTRS: {
						acceptChildren: {
							readOnly: true,
							value: false
						},

						fieldId: {
							readOnly: true,
							value: field.id || A.guid()
						}
					},

					EXTENDS: A.FormBuilderField,

					NAME: fieldName,

					prototype: {
						getHTML: function() {
							var instance = this;

							var fieldId = instance.get('fieldId');

							return A.Lang.sub(
								ITEM_FIELD_TPL,
								{
									description: field.description,
									editor: field.editor.replace(/\{ct_field_guid\}/g, fieldId),
									icon: field.icon,
									name: field.name
								}
							);
						},

						getNode: function() {
							var instance = this;

							var templateContainer = A.Node.create('<div></div>');

							templateContainer.plug(A.Plugin.ParseContent);
							templateContainer.setContent(instance.getHTML());

							return templateContainer;
						}
					}
				}
			);

			A['CT' + field.key + 'ItemField'] = ctFormField;

			if (!A.FormBuilder.types[field.key]) {
				A.FormBuilder.types[field.key] = ctFormField;
			}
		};

		A.LiferayCTFormBuilder = LiferayCTFormBuilder;
	},
	'',
	{
		requires: ['aui-form-builder', 'aui-parse-content', 'aui-toggler', 'autocomplete-base', 'autocomplete-filters']
	}
);