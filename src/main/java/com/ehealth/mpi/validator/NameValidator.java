package com.ehealth.mpi.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator {

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(".+",
			Pattern.CASE_INSENSITIVE);

	public synchronized boolean isValid(String name) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(name);
		return matcher.find();
	}
}
