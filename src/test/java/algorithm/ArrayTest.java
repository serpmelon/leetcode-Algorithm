package algorithm;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import com.togo.algorithm.easy.array.RotateArray189;

public class ArrayTest {

	public static void main(String[] args) {

		ConcurrentHashMap c = null;
		CopyOnWriteArrayList d = null;
		ThreadLocal ab = null;
		
		String a = "123";
		String b = new String("123");
		System.out.println(a == b);
		
		String[] e = {"a", "b", "c"};
		String[] f = new String[4];
		System.arraycopy(e, 0, f, 0, 1);
		System.arraycopy(e, 1, f, 1 + 1, 2);
		
		printArray(f);
	}
	
	private static void printArray(Object ...obj) {
		for(Object o : obj) {
			System.out.println(o);
		}
	}
}
