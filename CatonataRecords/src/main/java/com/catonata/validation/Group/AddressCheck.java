package com.catonata.validation.Group;

import javax.validation.GroupSequence;

import com.catonata.validation.Group.ValidationGroups.addressFirst;
import com.catonata.validation.Group.ValidationGroups.addressSecond;

@GroupSequence({addressFirst.class,addressSecond.class})
public interface AddressCheck {

}
