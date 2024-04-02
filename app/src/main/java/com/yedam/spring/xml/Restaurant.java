package com.yedam.spring.xml;

public class Restaurant {
	
	private Chef chef;
	
	//chef 메소드 호출
	public void run() {
		chef.coocking();
	}

	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
}
