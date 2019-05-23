package hms.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import hms.hotel.db.JdbcUtils;
import hms.hotel.dto.Hotel;

public class HotelDAO {
	
	public int insertHotel(Hotel dto) {
		String sql = "insert into hotel values(?,?,?)";
		
				// ���������� ������ ��ü�� ����
		//JdbcUtils jdbc = new JdbcUtils();
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;	
		
		try {
			conn = JdbcUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhone());
			pstmt.setInt(3, dto.getPass());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,pstmt,null);
		}
		return result;
	}
	
	public ArrayList<Hotel> selectHotelList(){
		String sql = "select * from hotel order by name asc";
		ArrayList<Hotel> list = new ArrayList<Hotel>();
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			//1�ܰ� : ����̹� �ε�
			
			//2�ܰ� : Connection ��ü ����
			conn = JdbcUtils.getConnection();
			
			//3�ܰ� : ��������
			pstmt = conn.prepareStatement(sql);
			
			//4�ܰ� : ���ó��
			rs = pstmt.executeQuery();
			Hotel mem = null;
			
			while(rs.next()) {
				mem = new Hotel(
								 rs.getString("name"), 
								 rs.getString("phone"),
								 rs.getInt("pass"));
				
				list.add(mem);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//5�ܰ� : �ڿ��ݱ�
			close(conn, pstmt, rs);
		}
				
		return list;
	}
	
	public int updateHotel(Hotel updateHotel) {
		int result = 0;
		String sql = "update hotel set name = ?, pass = ? where phone = ?";		
		PreparedStatement pstmt = null;
		Connection conn = null;
		
		try {
			//1�ܰ� : ����̺� �ε�
			
			//2�ܰ� : Connection ��ü ����
			conn = JdbcUtils.getConnection();
			
			//3�ܰ� : ��������
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, updateHotel.getName());
			pstmt.setInt(2, updateHotel.getPass());
			pstmt.setString(3, updateHotel.getPhone());
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//4�ܰ� : �ڿ��� �ݱ�
			close(conn, pstmt, null);
		}	
		return result;
	}
	private void close(Connection conn2, PreparedStatement pstmt, Object object) {		
	}
	
	public int deleteHotel(Hotel h) {
		String sql = "delete hotel where name =? and phone = ? and pass = ?";
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//1�ܰ� : ����̺� �ε�
			
			//2�ܰ� : Connection ��ü ����
			conn = JdbcUtils.getConnection();		
			//3�ܰ� : ��������
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, h.getName());
			pstmt.setString(2, h.getPhone());
			pstmt.setInt(3, h.getPass());
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//4�ܰ� : �ڿ��� �ݱ�
			close(conn, pstmt, null);
		}
		return result;
	}
	private Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
	public Hotel selectOldHotel(Hotel h) {
		String sql = "select * from hotel where name = ? and phone = ? and pass = ?";
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		Hotel oldHotel = null;
		
		try {
			//1�ܰ� : ����̹� �ε�
			
			//2�ܰ� : Connection ��ü ����
			conn = JdbcUtils.getConnection();
			
			//3�ܰ� : ���� ����
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, h.getName());
			pstmt.setString(2, h.getPhone());
			pstmt.setInt(3, h.getPass());
			rs = pstmt.executeQuery();
			
			//4�ܰ� : ���ó��
			if(rs.next()) {
				oldHotel = new Hotel(
									   rs.getString("name"), 
									   rs.getString("phone"),
									   rs.getInt("pass"));
			}			
		}catch(Exception e) {
			e.printStackTrace();	
		}finally {
			close(conn, pstmt, rs);
		}				
		return oldHotel;		
	}		
}