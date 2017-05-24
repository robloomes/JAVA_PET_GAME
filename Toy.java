package pet_game;
/**
 * Toy.java - a class used for building Toy objects.
 * <p>
 * This contains methods for returning and changing Toy attributes
 * Toy objects created are mainly used in association with classes @see Pet and @see gameEnvironment. 
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
	 * Constructor method for Food class.
	 * @param name A variable of type String.
	 * @param price A variable of type Integer
	 * @param durability A variable of type Integer.
	 * @param enjoyment A variable of type Integer.
	 * @return Nothing.
	 */
	Toy(String name, int price, int durability, int enjoyment) {
		this.name = name;
		this.price = price;
		this.durability = durability;
		this.enjoyment = enjoyment;
	}	
	
	/**
	 * Constructor method for clone class.
	 * create unique variavble for each pets.
	 * @param name A variable of type String.
	 * @return Nothing.
	 */
	Toy(Toy toy) {
		this.name = toy.getName();
		this.price = toy.getPrice();
		this.durability = toy.getDurability();
		this.enjoyment = toy.getEnjoyment();
	}	
	
	/**
	 * Getter method
	 * @return This returns the String name variable.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Getter method
	 * @return This returns the integer price variable.
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * Getter method
	 * @return This returns the integer durability variable.
	 */
	public int getDurability() {
		return durability;
	}
	
	/**
	 * Getter method
	 * @return This returns the integer enjoyment variable.
	 */
	public int getEnjoyment() {
		return enjoyment;
	}
	
	/**
	 * Sets the int newDurability variable to a new value.
	 * @param newDurability this is the new variable for int Durability.
	 */
	public void setDurability(int newDurability) {
		this.durability = newDurability;
	}
	
	/**
	 * Overides the default toString method.
	 * Produces a formatted String of all Pet variables.
	 * @return Formatted String.
	 */
	public String toString() {
		String toyName = "Name: " + this.name;
		String toyPrice = "Price: " + this.price;
		String toyDurability = "Durability: " + this.durability;
		String toyEnjoyment = "Enjoyment: " + this.enjoyment;

		String result = String.format("%s %n%s %n%s %n%s",toyName, toyPrice, toyDurability, toyEnjoyment);
		return result;
	}
	
	
	public static void main(String[]args) {
		Toy testBall = new Toy("Ball", 18, 100, 7); //(name, price, durability, enjoyment)
		System.out.println(testBall);

	   
	}
	
}
