package templatemethodpattern;

import java.util.ArrayList;
import java.util.Random;

public class Man extends Human{
	
	//이성친구를 만드는 과정을 프로그램으로 모델링
	public void search(){
		System.out.println("여자를 찾는다");
	}
	public void doAction(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("선물을 산다");
		list.add("꽃을 산다");
		list.add("부모님의 선물을 산다");
		list.add("얘기를 잘 들어준다");
		
		int num=(new Random()).nextInt(list.size());
		System.out.println(list.get(num));
	}
}
