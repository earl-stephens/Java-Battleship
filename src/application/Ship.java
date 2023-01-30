package application;

public class Ship {
	public String name;
	public int length;
	public int health;
	
	public Ship(String name, int length) {
		this.name = name;
		this.length = length;
		this.health = length;
	}
	
	public boolean sunk() {
		if(health == 0) {
		return true;
		}
		return false;
	}
	
	public void hit() {
		health--;
	}
}
