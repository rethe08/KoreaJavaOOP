package booksearch.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import booksearch.dto.BookDTO;

public class BookDAO {

	public ArrayList<BookDTO> select(String keyword) {
		
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();

		try{
			
			Class.forName("com.mysql.jdbc.Driver");	//driver loading
			System.out.println("드라이버 로딩 성공~~");
			
			String id = "java";
			String pw = "java";
			String url = "jdbc:mysql://localhost:3306/library";
			
			Connection con = DriverManager.getConnection(url,id,pw);
			System.out.println("연결성공!!!");
			
			String sql = "select btitle, bauthor, bisbn from book where btitle like ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, "%"+keyword+"%");
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				String title = rs.getString("btitle");
				String isbn = rs.getString("bisbn");
				String author = rs.getString("bauthor");
				BookDTO dto = new BookDTO();
				dto.setBtitle(title);
				dto.setBisbn(isbn);
				dto.setBauthor(author);
				list.add(dto);
			}			
			rs.close();
			pstmt.close();
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
		return list;
	}
	
	public boolean delete(String isbn){
		
		boolean result=false;

		try{
			
			Class.forName("com.mysql.jdbc.Driver");	//driver loading
			//System.out.println("드라이버 로딩 성공~~");
			
			String id = "java";
			String pw = "java";
			String url = "jdbc:mysql://localhost:3306/library";
			
			Connection con = DriverManager.getConnection(url,id,pw);
			//System.out.println("연결성공!!!");
			
			String sql = "delete from book where bisbn = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, isbn);
			
			//결과를 불러오는게 아님
			//delete, update, insert는 db에 영향을 미치는 작업.
			int tmp = pstmt.executeUpdate();
			//결과값이 int로 나옴 -> 영향을 받은 record의 수.			
	
			System.out.println("영향받은 record수 : "+tmp);
			
			if(tmp==1){
			result=true;
			}
			
			pstmt.close();
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
			result = false;
		}
		return result;		
	}
}
