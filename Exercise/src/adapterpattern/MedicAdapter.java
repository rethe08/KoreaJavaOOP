package adapterpattern;

public class MedicAdapter implements TerranInterface {
	
	public MedicInterface medic;
	
	public MedicAdapter(MedicInterface medic) {

		this.medic = medic;
		
	}
	@Override
	public void attack() {
		medic.heal();
	}

	@Override
	public void move() {
		medic.move();
	}

}
