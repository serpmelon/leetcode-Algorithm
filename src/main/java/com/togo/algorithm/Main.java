package com.togo.algorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	
	
//	public static void main(String[] args) {
//
//		int a = 123;
//		Date d = new Date();
//		String s = get(d);
//		System.out.println(s);
//		Map<String, String> map = new HashMap<>();
//		map.put("A", "wlj");
//		map.put("B", "123");
////		object
//		
////		HashMap<K, V>
////		ConcurrentHashMap<K, V>
////		BlockingQueue bq = (BlockingQueue) new ConcurrentLinkedQueue();
//	}
	
	public static String get(Object obj) {

		String t = null;
		try {

			t = (String) obj;
		} catch (ClassCastException e) {
			System.out.println("qqq");
			throw new ClassCastException("类型转换错误  " + obj.getClass() + " -> String");
		}


		return t;
	}
	
	public static void main(String[] args) {
		
//		String a = "123";
//		String b = "123";
//		
//		System.out.println(a.equals(b));
//		System.out.println(a == b);
//		String c = new String("123");
//		System.out.println(a.equals(c));
//		System.out.println(a == c);

//		long tt = Long.valueOf("-");
//		System.out.println(tt);
//		String s = "123";
//		s.contains(s);
		
		char a = 'a';
		int i = a;
		System.out.println(i);
	}
}
