package pet_game;
import java.util.*;

public class Player {
	
	//Initializations
	
	static Set<String> playerSet = new HashSet<String>();
	String name;
	int playerBalance;
	private Map<String, Pet> ownedPets = new HashMap<String, Pet>();
	private Map<String, Toy> ownedToys = new HashMap<String, Toy>();
	private Map<String, Food> ownedFood = new HashMap<String, Food>();

	
	//Constructor
	Player(String name){
		this.name = name;
		playerSet.add(name);
		this.playerBalance = 100;

	}
	
	//Getters
	public String getName() {
		return name;
	}
	
	public Map<String, Pet> getPets() {
		return ownedPets;
	}
	
	public Map<String, Toy> getToys() {
		return ownedToys;
	}
	
	
	public Map<String, Food> getFood() {
		return ownedFood;
	}
	
	
	//setters
	public void addPet(Pet pet) {
		ownedPets.put(pet.name, pet);
	}
	
	public void removePet(Pet pet) {
		ownedPets.remove(pet);
	}
	
	public void addToy(Toy item) {
		ownedToys.put(item.name, item);
	}
	
	public void removeToy(Toy item) {
		ownedToys.remove(item.name);
	}
	
	public void addFood(Food item) {
		ownedFood.put(item.name, item);
	}
	
	public void removeFood(Food item) {
		ownedFood.remove(item.name);
	}

	public String toString() {
		String playerName = "Name: " + name;
		String balanceString = "Balance: $" + playerBalance;
		String playerPets;
		String playerToys;
		String playerFood;
		
		if (ownedPets.isEmpty()) {
			playerPets = "Pets: None";
		}
		else {
			List<String> petKeyList = new ArrayList<String>(ownedPets.keySet());
			playerPets = "Pets: " + Arrays.toString(petKeyList.toArray()).replace("[", "").replace("]", "");
		}
		
		
		if (ownedToys.isEmpty()) {
			playerToys = "Toys: None";
		}
		else {
			List<String> toyKeyList = new ArrayList<String>(ownedToys.keySet());
			playerToys = "Toys: " + Arrays.toString(toyKeyList.toArray()).replace("[", "").replace("]", "");
		}
		
		if (ownedFood.isEmpty()) {
			playerFood = "Food: None";
		}
		
		else {
			List<String> foodKeyList = new ArrayList<String>(ownedFood.keySet());
			playerFood = "Food: " + Arrays.toString(foodKeyList.toArray()).replace("[", "").replace("]", "");
		}
		
		String result = String.format("%s %n%s %n%s %n%s %n%s", playerName, balanceString, playerPets, playerToys, playerFood);
		return result;
	}
	
	public static void main(String[] args) {
		//unit tests
		Player testHarry = new Player("Harry");
		System.out.println(testHarry);
		//adding a ball and doll to the player
		Toy testBall = new Toy("Ball", 18, 100, 7); //(name, price, durability, enjoyment)
		Toy testDoll = new Toy("Doll", 155, 7, 65); //(name, price, durability, enjoyment)
		testHarry.addToy(testDoll);
		testHarry.addToy(testBall);
		
		//adding some food
		Food testTuna = new Food("Tuna", 18, "small", 7, 12 ); //(name, price, size, nutrition , tastiness ))
		Food testCake = new Food("Cake", 2, "large", 0, 5 ); //(name, price, size, nutrition , tastiness )
		testHarry.addFood(testTuna);
		testHarry.addFood(testCake);
		System.out.println("\n" + testHarry);
		testHarry.removeToy(testBall);
		testHarry.removeFood(testCake);
		System.out.println("\n" + testHarry);
		//player list
		System.out.println(playerSet);
	}

}
