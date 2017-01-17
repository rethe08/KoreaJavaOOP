package booksearch.controller;

import java.util.ArrayList;
import java.util.Scanner;

import booksearch.dto.BookDTO;
import booksearch.service.BookService;

public class BookController {
	
	Scanner sc = new Scanner(System.in);
	String keyword;
	String isbn;
	
	public BookController() {
		//여기서부터 프로그램 시작!!
		//입출력을 담당하는 class.
		//scanner
		while(true){
			System.out.println("=== 도서관리 프로그램 ===");
			System.out.println("1. 도서검색(키워드 입력)");
			System.out.println("2. 도서삭제(ISBN 입력");
			System.out.println("3. 종료");
			System.out.print("\n원하시는 작업을 번호로 입력하세요!");
			
			String menu = sc.nextLine();
			
			if(menu.equals("1")){
				System.out.print("키워드를 입력하세요 : ");
				keyword = sc.nextLine();
				//logic을 처리하는 instance를 생성해서 일을 시킨다!
				BookService service = new BookService();
				
				ArrayList<BookDTO> list = service.findBookByKeyword(keyword);				
				
				//출력
				for(BookDTO dto : list){
					System.out.println("제목 : "+dto.getBtitle()+" 저자 : "+dto.getBauthor()+ " ISBN : "+dto.getBisbn());
				}
				System.out.println();
			}else if (menu.equals("2")) {
				
				System.out.print("ISBN을 입력하세요 : ");
				isbn = sc.nextLine();
				//logic을 처리하는 instance를 생성해서 일을 시킨다!
				BookService service = new BookService();
				
				boolean result = service.deleteBookByIsbn(isbn);	
				
				if(result){
					System.out.println("삭제완료");
				}else{
					System.out.println("오류발생!");
				}
								
			}else if (menu.equals("3")){
				System.out.println("프로그램을 종료합니다!!\n");
				break;
			}		
		}
	}
}
