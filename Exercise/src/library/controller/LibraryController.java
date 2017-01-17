package library.controller;

import java.util.ArrayList;
import java.util.Scanner;

import library.DTO.LibraryDTO;
import library.service.LibraryService;

public class LibraryController {
	
	Scanner sc = new Scanner(System.in);
	private LibraryService service = new LibraryService();
	
	public LibraryController() {
		
		String menu=null;
		
		do{
			System.out.println("**** 도서관리 프로그램 ****");
			System.out.println("1. 도서입력");
			System.out.println("2. 도서수정");
			System.out.println("3. 도서삭제");
			System.out.println("4. 도서검색");
			System.out.println("5. 도서대여");
			System.out.println("6. 도서반납");
			System.out.println("7. 도서종료");
			System.out.print("원하시는 작업을 숫자로 입력하세요 : ");
			menu = sc.nextLine();

			if(menu.equals("1")){
				LibraryDTO dto = new LibraryDTO();
				System.out.println("도서 추가입니다!!!!!");
				System.out.print("도서번호 입력 : ");
				dto.setBnumber(sc.nextInt());
				sc.nextLine();
				System.out.print("도서제목 입력 : ");
				dto.setBname(sc.nextLine());
				System.out.print("작가 입력 : ");
				dto.setBauthor(sc.nextLine());
				System.out.print("가격 입력 : ");
				dto.setBprice(sc.nextInt());
				sc.nextLine();
				dto.setBstatus("available");
				//입력
				
				boolean result = service.insertBook(dto);
				
				if(result){
					System.out.println("추가완료");
				}else{
					System.out.println("오류발생 - 번호를 확인하세요!");
				}
				System.out.println();
			}
			if(menu.equals("2")){
				//수정
				LibraryDTO dtoBefore = new LibraryDTO();
				LibraryDTO dtoAfter = new LibraryDTO();
				System.out.println("도서 수정입니다!!!!!!!");
				System.out.print("수정할 도서번호 입력 : ");
				dtoBefore.setBnumber(sc.nextInt());
				System.out.print("수정후 도서번호 입력 : ");
				dtoAfter.setBnumber(sc.nextInt());
				sc.nextLine();
				System.out.print("수정후 도서제목 입력 : ");
				dtoAfter.setBname(sc.nextLine());
				System.out.print("수정후 작가 입력 : ");
				dtoAfter.setBauthor(sc.nextLine());
				System.out.print("수정후 가격 입력 : ");
				dtoAfter.setBprice(sc.nextInt());
				sc.nextLine();
				dtoAfter.setBstatus("available");
				//입력
				
				boolean result = service.updateBook(dtoBefore,dtoAfter);
				
				if(result){
					System.out.println("수정완료");
				}else{
					System.out.println("오류발생 - 번호를 확인하세요!");
				}
				System.out.println();
			}
			if(menu.equals("3")){
				//삭제
				LibraryDTO dto = new LibraryDTO();
				System.out.print("삭제할 책 번호 : ");
				dto.setBnumber(sc.nextInt());
				sc.nextLine();
				
				boolean result = service.deleteBook(dto);
				
				if(result){
					System.out.println("삭제완료");
				}else{
					System.out.println("오류발생 - 번호를 확인하세요!");
				}
				System.out.println();
			}
			if(menu.equals("4")){
				//검색
				System.out.println("검색할 keyword를 입력하세요!");
				String keyword = sc.nextLine();
				
				ArrayList<LibraryDTO> list = service.checklibrary(keyword);
				
				for(LibraryDTO dto : list){
					System.out.println("번호 : "+dto.getBnumber()+" 제목: "+dto.getBname()+
							" 저자: "+dto.getBauthor()+ " 가격: "+dto.getBprice() + " 상태: "+dto.getBstatus());
				}
				System.out.println();
				
			}
			if(menu.equals("5")){
				//대여
				LibraryDTO dtoBefore = new LibraryDTO();
				LibraryDTO dtoAfter = new LibraryDTO();
				System.out.println("도서 대여입니다!!!!!!!");
				System.out.print("대여할 도서번호 입력 : ");
				dtoBefore.setBnumber(sc.nextInt());
				sc.nextLine();
				
				if(service.checkAvailable(dtoBefore))
				{
					System.out.println("대여 가능합니다.");
					
					dtoAfter = service.select(dtoBefore);
					
					dtoAfter.setBstatus("Unavailable");
					
					boolean result = service.updateBook(dtoBefore,dtoAfter);
					if(result){
						System.out.println("대출완료");
					}else{
						System.out.println("오류발생!");
					}	
				}else{
					System.out.println("이미 대출 중이거나 존재하지 않습니다.");
				}
				System.out.println();
			}
			if(menu.equals("6")){
				//반납
				LibraryDTO dtoBefore = new LibraryDTO();
				LibraryDTO dtoAfter = new LibraryDTO();
				System.out.println("도서 반납입니다!!!!!!!");
				System.out.print("반납할 도서번호 입력 : ");
				dtoBefore.setBnumber(sc.nextInt());
				sc.nextLine();
				
				dtoAfter = service.select(dtoBefore);
				
				dtoAfter.setBstatus("available");
				
				boolean result = service.updateBook(dtoBefore,dtoAfter);
				if(result){
					System.out.println("반납완료");
				}else{
					System.out.println("오류발생!");
				}	
				System.out.println();		
			}
			if(menu.equals("7")){
				System.out.println("프로그램이 종료됩니다.");				
			}
			
		}while(!menu.equals("7"));
	}

}
