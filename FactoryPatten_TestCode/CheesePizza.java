package factory;

public class CheesePizza extends Pizza{
	public static final String NAME = "치즈";
	
	public CheesePizza(){
		super(NAME);
	}
	public String getDescript() {
		return NAME;
	}
}
