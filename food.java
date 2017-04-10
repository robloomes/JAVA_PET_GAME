
public class food {
	
	
	String name;
	int price;
	float weight;
	int tastiness;
	int nutrition;
	
	
	public food(String name,int price, float weight, int testines, int nutrition){
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.tastiness = testines;
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
	
	public void setnutrition(int nutrition){
		nutrition = this.nutrition;
		
	}
	


	public static void main(String []args){
	}



}
