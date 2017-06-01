package pet_game;

import java.util.Random;

/**
 * Pet - a class used for building Pet objects.
 * <p>
 * This contains methods for returning and configuring Pet attributes. <br>
 * Food objects created are mainly used in association with classes
 * {@link pet_game.Player} and {@link pet_game.gameEnvironment}. This is the
 * superclass of class {@link pet_game.Species}.
 * 
 * @author Robert Loomes
 * @author Mna Chalabi
 * @since Winter 2017
 * @version 1.0
 */
public class Pet {
	/**
	 * Initialize the variables of the Pet class.
	 */
	protected double moodMod;
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
	 * Default constructor method for class Pet.
	 * 
	 * @param name
	 *            the name of the Pet. Produces base variables for the initial
	 *            variables.
	 */
	public Pet(String name) {
		this.moodMod = 1;
		this.hungerMod = 1;
		this.energyMod = 1;
		this.roughness = 1;
		this.name = name;
		this.age = 0;
		this.hunger = 50;
		this.mood = 50;
		this.energy = 50;
		this.toiletNeed = 0;
		this.actions = 2;
		this.health = (25 + mood + energy - hunger - toiletNeed) / 3;
		this.alive = true;
		this.reviveAvail = true;
		this.sick = false;
		this.misbehaving = false;
	}

	/**
	 * Clone constructor method for class Pet. This is used to create an unique
	 * clone of the standard Pets created in the {@link pet_game.gameObjects},
	 * this allows the unique copies of the "same" object.
	 * 
	 * @param pet
	 *            the Pet being cloned.
	 * @param newName
	 *            a new name that overwrites the name of the Pet being cloned.
	 */
	public Pet(Pet pet, String newName) {
		this.name = newName;
		this.moodMod = pet.moodMod;
		this.hungerMod = pet.hungerMod;
		this.energyMod = pet.energyMod;
		this.age = pet.age;
		this.hunger = pet.hunger;
		this.mood = pet.mood;
		this.energy = pet.energy;
		this.toiletNeed = pet.toiletNeed;
		this.actions = pet.actions;
		this.health = (25 + pet.mood + pet.energy - pet.hunger - toiletNeed) / 3;
		this.alive = pet.alive;
		this.reviveAvail = pet.reviveAvail;
		this.sick = false;
		this.misbehaving = false;
	}

	public boolean getMisbehaving() {
		return misbehaving;
	}

	/**
	 * Getter method
	 * 
	 * @return This returns the name of Pet object.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter method
	 * 
	 * @return This returns the weight of the Pet object.
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * Getter method
	 * 
	 * @return This returns the mood of the Pet object.
	 */
	public int getMood() {
		return mood;
	}

	/**
	 * Getter method
	 * 
	 * @return This returns the hunger of the Pet object.
	 */
	public int getHunger() {
		return hunger;
	}

	/**
	 * Getter method
	 * 
	 * @return This returns the energy of the Pet object.
	 */
	public int getEnergy() {
		return energy;
	}

	/**
	 * Getter method
	 * 
	 * @return This returns the toilet need of the Pet object.
	 */
	public int getToiletNeed() {
		return toiletNeed;
	}

	/**
	 * Getter method
	 * 
	 * @return Returns true if Pet revive is available; or false if not.
	 * 
	 */
	public Boolean getRevive() {
		return reviveAvail;
	}

	/**
	 * Getter method
	 * 
	 * @return Returns true if Pet is alive; false if Pet is dead.
	 * 
	 */
	public Boolean getAlive() {
		return alive;
	}

	/**
	 * Getter method
	 * 
	 * @return Returns true if Pet is sick; false if Pet is sick.
	 * 
	 */
	public Boolean getSick() {
		return sick;
	}

	/**
	 * Getter method
	 * 
	 * @return This returns the age of the Pet object.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Getter method
	 * 
	 * @return This returns the health of the Pet object.
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * Getter method
	 * 
	 * @return This returns the actions of the Pet object.
	 */

	/**
	 * Getter method
	 * 
	 * @return This returns the mood modifier of the Pet object.
	 */
	public double getMoodMod() {
		return moodMod;
	}

	/**
	 * Getter method
	 * 
	 * @return This returns the type of species of the Pet object. Is only
	 *         relevant when evoked by the subclass {@link pet_game.Species}.
	 */
	public String getSpecies() {
		return speciesName;
	}

