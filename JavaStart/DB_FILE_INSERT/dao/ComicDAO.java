package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vo.Category;
import vo.Comics;

public class ComicDAO {
	public static boolean insert (Connection con,Comics comic) {
		boolean result = false;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("INSERT INTO comics VALUES(DEFAULT,?,?,?,?);");
			pstmt.setString(1,comic.getTitle());
			pstmt.setInt(2,comic.getPrice());
			pstmt.setString(3,comic.getCategoryCode());
			pstmt.setString(4,comic.getPublisherCode());
			result = (pstmt.executeUpdate()>0);
		}catch(SQLException e){e.printStackTrace();}
		finally {
			try {pstmt.close();}catch(Exception e) {}
		}
		return result;
	}
	public static ArrayList<Comics> getComics(Connection con,Category category) // 카테고리 객체를 인수로받는다 
	// 카테고리 객체는 한가지 종류의 카테고리를 의미하며 그 분류로 빠지는 모든 책들을 리스트로 저장한다.
	{
		ArrayList<Comics> list = new ArrayList<>();
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM comics WHERE category_code like '"+category.getCode()+"'");
			// 해당 캐테고리가 가진 카테고리 코드를 기준으로책들을 뽑아낸다. 전달된 카테고리 인스턴스가 액션이면 액션에 해당하는 책을 반환. 
			while(rs.next()) {
				Comics c =new Comics();
				c.setId(rs.getInt("id"));
				c.setTitle(rs.getString("title"));
				c.setPrice(rs.getInt("price"));
				c.setCategoryCode(rs.getString("category_code"));
				c.setPublisherCode(rs.getString("publisher_code"));
				// 전달받은 책의 번호,타이틀, 가격, 카테고리코드, 출판코드를 설정
				c.setCategory(category);
				// 카테고리 필드에 전달받은 인스턴스를 등록한다.
				
				list.add(c); //리스트(분류)에 책을 저장한다.
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {rs.close();}catch(Exception e) {} // ResultSet 닫기 필행
			try {stmt.close();}catch(Exception e) {}
		}
		
		
		for (Comics comics:list) {
			System.out.println("===================");
			System.out.println("책번호  : "+comics.getId());
			System.out.println("책이름 : "+comics.getTitle());
			System.out.println("책가격 : "+comics.getPrice());
			System.out.println("출판사 : "+comics.getPublisherCode());
			System.out.println("분류코드 : "+comics.getCategoryCode());
		}
		
		return list;
	}
}
