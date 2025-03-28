package org.chobit.commons.codec;


public final class Hex {


    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param bytes 字节数组
     * @return 字节数组对应的十六进制字符串
     */
    public static String toString(byte[] bytes) {
        StringBuilder hexString = new StringBuilder(2 * bytes.length);
        for (byte b : bytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }


    /**
     * 将十六进制字符串转换为字节数组
     *
     * @param hexString 十六进制字符串
     * @return 十六进制字符串对应的字节数组
     */
    public static byte[] toBytes(String hexString) {
        int len = hexString.length();
        byte[] byteArray = new byte[len / 2];

        for (int i = 0, j = 0; i < len; i += 2, j++) {
            String byteString = hexString.substring(i, i + 2);
            byte byteValue = (byte) Integer.parseInt(byteString, 16);
            byteArray[j] = byteValue;
        }

        return byteArray;
    }


    private Hex() {
        throw new UnsupportedOperationException("Private constructor, cannot be accessed.");
    }
}
