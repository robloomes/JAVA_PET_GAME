import java.util.Random;

public class Pet {
	
	private double moodMul ;
	private double hungerMul;
	private double staminaMul;
	private double sleepMod;
	private double roughness;
	private String name;
	private int weight;
	private int age;
	private int mood;
	private int stamina;
	private int health;
	private int hunger;
	private int toiletNeed;
	private int sleep;
	private int actions;
	private boolean alive;
	private boolean reviveAvail;
	private boolean sick;
	private boolean misbehaving; // add
  
    // Constructor
    public Pet(String name){
    	this.moodMul = 1;
    	this.hungerMul =1;
    	this.staminaMul =1;
    	this.sleepMod=1;
    	this.roughness =1;
    	this.name = name ;
        this.age = 3;
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
    		if (food.getSize() == "small"){
    			weight += 25;
    			toiletNeed += 25;}
    		else if (food.getSize() == "large"){
    			weight += 50;
    			toiletNeed += 50;}
    		mood +=  food.getTastiness();
    		hunger -= food.nutrition;
    		if (favouriteFood == food.getName()){
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
    	if(health > 10){
  		   Random random = new Random();  // 50% chance
  		   random.nextBoolean();
  		   if(alive == false){
  			   alive = false;
  			   
  			   System.out.println("Your pet died Random");
  			   }
  		   }
    }
    
    public void punish(){
    	if(actions == 0){
    		System.out.println("Sorry! This pet has already taken 2 actions today. ");
    		}
    	else{ if(misbehaving == false && age >2){
    		mood -=10 * moodMul;
    	}
    	}
    }
    

    	
    public void play(Toy toy){
    	int dura = toy.getDurability();
    	dura -= roughness;
    	
    	toy.setDurability(dura);
    	stamina += stamina * staminaMul;
    	
    }
   
    public void sick(){
    	if(age > 2){
 		   Random randomno = new Random(); // 50% CHANCE
 		   randomno.nextBoolean();
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
	   sleep -= 25 * sleepMod;
	   hunger -= hunger* hungerMul;
	   
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
	   String petSleep= "Rested: " + this.sleep;
	   String petAlive = "Alive: " + this.alive;
	   String petRevive = "Revive: " + this.reviveAvail;
	   String petSick = "Sick: " + this.sick;
	   String petPunish = "misbehaving: " + this.misbehaving;//
	   String petStats = String.format("%s %n%s %n%s %n%s %n%s %n%s %n%s %n%s %n%s %n%s %n%s %n%s %n%s", 
			   			             petName, petWeight, petAge,
			   			             petMood, petStamina, petHealth,
			   			             petHunger, petToiletNeed, petSleep,
			   			             petAlive, petRevive, petSick, petPunish); 
	   return petStats;
   }

   public static void main(String[]args){
		//unit testing
	   
		Pet cat = new Pet("lolo"); 
		System.out.println("\n"+ cat);
		System.out.println("\n" + cat);
		cat.endDay();
		System.out.println("\n" + cat);
		cat.endDay();
		
		
	
	
   }
}    	

 