	/**
	 * Setter method. Used for reverting the Pet back to base stats after
	 * {@link #revive()} is called.
	 */

	public int getActions() {
		return actions;
	}

	public void setRevive(boolean bool) {
		this.reviveAvail = bool;
	}

	public void baseStats() {
		this.hunger = 50;
		this.mood = 50;
		this.energy = 50;
		this.toiletNeed = 0;
		this.actions = 2;
		this.health = (hunger + mood + energy) / 3;
		this.alive = true;
		this.sick = false;
		this.misbehaving = false;
	}

	/**
	 * The feed method can be invoked from the {@link pet_game.gameEnvironment}.
	 * Calculates the Pet variable changes based on the size of {@link Food}
	 * object parameter given.
	 * 
	 * @param food
	 *            the {@link Food} object given, is consumed from the
	 *            {@link pet_game.gameEnvironment}. after use.
	 * @return Returns a formatted String for use in the
	 *         {@link pet_game.gameEnvironment}.
	 */
	public void feed(Food food) {
		if (food.getSize() == "small") {
			weight += 25;
			toiletNeed += 25;
		} else {
			weight += 50;
			toiletNeed += 50;
		}
		energy += food.getNutrition();
		mood += food.getTastiness();
		hunger -= food.getNutrition();
		if (favFood == food.getName()) {
			mood += 25;
		}
		actions -= 1;
		maxCheck();
		minCheck();

	}

	/**
	 * The toilet method can be invoked from the
	 * {@link pet_game.gameEnvironment}. Calculates the Pet variable changes.
	 * 
	 * @return Returns a formatted String for use in the
	 *         {@link pet_game.gameEnvironment}.
	 */
	public void toilet() {
		toiletNeed -= 50;
		weight -= 20;
		actions -= 1;
		minCheck();

	}

	/**
	 * The toilet method can be invoked from the
	 * {@link pet_game.gameEnvironment}. Calculates the Pet variable changes.
	 * 
	 * @return Returns a formatted String for use in the
	 *         {@link pet_game.gameEnvironment}.
	 */
	public void sleep() {
		if (mood < 50 || energy < 50) {
			energy += 50;
		} else {
			energy += 40;
		}
		actions -= 1;
		minCheck();
		maxCheck();

	}

	/**
	 * The revive method can be invoked from the
	 * {@link pet_game.gameEnvironment}. Calculates the Pet variable changes if
	 * needed.
	 * 
	 * @return Returns a formatted String for use in the
	 *         {@link pet_game.gameEnvironment}, based on whether the Pet is
	 *         alive/dead and has revive available or not.
	 */
	public void revive() {
		if (alive == false && reviveAvail == true) {
			reviveAvail = false;
			baseStats();
		}
	}

	/**
	 * For internal use in the {@link Pet) class. Checks if any Pet variable has
	 * gone above the max limit of 100. If it has, it brings it back to the max
	 * limit.
	 * 
	 * @return Nothing.
	 */
	public void maxCheck() {
		if (mood > 100) {
			mood = 100;
		}
		if (energy > 100) {
			energy = 100;
		}
		if (health > 100) {
			health = 100;
		}
		if (hunger > 100) {
			hunger = 100;
		}
		if (toiletNeed > 100) {
			toiletNeed = 100;
		}

	}

	/**
	 * For internal use in the {@link Pet) class. Checks if any Pet variable has
	 * gone below the minimum limit of 100. If it has, it brings it back to the
	 * minimum limit.
	 * 
	 * @return Nothing.
	 */
	public void minCheck() {
		if (weight < 0) {
			weight = 0;
		}
		if (mood < 0) {
			mood = 0;
		}
		if (energy < 0) {
			energy = 0;
		}
		if (health < 0) {
			health = 0;
		}
		if (hunger < 0) {
			hunger = 0;
		}
		if (toiletNeed < 0) {
			toiletNeed = 0;
		}
	}

	/**
	 * For internal use in the {@link Pet) class. Invoked when a pet has
	 * died. @see {@link Pet#death()} Zero's out all variables.
	 * 
	 * @return Nothing.
	 */
	public void deadStats() {
		this.hunger = 0;
		this.mood = 0;
		this.energy = 0;
		this.toiletNeed = 0;
		this.actions = 0;
		this.health = (hunger + mood + energy) / 3;
		this.alive = false;
		this.sick = false;
		this.misbehaving = false;
	}

