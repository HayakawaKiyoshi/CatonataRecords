package com.catonata.validation.Group;

import javax.validation.GroupSequence;

import com.catonata.validation.Group.ValidationGroups.formatFirst;
import com.catonata.validation.Group.ValidationGroups.formatSecond;

@GroupSequence({formatFirst.class,formatSecond.class})
public interface FormatCheck {

}
