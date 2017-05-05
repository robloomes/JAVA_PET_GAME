package pet_game;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;
import java.util.*;
import java.util.Scanner; 
import java.util.Properties;

public class gameEnvironment {
	
	////Initializations
	private int numOfPlayers;
	private double numOfDays;
	private Map<String, String> foodSizes = new HashMap<String, String>();
	private Map<String, Toy> toyChoices = new HashMap<String, Toy>();
	private Map<String, Food> foodChoices = new HashMap<String, Food>();
	private Map<String, Pet> petChoices = new HashMap<String, Pet>();
	private Map<String, Player> players = new HashMap<String, Player>();
	
	//Toys available for purchase from store
	private Toy ball = new Toy("Ball", 10, 10, 10); //(name, price, durability, enjoyment)
	private Toy slinky = new Toy("Slinky", 20, 20, 20);
	private Toy cube = new Toy("Cube", 30, 30, 30);
	private Toy plushie = new Toy("Plushie", 40, 40, 40 );
	private Toy actionFigure = new Toy("Action figure", 50, 50, 50);
	private Toy bicycle = new Toy("Bicycle", 200, 100, 100);
	
	//Food available for purchase from store
	private Food biscuit = new Food("Biscuit", 5, "small", 5, 30 ); //(name, price, size, nutrition , tastiness)
	private Food fish = new Food("Fish", 10, "small", 40, 30 ); 
	private Food chocolate = new Food("Chocolate", 10, "small", 5, 60 ); 
	private Food cake = new Food("Cake", 20, "large", 10, 75 ); 
	private Food salad = new Food("Salad", 30, "large", 50, 25 ); 
	private Food roastBeef = new Food("Roast-beef", 50, "large", 75, 75 ); 
	
	gameEnvironment(){
		inputPlayerNum();
		inputDayNum();
		createPlayers();
		for (Map.Entry<String, Player> entry : players.entrySet()){
			Player val = entry.getValue();
			inputPetNum(val.name);
			val.addPet();
		}
		
		
		printPlayers();
		
		toyChoices.put(ball.name, ball);
		toyChoices.put(slinky.name, slinky);
		toyChoices.put(cube.name, cube);
		toyChoices.put(plushie.name, plushie);
		toyChoices.put(actionFigure.name, actionFigure );
		toyChoices.put(bicycle.name, bicycle);
		
		foodChoices.put(biscuit.name, biscuit);
		foodChoices.put(fish.name, fish);
		foodChoices.put(chocolate.name, chocolate);
		foodChoices.put(cake.name, cake);
		foodChoices.put(salad.name, salad);
		foodChoices.put(roastBeef.name, roastBeef);
		
		foodSizes.put("small", "small");
		foodSizes.put("large", "large");
	}
	
	public void inputPetNum(String player){
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String strPlayerNum = null;
		do{
			if (strPlayerNum != null){
				System.out.println("\nPlease enter a valid number between 1 and 3.\n");
			}
			System.out.format("How many pets would %s like to own? (max 3)", player);
			strPlayerNum = scan.nextLine();
		  }
		while(!strPlayerNum.matches("[1-3]"));
		System.out.format("You have selected %s pet/s.%n", strPlayerNum);
		numOfPlayers = Integer.parseInt(strPlayerNum);
	}
	public void inputDayNum(){
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String strDayNum = null;
		do{
			if (strDayNum != null){
				System.out.println("Please enter a valid number.");
			}
			System.out.println("\nHow many days will the game run for?");
			strDayNum = scan.nextLine();
		  }
		while(!strDayNum.matches("[1-9]+"));
		System.out.format("You have selected %s day/s.%n", strDayNum);
		numOfDays = Double.parseDouble(strDayNum);
	}
	
	public void inputPlayerNum(){
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String strPlayerNum = null;
		do{
			if (strPlayerNum != null){
				System.out.println("\nPlease enter a valid number between 1 and 3.\n");
			}
			System.out.println("How many players would like to play the game? (max 3).");
			strPlayerNum = scan.nextLine();
		  }
		while(!strPlayerNum.matches("[1-3]"));
		System.out.format("You have selected %s player/s.%n", strPlayerNum);
		numOfPlayers = Integer.parseInt(strPlayerNum);
	}
	public void createPlayers(){
		@SuppressWarnings("resourNone ce")
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < numOfPlayers; i++){
			System.out.println(String.format("\nPlayer %d, what is your name?", i+1));
			String name = scan.next();
			
			while (players.keySet().contains(name)){
				System.out.println("That name belongs to another player, please choose another.");
				System.out.println(String.format("Player %d, what is your name?", i+1));
				name = scan.next();
			}
			Player newPlayer = new Player(name);
			addPlayer(newPlayer);
		}
		
	}
	
	public void printPlayers(){
		for (Map.Entry<String, Player> entry : players.entrySet()){
			Player val = entry.getValue();
			System.out.println( "\n" + val);
		}
	}
	
	public void printFood(){
		for (Map.Entry<String, Food> entry : foodChoices.entrySet()){
			Food val = entry.getValue();
			System.out.println("\n" + val);
		}
	}
	
	public void printToys(){
		for (Map.Entry<String, Toy> entry : toyChoices.entrySet()){
			Toy val = entry.getValue();
			System.out.println("\n" + val);
		}
	}
	
	public void printPets(){
		for (Map.Entry<String, Pet > entry : petChoices.entrySet()){
			Pet val = entry.getValue(); 
			System.out.println("\n" + val);
		}
	}
	
	public void addToy(String player, String toyName){ 
		Toy toy = toyChoices.get(toyName);
		Player val = players.get(player);
		val.addToy(toy);
	}
	
	public void addPlayer(Player player){
		players.put(player.name, player);
	}
	
	public void addPet(String player, String petName){
		//Pet pet = petChoices.get(petName);
		//Player val = players.get(player);
		//val.addPet(pet);
	}
	
	public void addFood(String player, String foodName){ 
		Food food = foodChoices.get(foodName);
		Player val = players.get(player);
		val.addFood(food);
	}
	
	public static void main(String[]args) {
		/**Properties prop = new Properties();
		InputStream input = null;
		
		try {
		*	input = new FileInputStream("config.properties");
		*	prop.load(input);
		*} catch (IOException ex) {
		*	// TODO Auto-generated catch block
		*	ex.printStackTrace();
		*}
		*String food1 = prop.getProperty("ball");
		*System.out.println(food1);*/
		
		//Unit testing
		gameEnvironment newGame = new gameEnvironment();

		
		
		
		
	}
}
