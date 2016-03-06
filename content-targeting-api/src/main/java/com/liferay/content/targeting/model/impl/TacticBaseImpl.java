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

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.model.Tactic;
import com.liferay.content.targeting.service.TacticLocalServiceUtil;

/**
 * The extended model base implementation for the Tactic service. Represents a row in the &quot;CT_Tactic&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TacticImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TacticImpl
 * @see Tactic
 * @generated
 */
@ProviderType
public abstract class TacticBaseImpl extends TacticModelImpl implements Tactic {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a tactic model instance should use the {@link Tactic} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			TacticLocalServiceUtil.addTactic(this);
		}
		else {
			TacticLocalServiceUtil.updateTactic(this);
		}
	}
}