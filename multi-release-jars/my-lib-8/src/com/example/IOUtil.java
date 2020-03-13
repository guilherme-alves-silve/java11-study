package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class IOUtil {

	private IOUtil() {
		throw new IllegalArgumentException("No IOUtil!");
	}

	public static String convertToString(InputStream is) throws IOException {
		System.out.println("IOUtil java 8 version");
		try (Scanner scanner = new Scanner(is, "UTF-8")) {
			String str = scanner.useDelimiter("\\A").next();
			return str;
		}
	}
}