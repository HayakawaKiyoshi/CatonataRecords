package com.catonata.validation.Group;

import javax.validation.GroupSequence;

import com.catonata.validation.Group.ValidationGroups.banknameFirst;
import com.catonata.validation.Group.ValidationGroups.banknameSecond;
import com.catonata.validation.Group.ValidationGroups.banknameThird;

@GroupSequence({banknameFirst.class,banknameSecond.class,banknameThird.class})
public interface BanknameCheck {

}
