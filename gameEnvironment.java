package pet_game;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import java.awt.EventQueue;


import java.util.Properties;

public class gameEnvironment{
	
	////Initializations
	Species globalCurrentPet;
	private String currentPlayer;
	private int numOfPlayers;
	private double numOfDays;
	private List<String> existingPetNames = new ArrayList<String>();
	private Map<String, String> foodSizes = new HashMap<String, String>();
	private Map<Integer, Toy> toyChoices = new HashMap<Integer, Toy>();
	private Map<Integer, Food> foodChoices = new HashMap<Integer, Food>();
	private Map<Integer, Species> speciesChoices = new HashMap<Integer, Species>();
	private Map<String, Player> players = new HashMap<String, Player>();
	
	//Toys available for purchase from store
	//(name, price, durability, enjoyment)
	private Toy bear = new Toy("Bear", 10, 10, 10); 
	private Toy boat = new Toy("Boat", 20, 20, 20);
	private Toy doll = new Toy("Doll", 10, 30, 30);
	private Toy heli = new Toy("Helicopter", 20, 40, 40 );
	private Toy kite = new Toy("Kite", 10, 50, 50);
	private Toy yoyo = new Toy("Yoyo", 5, 20, 100);
	
	//Food available for purchase from store
	//(name, price, size, nutrition , tastiness)
	private Food cookie = new Food("Cookie", 5, foodSizes.get("small"), 5, 20); 
	private Food fish = new Food("Fish", 10, foodSizes.get("large"), 20, 30); 
	private Food chocolate = new Food("Chocolate", 5, foodSizes.get("small"), 5, 40); 
	private Food cake = new Food("Cake", 10, foodSizes.get("large"), 10, 30); 
	private Food melon = new Food("Melon", 5, foodSizes.get("small"), 15, 20); 
	private Food pizza = new Food("Pizza", 10, foodSizes.get("large"), 10, 40); 
	
	//All species available for creation. Species are differentiated by their attributes.
	//Name, sleep, mood, hunger, energy, favFood, favToy, species, weight, roughness.
	private Species species1 = new Species("defaultCloud",1.0, 1.0, 1.0, 1.0, melon.getName(),
			                                          kite.getName(), "Cloud", 100, 1.0); 
	private Species species2 = new Species("defaultCrab",1.1, 1.1, 1.1, 1.1, fish.getName(),
			                                          yoyo.getName(), "Crab", 100, 1.1);
	private Species species3 = new Species("defaultMonster",1.2, 1.2, 1.2, 1.2, chocolate.getName(),
			                                          bear.getName(), "Monster", 100, 1.2); 
	private Species species4 = new Species("defaultPenguin",1.3, 1.3, 1.3, 1.3, pizza.getName(),
			                                          doll.getName(), "Penquin", 100, 1.3); 
	private Species species5 = new Species("defaultRobot",1.4, 1.4, 1.4, 1.4, cake.getName(),
			                                          heli.getName(), "Robot", 100, 1.4); 
	private Species species6 = new Species("defaultSnake",1.5, 1.5, 1.5, 1.5, cookie.getName(),
			                                          boat.getName(), "Snake", 100, 1.5); 
			 
	
	gameEnvironment(){
		globalCurrentPet = null;
		
		toyChoices.put(1, bear);
		toyChoices.put(2, boat);
		toyChoices.put(3, doll);
		toyChoices.put(4, heli);
		toyChoices.put(5, kite);
		toyChoices.put(6, yoyo);
		
		foodChoices.put(1, cookie);
		foodChoices.put(2, fish);
		foodChoices.put(3, chocolate);
		foodChoices.put(4, cake);
		foodChoices.put(5, melon);
		foodChoices.put(6, pizza);
		
		speciesChoices.put(1, species1);
		speciesChoices.put(2, species2);
		speciesChoices.put(3, species3);
		speciesChoices.put(4, species4);
		speciesChoices.put(5, species5);
		speciesChoices.put(6, species6);
		
		foodSizes.put("small", "small");
		foodSizes.put("large", "large");

		int startChoice = welcome();
		if(startChoice != 1){
			do{
				help();
				startChoice = welcome();
			}
			while(startChoice == 2);
		}
		inputPlayerNum();
		inputDayNum();
		createPlayers();
		promptPetCreation();
		for (Map.Entry<String, Player> entry : players.entrySet()){
			Player val = entry.getValue();
			currentPlayer = val.name;
			mainSelectScreen(val);
		}
		
		
		

	}
	public void promptPetDetails(){
		
	
	}
	

