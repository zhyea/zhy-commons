package org.chobit.commons.tools;

import org.junit.jupiter.api.Test;

/**
 * Base36编码解码测试
 *
 * @author robin
 * @since 2025/4/26 22:02
 */
public class Base36CodecTest {

	@Test
	public void codec() {
		String src = "黄河远上白云间一片孤城万仞山";
		String encode = Base36Codec.encode(src);
		System.out.println(encode);
		String decodeStr = Base36Codec.decodeToStr(encode);
		System.out.println(decodeStr);
	}

}
