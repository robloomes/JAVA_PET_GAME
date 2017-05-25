package pet_game;

import static org.junit.Assert.*;

import org.junit.Test;

public class FoodTest {

	@Test
	public void testSetNutrition() {
		Food test = new Food("tuna", 10,"small", 2,3);
		assertEquals("small",test.getSize());
		}
	@Test
	public void testToString() {
		Food test = new Food("tuna", 10,"small", 2,3);
		assertEquals("Name: tuna \nPrice: 10 \nSize: small \nTastiness: 2 \nNutrition: 3", test.toString());
		}
	
	
}
