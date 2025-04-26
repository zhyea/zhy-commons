package org.chobit.commons.tools;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

import static org.chobit.commons.utils.StrKit.isBlank;

/**
 * Base36编码解码工具类
 *
 * @author robin
 * @since 2025/4/18 23:27
 */
public final class Base36Codec {


	public static String encode(byte[] bytes) {
		BigInteger bigInt = new BigInteger(bytes);
		String t = bigInt.toString(36);
		if (t.charAt(0) == '-') {
			StringBuilder builder = new StringBuilder(t);
			builder.setCharAt(0, 'f');
			return builder.toString();
		} else {
			return "z" + t;
		}
	}


	public static String encode(String src) {
		if (isBlank(src)) {
			return src;
		}
		byte[] bytes = src.getBytes(StandardCharsets.UTF_8);
		return encode(bytes);
	}


	public static byte[] decode(String encodedStr) {

		String tmp;
		if (encodedStr.charAt(0) == 'z') {
			tmp = encodedStr.substring(1);
		} else {
			tmp = "-" + encodedStr.substring(1);
		}
		BigInteger bigInt = new BigInteger(tmp, 36);

		return bigInt.toByteArray();
	}


	public static String decodeToStr(String encodedStr) {
		byte[] bytes = decode(encodedStr);
		return new String(bytes, StandardCharsets.UTF_8);
	}
}
