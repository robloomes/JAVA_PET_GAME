package pet_game;

import java.util.*;

public class Player{
	
	//Initializations
	static Set<String> playerSet = new HashSet<String>();
	String name;
	int playerBalance = 1000;
	List<String> emptyList = new ArrayList<String>();
	List<String> pets;
	List<String> toys;
	List<String> food;
	
	//Constructor
	Player(String name){
		this.name = name;
		this.playerBalance = 1000;
		this.pets = new ArrayList<String>();
		this.toys = new ArrayList<String>();
		this.food = new ArrayList<String>();
	}
	
	//Getters
	public String getName(){
		return name;
	}
	
	public List<String> getPets(){
		return pets;
	}
	
	public List<String> getToys(){
		return toys;
	}
	
	public List<String> getFood(){
		return food;
	}
	
	//setters
	public void addPet(){
		//TODO	
	}
	
	public void removePet(){
		//TODO
	}
	
	public void addToy(Toy item){
		this.toys.add(item.name);
	}
	
	public void removeToy(Toy item){
		List<String> toRemove =  new ArrayList<String>();
		for(String toy: this.toys){
			if(toy.equalsIgnoreCase(item.name)){
				toRemove.add(toy);
			}
		 }
		this.toys.removeAll(toRemove);
	}
	
	public void addFood(Food item){
		this.food.add(item.name);
	}
	
	public void removeFood(Food item){
		List<String> toRemove =  new ArrayList<String>();
		for(String food: this.food){
			if(food.equalsIgnoreCase(item.name)){
				toRemove.add(food);
			}
		 }
		this.food.removeAll(toRemove);
	}
	
	@Override
	public String toString(){
		String playerName = "Name: " + this.name;
		String playerBalance = "Balance: " + this.playerBalance;
		
		String playerPets;
		if (this.pets.isEmpty()){
			playerPets = "Pets: None";
		}
		else{
			playerPets = "Pets: " + Arrays.toString(this.pets.toArray()).replace("[", "").replace("]", "");
		}
		
		String playerToys;
		if (this.toys.isEmpty()){
			playerToys = "Toys: None";
		}
		else{
			playerToys = "Toys: " + Arrays.toString(this.toys.toArray()).replace("[", "").replace("]", "");
			
		}
		
		String playerFood;
		if (this.food.isEmpty()){
			playerFood = "Food: None";
		}
		else{
			playerFood = "Food: " + Arrays.toString(this.food.toArray()).replace("[", "").replace("]", "");
		}

		return playerName + "\n" + playerBalance + "\n" + playerPets + "\n" + playerToys + "\n" + playerFood;
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
		Food testTuna = new Food("Tuna", 18, 100, 7, 12 ); //(name, price, weight, nutrition , tastiness ))
		Food testCake = new Food("Cake", 2, 45, 0, 5 ); //(name, price, weight, nutrition , tastiness )
		testHarry.addFood(testTuna);
		testHarry.addFood(testCake);
		System.out.println("\n" + testHarry);
		testHarry.removeToy(testBall);
		testHarry.removeFood(testCake);
		System.out.println("\n" + testHarry);
		
		
	}

}
