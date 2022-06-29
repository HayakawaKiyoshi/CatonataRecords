package com.catonata.validation.Group;

import javax.validation.GroupSequence;

import com.catonata.validation.Group.ValidationGroups.creditspanFirst;
import com.catonata.validation.Group.ValidationGroups.creditspanSecond;

public class CreditspanCheck {

	@GroupSequence({creditspanFirst.class,creditspanSecond.class})
	public interface creditspanFirstCheck{}
}
