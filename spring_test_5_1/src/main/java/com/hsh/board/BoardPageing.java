package com.hsh.board;


/*@Component*/
public class BoardPageing {
	private int startNum;
	private int lastNum;
	private int curBlock;
	private int totalBlock;
	
	public void setMember(int curPage, int perPage, int total){
		int totalPage = sum(total, perPage);
		int perBlock = 5;
		totalBlock = sum(totalPage, perBlock);
		curBlock = sum(curPage, perBlock);
		startNum = (curBlock - 1) * perBlock + 1;
		lastNum = curBlock * perBlock;
		if(curBlock == totalBlock){
			lastNum = totalPage;
		}
	}
	private int sum(int num1, int num2) {
		int result = 0;
		if (num1 % num2 == 0) {
			result = num1 / num2;
		} else {
			result = num1 / num2 + 1;
		}
		return result;
	}
	
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getLastNum() {
		return lastNum;
	}
	public void setLastNum(int lastNum) {
		this.lastNum = lastNum;
	}
	public int getCurBlock() {
		return curBlock;
	}
	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}
	public int getTotalBlock() {
		return totalBlock;
	}
	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}
}
