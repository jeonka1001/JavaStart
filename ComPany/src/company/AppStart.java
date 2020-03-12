package company;
import employees.Employees;
import employees.Regular;
import employees.PartTime;

public class AppStart {
	private Company company;
	public AppStart(int count , int capital) {
		company = new Company(count,capital);
	}
	public void start()
	{
		company.hire(new Regular("심청이",35000000));
		company.hire(new Regular("홍길동",35000000));
		company.hire(new PartTime("홍길동",120,9000));
		company.hire(new PartTime("제이슨",100,8600));
		company.showInfo();
		company.showList();
		company.pay();
		company.showInfo(true);
		
		Employees emp = company.find("홍길동");
		if(emp!= null) {
			System.out.println(emp.getName()+"검색에 성공히였습니다.");
		}
		else {
			System.err.println("검색 실패");
		}
		Employees[] emps = company.findAll("홍길동");
		if(emps ==null) {
			System.err.println("findAll 검색 실패");
		}
		else {
			System.out.println(emps.length+"명이 검색 되었습니다.");
			for(Employees e: emps) {
				System.out.println(e.getName());
			}
		}
	}
	public static void main(String[] args) {
		AppStart app = new AppStart(3,10000000);
		app.start();
	}
}
