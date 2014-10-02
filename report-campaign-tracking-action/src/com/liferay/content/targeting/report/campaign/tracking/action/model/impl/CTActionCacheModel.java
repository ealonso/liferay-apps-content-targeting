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

package com.liferay.content.targeting.report.campaign.tracking.action.model.impl;

import com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CTAction in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CTAction
 * @generated
 */
public class CTActionCacheModel implements CacheModel<CTAction>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{CTActionId=");
		sb.append(CTActionId);
		sb.append(", campaignId=");
		sb.append(campaignId);
		sb.append(", userSegmentId=");
		sb.append(userSegmentId);
		sb.append(", alias=");
		sb.append(alias);
		sb.append(", referrerClassName=");
		sb.append(referrerClassName);
		sb.append(", referrerClassPK=");
		sb.append(referrerClassPK);
		sb.append(", elementId=");
		sb.append(elementId);
		sb.append(", eventType=");
		sb.append(eventType);
		sb.append(", count=");
		sb.append(count);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CTAction toEntityModel() {
		CTActionImpl ctActionImpl = new CTActionImpl();

		ctActionImpl.setCTActionId(CTActionId);
		ctActionImpl.setCampaignId(campaignId);
		ctActionImpl.setUserSegmentId(userSegmentId);

		if (alias == null) {
			ctActionImpl.setAlias(StringPool.BLANK);
		}
		else {
			ctActionImpl.setAlias(alias);
		}

		if (referrerClassName == null) {
			ctActionImpl.setReferrerClassName(StringPool.BLANK);
		}
		else {
			ctActionImpl.setReferrerClassName(referrerClassName);
		}

		ctActionImpl.setReferrerClassPK(referrerClassPK);

		if (elementId == null) {
			ctActionImpl.setElementId(StringPool.BLANK);
		}
		else {
			ctActionImpl.setElementId(elementId);
		}

		if (eventType == null) {
			ctActionImpl.setEventType(StringPool.BLANK);
		}
		else {
			ctActionImpl.setEventType(eventType);
		}

		ctActionImpl.setCount(count);

		if (modifiedDate == Long.MIN_VALUE) {
			ctActionImpl.setModifiedDate(null);
		}
		else {
			ctActionImpl.setModifiedDate(new Date(modifiedDate));
		}

		ctActionImpl.resetOriginalValues();

		return ctActionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		CTActionId = objectInput.readLong();
		campaignId = objectInput.readLong();
		userSegmentId = objectInput.readLong();
		alias = objectInput.readUTF();
		referrerClassName = objectInput.readUTF();
		referrerClassPK = objectInput.readLong();
		elementId = objectInput.readUTF();
		eventType = objectInput.readUTF();
		count = objectInput.readInt();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(CTActionId);
		objectOutput.writeLong(campaignId);
		objectOutput.writeLong(userSegmentId);

		if (alias == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(alias);
		}

		if (referrerClassName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(referrerClassName);
		}

		objectOutput.writeLong(referrerClassPK);

		if (elementId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(elementId);
		}

		if (eventType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventType);
		}

		objectOutput.writeInt(count);
		objectOutput.writeLong(modifiedDate);
	}

	public long CTActionId;
	public long campaignId;
	public long userSegmentId;
	public String alias;
	public String referrerClassName;
	public long referrerClassPK;
	public String elementId;
	public String eventType;
	public int count;
	public long modifiedDate;
}