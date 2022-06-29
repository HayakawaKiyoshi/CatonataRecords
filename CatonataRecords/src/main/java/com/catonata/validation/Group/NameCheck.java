package com.catonata.validation.Group;

import javax.validation.GroupSequence;

import com.catonata.validation.Group.ValidationGroups.nameFirst;
import com.catonata.validation.Group.ValidationGroups.nameSecond;

public class NameCheck {

	@GroupSequence({nameFirst.class,nameSecond.class})
	public interface nameCheck{}
}
