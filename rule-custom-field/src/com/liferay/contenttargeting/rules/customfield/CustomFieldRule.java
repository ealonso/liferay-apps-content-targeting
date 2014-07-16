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

package com.liferay.contenttargeting.rules.customfield;

import com.liferay.anonymoususers.model.AnonymousUser;
import com.liferay.contenttargeting.api.model.BaseRule;
import com.liferay.contenttargeting.api.model.Rule;
import com.liferay.contenttargeting.model.RuleInstance;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eudaldo Alonso
 */
@Component(immediate = true, service = Rule.class)
public class CustomFieldRule extends BaseRule {

	@Override
	public boolean evaluate(
			HttpServletRequest request, RuleInstance ruleInstance,
			AnonymousUser anonymousUser)
		throws Exception {

		String attributeName = StringPool.BLANK;
		String value = StringPool.BLANK;

		try {
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
				ruleInstance.getTypeSettings());

			attributeName = jsonObj.getString("attributeName");
			value = jsonObj.getString("value");
		}
		catch (JSONException jse) {
		}

		if (Validator.isNull(attributeName)) {
			return false;
		}

		ExpandoBridge expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(
			anonymousUser.getCompanyId(), User.class.getName(),
			anonymousUser.getUserId());

		if (expandoBridge == null) {
			return false;
		}

		Serializable attributeValue = expandoBridge.getAttribute(attributeName);

		if (Validator.isNotNull(attributeValue) &&
			attributeValue.equals(value)) {

			return true;
		}

		return false;
	}

	@Override
	public String getIcon() {
		return "icon-puzzle";
	}

	@Override
	public String getSummary(RuleInstance ruleInstance, Locale locale) {
		String typeSettings = ruleInstance.getTypeSettings();

		try {
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject(typeSettings);

			return jsonObj.getString("attributeName");
		}
		catch (JSONException jse) {
		}

		return StringPool.BLANK;
	}

	@Override
	public String processRule(
		PortletRequest request, PortletResponse response, String id,
		Map<String, String> values) {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);

		String attributeName = values.get("attributeName");

		ExpandoBridge expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(
			themeDisplay.getCompanyId(), User.class.getName());

		Serializable value = StringPool.BLANK;

		try {
			Map<String, Serializable> attributes =
				PortalUtil.getExpandoBridgeAttributes(expandoBridge, request);

			value = attributes.get(attributeName);
		}
		catch (Exception e) {
		}

		ExpandoColumnLocalServiceUtil.addColumn()

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("attributeName", attributeName);
		jsonObj.put("value", value.toString());

		return jsonObj.toString();
	}

	@Override
	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context) {

		Company company = (Company)context.get("company");

		ExpandoBridge expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(
			company.getCompanyId(), User.class.getName());

		List<String> attributeNames = Collections.list(
			expandoBridge.getAttributeNames());

		context.put("attributeNames", attributeNames);

		String selectedAttributeName = StringPool.BLANK;

		if (ruleInstance != null) {
			String typeSettings = ruleInstance.getTypeSettings();

			try {
				JSONObject jsonObj = JSONFactoryUtil.createJSONObject(
					typeSettings);

				selectedAttributeName = jsonObj.getString("attributeName");
			}
			catch (JSONException jse) {
			}
		}

		if (Validator.isNull(selectedAttributeName) &&
			!attributeNames.isEmpty()) {

			selectedAttributeName = attributeNames.get(0);
		}

		context.put("selectedAttributeName", selectedAttributeName);
	}

}