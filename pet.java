package pet_game;
import java.util.Random;

public class Pet {
	
	String name;
    int weight;
    int age;
    int mood;
    int stamina;
    int health;
    int hunger;
    int toiletNeed;
    int sleep;
    int actions;
    boolean alive;
    boolean reviveAvail;
    boolean sick;
  
    // Constructor
    public Pet(String name){
    	
    	this.name = name ;
        this.age = 0;
        this.hunger = 50;
        this.mood = 50;
        this.stamina = 50;
        this.sleep = 50;
        this.toiletNeed  = 0;
        this.actions = 2;
        this.health = (hunger + mood + stamina) / 3 ;
        this.alive = true;
        this.reviveAvail = false;
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
    	return reviveAvail;
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
    
    public void feed(Food food, String favouriteFood) {
    	if(actions == 0){
    		System.out.println("Sorry! This pet has already taken 2 actions today. ");
    		}
    	else{
    		if (food.size == "small"){
    			weight += 25;
    			toiletNeed += 25;}
    		else if (food.size == "large"){
    			weight += 50;
    			toiletNeed += 50;}
    		mood +=  food.tastiness;
    		hunger -= food.nutrition;
    		if (favouriteFood == food.name){
    			mood += 25;
    			}
    		actions-= 1;
    		}		
    }
    
    
    public void toilet(Food item){
    	String foodSize = item.size;
    	if(actions == 0){
    		System.out.println("Sorry! This pet has already taken 2 actions today. ");
    	}
    	else{
    		if(foodSize == "small"|| mood < 20){
    			toiletNeed -= 10; 
    		}else{
    			toiletNeed -= 20;
    		}weight -= 10;
    		actions-= 1;
    	}
    }

    public void sleep(){
    	if(actions == 0){
    		System.out.println("Sorry! This pet has already taken 2 actions today. ");
    		}
    	else{
    		if(mood < 50 || stamina < 50 ){
    			sleep -= 25;
    		}
    		actions -= 1;
    		}
    }
 
    
    public  void revive(){
    	if(actions == 0){
    		System.out.println("Sorry! This pet has already taken 2 actions today. ");
    		}
    	else{
    		if(alive == false && reviveAvail == false){
    			reviveAvail = true;
		    	alive = true;
		    	System.out.println("Your pet has revived!");
		    	System.out.println("");
		    	}
    		else if (alive == true && reviveAvail == false){	
    			System.out.print("Your pet is already alive!");
    			System.out.println("");}
    		else if (alive == false && reviveAvail == true){
    			System.out.print("Sorry, your pet is only allowed to revive once! ");
    			System.out.println("");
    			alive = false;
    			reviveAvail = true;
    		}
    		actions -= 1;
    	}
    }
    
    
    public void death(){
    	if(health < 10){
  		   Random random = new Random();
  		   boolean alive = random.nextBoolean();
  		   if(alive == false){
  			   alive = false;
  			   System.out.println("Your pet died Random");
  			   }
  		   }
    }
    
    public void punish(){
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
 			   System.out.println("Your pet is sick!");
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
	   String petRevive = "Revive: " + this.reviveAvail;
	   String petSick = "Sick: " + this.sick;
	   String stats1 = String.format("%s %n%s %n%s %n%s %n%s %n%s", petName, petWeight, petAge, petMood, petStamina, petHealth); 
	   String stats2 = String.format("%n%s %n%s %n%s %n%s %n%s %n%s", petHunger, petToiletNeed, petSleep, petAlive, petRevive, petSick);
	   return stats1 + stats2;
   }

   public static void main(String[]args){
		//unit testing
	   
		Pet cat = new Pet("lolo"); 
		System.out.println("\n"+ cat);
		cat.alive = true;
		cat.death();
		System.out.println("\n" + cat);
		cat.endDay();
		System.out.println("\n" + cat);
		cat.endDay();
		
		
	
	
   }
}

   
    	

 

