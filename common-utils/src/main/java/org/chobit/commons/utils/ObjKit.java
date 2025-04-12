package org.chobit.commons.utils;

import java.util.Objects;

/**
 * 对象操作工具类
 *
 * @author robin
 */
public final class ObjKit {


	/**
	 * 判断两个对象是否不相等
	 *
	 * @param a 对象a
	 * @param b 对象b
	 * @return true 不相等， false 相等
	 */
	public static boolean nonEquals(final Object a, final Object b) {
		return !Objects.equals(a, b);
	}


	private ObjKit() {
		throw new UnsupportedOperationException("Private constructor, cannot be accessed.");
	}

}
