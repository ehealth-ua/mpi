package com.ehealth.mpi.validator;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

@Service
public class PhoneValidator {

	private static PhoneNumberUtil phoneUtil;

	@PostConstruct
	private void init() {
		phoneUtil = PhoneNumberUtil.getInstance();
	}

	public synchronized Boolean isValid(String phoneNumber) {
		try {
			PhoneNumber number = null;
			number = phoneUtil.parseAndKeepRawInput(phoneNumber, "UA");
			return phoneUtil.isPossibleNumber(number) && phoneUtil.isValidNumber(number);
		} catch (NumberParseException e) {
			e.printStackTrace();
		}return false;
	}

	public String formattingPhoneNumber(String phoneNumber) {
		PhoneNumber number = null;
		try {
			number = phoneUtil.parseAndKeepRawInput(phoneNumber, "UA");
		} catch (NumberParseException e) {
			e.printStackTrace();
		}
		return String.valueOf(number.getCountryCode()) + String.valueOf(number.getNationalNumber());
	}

}
