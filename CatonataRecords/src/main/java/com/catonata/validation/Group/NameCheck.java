package com.catonata.validation.Group;

import javax.validation.GroupSequence;

import com.catonata.validation.Group.ValidationGroups.nameFirst;
import com.catonata.validation.Group.ValidationGroups.nameSecond;

@GroupSequence({nameFirst.class,nameSecond.class})
public interface NameCheck {



}
