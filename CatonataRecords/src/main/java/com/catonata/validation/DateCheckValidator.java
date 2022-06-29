package com.catonata.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateCheckValidator implements ConstraintValidator<DateCheck, String>{
    private String format;
    @Override
    public void initialize(DateCheck dc) {
        this.format = dc.format();
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
    	if (value == null) {return true;}
    	String date[] = value.split("/");
    	if (date[1].matches("[0-9]{1}")) {
    		date[1] = "0" + date[1];
    	}
    	String dateValue = date[0] + "/" + date[1] + "/" + date[2];
    	System.out.println(dateValue);
    		try{
    			//チェック対象文字列をLocalDate型の日付に変換できれば、チェックOKとする
    			LocalDate.parse(dateValue,
    			DateTimeFormatter.ofPattern(format).withResolverStyle(ResolverStyle.STRICT));
    	    	return true;
      }catch(Exception e){
          return false;
      }
    }
}
