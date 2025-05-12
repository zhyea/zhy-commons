package org.chobit.commons.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.chobit.commons.constans.Symbol.EMPTY;

/**
 * IO操作类
 *
 * @author robin
 */
public final class IoKit {


	private static final Logger logger = LoggerFactory.getLogger(IoKit.class);


	/**
	 * 将数据保存到本地
	 *
	 * @param src        源数据
	 * @param targetPath 本地路径
	 */
	public static void save(byte[] src, String targetPath) {
		try (FileOutputStream out = new FileOutputStream(targetPath)) {
			out.write(src);
			out.flush();
		} catch (IOException e) {
			logger.error("write to {} error.", targetPath, e);
		}
	}


	/**
	 * 读取txt文本文件
	 *
	 * @param path 文件路径
	 * @return 读取到的文本
	 */
	public static String readTxt(String path) {
		try (InputStream input = Files.newInputStream(Paths.get(path));
		     InputStreamReader read = new InputStreamReader(input);
		     BufferedReader bufferedReader = new BufferedReader(read)) {
			StringBuilder builder = new StringBuilder();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				builder.append(line);
			}
			return builder.toString();
		} catch (IOException e) {
			logger.error("read txt file failed. path:{}", path, e);
		}
		return EMPTY;
	}


	/**
	 * 将输入流中的数据写入输出流中
	 *
	 * @param in  输入流
	 * @param out 输出流
	 * @return 读取的总长度
	 * @throws IOException 异常
	 */
	public static long copy(InputStream in, OutputStream out) throws IOException {
		return copy(in, out, Long.MAX_VALUE);
	}


	private static final int IO_BUFFER_SIZE = 4 * 1024;


	/**
	 * 将输入流中的数据写入输出流中
	 *
	 * @param in     输入流
	 * @param out    输出流
	 * @param length 读取的长度
	 * @return 读取的总长度
	 * @throws IOException 异常
	 */
	public static long copy(InputStream in, OutputStream out, long length) throws IOException {
		long copied = 0;
		int len = (int) Math.min(length, IO_BUFFER_SIZE);
		byte[] buffer = new byte[len];
		while (length > 0) {
			len = in.read(buffer, 0, len);
			if (len < 0) {
				break;
			}
			if (out != null) {
				out.write(buffer, 0, len);
			}
			copied += len;
			length -= len;
			len = (int) Math.min(length, IO_BUFFER_SIZE);
		}
		return copied;
	}


	/**
	 * 读取输入流中的数据，并返回字节数组
	 *
	 * @param in     输入流
	 * @param length 读取的长度
	 * @return 输入流中的数据
	 * @throws IOException 异常
	 */
	public static byte[] readBytesAndClose(InputStream in, int length)
			throws IOException {

		if (length <= 0) {
			length = Integer.MAX_VALUE;
		}
		int block = Math.min(IO_BUFFER_SIZE, length);
		try (ByteArrayOutputStream out = new ByteArrayOutputStream(block)) {
			copy(in, out, length);
			return out.toByteArray();
		} finally {
			in.close();
		}
	}


	private IoKit() {
		throw new UnsupportedOperationException("Private constructor, cannot be accessed.");
	}

}