	public void mainSelectScreen(Player player){
		String input = null;
		Scanner scan = new Scanner(System.in);
		do{
			if (input != null){
				System.out.println("\nYou have entered an invalid number,"
					        + "please enter a number between 1 and 8.\n");
				promptEnterKey();
			}
			System.out.format("Current Player: %s\n", currentPlayer);
			System.out.format("Current balance: $%d\n", player.getBalance());
			System.out.format("Owned pets (actions remanining):\n");
			for (Species pet : player.getPets().values()){
				System.out.format("%s (%d)\n", pet.getName(), pet.getActions());
			}
			if(globalCurrentPet == null){
				System.out.println("Current pet selected: NONE (select a pet to interact with it).");
			}else{
				System.out.format("Current pet selected: %s \n", globalCurrentPet.getName());
			}
			System.out.println("\n1. Select a pet to view and interact with.");
			System.out.println("2. View status of current pet.");
			System.out.println("3. Visit the store.");
			System.out.println("4. Feed pet.");
			System.out.println("5. Put pet to sleep.");
			System.out.println("6. Use toy.");
			System.out.println("7. Use toilet.");
			System.out.println("\n8. End day (resets actions).");
			input = scan.nextLine();
		}
		while(!input.matches("[1-8]"));
		int intInput = Integer.parseInt(input);
		switch (intInput){
			case 1: globalCurrentPet = selectPet(player);
					mainSelectScreen(player);
					break;
			case 2: if(globalCurrentPet == null){
						System.out.println("You need to select a pet first!");// error window in GUI
						promptEnterKey();
						mainSelectScreen(player);
					}else{
						System.out.println(globalCurrentPet); 
						promptEnterKey();
						mainSelectScreen(player);
					}
					break;
			case 3: store(player);
					promptEnterKey();
					mainSelectScreen(player);
					break;
			case 4: if(globalCurrentPet.getActions() == 0){
						System.out.println("Sorry! This pet has already taken 2 actions today.");
					}else{
						feedPet(player);
					}
					promptEnterKey();
					mainSelectScreen(player);
					break;
			case 5: if(globalCurrentPet.getActions() == 0){
						System.out.println("Sorry! This pet has already taken 2 actions today.");
					}else{
						globalCurrentPet.sleep();
					}
					promptEnterKey();
					mainSelectScreen(player);
				break;
			case 6:	if(globalCurrentPet.getActions() == 0){
						System.out.println("Sorry! This pet has already taken 2 actions today.");
					}else{
					play(player);
					}
					promptEnterKey();
					break;
			case 7: if(globalCurrentPet.getActions() == 0){
						System.out.println("Sorry! This pet has already taken 2 actions today.");
					}else{
						
					}
				
				break;
			case 8:
				break;
				
		}
	}
	
	public void store(Player player){
		System.out.println("Welcome to the store! What will it be today?\n");
		System.out.println("Food:");
		
	}
	
