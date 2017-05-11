import java.util.Random;

public class Pet {
	int moodMul =1;
	int hungerMul=1;
	int staminaMul=1;
	String favFood;
	String favToy;
	String species;
	int weight;
	String name;
    int age;
    int mood;
    int stamina;
    int health;
    int feed;
    int toilet;
    int sleep;
    int actions;
    boolean misbehaving;
    boolean alive;
    boolean reviveAvail;
    boolean sick;
  
    // Constructor
    public Pet(String name){
    	
    	this.name = name ;
        this.age = 0;
        this.feed = 50;
        this.mood = 50;
        this.stamina = 50;
        this.sleep = 50;
        this.toilet  = 0;
        this.actions = 2;
        this.health = (feed + mood + stamina + sleep + toilet) / 5 ;
        this.alive = true;
        this.reviveAvail = false;
        this.sick = false;
        this.misbehaving = false;
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
    public int getHunger(){
    	return feed;
    }
    public int getStamina(){
    	return stamina;
    }
    public int getToiletNeed(){
    	return toilet;
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
    	if (misbehaving = true){
    		System.out.println("Your cat not allowed to take any action due of misbehaving ");
    		
    	}
    	else{
    	if(actions == 0){
    		System.out.println("Sorry! This pet has already taken 2 actions today. ");
    		}
    	else{
    		if (food.size == "small"){
    			weight += 25;
    			toilet += 25;}
    		else if (food.size == "large"){
    			weight += 50;
    			toilet -= 50;}
    		mood +=  food.tastiness;
    		feed -= food.nutrition;
    		if (favouriteFood == food.name){
    			mood += 25;
    			}
    		actions-= 1;
    		}		
    	}
    }
    
    
    public void toilet(){
    	if (misbehaving = true){
    		System.out.println("Your cat not allowed to take any action due of misbehaving ");
    		
    	}
    	else{
    	if(actions == 0){
    		System.out.println("Sorry! This pet has already taken 2 actions today. ");
    		}
    	else{
    	weight-=25;
    	}
    	actions -= 1;
    	}
    }

    public void sleep(){
    	if (misbehaving = true){
    		System.out.println("Your cat not allowed to take any action due of misbehaving ");
    		
    	}
    	else{
    	if(actions == 0){
    		System.out.println("Sorry! This pet has already taken 2 actions today. ");
    		}
    	else{
    		
    			sleep -= 25;
    		}
    	actions -= 1;
    	}		
    }
    
    public void misbehaving(){
    	if (age >2){
    		// misbehaving = true randomly
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
		    	actions -= 1;
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
    		
    	}
    }
    
    
    public void death(){
    	if(health < 10){
  		   Random random = new Random();
  		   boolean alive = random.nextBoolean(); // what is chnace? 1/10
  		   if(alive == false){
  			   System.out.println("Your pet died Random");
  			   }
  		   }
    }
    
    public void punish(){
    	
    	misbehaving =false;
    	mood-=10;
    	System.out.println("Your pet is misbehaving and not allowed to take any action until next day!");
    }
    
   public void doctor(){
	   if (misbehaving = true){
   		System.out.println("Your cat not allowed to take any action due of misbehaving ");
   		
   	}
   	else{
	   if(actions == 0){
   		System.out.println("Sorry! This pet has already taken 2 actions today. ");
   		}
   	else{
   		health += 50;
		sleep += 25;
		stamina += 25;
   	}
   	}
	   
   }
    	
   
    public void sick(){
    	if(age > 2){
 		   Random randomno = new Random();
 		   boolean sick = randomno.nextBoolean();
 		   if(sick == true){
 			   health -= 50;
 			   sleep -= 25;
 			   stamina -= 25;
 			   mood -=20;
 			   System.out.println("Your pet is sick!");
 			   }
 		   }
    }
    
    
   public void endDay(){
	   age += 1;
	   weight += weight;
	   sleep -= 20 * staminaMul;
	   stamina -= 20;
	   mood -=10;
	   }
	 
	  
  
   public String toString() {
	   String petName = "Name: " + this.name;
	   String petWeight = "Weight: " + this.weight;
	   String petAge = "Age: " + this.age;
	   String petMood = "Mood: " + this.mood;
	   String petStamina = "Stamina: " + this.stamina;
	   String petHealth = "Health: " + this.health;
	   String petHunger = "feed: " + this.feed;
	   String petToiletNeed = "Toilet Need: " + this.toilet;
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

   
    	

 

