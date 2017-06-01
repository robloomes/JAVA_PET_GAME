package pet_game;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ToyTest {

	@Test
	public void testSetDurability() {
		Toy test = new Toy("tuna", 10, 2, 3);
		assertEquals(2, test.getDurability());
	}

	@Test
	public void testToString() {
		Toy test = new Toy("Yoyo", 10, 2, 3);
		assertEquals("Name: Yoyo \nPrice: 10 \nDurability: 2 \nEnjoyment: 3", test.toString());
	}

}
