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
    int action;
    boolean alive;
    boolean revive;
    boolean sick;
  
      
    

 // Constructor
    public pet(String name , int weight,int moodint ,int staminaint,int health, int hunger, int toiletNeed, int sleep,int action, boolean alive ,boolean revive,boolean sick){
    	this.name = name ;
        this.weight = 50 ;
        this.age = 0;
        this.hunger = 50;
        this.mood = 50;
        this.stamina = 50;
        this.sleep = 50;
        this.toiletNeed  = 20;
        this.action = 2;
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
    
    public void feedPet(Food item,  String favouriteFood ){
    	String foodSize = item.size;
    	int foodNutrition = item.nutrition;
    	int foodTastiness = item.tastiness;
    	String foodName = item.name;
    	if(action == 0){
    		System.out.println("Sorry! you only can take action 2 times. ");
    		}
    	else{
    		if (foodSize == "small"){
    			weight += 25;
    			toiletNeed += 25;}
    		else if (foodSize == "large"){
    			weight += 50;
    			toiletNeed += 50;}
    		mood +=  foodTastiness;
    		hunger -= foodNutrition;
    		if (favouriteFood == foodName){
    			mood += 25;
    			}
    		action-= 1;
    		}		
    }
    
    
    public void toilet(Food item){
    	String foodSize = item.size;
    	if(action == 0){
    		System.out.println("Sorry! you only can take action 2 times. ");
    	}
    	else{
    		if(foodSize == "small"|| mood < 20){
    			toiletNeed -= 10; 
    		}else{
    			toiletNeed -= 20;
    		}weight -= 10;
    		action-= 1;
    	}
    }

    public void sleeping(){
    	if(action == 0){
    		System.out.println("Sorry! you only can take action 2 times. ");
    		}
    	else{
    		if(mood < 50 || stamina < 50 ){
    			sleep -= 25;
    		}
    		action -= 1;
    		}
    }
 
    
    public  void revive(){
    	if(action == 0){
    		System.out.println("Sorry! you only can take action 2 times. ");
    		}
    	else{
    		if(alive == false && revive == false){
    			revive = true;
		    	alive = true;
		    	System.out.println("Your pet revived!");
		    	System.out.println("");
		    	}
    		else if (alive == true && revive == false){	
    			System.out.print("Your pet is alread alive!");
    			System.out.println("");}
    		else if (alive == false && revive == true){
    			System.out.print("Sorry, you are only allowed to revive once! ");
    			System.out.println("");
    			alive = false;
    			revive = true;
    		}
    		action -= 1;
    	}
    }
    
    
    public void death(){
    	if(health < 10){
  		   Random random = new Random();
  		   boolean alive = random.nextBoolean();
  		   if(alive  == false){
  			   alive = false;
  			   System.out.println("Your pet died Random");
  			   }
  		   }
    }
    
    public void punishment(){
    	int randomSleep = 0;
    	Random rand = new Random();
    	while (Math.abs(sleep) != 3) {
    	    randomSleep = rand.nextInt(2) > 0 ? 1 : -1; // -1 or 1 with 50% probability
    	    sleep += randomSleep;
    	}
    	mood -= 10;	
    }
    
   // public void doctor(Player item){
    	//int balance = item.//
    		//	if
    	
    	// cost for treatment
    	// yes increase mood
    	// if no decrease mood (still sick until die or paid)
    	
    	//}
    	
   
    public void sick(){
    	if(age > 2){
 		   Random randomno = new Random();
 		   boolean sick = randomno.nextBoolean();
 		   if(sick == true){
 			   health -= 50;
 			   sleep -= 25;
 			   stamina -= 25;
 			   System.out.println("Your pet is scik! Do you want to pay for treatment? ");
 			   }
 		   }
    }
    
    
   public void endDay(){
	   age += 1;
	   weight += weight;
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
	   
		pet cat = new pet("lolo",100,55, 100, 5, 5, 10,5, 5,true, true,true); 
		System.out.println("\n"+ cat);
		cat.alive = true;
		cat.death();
		System.out.println("\n" + cat);
		cat.endDay();
		System.out.println("\n" + cat);
		cat.endDay();
		
		
	
	
   }
}

   
    	

 

