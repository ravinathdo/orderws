package com.order.util;

import java.util.ResourceBundle;

public class SystemMessage {

	private static ResourceBundle bundle = ResourceBundle
			.getBundle("com.order.util.Properties");

	public static String getMessage(String message) {
		return bundle.getString(message);
	}
}
