package pet_game;
import java.util.*;

public class Player {
	
	//Initializations
	
	static Set<String> playerSet = new HashSet<String>();
	String name;
	int playerBalance;
	private Map<String, Species> ownedPets = new HashMap<String, Species>();
	private Map<Toy, Integer> ownedToys = new HashMap<Toy, Integer>();
	private Map<Food, Integer> ownedFood = new HashMap<Food, Integer>();

	
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
	
	public Map<String, Species> getPets() {
		return ownedPets;
	}
	
	public Map<Toy, Integer> getToys() {
		return ownedToys;
	}
	
	
	public Map<Food, Integer> getFood() {
		return ownedFood;
	}
	
	public int getBalance() {
		return playerBalance;
	}
	
	
	//setters
	public void addPet(Species pet) {
		ownedPets.put(pet.getName(), pet);
	}
	
	public void removePet(Pet pet) {
		ownedPets.remove(pet);
		ownedPets.remove(pet, 0);
	}
	
	public void addToy(Toy toy) {
		ownedToys.merge(toy, 1, Integer::sum);
	}
	
	public void removeToy(Toy toy) {
		ownedToys.merge(toy, -1, Integer::sum);
		ownedToys.remove(toy, 0);
	}
	
	public void addFood(Food food) {
		ownedFood.merge(food, 1, Integer::sum);
	}
	
	public void removeFood(Food food) {
		ownedFood.merge(food, -1, Integer::sum);
		ownedFood.remove(food, 0);
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
			List<String> toyKeyList = new ArrayList<String>();
			for(Map.Entry<Toy, Integer> entry : ownedToys.entrySet()){
				Toy toy = entry.getKey();
				int val = entry.getValue();
				String toyFormat = String.format("%s: %d", toy.getName(), val);
				toyKeyList.add(toyFormat);
		}
			playerToys = "Toys: " + Arrays.toString(toyKeyList.toArray()).replace("[", "").replace("]", "");
		}
		
		if (ownedFood.isEmpty()) {
			playerFood = "Food: None";
		}
		
		else {
			List<String> foodKeyList = new ArrayList<String>();
			for(Map.Entry<Food, Integer> entry : ownedFood.entrySet()){
				Food food = entry.getKey();
				int val = entry.getValue();
				String foodFormat = String.format("%s: %d", food.getName(), val);
				foodKeyList.add(foodFormat);
				
		}
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
		testHarry.addToy(testBall);
		testHarry.addToy(testBall);
		System.out.println("\n" + testHarry);
		//adding some food
		Food testTuna = new Food("Tuna", 18, "small", 7, 12 ); //(name, price, size, nutrition , tastiness ))
		Food testCake = new Food("Cake", 2, "large", 0, 5 ); //(name, price, size, nutrition , tastiness )
		testHarry.addFood(testTuna);
		testHarry.addFood(testCake);
		testHarry.addFood(testTuna);
		testHarry.addFood(testTuna);
		testHarry.addFood(testTuna);
		testHarry.addFood(testTuna);
		testHarry.addFood(testTuna);
		System.out.println("\n" + testHarry);
		testHarry.removeToy(testBall);
		
		testHarry.removeToy(testBall);
		testHarry.removeToy(testBall);
		testHarry.removeFood(testCake);
		System.out.println("\n" + testHarry);
		//player list
		System.out.println(playerSet);
		
		
	}

}
