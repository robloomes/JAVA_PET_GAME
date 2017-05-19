package pet_game;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;
import java.awt.EventQueue;


import java.util.Properties;

public class gameEnvironment{
	
	////Initializations
	private pet_gui GUI = new pet_gui();
	private String currentPlayer;
	private int numOfPlayers;
	private double numOfDays;
	private List<String> existingPetNames = new ArrayList<String>();
	private Map<String, String> foodSizes = new HashMap<String, String>();
	private Map<String, Toy> toyChoices = new HashMap<String, Toy>();
	private Map<String, Food> foodChoices = new HashMap<String, Food>();
	private Map<String, Species> speciesChoices = new HashMap<String, Species>();
	private Map<String, Player> players = new HashMap<String, Player>();
	
	//Toys available for purchase from store
	private Toy ball = new Toy("Ball", 10, 10, 10); //(name, price, durability, enjoyment)
	private Toy slinky = new Toy("Slinky", 20, 20, 20);
	private Toy cube = new Toy("Cube", 30, 30, 30);
	private Toy plushie = new Toy("Plushie", 40, 40, 40 );
	private Toy actionFigure = new Toy("Action figure", 50, 50, 50);
	private Toy bicycle = new Toy("Bicycle", 200, 100, 100);
	
	//Food available for purchase from store
	//(name, price, size, nutrition , tastiness)
	private Food biscuit = new Food("Biscuit", 5, "small", 5, 30 ); 
	private Food fish = new Food("Fish", 10, "small", 40, 30 ); 
	private Food chocolate = new Food("Chocolate", 10, "small", 5, 60 ); 
	private Food cake = new Food("Cake", 20, "large", 10, 75 ); 
	private Food salad = new Food("Salad", 30, "large", 50, 25 ); 
	private Food roastBeef = new Food("Roast-beef", 50, "large", 75, 75 ); 
	
	//All species available for creation. Species are differentiated by their attributes.
	//Name, mood, hunger, stamina, favFood, favToy, species, weight, roughness
	private Species species1 = new Species("species1name", 1.0, 1.0, 1.0, biscuit.getName(),
			                                          ball.getName(), "species1", 100, 1.0); 
	private Species species2 = new Species("species2name", 1.1, 1.1, 1.1, biscuit.getName(),
			                                          ball.getName(), "species2", 100, 1.1);
	private Species species3 = new Species("species3name", 1.2, 1.2, 1.2, biscuit.getName(),
			                                          ball.getName(), "species3", 100, 1.2); 
	private Species species4 = new Species("species4name", 1.3, 1.3, 1.3, biscuit.getName(),
			                                          ball.getName(), "species4", 100, 1.3); 
	private Species species5 = new Species("species5name", 1.4, 1.4, 1.4, biscuit.getName(),
			                                          ball.getName(), "species5", 100, 1.4); 
	private Species species6 = new Species("species6name", 1.5, 1.5, 1.5, biscuit.getName(),
			                                          ball.getName(), "species6", 100, 1.5); 
			 
	
	gameEnvironment(){

		
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
		
		speciesChoices.put(species1.getSpecies(), species1);
		speciesChoices.put(species2.getSpecies(), species2);
		speciesChoices.put(species3.getSpecies(), species3);
		speciesChoices.put(species4.getSpecies(), species4);
		speciesChoices.put(species5.getSpecies(), species5);
		speciesChoices.put(species6.getSpecies(), species6);
		
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
		GUI.label.setText("gg");
		
		

	}
	public void promptPetDetails(){
		
	
	}
	

	public void mainSelectScreen(Player player){
		String input = null;
		String currentPet = "None";
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
			System.out.format("Current pet selected: %s \n", currentPet);
			System.out.println("\n1. Select a pet to view and interact with.");
			System.out.println("2. View status of your pets.");
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
			case 1: 
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
				
		}
		
		
		
		
		
		
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
			
			Species species = null;
			int intSpeciesNum = Integer.parseInt(speciesNum);
			switch (intSpeciesNum) {
				case 1:  species = species1;
                     	break;
				case 2:  species = species2;
                    	break;
				case 3:  species = species3;
                     	break;
				case 4:  species = species4;
                     	break;
				case 5:  species = species5;
						break;
				case 6:  species = species6;
						break;
			}
			
			//System.out.format("Enter a name for your new %s.\n\n", species);
			createPet(player, species);
			}
		}
	
	public void createPet(Player player, Species species){
		Scanner scan = new Scanner(System.in);
		System.out.format("Enter a name for your new %s.\n", species.getSpecies());
		String petName = scan.nextLine();
		while (existingPetNames.contains(petName)){
			System.out.println("Input error. That name belongs to another pet, please choose another.");
			System.out.println(String.format("Enter a name for your new %s.\n\n", species.getSpecies()));
			petName = scan.next();
		}
		//TODO create a species not a pet
		existingPetNames.add(petName);
		Species newPet = speciesChoices.get(species.getSpecies());
		newPet.setName(petName);
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
		for (Map.Entry<String, Species> entry : speciesChoices.entrySet()){
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