	public void play(Player player){
		Scanner scan = new Scanner(System.in);
		String toySelect= null;
		int i = 1;
		if(player.getToys().isEmpty()){
			System.out.println("You don't have any toys! Visit the store to buy some.");
			promptEnterKey();
		}else{
		for (Map.Entry<Toy, Integer> entry : player.getToys().entrySet()){
			Toy toy = entry.getKey();
			int val = entry.getValue();
			System.out.format("\n%d. %s x%d", i, toy.getName(), val);
			i++;
		}
		System.out.format("%d. quit.", i);
		do{
			if (toySelect != null){
				System.out.println("\nYou have entered an invalid number\n");
				promptEnterKey();
			}
			System.out.format("Select a toy to give to %s.\n", globalCurrentPet.getName());
			toySelect = scan.nextLine();
		} while(!toySelect.matches("[1-" + i + "]"));
		int inttoySelect = Integer.parseInt(toySelect);
		
		switch(inttoySelect){ 
			case 1:
				globalCurrentPet.play(toyChoices.get(1));
				break;
			case 2:
				globalCurrentPet.play(toyChoices.get(2));
				break;
			case 3:
				globalCurrentPet.play(toyChoices.get(3));
				break;
			case 4:
				globalCurrentPet.play(toyChoices.get(4));
				break;
			case 5:
				globalCurrentPet.play(toyChoices.get(5));
				break;
			case 6:
				globalCurrentPet.play(toyChoices.get(6));
				break;
		}
		promptEnterKey();
		}
	}
	public void  feedPet(Player player){
		Scanner scan = new Scanner(System.in);
		String foodSelect= null;
		int i = 1;
		if(player.getFood().isEmpty()){
			System.out.println("You don't have any food! Visit the store to buy some.");
			promptEnterKey();
		}else{
		for (Map.Entry<Food, Integer> entry : player.getFood().entrySet()){
			Food food = entry.getKey();
			int val = entry.getValue();
			System.out.format("\n%d. %s x%d", i, food.getName(), val);
			i++;
		}
		System.out.format("%d. quit.", i);
		do{
			if (foodSelect != null){
				System.out.println("\nYou have entered an invalid number\n");
			}
			System.out.format("Select an item to feed to %s.\n", globalCurrentPet.getName());
			foodSelect = scan.nextLine();
		} while(!foodSelect.matches("[1-" + i + "]"));
		int intFoodSelect = Integer.parseInt(foodSelect);
		
		switch(intFoodSelect){ 
			case 1:
				globalCurrentPet.feed(foodChoices.get(1));
				break;
			case 2:
				globalCurrentPet.feed(foodChoices.get(2));
				break;
			case 3:
				globalCurrentPet.feed(foodChoices.get(3));
				break;
			case 4:
				globalCurrentPet.feed(foodChoices.get(4));
				break;
			case 5:
				globalCurrentPet.feed(foodChoices.get(5));
				break;
			case 6:
				globalCurrentPet.feed(foodChoices.get(6));
				break;
		}
		}
	}
	public Species selectPet(Player player){
		String inputChoice = null;
		Scanner scan = new Scanner(System.in);
		Map<Integer, Species> petChoices = new HashMap<Integer, Species>();
		int i = 0;
		
		for(Species pet: player.getPets().values()){
			i++;
			petChoices.put(i, pet);
			}
		
		do{
			i = 0;
			if (inputChoice != null){
				System.out.println("\nYou have entered an invalid number\n");
				promptEnterKey();
			}
			for(Species pet: player.getPets().values()){
				i++;
				System.out.format("%d: %s.\n", i, pet.getName());
				petChoices.put(i, pet);
				}
			System.out.println("\nSelect a pet to interact with.");
			inputChoice = scan.nextLine();
		}
		while(!inputChoice.matches("[1-" + i + "]"));
		
//		if(petChoices.size() == 2){
//			do{
//				i = 0;
//				if (inputChoice != null){
//					System.out.println("\nYou have entered an invalid number\n");
//					promptEnterKey();
//				}
//				for(Species pet: player.getPets().values()){
//					i++;
//					System.out.format("%d: %s.\n", i, pet.getName());
//					petChoices.put(i, pet);
//					}
//				System.out.println("Select a pet to interact with.");
//				inputChoice = scan.nextLine();
//			}
//			while(!inputChoice.matches("[1-2]"));
//		}
//		if(petChoices.size() == 1){
//			do{
//				i = 0;
//				if (inputChoice != null){
//					System.out.println("\nYou have entered an invalid number\n");
//					promptEnterKey();
//				}
//				for(Species pet: player.getPets().values()){
//					i++;
//					System.out.format("%d: %s.\n", i, pet.getName());
//					petChoices.put(i, pet);
//					}
//				System.out.println("Select a pet to interact with.");
//				inputChoice = scan.nextLine();
//			}
//			while(!inputChoice.matches("[1-1]"));
//		System.out.println(inputChoice.matches("[1-1]"));
//		}
		
		int intInputChoice = Integer.parseInt(inputChoice);
		switch (intInputChoice){
			case 1: 
				return petChoices.get(1);
			case 2:
				return petChoices.get(2);
			case 3:
				return petChoices.get(3);
		}
		System.out.println("ERROR, CODE SHOULD NEVER BE REACHED");
		return species1;
		}
	
		
		
		
		
		
	
