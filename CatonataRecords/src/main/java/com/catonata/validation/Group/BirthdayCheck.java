package com.catonata.validation.Group;

import javax.validation.GroupSequence;

import com.catonata.validation.Group.ValidationGroups.birthdayFirst;
import com.catonata.validation.Group.ValidationGroups.birthdaySecond;


public class BirthdayCheck {

	@GroupSequence({birthdayFirst.class, birthdaySecond.class})
	public interface birthdayCheck{}
}
