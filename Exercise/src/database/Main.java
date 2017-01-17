package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		
		//입력받음
		Scanner s = new Scanner(System.in);
		System.out.print("검색어를 입력하세요 : ");
		String keyword = s.nextLine();	//한줄 입력받음.
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");	//driver loading
			System.out.println("드라이버 로딩 성공~~");
			
			String id = "java";
			String pw = "java";
			String url = "jdbc:mysql://localhost:3306/library";
			
			Connection con = DriverManager.getConnection(url,id,pw);
			System.out.println("연결성공!!!");
			
			String sql = "select btitle, bauthor from book where btitle like ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, "%"+keyword+"%");
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				String title = rs.getString("btitle");
				String author = rs.getString("bauthor");
				System.out.println(title+", " + author);

			}			
			
			rs.close();
			pstmt.close();
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
			
		}
		s.close();
	}

}
