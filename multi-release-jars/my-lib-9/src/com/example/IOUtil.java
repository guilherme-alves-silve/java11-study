package com.example;

import java.io.IOException;
import java.io.InputStream;

public class IOUtil {

	private IOUtil() {
		throw new IllegalArgumentException("No IOUtil!");
	}

	public static String convertToString(InputStream is) throws IOException {
		System.out.println("IOUtil java 9 version");
		try (is) {
			String str = new String(is.readAllBytes());
			return str;
		}
	}
}