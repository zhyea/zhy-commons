package org.chobit.commons.tools;

import org.junit.jupiter.api.Test;

public class ShortCodeTest {


	@Test
	public void genUppercase() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(ShortCode.genUppercase());
		}
	}

}
