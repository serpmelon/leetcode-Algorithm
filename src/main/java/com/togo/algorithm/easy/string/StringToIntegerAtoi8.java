package com.togo.algorithm.easy.string;

public class StringToIntegerAtoi8 {

	public static int myAtoi(String str) {

		if (isEmpty(str))
			return 0;

		int s = -1;
		int e = -1;
		String op = "";
		String trimStr = str.trim();
		String firstChar = String.valueOf(trimStr.charAt(0));
		if (!firstChar.matches("[\\d|\\-|\\+]")) {
			return 0;
		}
		if (firstChar.matches("[\\+|\\-]")) {
			op = firstChar;
		}

		int i = isEmpty(op) ? 0 : 1;
		for (; i < trimStr.length(); i++) {

			String charOfStr = String.valueOf(trimStr.charAt(i));
			if(!charOfStr.matches("\\d")) {
				
			}
		}

		if (s == -1)
			return 0;
		if (e == -1)
			e = trimStr.length();

		String longStr = trimStr.substring(s, e);
		if (longStr.length() == 1 && longStr.equals("-"))
			return 0;
		if (longStr.length() > 10)
			if (longStr.startsWith("-"))
				return Integer.MIN_VALUE;
			else
				return Integer.MAX_VALUE;

		long lnum = Long.valueOf(longStr);
		if (lnum >= Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (lnum <= Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		return (int) lnum;
	}

	public static boolean isEmpty(String s) {

		if (s == null || s.length() == 0 || s.trim().equals(""))
			return true;
		return false;
	}

	public static void main(String[] args) {

		String re = "[\\d|\\-]";
		String s = "  0000000000012345678";

		System.out.println(myAtoi(s));
	}
}
