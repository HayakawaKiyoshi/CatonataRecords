package com.catonata.validation.Group;

import javax.validation.GroupSequence;

import com.catonata.validation.Group.ValidationGroups.pro_nameFirst;
import com.catonata.validation.Group.ValidationGroups.pro_nameSecond;

@GroupSequence({pro_nameFirst.class,pro_nameSecond.class})
public interface Pro_nameCheck {

}
