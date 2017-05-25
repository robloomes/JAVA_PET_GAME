package pet_game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

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
	public void testDeadStats() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeath() {
		fail("Not yet implemented");
	}

	@Test
	public void testPunish() {
		fail("Not yet implemented");
	}

	@Test
	public void testPlay() {
		fail("Not yet implemented");
	}

	@Test
	public void testHeal() {
		fail("Not yet implemented");
	}

	@Test
	public void testSick() {
		fail("Not yet implemented");
	}

	@Test
	public void testMisbehaving() {
		fail("Not yet implemented");
	}

	@Test
	public void testEndDay() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
