package org.chobit.commons.model;

import java.util.Objects;

/**
 * 引用对象包装类
 * <p>
 * 用于处理直接类型或字符串，以解决直接类型或字符串被修改后引用丢失的问题
 *
 * @author robin
 */
public class Ref<T> {


	/**
	 * 被包装的值
	 */
	private final T value;


	/**
	 * 私有化构造器
	 *
	 * @param value 需要被引用的值
	 */
	private Ref(T value) {
		this.value = value;
	}


	/**
	 * 获取Ref对象
	 *
	 * @param value 被引用的值
	 * @param <T>   被引用的对象的类型
	 * @return Ref对象
	 */
	public static <T> Ref<T> of(T value) {
		return new Ref<>(value);
	}


	/**
	 * 获取被引用的对象
	 *
	 * @return 被引用的对象
	 */
	public T get() {
		return value;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Ref<?> reference = (Ref<?>) o;
		return Objects.equals(value, reference.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}


	@Override
	public String toString() {
		return "Ref(" + value + ')';
	}
}
