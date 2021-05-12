package factory;

public abstract class PizzaStore {
	protected String name;
	protected PizzaFactory factory;
	
	public PizzaStore(String name) {
		this.name=name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String Name() {
		return this.name;
	}
	
	public void setPizzaFactory(PizzaFactory factory) {
		this.factory = factory;
	}
	public abstract Pizza order(String name);
}
