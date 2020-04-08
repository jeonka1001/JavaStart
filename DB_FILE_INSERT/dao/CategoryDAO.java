package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import vo.Category;

public class CategoryDAO {
	
	public static boolean insert(Connection con,Category category) {
		
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			pstmt = con.prepareStatement("INSERT INTO category VALUES(?,?)");
			pstmt.setString(1,category.getCode());
			pstmt.setString(2,category.getName());
			result = (pstmt.executeUpdate() > 0); 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try{pstmt.close();}catch(Exception e) {}
		}
		return result;
	}
	public static ArrayList<Category> getCategory(Connection con){
		ArrayList<Category> list = new ArrayList<>(); // 카테고리 분류
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM category"); // select query문 실행
			while(rs.next()) { 
				Category c = new Category();
				c.setCode(rs.getString("category_code"));
				c.setName(rs.getString("category_name"));
				list.add(c);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {rs.close();}catch(Exception e) {} // ResultSet 닫기 필행
			try {stmt.close();}catch(Exception e) {}
			
		}
		
		for (Category category:list) {
			System.out.println("===================");
			System.out.println("분류코드 : "+category.getCode());
			System.out.println("분류코드 : "+category.getName());
			System.out.println("포함서적 : "+category.getComics());
		}
		
		return list; // 전체 카테고리가 어떤것이 있는지를 저장하는 리스트 반환
	}
}
