/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.geolocation.model.impl;

import com.liferay.geolocation.model.Geolocation;
import com.liferay.geolocation.model.GeolocationModel;
import com.liferay.geolocation.model.GeolocationSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
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
 * The base model implementation for the Geolocation service. Represents a row in the &quot;GEO_Geolocation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.geolocation.model.GeolocationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link GeolocationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GeolocationImpl
 * @see com.liferay.geolocation.model.Geolocation
 * @see com.liferay.geolocation.model.GeolocationModel
 * @generated
 */
@JSON(strict = true)
public class GeolocationModelImpl extends BaseModelImpl<Geolocation>
	implements GeolocationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a geolocation model instance should use the {@link com.liferay.geolocation.model.Geolocation} interface instead.
	 */
	public static final String TABLE_NAME = "GEO_Geolocation";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "geolocationId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "classNameId", Types.BIGINT },
			{ "classPK", Types.BIGINT },
			{ "latitude", Types.DOUBLE },
			{ "longitude", Types.DOUBLE },
			{ "areaCode", Types.VARCHAR },
			{ "city", Types.VARCHAR },
			{ "countryCode", Types.VARCHAR },
			{ "countryName", Types.VARCHAR },
			{ "metroCode", Types.VARCHAR },
			{ "regionCode", Types.VARCHAR },
			{ "regionName", Types.VARCHAR },
			{ "zipCode", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table GEO_Geolocation (uuid_ VARCHAR(75) null,geolocationId LONG not null primary key,companyId LONG,modifiedDate DATE null,classNameId LONG,classPK LONG,latitude DOUBLE,longitude DOUBLE,areaCode VARCHAR(75) null,city VARCHAR(75) null,countryCode VARCHAR(75) null,countryName VARCHAR(75) null,metroCode VARCHAR(75) null,regionCode VARCHAR(75) null,regionName VARCHAR(75) null,zipCode VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table GEO_Geolocation";
	public static final String ORDER_BY_JPQL = " ORDER BY geolocation.geolocationId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY GEO_Geolocation.geolocationId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.geolocation.model.Geolocation"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.geolocation.model.Geolocation"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.geolocation.model.Geolocation"),
			true);
	public static long CLASSNAMEID_COLUMN_BITMASK = 1L;
	public static long CLASSPK_COLUMN_BITMASK = 2L;
	public static long COMPANYID_COLUMN_BITMASK = 4L;
	public static long MODIFIEDDATE_COLUMN_BITMASK = 8L;
	public static long UUID_COLUMN_BITMASK = 16L;
	public static long GEOLOCATIONID_COLUMN_BITMASK = 32L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Geolocation toModel(GeolocationSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Geolocation model = new GeolocationImpl();

		model.setUuid(soapModel.getUuid());
		model.setGeolocationId(soapModel.getGeolocationId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setClassNameId(soapModel.getClassNameId());
		model.setClassPK(soapModel.getClassPK());
		model.setLatitude(soapModel.getLatitude());
		model.setLongitude(soapModel.getLongitude());
		model.setAreaCode(soapModel.getAreaCode());
		model.setCity(soapModel.getCity());
		model.setCountryCode(soapModel.getCountryCode());
		model.setCountryName(soapModel.getCountryName());
		model.setMetroCode(soapModel.getMetroCode());
		model.setRegionCode(soapModel.getRegionCode());
		model.setRegionName(soapModel.getRegionName());
		model.setZipCode(soapModel.getZipCode());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Geolocation> toModels(GeolocationSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Geolocation> models = new ArrayList<Geolocation>(soapModels.length);

		for (GeolocationSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.geolocation.model.Geolocation"));

	public GeolocationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _geolocationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGeolocationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _geolocationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Geolocation.class;
	}

	@Override
	public String getModelClassName() {
		return Geolocation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("geolocationId", getGeolocationId());
		attributes.put("companyId", getCompanyId());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("latitude", getLatitude());
		attributes.put("longitude", getLongitude());
		attributes.put("areaCode", getAreaCode());
		attributes.put("city", getCity());
		attributes.put("countryCode", getCountryCode());
		attributes.put("countryName", getCountryName());
		attributes.put("metroCode", getMetroCode());
		attributes.put("regionCode", getRegionCode());
		attributes.put("regionName", getRegionName());
		attributes.put("zipCode", getZipCode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long geolocationId = (Long)attributes.get("geolocationId");

		if (geolocationId != null) {
			setGeolocationId(geolocationId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		Double latitude = (Double)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		Double longitude = (Double)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		String areaCode = (String)attributes.get("areaCode");

		if (areaCode != null) {
			setAreaCode(areaCode);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String countryCode = (String)attributes.get("countryCode");

		if (countryCode != null) {
			setCountryCode(countryCode);
		}

		String countryName = (String)attributes.get("countryName");

		if (countryName != null) {
			setCountryName(countryName);
		}

		String metroCode = (String)attributes.get("metroCode");

		if (metroCode != null) {
			setMetroCode(metroCode);
		}

		String regionCode = (String)attributes.get("regionCode");

		if (regionCode != null) {
			setRegionCode(regionCode);
		}

		String regionName = (String)attributes.get("regionName");

		if (regionName != null) {
			setRegionName(regionName);
		}

		String zipCode = (String)attributes.get("zipCode");

		if (zipCode != null) {
			setZipCode(zipCode);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getGeolocationId() {
		return _geolocationId;
	}

	@Override
	public void setGeolocationId(long geolocationId) {
		_geolocationId = geolocationId;
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
		_columnBitmask |= MODIFIEDDATE_COLUMN_BITMASK;

		if (_originalModifiedDate == null) {
			_originalModifiedDate = _modifiedDate;
		}

		_modifiedDate = modifiedDate;
	}

	public Date getOriginalModifiedDate() {
		return _originalModifiedDate;
	}

	@Override
	public String getClassName() {
		if (getClassNameId() <= 0) {
			return StringPool.BLANK;
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@Override
	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@JSON
	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		_columnBitmask |= CLASSNAMEID_COLUMN_BITMASK;

		if (!_setOriginalClassNameId) {
			_setOriginalClassNameId = true;

			_originalClassNameId = _classNameId;
		}

		_classNameId = classNameId;
	}

	public long getOriginalClassNameId() {
		return _originalClassNameId;
	}

	@JSON
	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_columnBitmask |= CLASSPK_COLUMN_BITMASK;

		if (!_setOriginalClassPK) {
			_setOriginalClassPK = true;

			_originalClassPK = _classPK;
		}

		_classPK = classPK;
	}

	public long getOriginalClassPK() {
		return _originalClassPK;
	}

	@JSON
	@Override
	public double getLatitude() {
		return _latitude;
	}

	@Override
	public void setLatitude(double latitude) {
		_latitude = latitude;
	}

	@JSON
	@Override
	public double getLongitude() {
		return _longitude;
	}

	@Override
	public void setLongitude(double longitude) {
		_longitude = longitude;
	}

	@JSON
	@Override
	public String getAreaCode() {
		if (_areaCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _areaCode;
		}
	}

	@Override
	public void setAreaCode(String areaCode) {
		_areaCode = areaCode;
	}

	@JSON
	@Override
	public String getCity() {
		if (_city == null) {
			return StringPool.BLANK;
		}
		else {
			return _city;
		}
	}

	@Override
	public void setCity(String city) {
		_city = city;
	}

	@JSON
	@Override
	public String getCountryCode() {
		if (_countryCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _countryCode;
		}
	}

	@Override
	public void setCountryCode(String countryCode) {
		_countryCode = countryCode;
	}

	@JSON
	@Override
	public String getCountryName() {
		if (_countryName == null) {
			return StringPool.BLANK;
		}
		else {
			return _countryName;
		}
	}

	@Override
	public void setCountryName(String countryName) {
		_countryName = countryName;
	}

	@JSON
	@Override
	public String getMetroCode() {
		if (_metroCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _metroCode;
		}
	}

	@Override
	public void setMetroCode(String metroCode) {
		_metroCode = metroCode;
	}

	@JSON
	@Override
	public String getRegionCode() {
		if (_regionCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _regionCode;
		}
	}

	@Override
	public void setRegionCode(String regionCode) {
		_regionCode = regionCode;
	}

	@JSON
	@Override
	public String getRegionName() {
		if (_regionName == null) {
			return StringPool.BLANK;
		}
		else {
			return _regionName;
		}
	}

	@Override
	public void setRegionName(String regionName) {
		_regionName = regionName;
	}

	@JSON
	@Override
	public String getZipCode() {
		if (_zipCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _zipCode;
		}
	}

	@Override
	public void setZipCode(String zipCode) {
		_zipCode = zipCode;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Geolocation.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Geolocation toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Geolocation)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		GeolocationImpl geolocationImpl = new GeolocationImpl();

		geolocationImpl.setUuid(getUuid());
		geolocationImpl.setGeolocationId(getGeolocationId());
		geolocationImpl.setCompanyId(getCompanyId());
		geolocationImpl.setModifiedDate(getModifiedDate());
		geolocationImpl.setClassNameId(getClassNameId());
		geolocationImpl.setClassPK(getClassPK());
		geolocationImpl.setLatitude(getLatitude());
		geolocationImpl.setLongitude(getLongitude());
		geolocationImpl.setAreaCode(getAreaCode());
		geolocationImpl.setCity(getCity());
		geolocationImpl.setCountryCode(getCountryCode());
		geolocationImpl.setCountryName(getCountryName());
		geolocationImpl.setMetroCode(getMetroCode());
		geolocationImpl.setRegionCode(getRegionCode());
		geolocationImpl.setRegionName(getRegionName());
		geolocationImpl.setZipCode(getZipCode());

		geolocationImpl.resetOriginalValues();

		return geolocationImpl;
	}

	@Override
	public int compareTo(Geolocation geolocation) {
		long primaryKey = geolocation.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Geolocation)) {
			return false;
		}

		Geolocation geolocation = (Geolocation)obj;

		long primaryKey = geolocation.getPrimaryKey();

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
		GeolocationModelImpl geolocationModelImpl = this;

		geolocationModelImpl._originalUuid = geolocationModelImpl._uuid;

		geolocationModelImpl._originalCompanyId = geolocationModelImpl._companyId;

		geolocationModelImpl._setOriginalCompanyId = false;

		geolocationModelImpl._originalModifiedDate = geolocationModelImpl._modifiedDate;

		geolocationModelImpl._originalClassNameId = geolocationModelImpl._classNameId;

		geolocationModelImpl._setOriginalClassNameId = false;

		geolocationModelImpl._originalClassPK = geolocationModelImpl._classPK;

		geolocationModelImpl._setOriginalClassPK = false;

		geolocationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Geolocation> toCacheModel() {
		GeolocationCacheModel geolocationCacheModel = new GeolocationCacheModel();

		geolocationCacheModel.uuid = getUuid();

		String uuid = geolocationCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			geolocationCacheModel.uuid = null;
		}

		geolocationCacheModel.geolocationId = getGeolocationId();

		geolocationCacheModel.companyId = getCompanyId();

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			geolocationCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			geolocationCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		geolocationCacheModel.classNameId = getClassNameId();

		geolocationCacheModel.classPK = getClassPK();

		geolocationCacheModel.latitude = getLatitude();

		geolocationCacheModel.longitude = getLongitude();

		geolocationCacheModel.areaCode = getAreaCode();

		String areaCode = geolocationCacheModel.areaCode;

		if ((areaCode != null) && (areaCode.length() == 0)) {
			geolocationCacheModel.areaCode = null;
		}

		geolocationCacheModel.city = getCity();

		String city = geolocationCacheModel.city;

		if ((city != null) && (city.length() == 0)) {
			geolocationCacheModel.city = null;
		}

		geolocationCacheModel.countryCode = getCountryCode();

		String countryCode = geolocationCacheModel.countryCode;

		if ((countryCode != null) && (countryCode.length() == 0)) {
			geolocationCacheModel.countryCode = null;
		}

		geolocationCacheModel.countryName = getCountryName();

		String countryName = geolocationCacheModel.countryName;

		if ((countryName != null) && (countryName.length() == 0)) {
			geolocationCacheModel.countryName = null;
		}

		geolocationCacheModel.metroCode = getMetroCode();

		String metroCode = geolocationCacheModel.metroCode;

		if ((metroCode != null) && (metroCode.length() == 0)) {
			geolocationCacheModel.metroCode = null;
		}

		geolocationCacheModel.regionCode = getRegionCode();

		String regionCode = geolocationCacheModel.regionCode;

		if ((regionCode != null) && (regionCode.length() == 0)) {
			geolocationCacheModel.regionCode = null;
		}

		geolocationCacheModel.regionName = getRegionName();

		String regionName = geolocationCacheModel.regionName;

		if ((regionName != null) && (regionName.length() == 0)) {
			geolocationCacheModel.regionName = null;
		}

		geolocationCacheModel.zipCode = getZipCode();

		String zipCode = geolocationCacheModel.zipCode;

		if ((zipCode != null) && (zipCode.length() == 0)) {
			geolocationCacheModel.zipCode = null;
		}

		return geolocationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", geolocationId=");
		sb.append(getGeolocationId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", classNameId=");
		sb.append(getClassNameId());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", latitude=");
		sb.append(getLatitude());
		sb.append(", longitude=");
		sb.append(getLongitude());
		sb.append(", areaCode=");
		sb.append(getAreaCode());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", countryCode=");
		sb.append(getCountryCode());
		sb.append(", countryName=");
		sb.append(getCountryName());
		sb.append(", metroCode=");
		sb.append(getMetroCode());
		sb.append(", regionCode=");
		sb.append(getRegionCode());
		sb.append(", regionName=");
		sb.append(getRegionName());
		sb.append(", zipCode=");
		sb.append(getZipCode());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.liferay.geolocation.model.Geolocation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>geolocationId</column-name><column-value><![CDATA[");
		sb.append(getGeolocationId());
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
			"<column><column-name>classNameId</column-name><column-value><![CDATA[");
		sb.append(getClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>latitude</column-name><column-value><![CDATA[");
		sb.append(getLatitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>longitude</column-name><column-value><![CDATA[");
		sb.append(getLongitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>areaCode</column-name><column-value><![CDATA[");
		sb.append(getAreaCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryCode</column-name><column-value><![CDATA[");
		sb.append(getCountryCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryName</column-name><column-value><![CDATA[");
		sb.append(getCountryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>metroCode</column-name><column-value><![CDATA[");
		sb.append(getMetroCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionCode</column-name><column-value><![CDATA[");
		sb.append(getRegionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionName</column-name><column-value><![CDATA[");
		sb.append(getRegionName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zipCode</column-name><column-value><![CDATA[");
		sb.append(getZipCode());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Geolocation.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Geolocation.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _geolocationId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private Date _modifiedDate;
	private Date _originalModifiedDate;
	private long _classNameId;
	private long _originalClassNameId;
	private boolean _setOriginalClassNameId;
	private long _classPK;
	private long _originalClassPK;
	private boolean _setOriginalClassPK;
	private double _latitude;
	private double _longitude;
	private String _areaCode;
	private String _city;
	private String _countryCode;
	private String _countryName;
	private String _metroCode;
	private String _regionCode;
	private String _regionName;
	private String _zipCode;
	private long _columnBitmask;
	private Geolocation _escapedModel;
}