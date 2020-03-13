package com.logicbig.example;

public class StackWalkerTraversalExample {

	public static void main(String[] args) {
		method1();
	}

	public static void method1() {
		method2();
	}

	public static void method2() {
		method3();
	}

	public static void method3() {
		StackWalker stackWalker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
		stackWalker.forEach(StackWalkerTraversalExample::print);
	}

	private static void print(StackWalker.StackFrame stackFrame) {
		Class<?> clazz = stackFrame.getDeclaringClass();
		int lineNumber = stackFrame.getLineNumber();
		String methodName = stackFrame.getMethodName();
		System.out.printf("Class: %s, Method: %-7s, Line: %s%n",
						  clazz.getSimpleName(), methodName, lineNumber);						
	}
}