package ex7;

public class Shop {
	
	static int total=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("***** Coffee Shop 영업 개시 *****\n");
		
		Coffee a = new Coffee("Cappuccino");
		Coffee b = new Coffee("Cafe latte");
		Tea c = new Tea("Jasmine Tea");
		Coffee d = new Coffee("Cafe latte");
		Tea e = new Tea("Black Tea");
		
		a.calcPrice();
		b.calcPrice();
		c.calcPrice();
		d.calcPrice();
		e.calcPrice();
		
		total+=a.getPrice()+b.getPrice()+c.getPrice()+d.getPrice()+e.getPrice();
		
		a.print();
		b.print();
		c.print();
		d.print();
		e.print();
		
		System.out.println(total);
		//System.out.println(a.amount);
		//System.out.println(c.amount);
	}

}
