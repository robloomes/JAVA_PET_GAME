package pet_game;

import static org.junit.Assert.*;

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
		Species testing = new Species("lolo", 3,10,26,20,"Melon","Yoyo","Monster",10,20);
		test.addPet(testing);
		assertEquals("lolo",test.getPets());
	}
	
//	
//	@Test
//	public void testRemovePet() {
//	Player test = new Player("Mna");
//	Species testing = new Species("Monster", 3,10,26,20,"Melon","Yoyo","Lolo",10,20);
//		test.getPets();
//		test.addPet(pet);
//	}
//	
//	@Test
//	public void testAddToy() {
//	Player test = new Player("Mna");
//	Species testing = new Species("Monster", 3,10,26,20,"Melon","Yoyo","Lolo",10,20);
//		test.getPets();
//		test.addPet(pet);
//	}
//	
//	@Test
//	public void testRemoveToy() {
//	Player test = new Player("Mna");
//	Species testing = new Species("Monster", 3,10,26,20,"Melon","Yoyo","Lolo",10,20);
//		test.getPets();
//		test.addPet(pet);
//	}
//	
//	@Test
//	public void testAddFoodt() {
//	Player test = new Player("Mna");
//	Species testing = new Species("Monster", 3,10,26,20,"Melon","Yoyo","Lolo",10,20);
//		test.getPets();
//		test.addPet(pet);
//	}
//	
//	@Test
//	public void testRemoveFood() {
//		Player test = new Player("Mna");
//		String oldNumOfPet = test.
//		test.getPets();
//		test.addPet(pet);
//		
//	}

	
	
	@Test
	public void testToString() {
		Player test = new Player("Yo");
		//int ownedPets = test.getPets();
		//int playerPets = 3;
		test.toString();
		assertEquals("<html>Player name: Yo<br>Balance: $100<br>Pets: None<br>Toys: None<br>Food: None", test.toString());

	}

}
