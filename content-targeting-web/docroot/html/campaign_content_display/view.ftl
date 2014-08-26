<#--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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
-->

<#include "../init.ftl" />
<#include "../macros.ftl" />

<#if isMatchingRule>
	<div class="content-container">
		<div class="full-content" id="<@portlet["namespace"] />FullContent${selectedIndex}">
			<@renderAssetEntry />

			<@aui["script"] position="inline">
				Liferay.Analytics.track('view', {
					className: '${assetEntryClassName}',
					classPK: '${assetEntryClassPK}',
					groupId: '${groupId}',
					referrerClassName: '${campaignClassName}',
					referrerClassPK: '${campaignClassPK}'
				});
			</@>
		</div>

		<#if portletDisplay.isShowConfigurationIcon()>
			<@renderThumbnailsPreview queryRules=campaignQueryRules selectedIndex=selectedIndex />
		</#if>
	</div>
<#else>
	<div class="alert alert-info">
		<@liferay_ui["message"] key="there-are-no-matching-rules" />
	</div>
</#if>

<#if portletDisplay.isShowConfigurationIcon()>
	<div class="icons-container lfr-meta-actions">
		<div class="lfr-icon-actions">
			<@getConfigurationIconLink mvcPath=campaignContentDisplayPath.CONFIGURATION />

			<@getEditIconLinks queryRules=campaignQueryRules />
		</div>
	</div>
</#if>