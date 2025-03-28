package org.chobit.commons.codec;

/**
 * 十六进制工具类
 *
 * @author robin
 */
public final class Hex {


	private static final char[] HEX_ARRAY = "0123456789abcdef".toCharArray();

	/**
	 * 将字节数组转换为十六进制字符串
	 *
	 * @param bytes 字节数组
	 * @return 十六进制字符串
	 */
	public static String toStr(byte[] bytes) {
		if (bytes == null) {
			return null;
		}
		char[] hexChars = new char[bytes.length * 2];
		for (int i = 0; i < bytes.length; i++) {
			int v = bytes[i] & 0xFF;
			hexChars[i * 2] = HEX_ARRAY[v >>> 4];
			hexChars[i * 2 + 1] = HEX_ARRAY[v & 0x0F];
		}
		return new String(hexChars);
	}


	/**
	 * 将十六进制字符串转换为字节数组
	 *
	 * @param hexString 十六进制字符串
	 * @return 字节数组
	 */
	public static byte[] toBytes(String hexString) {
		if (hexString == null || hexString.length() % 2 != 0) {
			throw new IllegalArgumentException("Invalid hex string: " + hexString);
		}
		int len = hexString.length();
		byte[] byteArray = new byte[len / 2];

		for (int i = 0; i < len; i += 2) {
			int high = Character.digit(hexString.charAt(i), 16);
			int low = Character.digit(hexString.charAt(i + 1), 16);
			if (high == -1 || low == -1) {
				throw new IllegalArgumentException("Invalid hex character at index " + i);
			}
			byteArray[i / 2] = (byte) ((high << 4) | low);
		}

		return byteArray;
	}

	/**
	 * 私有构造函数，防止实例化。
	 */
	private Hex() {
		throw new UnsupportedOperationException("Hex is a utility class and cannot be instantiated.");
	}
}
