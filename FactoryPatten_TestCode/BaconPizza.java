package factory;

public class BaconPizza extends Pizza{
	public static final String NAME="베이컨";
	public BaconPizza() {
		super(NAME);
	}
	
	public String getDescript() {
		return name;
	}
}
