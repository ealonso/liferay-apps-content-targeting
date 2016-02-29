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

import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;

import javax.portlet.PortletResponse;

/**
 * @author Pavel Savinov
 */
public class ReportInstanceRowChecker extends EmptyOnClickRowChecker {

	public ReportInstanceRowChecker(PortletResponse response) {
		super(response);
	}

	@Override
	public boolean isDisabled(Object obj) {
		if (obj instanceof ReportInstance) {
			ReportInstance reportInstance = (ReportInstance)obj;

			return !reportInstance.isInstantiable();
		}

		return super.isDisabled(obj);
	}

}