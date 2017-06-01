package pet_game;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testSetBalance() {
		Player testing = new Player("Mna");
		int oldBalance = testing.getBalance();
		assertEquals(oldBalance, testing.getBalance());
		testing.getBalance();
	}

	@Test
	public void testAddPet() {
		Player test = new Player("Mna");
		// Name, sleep, mood, hunger, energy, favFood, favToy, species, weight,
		// roughness.
		Species testLolo = new Species("lolo", 3, 10, 26, 20, "Melon", "Yoyo", "Monster", 10, 20);
		Species testCloud = new Species("defaultCloud", 1.0, 1.5, 0.5, 0.5, "melon", "kite", "Cloud", 2, 5);
		test.addPet(testLolo);
		test.addPet(testCloud);
		assertEquals(true, test.getPets().containsKey("lolo"));
		assertEquals(true, test.getPets().containsKey("defaultCloud"));
	}

	@Test
	public void testAddToy() {
		Toy bear = new Toy("Bear", 5, 10, 20);
		Toy boat = new Toy("Boat", 15, 70, 50);
		Player test = new Player("Mna");
		test.addToy(bear);
		test.addToy(boat);
		assertEquals(true, test.getToys().containsKey(bear));
		assertEquals(true, test.getToys().containsKey(boat));
	}

	@Test
	public void testRemoveToy() {
		Toy bear = new Toy("Bear", 5, 10, 20);
		Toy boat = new Toy("Boat", 15, 70, 50);
		Player test = new Player("Mna");
		test.addToy(bear);
		test.removeToy(bear);
		test.addToy(boat);
		test.removeToy(boat);
		assertEquals(false, test.getToys().containsKey(bear));
		assertEquals(false, test.getToys().containsKey(boat));
	}

	@Test
	public void testAddFood() {
		Food cookie = new Food("Cookie", 5, "small", 25, 20);
		Food fish = new Food("Fish", 10, "large", 80, 30);
		Player test = new Player("Mna");
		test.addFood(cookie);
		test.addFood(fish);
		assertEquals(true, test.getFood().containsKey(cookie));
		assertEquals(true, test.getFood().containsKey(fish));
	}

	@Test
	public void testRemoveFood() {
		Food cookie = new Food("Cookie", 5, "small", 25, 20);
		Food fish = new Food("Fish", 10, "large", 80, 30);
		Player test = new Player("Mna");
		test.addFood(cookie);
		test.addFood(fish);
		test.removeFood(cookie);
		test.removeFood(fish);
		assertEquals(false, test.getFood().containsKey(cookie));
		assertEquals(false, test.getFood().containsKey(fish));

	}

	@Test
	public void testToString() {
		Player test = new Player("Yo");
		// int ownedPets = test.getPets();
		// int playerPets = 3;
		test.toString();
		assertEquals("<html>Player name: Yo<br>Balance: $100<br>Pets: None<br>Toys: None<br>Food: None",
				test.toString());

	}

}
