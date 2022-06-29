package com.catonata.validation.Group;

import javax.validation.GroupSequence;

import com.catonata.validation.Group.ValidationGroups.pro_nameFirst;
import com.catonata.validation.Group.ValidationGroups.pro_nameSecond;

public class Pro_nameCheck {

	@GroupSequence({pro_nameFirst.class,pro_nameSecond.class})
	public interface pro_nameCheck{}
}
