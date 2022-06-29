package com.catonata.validation.Group;

import javax.validation.GroupSequence;

import com.catonata.validation.Group.ValidationGroups.idFirst;

@GroupSequence({idFirst.class})
public interface IdCheck {

}
