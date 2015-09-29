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

package com.liferay.content.targeting.model.impl;

import com.liferay.content.targeting.model.AnonymousUserUserSegment;
import com.liferay.content.targeting.model.AnonymousUserUserSegmentModel;
import com.liferay.content.targeting.model.AnonymousUserUserSegmentSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the AnonymousUserUserSegment service. Represents a row in the &quot;CT_AnonymousUserUserSegment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.content.targeting.model.AnonymousUserUserSegmentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AnonymousUserUserSegmentImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnonymousUserUserSegmentImpl
 * @see com.liferay.content.targeting.model.AnonymousUserUserSegment
 * @see com.liferay.content.targeting.model.AnonymousUserUserSegmentModel
 * @generated
 */
@JSON(strict = true)
public class AnonymousUserUserSegmentModelImpl extends BaseModelImpl<AnonymousUserUserSegment>
	implements AnonymousUserUserSegmentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a anonymous user user segment model instance should use the {@link com.liferay.content.targeting.model.AnonymousUserUserSegment} interface instead.
	 */
	public static final String TABLE_NAME = "CT_AnonymousUserUserSegment";
	public static final Object[][] TABLE_COLUMNS = {
			{ "anonymousUserUserSegmentId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "anonymousUserId", Types.BIGINT },
			{ "userSegmentId", Types.BIGINT },
			{ "manual", Types.BOOLEAN },
			{ "active_", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table CT_AnonymousUserUserSegment (anonymousUserUserSegmentId LONG not null primary key,companyId LONG,modifiedDate DATE null,anonymousUserId LONG,userSegmentId LONG,manual BOOLEAN,active_ BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table CT_AnonymousUserUserSegment";
	public static final String ORDER_BY_JPQL = " ORDER BY anonymousUserUserSegment.modifiedDate DESC, anonymousUserUserSegment.active DESC";
	public static final String ORDER_BY_SQL = " ORDER BY CT_AnonymousUserUserSegment.modifiedDate DESC, CT_AnonymousUserUserSegment.active_ DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.content.targeting.model.AnonymousUserUserSegment"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.content.targeting.model.AnonymousUserUserSegment"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.content.targeting.model.AnonymousUserUserSegment"),
			true);
	public static long ACTIVE_COLUMN_BITMASK = 1L;
	public static long ANONYMOUSUSERID_COLUMN_BITMASK = 2L;
	public static long COMPANYID_COLUMN_BITMASK = 4L;
	public static long MANUAL_COLUMN_BITMASK = 8L;
	public static long MODIFIEDDATE_COLUMN_BITMASK = 16L;
	public static long USERSEGMENTID_COLUMN_BITMASK = 32L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static AnonymousUserUserSegment toModel(
		AnonymousUserUserSegmentSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		AnonymousUserUserSegment model = new AnonymousUserUserSegmentImpl();

		model.setAnonymousUserUserSegmentId(soapModel.getAnonymousUserUserSegmentId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setAnonymousUserId(soapModel.getAnonymousUserId());
		model.setUserSegmentId(soapModel.getUserSegmentId());
		model.setManual(soapModel.getManual());
		model.setActive(soapModel.getActive());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<AnonymousUserUserSegment> toModels(
		AnonymousUserUserSegmentSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<AnonymousUserUserSegment> models = new ArrayList<AnonymousUserUserSegment>(soapModels.length);

		for (AnonymousUserUserSegmentSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.content.targeting.model.AnonymousUserUserSegment"));

	public AnonymousUserUserSegmentModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _anonymousUserUserSegmentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAnonymousUserUserSegmentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _anonymousUserUserSegmentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return AnonymousUserUserSegment.class;
	}

	@Override
	public String getModelClassName() {
		return AnonymousUserUserSegment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("anonymousUserUserSegmentId",
			getAnonymousUserUserSegmentId());
		attributes.put("companyId", getCompanyId());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("anonymousUserId", getAnonymousUserId());
		attributes.put("userSegmentId", getUserSegmentId());
		attributes.put("manual", getManual());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long anonymousUserUserSegmentId = (Long)attributes.get(
				"anonymousUserUserSegmentId");

		if (anonymousUserUserSegmentId != null) {
			setAnonymousUserUserSegmentId(anonymousUserUserSegmentId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long anonymousUserId = (Long)attributes.get("anonymousUserId");

		if (anonymousUserId != null) {
			setAnonymousUserId(anonymousUserId);
		}

		Long userSegmentId = (Long)attributes.get("userSegmentId");

		if (userSegmentId != null) {
			setUserSegmentId(userSegmentId);
		}

		Boolean manual = (Boolean)attributes.get("manual");

		if (manual != null) {
			setManual(manual);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	@JSON
	@Override
	public long getAnonymousUserUserSegmentId() {
		return _anonymousUserUserSegmentId;
	}

	@Override
	public void setAnonymousUserUserSegmentId(long anonymousUserUserSegmentId) {
		_anonymousUserUserSegmentId = anonymousUserUserSegmentId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_columnBitmask = -1L;

		if (_originalModifiedDate == null) {
			_originalModifiedDate = _modifiedDate;
		}

		_modifiedDate = modifiedDate;
	}

	public Date getOriginalModifiedDate() {
		return _originalModifiedDate;
	}

	@JSON
	@Override
	public long getAnonymousUserId() {
		return _anonymousUserId;
	}

	@Override
	public void setAnonymousUserId(long anonymousUserId) {
		_columnBitmask |= ANONYMOUSUSERID_COLUMN_BITMASK;

		if (!_setOriginalAnonymousUserId) {
			_setOriginalAnonymousUserId = true;

			_originalAnonymousUserId = _anonymousUserId;
		}

		_anonymousUserId = anonymousUserId;
	}

	@Override
	public String getAnonymousUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getAnonymousUserId(), "uuid",
			_anonymousUserUuid);
	}

	@Override
	public void setAnonymousUserUuid(String anonymousUserUuid) {
		_anonymousUserUuid = anonymousUserUuid;
	}

	public long getOriginalAnonymousUserId() {
		return _originalAnonymousUserId;
	}

	@JSON
	@Override
	public long getUserSegmentId() {
		return _userSegmentId;
	}

	@Override
	public void setUserSegmentId(long userSegmentId) {
		_columnBitmask |= USERSEGMENTID_COLUMN_BITMASK;

		if (!_setOriginalUserSegmentId) {
			_setOriginalUserSegmentId = true;

			_originalUserSegmentId = _userSegmentId;
		}

		_userSegmentId = userSegmentId;
	}

	public long getOriginalUserSegmentId() {
		return _originalUserSegmentId;
	}

	@JSON
	@Override
	public boolean getManual() {
		return _manual;
	}

	@Override
	public boolean isManual() {
		return _manual;
	}

	@Override
	public void setManual(boolean manual) {
		_columnBitmask |= MANUAL_COLUMN_BITMASK;

		if (!_setOriginalManual) {
			_setOriginalManual = true;

			_originalManual = _manual;
		}

		_manual = manual;
	}

	public boolean getOriginalManual() {
		return _originalManual;
	}

	@JSON
	@Override
	public boolean getActive() {
		return _active;
	}

	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_columnBitmask = -1L;

		if (!_setOriginalActive) {
			_setOriginalActive = true;

			_originalActive = _active;
		}

		_active = active;
	}

	public boolean getOriginalActive() {
		return _originalActive;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			AnonymousUserUserSegment.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AnonymousUserUserSegment toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (AnonymousUserUserSegment)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AnonymousUserUserSegmentImpl anonymousUserUserSegmentImpl = new AnonymousUserUserSegmentImpl();

		anonymousUserUserSegmentImpl.setAnonymousUserUserSegmentId(getAnonymousUserUserSegmentId());
		anonymousUserUserSegmentImpl.setCompanyId(getCompanyId());
		anonymousUserUserSegmentImpl.setModifiedDate(getModifiedDate());
		anonymousUserUserSegmentImpl.setAnonymousUserId(getAnonymousUserId());
		anonymousUserUserSegmentImpl.setUserSegmentId(getUserSegmentId());
		anonymousUserUserSegmentImpl.setManual(getManual());
		anonymousUserUserSegmentImpl.setActive(getActive());

		anonymousUserUserSegmentImpl.resetOriginalValues();

		return anonymousUserUserSegmentImpl;
	}

	@Override
	public int compareTo(AnonymousUserUserSegment anonymousUserUserSegment) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				anonymousUserUserSegment.getModifiedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		if (getActive() == anonymousUserUserSegment.getActive()) {
			value = -1;
		}
		else if (getActive() != anonymousUserUserSegment.getActive()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnonymousUserUserSegment)) {
			return false;
		}

		AnonymousUserUserSegment anonymousUserUserSegment = (AnonymousUserUserSegment)obj;

		long primaryKey = anonymousUserUserSegment.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		AnonymousUserUserSegmentModelImpl anonymousUserUserSegmentModelImpl = this;

		anonymousUserUserSegmentModelImpl._originalCompanyId = anonymousUserUserSegmentModelImpl._companyId;

		anonymousUserUserSegmentModelImpl._setOriginalCompanyId = false;

		anonymousUserUserSegmentModelImpl._originalModifiedDate = anonymousUserUserSegmentModelImpl._modifiedDate;

		anonymousUserUserSegmentModelImpl._originalAnonymousUserId = anonymousUserUserSegmentModelImpl._anonymousUserId;

		anonymousUserUserSegmentModelImpl._setOriginalAnonymousUserId = false;

		anonymousUserUserSegmentModelImpl._originalUserSegmentId = anonymousUserUserSegmentModelImpl._userSegmentId;

		anonymousUserUserSegmentModelImpl._setOriginalUserSegmentId = false;

		anonymousUserUserSegmentModelImpl._originalManual = anonymousUserUserSegmentModelImpl._manual;

		anonymousUserUserSegmentModelImpl._setOriginalManual = false;

		anonymousUserUserSegmentModelImpl._originalActive = anonymousUserUserSegmentModelImpl._active;

		anonymousUserUserSegmentModelImpl._setOriginalActive = false;

		anonymousUserUserSegmentModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<AnonymousUserUserSegment> toCacheModel() {
		AnonymousUserUserSegmentCacheModel anonymousUserUserSegmentCacheModel = new AnonymousUserUserSegmentCacheModel();

		anonymousUserUserSegmentCacheModel.anonymousUserUserSegmentId = getAnonymousUserUserSegmentId();

		anonymousUserUserSegmentCacheModel.companyId = getCompanyId();

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			anonymousUserUserSegmentCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			anonymousUserUserSegmentCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		anonymousUserUserSegmentCacheModel.anonymousUserId = getAnonymousUserId();

		anonymousUserUserSegmentCacheModel.userSegmentId = getUserSegmentId();

		anonymousUserUserSegmentCacheModel.manual = getManual();

		anonymousUserUserSegmentCacheModel.active = getActive();

		return anonymousUserUserSegmentCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{anonymousUserUserSegmentId=");
		sb.append(getAnonymousUserUserSegmentId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", anonymousUserId=");
		sb.append(getAnonymousUserId());
		sb.append(", userSegmentId=");
		sb.append(getUserSegmentId());
		sb.append(", manual=");
		sb.append(getManual());
		sb.append(", active=");
		sb.append(getActive());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.content.targeting.model.AnonymousUserUserSegment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>anonymousUserUserSegmentId</column-name><column-value><![CDATA[");
		sb.append(getAnonymousUserUserSegmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>anonymousUserId</column-name><column-value><![CDATA[");
		sb.append(getAnonymousUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userSegmentId</column-name><column-value><![CDATA[");
		sb.append(getUserSegmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>manual</column-name><column-value><![CDATA[");
		sb.append(getManual());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = AnonymousUserUserSegment.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			AnonymousUserUserSegment.class
		};
	private long _anonymousUserUserSegmentId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private Date _modifiedDate;
	private Date _originalModifiedDate;
	private long _anonymousUserId;
	private String _anonymousUserUuid;
	private long _originalAnonymousUserId;
	private boolean _setOriginalAnonymousUserId;
	private long _userSegmentId;
	private long _originalUserSegmentId;
	private boolean _setOriginalUserSegmentId;
	private boolean _manual;
	private boolean _originalManual;
	private boolean _setOriginalManual;
	private boolean _active;
	private boolean _originalActive;
	private boolean _setOriginalActive;
	private long _columnBitmask;
	private AnonymousUserUserSegment _escapedModel;
}