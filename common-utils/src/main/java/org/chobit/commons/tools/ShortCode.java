package org.chobit.commons.tools;

import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 字符串唯一标识
 *
 * @author robin
 */
public final class ShortCode {

	private static final AtomicInteger SEQ = new AtomicInteger(1);
	private static final DecimalFormat FORMAT = new DecimalFormat("00");

	private static final int MAX_PAD_SIZE = 100;

	/**
	 * 基于时间生成随机字符
	 * <p>
	 * 该方法并不安全，如果调用间隔在10纳秒内会出现重复值，多线程或者分布式调用也可能出现重复值
	 *
	 * @return 生成的随机标识符
	 */
	public static synchronized String gen() {
		long v = longValue();
		return Base62.encode(v);
	}


	/**
	 * 基于时间生成大写的随机字符
	 * <p>
	 * 该方法并不安全，如果调用间隔在10纳秒内会出现重复值，多线程或者分布式调用也可能出现重复值
	 *
	 * @return 生成的随机标识符
	 */
	public static synchronized String genUpper() {
		long v = longValue();
		return Base36.encode(v);
	}


	private static long longValue() {
		StringBuilder builder = new StringBuilder(System.nanoTime() / 1000 + "");
		if (SEQ.incrementAndGet() % 10 == 0) {
			SEQ.incrementAndGet();
		}
		builder.append(FORMAT.format(SEQ.get()));
		if ((MAX_PAD_SIZE - 1) == SEQ.get()) {
			SEQ.set(1);
		}
		return Long.parseLong(builder.reverse().toString());
	}

	private ShortCode() {
		throw new UnsupportedOperationException("Private constructor, cannot be accessed.");
	}
}
