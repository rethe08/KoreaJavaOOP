package templatemethodpattern;


public abstract class Human {
	//이성친구를 만드는 과정을 프로그램으로 모델링
	
	public void makeFriends(){
		dress();
		search();
		doAction();
		confess();
	}
	
	public void dress(){
		System.out.println("옷을 입어");
	}
	public void confess(){
		System.out.println("고백한다");
	}
	public abstract void search();
	public abstract void doAction();
}
