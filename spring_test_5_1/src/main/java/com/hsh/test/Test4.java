package com.hsh.test;

import org.springframework.stereotype.Component;

@Component
public class Test4 implements Test {

	@Override
	public void doTest() {
		System.out.println("TEST4");
	}

}
