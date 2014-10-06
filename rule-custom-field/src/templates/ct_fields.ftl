<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<#setting number_format="computer">

<@aui["select"] inlineField=true label="custom-field" name="modelResource">
	<#list modelResources as curModelResource>
		<@aui["option"] label="${curModelResource.getDisplayName()}" selected=(modelResource = curModelResource.getModelResource()) value="${curModelResource.getModelResource()}" />
	</#list>
</@>

<#list modelResources as curModelResource>
	<#assign attributeNames = curModelResource.getAttributeNames() />

	<#if attributeNames?has_content>
		<@aui["select"] cssClass="atributte-names hide" inlineField=true label="attribute-names" name="attributeName_${curModelResource.getModelResource()}">
			<#list attributeNames as attributeName>
				<@aui["option"] label="${attributeName}" value="${attributeName}" />
			</#list>
		</@>
	</#if>
</#list>

<@aui["script"]>
	A.one('#<@portlet["namespace"] />modelResource').on(
		'change',
		function(event) {
			var currentTarget = event.currentTarget;

			var modelResource = '';

			A.all('.atributte-names').hide();

			A.one('#<@portlet["namespace"] />attributeName_' + modelResource).show();
		}
	);
</@>