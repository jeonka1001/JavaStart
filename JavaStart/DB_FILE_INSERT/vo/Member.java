package vo;

public class Member {
	private String name;
	private String id;
	private String email;
	private String password;
	public Member() {}
	public String getName() {
		return name;
	}
	public Member(String name, String id, String email, String password) {
		super();
		this.name = name;
		this.id = id;
		this.email = email;
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
