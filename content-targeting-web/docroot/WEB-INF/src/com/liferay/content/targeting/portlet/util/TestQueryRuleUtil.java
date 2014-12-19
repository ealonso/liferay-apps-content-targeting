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

package com.liferay.content.targeting.portlet.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletPreferences;

/**
 * @author Eudaldo Alonso
 */
public class TestQueryRuleUtil {

	public static QueryRule getQueryRule(
			PortletPreferences portletPreferences, int queryRulesIndex,
			Locale locale)
		throws PortalException, SystemException {

		long assetEntryId = GetterUtil.getLong(
			portletPreferences.getValue(
				"assetEntryId" + queryRulesIndex, null));

		return new TestQueryRule(assetEntryId, queryRulesIndex, locale);
	}

	public static List<QueryRule> getTestQueryRules(
			PortletPreferences portletPreferences, Locale locale,
			boolean includeEmptyQueryRules)
		throws PortalException, SystemException {

		List<QueryRule> testQueryRules = new ArrayList<QueryRule>();

		int[] queryRulesIndexes = GetterUtil.getIntegerValues(
			portletPreferences.getValues("queryLogicIndexes", null),
			new int[0]);

		for (int queryRulesIndex : queryRulesIndexes) {
			QueryRule campaignQueryRule = getQueryRule(
				portletPreferences, queryRulesIndex, locale);

				testQueryRules.add(campaignQueryRule);
		}

		if (testQueryRules.isEmpty() && includeEmptyQueryRules) {
			testQueryRules.add(new CampaignQueryRule());
			testQueryRules.add(new CampaignQueryRule());
			testQueryRules.add(new CampaignQueryRule());
		}

		Collections.sort(testQueryRules);

		return testQueryRules;
	}

	public static QueryRule match(List<QueryRule> queryRules)
		throws PortalException, SystemException {

		// TODO: random?

		return null;
	}

}