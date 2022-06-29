package com.catonata.validation.Group;

import javax.validation.GroupSequence;

import com.catonata.validation.Group.ValidationGroups.mediaFirst;
import com.catonata.validation.Group.ValidationGroups.mediaSecond;

public class MediaCheck {

	@GroupSequence({mediaFirst.class,mediaSecond.class})
	public interface mediaCheck{}
}
