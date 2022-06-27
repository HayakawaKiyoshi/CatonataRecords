package com.catonata.validation.ByteCheckValidation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * バイト数チェックのアノテーションクラスです。
 * 基本的にこのクラスは編集をしないでください。
 * Don't edit this class.
 *
 * @author 伊藤 馨
 *
 */
@Documented
@Constraint(validatedBy = { ByteCheckValidater.class })
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
//@Repeatable(ByteCheckAnnotation.class)
public @interface ByteCheck {
	int min() default 0;

	int max() default Integer.MAX_VALUE;

	String charset() default "UTF-8";

	String message() default
	"{min}バイトから{max}バイトで入力してください。";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	@Target({ ElementType.METHOD, ElementType.FIELD })
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@interface List {
		ByteCheck[] value();
	}
}
