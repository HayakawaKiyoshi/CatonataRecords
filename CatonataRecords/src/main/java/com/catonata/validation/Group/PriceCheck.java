package com.catonata.validation.Group;

import javax.validation.GroupSequence;

import com.catonata.validation.Group.ValidationGroups.priceFirst;
import com.catonata.validation.Group.ValidationGroups.priceSecond;
import com.catonata.validation.Group.ValidationGroups.priceThird;

@GroupSequence({priceFirst.class,priceSecond.class,priceThird.class})
public interface PriceCheck {

}
