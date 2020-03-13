package com.logicbig.example;

public class StackWalkerCallerExample {

	public static void main(String[] args) {
		TheCallerClass caller = new TheCallerClass();
		caller.doSomething();
	}

	public static final class TheCallerClass {
		public void doSomething() {
			TheCalleClass calle = new TheCalleClass();
			calle.work();
		}
	}

	public static final class TheCalleClass {
		public void work() {
			StackWalker stackWalker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
			Class<?> clazz = stackWalker.getCallerClass();
			System.out.println(clazz);			
		}
	}
}