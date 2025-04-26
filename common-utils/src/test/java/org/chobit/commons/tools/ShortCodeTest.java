package org.chobit.commons.tools;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ShortCodeTest {


	@Test
	public void genUpper() throws InterruptedException {
		Set<String> set = new HashSet<>(1000);
		for (int i = 0; i < 1000; i++) {
			String s = ShortCode.genUpper();
			System.out.println(s);
			if (s.length() > 8) {
				System.out.println("----------------------------------------------");
			}
			set.add(s);
			TimeUnit.MILLISECONDS.sleep(100);
		}
		Assertions.assertEquals(1000, set.size());
	}


	@Test
	public void genUpperMultiThread() throws InterruptedException {
		Set<String> set = new HashSet<>(50000);

		Runnable r = () -> {
			for (int i = 0; i < 10000; i++) {
				String code = ShortCode.genUpper();
				System.out.println(code);
				set.add(code);
			}
		};
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();

		TimeUnit.SECONDS.sleep(1);

		Assertions.assertEquals(50000, set.size());
	}

}
