package adapterpattern;

public class Marine implements TerranInterface {

	@Override
	public void attack() {
		System.out.println("총을 쏜다! 뚜두두 뚜두두!");
	}

	@Override
	public void move() {
		System.out.println("go go go!");
		
	}

}
