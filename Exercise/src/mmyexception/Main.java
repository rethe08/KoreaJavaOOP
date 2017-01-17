package mmyexception;


public class Main  {
	
	public static void test() throws Exception{
		System.out.println("호출돼요!!");
		Class.forName("");
		
		
	}

	public static void main(String[] args) {
		int a = 100;
		try{
			test();
		}catch(Exception e1){
			System.out.println(e1);
		}
		System.out.println(a);
	}

}
