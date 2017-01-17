package booksearch.service;

import java.util.ArrayList;

import booksearch.dao.BookDAO;
import booksearch.dto.BookDTO;

public class BookService {
	
	public BookService() {
	}

	public ArrayList<BookDTO> findBookByKeyword(String keyword) {

		//일반 logic 처리는 여기서 구현
		//DB처리는 DAO를 이용해서 처리.
		
		BookDAO dao = new BookDAO();
		return dao.select(keyword);
	}

	public boolean deleteBookByIsbn(String isbn) {
		BookDAO dao = new BookDAO();
		return dao.delete(isbn);	
	}

	

}
