package ex6;

public class PlaneTest {

	public static void main(String[] args) {
		Airplane a = new Airplane("L747", 1000);
		Cargoplane b = new Cargoplane("C40", 1000);
		System.out.println("Plane"+"          fuelSize");
		System.out.println("--------------------------");
		System.out.println(a);
		System.out.println(b);
		System.out.println();
		
		a.flight(100);
		b.flight(100);
		
		System.out.println("Plane"+"          fuelSize");
		System.out.println("--------------------------");
		System.out.println(a);
		System.out.println(b);
		System.out.println();
		
		a.refuel(200);
		b.refuel(200);
		
		System.out.println("Plane"+"          fuelSize");
		System.out.println("--------------------------");
		System.out.println(a);
		System.out.println(b);
		
		
	}

}
