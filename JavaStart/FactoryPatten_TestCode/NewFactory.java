package factory;

public class NewFactory extends PizzaFactory{
	public Pizza createPizza(String name) {
		switch(name) {
		case BaconPizza.NAME:
			return new BaconPizza();
		case CheesePizza.NAME:
			return new CheesePizza();
		case OnionPizza.NAME:
			return new OnionPizza();
		default:
			return null;
		}
	}
}
