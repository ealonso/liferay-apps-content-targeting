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

package com.liferay.content.targeting.portlet;

import com.liferay.content.targeting.portlet.util.QueryRule;
import com.liferay.content.targeting.portlet.util.TestQueryRule;
import com.liferay.content.targeting.portlet.util.TestQueryRuleUtil;
import com.liferay.content.targeting.util.WebKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetRendererFactory;

import freemarker.ext.beans.BeansWrapper;

import freemarker.template.TemplateHashModel;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * @author Eudaldo Alonso
 */
public class ABTestingPortlet extends CTFreeMarkerDisplayPortlet {

	public void updatePreferences(
			ActionRequest request, ActionResponse response)
		throws Exception {

		PortletPreferences portletPreferences = request.getPreferences();

		super.updatePreferences(request, response, portletPreferences);
	}

	@Override
	protected void doPopulateContext(
			String path, PortletRequest portletRequest,
			PortletResponse portletResponse, Template template)
		throws Exception {

		BeansWrapper wrapper = BeansWrapper.getDefaultInstance();

		TemplateHashModel staticModels = wrapper.getStaticModels();

		template.put("currentURL", PortalUtil.getCurrentURL(portletRequest));
		template.put(
			"redirect", ParamUtil.getString(portletRequest, "redirect"));

		populateViewContext(
			path, portletRequest, portletResponse, template, staticModels);
	}

	protected List<AssetRendererFactory> getSelectableAssetRendererFactories(
		long companyId) {

		List<AssetRendererFactory> selectableAssetRendererFactories =
			new ArrayList<AssetRendererFactory>();

		List<AssetRendererFactory> assetRendererFactories =
			AssetRendererFactoryRegistryUtil.getAssetRendererFactories(
				companyId);

		for (AssetRendererFactory rendererFactory : assetRendererFactories) {
			if (!rendererFactory.isSelectable()) {
				continue;
			}

			selectableAssetRendererFactories.add(rendererFactory);
		}

		return selectableAssetRendererFactories;
	}

	protected void populateViewContext(
			String path, PortletRequest portletRequest,
			PortletResponse portletResponse, Template template,
			TemplateHashModel staticModels)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		PortletPreferences portletPreferences = portletRequest.getPreferences();

		populatePortletDisplayTemplateContext(
			template, portletPreferences, themeDisplay.getScopeGroupId(),
			"full-content");

		if (Validator.isNull(path) ||
			path.equals(CampaignContentDisplayPath.VIEW)) {

			template.put(
				"isNotConfigured", portletPreferences.getMap().isEmpty());

			template.put("showPreview", showPreview(themeDisplay));

			List<QueryRule> testQueryRules =
				TestQueryRuleUtil.getTestQueryRules(
					portletPreferences, themeDisplay.getLocale(), false);

			template.put("testQueryRules", testQueryRules);

			QueryRule queryRule = TestQueryRuleUtil.match(testQueryRules);

			template.put("queryRule", queryRule);

			template.put("selectedIndex", testQueryRules.indexOf(queryRule));

			List<AssetEntry> results = new ArrayList<AssetEntry>();

			if ((queryRule != null) && (queryRule.getAssetEntry() != null)) {
				results.add(queryRule.getAssetEntry());

				queryRule.setAssetAttributes(portletRequest);
			}
			else {
				portletRequest.setAttribute(
					WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
			}

			template.put("liferayWindowStatePopUp", LiferayWindowState.POP_UP);

			populatePortletDisplayTemplateViewContext(
				template, portletRequest, themeDisplay, results,
				testQueryRules);
		}
		else if (path.equals(CampaignContentDisplayPath.EDIT_QUERY_RULE) ||
				 path.equals(CampaignContentDisplayPath.CONFIGURATION)) {

			template.put(
				"assetRendererFactories",
				getSelectableAssetRendererFactories(
					themeDisplay.getCompanyId()));

			List<QueryRule> testQueryRules =
				TestQueryRuleUtil.getTestQueryRules(
					portletPreferences, themeDisplay.getLocale(), true);

			template.put("testQueryRules", testQueryRules);

			TestQueryRule testQueryRule =
				(TestQueryRule)portletRequest.getAttribute(
					"configuration.queryRule");

			if (testQueryRule == null) {
				testQueryRule = new TestQueryRule();
			}

			template.put("queryRule", testQueryRule);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ABTestingPortlet.class);

}