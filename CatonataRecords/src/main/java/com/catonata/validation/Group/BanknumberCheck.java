package com.catonata.validation.Group;

import javax.validation.GroupSequence;

import com.catonata.validation.Group.ValidationGroups.banknumberFirst;
import com.catonata.validation.Group.ValidationGroups.banknumberSecond;
import com.catonata.validation.Group.ValidationGroups.banknumberThird;

@GroupSequence({banknumberFirst.class,banknumberSecond.class,banknumberThird.class})
public interface BanknumberCheck {

}