	/**
	 * For internal use in the {@link Pet) class. Invoked when a pet has
	 * died. @see {@link Pet#death()} Zero's out all variables.
	 * 
	 * @return Nothing.
	 */
	public void death() {
		if (health < 10) {
			Random random = new Random(); // 50% chance
			if (!random.nextBoolean()) {
				alive = false;
				deadStats();

			}
		}
	}

	/**
	 * The punish method can be invoked from the
	 * {@link pet_game.gameEnvironment}. Calculates the Pet variable changes if
	 * needed. Changes the misbehaving variable to false.
	 */
	public void punish() {
		misbehaving = false;
		actions -= 1;
		mood -= 10;
		minCheck();

	}

	/**
	 * The toy method can be invoked from the {@link pet_game.gameEnvironment}.
	 * Calculates the Pet variable changes based on the energy modifier variable
	 * of the Pet, and the enjoyment variable of the {@link pet_game.Toy} object
	 * parameter given.
	 * 
	 * @param toy
	 *            the {@link Toy} object given, has it's durability variable
	 *            changed for evoking the
	 *            {@link pet_game.Toy#setDurability(int)} method.
	 * @return Returns a formatted String for use in the
	 *         {@link pet_game.gameEnvironment}.
	 */
	public void play(Toy toy) {
		int dura = toy.getDurability();
		dura -= roughness;
		toy.setDurability(dura);
		energy -= energy * energyMod;
		mood += (toy.getEnjoyment() * moodMod);
		minCheck();
		maxCheck();
		actions -= 1;

	}

	/**
	 * The feed method can be invoked from the {@link pet_game.gameEnvironment}.
	 * Increases the Pet variables when evoked, and changes sick boolean to
	 * false. Evokes {@link Pet#maxCheck()}
	 * 
	 * @return Returns a formatted String for use in the
	 *         {@link pet_game.gameEnvironment}.
	 */
	public void heal() {
		sick = false;
		health += 25;
		energy += 25;
		maxCheck();
		actions -= 1;
	}

	/**
	 * The feed method can be invoked from the {@link pet_game.gameEnvironment}.
	 * When called, have a 50% chance of changing pet attribute "sick" to true
	 * if pet attribute "age" is above 1.
	 * 
	 * @return Nothing.
	 */
	public void sick() {
		if (age > 1) {
			Random randomno = new Random(); // 50% CHANCE
			if (randomno.nextBoolean() == true) {
				sick = true;
				health -= 25;
				energy -= 25;
				minCheck();
			}
		}
	}

	/**
	 * The feed method can be invoked from the {@link pet_game.gameEnvironment}.
	 * When called, have a 50% chance of changing pet attribute "misbehaving" to
	 * true if pet attriibute "age" is above 0.
	 * 
	 * @return Nothing.
	 */
	public void misbehaving() {
		if (misbehaving == false) {
			if (age > 0) {
				Random randomno = new Random(); // 50% CHANCE
				if (randomno.nextBoolean()) {
					misbehaving = true;
					health -= 10;
					energy -= 10;
					minCheck();

				}
			}
		}
	}

	/**
	 * The feed method can be invoked from the {@link pet_game.gameEnvironment}.
	 * Changes Pet stat variables Calls other methods if criteria is met.
	 * 
	 * @return Nothing.
	 */
	public void endDay() {
		if (alive == true) {
			age += 1;
			weight += 5;
			energy -= 25 * energyMod;
			hunger += hunger * hungerMod;
			actions = 2;
			if (this.sick == false) {
				sick();
				if (this.misbehaving == false) {
					misbehaving();
				}
			}
			if (this.alive == true) {
				death();
			}
		}
		minCheck();
		maxCheck();
		if (this.sick == true) {
			actions -= 1;
		}
		if (this.misbehaving == true) {
			actions -= 1;
		}

	}

	/**
	 * Overides the default toString method. Produces a formatted String of all
	 * Pet variables.
	 * 
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
		String petStats = String.format("%s %n%s %n%s %n%s %n%s %n%s %n%s %n%s %n%s %n%s %n%s %n%s", petName, petWeight,
				petAge, petMood, petEnergy, petHealth, petHunger, petToiletNeed, petAlive, petRevive, petSick,
				petMisbehave);
		return petStats;
	}
}
