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

package com.liferay.content.targeting.rule.customfield;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.api.model.BaseRule;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.rule.categories.UserAttributesRuleCategory;
import com.liferay.content.targeting.util.ContentTargetingContextUtil;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portlet.expando.model.CustomAttributesDisplay;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Eudaldo Alonso
 */
@Component(immediate = true, service = Rule.class)
public class CustomFieldRule extends BaseRule {

	@Activate
	@Override
	public void activate() {
		super.activate();
	}

	@Deactivate
	@Override
	public void deActivate() {
		super.deActivate();
	}

	@Override
	public boolean evaluate(
			HttpServletRequest request, RuleInstance ruleInstance,
			AnonymousUser anonymousUser)
		throws Exception {

		return false;
	}

	@Override
	public String getIcon() {
		return "icon-puzzle";
	}

	@Override
	public String getRuleCategoryKey() {
		return UserAttributesRuleCategory.KEY;
	}

	@Override
	public String getSummary(RuleInstance ruleInstance, Locale locale) {
		return StringPool.BLANK;
	}

	@Override
	public String processRule(
			PortletRequest request, PortletResponse response, String id,
			Map<String, String> values) {

		return StringPool.BLANK;
	}

	@Override
	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context,
		Map<String, String> values) {

		String modelResource = StringPool.BLANK;

		if (!values.isEmpty()) {
			modelResource = GetterUtil.getString(values.get("modelResource"));
		}
		else if (ruleInstance != null) {
			String typeSettings = ruleInstance.getTypeSettings();

			try {
				JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
					typeSettings);

				modelResource = jsonObj.getString("modelResource");
			}
			catch (JSONException jse) {
			}
		}

		context.put("modelResource", modelResource);

		Company company = (Company)context.get("company");

		Locale locale = (Locale)context.get("locale");

		List<CustomAttributeItem> modelResources =
			new ArrayList<CustomAttributeItem>();

		List<CustomAttributesDisplay> customAttributesDisplays =
			PortletLocalServiceUtil.getCustomAttributesDisplays();

		for (CustomAttributesDisplay customAttributesDisplay :
				customAttributesDisplays) {

			String className = customAttributesDisplay.getClassName();
			String displayName = ResourceActionsUtil.getModelResource(
				locale, customAttributesDisplay.getClassName());

			ExpandoBridge expandoBridge =
				ExpandoBridgeFactoryUtil.getExpandoBridge(
					company.getCompanyId(),
					customAttributesDisplay.getClassName());

			List<String> attributeNames = Collections.list(
				expandoBridge.getAttributeNames());

			CustomAttributeItem customAttributeItem = new CustomAttributeItem(
				attributeNames, className, displayName);

			modelResources.add(customAttributeItem);
		}

		context.put("modelResources", modelResources);
	}

}