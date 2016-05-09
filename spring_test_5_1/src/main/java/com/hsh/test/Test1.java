package com.hsh.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test1 {

	private String t1 = "@TEST1";
	@Autowired
	private Test2 t2;
	public String getT1() {
		return t1;
	}
	public void setT1(String t1) {
		this.t1 = t1;
	}
	public Test2 getT2() {
		return t2;
	}
	public void setT2(Test2 t2) {
		this.t2 = t2;
	}
}
