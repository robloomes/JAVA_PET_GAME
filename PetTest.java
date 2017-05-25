package pet_game;

import static org.junit.Assert.*;

import org.junit.Test;

public class PetTest {

	@Test
	public void test() {
		
		Pet test = new Pet("lolo");
		Food testFood = new Food("tuna", 10,"small", 2,3);
		int oldWeight = test.weight;
		int oldToilet = test.toiletNeed;
		test.feed(testFood);
		assertEquals(oldWeight+25,test.weight);
		assertEquals(oldToilet+25,test.toiletNeed);
	}
	
		@Test
		public void testPet() {
			
			Pet test = new Pet("lolo");
			Food testFood = new Food("tuna", 10,"large", 2,3);
			int oldWeight = test.weight;
			int oldToilet = test.toiletNeed;
			test.feed(testFood);
			assertEquals(oldWeight+50,test.weight);
			assertEquals(oldToilet+50,test.toiletNeed);
			
		}
		@Test
		public void testToilet() {
			
			Pet test = new Pet("lolo");
			Food testFood = new Food("tuna", 10,"small", 2,3);
			int oldWeight = test.weight;
			int oldToilet = test.toiletNeed;
			test.toilet();
			assertEquals(oldWeight+20,test.weight);
			assertEquals(oldToilet+50,test.toiletNeed);
		}
		
		@Test
		public void testSleep() {
			Pet test = new Pet("lo");
			//int oldEnergy = test.energy;
			System.out.println(test.mood);
			System.out.println(test.energy);
			//int oldMood = test.mood;
			test.sleep();
			
			
		}
	
}
