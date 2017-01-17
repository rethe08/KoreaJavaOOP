package ex8;

import java.util.HashMap;
import java.util.Map.Entry;

public class Company {

	public static void main(String[] args) {

		
		HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
		
		
		map.put(1, new Secretary("Hilery",1,"secretary",800));
		map.put(2, new Sales("Clinten",2,"sales",1200));
		
		for(Entry<Integer, Employee> p : map.entrySet()){
			System.out.println(p.getValue());
		}
		
		((Secretary) map.get(1)).incentive(100);
		((Sales) map.get(2)).incentive(100);
		
		for(Entry<Integer, Employee> p : map.entrySet()){
			System.out.print(p.getValue());
		}
	}

}
