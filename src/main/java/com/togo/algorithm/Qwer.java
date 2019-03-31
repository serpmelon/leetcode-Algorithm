package com.togo.algorithm;

import java.lang.invoke.MethodHandle;
import static java.lang.invoke.MethodHandles.lookup;
import java.lang.invoke.MethodType;

public class Qwer {

	static class ClassA {
		public void println(String s) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, Throwable {

		Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();

		getPrintMH(obj).invokeExact("fffff");
	}

	private static MethodHandle getPrintMH(Object reveiver) throws NoSuchMethodException, IllegalAccessException {

		MethodType type = MethodType.methodType(void.class, String.class);

		return lookup().findVirtual(reveiver.getClass(), "println", type).bindTo(reveiver);
	}
}
