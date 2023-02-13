package application;

public class Ship {
	private String name;
	public int length;
	public int health;
	public boolean sunk = false;
	
	public Ship(String name, int length) {
		this.name = name;
		this.length = length;
		this.health = length;
	}
	
	public String getName() {
		return name;
	}

	public boolean sunk() {
		if(health == 0) {
			sunk = true;
			return true;
		}
		return false;
	}
	
	public void hit() {
		health--;
	}
}
