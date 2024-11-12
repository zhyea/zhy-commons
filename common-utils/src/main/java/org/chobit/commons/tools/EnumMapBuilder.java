package org.chobit.commons.tools;

import org.chobit.commons.contract.CodeDescEnum;
import org.chobit.commons.utils.EnumKit;

import java.util.HashMap;
import java.util.Map;

/**
 * 枚举Map构建
 *
 * @author robin
 */
public class EnumMapBuilder {

	private final Map<String, Map<Integer, String>> enumMap = new HashMap<>(16);


	/**
	 * 新增枚举到Map中
	 *
	 * @param enumType 枚举类
	 * @param excludes 要排除的枚举值
	 * @param <T>      枚举类型
	 */
	public <T extends Enum<?> & CodeDescEnum> EnumMapBuilder add(Class<T> enumType, int... excludes) {
		enumMap.put(enumType.getSimpleName(), EnumKit.mapOf(enumType, excludes));
		return this;
	}


	/**
	 * 构建枚举Map
	 *
	 * @return 枚举map
	 */
	public Map<String, Map<Integer, String>> build() {
		return enumMap;
	}
}
