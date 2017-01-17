package ex7;

public class Tea extends Beverage{
	
	static int amount;
	
	public Tea() {
		// TODO Auto-generated constructor stub
	}
	
	public Tea(String name){
		super(name);
	}

	@Override
	public void calcPrice() {
		if(this.getName().equals("Lemon Tea")){
			this.setPrice(1500);amount++;
		}else if (this.getName().equals("Jasmine Tea")) {
			this.setPrice(2000);amount++;		
		}else if (this.getName().equals("Black Tea")) {
			this.setPrice(2500);amount++;
		}
	}

}
