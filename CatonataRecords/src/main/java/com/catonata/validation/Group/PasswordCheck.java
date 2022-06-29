package com.catonata.validation.Group;

import javax.validation.GroupSequence;

import com.catonata.validation.Group.ValidationGroups.passFirst;
import com.catonata.validation.Group.ValidationGroups.passSecond;
import com.catonata.validation.Group.ValidationGroups.passThird;

public class PasswordCheck {

	@GroupSequence({passFirst.class,passSecond.class,passThird.class})
	public interface passCheck{}
}
