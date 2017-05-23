package pet_game;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.*;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class gameEnvironment extends gameObjects{
	
	////Initializations
	private Species globalCurrentPet;
	private String currentPlayer;
	private int numOfPlayers;
	private double gameDays;
	private double playerDaysTaken;
	private List<String> existingPetNames = new ArrayList<String>();
	private Map<Integer, Toy> toyChoices = new HashMap<Integer, Toy>();
	private Map<Integer, Food> foodChoices = new HashMap<Integer, Food>();
	private Map<Integer, Species> speciesChoices = new HashMap<Integer, Species>();
	private Map<String, Player> players = new HashMap<String, Player>();
	
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
		
		speciesChoices.put(1, cloud);
		speciesChoices.put(2, crab);
		speciesChoices.put(3, monster);
		speciesChoices.put(4, penguin);
		speciesChoices.put(5, robot);
		speciesChoices.put(6, snake);
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

	public void mainScreenHelper(){
		Map<Player, Integer> playerScores = new HashMap<Player, Integer>();
		
		for (Map.Entry<String, Player> entry : players.entrySet()){
			Player val = entry.getValue();
			currentPlayer = val.getName();;
			playerDaysTaken = 0;
			mainSelectScreen(val);
			System.out.format("Days for %s ended, you scored a total of %d points overall, well done!", val.getName(), score(val));
			playerScores.put(val, score(val));
			promptEnterKey();
		}
		System.out.println("Game Over...");
		System.out.println("Total scores for game:");
		
		for (Player key : playerScores.keySet()){
			System.out.format("%s: %d\n",key.getName(), playerScores.get(key));
		}
	}
	
	public void mainScreenText()
	{
		Properties prop = new Properties();
		InputStream input = null;
		
		try {

			input = new FileInputStream("config.properties");
			// load a properties file
			prop.load(input);
			// get the property value and print it out
			System.out.println(prop.getProperty("main"));
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
	
	public void mainSelectScreen(Player player){
		String input = null;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		do{
			if (input != null){
				System.out.println("\nYou have entered an invalid number,"
					        + "please enter a number between 1 and 8.\n");
				promptEnterKey();
			}
			System.out.format("Current Player: %s\n", currentPlayer);
			System.out.format("Days remaining: %1$.0f\n", (gameDays - playerDaysTaken));
			System.out.format("Current balance: $%d\n", player.getBalance());
			System.out.format("Owned pets (actions remanining):\n");
			for (Species pet : player.getPets().values()){
				System.out.format("%s (%d)\n", pet.getName(), pet.getActions());
			}
			if(globalCurrentPet == null){
				System.out.println("Current pet selected: NONE (select a pet to interact with it).");
			}else{
				System.out.format("Current pet selected: %s \n\n", globalCurrentPet.getName());
			}
			mainScreenText();
			input = scan.nextLine();
		}
		
		while(!input.matches("[1-9]" + "[0]*"));
		int intInput = Integer.parseInt(input);
		switch (intInput){
			case 1: globalCurrentPet = selectPet(player);
					mainSelectScreen(player);
					break;
			case 2: if(globalCurrentPet == null){
						System.out.println("You need to select a pet first!");
						promptEnterKey();
						mainSelectScreen(player);
					}else{
						System.out.println(globalCurrentPet); 
						promptEnterKey();
						mainSelectScreen(player);
					}
					break;
			case 3: store(player);
					mainSelectScreen(player);
					break;
			case 4: if(globalCurrentPet == null){
						System.out.println("You need to select a pet first!");
						promptEnterKey();
						mainSelectScreen(player);
					}else{
					if(globalCurrentPet.getActions() == 0){
						System.out.println("Sorry! This pet has already taken 2 actions today.");
						promptEnterKey();
					}else{
						feedPet(player);
					}
					promptEnterKey();
					mainSelectScreen(player);
					break;
					}
			case 5: if(globalCurrentPet == null){
						System.out.println("You need to select a pet first!");// error window in GUI
						promptEnterKey();
						mainSelectScreen(player);
					}else{	
						if(globalCurrentPet.getActions() == 0){
							System.out.println("Sorry! This pet has already taken 2 actions today.");
						}else{
							sleep();
						}
						promptEnterKey();
						mainSelectScreen(player);
					}
					break;
			case 6:	if(globalCurrentPet == null){
						System.out.println("You need to select a pet first!");// error window in GUI
						promptEnterKey();
						mainSelectScreen(player);
					}else{
						if(globalCurrentPet.getActions() == 0){
							System.out.println("Sorry! This pet has already taken 2 actions today.");
							promptEnterKey();
						}else{
							play(player);
						}
						promptEnterKey();
						mainSelectScreen(player);
						}
					break;
			case 7: if(globalCurrentPet == null){
						System.out.println("You need to select a pet first!");// error window in GUI
						promptEnterKey();
						mainSelectScreen(player);
					}else{
						if(globalCurrentPet.getActions() == 0){
							System.out.println("Sorry! This pet has already taken 2 actions today.");
						}else{
							toilet();
						}
						promptEnterKey();
						mainSelectScreen(player);
					}
				break;
			case 8 : if(globalCurrentPet == null){
						System.out.println("You need to select a pet first!");// error window in GUI
						promptEnterKey();
						mainSelectScreen(player);
					}else{
						if(globalCurrentPet.getActions() == 0){
							System.out.println("Sorry! This pet has already taken 2 actions today.");
						}else{
							punish();
						}
						promptEnterKey();
						mainSelectScreen(player);
			}
		break;
			case 9: if(globalCurrentPet == null){
						System.out.println("You need to select a pet first!");// error window in GUI
						promptEnterKey();
						mainSelectScreen(player);
					}else{
						if(globalCurrentPet.getActions() == 0){
							System.out.println("Sorry! This pet has already taken 2 actions today.");
						}else{
							doctor();
						}
						promptEnterKey();
						mainSelectScreen(player);
					}
					break;
			case 10: endDay(player);
			playerDaysTaken ++;
			System.out.println(playerDaysTaken);
			System.out.println(gameDays);
			promptEnterKey();
			if(playerDaysTaken < gameDays){
				mainSelectScreen(player);
				break;
			} 
				
		}
	}
	
	public void punish(){
		globalCurrentPet.punish();
	}
	
	public void doctor(){
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String doctorSelect = null;
		System.out.println("Doctor's Office:\n");
		System.out.println("1.Give pet medicine(cures sickness.");
		System.out.println("2.Revive pet(brings dead pets back to live)!");
		System.out.println("\n3.Quit.");
		
		do{
			if (doctorSelect != null){
				System.out.println("\nYou have entered an invalid number, please try again.\n");
			}
			System.out.format("Select an action for %s.\n", globalCurrentPet.getName());
			doctorSelect = scan.nextLine();
		} while(!doctorSelect.matches("[1-3]"));
		int intDoctorSelect = Integer.parseInt(doctorSelect);
		
		switch(intDoctorSelect){ 
			case 1: globalCurrentPet.heal();
				break;
			case 2: globalCurrentPet.revive();
		}
	}

	public void gameStart(){
		int intStartChoice;
		System.out.println("Welcome to Generic Pet Game!\n");
		System.out.println("1. Start the game");
		System.out.println("2. View the help section");
		@SuppressWarnings("resource")
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
		
		intStartChoice = Integer.parseInt(startChoice);
		if(intStartChoice == 2){
			help();
			gameStart();
			}
		}
	
	public void inputPlayerNum(){
	@SuppressWarnings("resource")
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
	
	public void inputDayNum(){
		@SuppressWarnings("resource")
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
		gameDays = Double.parseDouble(strDayNum);
		
	}
	
	public void createPlayers(){
		@SuppressWarnings("resource")
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
	
	public void promptPetCreation(){
	@SuppressWarnings("resource")
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
	
	public void store(Player player){
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String itemSelect= null;
		storeHelper();
		System.out.println(player);
		System.out.println();
		
		do{
			if (itemSelect != null){
				System.out.println("\nYou have entered an invalid number, please try again.\n");
			}
			System.out.format("%s, enter an item number to add it to your inventory.\n", player.getName());
			itemSelect = scan.nextLine();
		} while(!itemSelect.matches("[1-9]" + "[0-3]*"));
		int intItemSelect = Integer.parseInt(itemSelect);
		
		switch(intItemSelect){ 
			case 1:
				if ((player.getBalance() - cookie.getPrice()) < 0){
					System.out.println("You don't have enough money to make this purchase");
					promptEnterKey();
					
				}else{
				player.addFood(cookie);
				player.setBalance((player.getBalance() - cookie.getPrice()));
				}
				store(player);
				break;
			case 2:
				if ((player.getBalance() - melon.getPrice()) < 0){
					System.out.println("You don't have enough money to make this purchase");
					promptEnterKey();
				}else{
				player.addFood(melon);
				player.setBalance((player.getBalance() - melon.getPrice()));
				}
				store(player);
				break;
			case 3:
				if ((player.getBalance() - fish.getPrice()) < 0){
					System.out.println("You don't have enough money to make this purchase");
					promptEnterKey();
				}else{
				player.addFood(fish);
				player.setBalance((player.getBalance() - fish.getPrice()));
				}
				store(player);
				break;
			case 4:
				if ((player.getBalance() - chocolate.getPrice()) < 0){
					System.out.println("You don't have enough money to make this purchase");
					promptEnterKey();
				}else{
				player.addFood(chocolate);
				player.setBalance((player.getBalance() - chocolate.getPrice()));
				}
				store(player);
				break;
			case 5:
				if ((player.getBalance() - cake.getPrice()) < 0){
					System.out.println("You don't have enough money to make this purchase");
					promptEnterKey();
				}else{
				player.addFood(cake);
				player.setBalance((player.getBalance() - cake.getPrice()));
				}
				store(player);
				break;
			case 6:
				if ((player.getBalance() - pizza.getPrice()) < 0){
					System.out.println("You don't have enough money to make this purchase");
					promptEnterKey();
				}else{
				player.addFood(pizza);
				player.setBalance((player.getBalance() - pizza.getPrice()));
				}
				store(player);
				break;
			case 7:
				if ((player.getBalance() - yoyo.getPrice()) < 0){
					System.out.println("You don't have enough money to make this purchase");
					promptEnterKey();
				}else{
					//yoyo
					Toy newToy = new Toy (toyChoices.get(6));
					player.addToy(newToy);
					player.setBalance((player.getBalance() - yoyo.getPrice()));
				}
				store(player);
				break;
			case 8:
				//doll
				if ((player.getBalance() - doll.getPrice()) < 0){
					System.out.println("You don't have enough money to make this purchase");
					promptEnterKey();
				}else{
					Toy newToy = new Toy (toyChoices.get(3));
					player.addToy(newToy);
					player.setBalance((player.getBalance() - doll.getPrice()));
				}
				store(player);
				break;
			case 9:
				//bear
				if ((player.getBalance() - bear.getPrice()) < 0){
					System.out.println("You don't have enough money to make this purchase");
					promptEnterKey();
				}else{
					Toy newToy = new Toy (toyChoices.get(1));
					player.addToy(newToy);
					player.setBalance((player.getBalance() - bear.getPrice()));
				}
				store(player);
				break;
			case 10:
				//kite
				if ((player.getBalance() - kite.getPrice()) < 0){
					System.out.println("You don't have enough money to make this purchase");
					promptEnterKey();
				}else{
					Toy newToy = new Toy (toyChoices.get(5));
					player.addToy(newToy);
					player.setBalance((player.getBalance() - kite.getPrice()));
				}
				store(player);
				break;
			case 11:
				//boat
				if ((player.getBalance() - boat.getPrice()) < 0){
					System.out.println("You don't have enough money to make this purchase");
					promptEnterKey();
				}else{
					Toy newToy = new Toy (toyChoices.get(2));
					player.addToy(newToy);
					player.setBalance((player.getBalance() - boat.getPrice()));
				}
				store(player);
				break;
			case 12:
				//helicopter
				if ((player.getBalance() - heli.getPrice()) < 0){
					System.out.println("You don't have enough money to make this purchase");
					promptEnterKey();
				}else{
					Toy newToy = new Toy (toyChoices.get(4));
					player.addToy(newToy);
					player.setBalance((player.getBalance() - heli.getPrice()));
				}
				store(player);
				break;
			case 13:
				mainSelectScreen(player);
				break;
		}
	}

	public void storeHelper()
	{
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("config.properties");
			// load a properties file
			prop.load(input);
			// get the property value and print it out
			System.out.println(prop.getProperty("store"));
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

	public int score(Player player){
	int score = 0;
	
	for(Map.Entry<String, Species> entry : player.getPets().entrySet()){
		Species pet = entry.getValue();
		score += pet.getHealth();
		}
	return score;
	}

	public void endDay(Player player){
		for(Map.Entry<String, Species> entry : player.getPets().entrySet()){
			Species pet = entry.getValue();
			pet.endDay();
		}
	}
	
	public void toilet(){
		globalCurrentPet.toilet();
	}
	
	public void sleep(){
		globalCurrentPet.sleep();
	}
	
	public void play(Player player){
		Map<Integer, Toy> currentToys = new HashMap<Integer, Toy>();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String toySelect= null;
		int i = 1;
		if(player.getToys().isEmpty()){
			System.out.println("You don't have any toys! Visit the store to buy some.");
			promptEnterKey();
		}else{
		for (Map.Entry<Toy, Integer> entry : player.getToys().entrySet()){
			Toy toy = entry.getKey();
			currentToys.put(i, toy);
			int val = entry.getValue();
			System.out.format("\n%d(durability). %s(%s)", i, toy.getName(), toy.getDurability());
			i++;
		}
		System.out.format("\n\n%d. quit.", 7);
		do{
			if (toySelect != null){
				System.out.println("\nYou have entered an invalid number\n");
				promptEnterKey();
			}
			System.out.format("\nSelect a toy to give to %s.", globalCurrentPet.getName());
			toySelect = scan.nextLine();
		} while(!toySelect.matches("[1-" + (i-1) + "]?|[7]?"));
		int inttoySelect = Integer.parseInt(toySelect);
		
		switch(inttoySelect){ 
			case 1:
				globalCurrentPet.play(currentToys.get(1));
				if(currentToys.get(1).getDurability() < 0){
					player.removeToy(currentToys.get(1));
					System.out.format("Your %s broke!",currentToys.get(1).getName());
				}
				break;
			case 2:
				globalCurrentPet.play(currentToys.get(2));
				if(currentToys.get(2).getDurability() < 0){
					player.removeToy(currentToys.get(2));
					System.out.format("Your %s broke!",currentToys.get(2).getName());
				}
				break;
			case 3:
				globalCurrentPet.play(currentToys.get(3));
				if(currentToys.get(3).getDurability() < 0){
					player.removeToy(currentToys.get(3));
					System.out.format("Your %s broke!",currentToys.get(3).getName());
				}
				break;
			case 4:
				globalCurrentPet.play(currentToys.get(4));
				if(currentToys.get(4).getDurability() < 0){
					player.removeToy(currentToys.get(4));
					System.out.format("Your %s broke!",currentToys.get(3).getName());
				}
				break;
			case 5:
				globalCurrentPet.play(currentToys.get(5));
				if(currentToys.get(5).getDurability() < 0){
					player.removeToy(currentToys.get(5));
					System.out.format("Your %s broke!",currentToys.get(3).getName());
				break;
				}
			case 6:
				globalCurrentPet.play(currentToys.get(6));
				if(currentToys.get(5).getDurability() < 0){
					player.removeToy(currentToys.get(6));
					System.out.format("Your %s broke!",currentToys.get(3).getName());
				break;
				}
			case 7:
				mainSelectScreen(player);
				break;
				}
				
		}
	}
	
	
	public void  feedPet(Player player){
		Map<Integer, Food> currentFood = new HashMap<Integer, Food>();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String foodSelect= null;
		int i = 1;
		
		if(player.getFood().isEmpty()){
			System.out.println("You don't have any food! Visit the store to buy some.");
			promptEnterKey();
		}else{
		for (Map.Entry<Food, Integer> entry : player.getFood().entrySet()){
			Food food = entry.getKey();
			currentFood.put(i, food);
			int val = entry.getValue();
			System.out.format("\n%d. %s x%d", i, food.getName(), val);
			i++;
		}
		System.out.format("\n%d. quit.\n", i);
		
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
				globalCurrentPet.feed(currentFood.get(1));
				player.removeFood(currentFood.get(1));
				break;
			case 2:
				globalCurrentPet.feed(currentFood.get(2));
				player.removeFood(currentFood.get(2));
				break;
			case 3:
				globalCurrentPet.feed(currentFood.get(3));
				player.removeFood(currentFood.get(3));
				break;
			case 4:
				globalCurrentPet.feed(currentFood.get(4));
				player.removeFood(currentFood.get(4));
				break;
			case 5:
				globalCurrentPet.feed(currentFood.get(5));
				player.removeFood(currentFood.get(5));
				break;
			case 6:
				globalCurrentPet.feed(currentFood.get(6));
				player.removeFood(currentFood.get(6));
				break;
		}
		}
	}
	
	public Species selectPet(Player player){
		String inputChoice = null;
		@SuppressWarnings("resource")
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
		
		return crab;
		}
	
	public void promptStoreSection(Player player){
		System.out.println("Welcome to the Pet Store!");
		System.out.println("Enter 1 to view the food items for sale");
		System.out.println("Enter 2 to view the food items for sale\n");
		System.out.println(player);
	}
	
	public void promptSpecies(Player player, int petNum){
		for (int i=1; i<(petNum+1); i++){
			@SuppressWarnings("resource")
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
			createPet(player, species);
			}
		}
	
	public void createPet(Player player, int species){
		@SuppressWarnings("resource")
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
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("config.properties");
			// load a properties file
			prop.load(input);
			// get the property value and print it out
			System.out.println(prop.getProperty("species1"));
			System.out.println(prop.getProperty("species2"));
			System.out.println(prop.getProperty("species3"));
			System.out.println(prop.getProperty("species4"));
			System.out.println(prop.getProperty("species5"));
			System.out.println(prop.getProperty("species6"));

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
	
	 private void promptEnterKey(){
		 System.out.println("\nPress \"ENTER\" to continue...");
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); 
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
		gameEnvironment newGame = new gameEnvironment();
//		newGame.gameStart();
//		newGame.inputPlayerNum();
//		newGame.inputDayNum();
//		newGame.createPlayers();
//		newGame.promptPetCreation();
//		newGame.mainScreenHelper();
	}
}