	public void help(){
		
		Properties prop = new Properties();
		InputStream input = null;
		
		try {

			input = new FileInputStream("config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			System.out.println(prop.getProperty("help1"));
			promptEnterKey();
			System.out.println(prop.getProperty("help2"));
			promptEnterKey();
			System.out.println(prop.getProperty("help3"));
			promptEnterKey();
			System.out.println(prop.getProperty("help4"));
			promptEnterKey();
			System.out.println(prop.getProperty("help5"));
			promptEnterKey();
			System.out.println(prop.getProperty("help6"));
			promptEnterKey();

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public int welcome(){
		System.out.println("Welcome to Generic Pet Game!\n");
		System.out.println("1. Start the game");
		System.out.println("2. View the help section");
		Scanner scan = new Scanner(System.in);
		String startChoice = null;
		do{
			if (startChoice != null){
			System.out.println("\nYou have entered an invalid number,"
					+ " please enter a number between 1 and 2.\n");
			}
			startChoice = scan.nextLine();
		}
		while(!startChoice.matches("[1-2]"));
		int intStartChoice = Integer.parseInt(startChoice);
		return intStartChoice;

	}
	
	public void promptStoreSection(Player player){
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the Pet Store!");
		System.out.println("Enter 1 to view the food items for sale");
		System.out.println("Enter 2 to view the food items for sale\n");
		
		System.out.println(player);
		
	}
	public void promptPetCreation(){
		Scanner scan = new Scanner(System.in);
		for (Map.Entry<String, Player> entry : players.entrySet()){
			Player player = entry.getValue();
			String strPetNum = null;
			do{
				if (strPetNum != null){
				System.out.println("\nYou have entered an invalid number,"
						    + "please enter a number between 1 and 3.\n");
				}
				System.out.format("How many pets would %s like to own? (max 3).", player.name);
				strPetNum = scan.nextLine();
			}
			while(!strPetNum.matches("[1-3]"));
			
			System.out.format("You have selected %s pet/s.\n\n", strPetNum);
			int intPetNum = Integer.parseInt(strPetNum);
			promptSpecies(player, intPetNum);
			}
		}
	
	public void promptSpecies(Player player, int petNum){
		for (int i=1; i<(petNum+1); i++){
			Scanner scan = new Scanner(System.in);
			printSpeciesInfo();

			
			String speciesNum = null;
			do{
				if (speciesNum != null){
				System.out.println("\nYou have entered an invalid number,"
						    + "please enter a number between 1 and 6.\n");
				}
				System.out.println("To choose, enter a number from 1-6...");
				System.out.format("%s, please choose a species for Pet no.%d\n", player.name, i);
				speciesNum = scan.nextLine();
			}
			while(!speciesNum.matches("[1-6]"));
			
			int species = 0;
			int intSpeciesNum = Integer.parseInt(speciesNum);
			switch (intSpeciesNum) {
				case 1:  species = 1;
                     	break;
				case 2:  species = 2;
                    	break;
				case 3:  species = 3;
                     	break;
				case 4:  species = 4;
                     	break;
				case 5:  species = 5;
						break;
				case 6:  species = 6;
						break;
			}
			
			//System.out.format("Enter a name for your new %s.\n\n", species);
			createPet(player, species);
			}
		}
	
	public void createPet(Player player, int species){
		Scanner scan = new Scanner(System.in);
		System.out.format("Enter a name for your new %s.\n", speciesChoices.get(species).getSpecies());
		String petName = scan.nextLine();
		while (existingPetNames.contains(petName)){
			System.out.println("Input error. That name belongs to another pet, please choose another.\n");
			System.out.println(String.format("Enter a name for your new %s.", speciesChoices.get(species).getSpecies()));
			petName = scan.next();
		}
		existingPetNames.add(petName);
		Species newPet = new Species (petName, speciesChoices.get(species));
		player.addPet(newPet);
	}
	
	public void printSpeciesInfo(){
		
		System.out.println("TODO PET-1 description...");
		System.out.println("TODO PET-2 description...");
		System.out.println("TODO PET-3 description...");
		System.out.println("TODO PET-4 description...");
		System.out.println("TODO PET-5 description...");
		System.out.println("TODO PET-6 description...\n");
		}
	
	 private void promptEnterKey()
	 { 
	        System.out.println("\nPress \"ENTER\" to continue...");
	        Scanner scanner = new Scanner(System.in);
	        scanner.nextLine(); 
	        
	        
	 }
	

	public void inputDayNum(){
		Scanner scan = new Scanner(System.in);
		String strDayNum = null;
		do{
			if (strDayNum != null){
				System.out.println("You have entered an invalid number, please try again to continue");
			}
			System.out.println("\nHow many days will the game run for?");
			strDayNum = scan.nextLine();
		  }
		while(!strDayNum.matches("[1-9]+"));
		System.out.format("You have selected %s day/s.\n\n", strDayNum);
		numOfDays = Double.parseDouble(strDayNum);
		
	}
	
	public void inputPlayerNum(){
		Scanner scan = new Scanner(System.in);
		String strPlayerNum = null;
		do{
			if (strPlayerNum != null){
				System.out.println("You have entered an invalid number, please enter a number between 1 and 3.\n");
			}
			System.out.println("How many players would like to play the game? (max 3).");
			strPlayerNum = scan.nextLine();
		  }
		while(!strPlayerNum.matches("[1-3]"));
		System.out.format("You have selected %s player/s.%n", strPlayerNum);
		numOfPlayers = Integer.parseInt(strPlayerNum);
	
	}
	public void createPlayers(){
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < numOfPlayers; i++){
			System.out.println(String.format("Player %d, what is your name?", i+1));
			String name = scan.next();
			
			while (players.keySet().contains(name)){
				System.out.println("Input error. That name belongs to another player, please choose another.");
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
		for (Map.Entry<Integer, Food> entry : foodChoices.entrySet()){
			Food val = entry.getValue();
			System.out.println("\n" + val);
		}
	}
	
	public void printToys(){
		for (Map.Entry<Integer, Toy> entry : toyChoices.entrySet()){
			Toy val = entry.getValue();
			System.out.println("\n" + val);
		}
	}
	
	public void printPets(){
		for (Map.Entry<Integer, Species> entry : speciesChoices.entrySet()){
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
		
		
		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					pet_gui window = new pet_gui();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	
		gameEnvironment newGame = new gameEnvironment();
		

		
		
		
		
	}
}
