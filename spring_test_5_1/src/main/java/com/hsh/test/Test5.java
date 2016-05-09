package com.hsh.test;

import org.springframework.stereotype.Component;

@Component
public class Test5 implements Test {

	@Override
	public void doTest() {
		System.out.println("TEST5");
	}

}
