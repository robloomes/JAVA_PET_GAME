package pet_game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface gameObjects {
	public String help1 = "<html>This game let's 1 or more players own pets, which can be interacted with for a number of days."
			            + "<html> Players can choose between a number of different species to choose from,<br>"
			            + "<html>which each have their own appearance, attributes, behaviors etc.  (1/5)";
	
	public String help2 = "<html>The goal of the game is to keep the pets healthy and happy,<br>"
			            + "<html> or else they might get sick, misbehave, or die!  (2/5)";
	
	public String help3 = "<html>Players can view the attributes of each pet to find out what they need.<br>"
			            +"<html> If a pet has a issue, there will always be a way to solve it.  (3/5)";

	public String help4 = "<html>Players start with money to purchase items food or toys from the store,<br>"
						+ " which have different attributes and prices that have varying effects on pets.  (4/5)";
	
	public String help5 = "<html>Each pet is able to take 2 actions per day,and the game is over when the last day is finished.<br> Good luck!  (5/5)";

			

	
	
	public List<String> existingPetNames = new ArrayList<String>();
	public Map<Integer, Toy> toyChoices = new HashMap<Integer, Toy>();
	public Map<Integer, Food> foodChoices = new HashMap<Integer, Food>();
	public Map<Integer, Species> speciesChoices = new HashMap<Integer, Species>();
	public Map<String, Player> players = new HashMap<String, Player>();
	//Toys available for purchase from store
	//(name, price, durability, enjoyment)
	public Toy bear = new Toy("Bear", 5, 10, 20); 
	public Toy boat = new Toy("Boat", 15, 70, 50);
	public Toy doll = new Toy("Doll", 5, 50, 10);
	public Toy heli = new Toy("Helicopter", 20, 100, 50);
	public Toy kite = new Toy("Kite", 10, 50, 50);
	public Toy yoyo = new Toy("Yoyo", 5, 10, 20);
	
	//Food available for purchase from store
	//(name, price, size, nutrition , tastiness)
	public Food cookie = new Food("Cookie", 5, "small", 25, 20); 
	public Food fish = new Food("Fish", 10, "large", 80, 30); 
	public Food chocolate = new Food("Chocolate", 5, "small", 5, 40); 
	public Food cake = new Food("Cake", 10, "large", 40, 30); 
	public Food melon = new Food("Melon", 5, "small", 50, 20); 
	public Food pizza = new Food("Pizza", 10, "large", 30, 40); 
	
	//All species available for creation. Species are differentiated by their attributes.
	//Name, sleep, mood, hunger, energy, favFood, favToy, species, weight, roughness.
	public Species cloud = new Species("defaultCloud",1.0, 1.5, 0.5, 0.5, melon.getName(),
			                                          kite.getName(), "Cloud", 2, 5); 
	public Species crab = new Species("defaultCrab",1.1, 1.0, 1.0, 1.1, fish.getName(),
			                                          yoyo.getName(), "Crab", 4, 10);
	public Species monster = new Species("defaultMonster", 2.0, 1.0, 1.5, 1.2, chocolate.getName(),
			                                          bear.getName(), "Monster", 100, 20); 
	public Species penguin = new Species("defaultPenguin", 1.0, 1.0, 1.0, 1.0, pizza.getName(),
			                                          doll.getName(), "Penguin", 8, 10); 
	public Species robot = new Species("defaultRobot", 1.0, 1.5, 0.5, 0.5, cake.getName(),
			                                          heli.getName(), "Robot", 400, 20); 
	public Species snake = new Species("defaultSnake", 1.0, 1.0, 1.5, 1.5, cookie.getName(),
			                                          boat.getName(), "Snake", 7, 10); 
}
