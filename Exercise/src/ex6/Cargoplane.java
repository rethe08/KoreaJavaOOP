package ex6;

public class Cargoplane extends Plane {

	public Cargoplane() {
		// TODO Auto-generated constructor stub
	}
	
	public Cargoplane(String planeName, int fuelSize){
		super(planeName, fuelSize);

	}
	
	@Override
	public void flight(int distance) {
		
		this.setFuelSize(this.getFuelSize()-distance*5);
	}

}
