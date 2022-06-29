package com.catonata.validation.Group;

import javax.validation.GroupSequence;

import com.catonata.validation.Group.ValidationGroups.idFirst;

public class IdCheck {

	@GroupSequence({idFirst.class})
	public interface idCheck{}
}
