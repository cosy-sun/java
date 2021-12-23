package com.sun.design.memento;

public class GameRole {

	public int vit;
	public int atk;
	
	public void init() {
		this.vit = 100;
		this.atk = 100;
	}
	
	public void killBoss() {
		this.vit = 0;
		
		this.atk = 0;
	}
	
	public void show() {
		System.out.println("攻击力：" + this.vit);
		System.out.println("生命之：" + this.atk);
		
	}
	
	public MementoMemo saveGameRole() {
		return new MementoMemo(this.vit, this.atk);
	}
	
	public void recove(MementoMemo memo) {
		this.vit = memo.getVit();
		
		this.atk = memo.getAtk();
	}
	
}
