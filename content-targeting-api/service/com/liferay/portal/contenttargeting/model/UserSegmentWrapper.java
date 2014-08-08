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

package com.liferay.portal.contenttargeting.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserSegment}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserSegment
 * @generated
 */
public class UserSegmentWrapper implements UserSegment,
	ModelWrapper<UserSegment> {
	public UserSegmentWrapper(UserSegment userSegment) {
		_userSegment = userSegment;
	}

	@Override
	public Class<?> getModelClass() {
		return UserSegment.class;
	}

	@Override
	public String getModelClassName() {
		return UserSegment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("userSegmentId", getUserSegmentId());
		attributes.put("groupId", getGroupId());
		attributes.put("assetCategoryId", getAssetCategoryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long userSegmentId = (Long)attributes.get("userSegmentId");

		if (userSegmentId != null) {
			setUserSegmentId(userSegmentId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long assetCategoryId = (Long)attributes.get("assetCategoryId");

		if (assetCategoryId != null) {
			setAssetCategoryId(assetCategoryId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	/**
	* Returns the primary key of this user segment.
	*
	* @return the primary key of this user segment
	*/
	@Override
	public long getPrimaryKey() {
		return _userSegment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user segment.
	*
	* @param primaryKey the primary key of this user segment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userSegment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this user segment.
	*
	* @return the uuid of this user segment
	*/
	@Override
	public java.lang.String getUuid() {
		return _userSegment.getUuid();
	}

	/**
	* Sets the uuid of this user segment.
	*
	* @param uuid the uuid of this user segment
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_userSegment.setUuid(uuid);
	}

	/**
	* Returns the user segment ID of this user segment.
	*
	* @return the user segment ID of this user segment
	*/
	@Override
	public long getUserSegmentId() {
		return _userSegment.getUserSegmentId();
	}

	/**
	* Sets the user segment ID of this user segment.
	*
	* @param userSegmentId the user segment ID of this user segment
	*/
	@Override
	public void setUserSegmentId(long userSegmentId) {
		_userSegment.setUserSegmentId(userSegmentId);
	}

	/**
	* Returns the group ID of this user segment.
	*
	* @return the group ID of this user segment
	*/
	@Override
	public long getGroupId() {
		return _userSegment.getGroupId();
	}

	/**
	* Sets the group ID of this user segment.
	*
	* @param groupId the group ID of this user segment
	*/
	@Override
	public void setGroupId(long groupId) {
		_userSegment.setGroupId(groupId);
	}

	/**
	* Returns the asset category ID of this user segment.
	*
	* @return the asset category ID of this user segment
	*/
	@Override
	public long getAssetCategoryId() {
		return _userSegment.getAssetCategoryId();
	}

	/**
	* Sets the asset category ID of this user segment.
	*
	* @param assetCategoryId the asset category ID of this user segment
	*/
	@Override
	public void setAssetCategoryId(long assetCategoryId) {
		_userSegment.setAssetCategoryId(assetCategoryId);
	}

	/**
	* Returns the company ID of this user segment.
	*
	* @return the company ID of this user segment
	*/
	@Override
	public long getCompanyId() {
		return _userSegment.getCompanyId();
	}

	/**
	* Sets the company ID of this user segment.
	*
	* @param companyId the company ID of this user segment
	*/
	@Override
	public void setCompanyId(long companyId) {
		_userSegment.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this user segment.
	*
	* @return the user ID of this user segment
	*/
	@Override
	public long getUserId() {
		return _userSegment.getUserId();
	}

	/**
	* Sets the user ID of this user segment.
	*
	* @param userId the user ID of this user segment
	*/
	@Override
	public void setUserId(long userId) {
		_userSegment.setUserId(userId);
	}

	/**
	* Returns the user uuid of this user segment.
	*
	* @return the user uuid of this user segment
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSegment.getUserUuid();
	}

	/**
	* Sets the user uuid of this user segment.
	*
	* @param userUuid the user uuid of this user segment
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_userSegment.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this user segment.
	*
	* @return the user name of this user segment
	*/
	@Override
	public java.lang.String getUserName() {
		return _userSegment.getUserName();
	}

	/**
	* Sets the user name of this user segment.
	*
	* @param userName the user name of this user segment
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_userSegment.setUserName(userName);
	}

	/**
	* Returns the create date of this user segment.
	*
	* @return the create date of this user segment
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _userSegment.getCreateDate();
	}

	/**
	* Sets the create date of this user segment.
	*
	* @param createDate the create date of this user segment
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_userSegment.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this user segment.
	*
	* @return the modified date of this user segment
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _userSegment.getModifiedDate();
	}

	/**
	* Sets the modified date of this user segment.
	*
	* @param modifiedDate the modified date of this user segment
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_userSegment.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this user segment.
	*
	* @return the name of this user segment
	*/
	@Override
	public java.lang.String getName() {
		return _userSegment.getName();
	}

	/**
	* Returns the localized name of this user segment in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized name of this user segment
	*/
	@Override
	public java.lang.String getName(java.util.Locale locale) {
		return _userSegment.getName(locale);
	}

	/**
	* Returns the localized name of this user segment in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this user segment. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getName(java.util.Locale locale, boolean useDefault) {
		return _userSegment.getName(locale, useDefault);
	}

	/**
	* Returns the localized name of this user segment in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized name of this user segment
	*/
	@Override
	public java.lang.String getName(java.lang.String languageId) {
		return _userSegment.getName(languageId);
	}

	/**
	* Returns the localized name of this user segment in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this user segment
	*/
	@Override
	public java.lang.String getName(java.lang.String languageId,
		boolean useDefault) {
		return _userSegment.getName(languageId, useDefault);
	}

	@Override
	public java.lang.String getNameCurrentLanguageId() {
		return _userSegment.getNameCurrentLanguageId();
	}

	@Override
	public java.lang.String getNameCurrentValue() {
		return _userSegment.getNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized names of this user segment.
	*
	* @return the locales and localized names of this user segment
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getNameMap() {
		return _userSegment.getNameMap();
	}

	/**
	* Sets the name of this user segment.
	*
	* @param name the name of this user segment
	*/
	@Override
	public void setName(java.lang.String name) {
		_userSegment.setName(name);
	}

	/**
	* Sets the localized name of this user segment in the language.
	*
	* @param name the localized name of this user segment
	* @param locale the locale of the language
	*/
	@Override
	public void setName(java.lang.String name, java.util.Locale locale) {
		_userSegment.setName(name, locale);
	}

	/**
	* Sets the localized name of this user segment in the language, and sets the default locale.
	*
	* @param name the localized name of this user segment
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setName(java.lang.String name, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_userSegment.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(java.lang.String languageId) {
		_userSegment.setNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized names of this user segment from the map of locales and localized names.
	*
	* @param nameMap the locales and localized names of this user segment
	*/
	@Override
	public void setNameMap(
		java.util.Map<java.util.Locale, java.lang.String> nameMap) {
		_userSegment.setNameMap(nameMap);
	}

	/**
	* Sets the localized names of this user segment from the map of locales and localized names, and sets the default locale.
	*
	* @param nameMap the locales and localized names of this user segment
	* @param defaultLocale the default locale
	*/
	@Override
	public void setNameMap(
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Locale defaultLocale) {
		_userSegment.setNameMap(nameMap, defaultLocale);
	}

	/**
	* Returns the description of this user segment.
	*
	* @return the description of this user segment
	*/
	@Override
	public java.lang.String getDescription() {
		return _userSegment.getDescription();
	}

	/**
	* Returns the localized description of this user segment in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized description of this user segment
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale) {
		return _userSegment.getDescription(locale);
	}

	/**
	* Returns the localized description of this user segment in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this user segment. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale,
		boolean useDefault) {
		return _userSegment.getDescription(locale, useDefault);
	}

	/**
	* Returns the localized description of this user segment in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized description of this user segment
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId) {
		return _userSegment.getDescription(languageId);
	}

	/**
	* Returns the localized description of this user segment in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this user segment
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId,
		boolean useDefault) {
		return _userSegment.getDescription(languageId, useDefault);
	}

	@Override
	public java.lang.String getDescriptionCurrentLanguageId() {
		return _userSegment.getDescriptionCurrentLanguageId();
	}

	@Override
	public java.lang.String getDescriptionCurrentValue() {
		return _userSegment.getDescriptionCurrentValue();
	}

	/**
	* Returns a map of the locales and localized descriptions of this user segment.
	*
	* @return the locales and localized descriptions of this user segment
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getDescriptionMap() {
		return _userSegment.getDescriptionMap();
	}

	/**
	* Sets the description of this user segment.
	*
	* @param description the description of this user segment
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_userSegment.setDescription(description);
	}

	/**
	* Sets the localized description of this user segment in the language.
	*
	* @param description the localized description of this user segment
	* @param locale the locale of the language
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale) {
		_userSegment.setDescription(description, locale);
	}

	/**
	* Sets the localized description of this user segment in the language, and sets the default locale.
	*
	* @param description the localized description of this user segment
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_userSegment.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(java.lang.String languageId) {
		_userSegment.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized descriptions of this user segment from the map of locales and localized descriptions.
	*
	* @param descriptionMap the locales and localized descriptions of this user segment
	*/
	@Override
	public void setDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap) {
		_userSegment.setDescriptionMap(descriptionMap);
	}

	/**
	* Sets the localized descriptions of this user segment from the map of locales and localized descriptions, and sets the default locale.
	*
	* @param descriptionMap the locales and localized descriptions of this user segment
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Locale defaultLocale) {
		_userSegment.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	* Returns the status of this user segment.
	*
	* @return the status of this user segment
	*/
	@Override
	public int getStatus() {
		return _userSegment.getStatus();
	}

	/**
	* Sets the status of this user segment.
	*
	* @param status the status of this user segment
	*/
	@Override
	public void setStatus(int status) {
		_userSegment.setStatus(status);
	}

	/**
	* Returns the status by user ID of this user segment.
	*
	* @return the status by user ID of this user segment
	*/
	@Override
	public long getStatusByUserId() {
		return _userSegment.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this user segment.
	*
	* @param statusByUserId the status by user ID of this user segment
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_userSegment.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this user segment.
	*
	* @return the status by user uuid of this user segment
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSegment.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this user segment.
	*
	* @param statusByUserUuid the status by user uuid of this user segment
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_userSegment.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status by user name of this user segment.
	*
	* @return the status by user name of this user segment
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _userSegment.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this user segment.
	*
	* @param statusByUserName the status by user name of this user segment
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_userSegment.setStatusByUserName(statusByUserName);
	}

	/**
	* Returns the status date of this user segment.
	*
	* @return the status date of this user segment
	*/
	@Override
	public java.util.Date getStatusDate() {
		return _userSegment.getStatusDate();
	}

	/**
	* Sets the status date of this user segment.
	*
	* @param statusDate the status date of this user segment
	*/
	@Override
	public void setStatusDate(java.util.Date statusDate) {
		_userSegment.setStatusDate(statusDate);
	}

	/**
	* Returns the trash entry created when this user segment was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this user segment.
	*
	* @return the trash entry created when this user segment was moved to the Recycle Bin
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.portlet.trash.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userSegment.getTrashEntry();
	}

	/**
	* Returns the class primary key of the trash entry for this user segment.
	*
	* @return the class primary key of the trash entry for this user segment
	*/
	@Override
	public long getTrashEntryClassPK() {
		return _userSegment.getTrashEntryClassPK();
	}

	/**
	* Returns the trash handler for this user segment.
	*
	* @return the trash handler for this user segment
	*/
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return _userSegment.getTrashHandler();
	}

	/**
	* Returns <code>true</code> if this user segment is in the Recycle Bin.
	*
	* @return <code>true</code> if this user segment is in the Recycle Bin; <code>false</code> otherwise
	*/
	@Override
	public boolean isInTrash() {
		return _userSegment.isInTrash();
	}

	/**
	* Returns <code>true</code> if the parent of this user segment is in the Recycle Bin.
	*
	* @return <code>true</code> if the parent of this user segment is in the Recycle Bin; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean isInTrashContainer() {
		return _userSegment.isInTrashContainer();
	}

	/**
	* @deprecated As of 6.1.0, replaced by {@link #isApproved()}
	*/
	@Override
	public boolean getApproved() {
		return _userSegment.getApproved();
	}

	/**
	* Returns <code>true</code> if this user segment is approved.
	*
	* @return <code>true</code> if this user segment is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _userSegment.isApproved();
	}

	/**
	* Returns <code>true</code> if this user segment is denied.
	*
	* @return <code>true</code> if this user segment is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _userSegment.isDenied();
	}

	/**
	* Returns <code>true</code> if this user segment is a draft.
	*
	* @return <code>true</code> if this user segment is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _userSegment.isDraft();
	}

	/**
	* Returns <code>true</code> if this user segment is expired.
	*
	* @return <code>true</code> if this user segment is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _userSegment.isExpired();
	}

	/**
	* Returns <code>true</code> if this user segment is inactive.
	*
	* @return <code>true</code> if this user segment is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _userSegment.isInactive();
	}

	/**
	* Returns <code>true</code> if this user segment is incomplete.
	*
	* @return <code>true</code> if this user segment is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _userSegment.isIncomplete();
	}

	/**
	* Returns <code>true</code> if this user segment is pending.
	*
	* @return <code>true</code> if this user segment is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _userSegment.isPending();
	}

	/**
	* Returns <code>true</code> if this user segment is scheduled.
	*
	* @return <code>true</code> if this user segment is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _userSegment.isScheduled();
	}

	@Override
	public boolean isNew() {
		return _userSegment.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_userSegment.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _userSegment.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userSegment.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _userSegment.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _userSegment.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_userSegment.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userSegment.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_userSegment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_userSegment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userSegment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _userSegment.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _userSegment.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_userSegment.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_userSegment.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new UserSegmentWrapper((UserSegment)_userSegment.clone());
	}

	@Override
	public int compareTo(
		com.liferay.portal.contenttargeting.model.UserSegment userSegment) {
		return _userSegment.compareTo(userSegment);
	}

	@Override
	public int hashCode() {
		return _userSegment.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.portal.contenttargeting.model.UserSegment> toCacheModel() {
		return _userSegment.toCacheModel();
	}

	@Override
	public com.liferay.portal.contenttargeting.model.UserSegment toEscapedModel() {
		return new UserSegmentWrapper(_userSegment.toEscapedModel());
	}

	@Override
	public com.liferay.portal.contenttargeting.model.UserSegment toUnescapedModel() {
		return new UserSegmentWrapper(_userSegment.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _userSegment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userSegment.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_userSegment.persist();
	}

	@Override
	public java.lang.String getNameWithGroupName(java.util.Locale locale,
		long groupId) {
		return _userSegment.getNameWithGroupName(locale, groupId);
	}

	@Override
	public java.util.List<com.liferay.portal.contenttargeting.model.RuleInstance> getRuleInstances()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSegment.getRuleInstances();
	}

	@Override
	public boolean isRuleEnabled(
		com.liferay.portal.contenttargeting.api.model.Rule rule)
		throws java.lang.Exception {
		return _userSegment.isRuleEnabled(rule);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserSegmentWrapper)) {
			return false;
		}

		UserSegmentWrapper userSegmentWrapper = (UserSegmentWrapper)obj;

		if (Validator.equals(_userSegment, userSegmentWrapper._userSegment)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _userSegment.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public UserSegment getWrappedUserSegment() {
		return _userSegment;
	}

	@Override
	public UserSegment getWrappedModel() {
		return _userSegment;
	}

	@Override
	public void resetOriginalValues() {
		_userSegment.resetOriginalValues();
	}

	private UserSegment _userSegment;
}