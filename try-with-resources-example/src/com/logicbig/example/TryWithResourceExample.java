package com.logicbig.example;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TryWithResourceExample {

	public static void main(String[] args) throws IOException {
		
		InputStream is = getInputStream();

		try (is) {
			String str = new String(is.readAllBytes());
			System.out.println(str);			
		}

		System.out.println("********************");

		InputStream is1 = getInputStream();
		InputStream is2 = getInputStream();
		try (is1; is2) {
			String str1 = new String(is1.readAllBytes());
			String str2 = new String(is2.readAllBytes());
			System.out.println(str1 + " - " + str2);
		}

		System.out.println("after try-with-resource block");
	}

	public static InputStream getInputStream() {
		
		return new ByteArrayInputStream("test string".getBytes()) {

			@Override
			public void close() throws IOException {

				System.out.println("closing");
				super.close();
			}
		};
	}
}