package templatemethodpattern;

import java.util.ArrayList;
import java.util.Random;

public class Woman extends Human {
	
	
	//이성친구를 만드는 과정을 프로그램으로 모델링
	public void search(){
		System.out.println("남자를 찾는다");
	}
	public void doAction(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("잘 웃는다");
		list.add("리액션!");
		list.add("몰라");
		list.add("으아아아아아아아");
		
		int num=(new Random()).nextInt(list.size());
		System.out.println(list.get(num));
	}
}
