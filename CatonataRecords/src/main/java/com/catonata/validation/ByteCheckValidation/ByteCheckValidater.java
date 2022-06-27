package com.catonata.validation.ByteCheckValidation;

import java.nio.charset.Charset;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * バイト数チェックのバリデーションクラスです。
 * 基本的にこのクラスは編集しないでください。
 * Don't edit this class.
 *
 * @author 伊藤 馨
 *
 */
public class ByteCheckValidater implements ConstraintValidator<ByteCheck, String> {

	private int min;
	private int max;
	private String charset;

	@Override
	public void initialize(ByteCheck bc) {
		min = bc.min();
		max = bc.max();
		charset = bc.charset();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext ctx) {
		if (value == null) {return true;}
		byte[] b = value.getBytes(Charset.forName(charset));
		return min <= b.length && b.length <= max;
	}
}
