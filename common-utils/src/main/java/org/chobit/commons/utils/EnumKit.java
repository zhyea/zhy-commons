package org.chobit.commons.utils;


import org.chobit.commons.contract.CodeDescEnum;
import org.chobit.commons.contract.CodeEnum;

import java.util.HashMap;
import java.util.Map;

import static org.chobit.commons.constans.Symbol.EMPTY;

/**
 * 枚举工具类
 * <p>
 * 主要用来处理继承了{@link org.chobit.commons.contract.CodeEnum}和{@link org.chobit.commons.contract.CodeDescEnum}接口的枚举
 *
 * @author robin
 */
public final class EnumKit {


	/**
	 * 获取code对应的枚举值
	 *
	 * @param code  枚举值code
	 * @param clazz 枚举类
	 * @return code对应的枚举值
	 */
	public static CodeEnum enumOf(Integer code, Class<? extends Enum<? extends CodeEnum>> clazz) {
		if (null == code) {
			return null;
		}

		if (!CodeEnum.class.isAssignableFrom(clazz)) {
			return null;
		}

		Enum<?>[] values = clazz.getEnumConstants();
		for (Enum<?> e : values) {
			CodeEnum val = (CodeEnum) e;
			if (code.equals(val.getCode())) {
				return val;
			}
		}

		return null;
	}


	/**
	 * 获取code对应的枚举值
	 *
	 * @param code  枚举值code
	 * @param clazz 枚举类
	 * @return code对应的枚举值
	 */
	public static CodeDescEnum enumOf2(Integer code, Class<? extends Enum<? extends CodeDescEnum>> clazz) {
		if (null == code) {
			return null;
		}

		if (!CodeDescEnum.class.isAssignableFrom(clazz)) {
			return null;
		}

		Enum<?>[] values = clazz.getEnumConstants();
		for (Enum<?> e : values) {
			CodeDescEnum val = (CodeDescEnum) e;
			if (code.equals(val.getCode())) {
				return val;
			}
		}

		return null;
	}


	/**
	 * 将枚举类型转换为Map
	 *
	 * @param enumType 枚举类
	 * @param excludes 需要排除的code值
	 * @param <T>      枚举类型
	 * @return CodeDescEnum 对应的 Map
	 */
	public static <T extends Enum<?> & CodeDescEnum> Map<Integer, String> mapOf(Class<T> enumType, int... excludes) {

		T[] values = enumType.getEnumConstants();

		if (null == values) {
			return new HashMap<>(0);
		}

		Map<Integer, String> map = new HashMap<>(values.length);

		for (T v : values) {
			map.put(v.getCode(), v.getDesc());
		}

		for (int code : excludes) {
			map.remove(code);
		}

		return map;
	}


	/**
	 * 根据code获取枚举值
	 *
	 * @param enumType 枚举类型
	 * @param code     枚举对应code值
	 * @param <T>      枚举类型实例
	 * @return 枚举值
	 */
	public static <T extends Enum<?> & CodeDescEnum> T codeOf(Class<T> enumType, Integer code) {

		if (null == code) {
			return null;
		}

		T[] values = enumType.getEnumConstants();

		if (values == null) {
			return null;
		}

		for (T v : values) {
			if (v.getCode() == code) {
				return v;
			}
		}

		return null;
	}


	/**
	 * 获取枚举值code对应的描述
	 *
	 * @param code  枚举值code
	 * @param clazz 枚举类
	 * @return 枚举值对应的desc
	 */
	public static <T extends Enum<?> & CodeDescEnum> String descOf(Integer code, Class<T> clazz) {

		CodeDescEnum v = codeOf(clazz, code);

		if (null != v) {
			return v.getDesc();
		}

		return EMPTY;
	}


	private EnumKit() {
		throw new UnsupportedOperationException("Private constructor, cannot be accessed.");
	}

}
