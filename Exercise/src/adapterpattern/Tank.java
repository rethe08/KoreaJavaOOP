package adapterpattern;

public class Tank implements TerranInterface {

	@Override
	public void attack() {
		System.out.println("퉁! 퉁! 퉁!");
	}

	@Override
	public void move() {
		System.out.println("붕붕붕!");
	}

}
