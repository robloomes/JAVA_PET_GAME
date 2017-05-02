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
	private List<String> pets = new ArrayList<String>();
	private Map<String, String> players = new HashMap<String, String>();
	
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
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String strPlayerNum = null;
		do{
			if (strPlayerNum != null){
				System.out.println("Please enter a valid number between 1 and 3");
			}
			System.out.println("How many players would like to play the game? (max 3)");
			strPlayerNum = scan.nextLine();
		  }
		while(!strPlayerNum.matches("[1-3]"));
		System.out.format("You have selected %s player/s%n", strPlayerNum);
		numOfPlayers = Integer.parseInt(strPlayerNum);

		
		String strDayNum = null;
		do{
			if (strDayNum != null){
				System.out.println("Please enter a valid number");
			}
			System.out.println("How many days will the game run for?");
			strDayNum = scan.nextLine();
		  }
		while(!strDayNum.matches("[1-9]+"));
		System.out.format("You have selected %s day/s%n", strDayNum);
		numOfDays = Double.parseDouble(strDayNum);
	
			
		for (int i = 0; i < numOfPlayers; i++){
			System.out.println(String.format("Player %d, what is your name?", i+1));
			String name = scan.next();
			createPlayer(name); //TODO	
		}
		
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
		newGame.addPlayer("Dennis");
		newGame.addPlayer("Harry");
		
		
		
	}
}
