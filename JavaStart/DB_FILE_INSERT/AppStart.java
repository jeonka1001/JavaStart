import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import dao.CategoryDAO;
import dao.ComicDAO;
import vo.Category;
import vo.Comics;

public class AppStart {
	public static final String URL="jdbc:mariadb://localhost:3306/example?user=example&password=1234";
	
	public static void main(String[] args) {
		Connection con = null;
		ArrayList<Category>list=null;
		try {
			con = DriverManager.getConnection(URL);
			con.setAutoCommit(false);
			
			Category ca = new Category("LECT","학원");
			Comics co = new Comics("테스트입력",0,2000,"LECT","HUNI",ca);
			if(CategoryDAO.insert(con, ca)) {
				if(ComicDAO.insert(con, co)) {
					con.commit(); // ca와co가 정상 등록이라면 commit
					System.out.println("정상 등록");
				}
				else {
					System.out.println("코믹 등록 실패");
				}
			}else {
				con.rollback();
				System.out.println("카테고리 등록 실패");
			}
			con.setAutoCommit(true); // 다시 정상 등록
			
			list = CategoryDAO.getCategory(con);
			
			for(int i=0;i<list.size();i++) {
				Category category = list.get(i);
				category.setComics(ComicDAO.getComics(con,category));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}catch(Exception e) {}
		}
	}
}
