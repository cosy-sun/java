package com.cosy.sun.design.memento;

public class Manager {
	
	public static void main(String[] args) {
		GameRole gameRolw = new GameRole();
		gameRolw.init();
		gameRolw.show();
		
		MementoMemo saveGameRole = gameRolw.saveGameRole();
		
		Manager manager = new Manager();
		manager.setMemo(saveGameRole);
		
		gameRolw.killBoss();
		
		gameRolw.show();
		
		gameRolw.recove(manager.getMemo());
		
		gameRolw.show();
		
	}
	
	private MementoMemo memo;

	public MementoMemo getMemo() {
		return memo;
	}

	public void setMemo(MementoMemo memo) {
		this.memo = memo;
	}
	
	
	
}
