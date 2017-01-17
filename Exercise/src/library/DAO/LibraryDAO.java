package library.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import library.DTO.LibraryDTO;

public class LibraryDAO {
	
	private Connection con;
	
	

	
	public LibraryDAO() {
		// TODO Auto-generated constructor stub
	}
	public LibraryDAO(Connection con) {
		this.con=con;
	}
	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	
	public ArrayList<LibraryDTO> select(String keyword) {
		ArrayList<LibraryDTO> list = new ArrayList<LibraryDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			String sql = "select bnumber,bname,bauthor,bprice,bstatus from library where bname like ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, "%"+keyword+"%");
			rs=pstmt.executeQuery();
			while(rs.next()){
				int bnumTmp = rs.getInt("bnumber");
				String bnameTmp = rs.getString("bname");
				String bauthorTmp = rs.getString("bauthor");
				int bpriceTmp = rs.getInt("bprice");
				String bstatusTmp = rs.getString("bstatus");
				LibraryDTO dto = new LibraryDTO();
				
				dto.setBnumber(bnumTmp);
				dto.setBname(bnameTmp);
				dto.setBauthor(bauthorTmp);
				dto.setBprice(bpriceTmp);
				dto.setBstatus(bstatusTmp);
				list.add(dto);
			}			
			
		}catch(Exception e){
			System.out.println(e);
		}finally{
			try{
			rs.close();
			pstmt.close();
			}catch(Exception e2){
				System.out.println(e2);
			}

		}
		return list;
	}
	
	public LibraryDTO select(LibraryDTO dto) {
		LibraryDTO result = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			String sql="select bnumber, bname, bauthor, bprice, bstatus from library where bnumber=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBnumber());
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				result = new LibraryDTO();
				result.setBnumber(rs.getInt("bnumber"));
				result.setBname(rs.getString("bname"));
				result.setBauthor(rs.getString("bauthor"));
				result.setBprice(rs.getInt("bprice"));
				result.setBstatus(rs.getString("bstatus"));
			}
			
		}catch(Exception e1){
			System.out.println(e1);
		}finally{
			try{
				rs.close();
				pstmt.close();
			}catch(Exception e2){
				System.out.println(e2);
			}
		}
		return result;
	}
	
	public boolean delete(LibraryDTO dto) {
		boolean result = false;
		PreparedStatement pstmt = null;
		try{
			String sql="delete from library where bnumber=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBnumber());
			
			int num=pstmt.executeUpdate();
			
			if(num==1)
				result=true;
			
		}catch(Exception e1){
			System.out.println(e1);
		}finally{
			try{
				pstmt.close();
			}catch(Exception e2){
				System.out.println(e2);
			}
		}
		return result;
	}
	
	public boolean update(LibraryDTO dtoBefore, LibraryDTO dtoAfter) {
		boolean result = false;
		PreparedStatement pstmt = null;
		try{
			String sql="update library set bnumber=?,bname=?,bauthor=?,bprice=?,bstatus=? where bnumber=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, dtoAfter.getBnumber());
			pstmt.setString(2, dtoAfter.getBname());
			pstmt.setString(3, dtoAfter.getBauthor());
			pstmt.setInt(4, dtoAfter.getBprice());
			pstmt.setString(5, dtoAfter.getBstatus());
			pstmt.setInt(6, dtoBefore.getBnumber());
			int num=pstmt.executeUpdate();
			
			if(num==1)
				result=true;
			
		}catch(Exception e1){
			System.out.println(e1);
		}finally{
			try{
				pstmt.close();
			}catch(Exception e2){
				System.out.println(e2);
			}
		}
		return result;
	}
	public boolean insert(LibraryDTO dto) {
		boolean result = false;
		PreparedStatement pstmt = null;
		try{
			String sql="insert into library values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBnumber());
			pstmt.setString(2, dto.getBname());
			pstmt.setString(3, dto.getBauthor());
			pstmt.setInt(4, dto.getBprice());
			pstmt.setString(5, dto.getBstatus());
			int num=pstmt.executeUpdate();
			
			if(num==1)
				result=true;
			
		}catch(Exception e1){
			System.out.println(e1);
		}finally{
			try{
				pstmt.close();
			}catch(Exception e2){
				System.out.println(e2);
			}
		}
		return result;
	}
	public boolean checkAvailable(LibraryDTO dto) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		boolean result=false;
		try{
			String sql = "select bstatus from library where bnumber=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBnumber());
			rs=pstmt.executeQuery();
			if(rs.next()){
				if(rs.getString("bstatus").equals("available")){
					result=true;
				}
				
			}
		}catch(Exception e){
			System.out.println(e);
		}finally{
			try{
			rs.close();
			pstmt.close();
			}catch(Exception e2){
				System.out.println(e2);
			}

		}
		return result;
	}
}
