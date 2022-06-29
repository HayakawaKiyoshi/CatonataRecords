package com.catonata.validation.Group;

import javax.validation.GroupSequence;

import com.catonata.validation.Group.ValidationGroups.labelFirst;
import com.catonata.validation.Group.ValidationGroups.labelSecond;

@GroupSequence({labelFirst.class,labelSecond.class})
public interface LabelCheck {

}
