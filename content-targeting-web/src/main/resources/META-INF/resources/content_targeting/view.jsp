<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
String tabs1 = ParamUtil.getString(request, "tabs1", "user-segments");
%>

<c:choose>
	<c:when test='<%= tabs1.equals("user-segments") %>'>
		<liferay-util:include page="/content_targeting/view_user_segments.jsp" servletContext="<%= application %>" />
	</c:when>
	<c:when test='<%= tabs1.equals("campaigns") %>'>
		<liferay-util:include page="/content_targeting/view_campaigns.jsp" servletContext="<%= application %>" />
	</c:when>
</c:choose>