package com.catonata.validation.Group;

import javax.validation.GroupSequence;

import com.catonata.validation.Group.ValidationGroups.formatFirst;
import com.catonata.validation.Group.ValidationGroups.formatSecond;

public class FormatCheck {

	@GroupSequence({formatFirst.class,formatSecond.class})
	public interface formatCheck{}
}
