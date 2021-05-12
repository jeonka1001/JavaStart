package vo;

public class Publisher {
	private String code;
	private String name;
	private String tel;
	private String tax;
	public Publisher() {}
	public Publisher(String code,String name, String tel,String tax) {
		this.name=name;
		this.code=code;
		this.tel=tel;
		this.tax = tax;
		
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
}
