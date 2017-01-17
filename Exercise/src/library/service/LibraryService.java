package library.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import library.DAO.LibraryDAO;
import library.DTO.LibraryDTO;

public class LibraryService {
	
	public LibraryService() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public boolean checkAvailable(LibraryDTO dto){
		boolean result = false;
		Connection con = null;
		try{
			String id = "java";
			String pw = "java";
			String url= "jdbc:mysql://localhost:3306/library";
			
			con = DriverManager.getConnection(url, id, pw);
			
			LibraryDAO dao = new LibraryDAO(con);
			result = dao.checkAvailable(dto);
		}catch(Exception e1){
			System.out.println(e1);
		}finally{
			try{
				con.close();
			}catch(Exception e2){
				System.out.println(e2);
			}
		}
		
		return result;
	}

	//입력받은 keyword로 검색후 결과list 반환
	public ArrayList<LibraryDTO> checklibrary(String keyword) {
		Connection con = null;
		ArrayList<LibraryDTO> list = new ArrayList<LibraryDTO>();
		try{
			String id = "java";
			String pw = "java";
			String url= "jdbc:mysql://localhost:3306/library";
			
			con = DriverManager.getConnection(url, id, pw);
			
			
			LibraryDAO dao = new LibraryDAO(con);
			list=dao.select(keyword);
		}catch(Exception e1){
			System.out.println(e1);
		}finally{
			try{
				con.close();
			}catch(Exception e2){
				System.out.println(e2);
			}
		}
		return list;
	}

	//입력받은 dto안의 number로 해당 책 삭제
	public boolean deleteBook(LibraryDTO dto){
		
		Connection con = null;
		boolean result2=false;
		
		try{
			
			String id="java";
			String pw="java";
			String url="jdbc:mysql://localhost:3306/library";
			
			con = DriverManager.getConnection(url, id, pw);
			con.setAutoCommit(false);
			
			LibraryDAO dao = new LibraryDAO(con);
			
			LibraryDTO result = dao.select(dto);		//dto안에 있는 사람이 있는지 확인
			if(result!=null){
				result2=dao.delete(dto);			//있으면 dto삭제
			}
			if(result2 && result!=null){
				con.commit();
			}else{
				con.rollback();
			}
			
		}catch(Exception e1){
			System.out.println(e1);
		}finally{
			try{
				con.close();
			}catch(Exception e2){
				System.out.println(e2);
			}
		}
		return result2;
	}
	
	//입력받은 dto추가
	public boolean insertBook(LibraryDTO dto) {

		Connection con = null;
		boolean result2=false;
		
		try{
			
			String id="java";
			String pw="java";
			String url="jdbc:mysql://localhost:3306/library";
			
			con = DriverManager.getConnection(url, id, pw);
			con.setAutoCommit(false);
			
			LibraryDAO dao = new LibraryDAO(con);
			
			LibraryDTO result = dao.select(dto);		//해당 dto가 있는지 확인
			if(result==null){
				result2=dao.insert(dto);}			//없으면 dto insert
			if(result2){
				con.commit();
			}else{
				con.rollback();
			}
			
		}catch(Exception e1){
			System.out.println(e1);
		}finally{
			try{
				con.close();
			}catch(Exception e2){
				System.out.println(e2);
			}
		}
		return result2;
	}
	
	//입력받은 dto안의 number로 해당 책 업데이트
	public boolean updateBook(LibraryDTO dtoBefore, LibraryDTO dtoAfter) {
		
		Connection con = null;
		boolean result2=false;
		
		try{
			
			String id="java";
			String pw="java";
			String url="jdbc:mysql://localhost:3306/library";
			
			con = DriverManager.getConnection(url, id, pw);
			con.setAutoCommit(false);
			
			LibraryDAO dao = new LibraryDAO(con);
			
			LibraryDTO result = dao.select(dtoBefore);		//해당 dto가 있는지 확인
			if(result!=null){
				result2=dao.update(dtoBefore,dtoAfter);			//있으면 dto로 update
			}
			if(result2){
				con.commit();
			}else{
				con.rollback();
			}
			
		}catch(Exception e1){
			System.out.println(e1);
		}finally{
			try{
				con.close();
			}catch(Exception e2){
				System.out.println(e2);
			}
		}
		return result2;
	}

	public LibraryDTO select(LibraryDTO dtoBefore) {
		Connection con = null;	
		LibraryDTO dtoAfter= new LibraryDTO();

		try{
			String id="java";
			String pw="java";
			String url="jdbc:mysql://localhost:3306/library";
			
			con = DriverManager.getConnection(url, id, pw);
			
			LibraryDAO dao = new LibraryDAO(con);
			
			dtoAfter=dao.select(dtoBefore);	
			
		}catch(Exception e1){
			System.out.println(e1);
		}finally{
			try{
				con.close();
			}catch(Exception e2){
				System.out.println(e2);
			}
		}
		return dtoAfter;
	}
}
