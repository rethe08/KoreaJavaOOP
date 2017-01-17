package adapterpattern;

public class Medic implements MedicInterface {

	@Override
	public void heal() {

		System.out.println("치료치료치료!");
	}

	@Override
	public void move() {

		System.out.println("신나는포이너즈!");
	}

}
