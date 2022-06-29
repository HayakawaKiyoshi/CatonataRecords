package com.catonata.validation.Group;

import javax.validation.GroupSequence;

import com.catonata.validation.Group.ValidationGroups.release_dateFirst;
import com.catonata.validation.Group.ValidationGroups.release_dateSecond;
import com.catonata.validation.Group.ValidationGroups.release_dateThird;

@GroupSequence({release_dateFirst.class,release_dateSecond.class, release_dateThird.class})
public interface Release_dateCheck {

}
