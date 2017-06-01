package pet_game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Player.java - a class used for building Player objects. Food objects created
 * are mainly used in association with classes @see gameEnvironment.
 * 
 * @author Robert Loomes
 * @author Mna Chalabi
 * @since Winter 2017
 * @version 1.0
 */
public class Player {

	/**
	 * Initialize the variables of the class
	 */

	String name;
	int playerBalance;
	private Map<String, Species> ownedPets = new HashMap<String, Species>();
	private Map<Toy, Integer> ownedToys = new HashMap<Toy, Integer>();
	private Map<Food, Integer> ownedFood = new HashMap<Food, Integer>();

	/**
	 * Constructor method for Food class.
	 * 
	 * @param name
	 *            A variable of type String.
	 * @return Nothing.
	 */
	Player(String name) {
		this.name = name;
		this.playerBalance = 100;

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
	 * @return This returns the ownedPets list.
	 */
	public Map<String, Species> getPets() {
		return ownedPets;
	}

	/**
	 * Getter method
	 * 
	 * @return This returns the ownedToys list.
	 */
	public Map<Toy, Integer> getToys() {
		return ownedToys;
	}

	/**
	 * Getter method
	 * 
	 * @return This returns the ownedFood list.
	 */
	public Map<Food, Integer> getFood() {
		return ownedFood;
	}

	/**
	 * Getter method
	 * 
	 * @return This returns the Integer playerBalance variable.
	 */
	public int getBalance() {
		return playerBalance;
	}

	/**
	 * Sets the int newBalance variable to a new value.
	 * 
	 * @param newBalance
	 *            this is the new variable for int Balance.
	 */
	public void setBalance(int newBalance) {
		this.playerBalance = newBalance;
	}

	/**
	 * addPet is Method that adds pet to the list of the player.
	 * 
	 * @param pet
	 *            to sets a name for the pet.
	 */
	public void addPet(Species pet) {
		ownedPets.put(pet.getName(), pet);
	}

	/**
	 * addToy is Method that adds Toys to the list of the player.
	 */
	public void addToy(Toy toy) {
		ownedToys.merge(toy, 1, Integer::sum);
	}

	/**
	 * removePet is Method that remove Toys from the list of the player.
	 */
	public void removeToy(Toy toy) {
		ownedToys.merge(toy, -1, Integer::sum);
		ownedToys.remove(toy, 0);
	}

	/**
	 * addFood is Method that adds Foods to the list of the player.
	 */
	public void addFood(Food food) {
		ownedFood.merge(food, 1, Integer::sum);
	}

	/**
	 * removeFood is Method that remove Food from the list of the player.
	 */
	public void removeFood(Food food) {
		ownedFood.merge(food, -1, Integer::sum);
		ownedFood.remove(food, 0);
	}

	/**
	 * Overides the default toString method. Produces a formatted String of all
	 * Player variables.
	 * 
	 * @return Formatted String.
	 */
	public String toString() {
		String playerName = "Player name: " + name;
		String balanceString = "Balance: $" + playerBalance;
		String playerPets;
		String playerToys;
		String playerFood;

		if (ownedPets.isEmpty()) {
			playerPets = "Pets: None";
		} else {
			List<String> petKeyList = new ArrayList<String>(ownedPets.keySet());
			playerPets = "Pets: " + Arrays.toString(petKeyList.toArray()).replace("[", "").replace("]", "");
		}

		if (ownedToys.isEmpty()) {
			playerToys = "Toys: None";
		} else {
			List<String> toyKeyList = new ArrayList<String>();
			for (Map.Entry<Toy, Integer> entry : ownedToys.entrySet()) {
				Toy toy = entry.getKey();
				int val = entry.getValue();
				String toyFormat = String.format("%s (%d)", toy.getName(), toy.getDurability());
				toyKeyList.add(toyFormat);
			}
			playerToys = "Toys (durability): "
					+ Arrays.toString(toyKeyList.toArray()).replace("[", "").replace("]", "");
		}

		if (ownedFood.isEmpty()) {
			playerFood = "Food: None";
		}

		else {
			List<String> foodKeyList = new ArrayList<String>();
			for (Map.Entry<Food, Integer> entry : ownedFood.entrySet()) {
				Food food = entry.getKey();
				int val = entry.getValue();
				String foodFormat = String.format("%s x%d", food.getName(), val);
				foodKeyList.add(foodFormat);

			}
			playerFood = "Food: " + Arrays.toString(foodKeyList.toArray()).replace("[", "").replace("]", "");
		}

		String result = String.format("<html>%s<br>%s<br>%s<br>%s<br>%s", playerName, balanceString, playerPets,
				playerToys, playerFood);
		return result;
	}

}
