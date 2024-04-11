package com.cosy.sun.jdk.design.statustest;

public class Hero {
	
	public static void main(String [] args ) throws Exception{
		Hero hero = new Hero();
		hero.startRun();
		hero.setState(SPEED_UP);
		Thread.sleep(5000);
		hero.setState(SPEED_DOWN);
		Thread.sleep(5000);
		hero.stopRun();
	}
    
    public static final RunState COMMON = new RunStateOne();//正常状态
    
    public static final RunState SPEED_UP = new RunStateTwo();//加速状态
    
    public static final RunState SPEED_DOWN = new RunStateThreee();//减速状态
    
    private RunState state = COMMON;//默认是正常状态
    
    private Thread runThread;//跑动线程
    
    //设置状态
    public void setState(RunState state) {
        this.state = state;
    }
    //停止跑动
    public void stopRun() {
        if (isRunning()) 
        	runThread.interrupt();
        System.out.println("--------------停止跑动---------------");
    }
    //开始跑动
    public void startRun() {
        if (isRunning()) {
            return;
        }
        final Hero hero = this;
        runThread = new Thread(new Runnable() {
            public void run() {
                while (!runThread.isInterrupted()) {
                	state.run(hero);
                }
            }
        });
        System.out.println("--------------开始跑动---------------");
        runThread.start();
    }
    
    private boolean isRunning(){
        return runThread != null && !runThread.isInterrupted();
    }

}