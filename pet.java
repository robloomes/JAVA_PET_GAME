package pet_game;
import java.util.Random;
public class Pet {
	
	protected double moodMod ;
	protected double hungerMod;
	protected double energyMod;
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
    	this.roughness =1;
    	this.name = name ;
        this.age = 0;
        this.hunger = 50;
        this.mood = 50;
        this.energy = 50;
        this.toiletNeed  = 0;
        this.actions = 2;
        this.health = (25 + mood + energy - hunger - toiletNeed) / 3 ;
        this.alive = true;
        this.reviveAvail = true;
        this.sick = false;
        this.misbehaving = false;
    }
    
    //Constructor for cloning the class, not just the reference
    public Pet(Pet pet, String newName){
    	this.name = newName;
    	this.moodMod = pet.moodMod;
    	this.hungerMod = pet.hungerMod;
    	this.energyMod = pet.energyMod;
        this.age = pet.age;
        this.hunger = pet.hunger;
        this.mood = pet.mood;
        this.energy = pet.energy;
        this.toiletNeed  = pet.toiletNeed;
        this.actions = pet.actions;
        this.health = (25 + pet.mood + pet.energy - pet.hunger - toiletNeed) / 3 ;
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
    public void baseStats(){
        this.hunger = 50;
        this.mood = 50;
        this.energy = 50;
        this.toiletNeed  = 0;
        this.actions = 2;
        this.health = (hunger + mood + energy) / 3 ;
        this.alive = true;
        this.sick = false;
        this.misbehaving = false;
    }
    public void feed(Food food) {
    	if(actions == 0){
    		System.out.println("Sorry! This pet is out of actions today.");
    		}
    	else{
    		if (food.getSize() == "small"){
    			weight += 25;
    			toiletNeed += 25;}
    		else if (food.getSize() == "large"){
    			weight += 50;
    			toiletNeed += 50;}
    		energy += food.getNutrition();
    		mood +=  food.getTastiness();
    		hunger -= food.nutrition;
    		if (favFood == food.getName()){
    			mood += 25;
    			}
       		actions-= 1;
    		maxCheck();
    		minCheck();
    		System.out.format("*chomp..chomp..chomp* %s enjoyed the food!\n", name);
    	}		
	}
    
    public void toilet(){
    	if(actions == 0){
    		System.out.println("Sorry! This pet is out of actions today.");
    	}
    	else{
    		toiletNeed -= 50; 

    		weight -= 20;
    		actions -= 1;
    		minCheck();
    	}
    	
    }

    public void sleep(){
    	if(actions == 0){
    		System.out.println("Sorry! This pet is out of actions today.");
    		}
    	else if(mood < 50 || energy < 50 ){
    		energy += 50;
    		}
       	else{
    		energy += 40;
    		}	
    	actions -= 1;
    	System.out.format("%s feels refreshed!\n", name);
		minCheck();
		}
    
    public  void revive(){
    	if(alive == false && reviveAvail == true){
			reviveAvail = false;
	    	baseStats();
	    	System.out.println("Your pet has revived!");
    	}else if (alive == true){	
    		System.out.print("Your pet is already alive!");
    	}else if (alive == false && reviveAvail == false){
	    	System.out.print("Sorry, your pet is only allowed to revive once! ");
		}
	}
    
    
    public void maxCheck(){
    	if(mood > 0){
    		mood = 100;
    	}
    	if(energy > 0){
    		mood = 100;
    	}
    	if(health > 0){
    		mood = 100;
    	}
    	if(hunger > 0){
    		mood = 100;
    	}
    	if(toiletNeed > 0){
    		mood = 100;
    	}
    	if(toiletNeed > 0){
    		toiletNeed = 100;
    	}
    }
    
    public void minCheck(){
    	if(weight < 0){
    		weight = 0;
    	}
    	if(mood < 0){
    		mood = 0;
    	}
    	if(energy < 0){
    		mood = 0;
    	}
    	if(health < 0){
    		mood = 0;
    	}
    	if(hunger < 0){
    		mood = 0;
    	}
    	if(toiletNeed < 0){
    		mood = 0;
    	}

    	if(toiletNeed < 0){
    		toiletNeed = 0;
    	}
    }
    
    public void  deadStats(){
        this.hunger = 0;
        this.mood = 0;
        this.energy = 0;
        this.toiletNeed  = 0;
        this.actions = 0;
        this.health = (hunger + mood + energy) / 3 ;
        this.alive = false;
        this.sick = false;
        this.misbehaving = false;
    }
    
    public void death(){
    	if(health < 10){
  		   Random random = new Random();  // 50% chance
  		   if(!random.nextBoolean()){
  			   alive = false;
  			   System.out.println("Your pet died from a random illness!");
  			   System.out.println("If the pet has not died before, he can be revived from the doctor!");
  			   deadStats();
  			   System.out.println(health);
  			   }
  		   }
    }
    
    public void punish(){
    	if(actions == 0){
    		System.out.println("Sorry! This pet is out of actions today.");
    		} else {
    			misbehaving = false;
    			System.out.format("%s is upset, but is now under control", name);
    			mood -= 10;
    			minCheck();
			}
	}

    public void play(Toy toy){
    	int dura = toy.getDurability();
    	dura -= roughness;
    	toy.setDurability(dura);
    	energy -= energy * energyMod;
    	mood += (toy.getEnjoyment() * moodMod);
    	maxCheck();
    	System.out.println();
    	System.out.format("%s is feeling happier!\n", name);
    	actions -= 1;
	 }
    
    public void heal(){
    	sick = false;
    	health += 25;
    	energy += 25;
    	maxCheck();
    	System.out.format("%s is feeling much better already!", name);
    }
    
    public void sick(){
    	if(age > 1){
 		   Random randomno = new Random(); // 50% CHANCE
 		   if(randomno.nextBoolean() == true){
 			   sick = true;
 			   health -= 25;
 			   energy -= 25;
 			   minCheck();
 			   System.out.format("%s is sick! This causes your pet to waste 1 action per day.", this.name);
 			   System.out.println(" Your pet can be treated at the doctor's (this will use an action).");
		   }
	   }
    }
    
    public void misbehaving(){
    	if(misbehaving == false){
			if(age > 0){
			   Random randomno = new Random(); // 50% CHANCE
			   if(randomno.nextBoolean()){
				   misbehaving = true;
				   health -= 10;
				   energy -= 10;
				   System.out.format("%s is misbehaving! This causes your pet to lose 1 action per day.", this.name);
				   System.out.println(" Your pet can be punished (this will use an action).");
				   minCheck();
  			   }
  		   }
    	}
    }
    
    public void endDay(){
    	if(alive==true){
    		age += 1;
    		weight += 5;
    		energy -= 25 * energyMod;
    		hunger += hunger * hungerMod;
    		actions = 2;
    		if(this.sick==false){
    		sick();
    			if(this.misbehaving==false){
    				misbehaving();
    			}
    		}
    		if(this.alive==true){
    			death();	
    		}
		 }
		minCheck();
		maxCheck();
    	if(this.sick == true){
    		actions -= 1;
    	}
    	if(this.misbehaving == true){
    		actions -= 1;
    	}

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
	   String petAlive = "Alive: " + this.alive;
	   String petRevive = "Revive Available: " + this.reviveAvail;
	   String petSick = "Is sick: " + this.sick;
	   String petMisbehave = "Is misbehaving: " + this.misbehaving;
	   String petStats = String.format("%s %n%s %n%s %n%s %n%s %n%s %n%s %n%s %n%s %n%s %n%s %n%s %n%s", 
			   			             petName, petWeight, petAge,
			   			             petMood, petEnergy, petHealth,
			   			             petHunger, petToiletNeed,
			   			             petAlive, petRevive, petSick, 
			   			             petMisbehave); 
	   return petStats;
  	}

   public static void main(String[]args){
		//unit testing
	    Pet cat = new Pet("lolo"); 
		System.out.println(cat);
		cat.endDay();
		cat.endDay();
		cat.endDay();
		cat.endDay();
		cat.endDay();
		cat.endDay();
		cat.endDay();
		cat.endDay();
		cat.endDay();
		cat.endDay();
		cat.endDay();
		System.out.println(cat.getHealth());
   }
}    	

 

