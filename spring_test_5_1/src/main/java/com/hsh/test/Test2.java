package com.hsh.test;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

@Component
public class Test2 {
	private String t2 = "@TEST2";
	@Inject
	private Test3 t3;
	
	public Test2() { }
	
	public Test2(String t2, Test3 t3){
		this.t2 = t2;
		this.t3 = t3;
	}
	
	public String getT2() {
		return t2;
	}
	public void setT2(String t2) {
		this.t2 = t2;
	}
	public Test3 getT3() {
		return t3;
	}
	public void setT3(Test3 t3) {
		this.t3 = t3;
	}
}
