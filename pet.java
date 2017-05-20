package pet_game;
import java.util.Random;

public class Pet {
	
	protected double moodMod ;
	protected double hungerMod;
	protected double energyMod;
	protected double sleepMod;
	protected double roughness;
	protected String name;
	protected String favFood;
	protected String speciesName;
	protected String favToy;
	protected int weight;
	protected int age;
	protected int mood;
	protected int energy;
	protected int health;
	protected int hunger;
	protected int toiletNeed;
	protected int sleep;
	protected int actions;
	protected boolean alive;
	protected boolean reviveAvail;
	protected boolean sick;
	protected boolean misbehaving; 
	

  
    // Constructor
    public Pet(String name){
    	this.moodMod = 1;
    	this.hungerMod =1;
    	this.energyMod =1;
    	this.sleepMod=1;
    	this.roughness =1;
    	this.name = name ;
        this.age = 0;
        this.hunger = 50;
        this.mood = 50;
        this.energy = 50;
        this.sleep = 50;
        this.toiletNeed  = 0;
        this.actions = 2;
        this.health = (hunger + mood + energy) / 3 ;
        this.alive = true;
        this.reviveAvail = false;
        this.sick = false;
        this.misbehaving = false;
    }
    
    //Constructor for cloning the class, not just the reference
    public Pet(Pet pet, String newName){
    	this.name = newName;
    	this.moodMod = pet.moodMod;
    	this.hungerMod = pet.hungerMod;
    	this.energyMod = pet.energyMod;
    	this.sleepMod= pet.sleepMod;
        this.age = pet.age;
        this.hunger = pet.hunger;
        this.mood = pet.mood;
        this.energy = pet.energy;
        this.sleep = pet.sleep;
        this.toiletNeed  = pet.toiletNeed;
        this.actions = pet.actions;
        this.health = (pet.hunger + pet.mood + pet.energy) / 3 ;
        this.alive = pet.alive;
        this.reviveAvail = pet.reviveAvail;
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
    public int getEnergy(){
    	return energy;
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
    public int getAge(){
    	return age;
    }
    
    public int getSleep(){
    	return sleep;
    }
    
    public int getHealth(){
    	return health;
    }
    
    public int getActions(){
    	return actions;
    }
    
    public double getMoodMod(){
    	return moodMod;
    }
    
    public String getSpecies(){
    	return speciesName;
    }

    
    public void setName(String petName){
    	name = petName;
    }
   
    
    // Method
    
    public void feed(Food food) {
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
    		if (favFood == food.getName()){
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
    	System.out.format("%s feels relieved!\n", name);
    }

    public void sleep(){
    	if(actions == 0){
    		System.out.println("Sorry! This pet has already taken 2 actions today. ");
    		}
    	else if(mood < 50 || energy < 50 ){
    		sleep -= 25;
    		}
       	else{
    		sleep -= 20;
    		}	
    	actions -= 1;
    	System.out.format("%s feels refreshed!\n", name);
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
    		mood -=10 * moodMod;
    	}
    	}
    }
    

    	
    public void play(Toy toy){
    	int dura = toy.getDurability();
    	dura -= roughness;
    	
    	toy.setDurability(dura);
    	energy += energy * energyMod;
    	
    }
   
    public void sick(){
    	if(age > 2){
 		   Random randomno = new Random(); // 50% CHANCE
 		   randomno.nextBoolean();
 		   if(sick == true){
 			   health -= 50;
 			   sleep -= 25;
 			   energy -= 25;
 			   System.out.println("Your pet is sick!");
 			   }
 		   }
    }
    
    
   public void endDay(){
	   age += 1;
	   weight += weight;
	   sleep -= 25 * sleepMod;
	   hunger -= hunger* hungerMod;
	   
	   }
	 
	  
  
   public String toString() {
	   String petName = "Name: " + this.name;
	   String petWeight = "Weight: " + this.weight;
	   String petAge = "Age: " + this.age;
	   String petMood = "Mood: " + this.mood;
	   String petEnergy = "Energy: " + this.energy;
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
			   			             petMood, petEnergy, petHealth,
			   			             petHunger, petToiletNeed, petSleep,
			   			             petAlive, petRevive, petSick, petPunish); 
	   return petStats;
   }

   public static void main(String[]args){
		//unit testing
	   
		Pet cat = new Pet("lolo"); 
		Pet cat2 = new Pet(cat, "catclone");
		
		System.out.println("\n"+ cat);
		System.out.println("\n"+ cat2);
		
		System.out.println("\n"+ cat2);
		Food testTuna = new Food("Tuna", 18, "large", 7, 12 ); //(name, price, size, nutrition , tastiness)
		cat2.feed(testTuna);
		System.out.println("\n"+ cat2);
		

		
		
		
	
	
   }
}    	

 

