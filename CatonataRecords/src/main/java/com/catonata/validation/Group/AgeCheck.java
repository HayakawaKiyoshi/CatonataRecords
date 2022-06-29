package com.catonata.validation.Group;

import javax.validation.GroupSequence;

import com.catonata.validation.Group.ValidationGroups.ageFirst;
import com.catonata.validation.Group.ValidationGroups.ageSecond;
import com.catonata.validation.Group.ValidationGroups.ageThird;

public class AgeCheck {

	@GroupSequence({ageFirst.class,ageSecond.class,ageThird.class})
	public interface nameCheck{}
}
