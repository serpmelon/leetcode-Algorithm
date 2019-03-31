package algorithm;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Util {

	/**
	 * 
	 * <p>
	 * 功能描述 : map对象转换为实体类对象
	 * <p>
	 * 详细说明 : 无
	 * 
	 * @param map
	 * @param clazz
	 * @return
	 * @throws Exception
	 * 
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2017年10月27日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public static <T> T map2Object(Map<String, Object> map, Class<T> clazz) throws Exception {

		T t = clazz.newInstance();
		if (map != null && map.size() > 0) {
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				String propertyName = entry.getKey(); // 属性名
				Object value = entry.getValue();

				// 获取属性对应的对象字段
				Field field = getClassField(clazz, propertyName);
				
				if (field == null)
					continue;

				// 1 直接给属性赋值
				field.setAccessible(true);
				field.set(t, value);
				
				// 2 通过set方法赋值
//				try {
//					String setMethodName = theSetMethodName(field, clazz);
//
//					if (setMethodName != null) //
//						// 调用对象对应的set方法
//						clazz.getMethod(setMethodName, field.getType()).invoke(t, value);
//				} catch (NoSuchMethodException e) {
//					e.printStackTrace();
//				}
			}
		}
		return t;
	}

	private static String theSetMethodName(Field field, Class<?> clazz) {

		Method[] methods = clazz.getMethods();

		String methodName = "set" + field.getName().substring(0, 1).toUpperCase()
				+ field.getName().substring(1);

		for (Method m : methods) {

			if (m.getName().equals(methodName))
				return methodName;
		}

		methodName = "set" + field.getName();

		for (Method m : methods) {

			if (m.getName().equals(methodName))
				return methodName;
		}

		return null;
	}

	/**
	 * 
	 * <p>
	 * 功能描述 : 根据字符串获取类属性域
	 * <p>
	 * 详细说明 : 无
	 * 
	 * @param clazz
	 * @param fieldName
	 * @return
	 * 
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2017年10月27日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	private static Field getClassField(Class<?> clazz, String fieldName) {

		Field[] declaredFields = clazz.getDeclaredFields();
		for (Field field : declaredFields) {
			// 全部大写比较
			if (field.getName().toUpperCase().equals(fieldName.toUpperCase())) {
				return field;
			}
		}

		return null;
	}

	public static void main(String[] args) {

		Map<String, Object> map = new HashMap<>();
		String str = "asd";
		map.put("str", str);
		int aInt = 123;
		map.put("abcInt", aInt);
		Date bDate = new Date();
		map.put("defDate", bDate);
		long l = 123L;
		map.put("gLong", l);

		try {
			Entity entity = map2Object(map, Entity.class);
			System.out.println(entity.getAbcInt());
			System.out.println(entity.getStr());
			System.out.println(entity.getDefDate());
			System.out.println(entity.getgLong());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static class Entity {

		private String str;
		private int abcInt;
		private Date defDate;
		private long gLong;

		public long getgLong() {
			return gLong;
		}

		public void setgLong(long gLong) {
			this.gLong = gLong;
		}

		public String getStr() {
			return str;
		}

		public void setStr(String str) {
			this.str = str;
		}

		public int getAbcInt() {
			return abcInt;
		}

		public void setAbcInt(int abcInt) {
			this.abcInt = abcInt;
		}

		public Date getDefDate() {
			return defDate;
		}

		public void setDefDate(Date defDate) {
			this.defDate = defDate;
		}

	}

}
