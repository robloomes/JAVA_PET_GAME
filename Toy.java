package pet_game;
public class Toy {
	
	//Initializations
	String name;
	int price;
	int durability;
	int enjoyment;
	
	//Constructor for Toy class
	Toy(String name, int price, int durability, int enjoyment) {
		this.name = name;
		this.price = price;
		this.durability = durability;
		this.enjoyment = enjoyment;
	}	
	
	//Constructor for clone class
	Toy(Toy toy) {
		this.name = toy.getName();
		this.price = toy.getPrice();
		this.durability = toy.getDurability();
		this.enjoyment = toy.getEnjoyment();
	}	
	
	//Getters
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getDurability() {
		return durability;
	}
	
	public int getEnjoyment() {
		return enjoyment;
	}
	
	//Setters
	public void setDurability(int newDurability) {
		this.durability = newDurability;
	}
	
	public String toString() {
		//Output format
		String toyName = "Name: " + this.name;
		String toyPrice = "Price: " + this.price;
		String toyDurability = "Durability: " + this.durability;
		String toyEnjoyment = "Enjoyment: " + this.enjoyment;

		String result = String.format("%s %n%s %n%s %n%s",toyName, toyPrice, toyDurability, toyEnjoyment);
		return result;
	}
	
	public static void main(String[]args) {
		//Unit testing
		Toy testBall = new Toy("Ball", 18, 100, 7); //(name, price, durability, enjoyment)
		System.out.println(testBall);

	   
	}
	
}
