<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />
<#assign portlet = PortletJspTagLibs["/META-INF/liferay-portlet.tld"] />

<@aui["select"] label="" name="attributeName">
	<#list attributeNames as attributeName>
		<@aui["option"] label="${attributeName}" selected=(attributeName == selectedAttributeName) value="${attributeName}" />
	</#list>
</@>

<#list attributeNames as attributeName>
	<div id="${attributeName_index}customFieldId" class="custom-field <#if attributeName != selectedAttributeName>hide</#if>">
		<@liferay_ui["custom-attribute"]
			className="com.liferay.portal.model.User"
			classPK=0
			editable=true
			label=false
			name="${attributeName}"
		/>
	</div>
</#list>

<@aui["script"] use="aui-base">
	A.one('#<@portlet["namespace"] />attributeName').on(
		'change',
		function(event) {
			A.all('.custom-field').hide();

			var selectedIndex = event.currentTarget.get('selectedIndex');

			A.one('#' + selectedIndex + 'customFieldId').show();
		}
	);
</@>