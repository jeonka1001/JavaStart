package company;
import employees.Employees;
import employees.Regular;
import employees.PartTime;

public class Company {
	private Employees[] employee;
	private int count;
	private int capital;
	
	public Company(int employeesCount,int capital) {
		employee = new Employees[employeesCount];
		this.capital = capital;
		count = 0;
	}
	public void setEmployees(Employees[] employee) {
		this.employee = employee;
	}
	public void setCpaital(int capital) {
		this.capital = capital;
	}
	public Employees[] getEmployees() {
		return employee;
	}
	public int getCount()
	{
		return count;
	}
	public int getCapital() {
		return capital;
	}
	public boolean hire(Employees employee) {
		if(count<this.employee.length) {
			this.employee[count]=employee;
			count++;
			System.out.println(employee.getName()+"님을 고용하셨습니다.");
			return true;
		}
		System.out.println("더이상 고용 불가");
		return false;
	}
	public Employees find(String name) {
		for(Employees emp: employee) {
			if(emp.getName().contentEquals(name)) {
				return emp;
			}
		}
		return null;
	}
	public Employees[] findAll(String name) {
		int cnt=0;
		for(Employees emp: employee) {
			if(emp.getName().equals(name)) {
				cnt++;
			}
		}
		if(cnt == 0) {
			return null;
		}
		else {
			int num=0;
			Employees[] tmp = new Employees[cnt];
			for(Employees emp: employee) {
				if(emp.getName().equals(name)) {
					tmp[num++]=emp;
				}
			}
			return tmp;
		}
	}
	public void showInfo() {
		System.out.println("자본금 : "+capital);
		System.out.println("사원수 : "+count+"명");
	}
	
	public void showInfo(boolean listFlag) {
		showInfo();
		if(listFlag) {
			showList();
		}
	}
	public void showList() {
		for(Employees emp: employee) {
			if(emp instanceof Regular) {
				System.out.println("사원명 : "+emp.getName()+"[정직원]");
			}
			else {
				System.out.println("사원명 : "+emp.getName()+"[파트타임직원]");
			}
		}
	}
	public void pay() {
		for(int i=0;i<count;i++) {
			if(employee[i] instanceof Regular) {
				int tmp = ((Regular)employee[i]).pay();
				System.out.println(employee[i].getName() + "사원에게"+tmp+"원을 지급하였습니다.");
				capital -=tmp;
			}
			else {
				PartTime pt = (PartTime)employee[i];
				System.out.println(pt.getName() + "사원에게"+pt.pay()+"원을 지급하였습니다.");
			}
		}
	}
}

