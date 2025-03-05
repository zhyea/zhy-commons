package org.chobit.commons.codec;


public final class Hex {

	/**
	 * 将字符串转换为16进制数组
	 *
	 * @param str 输入字符串
	 * @return 16进制数组
	 */
	public static byte[] toBytes(String str) {
		if (null == str || str.isEmpty()) {
			return new byte[0];
		}

		byte[] bytes = new byte[str.length() * 2];
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			bytes[i * 2] = (byte) (c >> 8);
			bytes[i * 2 + 1] = (byte) c;
		}
		return bytes;
	}


	/**
	 * 将字节数组转换为16进制字符串
	 *
	 * @param bytes 输入字节数组
	 * @return 16进制字符串
	 */
	public static String toString(byte[] bytes) {
		if (null == bytes) {
			return "";
		}

		StringBuilder builder = new StringBuilder();
		for (byte b : bytes) {
			String hex = Integer.toHexString(0xff & b);
			if (hex.length() == 1) {
				builder.append('0');
			}
			builder.append(hex);
		}
		return builder.toString();
	}


	private Hex() {
		throw new UnsupportedOperationException("Private constructor, cannot be accessed.");
	}
}
