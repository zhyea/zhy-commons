package org.chobit.commons.utils;

import java.util.HashMap;
import java.util.Map;


/**
 * 类处理相关工具
 *
 * @author robin
 */
public final class ClassUtils {


	/**
	 * 直接类型和对应包装类的映射关系
	 */
	private static final Map<Class<?>, Class<?>> primitiveWrapperMap = new HashMap<>();

	static {
		primitiveWrapperMap.put(Boolean.TYPE, Boolean.class);
		primitiveWrapperMap.put(Byte.TYPE, Byte.class);
		primitiveWrapperMap.put(Character.TYPE, Character.class);
		primitiveWrapperMap.put(Short.TYPE, Short.class);
		primitiveWrapperMap.put(Integer.TYPE, Integer.class);
		primitiveWrapperMap.put(Long.TYPE, Long.class);
		primitiveWrapperMap.put(Double.TYPE, Double.class);
		primitiveWrapperMap.put(Float.TYPE, Float.class);
		primitiveWrapperMap.put(Void.TYPE, Void.TYPE);
	}


	/**
	 * 包装类和对应直接类型的映射关系
	 */
	private static final Map<Class<?>, Class<?>> wrapperPrimitiveMap = new HashMap<>();

	static {
		for (final Map.Entry<Class<?>, Class<?>> entry : primitiveWrapperMap.entrySet()) {
			final Class<?> primitiveClass = entry.getKey();
			final Class<?> wrapperClass = entry.getValue();
			if (!primitiveClass.equals(wrapperClass)) {
				wrapperPrimitiveMap.put(wrapperClass, primitiveClass);
			}
		}
	}


	/**
	 * 判断一个类是不是直接类型或包装类
	 *
	 * @param type 要判断的类型
	 * @return true 是, false 否
	 */
	public static boolean isPrimitiveOrWrapper(final Class<?> type) {
		if (type == null) {
			return false;
		}
		return type.isPrimitive() || isPrimitiveWrapper(type);
	}


	/**
	 * 判断一个类是不是包装类
	 *
	 * @param type 要判断的类型
	 * @return true 是 , false 否
	 */
	public static boolean isPrimitiveWrapper(final Class<?> type) {
		return wrapperPrimitiveMap.containsKey(type);
	}


	private ClassUtils() {
		throw new UnsupportedOperationException("Private constructor, cannot be accessed.");
	}

}
