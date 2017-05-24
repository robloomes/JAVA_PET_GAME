package pet_game;
import java.util.Random;
/**
 * Pet.java - a class used for building Pet objects.
 * <p>
 * This contains methods for returning and changing  Pet attributes
 * Pet objects created are mainly used in association with class @see gameEnvironment. 
 * 
 * @author Robert Loomes
 * @author Mna Chalabi
 * @since Winter 2017
 * @version 1.0
 */	
public class Pet {
	/**
	 * Initialize the variables of the class
	 */
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
	/**
	 * Constructor method for Pet class.
	 * @param moodMod A variable of type double.
	 * @param hungerMod A variable of type double.
	 * @param energyMod A variable of type double.
	 * @param roughness A variable of type double
	 * @param name A variable of type string.
	 * @param favFood A variable of type string.
	 * @param speciesName A variable of type string.
	 * @param favToy A variable of type string.
	 * @param weight A variable of type integer.
	 * @param age A variable of type integer.
	 * @param mood A variable of type integer.
	 * @param energy A variable of type integer.
	 * @param health A variable of type integer.
	 * @param hunger A variable of type integer.
	 * @param toiletNeed A variable of type integer.
	 * @param actions A variable of type integer.
	 * @param alive A variable of type boolean.
	 * @param reviveAvail A variable of type boolean.
	 * @param sick A variable of type boolean.
	 * @param misbehaving A variable of type boolean.
	 * @return Nothing.
	 */
	

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
    
    /**
	 * Getter method
	 * @return This returns the String name variable.
	 */
    public String getName() {
    	return name; 
    }
    
    /**
   	 * Getter method
   	 * @return This returns the String speciesName variable.
   	 */
       public String getSpecies(){
       	return speciesName;
     }
    
    /**
	 * Getter method
	 * @return This returns the integer weight variable.
	 */
    public int getWeight() { 
    	return weight; 
    }
    
    /**
	 * Getter method
	 * @return This returns the integer mood variable.
	 */
    public int getMood(){
    	return mood;
    }
    
    /**
	 * Getter method
	 * @return This returns the integer hunger variable.
	 */
    public int getHunger(){
    	return hunger;
    }
    
    /**
	 * Getter method
	 * @return This returns the integer energy variable.
	 */
    public int getEnergy(){
    	return energy;
    }
    
    /**
	 * Getter method
	 * @return This returns the integer toiletNeed variable.
	 */
    public int getToiletNeed(){
    	return toiletNeed;
    }
    
    /**
	 * Getter method
	 * @return This returns the Boolean reviveAvail variable.
	 */
    public Boolean getRevive(){
    	return reviveAvail;
    }
    
    /**
	 * Getter method
	 * @return This returns the reviveAvail alive variable.
	 */
    public Boolean getAlive(){
    	return alive;	
    }
    
    /**
	 * Getter method
	 * @return This returns the Boolean sick variable.
	 */
    public Boolean getSick(){
    	return sick;
    }
    
    /**
	 * Getter method
	 * @return This returns the integer age variable.
	 */
    public int getAge(){
    	return age;
    }
    
    /**
	 * Getter method
	 * @return This returns the integer health variable.
	 */
    
    
    public int getHealth(){
    	return health;
    }
    
    /**
	 * Getter method
	 * @return This returns the integer actions variable.
	 */
    public int getActions(){
    	return actions;
    }
    
    /**
	 * Getter method
	 * @return This returns the double moodMod variable.
	 */
    public double getMoodMod(){
    	return moodMod;
    }
    
    /**
	 * Sets the String petName variable to a new string.
	 * @param petName this is the new variable for string petName.
	 */
    
       
    public void setName(String petName){
    	name = petName;
    }
   
    /**
     * Setting values for some variable
     */
    
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
    
    /**
     * feed is Method that allow the pet to eat.
     * @param food is class has been used to indicate the size of food.
     */
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

    /**
     * Method that allow the Pets to sleep. 
     */
    public void sleep(){
    	if(actions == 0){
    		System.out.println("Sorry! This pet is out of actions today.");
    		}
    	else if(mood < 50 || energy < 50 ){
    		energy += 40;
    		}
       	else{
    		energy += 30;
    		}	
    	actions -= 1;
    	System.out.format("%s feels refreshed!\n", name);
		minCheck();
		maxCheck();
		}
    
    /**
     * Method that allow the pets to revive after death. 
     */
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
    
    /**
     * maxCheck is method that set the values to 100 if it reach more than 100. 
     */
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
    
    /**
     * minCheck is method that set the values to 0 if it goes to negative. 
     */
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
    
    /**
     * deadStats is method that put all the variable to 0 while the pet died.
     */
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
    
    /**
     * death is Method that makes the pet die randomly if the health less than 100.
     */
    public void death(){
    	if(health < 10){
  		   Random random = new Random();  
  		   if(!random.nextBoolean()){
  			   alive = false;
  			   System.out.println("Your pet died from a random illness!");
  			   System.out.println("If the pet has not died before, he can be revived from the doctor!");
  			   deadStats();
  			   }
  		   }
    }
    
    /**
     * punish is method that punish the pet if he/ she misbehave.
     */
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
    
    /**
     * @param toy this is a variable used from Toy.java.
     */
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
    
    /**
     * heath method that check the health of the pet.
     */
    public void health(){
    	sick = false;
    	health += 25;
    	energy += 25;
    	maxCheck();
    	System.out.format("%s is feeling much better already!", name);
    }
    
    /**
     * sick is method that makes the pet sick randomly if he/she older than 1 day with 50 % chance.
     */
    public void sick(){
    	if(age > 1){
 		   Random randomno = new Random(); 
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
    
    /**
     * misbehaving is method that makes the pet misbehave randomly if he/she older than 1 day with 50 % chance.
     */
    public void misbehaving(){
    	if(misbehaving == false){
			if(age > 0){
			   Random randomno = new Random(); 
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
    /**
     * endDay is method that increase the value of age and action and decreases energy.
     */
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
    
    /**
	 * Overides the default toString method.
	 * Produces a formatted String of all Pet variables.
	 * @return Formatted String.
	 */ 
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
	   String petStats = String.format("%s %n%s %n%s %n%s %n%s %n%s %n%s %n%s %n%s %n%s %n%s %n%s", 
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
		
   }
}    	

 

