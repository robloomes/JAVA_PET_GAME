import java.util.Random;
public class pet {
	
	
	String name;
    int weight;
    int age;
    int mood;
    int stamina;
    int health;
    int hunger;
    int toiletNeed;
    int sleep;
    boolean alive;
    boolean revive;
    boolean sick;
  
      
    

 // Constructor
    public pet(String name , int weight,int moodint ,int staminaint,int health, int hunger, int toiletNeed, int sleep, boolean alive ,boolean revive,boolean sick){
    	this.name = name ;
        this.weight = weight ;
        this.age = 0;
        this.hunger = 100;
        this.mood = 100;
        this.stamina = 100;
        this.sleep = 100;
        this.toiletNeed  = 100;
        this.health= (hunger + mood + stamina)/ 3 ;
        this.alive = true;
        this.revive = false;
        this.sick = false;
    }
    
   
    // getter
    
    public String getName() {
    	return name; 
    	}
    
    public int getWeight() { 
    	return weight; 
    	}
    public int getMood(){
    	return mood;
    	}
    public int getHundger(){
    	return hunger;
    }
    public int getStamina(){
    	return stamina;
    }
    public int getToiletNeed(){
    	return toiletNeed;
    }
    public Boolean getRevive(){
    	return revive;
    }
    public Boolean getAlive(){
    	return alive;	
    }
    public Boolean getSick(){
    	return sick;
    }
    public int getSleep(){
    	return sleep;
    }
   
    
   
    
   // Method
    
    public void eat(Food item,  String favouriteFood ){
    	
    	String foodSize = item.size;
    	int foodNutrition = item.nutrition;
    	int foodTastiness = item.tastiness;
    	String foodName = item.name;
    	
    	
    	if (foodSize == "small"){
    		weight += 25;
    		toiletNeed += 25;	
    	}
    	
    	else if (foodSize == "large"){
    		weight += 50;
    		toiletNeed += 50;
    	}
    	
    	mood +=  foodTastiness;
    	hunger -= foodNutrition;

    	if (favouriteFood == foodName){
    		mood += 25;
    	}		
    }
    
    
    public void toilet(Food item){
    
    	String foodSize = item.size;
   
    	if(toiletNeed< 50){
    		mood += 25;
    	}else{
    		mood -= 25;
    	}
    	if(foodSize == "small"){
    	toiletNeed -= 10; 
    	}else{
    		toiletNeed -= 20;
    	}
    }

    public void sleep(int mood , int stamina){
    	
    if(mood > 50 && stamina > 50 ){
    	sleep += 25;
    }if(hunger > 50){
    	sleep -= 30;
    	}
    }
 
    
    public  void revive(boolean alive, boolean revive){
    	
    
    	if(alive == false && revive == false){
    	revive = true;
    	alive = true;
    	System.out.println("Your pet revived!");
    	System.out.println("");
    	}
    	else if (alive == true && revive == false){
    		
    	System.out.print("Your pet is alread alive!");
    	System.out.println("");
    	}
    	else if (alive == false && revive == true){
    		
    		System.out.print("Sorry, you are only allowed to revive once! ");
    		System.out.println("");
    		alive = false;
    		revive = true;
    	}
    }
    
    
    public void death(){
    	if(alive  == false){
    		alive = false;
    	}
    	else{
    		alive= true;
    		}
    	
    }
    
    
   public void endDay(){
	   age += 1;
	 
	   
	   if(health < 50){
		   Random randomno = new Random();
		   boolean sick = randomno.nextBoolean();
		   
		// check   
		   System.out.println("Your pet is " + sick);
		   if(sick == true){
			   health -= 50;
			   sleep -= 25;
			   stamina -= 25;
			   System.out.println("Your pet is scik"); 
		   }
	   }
	 
	  
   }
   public String toString() {
	   String petName = "Name: " + this.name;
	   String petWeight = "Weight: " + this.weight;
	   String petAge = "Age: " + this.age;
	   String petMood = "Mood: " + this.mood;
	   String petStamina = "Stamina: " + this.stamina;
	   String petHealth = "Health: " + this.health;
	   String petHunger = "Hunger: " + this.hunger;
	   String petToiletNeed = "Toilet Need: " + this.toiletNeed;
	   String petSleep= "Sleep: " + this.sleep;
	   String petAlive = "Alive: " + this.alive;
	   String petRevive = "Revive: " + this.revive;
	   String petSick = "Sick: " + this.sick;
	   String result = String.format("%s %n%s %n%s %n%s %n%s %n%s %n%s %n%s %n%s %n%s %n%s %n%s ", petName, petWeight, petAge, petMood, petStamina, petHealth, petHunger, petToiletNeed, petSleep,petAlive, petRevive, petSick); 
	   return result;
   }
   

   public static void main(String[]args){
		//unit testing
	   
		pet cat = new pet("lolo",100,50, 100, 5, 50, 50, 5, true, true,true); //(name, price, size, nutrition , tastiness)
		System.out.println(cat);
		System.out.println("________________________________________");
		//cat.sleep(0, 50);
		//System.out.println(cat);
		//cat.alive = false;
		cat.revive(false,true);
		System.out.println(cat);
		System.out.println("________________________________________");
		cat.endDay();
		System.out.println(cat);
		System.out.println("________________________________________");
	
	
	}
   
    	

 
    
    
    /*public void setDecreaeWeight(int toiletNeed) {
    	this.weight -= toiletNeed;
    }
    
    
    
    public void setAge(){
    	this.age += 1;
    	
    }
    public void setIncreaseMood(int hunger, int sleep){
    	this.mood += sleep + hunger;
    }
    public void setDecreaseMood(int hunger , int toiletNeed){
    	this.mood -= hunger - toiletNeed;
    }
    
    
    public void setIncreaseStamina(int increseStamina){
    	this.stamina += increseStamina;
    }
    
    
    public void setIDecreaseStamina(int sleep, int toiletNeed , int hunger){
    	this.stamina -= sleep - hunger - toiletNeed;
    }
    
    
    public void setIncreaseHunger(int stamina){
    	this.hunger += stamina;
    }
    public void setDecreaseHunger(int decreseHunger){
    	this.hunger -= decreseHunger;
    }
    public void setHealth(int health){
    	this.health = health;
    }
    public void setAlive(boolean alive){
    	this.alive = alive;
    }
    */
    
 

}
