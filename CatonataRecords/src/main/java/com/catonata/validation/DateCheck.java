package com.catonata.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy={DateCheckValidator.class})
@Target({ ElementType.METHOD, ElementType.FIELD })
//@Repeatable(DateCheckAnnotation.class)
public @interface DateCheck {
	String format() default"uuuu/MM/dd";

	String message() default "正しいフォーマットで入力してください。";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

	@Target({ ElementType.METHOD, ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface DateCheckAnnotation {
        DateCheck[] value();
    }
}
