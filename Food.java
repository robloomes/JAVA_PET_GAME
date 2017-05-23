package pet_game;

public class Food {
	
	//Initializations
	String name;
	int price;
	String size;
	int tastiness;
	int nutrition;
	
	//Constructor
	Food(String name, int price, String size, int tastiness, int nutrition) {
		this.name = name;
		this.price = price;
		this.size = size;
		this.tastiness = tastiness;
		this.nutrition = nutrition;
	}
	
	//Getters
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getSize() {
		return size;
	}
	
	public int getTastiness() {
		return tastiness;
	}
	
	public int getNutrition(){
		return nutrition;
	}
	public void setNutrition(int newNutrition) { //TODO is this method needed?
		this.nutrition = newNutrition ;
	}
	
	public String toString() {
		String foodName = "Name: " + this.name;
		String foodPrice = "Price: " + this.price;
		String foodSize = "Size: " + this.size;
		String foodTastiness = "Tastiness: " + this.tastiness;
		String foodNutrition = "Nutrition: " + this.nutrition;
		 
		String result = String.format("%s %n%s %n%s %n%s %n%s", foodName, foodPrice, foodSize, foodTastiness, foodNutrition);
		return result;
	}
	
	public static void main(String[]args){
		//unit testing
		Food testTuna = new Food("Tuna", 18, "large", 7, 12 ); //(name, price, size, nutrition , tastiness)
		System.out.println(testTuna);
	}

}
