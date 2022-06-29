package com.catonata.validation.Group;

import javax.validation.GroupSequence;

import com.catonata.validation.Group.ValidationGroups.emailFirst;
import com.catonata.validation.Group.ValidationGroups.emailSecond;
import com.catonata.validation.Group.ValidationGroups.emailThird;

public class EmailCheck {

	@GroupSequence({emailFirst.class,emailSecond.class,emailThird.class})
	public interface emailCheck{}
}
