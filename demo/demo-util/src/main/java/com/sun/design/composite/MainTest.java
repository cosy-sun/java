package com.sun.design.composite;

public class MainTest {

	public static void main(String[] args) {
		ImageKill a = new ImageKill("a");
		ImageKill b = new ImageKill("b");
		ImageKill c = new ImageKill("c");
		ImageKill d = new ImageKill("d");
		ImageKill e = new ImageKill("e");
		
		TextKill ta = new TextKill("ta");
		TextKill tb = new TextKill("tb");
		TextKill tc = new TextKill("tc");
		TextKill td = new TextKill("td");
		TextKill te = new TextKill("te");
		
		FlodKill fa = new FlodKill("fa");
		FlodKill fb = new FlodKill("fb");
		
		fb.add(a);
		fb.add(b);
		fb.add(c);
		fb.add(d);
		fb.add(e);
		
		fb.add(ta);
		fb.add(tb);
		fb.add(tc);
		fb.add(td);
		fb.add(te);
		fa.add(a);
		fa.add(fb);
		
		fa.killVirus(fa);
		
	}
	
}
