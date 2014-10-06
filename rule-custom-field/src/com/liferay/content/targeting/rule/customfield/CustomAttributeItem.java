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

import java.util.List;

/**
 * @author Eudaldo Alonso
 */
public class CustomAttributeItem {

	public CustomAttributeItem(
		List<String> attributeNames, String modelResource, String displayName) {

		_attributeNames = attributeNames;
		_modelResource = modelResource;
		_displayName = displayName;
	}

	public List<String> getAttributeNames() {
		return _attributeNames;
	}

	public String getModelResource() {
		return _modelResource;
	}

	public String getDisplayName() {
		return _displayName;
	}

	private List<String> _attributeNames;
	private String _modelResource;
	private String _displayName;

}