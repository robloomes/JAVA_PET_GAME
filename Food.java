package pet_game;

/**
 * Food.java - a class used for building Food objects.
 * <p>
 * This contains methods for returning and changing Food attributes Food objects
 * created are mainly used in association with classes {@link pet_game.Pet} and
 * {@link pet_game.GUIfinal}.
 * 
 * @author Robert Loomes
 * @author Mna Chalabi
 * @since Winter 2017
 * @version 1.0
 */
public class Food {

	/**
	 * Initialize the variables of the class
	 */
	String name;
	int price;
	String size;
	int tastiness;
	int nutrition;

	/**
	 * Constructor method for Food class.
	 * 
	 * @param name
	 *            A variable of type String.
	 * @param price
	 *            A variable of type Integer.
	 * @param size
	 *            A variable of type String.
	 * @param tastiness
	 *            A variable of type Integer
	 * @param nutrition
	 *            A variable of type Integer.
	 * @return Nothing.
	 */
	Food(String name, int price, String size, int tastiness, int nutrition) {
		this.name = name;
		this.price = price;
		this.size = size;
		this.tastiness = tastiness;
		this.nutrition = nutrition;
	}

	/**
	 * Getter method
	 * 
	 * @return This returns the String name variable.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter method
	 * 
	 * @return This returns the int Price variable.
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Getter method
	 * 
	 * @return This returns the String size variable.
	 */
	public String getSize() {
		return size;
	}

	/**
	 * Getter method
	 * 
	 * @return This returns the int tastiness variable.
	 */
	public int getTastiness() {
		return tastiness;
	}

	/**
	 * Getter method
	 * 
	 * @return This returns the int nutrition variable.
	 */
	public int getNutrition() {
		return nutrition;
	}

	/**
	 * Sets the int nutrition variable to a new value.
	 * 
	 * @param newNutrition
	 *            this is the new variable for int nutrition.
	 */
	public void setNutrition(int newNutrition) {
		this.nutrition = newNutrition;
	}

	/**
	 * Overides the default toString method. Produces a formatted String of all
	 * Food variables.
	 * 
	 * @return Formatted String.
	 */
	public String toString() {
		String foodName = "Name: " + this.name;
		String foodPrice = "Price: " + this.price;
		String foodSize = "Size: " + this.size;
		String foodTastiness = "Tastiness: " + this.tastiness;
		String foodNutrition = "Nutrition: " + this.nutrition;

		String result = String.format("%s %n%s %n%s %n%s %n%s", foodName, foodPrice, foodSize, foodTastiness,
				foodNutrition);
		return result;
	}
}
