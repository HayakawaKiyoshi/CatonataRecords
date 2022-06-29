package com.catonata.validation.Group;

import javax.validation.GroupSequence;

import com.catonata.validation.Group.ValidationGroups.stockFirst;
import com.catonata.validation.Group.ValidationGroups.stockSecond;
import com.catonata.validation.Group.ValidationGroups.stockThird;

public class StockCheck {

	@GroupSequence({stockFirst.class,stockSecond.class,stockThird.class})
	public interface stockCheck{}
}
