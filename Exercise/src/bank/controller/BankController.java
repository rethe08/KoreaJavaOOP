package bank.controller;

import java.util.ArrayList;
import java.util.Scanner;

import bank.DTO.BankDTO;
import bank.service.BankService;

public class BankController {
	
	Scanner sc = new Scanner(System.in);
	
	
	public BankController() {
		
		String menu=null;
		
		do{
			System.out.println("=== 은행 업무 ===");
			System.out.println("1. 조회");
			System.out.println("2. 입금");
			System.out.println("3. 출금");
			System.out.println("4. 이체");
			System.out.println("5. 종료");
			System.out.println("원하시는 업무를 숫자로 입력하세요 : ");
			
			menu = sc.nextLine();
			
			if(menu.equals("1")){
				
				System.out.print("조회할 계좌주 이름을 입력하세요 : ");
				String name=sc.nextLine();
				
				BankService service = new BankService();
				
				ArrayList<BankDTO> list = service.checkAccount(name);

				for(BankDTO dto : list){
					System.out.println("이름 : " +dto.getName()+" 잔고 : "+dto.getBalance());
				}
				System.out.println();
			}			
			if(menu.equals("2")){
							
				System.out.print("입금할 계좌주 이름을 입력하세요 : ");
				String name=sc.nextLine();
				System.out.print("입금할 금액을 입력하세요 : ");
				int amount=sc.nextInt();
				
				BankService service = new BankService();
				
				boolean result = service.deposit(name, amount);
				
				if(result){
					System.out.println("입금완료");
				}else{
					System.out.println("오류발생");
				}
				//입금
			}
			if(menu.equals("3")){
				System.out.print("출금할 계좌주 이름을 입력하세요 : ");
				String name=sc.nextLine();
				System.out.print("출금할 금액을 입력하세요 : ");
				int amount=sc.nextInt();
				
				BankService service = new BankService();
				
				boolean result = service.withdraw(name, amount);
				
				if(result){
					System.out.println("출금완료");
				}else{
					System.out.println("오류발생-잔고를 확인하세요!");
				}
				//출금
			}
			if(menu.equals("4")){
				System.out.print("돈을 보낼 계좌주 이름을 입력하세요 : ");
				String nameSender=sc.nextLine();
				System.out.print("돈을 받을 계좌주 이름을 입력하세요 : ");
				String nameReceiver=sc.nextLine();
				System.out.print("이체할 금액을 입력하세요 : ");
				int amount=sc.nextInt();
				
				BankService service = new BankService();
				
				boolean result = service.transfer(nameSender,nameReceiver, amount);
				
				if(result){
					System.out.println("이체완료");
				}else{
					System.out.println("오류발생-잔고를확인하세요!");
				}
				//이체
			}
			if(menu.equals("5")){
				System.out.println("종료됩니다!\n");
			}
			
		}while(!menu.equals("5"));
		
	}

}
