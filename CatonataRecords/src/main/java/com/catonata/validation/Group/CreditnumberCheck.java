package com.catonata.validation.Group;

import javax.validation.GroupSequence;

import com.catonata.validation.Group.ValidationGroups.creditnumberFirst;
import com.catonata.validation.Group.ValidationGroups.creditnumberSecond;
import com.catonata.validation.Group.ValidationGroups.creditnumberThird;

public class CreditnumberCheck {

	@GroupSequence({creditnumberFirst.class,creditnumberSecond.class,creditnumberThird.class})
	public interface creditnumberCheck{}
}
