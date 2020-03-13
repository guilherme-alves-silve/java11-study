package com.example;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

	public static void main(String[] args) throws IOException {

		InputStream is = new ByteArrayInputStream("test string".getBytes());
		String result = IOUtil.convertToString(is);
		System.out.println(result);
	}
}