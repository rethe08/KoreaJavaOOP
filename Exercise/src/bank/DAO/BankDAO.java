package bank.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bank.DTO.BankDTO;

public class BankDAO {
	
	public BankDAO() {
	}

	public boolean deposit(String name, int amount) {

		boolean result=false;
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String id="java";
			String pw="java";
			String url="jdbc:mysql://localhost:3306/library";
			
			Connection con = DriverManager.getConnection(url,id,pw);
			con.setAutoCommit(false);
			
			String sql = "select balance from bank where name=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, name);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int tmpMoney=rs.getInt("balance");
			
			sql="update bank set balance=? where name=?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, tmpMoney+amount);
			pstmt.setString(2, name);
			
			int tmp = pstmt.executeUpdate();
			
			if(tmp==1){
				result=true;
			}
			con.commit();
			
			rs.close();
			pstmt.close();
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
			result=false;
		}
		return result;
	}

	public boolean withdraw(String name, int amount) {
		boolean result=false;
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String id="java";
			String pw="java";
			String url="jdbc:mysql://localhost:3306/library";
			
			Connection con = DriverManager.getConnection(url,id,pw);
			con.setAutoCommit(false);
			
			String sql = "select balance from bank where name=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, name);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int tmpMoney=rs.getInt("balance");
			
			sql="update bank set balance=? where name=?";
			
			pstmt = con.prepareStatement(sql);
			if(tmpMoney-amount>=0){
				pstmt.setInt(1, tmpMoney-amount);
				pstmt.setString(2, name);
				
				int tmp = pstmt.executeUpdate();
				
				if(tmp==1){
					result=true;
				}
				con.commit();
			}else{
				con.rollback();
			}
			rs.close();
			pstmt.close();
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
			result=false;
		}
		
		return result;
	}

	public boolean transfer(String nameSender, String nameReceiver, int amount) {
		boolean result=false;
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String id="java";
			String pw="java";
			String url="jdbc:mysql://localhost:3306/library";
			
			Connection con = DriverManager.getConnection(url,id,pw);
			con.setAutoCommit(false);
			
			String sql = "select balance from bank where name=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, nameSender);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int tmpMoney=rs.getInt("balance");
			
			sql="update bank set balance=? where name=?";
			
			pstmt = con.prepareStatement(sql);
			if(tmpMoney-amount>=0){
				pstmt.setInt(1, tmpMoney-amount);
				pstmt.setString(2, nameSender);
				
				int tmp = pstmt.executeUpdate();
				
				sql="update bank set balance=? where name=?";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, tmpMoney+amount);
				pstmt.setString(2, nameReceiver);
				
				tmp+=pstmt.executeUpdate();
				
				if(tmp==2){
					result=true;
				}
				con.commit();
			}else{
				con.rollback();
			}
			rs.close();
			pstmt.close();
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
			result=false;
		}
		
		return result;

	}

	public ArrayList<BankDTO> select(String name) {
		ArrayList<BankDTO> list = new ArrayList<BankDTO>();

		try{
			
			Class.forName("com.mysql.jdbc.Driver");	//driver loading
			
			String id = "java";
			String pw = "java";
			String url = "jdbc:mysql://localhost:3306/library";
			
			Connection con = DriverManager.getConnection(url,id,pw);			
			String sql = "select name, balance from bank where name like ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, "%"+name+"%");
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				String nameTmp = rs.getString("name");
				int balance = rs.getInt("balance");
				BankDTO dto = new BankDTO();
				dto.setName(nameTmp);
				dto.setBalance(balance);
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

	

}
