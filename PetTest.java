package pet_game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
/**
 * Methods implementing random events are not tested.
 * @author Robert
 *
 */
public class PetTest {

	@Test
	public void test() {

		Pet test = new Pet("lolo");
		Food testFood = new Food("tuna", 10, "small", 2, 3);
		int oldWeight = test.weight;
		int oldToilet = test.toiletNeed;
		test.feed(testFood);
		assertEquals(oldWeight + 25, test.getWeight());
		assertEquals(oldToilet + 25, test.getToiletNeed());
	}

	@Test
	public void testPet() {

		Pet test = new Pet("lolo");
		Food testFood = new Food("tuna", 10, "large", 2, 3);
		int oldWeight = test.weight;
		int oldToilet = test.toiletNeed;
		test.feed(testFood);
		assertEquals(oldWeight + 50, test.weight);
		assertEquals(oldToilet + 50, test.toiletNeed);
	}

	@Test
	public void testFeed() {
		Pet test = new Pet("lolo");
		Food testFood = new Food("tuna", 10, "large", 2, 3);
		int oldWeight = test.weight;
		int oldToilet = test.toiletNeed;
		int oldMood = test.mood;
		int oldEnergy = test.energy;
		int oldHunger = test.hunger;
		int oldActions = test.actions;
		test.feed(testFood);
		assertEquals(oldWeight + 50, test.weight);
		assertEquals(oldToilet + 50, test.toiletNeed);
		assertEquals(oldMood + 2, test.mood);
		assertEquals(oldEnergy + 3, test.energy);
		assertEquals(oldHunger - 3, test.hunger);
		assertEquals(oldActions - 1, test.actions);
		;
	}

	@Test
	public void testToilet() {
		Pet test = new Pet("lolo");
		int oldWeight = test.weight;
		int oldActions = test.actions;
		int oldToilet = test.toiletNeed;
		test.toilet();
		assertEquals(oldWeight - 0, test.weight);
		assertEquals(oldActions - 1, test.actions);
		assertEquals(oldToilet - 0, test.toiletNeed);
		test.toilet();
		assertEquals(oldActions - 2, test.actions);
	}

	@Test
	public void testSleep() {
		Pet test = new Pet("lo");
		int oldActions = test.actions;
		int oldEnergy = test.energy;
		test.sleep();
		assertEquals(oldActions - 1, test.actions);
		assertEquals(oldEnergy + 40, test.energy);
		test.sleep();
		assertEquals(oldActions - 2, test.actions);
		assertEquals(oldEnergy + 50, test.energy);
	}

	@Test
	public void testRevive() {
		Pet test = new Pet("lo");
		int oldActions = test.actions;
		test.alive = false;
		test.deadStats();
		test.revive();
		assertEquals(oldActions, test.actions);
		assertEquals(50, test.energy);
		assertEquals(50, test.mood);
		assertEquals(50, test.hunger);
		assertEquals(0, test.toiletNeed);

	}

	@Test
	public void testMaxCheck() {
		Pet test = new Pet("lo");
		test.energy = 9999;
		test.mood = 9999;
		test.health = 9999;
		test.hunger = -9999;
		int oldHunger = test.hunger;
		test.toiletNeed = -9999;
		int oldToilet = test.toiletNeed;
		test.maxCheck();
		assertEquals(100, test.energy);
		assertEquals(100, test.mood);
		assertEquals(100, test.health);
		assertEquals(oldHunger, test.hunger);
		assertEquals(oldToilet, test.toiletNeed);

	}

	@Test
	public void testMinCheck() {
		Pet test = new Pet("lo");
		test.energy = 9999;
		int oldEnergy = test.energy;
		test.mood = 9999;
		int oldMood = test.mood;
		test.health = 9999;
		int oldHealth = test.health;
		test.hunger = -9999;
		test.toiletNeed = -9999;
		test.minCheck();
		assertEquals(oldEnergy, test.energy);
		assertEquals(oldMood, test.mood);
		assertEquals(oldHealth, test.health);
		assertEquals(0, test.hunger);
		assertEquals(0, test.toiletNeed);
	}

	@Test
	public void testPunish() {
		Pet test = new Pet("lo");
		boolean oldMisbehaving = test.misbehaving;
		int oldMood = test.mood;
		test.punish();
		assertEquals(false, oldMisbehaving);
		assertEquals(oldMood - 10, test.mood);
		
	}

	@Test
	public void testPlay() {
		Pet testPet = new Pet("lo");
		Toy testToy = new Toy("Bear", 5, 10, 20);  //(name, price, durability, enjoyment)
		int oldEnergy = testPet.energy;
		int oldDura = testToy.durability;
		int oldMood = testPet.mood;
		testPet.play(testToy);
		assertEquals(oldMood + testToy.enjoyment, testPet.mood);
		assertEquals(oldDura - 1,testToy.durability);
		assertEquals(oldMood + 20, testPet.mood);
		
	}

	@Test
	public void testHeal() {
		Pet test = new Pet("lo");
		int oldEnergy = test.energy;
		test.sick = true;
		test.heal();
		assertEquals(oldEnergy + 25, test.energy);
		assertEquals(false, test.sick);
	}

	@Test
	public void testEndDay() {
		Pet test = new Pet("lo");
		test.age = 1;
		test.weight = 10;
		test.energyMod = 2;
		test.sick = true;
		int oldAge = test.age;
		int oldWeight = test.weight;
		int oldEnergy = test.energy;
		test.misbehaving = true;
		test.sick = true;
		test.endDay();
		assertEquals(oldAge + 1, test.age);
		assertEquals(oldWeight + 5, test.weight);
		assertEquals(oldEnergy + 50, test.energy);
	}
			
}
		


