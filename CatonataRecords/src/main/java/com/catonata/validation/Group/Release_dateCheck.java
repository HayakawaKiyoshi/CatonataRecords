package com.catonata.validation.Group;

import javax.validation.GroupSequence;

import com.catonata.validation.Group.ValidationGroups.release_dateFirst;
import com.catonata.validation.Group.ValidationGroups.release_dateSecond;

public class Release_dateCheck {

	@GroupSequence({release_dateFirst.class,release_dateSecond.class})
	public interface release_dateCheck{}
}
