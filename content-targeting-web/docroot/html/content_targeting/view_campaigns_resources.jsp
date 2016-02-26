<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/html/init.jsp" %>

<%
int channelsCount = GetterUtil.getInteger(request.getAttribute("channelsCount"));

int reportsCount = GetterUtil.getInteger(request.getAttribute("reportsCount"));

String campaignKeywords = ParamUtil.getString(request, "campaignKeywords");

RowChecker campaignsRowChecker = new RowChecker(liferayPortletResponse);

SearchContainerIterator searchContainerIterator = new CampaignSearchContainerIterator(scopeGroupId, campaignKeywords);
%>

<liferay-portlet:renderURL varImpl="viewCampaignsURL">
	<portlet:param name="mvcPath" value="<%= ContentTargetingPath.VIEW %>" />
	<portlet:param name="tabs1" value="campaigns" />
</liferay-portlet:renderURL>

<liferay-ui:search-container
	emptyResultsMessage="no-campaigns-were-found"
	iteratorURL="<%= viewCampaignsURL %>"
	rowChecker="<%= campaignsRowChecker %>"
	total="<%= searchContainerIterator.getTotal() %>"
>
	<liferay-ui:search-container-results
		results="<%= searchContainerIterator.getResults(searchContainer.getStart(), searchContainer.getEnd()) %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.content.targeting.model.Campaign"
		keyProperty="campaignId"
		modelVar="campaign"
	>

		<%
		String editCampaignURL = null;
		%>

		<c:if test="<%= CampaignPermission.contains(permissionChecker, campaign, ActionKeys.UPDATE) %>">

			<%
			PortletURL editCampaignURLObject = liferayPortletResponse.createRenderURL();
			editCampaignURLObject.setParameter("mvcRenderCommandName", ContentTargetingMVCCommand.EDIT_CAMPAIGN);
			editCampaignURLObject.setParameter("redirect", viewCampaignsURL.toString());
			editCampaignURLObject.setParameter("campaignId", String.valueOf(campaign.getCampaignId()));
			editCampaignURLObject.setParameter("className", Campaign.class.getName());
			editCampaignURLObject.setParameter("classPK", String.valueOf(campaign.getCampaignId()));

			editCampaignURL = editCampaignURLObject.toString();
			%>

		</c:if>

		<liferay-ui:search-container-column-text
			href="<%= editCampaignURL %>"
			name="name"
			value="<%= campaign.getName(locale) %>"
		/>

		<liferay-ui:search-container-column-text
			href="<%= editCampaignURL %>"
			name="description"
			value="<%= campaign.getDescription(locale) %>"
		/>

		<liferay-ui:search-container-column-date
			name="start-date"
			value="<%= campaign.getStartDate() %>"
		/>

		<liferay-ui:search-container-column-date
			name="end-date"
			value="<%= campaign.getEndDate() %>"
		/>

		<liferay-ui:search-container-column-text
			name="priority"
			value="<%= String.valueOf(campaign.getPriority()) %>"
		/>

		<liferay-ui:search-container-column-text
			name="status"
		>
			<span class="label <%= CampaignConstants.getStatusCssClass(campaign.getStatus()) %>">
				<liferay-ui:message key="<%= campaign.getStatus() %>" />
			</span>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text
			align="right"
			name=""
		>
			<liferay-ui:icon-menu>
				<c:if test="<%= editCampaignURL != null %>">
					<liferay-ui:icon
						image="edit"
						method="get"
						url="<%= editCampaignURL %>"
					/>

					<c:if test="<%= reportsCount > 0 %>">
						<liferay-portlet:renderURL var="viewCampaignReportsURL">
							<portlet:param
								name="mvcRenderCommandName"
								value="<%= ContentTargetingMVCCommand.EDIT_CAMPAIGN %>"
							/>
							<portlet:param
								name="redirect"
								value="<%= viewCampaignsURL.toString() %>"
							/>
							<portlet:param
								name="campaignId"
								value="<%= String.valueOf(campaign.getCampaignId()) %>"
							/>
							<portlet:param
								name="className"
								value="<%= Campaign.class.getName() %>"
							/>
							<portlet:param
								name="classPK"
								value="<%= String.valueOf(campaign.getCampaignId()) %>"
							/>
							<portlet:param
								name="tabs2"
								value="reports"
							/>
						</liferay-portlet:renderURL>

						<liferay-ui:icon
							image="view"
							label="<%= true %>"
							message="reports"
							method="get"
							url="<%= viewCampaignReportsURL %>"
						/>
					</c:if>

					<c:if test="<%= channelsCount > 0 %>">
						<liferay-portlet:renderURL var="viewCampaignTacticsURL">
							<portlet:param
								name="mvcRenderCommandName"
								value="<%= ContentTargetingMVCCommand.EDIT_CAMPAIGN %>"
							/>
							<portlet:param
								name="redirect"
								value="<%= viewCampaignsURL.toString() %>"
							/>
							<portlet:param
								name="className"
								value="<%= Campaign.class.getName() %>"
							/>
							<portlet:param
								name="classPK"
								value="<%= String.valueOf(campaign.getCampaignId()) %>"
							/>
							<portlet:param
								name="campaignId"
								value="<%= String.valueOf(campaign.getCampaignId()) %>"
							/>
							<portlet:param
								name="tabs2"
								value="promotions"
							/>
						</liferay-portlet:renderURL>

						<liferay-ui:icon
							image="sitemap"
							label="<%= true %>"
							message="promotions"
							method="get"
							url="<%= viewCampaignTacticsURL %>"
						/>
					</c:if>
				</c:if>

				<c:if test="<%= CampaignPermission.contains(permissionChecker, campaign, ActionKeys.DELETE) %>">
					<liferay-portlet:actionURL name="deleteCampaign" var="deleteCampaignURL">
						<portlet:param
							name="redirect"
							value="<%= viewCampaignsURL.toString() %>"
						/>
						<portlet:param
							name="campaignId"
							value="<%= String.valueOf(campaign.getCampaignId()) %>"
						/>
					</liferay-portlet:actionURL>

					<liferay-ui:icon-delete
						url="<%= deleteCampaignURL %>"
					/>
				</c:if>

				<c:if test="<%= CampaignPermission.contains(permissionChecker, campaign, ActionKeys.PERMISSIONS) %>">
					<liferay-security:permissionsURL
						modelResource="<%= Campaign.class.getName() %>"
						modelResourceDescription="<%= campaign.getName(locale) %>"
						resourcePrimKey="<%= String.valueOf(campaign.getCampaignId()) %>"
						var="permissionsEntryURL"
						windowState="<%= LiferayWindowState.POP_UP.toString() %>"
					/>

					<liferay-ui:icon
						image="permissions"
						method="get"
						url="<%= permissionsEntryURL %>"
						useDialog="<%= true %>"
					/>
				</c:if>
			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<aui:script use="liferay-util-list-fields">
	var deleteCampaigns = A.one('#<portlet:namespace />deleteCampaigns');

	if (deleteCampaigns) {
		A.one('#<portlet:namespace /><%= searchContainerReference.getId(request) %>SearchContainer').on(
			'click',
			function() {
				var hide = (Liferay.Util.listCheckedExcept(document.<portlet:namespace />fmCampaigns, '<portlet:namespace />allRowIds').length == 0);

				deleteCampaigns.toggle(!hide);
			},
			'input[type=checkbox]'
		);

		deleteCampaigns.on(
			'click',
			function(event) {
				if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this" />')) {
					document.<portlet:namespace />fmCampaigns.<portlet:namespace />campaignsIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fmCampaigns, '<portlet:namespace />allRowIds');

					<liferay-portlet:renderURL var="redirectURL">
						<portlet:param
							name="mvcPath"
							value="<%= ContentTargetingPath.VIEW %>"
						/>
						<portlet:param
							name="tabs1"
							value="campaigns"
						/>
					</liferay-portlet:renderURL>

					<liferay-portlet:actionURL name="deleteCampaign" var="deleteCampaignsURL">
						<portlet:param
							name="redirect"
							value="<%= redirectURL %>"
						/>
					</liferay-portlet:actionURL>

					submitForm(document.<portlet:namespace />fmCampaigns, '<%= deleteCampaignsURL %>');
				}
			}
		);
	}
</aui:script>