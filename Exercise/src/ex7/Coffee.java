package ex7;

public class Coffee extends Beverage{
	
	static int amount;
	
	public Coffee() {
		// TODO Auto-generated constructor stub
	}
	
	public Coffee(String name){
		super(name);
	}

	@Override
	public void calcPrice() {
		if(this.getName().equals("Americano")){
			this.setPrice(1500);amount++;
		}else if (this.getName().equals("Cafe latte")) {
			this.setPrice(2500);amount++;		
		}else if (this.getName().equals("Cappuccino")) {
			this.setPrice(3000);amount++;
		}
	}

}
