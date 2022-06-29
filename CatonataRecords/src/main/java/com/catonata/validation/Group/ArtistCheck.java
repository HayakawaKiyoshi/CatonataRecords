package com.catonata.validation.Group;

import javax.validation.GroupSequence;

import com.catonata.validation.Group.ValidationGroups.artistFirst;
import com.catonata.validation.Group.ValidationGroups.artistSecond;

@GroupSequence({artistFirst.class,artistSecond.class})
public interface ArtistCheck {

}
