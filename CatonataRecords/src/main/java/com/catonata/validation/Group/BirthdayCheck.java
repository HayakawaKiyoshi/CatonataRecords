package com.catonata.validation.Group;

import javax.validation.GroupSequence;

import com.catonata.validation.Group.ValidationGroups.birthdayFirst;
import com.catonata.validation.Group.ValidationGroups.birthdaySecond;
import com.catonata.validation.Group.ValidationGroups.birthdayThird;

@GroupSequence({birthdayFirst.class, birthdaySecond.class, birthdayThird.class})
public interface BirthdayCheck {

}
