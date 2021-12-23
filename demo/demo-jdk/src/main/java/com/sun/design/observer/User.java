package com.sun.design.observer;

public class User implements Observer{

	private String message;
	private String name;
	
	public User(String name) {
		this.name = name;
	}
	
	@Override
	public void update(String message) {
		this.message = message;
		System.out.println(name + "  " + message);
	}

	public static void main (String [] args) {
		Server server = new Server();
		User user = new User("h");
		server.register(new User("s"));
		server.register(new User("z"));
		server.register(user);
		server.setInformation("hahahah");
		server.remove(user);
		server.setInformation("ssss");
	}
	
}
