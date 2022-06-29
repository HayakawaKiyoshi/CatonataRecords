package com.catonata.validation.Group;

import javax.validation.GroupSequence;

import com.catonata.validation.Group.ValidationGroups.securityFirst;
import com.catonata.validation.Group.ValidationGroups.securitySecond;
import com.catonata.validation.Group.ValidationGroups.securityThird;

public class SecurityCheck {

	@GroupSequence({securityFirst.class,securitySecond.class,securityThird.class})
	public interface securityCheck{}
}
