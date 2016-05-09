package com.hsh.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Test6 {
	@Autowired
	@Qualifier("test4")
	private Test t;

	public Test getT() {
		return t;
	}

	public void setT(Test t) {
		this.t = t;
	}
}
