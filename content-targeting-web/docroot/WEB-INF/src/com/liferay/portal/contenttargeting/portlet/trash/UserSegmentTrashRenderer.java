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

package com.liferay.portal.contenttargeting.portlet.trash;

import com.liferay.portal.contenttargeting.model.UserSegment;
import com.liferay.portal.kernel.trash.BaseTrashRenderer;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.wiki.model.WikiNode;

import java.util.Locale;

/**
 * @author Eudaldo Alonso
 */
public class UserSegmentTrashRenderer extends BaseTrashRenderer {

	public static final String TYPE = "user_segment";

	public UserSegmentTrashRenderer(UserSegment userSegment) {
		_userSegment = userSegment;
	}

	@Override
	public String getClassName() {
		return WikiNode.class.getName();
	}

	@Override
	public long getClassPK() {
		return _userSegment.getUserSegmentId();
	}

	@Override
	public String getIconPath(ThemeDisplay themeDisplay) {
		return themeDisplay.getPathThemeImages() + "/common/icon_user.png";
	}

	@Override
	public String getPortletId() {
		return null;
	}

	@Override
	public String getSummary(Locale locale) {
		return _userSegment.getDescription(locale);
	}

	@Override
	public String getTitle(Locale locale) {
		return _userSegment.getName(locale);
	}

	@Override
	public String getType() {
		return TYPE;
	}

	private UserSegment _userSegment;

}