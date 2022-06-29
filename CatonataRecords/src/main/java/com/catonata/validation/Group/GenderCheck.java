package com.catonata.validation.Group;

import javax.validation.GroupSequence;

import com.catonata.validation.Group.ValidationGroups.genderFirst;
import com.catonata.validation.Group.ValidationGroups.genderSecond;
import com.catonata.validation.Group.ValidationGroups.genderThird;

@GroupSequence({genderFirst.class,genderSecond.class,genderThird.class})
public interface GenderCheck {

}
