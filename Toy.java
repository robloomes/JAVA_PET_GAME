package pet_game;
/**
 * Toy.java - a class used for building Food objects.
 * <p>
 * This contains methods for returning and changing Toy attributes Toy objects
 * created are mainly used in association with classes {@link pet_game.Pet} and
 * {@link pet_game.GUIfinal}.
 * 
 * @author Robert Loomes
 * @author Mna Chalabi
 * @since Winter 2017
 * @version 1.0
 */
public class Toy {
	
	/**
	 * Initialize the variables of the class
	 */
	String name;
	int price;
	int durability;
	int enjoyment;
	
	/**
	 * Constructor method for Toy class.
	 * 
	 * @param name A variable of type String.
	 * @param price A variable of type Integer.
	 * @param durability A variable of type Integer.
	 * @param enjoyment A variable of type Integer.
	 */
	Toy(String name, int price, int durability, int enjoyment) {
		this.name = name;
		this.price = price;
		this.durability = durability;
		this.enjoyment = enjoyment;
	}	
	
	/**
	 *  Constructor for cloning the class, not just the reference.
	 * 
	 * @param toy The Toy object being cloned.
	 */
	Toy(Toy toy) {
		this.name = toy.getName();
		this.price = toy.getPrice();
		this.durability = toy.getDurability();
		this.enjoyment = toy.getEnjoyment();
	}	
	
	/**
	 * Getter method
	 * @return This returns the name of {@link pet_game.Toy} object.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Getter method
	 * @return This returns the price of {@link pet_game.Toy} object.
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * Getter method
	 * @return This returns the durability of {@link pet_game.Toy} object.
	 */
	public int getDurability() {
		return durability;
	}
	
	/**
	 * Getter method
	 * @return This returns the enjoyment of {@link pet_game.Toy} object.
	 */
	public int getEnjoyment() {
		return enjoyment;
	}
	
	/**
	 * Sets a new durability value
	 * @param newDurability the new durability value
	 */
	public void setDurability(int newDurability) {
		this.durability = newDurability;
	}
	
	/**
	 * Overrides the default toString method. Produces a formatted String of all
	 * Toy variables.
	 * 
	 * @return Formatted String.
	 */
	public String toString() {
		//Output format
		String toyName = "Name: " + this.name;
		String toyPrice = "Price: " + this.price;
		String toyDurability = "Durability: " + this.durability;
		String toyEnjoyment = "Enjoyment: " + this.enjoyment;

		String result = String.format("%s %n%s %n%s %n%s",toyName, toyPrice, toyDurability, toyEnjoyment);
		return result;
	}
	
	public static void main(String[]args) {
		//Unit testing
		Toy testBall = new Toy("Ball", 18, 100, 7); //(name, price, durability, enjoyment)
		System.out.println(testBall);
		}
	
}
