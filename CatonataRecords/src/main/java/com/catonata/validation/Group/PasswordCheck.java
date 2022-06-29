package com.catonata.validation.Group;

import javax.validation.GroupSequence;

import com.catonata.validation.Group.ValidationGroups.passFirst;
import com.catonata.validation.Group.ValidationGroups.passSecond;
import com.catonata.validation.Group.ValidationGroups.passThird;

@GroupSequence({passFirst.class,passSecond.class,passThird.class})
public interface PasswordCheck {

}
