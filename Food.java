package pet_game;

public class Food {
	
	//Initializations
	String name;
	int price;
	float weight;
	int tastiness;
	int nutrition;
	
	//Constructor
	Food(String name, int price, float weight, int tastiness, int nutrition) {
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.tastiness = tastiness;
		this.nutrition = nutrition;
	}
	
	//Getters
	public String getname() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public float getWeight() {
		return weight;
	}
	
	public int gettestines() {
		return tastiness;
	}
	
	public void setNutrition(int newNutrition) { //TODO is this method needed?
	this.nutrition = newNutrition ;
	}
	
	public String toString() {
		 String foodName = "Name: " + this.name;
		 String foodPrice = "Price: " + this.price;
		 String foodWeight = "Weight: " + this.weight;
		 String foodTastiness = "Tastiness: " + this.tastiness;
		 String foodNutrition = "Nutrition: " + this.nutrition;
		 
		 String foodStats = foodName + "\n" + foodPrice + "\n" + foodWeight + "\n" + foodNutrition + "\n" + foodTastiness;
		 return foodStats;
	}
	
	public static void main(String[]args){
		//unit testing
		Food testTuna = new Food("Tuna", 18, 100, 7, 12 ); //(name, price, weight, nutrition , tastiness)
		System.out.println(testTuna);
	}

}
