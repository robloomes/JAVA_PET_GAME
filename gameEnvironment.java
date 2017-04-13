package pet_game;
import java.util.*;
import java.util.Scanner; 

public class gameEnvironment {
	
	////Initializations
	int numOfPlayers = 0;
	int numOfDays;
	
	//Toys available for purchase from store
	Toy ball = new Toy("Ball", 10, 10, 10); //(name, price, durability, enjoyment)
	Toy slinky = new Toy("Slinky", 20, 20, 20);
	Toy cube = new Toy("Cube", 30, 30, 30);
	Toy plushie = new Toy("Plushie", 40, 40, 40 );
	Toy actionFigure = new Toy("Action figure", 50, 50, 50);
	Toy bicycle = new Toy("Bicycle", 200, 100, 100);
	List<String> toyChoices = new ArrayList<String>();
	
	//Food available for purchase from store
	Food biscuit = new Food("Biscuit", 5, "small", 5, 30 ); //(name, price, size, nutrition , tastiness)
	Food fish = new Food("Fish", 10, "small", 40, 30 ); 
	Food chocolate = new Food("Chocolate", 10, "small", 5, 60 ); 
	Food cake = new Food("Cake", 20, "large", 10, 75 ); 
	Food salad = new Food("Salad", 30, "large", 50, 25 ); 
	Food roastBeef = new Food("Roast-beef", 50, "large", 75, 75 ); 
	List<String> foodChoices = new ArrayList<String>();
	
	// List<Food> foodChoices 
	// foodChoices.add(biscuit)
	
	// Move food sizes into a dictionary or enum i.e FOOD_SIZES.SMALL will return 'small'
	
	//List<String> players = new ArrayList<String>();
	List<String> pet = new ArrayList<String>();
	static Map<String, String> players = new HashMap<String, String>();
	
	gameEnvironment(){
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("How many players would like to play the game? (max 3)");
		numOfPlayers = scan.nextInt();
		while((numOfPlayers <= 0) || (numOfPlayers > 3)){
			try{
				System.out.println("How many players would like to play the game? (max 3)");
				numOfPlayers = scan.nextInt();
			} 
			
			catch (Exception e) { //TODO
				System.out.println("ERROR!");
				numOfPlayers = scan.nextInt();
				
			}
			
			}
		
		System.out.println("How many days will the game run for?");
		numOfDays = scan.nextInt();
		
		Collections.addAll(toyChoices, "Ball", "Slinky", "Cube", "Plushie", "Action-figure", "Bicycle");
		Collections.addAll(foodChoices, "Biscuit", "Fish", "Chocolate", "Cake", "Salad", "Roast-beef");
		
		// Using the List<Food> You can iterate and populate your store
		
		for (int i=1; i < numOfPlayers; i++){
			System.out.println("Player 1, what is your name?");
			String name = scan.next();
			createPlayer(name); //TODO
			
		}
	}
	
	public Object createPlayer(String name){
		Player newPlayer = new Player(name);
		return newPlayer;
	}
	
	
	public void helpSection(){
		//return help page
		//TODO
	}
	

	public void addToy(String player){
		//TODO
	}
	
	public void addPlayer(String player){
		players.put(player,"None");
	}
	
	public void addPet(String player ){
		//TODO
	}
	
	
	
	public static void main(String[]args) {
		
		
		//Unit testing
		gameEnvironment newGame = new gameEnvironment();
		
		
		newGame.addPlayer("Dennis");
		newGame.addPlayer("Harry");
		System.out.println(players);
		
		
	}
}
