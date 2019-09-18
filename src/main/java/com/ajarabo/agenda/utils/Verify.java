package com.ajarabo.agenda.utils;

import com.ajarabo.agenda.exception.InvalidValueException;

public class Verify {

	
	public static void isNotNull(Object o) {
		if (o == null) {
			throw new InvalidValueException();
		}
	}
}
