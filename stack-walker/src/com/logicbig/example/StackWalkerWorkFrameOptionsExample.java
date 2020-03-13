package com.logicbig.example;

import java.util.stream.Stream;
import java.lang.reflect.Method;
import java.util.Set;

public class StackWalkerWorkFrameOptionsExample {

	public static void main(String[] args) throws Exception {
		doSomething();
		doSomethingWithReflectFrames();
		doSomethingWithHiddenFrames();
		doSomethingWithMultipleOptions();
	}

	private static void doSomething() {
		System.out.println(" -- normal -- ");
		Stream.of("example")
			  .forEach(str -> {
			  	StackWalker stackWalker = StackWalker.getInstance();
			  	stackWalker.forEach(System.out::println);
			  });
	}

	private static void doSomethingWithReflectFrames() throws Exception {
		Method method = StackWalkerWorkFrameOptionsExample.class
							.getDeclaredMethod("doReflection");
		method.setAccessible(true);
		method.invoke(null);
	}

	private static void doReflection() {
		System.out.println(" -- with SHOW_REFLECT_FRAMES -- ");
		StackWalker stackWalker = StackWalker.getInstance(StackWalker.Option.SHOW_REFLECT_FRAMES);
		stackWalker.forEach(System.out::println);
	}

	private static void doSomethingWithHiddenFrames() {
		System.out.println(" -- with SHOW_HIDDEN_FRAMES -- ");
		Stream.of("example")
			  .forEach(str -> {
		  	      StackWalker stackWalker = StackWalker.getInstance(StackWalker.Option.SHOW_HIDDEN_FRAMES);
				  stackWalker.forEach(System.out::println);		  	      
		  	  });
	}

	private static void doSomethingWithMultipleOptions() throws Exception {
		Method method = StackWalkerWorkFrameOptionsExample.class
							.getDeclaredMethod("doReflectionWithHiddenAndRetain");
		method.setAccessible(true);
		method.invoke(null);		
	}

	private static void doReflectionWithHiddenAndRetain() {
		System.out.println(" -- with SHOW_HIDDEN_FRAMES and RETAIN_CLASS_REFERENCE -- ");
		StackWalker stackWalker = StackWalker.getInstance(
			Set.of(
				StackWalker.Option.SHOW_HIDDEN_FRAMES,
				StackWalker.Option.RETAIN_CLASS_REFERENCE
			)
		);	
		stackWalker.forEach(stackFrame -> System.out.println(
			stackFrame.getDeclaringClass().getName()
		));	
	}
}