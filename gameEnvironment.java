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
	private List<String> existingPetNames = new ArrayList<String>();
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
	
	private Pet pet1 = new Pet("pet1name");
	private Pet pet2 = new Pet("pet2name");
	private Pet pet3 = new Pet("pet3name"); 
	private Pet pet4 = new Pet("pet4name"); 
	private Pet pet5 = new Pet("pet5name"); 
	private Pet pet6 = new Pet("pet6name"); 
			 
	
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
		
		petChoices.put(pet1.name, pet1);
		petChoices.put(pet2.name, pet2);
		petChoices.put(pet3.name, pet3);
		petChoices.put(pet4.name, pet4);
		petChoices.put(pet5.name, pet5);
		petChoices.put(pet6.name, pet6);
		
		foodSizes.put("small", "small");
		foodSizes.put("large", "large");
		
		inputPlayerNum();
		inputDayNum();
		createPlayers();
		promptPetDetails();
		
		

		printPlayers();
	}
	
	public void promptPetDetails(){
		Scanner scan = new Scanner(System.in);
		for (Map.Entry<String, Player> entry : players.entrySet()){
			Player player = entry.getValue();
			String strPetNum = null;
			do{
				if (strPetNum != null){
				System.out.println("\nYou have entered an invalid number, please enter a number between 1 and 3.\n");
				}
				System.out.format("How many pets would %s like to own? (max 3).%n", player.name);
				strPetNum = scan.nextLine();
			}
			while(!strPetNum.matches("[1-3]"));
			
			System.out.format("You have selected %s pet/s.\n\n", strPetNum);
			int intPetNum = Integer.parseInt(strPetNum);
			promptSpecies(player, intPetNum);
			}
		scan.close();
		}
	
	public void promptSpecies(Player player, int petNum){
		for (int i=1; i<(petNum+1); i++){
			Scanner scan = new Scanner(System.in);
			printSpeciesInfo();

			
			String speciesNum = null;
			do{
				if (speciesNum != null){
				System.out.println("\nYou have entered an invalid number, please enter a number between 1 and 6.\n");
				}
				System.out.println("To choose, enter a number from 1-6...");
				System.out.format("%s, please choose a species for Pet no.%d\n", player.name, i);
				speciesNum = scan.nextLine();
			}
			while(!speciesNum.matches("[1-6]"));
			
			String species = null;
			int intSpeciesNum = Integer.parseInt(speciesNum);
			switch (intSpeciesNum) {
				case 1:  species = pet1.name;
                     	break;
				case 2:  species = pet2.name;
                    	break;
				case 3:  species = pet3.name;
                     	break;
				case 4:  species = pet4.name;
                     	break;
				case 5:  species = pet5.name;
						break;
				case 6:  species = pet6.name;
						break;
			}
			System.out.format("Enter a name for your new %s.\n\n", species);
			createPet(player, species);
			}
		}
	
	public void createPet(Player player, String species){
		Scanner scan = new Scanner(System.in);
		String petName = scan.nextLine();
		System.out.format("Enter a name for your new %s.\n\n", species);
		while (existingPetNames.contains(petName)){
			System.out.println("Input error. That name belongs to another pet, please choose another.");
			System.out.println(String.format("Enter a name for your new %s.\n\n", species));
			petName = scan.next();
		}
		//TODO create a species not a pet
		existingPetNames.add(petName);
		Pet pet = petChoices.get(species);
		pet.name = petName;
		player.addPet(pet);
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
	        System.out.println("Press \"ENTER\" to continue...");
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
				System.out.println("\nYou have entered an invalid number, please enter a number between 1 and 3.%n");
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
