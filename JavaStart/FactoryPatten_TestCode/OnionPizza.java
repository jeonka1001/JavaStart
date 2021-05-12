package factory;

public class OnionPizza extends Pizza{
	public static final String NAME = "어니언";
	
	public OnionPizza() {
		super(NAME);
	}
	public String getDescript() {
		return NAME;
	}

}
