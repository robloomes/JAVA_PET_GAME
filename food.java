
public class Food {
	
	
	String name;
	int price;
	float weight;
	int tastiness;
	int nutrition;
	
	
	Food(String name,int price, float weight, int tastiness, int nutrition){
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.tastiness = tastiness;
		this.nutrition = nutrition;
	}
	

	
	// getter
	
	public String getname(){
	return name;
	}
	
	public int getPrice(){
		return price;
	}
	
	public float getWeight(){
		return weight;
	}
	
	public int gettestines(){
		return tastiness;
	}
	
	public void setnutrition(int newNutrition){
	this.nutrition = newNutrition ;
		
	}
	


	
	public String toString() {
		 String foodName = "Name: " + this.name;
		 String foodPrice = "Price: " + this.price;
		 String foodWeight = "weight: " + this.weight;
		 String foodTastiness = "tastiness: " + this.tastiness;
		 String foodNutrition = "nutrition: " + this.nutrition;
		 
		 
		 String foodStats = foodName + "\n" + foodPrice + "\n" + foodWeight + "\n" + foodNutrition + "\n" + foodTastiness ;
		 return foodStats;
	}
	public static void main(String[]args){
		//unit testing
		Food testTuna = new Food("toby", 18, 100, 7, 12 ); //(name, price, weight, nutrition , tastiness )
		System.out.println(testTuna);
	}



}
