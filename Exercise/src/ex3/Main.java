package ex3;

import java.util.HashMap;
import java.util.Random;

public class Main {

	public static void main(String[] args) {


		//1~100사이의 난수를 10개 발생 (Random class)
		Random r = new Random();
		
		//발생된 난수를 HashMap에 저장( HashMap class)
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=1;i<11;i++){
			map.put(i, r.nextInt(100)+1);			
		}
		
		//저장된 data의 합계와 평균을 출력
		float sum=0,n=0;
		for(int i=1;i<11;i++){
			sum+=map.get(i);
			n=i;
		}
		System.out.println("합계 :"+sum+"\n평균 :"+sum/n);
	}

}
