package factory;

public class PizzaHut extends PizzaStore{
	
	public PizzaHut() {
		super("피자헛");
	}
	public Pizza order(String name) {
		return factory.createPizza(name);
	}
}
