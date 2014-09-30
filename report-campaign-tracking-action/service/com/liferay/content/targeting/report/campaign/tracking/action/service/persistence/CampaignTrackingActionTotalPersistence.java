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

package com.liferay.content.targeting.report.campaign.tracking.action.service.persistence;

import com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the campaign tracking action total service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignTrackingActionTotalPersistenceImpl
 * @see CampaignTrackingActionTotalUtil
 * @generated
 */
public interface CampaignTrackingActionTotalPersistence extends BasePersistence<CampaignTrackingActionTotal> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CampaignTrackingActionTotalUtil} to access the campaign tracking action total persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the campaign tracking action totals where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the matching campaign tracking action totals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal> findByCampaignId(
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the campaign tracking action totals where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of campaign tracking action totals
	* @param end the upper bound of the range of campaign tracking action totals (not inclusive)
	* @return the range of matching campaign tracking action totals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal> findByCampaignId(
		long campaignId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the campaign tracking action totals where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of campaign tracking action totals
	* @param end the upper bound of the range of campaign tracking action totals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaign tracking action totals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal> findByCampaignId(
		long campaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first campaign tracking action total in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign tracking action total
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException if a matching campaign tracking action total could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal findByCampaignId_First(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first campaign tracking action total in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign tracking action total, or <code>null</code> if a matching campaign tracking action total could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal fetchByCampaignId_First(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last campaign tracking action total in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign tracking action total
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException if a matching campaign tracking action total could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal findByCampaignId_Last(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last campaign tracking action total in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign tracking action total, or <code>null</code> if a matching campaign tracking action total could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal fetchByCampaignId_Last(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the campaign tracking action totals before and after the current campaign tracking action total in the ordered set where campaignId = &#63;.
	*
	* @param campaignTrackingActionTotalId the primary key of the current campaign tracking action total
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign tracking action total
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException if a campaign tracking action total with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal[] findByCampaignId_PrevAndNext(
		long campaignTrackingActionTotalId, long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the campaign tracking action totals where campaignId = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCampaignId(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of campaign tracking action totals where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the number of matching campaign tracking action totals
	* @throws SystemException if a system exception occurred
	*/
	public int countByCampaignId(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the campaign tracking action totals where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @return the matching campaign tracking action totals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal> findByC_GtD(
		long campaignId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the campaign tracking action totals where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param start the lower bound of the range of campaign tracking action totals
	* @param end the upper bound of the range of campaign tracking action totals (not inclusive)
	* @return the range of matching campaign tracking action totals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal> findByC_GtD(
		long campaignId, java.util.Date modifiedDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the campaign tracking action totals where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param start the lower bound of the range of campaign tracking action totals
	* @param end the upper bound of the range of campaign tracking action totals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaign tracking action totals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal> findByC_GtD(
		long campaignId, java.util.Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first campaign tracking action total in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign tracking action total
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException if a matching campaign tracking action total could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal findByC_GtD_First(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first campaign tracking action total in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign tracking action total, or <code>null</code> if a matching campaign tracking action total could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal fetchByC_GtD_First(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last campaign tracking action total in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign tracking action total
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException if a matching campaign tracking action total could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal findByC_GtD_Last(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last campaign tracking action total in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign tracking action total, or <code>null</code> if a matching campaign tracking action total could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal fetchByC_GtD_Last(
		long campaignId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the campaign tracking action totals before and after the current campaign tracking action total in the ordered set where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignTrackingActionTotalId the primary key of the current campaign tracking action total
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign tracking action total
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException if a campaign tracking action total with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal[] findByC_GtD_PrevAndNext(
		long campaignTrackingActionTotalId, long campaignId,
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the campaign tracking action totals where campaignId = &#63; and modifiedDate &gt; &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_GtD(long campaignId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of campaign tracking action totals where campaignId = &#63; and modifiedDate &gt; &#63;.
	*
	* @param campaignId the campaign ID
	* @param modifiedDate the modified date
	* @return the number of matching campaign tracking action totals
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_GtD(long campaignId, java.util.Date modifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the campaign tracking action total where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; or throws a {@link com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException} if it could not be found.
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param elementId the element ID
	* @param eventType the event type
	* @return the matching campaign tracking action total
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException if a matching campaign tracking action total could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal findByC_R_R_E_E(
		long campaignId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the campaign tracking action total where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param elementId the element ID
	* @param eventType the event type
	* @return the matching campaign tracking action total, or <code>null</code> if a matching campaign tracking action total could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal fetchByC_R_R_E_E(
		long campaignId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the campaign tracking action total where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param elementId the element ID
	* @param eventType the event type
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching campaign tracking action total, or <code>null</code> if a matching campaign tracking action total could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal fetchByC_R_R_E_E(
		long campaignId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the campaign tracking action total where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param elementId the element ID
	* @param eventType the event type
	* @return the campaign tracking action total that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal removeByC_R_R_E_E(
		long campaignId, java.lang.String referrerClassName,
		long referrerClassPK, java.lang.String elementId,
		java.lang.String eventType)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of campaign tracking action totals where campaignId = &#63; and referrerClassName = &#63; and referrerClassPK = &#63; and elementId = &#63; and eventType = &#63;.
	*
	* @param campaignId the campaign ID
	* @param referrerClassName the referrer class name
	* @param referrerClassPK the referrer class p k
	* @param elementId the element ID
	* @param eventType the event type
	* @return the number of matching campaign tracking action totals
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_R_R_E_E(long campaignId,
		java.lang.String referrerClassName, long referrerClassPK,
		java.lang.String elementId, java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the campaign tracking action total in the entity cache if it is enabled.
	*
	* @param campaignTrackingActionTotal the campaign tracking action total
	*/
	public void cacheResult(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal campaignTrackingActionTotal);

	/**
	* Caches the campaign tracking action totals in the entity cache if it is enabled.
	*
	* @param campaignTrackingActionTotals the campaign tracking action totals
	*/
	public void cacheResult(
		java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal> campaignTrackingActionTotals);

	/**
	* Creates a new campaign tracking action total with the primary key. Does not add the campaign tracking action total to the database.
	*
	* @param campaignTrackingActionTotalId the primary key for the new campaign tracking action total
	* @return the new campaign tracking action total
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal create(
		long campaignTrackingActionTotalId);

	/**
	* Removes the campaign tracking action total with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignTrackingActionTotalId the primary key of the campaign tracking action total
	* @return the campaign tracking action total that was removed
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException if a campaign tracking action total with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal remove(
		long campaignTrackingActionTotalId)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal updateImpl(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal campaignTrackingActionTotal)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the campaign tracking action total with the primary key or throws a {@link com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException} if it could not be found.
	*
	* @param campaignTrackingActionTotalId the primary key of the campaign tracking action total
	* @return the campaign tracking action total
	* @throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException if a campaign tracking action total with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal findByPrimaryKey(
		long campaignTrackingActionTotalId)
		throws com.liferay.content.targeting.report.campaign.tracking.action.NoSuchCampaignTrackingActionTotalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the campaign tracking action total with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param campaignTrackingActionTotalId the primary key of the campaign tracking action total
	* @return the campaign tracking action total, or <code>null</code> if a campaign tracking action total with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal fetchByPrimaryKey(
		long campaignTrackingActionTotalId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the campaign tracking action totals.
	*
	* @return the campaign tracking action totals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the campaign tracking action totals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campaign tracking action totals
	* @param end the upper bound of the range of campaign tracking action totals (not inclusive)
	* @return the range of campaign tracking action totals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the campaign tracking action totals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CampaignTrackingActionTotalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campaign tracking action totals
	* @param end the upper bound of the range of campaign tracking action totals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of campaign tracking action totals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.tracking.action.model.CampaignTrackingActionTotal> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the campaign tracking action totals from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of campaign tracking action totals.
	*
	* @return the number of campaign tracking action totals
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}