package pet_game;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 * GUIfinal.java - a class used for building a game environment.
 * <p>
 * The GUI file calls and interacts with lower class {@link pet_game.Food},
 * {@link pet_game.Toy}, {@link pet_game.Pet}, {@link pet_game.Species},
 * {@link pet_game.gameObjects}, {@link pet_game.Player}
 * 
 * Contains all graphical elements as well as all general game logic.
 * 
 * @author Robert Loomes
 * @author Mna Chalabi
 * @since Winter 2017
 * @version 1.0
 */
public class GUIfinal implements gameObjects {
	/**
	 * Initialize the variables of the Pet class that need to be accessed
	 * privately within the class.
	 */
	private final JLabel lblFoodStore = new JLabel("  Food");
	private final JLabel lblToyStore = new JLabel("  Toys");
	private final JButton btnCake = new JButton("");
	private final JButton btnMelon = new JButton("");
	private final JButton btnHelicopter = new JButton("");
	private final JButton btnDoll = new JButton("");
	private final JButton btnBear = new JButton("");
	private final JButton btnBoat = new JButton("");
	private final JButton btnYoyo = new JButton("");
	private final JButton btnKite = new JButton("");
	private JLabel lblPlayerContents = new JLabel("Player contents");
	private final JLabel lblChocolate = new JLabel(
			"<html>Name: Chocolate\nPrice: 5<br>\nSize: small\nTastiness: 10\nNutrition: 40");
	private final JLabel lblCookies = new JLabel(
			"<html>Name: Cookies\nPrice: 5<br>\nSize: small\nTastiness:  5\nNutrition: 20");
	private final JLabel lblFish = new JLabel(
			"<html>Name: Fish<br>\nPrice: 10<br>\nSize: large\nTastiness: 20\nNutrition: 30");
	private final JLabel lblPizza = new JLabel(
			"<html>Name: Pizza\nPrice: 10<br>\nSize: large\nTastiness: 10\nNutrition: 40");
	private final JLabel lblCake = new JLabel(
			"<html>Name: Cake\nPrice: 10<br>\nSize: large\nTastiness: 10\nNutrition: 30");
	private final JLabel lblMelon = new JLabel(
			"<html>Name: Melon\nPrice: 5<br>\nSize: small\nTastiness: 15\nNutrition: 29");
	private final JLabel lblHelicopter = new JLabel(
			"<html>Name: Helicopter\nPrice: 20<br>\nDurability: 100\nEnjoyment: 50");
	private final JLabel lblBoat = new JLabel("<html>Name: Boat\nPrice: 15<br>\nDurability: 70\nEnjoyment: 50");
	private final JLabel lblYoyo = new JLabel("<html>Name: Yoyo<br>\nPrice: 5<br>\nDurability: 10\nEnjoyment: 20");
	private final JLabel lblBear = new JLabel("<html>Name: Bear<br>\nPrice: 5<br>\nDurability: 10\nEnjoyment: 10");
	private final JLabel lblDoll = new JLabel("<html>Name: Doll<br>\nPrice: 5<br>\nDurability: 50\nEnjoyment: 10");
	private final JLabel lblKite = new JLabel("<html>Name: Kite<br>\nPrice: 10<br>\nDurability: 50\nEnjoyment: 50");
	private final JLabel lblStoreTitle = new JLabel("24 Hour Pet Store");
	private final JLabel lblPetStoreImage = new JLabel("");

	private int textCounter = 1;
	private JFrame frame;
	private Species globalCurrentPet;
	private Player globalCurrentPlayer;
	private int numOfPlayers;
	private double gameDays;
	private int globalCurrentDay;
	private List<String> existingPetNames = new ArrayList<String>();
	private int playerIterator;

	private JLabel lblWelcome = new JLabel("<html>Welcome to Pets <br> the virtual pet game!");
	private JButton btnStart = new JButton("Start");
	private JButton btnHelp = new JButton("Help");
	private final JPanel panelStart = new JPanel();
	private final JPanel panelHelp = new JPanel();
	private JLabel lblHelp = new JLabel("");
	private final JLabel lblContinue = new JLabel("Click to continue...\r\n");
	private final JLabel lblHelpcounter = new JLabel("");
	private final JPanel clickPanel = new JPanel();
	private JPanel panelInput = new JPanel();
	private final JLabel lblPlayerNum = new JLabel("How many players would like to play the game?");

	private ButtonGroup radioGroupPlayers = new ButtonGroup();
	private JRadioButton rdbtn1player = new JRadioButton("1 Player");
	private JRadioButton rdbtn3players = new JRadioButton("3 Players");
	private JRadioButton rdbtn2players = new JRadioButton("2 Players");

	private JButton btnPlayerContinue = new JButton("Continue\n");
	private final JButton btnPlayerContinue2 = new JButton("Continue\n");
	private JSpinner spinnerDayNum = new JSpinner();
	private final JPanel panelCreation = new JPanel();
	private final JLabel lblNamePrompt = new JLabel("");
	private final JTextField textFieldCreation = new JTextField();
	private final JButton btnCreationContinue = new JButton("Continue\n");
	private final JPanel panelPet = new JPanel();
	private final JLabel lblpetdetails = new JLabel("");
	private JButton btnPetCounter = new JButton("Continue\n");
	private JTextField txtPetName1;
	private JTextField txtPetName2;
	private JTextField txtPetName3;
	private JTextField txtPetName4;
	private JTextField txtPetName5;
	private JTextField txtPetName6;
	private final JLabel lblSelectUpTo = new JLabel("Select up to 3.");
	private JCheckBox chckbxPet1 = new JCheckBox("Select Cloud");
	private JCheckBox chckbxPet2 = new JCheckBox("Select Crab");
	private JCheckBox chckbxPet3 = new JCheckBox("Select Monster");
	private JCheckBox chckbxPet4 = new JCheckBox("Select Penquin");
	private JCheckBox chckbxPet5 = new JCheckBox("Select Robot");
	private JCheckBox chckbxPet6 = new JCheckBox("Select Snake");
	private JLabel lblPet_6 = new JLabel("");
	private JLabel lblWelcome2 = new JLabel("<html>Welcome to Pets <br>the virtual pet game!");
	private JLabel lblpet_3 = new JLabel("");
	private JLabel lblPet_1 = new JLabel("");
	private JLabel lblPet_2 = new JLabel("");
	private JLabel lblPet_5 = new JLabel("");
	private JLabel lblPet4 = new JLabel("");
	private final JLabel lblBackgroundIcon = new JLabel("");
	private final JLabel lblBackgroundstart = new JLabel("");
	private final JLabel lblPet_1INFo = new JLabel(
			"<html>Cloud: Seems to care only <br> about itself,but can bring great joy to others.<br>\nFav food: Melon.\nFavo toy: Kite.\n");
	private final JLabel lblPet_2INFo = new JLabel(
			"<html>Penguin: not much to be <br>said about this black and white companion.<br>\nFav food: Pizza.\nFavo toy: Doll.");
	private final JLabel lblPet_3INFo = new JLabel(
			"<html>Crab: loyal but simple.<br> Obsessed with toys.<br>\nFav food: Fish.\nFavo toy: Yoyo.");
	private final JLabel lblPet_4INFo = new JLabel(
			"<html>Robot: has great personality for<br> a machine. Spends most of his time recharging his batteries.<br>\nFav food: Cake.\nFavo toy: Heli.");
	private final JLabel lblNewLabel_9 = new JLabel(
			"<html>Monster: while scary looking, <br>has a gentle heart beneath the rugged fur.<br>\nFav food: Chocolate.\nFavo toy: Bear.");
	private final JLabel lblNewLabel_10 = new JLabel(
			"<html>Snake: is as slippery as he<br> is untrustworthy. Keep a close eye on this one.<br>\nFav food: Cookies.\nFavo toy: Boat.");
	private final JLabel lblNewLabel_11 = new JLabel("");
	private final JLabel lblNewLabel_12 = new JLabel("");
	private final JPanel panelMainScreen = new JPanel();
	private final JPanel panelButtons = new JPanel();
	private final JButton btnPetSelect = new JButton("Select a pet");
	private final JButton btnVisitTheStore = new JButton("Visit the store");
	private final JButton btnFeedPet = new JButton("Feed pet");
	private JButton btnSleep = new JButton("Put pet to sleep");
	private final JButton btnUseToy = new JButton("Use toy");
	private final JButton btnUseToilet = new JButton("Use toilet");
	private final JButton btnPunishPet = new JButton("Punish pet");
	private final JButton btnVisitDoctor = new JButton("Visit doctor");
	private final JButton btnEndDay = new JButton("End day");
	private final JLabel lblCurrentSelectedPet = new JLabel("<html>Select a pet to <br>interact with it!");
	private final JLabel lblPetAttributes = new JLabel("<html>");
	private final JLabel lblCurrentPet = new JLabel("Current Pet: NONE");
	private final JLabel lblEventOutputs = new JLabel("");
	private final JLabel lblCurrentPlayer = new JLabel("Current player:");
	private final JLabel lblCurrentDay = new JLabel("");
	private final JPanel panelStore = new JPanel();
	private final JLabel lblDay = new JLabel("Day");
	private final JLabel lblDayTotals = new JLabel("/ --");
	private final JPanel panelPets = new JPanel();
	private final JLabel lblSelectAPet = new JLabel("Click on a pet to select it!");
	private JButton btnSelectPet1 = new JButton("");
	private JButton btnSelectPet2 = new JButton("");
	private JButton btnSelectPet3 = new JButton("");
	private final JLabel lblPetName1 = new JLabel("");
	private final JLabel lblPetName2 = new JLabel("");
	private final JLabel lblPetName3 = new JLabel("");
	private final JButton btnRevive = new JButton("Revive pet");
	private JButton btnChocolate = new JButton("");
	private JButton btnCookies = new JButton("");
	private JButton btnFish = new JButton("");
	private JButton btnPizza = new JButton("");
	private JButton btnStoreBack = new JButton("Back");
	private JPanel panelFeed = new JPanel();

	private JButton btnFood1 = new JButton("");
	private JButton btnFood2 = new JButton("");
	private JButton btnFood3 = new JButton("");
	private JButton btnFood4 = new JButton("");
	private JButton btnFood5 = new JButton("");
	private JButton btnFood6 = new JButton("");

	private final JButton btnFeedBack = new JButton("Back");
	private final JLabel lblFood1 = new JLabel("");
	private final JLabel lblFood2 = new JLabel("");
	private final JLabel lblFood3 = new JLabel("");
	private final JLabel lblFood4 = new JLabel("");
	private final JLabel lblFood5 = new JLabel("");
	private final JLabel lblFood6 = new JLabel("");
	private Map<Integer, Food> currentFood = new HashMap<Integer, Food>();
	private Map<Integer, Toy> currentToys = new HashMap<Integer, Toy>();
	private final JPanel panelPlay = new JPanel();
	private final JButton btnToy1 = new JButton("");
	private final JButton btnToy2 = new JButton("");
	private final JButton btnToy3 = new JButton("");
	private final JButton btnToy4 = new JButton("");
	private final JButton btnToy5 = new JButton("");
	private final JButton btnToy6 = new JButton("");
	private final JButton btnPlayBack = new JButton("Back");
	private final JLabel lblPlay = new JLabel("Choose a toy for your pet to play with.");
	private final JLabel lblToy1 = new JLabel("");
	private final JLabel lblToy2 = new JLabel("");
	private final JLabel lblToy3 = new JLabel("");
	private final JLabel lblToy4 = new JLabel("");
	private final JLabel lblToy5 = new JLabel("");
	private final JLabel lblToy6 = new JLabel("");
	private final JLabel lblPlayerStats = new JLabel("<html>");

	private Species button1 = null;
	private Species button2 = null;
	private Species button3 = null;
	private Species[] species = { button1, button2, button3 };

	private JButton[] jButtons = { btnSelectPet1, btnSelectPet2, btnSelectPet3 };
	private JLabel[] jLabels = { lblPetName1, lblPetName2, lblPetName3 };
	private final JPanel panelEnd = new JPanel();
	private final JLabel lblGameOver = new JLabel("GAME OVER");
	private final JLabel lblEndStats = new JLabel("");
	private final JButton btnExit = new JButton("EXIT");

	/**
	 * Main contructor used to add objects needed for the game environment.
	 */
	public GUIfinal() {

		globalCurrentPet = null;

		toyChoices.put(1, bear);
		toyChoices.put(2, boat);
		toyChoices.put(3, doll);
		toyChoices.put(4, heli);
		toyChoices.put(5, kite);
		toyChoices.put(6, yoyo);

		foodChoices.put(1, cookie);
		foodChoices.put(2, fish);
		foodChoices.put(3, chocolate);
		foodChoices.put(4, cake);
		foodChoices.put(5, melon);
		foodChoices.put(6, pizza);

		speciesChoices.put(1, cloud);
		speciesChoices.put(2, crab);
		speciesChoices.put(3, monster);
		speciesChoices.put(4, penguin);
		speciesChoices.put(5, robot);
		speciesChoices.put(6, snake);
	}

	/**
	 * Secondary constructor for the gui. Constructs all main graphical
	 * elements.
	 */
	public void GUIfinalConstructor() {

		panelStore.setVisible(false);
		panelStore.add(lblFoodStore);
		lblToyStore.setForeground(new Color(255, 215, 0));
		lblToyStore.setFont(new Font("Dialog", Font.BOLD, 25));
		lblToyStore.setBounds(807, 81, 114, 47);
		panelStore.add(lblToyStore);

		btnCake.setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/cake.jpg")));
		btnCake.setBounds(175, 322, 114, 123);

		panelStore.add(btnCake);
		btnMelon.setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/water_m.jpg")));
		btnMelon.setBounds(319, 325, 125, 120);

		panelStore.add(btnMelon);
		btnHelicopter.setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/HELI_TOY.jpg")));

		btnHelicopter.setFont(new Font("Dialog", Font.PLAIN, 5));
		btnHelicopter.setBounds(668, 129, 117, 112);

		panelStore.add(btnHelicopter);
		btnDoll.setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/Doll_Toy.jpg")));
		btnDoll.setBounds(817, 321, 105, 124);

		panelStore.add(btnDoll);
		btnBear.setFont(new Font("Dialog", Font.BOLD, 5));
		btnBear.setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/Bear_Toy.jpg")));
		btnBear.setBounds(668, 322, 105, 123);

		panelStore.add(btnBear);
		btnBoat.setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/Boat_Toy.jpg")));
		btnBoat.setBounds(817, 129, 132, 112);

		panelStore.add(btnBoat);
		btnYoyo.setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/yoy.jpg")));
		btnYoyo.setBounds(971, 129, 129, 112);

		panelStore.add(btnYoyo);
		btnKite.setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/KITE_TOY.png")));
		btnKite.setBounds(983, 322, 117, 132);

		panelStore.add(btnKite);
		lblPlayerContents.setOpaque(true);
		lblPlayerContents.setForeground(Color.WHITE);
		lblPlayerContents.setBackground(Color.GRAY);
		lblPlayerContents.setBounds(25, 536, 424, 146);

		panelStore.add(lblPlayerContents);
		lblChocolate.setForeground(Color.WHITE);
		lblChocolate.setFont(new Font("Dialog", Font.BOLD, 11));
		lblChocolate.setBounds(37, 242, 117, 80);

		panelStore.add(lblChocolate);
		lblCookies.setForeground(Color.WHITE);
		lblCookies.setFont(new Font("Dialog", Font.BOLD, 11));
		lblCookies.setBounds(175, 248, 117, 69);

		panelStore.add(lblCookies);
		lblFish.setForeground(Color.WHITE);
		lblFish.setFont(new Font("Dialog", Font.BOLD, 11));
		lblFish.setBounds(319, 246, 125, 71);

		panelStore.add(lblFish);
		lblPizza.setForeground(Color.WHITE);
		lblPizza.setFont(new Font("Dialog", Font.BOLD, 11));
		lblPizza.setBounds(37, 450, 117, 75);

		panelStore.add(lblPizza);
		lblCake.setForeground(Color.WHITE);
		lblCake.setFont(new Font("Dialog", Font.BOLD, 11));
		lblCake.setBounds(185, 450, 107, 75);

		panelStore.add(lblCake);
		lblMelon.setForeground(Color.WHITE);
		lblMelon.setFont(new Font("Dialog", Font.BOLD, 11));
		lblMelon.setBounds(319, 450, 125, 75);

		panelStore.add(lblMelon);
		lblHelicopter.setForeground(Color.WHITE);
		lblHelicopter.setFont(new Font("Dialog", Font.BOLD, 11));
		lblHelicopter.setBounds(678, 236, 114, 79);

		panelStore.add(lblHelicopter);
		lblBoat.setForeground(Color.WHITE);
		lblBoat.setFont(new Font("Dialog", Font.BOLD, 11));
		lblBoat.setBounds(826, 241, 105, 68);

		panelStore.add(lblBoat);
		lblYoyo.setForeground(Color.WHITE);
		lblYoyo.setFont(new Font("Dialog", Font.BOLD, 11));
		lblYoyo.setBounds(981, 243, 119, 64);

		panelStore.add(lblYoyo);
		lblBear.setForeground(Color.WHITE);
		lblBear.setFont(new Font("Dialog", Font.BOLD, 11));
		lblBear.setBounds(668, 446, 117, 68);

		panelStore.add(lblBear);
		lblDoll.setForeground(Color.WHITE);
		lblDoll.setFont(new Font("Dialog", Font.BOLD, 11));
		lblDoll.setBounds(827, 446, 114, 68);

		panelStore.add(lblDoll);
		lblKite.setForeground(Color.WHITE);
		lblKite.setFont(new Font("Dialog", Font.BOLD, 11));
		lblKite.setBounds(993, 451, 114, 63);

		panelStore.add(lblKite);
		lblStoreTitle.setForeground(Color.WHITE);
		lblStoreTitle.setFont(new Font("Dialog", Font.BOLD, 40));
		lblStoreTitle.setBounds(371, 0, 414, 89);

		panelStore.add(lblStoreTitle);
		lblPetStoreImage.setBounds(443, 537, 258, 182);

		panelStore.add(lblPetStoreImage);
		panelStart.setBackground(Color.BLUE);
		panelStart.setForeground(Color.RED);
		panelStart.setBounds(0, 0, 1213, 718);

		frame = new JFrame();
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setBounds(100, 100, 1215, 744);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		panelPet.setBackground(Color.DARK_GRAY);
		panelPet.setVisible(false);

		btnChocolate.setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/Choclate.jpg")));
		btnChocolate.setBounds(37, 129, 115, 115);
		panelStore.add(btnChocolate);

		btnCookies.setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/Cookies.jpg")));
		btnCookies.setBounds(175, 129, 117, 112);
		panelStore.add(btnCookies);

		btnFish.setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/Fish.jpg")));
		btnFish.setBounds(319, 129, 125, 112);
		panelStore.add(btnFish);

		btnPizza.setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/Pizza.jpg")));
		btnPizza.setBounds(40, 322, 114, 123);
		panelStore.add(btnPizza);
		panelStore.setLayout(null);
		panelStore.setForeground(Color.WHITE);
		panelStore.setBackground(Color.DARK_GRAY);
		panelStore.setBounds(0, 0, 1210, 717);

		frame.getContentPane().add(panelStore);

		JLabel lblFood = new JLabel("Food");
		lblFood.setForeground(new Color(255, 215, 0));
		lblFood.setFont(new Font("Dialog", Font.BOLD, 25));
		lblFood.setBounds(175, 81, 114, 47);
		panelStore.add(lblFood);

		btnStoreBack.setFont(new Font("Tahoma", Font.PLAIN, 31));
		btnStoreBack.setBounds(983, 623, 204, 69);
		panelStore.add(btnStoreBack);
		panelStart.setBackground(Color.BLUE);
		panelStart.setForeground(Color.RED);
		panelStart.setBounds(0, 0, 1213, 718);

		frame.getContentPane().add(panelStart);
		panelStart.setLayout(null);

		btnHelp.setBounds(550, 542, 179, 48);
		panelStart.add(btnHelp);

		btnStart.setBounds(550, 439, 179, 48);
		panelStart.add(btnStart);
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setBackground(new Color(255, 255, 255));
		lblWelcome.setBounds(298, 99, 817, 225);
		panelStart.add(lblWelcome);
		lblWelcome.setFont(new Font("Dialog", Font.BOLD, 65));
		lblWelcome.setHorizontalTextPosition(SwingConstants.CENTER);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblBackgroundstart.setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/Pets-Background.png")));
		lblBackgroundstart.setBounds(-30, -231, 1365, 981);

		panelStart.add(lblBackgroundstart);
		panelHelp.setBounds(0, 0, 1199, 705);
		frame.getContentPane().add(panelHelp);

		panelHelp.setVisible(false);
		panelHelp.setBackground(Color.RED);
		panelHelp.setLayout(null);

		lblHelp.setVerticalTextPosition(SwingConstants.TOP);
		lblHelp.setVerticalAlignment(SwingConstants.TOP);

		lblHelp.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblHelp.setHorizontalTextPosition(SwingConstants.LEFT);
		lblHelp.setHorizontalAlignment(SwingConstants.LEFT);
		lblHelp.setOpaque(true);
		lblHelp.setBounds(132, 417, 935, 200);
		panelHelp.add(lblHelp);
		lblWelcome2.setForeground(Color.WHITE);
		lblWelcome2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblWelcome2.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome2.setFont(new Font("Dialog", Font.BOLD, 65));
		lblWelcome2.setBounds(245, 72, 704, 290);
		panelHelp.add(lblWelcome2);
		lblContinue.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblContinue.setOpaque(true);
		lblContinue.setBounds(132, 617, 215, 47);

		panelHelp.add(lblContinue);
		lblHelpcounter.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblHelpcounter.setOpaque(true);
		lblHelpcounter.setBounds(309, 617, 758, 47);

		panelHelp.add(lblHelpcounter);

		clickPanel.setOpaque(false);
		clickPanel.setBounds(-140, 178, 1131, 598);

		panelHelp.add(clickPanel);
		lblNewLabel_12.setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/Pets-Background.png")));
		lblNewLabel_12.setBounds(-31, -49, 1273, 850);

		panelHelp.add(lblNewLabel_12);

		rdbtn1player.setSelected(true);

		panelInput.setBackground(Color.WHITE);
		panelInput.setVisible(false);

		panelInput.setBounds(0, 0, 1213, 718);
		frame.getContentPane().add(panelInput);
		panelInput.setLayout(null);
		rdbtn3players.setVerticalTextPosition(SwingConstants.BOTTOM);
		rdbtn3players.setHorizontalTextPosition(SwingConstants.CENTER);
		rdbtn3players.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn3players.setOpaque(false);

		rdbtn3players.setBounds(687, 414, 232, 67);
		panelInput.add(rdbtn3players);
		rdbtn1player.setVerticalTextPosition(SwingConstants.BOTTOM);
		rdbtn1player.setHorizontalTextPosition(SwingConstants.CENTER);
		rdbtn1player.setHorizontalAlignment(SwingConstants.CENTER);

		rdbtn1player.setOpaque(false);
		rdbtn1player.setSize(new Dimension(20, 20));
		rdbtn1player.setBounds(301, 414, 232, 67);
		panelInput.add(rdbtn1player);
		rdbtn2players.setVerticalTextPosition(SwingConstants.BOTTOM);
		rdbtn2players.setHorizontalTextPosition(SwingConstants.CENTER);
		rdbtn2players.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn2players.setOpaque(false);
		rdbtn2players.setSize(new Dimension(20, 20));
		rdbtn2players.setBounds(487, 414, 232, 67);
		panelInput.add(rdbtn2players);

		radioGroupPlayers.add(rdbtn1player);
		radioGroupPlayers.add(rdbtn2players);
		radioGroupPlayers.add(rdbtn3players);
		JLabel lblwelcomeToPets = new JLabel("<html>Welcome to Pets <br>the virtual pet  game!");
		lblwelcomeToPets.setForeground(Color.WHITE);
		lblwelcomeToPets.setHorizontalTextPosition(SwingConstants.CENTER);
		lblwelcomeToPets.setHorizontalAlignment(SwingConstants.CENTER);
		lblwelcomeToPets.setFont(new Font("Dialog", Font.BOLD, 65));
		lblwelcomeToPets.setBackground(Color.WHITE);
		lblwelcomeToPets.setBounds(210, 99, 879, 217);
		panelInput.add(lblwelcomeToPets);

		panelInput.add(rdbtn2players);
		lblPlayerNum.setForeground(Color.WHITE);
		lblPlayerNum.setFont(new Font("Dialog", Font.BOLD, 22));
		lblPlayerNum.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPlayerNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerNum.setBounds(253, 488, 702, 108);

		panelInput.add(lblPlayerNum);

		btnPlayerContinue.setVerticalAlignment(SwingConstants.BOTTOM);
		btnPlayerContinue.setBounds(510, 605, 193, 78);
		panelInput.add(btnPlayerContinue);

		btnPlayerContinue2.setVerticalAlignment(SwingConstants.BOTTOM);
		btnPlayerContinue2.setBounds(510, 622, 193, 61);

		panelInput.add(btnPlayerContinue2);

		spinnerDayNum.setVisible(false);
		spinnerDayNum.setModel(new SpinnerNumberModel(1.0, 1.0, 19.0, 1.0));
		spinnerDayNum.setBounds(576, 470, 57, 46);
		panelInput.add(spinnerDayNum);
		lblBackgroundIcon.setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/Pets-Background.png")));
		lblBackgroundIcon.setBounds(-19, -304, 1243, 1048);

		panelInput.add(lblBackgroundIcon);
		panelPet.setBounds(0, 0, 1213, 718);

		frame.getContentPane().add(panelPet);
		panelPet.setLayout(null);
		lblpetdetails.setBackground(Color.LIGHT_GRAY);
		lblpetdetails.setOpaque(true);
		lblpetdetails.setBounds(12, 12, 607, 358);

		panelPet.add(lblpetdetails);
		panelCreation.setLayout(null);
		lblPet_6.setBounds(450, 74, 192, 192);
		lblSelectUpTo.setForeground(Color.ORANGE);
		lblSelectUpTo.setFont(new Font("Dialog", Font.BOLD, 25));
		lblSelectUpTo.setBounds(474, 26, 246, 37);

		panelCreation.add(lblSelectUpTo);
		lblPet_1.setBounds(98, 310, 192, 192);

		lblPet_1.setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/PENG_PET.png")));
		panelCreation.add(lblPet_1);
		lblPet_2.setBounds(450, 310, 192, 192);

		lblPet_2.setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/ROBOT_PET.png")));
		panelCreation.add(lblPet_2);
		lblpet_3.setBounds(801, 74, 192, 192);

		lblpet_3.setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/MONSTER_PET.png")));
		panelCreation.add(lblpet_3);
		lblPet4.setBounds(98, 74, 192, 192);
		lblPet4.setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/CLOUD_PET.png")));
		panelCreation.add(lblPet4);
		lblPet_5.setBounds(801, 310, 192, 192);

		lblPet_5.setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/SNAKE_PET.png")));
		panelCreation.add(lblPet_5);
		lblPet_6.setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/CRAB_PET-1.png")));
		panelCreation.add(lblPet_6);
		panelCreation.add(lblPet_6);
		textFieldCreation.setBounds(368, 538, 450, 37);
		textFieldCreation.setColumns(10);
		panelCreation.setBackground(Color.GRAY);
		panelCreation.setVisible(false);
		panelCreation.setBounds(0, 0, 1213, 718);

		frame.getContentPane().add(panelCreation);
		lblNamePrompt.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblNamePrompt.setHorizontalAlignment(SwingConstants.CENTER);
		lblNamePrompt.setForeground(Color.ORANGE);
		lblNamePrompt.setBounds(274, 560, 756, 83);

		panelCreation.add(lblNamePrompt);

		panelCreation.add(textFieldCreation);
		btnCreationContinue.setBounds(510, 622, 193, 61);

		btnCreationContinue.setVerticalAlignment(SwingConstants.BOTTOM);

		panelCreation.add(btnCreationContinue);
		btnPetCounter.setBounds(510, 622, 193, 61);

		btnPetCounter.setVisible(false);
		btnPetCounter.setVerticalAlignment(SwingConstants.BOTTOM);
		panelCreation.add(btnPetCounter);

		txtPetName1 = new JTextField();
		txtPetName1.setBounds(294, 235, 130, 31);
		txtPetName1.setText("Enter a name...");
		panelCreation.add(txtPetName1);
		txtPetName1.setColumns(10);

		txtPetName2 = new JTextField();
		txtPetName2.setBounds(652, 235, 130, 31);
		txtPetName2.setText("Enter a name...");
		txtPetName2.setColumns(10);
		panelCreation.add(txtPetName2);

		txtPetName3 = new JTextField();
		txtPetName3.setBounds(1003, 235, 130, 31);
		txtPetName3.setText("Enter a name...");
		txtPetName3.setColumns(10);
		panelCreation.add(txtPetName3);

		txtPetName4 = new JTextField();
		txtPetName4.setBounds(294, 469, 130, 31);
		txtPetName4.setText("Enter a name...");
		txtPetName4.setColumns(10);
		panelCreation.add(txtPetName4);

		txtPetName5 = new JTextField();
		txtPetName5.setBounds(647, 471, 130, 31);
		txtPetName5.setText("Enter a name...");
		txtPetName5.setColumns(10);
		panelCreation.add(txtPetName5);

		txtPetName6 = new JTextField();
		txtPetName6.setBounds(1003, 471, 130, 31);
		txtPetName6.setText("Enter a name...");
		txtPetName6.setColumns(10);
		panelCreation.add(txtPetName6);
		chckbxPet1.setBounds(296, 205, 129, 23);
		panelCreation.add(chckbxPet1);
		chckbxPet2.setBounds(652, 205, 129, 23);
		panelCreation.add(chckbxPet2);
		chckbxPet3.setBounds(1004, 205, 129, 23);
		panelCreation.add(chckbxPet3);
		chckbxPet4.setBounds(296, 439, 129, 23);
		panelCreation.add(chckbxPet4);
		chckbxPet5.setBounds(648, 441, 129, 23);
		panelCreation.add(chckbxPet5);
		chckbxPet6.setBounds(1004, 441, 129, 23);
		panelCreation.add(chckbxPet6);
		lblPet_1INFo.setFont(new Font("Dialog", Font.BOLD, 11));
		lblPet_1INFo.setForeground(Color.WHITE);
		lblPet_1INFo.setBounds(294, 64, 130, 140);

		panelCreation.add(lblPet_1INFo);
		lblPet_2INFo.setFont(new Font("Dialog", Font.BOLD, 11));
		lblPet_2INFo.setForeground(Color.WHITE);
		lblPet_2INFo.setBounds(294, 310, 135, 127);

		panelCreation.add(lblPet_2INFo);
		lblPet_3INFo.setFont(new Font("Dialog", Font.BOLD, 11));
		lblPet_3INFo.setForeground(Color.WHITE);
		lblPet_3INFo.setBounds(654, 57, 122, 140);

		panelCreation.add(lblPet_3INFo);
		lblPet_4INFo.setFont(new Font("Dialog", Font.BOLD, 11));
		lblPet_4INFo.setForeground(Color.WHITE);
		lblPet_4INFo.setBounds(654, 317, 137, 127);

		panelCreation.add(lblPet_4INFo);
		lblNewLabel_9.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBounds(1014, 79, 111, 125);

		panelCreation.add(lblNewLabel_9);
		lblNewLabel_10.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setBounds(1014, 306, 119, 148);

		panelCreation.add(lblNewLabel_10);
		lblNewLabel_11.setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/Pets-Background.png")));
		lblNewLabel_11.setBounds(-58, -127, 1384, 869);

		panelCreation.add(lblNewLabel_11);
		panelPlay.setVisible(false);
		panelPlay.setBackground(Color.DARK_GRAY);
		panelPlay.setBounds(0, 0, 605, 706);

		frame.getContentPane().add(panelPlay);
		panelPlay.setLayout(null);
		btnToy1.setVisible(false);
		btnToy1.setBounds(40, 155, 115, 115);

		panelPlay.add(btnToy1);
		btnToy2.setVisible(false);
		btnToy2.setBounds(245, 155, 115, 115);

		panelPlay.add(btnToy2);
		btnToy3.setVisible(false);
		btnToy3.setBounds(446, 155, 115, 115);

		panelPlay.add(btnToy3);
		btnToy4.setVisible(false);
		btnToy4.setBounds(40, 386, 115, 115);

		panelPlay.add(btnToy4);
		btnToy5.setVisible(false);
		btnToy5.setBounds(245, 386, 115, 115);

		panelPlay.add(btnToy5);
		btnToy6.setVisible(false);
		btnToy6.setBounds(446, 386, 115, 115);

		panelPlay.add(btnToy6);
		btnPlayBack.setFont(new Font("Tahoma", Font.PLAIN, 27));
		btnPlayBack.setBounds(407, 629, 188, 66);

		panelPlay.add(btnPlayBack);
		lblPlay.setForeground(Color.WHITE);
		lblPlay.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlay.setBackground(Color.GRAY);
		lblPlay.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblPlay.setOpaque(true);
		lblPlay.setBounds(36, 29, 525, 115);

		panelPlay.add(lblPlay);
		lblToy1.setVisible(false);
		lblToy1.setOpaque(true);
		lblToy1.setBounds(40, 281, 115, 34);

		panelPlay.add(lblToy1);
		lblToy2.setVisible(false);
		lblToy2.setOpaque(true);
		lblToy2.setBounds(245, 281, 115, 34);

		panelPlay.add(lblToy2);
		lblToy3.setVisible(false);
		lblToy3.setOpaque(true);
		lblToy3.setBounds(446, 281, 115, 34);

		panelPlay.add(lblToy3);
		lblToy4.setVisible(false);
		lblToy4.setOpaque(true);
		lblToy4.setBounds(40, 513, 115, 34);

		panelPlay.add(lblToy4);
		lblToy5.setVisible(false);
		lblToy5.setOpaque(true);
		lblToy5.setBounds(245, 513, 115, 34);

		panelPlay.add(lblToy5);
		lblToy6.setVisible(false);
		lblToy6.setOpaque(true);
		lblToy6.setBounds(446, 512, 115, 34);

		panelPlay.add(lblToy6);
		panelEnd.setVisible(false);
		panelEnd.setBackground(Color.DARK_GRAY);
		panelEnd.setBounds(0, 0, 1199, 706);

		frame.getContentPane().add(panelEnd);
		panelEnd.setLayout(null);

		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExit.setBounds(953, 602, 219, 74);

		panelEnd.add(btnExit);
		lblGameOver.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 42));
		lblGameOver.setHorizontalTextPosition(SwingConstants.CENTER);
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOver.setBackground(Color.BLUE);
		lblGameOver.setForeground(Color.ORANGE);
		lblGameOver.setOpaque(true);
		lblGameOver.setBounds(10, 11, 1179, 179);

		panelEnd.add(lblGameOver);
		lblEndStats.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEndStats.setOpaque(true);
		lblEndStats.setBounds(10, 201, 1179, 494);

		panelEnd.add(lblEndStats);
		panelMainScreen.setVisible(false);
		panelFeed.setBounds(0, 0, 605, 706);
		frame.getContentPane().add(panelFeed);

		panelFeed.setVisible(false);
		panelFeed.setBackground(Color.DARK_GRAY);
		panelFeed.setLayout(null);
		btnFood1.setVisible(false);

		btnFood1.setBounds(40, 155, 115, 115);
		panelFeed.add(btnFood1);
		btnFood2.setVisible(false);

		btnFood2.setBounds(245, 155, 115, 115);
		panelFeed.add(btnFood2);
		btnFood3.setVisible(false);

		btnFood3.setBounds(446, 155, 115, 115);
		panelFeed.add(btnFood3);
		btnFood4.setVisible(false);

		btnFood4.setBounds(40, 386, 115, 115);
		panelFeed.add(btnFood4);
		btnFood5.setVisible(false);

		btnFood5.setBounds(245, 386, 115, 115);
		panelFeed.add(btnFood5);
		btnFood6.setVisible(false);

		btnFood6.setBounds(446, 386, 115, 115);
		panelFeed.add(btnFood6);

		JLabel lblFeed = new JLabel("Choose an item to feed to your pet.");
		lblFeed.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblFeed.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeed.setForeground(Color.WHITE);
		lblFeed.setOpaque(true);
		lblFeed.setBackground(new Color(128, 128, 128));
		lblFeed.setBounds(36, 29, 525, 115);
		panelFeed.add(lblFeed);
		btnFeedBack.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnFeedBack.setBounds(407, 629, 188, 66);

		panelFeed.add(btnFeedBack);
		lblFood1.setVisible(false);
		lblFood1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFood1.setBackground(Color.GRAY);
		lblFood1.setForeground(Color.WHITE);
		lblFood1.setOpaque(true);
		lblFood1.setBounds(40, 281, 115, 34);

		panelFeed.add(lblFood1);
		lblFood2.setVisible(false);
		lblFood2.setHorizontalAlignment(SwingConstants.CENTER);
		lblFood2.setBackground(Color.GRAY);
		lblFood2.setForeground(Color.WHITE);
		lblFood2.setOpaque(true);
		lblFood2.setBounds(245, 281, 115, 34);

		panelFeed.add(lblFood2);
		lblFood3.setVisible(false);
		lblFood3.setHorizontalAlignment(SwingConstants.CENTER);
		lblFood3.setBackground(Color.GRAY);
		lblFood3.setForeground(Color.WHITE);
		lblFood3.setOpaque(true);
		lblFood3.setBounds(446, 281, 115, 34);

		panelFeed.add(lblFood3);
		lblFood4.setVisible(false);
		lblFood4.setHorizontalAlignment(SwingConstants.CENTER);
		lblFood4.setBackground(Color.GRAY);
		lblFood4.setForeground(Color.WHITE);
		lblFood4.setOpaque(true);
		lblFood4.setBounds(40, 512, 115, 34);

		panelFeed.add(lblFood4);
		lblFood5.setVisible(false);
		lblFood5.setHorizontalAlignment(SwingConstants.CENTER);
		lblFood5.setBackground(Color.GRAY);
		lblFood5.setForeground(Color.WHITE);
		lblFood5.setOpaque(true);
		lblFood5.setBounds(245, 512, 115, 34);

		panelFeed.add(lblFood5);
		lblFood6.setVisible(false);
		lblFood6.setHorizontalAlignment(SwingConstants.CENTER);
		lblFood6.setBackground(Color.GRAY);
		lblFood6.setForeground(Color.WHITE);
		lblFood6.setOpaque(true);
		lblFood6.setBounds(446, 512, 115, 34);

		panelFeed.add(lblFood6);
		panelMainScreen.setBackground(Color.GRAY);
		panelMainScreen.setBounds(0, 0, 1213, 718);

		frame.getContentPane().add(panelMainScreen);
		panelMainScreen.setLayout(null);
		lblDayTotals.setFont(new Font("Dialog", Font.BOLD, 19));
		lblDayTotals.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDayTotals.setForeground(Color.WHITE);
		lblDayTotals.setBounds(910, 227, 81, 28);

		panelMainScreen.add(lblDayTotals);
		lblDay.setForeground(Color.WHITE);
		lblDay.setBounds(827, 76, 81, 23);
		panelMainScreen.add(lblDay);
		lblCurrentSelectedPet.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentSelectedPet.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCurrentSelectedPet.setOpaque(true);
		lblCurrentSelectedPet.setBounds(615, 69, 192, 192);

		panelMainScreen.add(lblCurrentSelectedPet);
		lblPetAttributes.setVerticalAlignment(SwingConstants.TOP);
		lblPetAttributes.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblPetAttributes.setHorizontalAlignment(SwingConstants.LEFT);
		lblPetAttributes.setHorizontalTextPosition(SwingConstants.LEFT);
		lblPetAttributes.setOpaque(true);
		lblPetAttributes.setBackground(Color.DARK_GRAY);
		lblPetAttributes.setForeground(Color.WHITE);
		lblPetAttributes.setBounds(615, 267, 192, 428);

		panelMainScreen.add(lblPetAttributes);
		lblCurrentPet.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCurrentPet.setForeground(Color.WHITE);
		lblCurrentPet.setBackground(Color.DARK_GRAY);
		lblCurrentPet.setOpaque(true);
		lblCurrentPet.setBounds(615, 11, 192, 48);

		panelMainScreen.add(lblCurrentPet);
		lblEventOutputs.setVerticalAlignment(SwingConstants.TOP);
		lblEventOutputs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEventOutputs.setBackground(Color.DARK_GRAY);
		lblEventOutputs.setForeground(Color.WHITE);
		lblEventOutputs.setOpaque(true);
		lblEventOutputs.setBounds(817, 266, 373, 429);

		panelMainScreen.add(lblEventOutputs);
		lblCurrentPlayer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCurrentPlayer.setBackground(Color.DARK_GRAY);
		lblCurrentPlayer.setForeground(Color.WHITE);
		lblCurrentPlayer.setOpaque(true);
		lblCurrentPlayer.setBounds(817, 11, 384, 48);

		panelMainScreen.add(lblCurrentPlayer);
		panelPets.setVisible(false);
		panelPets.setBounds(0, 0, 593, 706);
		panelMainScreen.add(panelPets);
		panelPets.setBackground(Color.DARK_GRAY);
		panelPets.setLayout(null);
		btnSelectPet1.setVisible(false);
		btnSelectPet1.setHorizontalTextPosition(SwingConstants.CENTER);

		btnSelectPet1.setBackground(Color.GRAY);
		btnSelectPet1.setBounds(87, 64, 192, 192);
		panelPets.add(btnSelectPet1);
		lblSelectAPet.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSelectAPet.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectAPet.setBackground(Color.GRAY);
		lblSelectAPet.setForeground(Color.WHITE);
		lblSelectAPet.setOpaque(true);
		lblSelectAPet.setBounds(162, 12, 277, 40);

		panelPets.add(lblSelectAPet);
		btnSelectPet2.setVisible(false);
		btnSelectPet2.setHorizontalTextPosition(SwingConstants.CENTER);

		btnSelectPet2.setBackground(Color.GRAY);
		btnSelectPet2.setBounds(346, 64, 192, 192);
		panelPets.add(btnSelectPet2);
		btnSelectPet3.setVisible(false);
		btnSelectPet3.setHorizontalTextPosition(SwingConstants.CENTER);

		btnSelectPet3.setBackground(Color.GRAY);
		btnSelectPet3.setBounds(220, 356, 192, 192);
		panelPets.add(btnSelectPet3);
		lblPetName1.setVisible(false);
		lblPetName1.setOpaque(true);
		lblPetName1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblPetName1.setBounds(87, 259, 119, 33);

		panelPets.add(lblPetName1);
		lblPetName2.setVisible(false);
		lblPetName2.setOpaque(true);
		lblPetName2.setBounds(346, 259, 119, 33);

		panelPets.add(lblPetName2);
		lblPetName3.setVisible(false);
		lblPetName3.setOpaque(true);
		lblPetName3.setBounds(220, 550, 119, 33);

		panelPets.add(lblPetName3);
		lblPlayerStats.setVerticalAlignment(SwingConstants.TOP);
		lblPlayerStats.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblPlayerStats.setOpaque(true);
		lblPlayerStats.setHorizontalTextPosition(SwingConstants.LEFT);
		lblPlayerStats.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayerStats.setForeground(Color.WHITE);
		lblPlayerStats.setBackground(Color.DARK_GRAY);
		lblPlayerStats.setBounds(1008, 72, 182, 189);

		panelMainScreen.add(lblPlayerStats);
		panelButtons.add(btnFeedPet);
		panelButtons.setBackground(Color.DARK_GRAY);
		panelButtons.setForeground(Color.WHITE);
		panelButtons.setBounds(12, 11, 593, 695);

		panelMainScreen.add(panelButtons);
		panelButtons.setLayout(null);

		btnPetSelect.setBounds(10, 10, 571, 57);
		panelButtons.add(btnPetSelect);
		btnVisitTheStore.setBounds(10, 79, 571, 57);
		panelButtons.add(btnVisitTheStore);
		btnFeedPet.setBounds(10, 147, 571, 57);
		btnSleep.setBounds(10, 215, 571, 57);
		panelButtons.add(btnSleep);
		btnUseToy.setBounds(10, 283, 571, 57);
		panelButtons.add(btnUseToy);
		btnUseToilet.setBounds(10, 351, 571, 57);
		btnPunishPet.setBounds(10, 419, 571, 57);
		btnVisitDoctor.setBounds(10, 487, 571, 57);
		panelButtons.add(btnVisitDoctor);
		btnEndDay.setBounds(10, 626, 571, 57);
		panelButtons.add(btnEndDay);
		panelButtons.add(btnPunishPet);
		btnRevive.setBounds(10, 556, 571, 57);
		panelButtons.add(btnUseToilet);
		panelButtons.add(btnRevive);
		lblCurrentDay.setFont(new Font("Dialog", Font.BOLD, 47));
		lblCurrentDay.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCurrentDay.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentDay.setBackground(Color.DARK_GRAY);
		lblCurrentDay.setForeground(Color.WHITE);
		lblCurrentDay.setOpaque(true);
		lblCurrentDay.setBounds(817, 71, 182, 190);

		panelMainScreen.add(lblCurrentDay);
	}

	/**
	 * Hold the action listeners for player buttons. Sets the amount of players
	 * in the game from user input. Is initialized on game launch.
	 */
	public void playerButtons() {
		rdbtn1player.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numOfPlayers = 1;
			}
		});

		rdbtn2players.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numOfPlayers = 2;
			}
		});

		rdbtn3players.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numOfPlayers = 3;
			}
		});
	}

	/**
	 * Handles the ghost text graphical elements for various text boxes. Let's
	 * text boxes be more user friendly by letting the player know what the text
	 * box is asking for, and not obstructing the input. Is initialized on game
	 * launch.
	 */
	public void mouseClickActions() {

		txtPetName1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPetName1.setText("");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (txtPetName1.getText().equals("")) {
					txtPetName1.setText("Enter a name...");
				}
			}
		});

		txtPetName2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPetName2.setText("");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (txtPetName2.getText().equals("")) {
					txtPetName2.setText("Enter a name...");
				}
			}
		});

		txtPetName3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPetName3.setText("");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (txtPetName3.getText().equals("")) {
					txtPetName3.setText("Enter a name...");
				}
			}
		});

		txtPetName4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPetName4.setText("");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (txtPetName4.getText().equals("")) {
					txtPetName4.setText("Enter a name...");
				}
			}
		});

		txtPetName5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPetName5.setText("");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (txtPetName5.getText().equals("")) {
					txtPetName5.setText("Enter a name...");
				}
			}
		});

		txtPetName6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPetName6.setText("");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (txtPetName6.getText().equals("")) {
					txtPetName6.setText("Enter a name...");
				}
			}
		});
	}

	/**
	 * Holds the action listener for the feed buttons. Holds all the feed logic
	 * within the button and calls a secondary method @see feedBack() to handle
	 * graphical visibility requirements. Is initialized on game launch.
	 */
	public void feedButtons() {
		btnFood1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnFood1.getIcon() != null) {
					lblEventOutputs.setText(String.format("<html>*chomp..chomp..chomp*<br><br> %s enjoyed the %s!\n",
							globalCurrentPet.getName(), currentFood.get(0).getName()));
					globalCurrentPet.feed(currentFood.get(0));
					globalCurrentPlayer.removeFood(currentFood.get(0));
					lblPetAttributes.setText(globalCurrentPet.toString());
					lblPlayerStats.setText(globalCurrentPlayer.toString());
					feedBack();
				}
			}
		});

		btnFood2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnFood2.getIcon() != null) {
					lblEventOutputs.setText(String.format("<html>*chomp..chomp..chomp*<br><br> %s enjoyed the %s!\n",
							globalCurrentPet.getName(), currentFood.get(1).getName()));
					globalCurrentPet.feed(currentFood.get(1));
					globalCurrentPlayer.removeFood(currentFood.get(1));
					lblPetAttributes.setText(globalCurrentPet.toString());
					lblPlayerStats.setText(globalCurrentPlayer.toString());
					feedBack();
				}
			}
		});

		btnFood3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnFood3.getIcon() != null) {
					lblEventOutputs.setText(String.format("<html>*chomp..chomp..chomp*<br><br> %s enjoyed the %s!\n",
							globalCurrentPet.getName(), currentFood.get(2).getName()));
					globalCurrentPet.feed(currentFood.get(2));
					globalCurrentPlayer.removeFood(currentFood.get(2));
					lblPetAttributes.setText(globalCurrentPet.toString());
					lblPlayerStats.setText(globalCurrentPlayer.toString());
					feedBack();
				}
			}
		});

		btnFood4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnFood4.getIcon() != null) {
					lblEventOutputs.setText(String.format("<html>*chomp..chomp..chomp*<br><br> %s enjoyed the %s!\n",
							globalCurrentPet.getName(), currentFood.get(3).getName()));
					globalCurrentPet.feed(currentFood.get(3));
					globalCurrentPlayer.removeFood(currentFood.get(3));
					lblPetAttributes.setText(globalCurrentPet.toString());
					lblPlayerStats.setText(globalCurrentPlayer.toString());
					feedBack();
				}
			}
		});

		btnFood5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnFood5.getIcon() != null) {
					lblEventOutputs.setText(String.format("<html>*chomp..chomp..chomp*<br><br> %s enjoyed the %s!\n",
							globalCurrentPet.getName(), currentFood.get(4).getName()));
					globalCurrentPet.feed(currentFood.get(4));
					globalCurrentPlayer.removeFood(currentFood.get(4));
					lblPetAttributes.setText(globalCurrentPet.toString());
					lblPlayerStats.setText(globalCurrentPlayer.toString());
					feedBack();
				}
			}
		});

		btnFood6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnFood6.getIcon() != null) {
					lblEventOutputs.setText(String.format("<html>*chomp..chomp..chomp*<br><br> %s enjoyed the %s!\n",
							globalCurrentPet.getName(), currentFood.get(5).getName()));
					globalCurrentPet.feed(currentFood.get(5));
					globalCurrentPlayer.removeFood(currentFood.get(5));
					lblPetAttributes.setText(globalCurrentPet.toString());
					lblPlayerStats.setText(globalCurrentPlayer.toString());
					feedBack();
				}
			}
		});
	}

	/**
	 * Holds the action listeners for the store buttons. Contains the logic
	 * within the buttons. Calls warning messages if user input is not
	 * applicable. Is initialized on game launch.
	 */
	public void storeButtons() {
		btnChocolate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((globalCurrentPlayer.getBalance() - chocolate.getPrice()) < 0) {
					JOptionPane.showMessageDialog(null, "You don't have enough money to make this purchase",
							"InfoBox: " + "Warning", JOptionPane.INFORMATION_MESSAGE);
				} else {
					globalCurrentPlayer.addFood(chocolate);
					globalCurrentPlayer.setBalance((globalCurrentPlayer.getBalance() - chocolate.getPrice()));
					lblPlayerContents.setText(globalCurrentPlayer.toString());
				}
			}
		});

		btnCookies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((globalCurrentPlayer.getBalance() - cookie.getPrice()) < 0) {
					JOptionPane.showMessageDialog(null, "You don't have enough money to make this purchase",
							"InfoBox: " + "Warning", JOptionPane.INFORMATION_MESSAGE);
				} else {
					globalCurrentPlayer.addFood(cookie);
					globalCurrentPlayer.setBalance((globalCurrentPlayer.getBalance() - cookie.getPrice()));
					lblPlayerContents.setText(globalCurrentPlayer.toString());
				}
			}
		});

		btnFish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((globalCurrentPlayer.getBalance() - fish.getPrice()) < 0) {
					JOptionPane.showMessageDialog(null, "You don't have enough money to make this purchase",
							"InfoBox: " + "Warning", JOptionPane.INFORMATION_MESSAGE);
				} else {
					globalCurrentPlayer.addFood(fish);
					globalCurrentPlayer.setBalance((globalCurrentPlayer.getBalance() - fish.getPrice()));
					lblPlayerContents.setText(globalCurrentPlayer.toString());
				}
			}
		});

		btnPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((globalCurrentPlayer.getBalance() - pizza.getPrice()) < 0) {
					JOptionPane.showMessageDialog(null, "You don't have enough money to make this purchase",
							"InfoBox: " + "Warning", JOptionPane.INFORMATION_MESSAGE);
				} else {
					globalCurrentPlayer.addFood(pizza);
					globalCurrentPlayer.setBalance((globalCurrentPlayer.getBalance() - pizza.getPrice()));
					lblPlayerContents.setText(globalCurrentPlayer.toString());
				}
			}
		});

		btnCake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((globalCurrentPlayer.getBalance() - cake.getPrice()) < 0) {
					JOptionPane.showMessageDialog(null, "You don't have enough money to make this purchase",
							"InfoBox: " + "Warning", JOptionPane.INFORMATION_MESSAGE);
				} else {
					globalCurrentPlayer.addFood(cake);
					globalCurrentPlayer.setBalance((globalCurrentPlayer.getBalance() - cake.getPrice()));
					lblPlayerContents.setText(globalCurrentPlayer.toString());
				}
			}
		});

		btnMelon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((globalCurrentPlayer.getBalance() - melon.getPrice()) < 0) {
					JOptionPane.showMessageDialog(null, "You don't have enough money to make this purchase",
							"InfoBox: " + "Warning", JOptionPane.INFORMATION_MESSAGE);
				} else {
					globalCurrentPlayer.addFood(melon);
					globalCurrentPlayer.setBalance((globalCurrentPlayer.getBalance() - melon.getPrice()));
					lblPlayerContents.setText(globalCurrentPlayer.toString());
				}
			}
		});

		btnHelicopter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((globalCurrentPlayer.getBalance() - heli.getPrice()) < 0) {
					JOptionPane.showMessageDialog(null, "You don't have enough money to make this purchase",
							"InfoBox: " + "Warning", JOptionPane.INFORMATION_MESSAGE);
				} else if (toyChecker(heli) == true) {
					JOptionPane.showMessageDialog(null, "You can only own 1 type of each toy at once.",
							"InfoBox: " + "Warning", JOptionPane.INFORMATION_MESSAGE);
				} else {
					globalCurrentPlayer.addToy(heli);
					globalCurrentPlayer.setBalance((globalCurrentPlayer.getBalance() - heli.getPrice()));
					lblPlayerContents.setText(globalCurrentPlayer.toString());
				}
			}
		});

		btnYoyo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((globalCurrentPlayer.getBalance() - yoyo.getPrice()) < 0) {
					JOptionPane.showMessageDialog(null, "You don't have enough money to make this purchase",
							"InfoBox: " + "Warning", JOptionPane.INFORMATION_MESSAGE);
				} else if (toyChecker(yoyo) == true) {
					JOptionPane.showMessageDialog(null, "You can only own 1 type of each toy at once.",
							"InfoBox: " + "Warning", JOptionPane.INFORMATION_MESSAGE);
				} else {
					globalCurrentPlayer.addToy(yoyo);
					globalCurrentPlayer.setBalance((globalCurrentPlayer.getBalance() - yoyo.getPrice()));
					lblPlayerContents.setText(globalCurrentPlayer.toString());
				}
			}
		});

		btnDoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((globalCurrentPlayer.getBalance() - doll.getPrice()) < 0) {
					JOptionPane.showMessageDialog(null, "You don't have enough money to make this purchase",
							"InfoBox: " + "Warning", JOptionPane.INFORMATION_MESSAGE);
				} else if (toyChecker(doll) == true) {
					JOptionPane.showMessageDialog(null, "You can only own 1 type of each toy at once.",
							"InfoBox: " + "Warning", JOptionPane.INFORMATION_MESSAGE);
				} else {
					globalCurrentPlayer.addToy(doll);
					globalCurrentPlayer.setBalance((globalCurrentPlayer.getBalance() - doll.getPrice()));
					lblPlayerContents.setText(globalCurrentPlayer.toString());
				}
			}
		});

		btnBear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((globalCurrentPlayer.getBalance() - bear.getPrice()) < 0) {
					JOptionPane.showMessageDialog(null, "You don't have enough money to make this purchase",
							"InfoBox: " + "Warning", JOptionPane.INFORMATION_MESSAGE);
				} else if (toyChecker(bear) == true) {
					JOptionPane.showMessageDialog(null, "You can only own 1 type of each toy at once.",
							"InfoBox: " + "Warning", JOptionPane.INFORMATION_MESSAGE);
				} else {
					globalCurrentPlayer.addToy(bear);
					globalCurrentPlayer.setBalance((globalCurrentPlayer.getBalance() - bear.getPrice()));
					lblPlayerContents.setText(globalCurrentPlayer.toString());
				}
			}
		});

		btnKite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((globalCurrentPlayer.getBalance() - kite.getPrice()) < 0) {
					JOptionPane.showMessageDialog(null, "You don't have enough money to make this purchase",
							"InfoBox: " + "Warning", JOptionPane.INFORMATION_MESSAGE);
				} else if (toyChecker(kite) == true) {
					JOptionPane.showMessageDialog(null, "You can only own 1 type of each toy at once.",
							"InfoBox: " + "Warning", JOptionPane.INFORMATION_MESSAGE);
				} else {
					globalCurrentPlayer.addToy(kite);
					globalCurrentPlayer.setBalance((globalCurrentPlayer.getBalance() - kite.getPrice()));
					lblPlayerContents.setText(globalCurrentPlayer.toString());
				}
			}
		});

		btnBoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((globalCurrentPlayer.getBalance() - boat.getPrice()) < 0) {
					JOptionPane.showMessageDialog(null, "You don't have enough money to make this purchase",
							"InfoBox: " + "Warning", JOptionPane.INFORMATION_MESSAGE);
				} else if (toyChecker(boat) == true) {
					JOptionPane.showMessageDialog(null, "You can only own 1 type of each toy at once.",
							"InfoBox: " + "Warning", JOptionPane.INFORMATION_MESSAGE);
				} else {
					globalCurrentPlayer.addToy(boat);
					globalCurrentPlayer.setBalance((globalCurrentPlayer.getBalance() - boat.getPrice()));
					lblPlayerContents.setText(globalCurrentPlayer.toString());
				}
			}
		});

		btnStoreBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMainScreen.setVisible(true);
				panelStore.setVisible(false);
				lblPlayerStats.setText(globalCurrentPlayer.toString());
			}
		});

	}

	/**
	 * Holds the action listeners for using toys with pets. Play logic is
	 * contained within the buttons. Is initialized on game launch.
	 */
	public void playButtons() {
		btnToy1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnToy1.getIcon() != null) {
					lblEventOutputs.setText(String.format("%s is feeling happier!", globalCurrentPet.getName()));
					globalCurrentPet.play(currentToys.get(0));
					if (currentToys.get(0).getDurability() <= 0) {
						globalCurrentPlayer.removeToy(currentToys.get(0));
						lblEventOutputs.setText(String.format("%s is feeling happier!", globalCurrentPet.getName()));
						lblEventOutputs.setText(String.format("Your %s broke!", currentToys.get(0).getName()));
					}

					lblPetAttributes.setText(globalCurrentPet.toString());
					lblPlayerStats.setText(globalCurrentPlayer.toString());
					playBack();
				}
			}
		});

		btnToy2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnToy2.getIcon() != null) {
					lblEventOutputs.setText(String.format("%s is feeling happier!", globalCurrentPet.getName()));
					globalCurrentPet.play(currentToys.get(1));
					if (currentToys.get(1).getDurability() <= 0) {
						globalCurrentPlayer.removeToy(currentToys.get(1));
						lblEventOutputs.setText(String.format("%s is feeling happier!", globalCurrentPet.getName()));
						lblEventOutputs.setText(String.format("Your %s broke!", currentToys.get(1).getName()));
					}
					lblPetAttributes.setText(globalCurrentPet.toString());
					lblPlayerStats.setText(globalCurrentPlayer.toString());
					playBack();
				}
			}
		});

		btnToy3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnToy3.getIcon() != null) {
					lblEventOutputs.setText(String.format("%s is feeling happier!", globalCurrentPet.getName()));
					globalCurrentPet.play(currentToys.get(2));
					if (currentToys.get(2).getDurability() <= 0) {
						globalCurrentPlayer.removeToy(currentToys.get(2));
						lblEventOutputs.setText(String.format("%s is feeling happier!", globalCurrentPet.getName()));
						lblEventOutputs.setText(String.format("Your %s broke!", currentToys.get(2).getName()));
					}
					lblPetAttributes.setText(globalCurrentPet.toString());
					lblPlayerStats.setText(globalCurrentPlayer.toString());
					playBack();
				}
			}
		});

		btnToy4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnToy4.getIcon() != null) {
					lblEventOutputs.setText(String.format("%s is feeling happier!", globalCurrentPet.getName()));
					globalCurrentPet.play(currentToys.get(3));
					if (currentToys.get(3).getDurability() <= 0) {
						globalCurrentPlayer.removeToy(currentToys.get(3));
						lblEventOutputs.setText(String.format("%s is feeling happier!", globalCurrentPet.getName()));
						lblEventOutputs.setText(String.format("Your %s broke!", currentToys.get(3).getName()));
					}
					lblPetAttributes.setText(globalCurrentPet.toString());
					lblPlayerStats.setText(globalCurrentPlayer.toString());
					playBack();
				}
			}
		});

		btnToy5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnToy5.getIcon() != null) {
					lblEventOutputs.setText(String.format("%s is feeling happier!", globalCurrentPet.getName()));
					globalCurrentPet.play(currentToys.get(4));
					if (currentToys.get(4).getDurability() <= 0) {
						globalCurrentPlayer.removeToy(currentToys.get(4));
						lblEventOutputs.setText(String.format("%s is feeling happier!", globalCurrentPet.getName()));
						lblEventOutputs.setText(String.format("Your %s broke!", currentToys.get(4).getName()));
					}
					lblPetAttributes.setText(globalCurrentPet.toString());
					lblPlayerStats.setText(globalCurrentPlayer.toString());
					playBack();
				}
			}
		});

		btnToy6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnToy6.getIcon() != null) {
					lblEventOutputs.setText(String.format("%s is feeling happier!", globalCurrentPet.getName()));
					globalCurrentPet.play(currentToys.get(5));
					if (currentToys.get(5).getDurability() <= 0) {
						globalCurrentPlayer.removeToy(currentToys.get(5));
						lblEventOutputs.setText(String.format("%s is feeling happier!", globalCurrentPet.getName()));
						lblEventOutputs.setText(String.format("Your %s broke!", currentToys.get(5).getName()));
					}
					lblPetAttributes.setText(globalCurrentPet.toString());
					lblPlayerStats.setText(globalCurrentPlayer.toString());
					playBack();
				}
			}
		});
	}

	/**
	 * Holds the mouse listeners for the buttons on the main game screen.
	 * Changes colour of button on mouseover for a bit of user quality of life.
	 * Is initialized on game launch.
	 */
	public void mainScreenButtonColours() {
		btnEndDay.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnEndDay.setBackground(Color.getHSBColor(1, 20, 20));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnEndDay.setBackground(UIManager.getColor("control"));
			}
		});

		btnVisitDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnVisitDoctor.setBackground(Color.getHSBColor(1, 20, 20));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnVisitDoctor.setBackground(UIManager.getColor("control"));
			}
		});

		btnPunishPet.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnPunishPet.setBackground(Color.getHSBColor(1, 20, 20));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnPunishPet.setBackground(UIManager.getColor("control"));
			}
		});

		btnUseToilet.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnUseToilet.setBackground(Color.getHSBColor(1, 20, 20));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnUseToilet.setBackground(UIManager.getColor("control"));
			}
		});

		btnUseToy.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnUseToy.setBackground(Color.getHSBColor(1, 20, 20));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnUseToy.setBackground(UIManager.getColor("control"));
			}
		});

		btnSleep.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnSleep.setBackground(Color.getHSBColor(1, 20, 20));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnSleep.setBackground(UIManager.getColor("control"));
			}
		});

		btnFeedPet.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnFeedPet.setBackground(Color.getHSBColor(1, 20, 20));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnFeedPet.setBackground(UIManager.getColor("control"));
			}
		});

		btnVisitTheStore.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnVisitTheStore.setBackground(Color.getHSBColor(1, 20, 20));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnVisitTheStore.setBackground(UIManager.getColor("control"));
			}
		});

		btnPetSelect.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnPetSelect.setBackground(Color.getHSBColor(1, 20, 20));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnPetSelect.setBackground(UIManager.getColor("control"));
			}
		});

		btnRevive.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnRevive.setBackground(Color.getHSBColor(1, 20, 20));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnRevive.setBackground(UIManager.getColor("control"));
			}
		});
	}

	/**
	 * Holds the actions listeners for the main game buttons on the main screen.
	 * Contains some logic is used mostly for called other methods. Is
	 * initialized on game launch.
	 */
	public void GUIfinalMainButtons() {

		btnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (globalCurrentPet == null) {
					lblEventOutputs.setText("You need to select a pet first!");
				} else {
					if (globalCurrentPet.getActions() == 0) {

						lblEventOutputs.setText("<html>Sorry! This pet has already <br>taken 2 actions today.");
					} else {
						sleep();
						lblPetAttributes.setText(globalCurrentPet.toString());
						lblPlayerStats.setText(globalCurrentPlayer.toString());
					}
				}
			}
		});

		btnUseToilet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (globalCurrentPet == null) {
					lblEventOutputs.setText("You need to select a pet first!");
					;
				} else {
					if (globalCurrentPet.getActions() == 0) {
						lblEventOutputs.setText("<html>Sorry! This pet has already <br>taken 2 actions today.");
					} else {
						toilet();
						lblPetAttributes.setText(globalCurrentPet.toString());
						lblPlayerStats.setText(globalCurrentPlayer.toString());
					}
				}
			}
		});

		btnPunishPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (globalCurrentPet == null) {
					lblEventOutputs.setText("You need to select a pet first!");
				} else {
					punish();
					lblPetAttributes.setText(globalCurrentPet.toString());
					lblPlayerStats.setText(globalCurrentPlayer.toString());
				}
			}
		});

		btnRevive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				revive();
			}
		});

		btnVisitDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doctor();
			}
		});

		btnVisitTheStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelMainScreen.setVisible(false);
				panelStore.setVisible(true);
				lblPlayerContents.setText(globalCurrentPlayer.toString());
			}
		});

		btnFeedPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (globalCurrentPet == null) {
					lblEventOutputs.setText("You need to select a pet first!");
				} else if (globalCurrentPlayer.getFood().isEmpty()) {
					JOptionPane.showMessageDialog(null, "You don't have any food! Visit the store to buy some.",
							"InfoBox: " + "Warning", JOptionPane.INFORMATION_MESSAGE);
				} else if (globalCurrentPet.getActions() == 0) {
					lblEventOutputs.setText("<html>Sorry! This pet has already <br>taken 2 actions today.");
				} else {
					feedPet();
				}
			}
		});

		btnUseToy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (globalCurrentPet == null) {
					lblEventOutputs.setText("You need to select a pet first!");
				} else if (globalCurrentPlayer.getToys().isEmpty()) {
					JOptionPane.showMessageDialog(null, "You don't have any toys! Visit the store to buy some.",
							"InfoBox: " + "Warning", JOptionPane.INFORMATION_MESSAGE);
				} else if (globalCurrentPet.getActions() == 0) {
					lblEventOutputs.setText("<html>Sorry! This pet has already <br>taken 2 actions today.");
				} else {
					play();
				}
			}
		});

		btnFeedBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feedBack();
			}
		});

		btnPlayBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playBack();
			}
		});

		btnPlayerContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtn1player.isSelected() == true) {
					rdbtn1player.setSelected(false);
					inputDayNum();
					return;
				}
				if (rdbtn2players.isSelected() == true) {
					rdbtn2players.setSelected(false);
					inputDayNum();
					return;
				}
				if (rdbtn3players.isSelected() == true) {
					rdbtn3players.setSelected(false);
					inputDayNum();
					return;
				}
			}
		});

		btnPetSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelButtons.setVisible(false);
				panelPets.setVisible(true);
				selectPet();
			}
		});

		btnEndDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				endDay();
			}
		});
	}

	/**
	 * Method holding visibility requirements of some on the graphical elements.
	 * Is initialized on game launch.
	 */
	public void feedBack() {
		panelMainScreen.setVisible(true);
		panelFeed.setVisible(false);
		panelButtons.setVisible(true);

		btnFood1.setVisible(false);
		btnFood2.setVisible(false);
		btnFood3.setVisible(false);
		btnFood4.setVisible(false);
		btnFood5.setVisible(false);
		btnFood6.setVisible(false);

		lblFood1.setVisible(false);
		lblFood2.setVisible(false);
		lblFood3.setVisible(false);
		lblFood4.setVisible(false);
		lblFood5.setVisible(false);
		lblFood6.setVisible(false);
	}

	/**
	 * Method holding visibility requirements of some on the graphical elements.
	 * Is initialized on game launch.
	 */
	public void playBack() {
		lblPlayerStats.setText(globalCurrentPlayer.toString());
		panelMainScreen.setVisible(true);
		panelPlay.setVisible(false);
		panelButtons.setVisible(true);

		btnToy1.setVisible(false);
		btnToy2.setVisible(false);
		btnToy3.setVisible(false);
		btnToy4.setVisible(false);
		btnToy5.setVisible(false);
		btnToy6.setVisible(false);

		lblToy1.setVisible(false);
		lblToy2.setVisible(false);
		lblToy3.setVisible(false);
		lblToy4.setVisible(false);
		lblToy5.setVisible(false);
		lblToy6.setVisible(false);
	}

	/**
	 * Method handling button image dedications. Based on the global players
	 * currently owned pets.
	 */
	public void selectPet() {

		panelPets.setVisible(true);
		panelButtons.setVisible(false);

		int i = 0;
		for (Map.Entry<String, Species> entry : globalCurrentPlayer.getPets().entrySet()) {
			jButtons[i].setVisible(true);
			species[i] = entry.getValue();
			if (entry.getValue().getSpecies() == penguin.getSpecies()) {
				jButtons[i].setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/PENG_PET.png")));
				jLabels[i].setText(entry.getValue().getName());
				jButtons[i].setVisible(true);
				jLabels[i].setVisible(true);
			} else if (entry.getValue().getSpecies() == crab.getSpecies()) {
				jButtons[i].setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/CRAB_PET-1.png")));
				jLabels[i].setText(entry.getValue().getName());
				jButtons[i].setVisible(true);
				jLabels[i].setVisible(true);
			} else if (entry.getValue().getSpecies() == robot.getSpecies()) {
				jButtons[i].setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/ROBOT_PET.png")));
				jLabels[i].setText(entry.getValue().getName());
				jButtons[i].setVisible(true);
				jLabels[i].setVisible(true);
			} else if (entry.getValue().getSpecies() == snake.getSpecies()) {
				jButtons[i].setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/SNAKE_PET.png")));
				jLabels[i].setText(entry.getValue().getName());
				jButtons[i].setVisible(true);
				jLabels[i].setVisible(true);
			} else if (entry.getValue().getSpecies() == cloud.getSpecies()) {
				jButtons[i].setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/CLOUD_PET.png")));
				jLabels[i].setText(entry.getValue().getName());
				jButtons[i].setVisible(true);
				jLabels[i].setVisible(true);
			} else if (entry.getValue().getSpecies() == monster.getSpecies()) {
				jButtons[i].setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/MONSTER_PET.png")));
				jLabels[i].setText(entry.getValue().getName());
				jButtons[i].setVisible(true);
				jLabels[i].setVisible(true);
			}
			i++;
		}

	}

	/**
	 * Method containing button action listeners when selecting pets. Is
	 * initialized on game launch.
	 */
	public void selectPetButtons() {

		btnSelectPet1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnSelectPet1.getIcon() != null) {
					globalCurrentPet = species[0];
					currentSelectedPet();
					panelButtons.setVisible(true);
					panelPets.setVisible(false);
					mainSelectScreen();
				}
			}
		});
		btnSelectPet2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnSelectPet2.getIcon() != null) {
					globalCurrentPet = species[1];
					currentSelectedPet();
					panelButtons.setVisible(true);
					panelPets.setVisible(false);
					mainSelectScreen();
				}
			}
		});
		btnSelectPet3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnSelectPet3.getIcon() != null) {
					globalCurrentPet = species[2];
					currentSelectedPet();
					panelButtons.setVisible(true);
					panelPets.setVisible(false);
					mainSelectScreen();
				}
			}
		});
	}

	/**
	 * Method handling button image dedications. Based on the global players
	 * currently owned pet.
	 */
	public void currentSelectedPet() {
		lblCurrentPet.setText(String.format("Current pet: %s", globalCurrentPet.getName()));
		lblPetAttributes.setText(globalCurrentPet.toString());
		lblPlayerStats.setText(globalCurrentPlayer.toString());
		if (globalCurrentPet.getSpecies() == penguin.getSpecies()) {
			lblCurrentSelectedPet.setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/PENG_PET.png")));
		} else if (globalCurrentPet.getSpecies() == crab.getSpecies()) {
			lblCurrentSelectedPet.setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/CRAB_PET-1.png")));

		} else if (globalCurrentPet.getSpecies() == robot.getSpecies()) {
			lblCurrentSelectedPet.setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/ROBOT_PET.png")));

		} else if (globalCurrentPet.getSpecies() == snake.getSpecies()) {
			lblCurrentSelectedPet.setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/SNAKE_PET.png")));

		} else if (globalCurrentPet.getSpecies() == cloud.getSpecies()) {
			lblCurrentSelectedPet.setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/CLOUD_PET.png")));

		} else if (globalCurrentPet.getSpecies() == monster.getSpecies()) {
			lblCurrentSelectedPet.setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/MONSTER_PET.png")));

		}

	}

	/**
	 * Method handling the graphical elements of the main game screen.
	 */
	public void mainSelectScreen() {

		panelCreation.setVisible(false);
		panelMainScreen.setVisible(true);
		lblCurrentPlayer.setText(String.format("Current player: %s", globalCurrentPlayer.getName()));
		lblCurrentDay.setText(String.format("%d", globalCurrentDay));
		lblDayTotals.setText(String.format("/%1$,.0f", gameDays));
	}

	/**
	 * Method containing the logic interactions when the pet is punished. Is
	 * called from a button action listener.
	 */
	public void punish() {
		if (globalCurrentPet.getMisbehaving() == true) {
			lblEventOutputs.setText(
					String.format("<html>%s is upset, but can focus better<br> (can have 2 actions again next day)",
							globalCurrentPet.getName()));
			globalCurrentPet.punish();
		} else {
			lblEventOutputs.setText(String.format("%s isn't misbehaving!", globalCurrentPet.getName()));

		}

	}

	/**
	 * Method containing the logic interactions when the pet is revived. Is
	 * called from a button action listener.
	 */
	public void revive() {
		if (globalCurrentPet == null) {
			lblEventOutputs.setText("You need to select a pet first!");
		} else if (globalCurrentPet.getAlive() == false && globalCurrentPet.getRevive() == true) {
			globalCurrentPet.setRevive(false);
			lblEventOutputs.setText("Your pet has revived!");
			lblPetAttributes.setText(globalCurrentPet.toString());
		} else if (globalCurrentPet.getAlive() == true) {
			lblEventOutputs.setText("Your pet is already alive!");
		} else {
			lblEventOutputs.setText("Sorry, your pet is only allowed to revive once! ");
		}
	}

	/**
	 * Method containing the logic interactions when the pet is taken to the
	 * doctor. Is called from a button action listener.
	 */
	public void doctor() {

		if (globalCurrentPet == null) {
			lblEventOutputs.setText("You need to select a pet first!");
		} else {
			if (globalCurrentPet.getActions() == 0) {
				lblEventOutputs.setText("<html>Sorry! This pet has already <br>taken 2 actions today.");
			} else if (globalCurrentPet.getSick() == true) {
				globalCurrentPet.heal();
				lblEventOutputs.setText(String.format("%s isn't sick anymore!", globalCurrentPet.getName()));
				lblPetAttributes.setText(globalCurrentPet.toString());
				lblPlayerStats.setText(globalCurrentPlayer.toString());
			} else {
				globalCurrentPet.heal();
				lblPetAttributes.setText(globalCurrentPet.toString());
				lblPlayerStats.setText(globalCurrentPlayer.toString());
				lblEventOutputs.setText(String.format("%s is feeling healthier!", globalCurrentPet.getName()));
			}
		}
	}

	/**
	 * Method handling graphical elements related to the start game panel.
	 * Contains an action listener that calls text from the interface
	 * gameObjects when activated.
	 */
	public void gameStart() {
		panelStart.setVisible(true);
		panelHelp.setVisible(false);
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textCounter = 1;
				panelStart.setVisible(false);
				panelHelp.setVisible(true);
				clickPanel.setVisible(true);
				lblHelp.setText("");
			}
		});

		clickPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (textCounter == 1) {
					lblHelp.setText(help1);
				}
				if (textCounter == 2) {
					lblHelp.setText(help2);
				}
				if (textCounter == 3) {
					lblHelp.setText(help3);
				}
				if (textCounter == 4) {
					lblHelp.setText(help4);
				}
				if (textCounter == 5) {
					lblHelp.setText(help5);
				}
				if (textCounter == 6) {
					panelStart.setVisible(true);
					panelHelp.setVisible(false);
					textCounter = 1;
				}
				textCounter++;
			}
		});

		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputPlayerNum();
			}
		});
	}

	/**
	 * Method handling visibility requirements for graphical elements on the
	 * player initialization screen.
	 */
	public void inputPlayerNum() {
		panelInput.setVisible(true);
		panelStart.setVisible(false);
		panelHelp.setVisible(false);
	}

	/**
	 * Method handling visibility requirements for graphical elements on the
	 * game days initialization screen. Contains an action listener for a basic
	 * continue button.
	 */
	public void inputDayNum() {
		gameDays = 0;

		spinnerDayNum.setVisible(true);
		lblPlayerNum.setText("How many days will the game run for?");
		rdbtn1player.setVisible(false);
		rdbtn2players.setVisible(false);
		rdbtn3players.setVisible(false);
		btnPlayerContinue.setVisible(false);
		btnPlayerContinue2.setVisible(true);

		btnPlayerContinue2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameDays = (Double) spinnerDayNum.getValue();
				createPlayers();
			}
		});
	}

	/**
	 * Method containing logic that checks whether 2 pets have the same name,
	 * and returns false if they do.
	 * 
	 * @return boolean letting the program know if 2 pets have the same name.
	 */
	public boolean dualPetNameChecker() {
		String textFields[] = { txtPetName1.getText(), txtPetName2.getText(), txtPetName3.getText(),
				txtPetName4.getText(), txtPetName5.getText(), txtPetName6.getText() };
		List<String> petNames = new ArrayList<String>();
		for (String name : textFields) {
			if (!name.equals("Enter a name...")) {
				if (petNames.contains(name)) {
					return true;
				}
				if (existingPetNames.contains(name)) {
					return true;
				}
				petNames.add(name);
			}
		}
		return false;
	}

	/**
	 * Method containing the main logic related to player and pet selctions/name
	 * inputs. Makes use of pop-up error windows when user input is not what is
	 * required.
	 */
	public void createPlayers() {
		textCounter = 1;
		panelInput.setVisible(false);
		panelCreation.setVisible(true);
		lblNamePrompt.setText(
				String.format("Player %d, enter your name here and select up to 3 pets above before clicking continue.",
						textCounter));

		btnCreationContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldCreation.grabFocus();
				if (textFieldCreation.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "You need to enter a name for your player!",
							"InfoBox: " + "Warning", JOptionPane.INFORMATION_MESSAGE);
				} else if (boxCounter() > 3 || boxCounter() == 0) {
					JOptionPane.showMessageDialog(null, "You need to select 1-3 Pets for you to own!",
							"InfoBox: " + "Warning", JOptionPane.INFORMATION_MESSAGE);
				} else if (petNameChecker() == false) {
					JOptionPane.showMessageDialog(null, "One or more of your selected pets does not have a name yet!",
							"InfoBox: " + "Warning", JOptionPane.INFORMATION_MESSAGE);
				} else if (existingPlayerChecker(textFieldCreation.getText()) == true) {
					JOptionPane.showMessageDialog(frame, "That name belongs to another player, please choose another.");
				} else if (textFieldCreation.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "You need to enter a name for your player.");
				} else if (dualPetNameChecker() == true) {
					JOptionPane.showMessageDialog(frame,
							"2 pets you are making have the same name, or share the name with a previous player. Please choose another.");
				} else if (textCounter >= numOfPlayers) {
					Player newPlayerFinal = new Player(textFieldCreation.getText());
					addPlayer(newPlayerFinal, textCounter);
					textFieldCreation.setText("");
					createPets(newPlayerFinal);
					clearBoxes();
					globalCurrentPlayer = players.get(1);
					playerIterator = 1;
					globalCurrentDay = 1;
					mainSelectScreen();
				} else if (textCounter == 1) {
					Player newPlayer1 = new Player(textFieldCreation.getText());
					addPlayer(newPlayer1, 1);
					createPets(newPlayer1);
					textFieldCreation.setText("");
					lblNamePrompt.setText(String.format(
							"Player %d, enter your name here and select up to 3 pets above before clicking continue.",
							2));
					textCounter++;
					clearBoxes();
				} else if (textCounter == 2) {
					Player newPlayer2 = new Player(textFieldCreation.getText());
					addPlayer(newPlayer2, 2);
					createPets(newPlayer2);
					textFieldCreation.setText("");
					lblNamePrompt.setText(String.format(
							"Player %d, enter your name here and select up to 3 pets above before clicking continue.",
							3));
					textCounter++;
					clearBoxes();
				} else if (textCounter == 3) {
					Player newPlayer3 = new Player(textFieldCreation.getText());
					addPlayer(newPlayer3, 3);
					createPets(newPlayer3);
					textFieldCreation.setText("");
					lblNamePrompt.setText(String.format(
							"Player %d, enter your name here and select up to 3 pets above before clicking continue.",
							4));
					textCounter++;
					clearBoxes();
				} else if (textCounter == 4) {
					Player newPlayer4 = new Player(textFieldCreation.getText());
					addPlayer(newPlayer4, 4);
					createPets(newPlayer4);
					textFieldCreation.setText("");
					textCounter = 1;
					clearBoxes();
				}
			}
		});
	}

	/**
	 * Method handling visibility requirements check boxes on the pet creation
	 * panel.
	 */
	public void clearBoxes() {
		txtPetName1.setText("Enter a name...");
		txtPetName2.setText("Enter a name...");
		txtPetName3.setText("Enter a name...");
		txtPetName4.setText("Enter a name...");
		txtPetName5.setText("Enter a name...");
		txtPetName6.setText("Enter a name...");
		chckbxPet1.setSelected(false);
		chckbxPet2.setSelected(false);
		chckbxPet3.setSelected(false);
		chckbxPet4.setSelected(false);
		chckbxPet5.setSelected(false);
		chckbxPet6.setSelected(false);
	}

	/**
	 * Checks whether 2 players have the same name.
	 * 
	 * @param name
	 *            -the player name of type String.
	 * @return boolean -returns true if 2 players have the same name.
	 */
	public boolean existingPlayerChecker(String name) {
		for (Map.Entry<Integer, Player> entry : players.entrySet()) {
			if (entry.getValue().getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * A simple method for counting how many check boxes are selected on the pet
	 * creation panel.
	 * 
	 * @return Returns an int of how many check boxes are selected.
	 */
	public int boxCounter() {
		int counter = 0;
		if (chckbxPet1.isSelected()) {
			counter++;
		}
		if (chckbxPet2.isSelected()) {
			counter++;
		}
		if (chckbxPet3.isSelected()) {
			counter++;
		}
		if (chckbxPet4.isSelected()) {
			counter++;
		}
		if (chckbxPet5.isSelected()) {
			counter++;
		}
		if (chckbxPet6.isSelected()) {
			counter++;
		}
		return counter;
	}

	/**
	 * Method making sure the pet name is not null.
	 * 
	 * @return Returns a boolean whether or not the name is null.
	 */
	public boolean petNameChecker() {
		if ((chckbxPet1.isSelected()) && (txtPetName1.getText().equals("Enter a name..."))) {
			return false;
		} else if ((chckbxPet2.isSelected()) && (txtPetName2.getText().equals("Enter a name..."))) {
			return false;
		} else if ((chckbxPet3.isSelected()) && (txtPetName3.getText().equals("Enter a name..."))) {
			return false;
		} else if ((chckbxPet4.isSelected()) && (txtPetName4.getText().equals("Enter a name..."))) {
			return false;
		} else if ((chckbxPet5.isSelected()) && (txtPetName5.getText().equals("Enter a name..."))) {
			return false;
		} else if ((chckbxPet6.isSelected()) && (txtPetName6.getText().equals("Enter a name..."))) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * Checks whether a player already owned a specific Toy.
	 * 
	 * @param toy
	 *            -the Toy being checked if already owned.
	 * @return Returns a boolean true if Toy is already owned.
	 */
	public boolean toyChecker(Toy toy) {
		boolean toyOwned = false;
		for (Map.Entry<Toy, Integer> entry : globalCurrentPlayer.getToys().entrySet()) {
			Toy ownedToy = entry.getKey();
			if (toy.getName().equals(ownedToy.getName())) {
				toyOwned = true;
			}
		}
		return toyOwned;
	}

	/**
	 * Method calculating a user score for a player for the end game panel.
	 * 
	 * @param player
	 *            -the player whose score is being calculated.
	 * @return Returns an int of user score.
	 */
	public int score(Player player) {
		int score = 0;

		for (Map.Entry<String, Species> entry : player.getPets().entrySet()) {
			Species pet = entry.getValue();
			score += pet.getHealth();
		}
		return score;
	}

	/**
	 * Method handling the visibility requirements of graphical elements related
	 * to the end game panel.
	 */
	public void endGame() {
		panelMainScreen.setVisible(false);
		panelEnd.setVisible(true);
		String output = "<html>Total scores for game:<br>";

		Map<Player, Integer> playerScores = new HashMap<Player, Integer>();
		for (Map.Entry<Integer, Player> entry : players.entrySet()) {
			Player val = entry.getValue();
			playerScores.put(val, score(val));
		}

		for (Player key : playerScores.keySet()) {
			output = output.concat(String.format("<html>%s: %d<br><br>", key.getName(), playerScores.get(key)));
		}
		lblEndStats.setText(output);

		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				;
			}
		});
	}

	/**
	 * Method handling visibility requirements for graphical elements when a new
	 * player's turn begin. Resets all lists to make it clean for the new
	 * player.
	 */
	public void resetNewPlayer() {
		btnSelectPet1.setIcon(null);
		btnSelectPet2.setIcon(null);
		btnSelectPet3.setIcon(null);
		lblPetName1.setText("");
		lblPetName2.setText("");
		lblPetName3.setText("");
		button1 = null;
		button2 = null;
		button3 = null;
		btnSelectPet1.setVisible(false);
		btnSelectPet2.setVisible(false);
		btnSelectPet3.setVisible(false);
		lblPetName1.setVisible(false);
		lblPetName2.setVisible(false);
		lblPetName3.setVisible(false);
		globalCurrentPet = null;
		lblCurrentPet.setText("Current Pet: NONE");
		lblPetAttributes.setText("");
		lblCurrentSelectedPet.setIcon(null);
		lblCurrentDay.setText(String.format("%d", globalCurrentDay));
		lblPlayerStats.setText("");
		lblEventOutputs.setText("");
	}

	/**
	 * Contains the main logic for handling the end day action listener. Makes
	 * use of for if statements to check whether the game needs to go to the
	 * next day, change player, or end the game, based on the days already taken
	 * by each player.
	 */
	public void endDay() {
		globalCurrentDay++;
		if (globalCurrentDay > gameDays) {
			playerIterator++;
			if (players.get(playerIterator) != null) {
				JOptionPane.showMessageDialog(null, "Player days over. Next player turns begin now.",
						"InfoBox: " + "Warning", JOptionPane.INFORMATION_MESSAGE);
				globalCurrentDay = 1;
				resetNewPlayer();
				globalCurrentPlayer = players.get(playerIterator);
				lblCurrentPlayer.setText(String.format("Current player: %s", globalCurrentPlayer.getName()));

			} else {
				endGame();
			}
		} else {
			String output = "";
			for (Map.Entry<String, Species> entry : globalCurrentPlayer.getPets().entrySet()) {
				Species pet = entry.getValue();
				pet.endDay();
				if (pet.getAlive() == false) {
					output = output.concat(String.format("<html>%s has died from illness!<br>", pet.getName()));
					output = output
							.concat(String.format("<html>If the pet has not died before, he can be revived!<br><br>"));
				}
				if (pet.getSick() == true) {
					output = output.concat(String.format(
							"<html>%s is sick! This causes your pet to waste 1 action per day.<br>", pet.getName()));
					output = output.concat(String.format(
							"<html>Your pet can be treated at the doctor's (this will use an action).<br><br>"));
				}
				if (pet.getMisbehaving() == true) {
					output = output.concat(
							String.format("<html>%s is misbehaving! This causes your pet to lose 1 action per day.<br>",
									pet.getName()));
					output = output
							.concat(String.format("<html>Your pet can be punished (this will use an action).<br><br>"));
				}
			}

			lblCurrentDay.setText(String.format("%d", globalCurrentDay));
			lblEventOutputs.setText(output);
			lblPetAttributes.setText(globalCurrentPet.toString());
		}
	}

	/**
	 * Calls the toilet method for the Pet.
	 */
	public void toilet() {
		globalCurrentPet.toilet();
		lblEventOutputs.setText(String.format("%s feels relieved.", globalCurrentPet.getName()));
	}

	/**
	 * Calls the sleep method for the Pet.
	 */
	public void sleep() {
		lblEventOutputs.setText(String.format("%s feels refreshed!", globalCurrentPet.getName()));
		globalCurrentPet.sleep();
	}

	/**
	 * Calls the play method for the Pet. Handles the button image settings for
	 * Toy objects.
	 */
	public void play() {
		panelPlay.setVisible(true);
		panelButtons.setVisible(false);
		JButton[] jButtons = { btnToy1, btnToy2, btnToy3, btnToy4, btnToy5, btnToy6 };
		JLabel[] jLabels = { lblToy1, lblToy2, lblToy3, lblToy4, lblToy5, lblToy6 };
		int i = 0;
		for (Map.Entry<Toy, Integer> entry : globalCurrentPlayer.getToys().entrySet()) {
			jButtons[i].setVisible(true);
			Toy toy = entry.getKey();
			currentToys.put(i, toy);
			if (entry.getKey().getName() == yoyo.getName()) {
				jButtons[i].setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/yoy.jpg")));
				jButtons[i].setVisible(true);
				jLabels[i].setVisible(true);
				jLabels[i].setText(String.format("Durability: %d", entry.getKey().getDurability()));
			} else if (entry.getKey().getName() == doll.getName()) {
				jButtons[i].setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/Doll_Toy.jpg")));
				jLabels[i].setText(String.format("Durability: %d", entry.getKey().getDurability()));
				jButtons[i].setVisible(true);
				jLabels[i].setVisible(true);
			} else if (entry.getKey().getName() == bear.getName()) {
				jButtons[i].setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/Bear_Toy.jpg")));
				jLabels[i].setText(String.format("Durability: %d", entry.getKey().getDurability()));
				jButtons[i].setVisible(true);
				jLabels[i].setVisible(true);
			} else if (entry.getKey().getName() == kite.getName()) {
				jButtons[i].setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/KITE_TOY.png")));
				jLabels[i].setText(String.format("Durability: %d", entry.getKey().getDurability()));
				jButtons[i].setVisible(true);
				jLabels[i].setVisible(true);
			} else if (entry.getKey().getName() == boat.getName()) {
				jButtons[i].setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/Boat_Toy.jpg")));
				jLabels[i].setText(String.format("Durability: %d", entry.getKey().getDurability()));
				jButtons[i].setVisible(true);
				jLabels[i].setVisible(true);
			} else if (entry.getKey().getName() == heli.getName()) {
				jButtons[i].setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/HELI_TOY.jpg")));
				jLabels[i].setText(String.format("Durability: %d", entry.getKey().getDurability()));
				jButtons[i].setVisible(true);
				jLabels[i].setVisible(true);
			}
			i++;
		}
	}

	/**
	 * Calls the feed method for the Pet. Handles the button image settings for
	 * Food objects.
	 */
	public void feedPet() {
		panelFeed.setVisible(true);
		panelButtons.setVisible(false);
		JButton[] jButtons = { btnFood1, btnFood2, btnFood3, btnFood4, btnFood5, btnFood6 };
		JLabel[] jLabels = { lblFood1, lblFood2, lblFood3, lblFood4, lblFood5, lblFood6 };
		int i = 0;
		for (Map.Entry<Food, Integer> entry : globalCurrentPlayer.getFood().entrySet()) {
			jButtons[i].setVisible(true);
			Food food = entry.getKey();
			currentFood.put(i, food);
			if (entry.getKey().getName() == cookie.getName()) {
				jButtons[i].setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/Cookies.jpg")));
				jButtons[i].setVisible(true);
				jLabels[i].setVisible(true);
				jLabels[i].setText(String.format("x%d", entry.getValue()));
			} else if (entry.getKey().getName() == melon.getName()) {
				jButtons[i].setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/water_m.jpg")));
				jLabels[i].setText(String.format("x%d", entry.getValue()));
				jButtons[i].setVisible(true);
				jLabels[i].setVisible(true);
			} else if (entry.getKey().getName() == fish.getName()) {
				jButtons[i].setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/Fish.jpg")));
				jLabels[i].setText(String.format("x%d", entry.getValue()));
				jButtons[i].setVisible(true);
				jLabels[i].setVisible(true);
			} else if (entry.getKey().getName() == chocolate.getName()) {
				jButtons[i].setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/Choclate.jpg")));
				jLabels[i].setText(String.format("x%d", entry.getValue()));
				jButtons[i].setVisible(true);
				jLabels[i].setVisible(true);
			} else if (entry.getKey().getName() == cake.getName()) {
				jButtons[i].setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/cake.jpg")));
				jLabels[i].setText(String.format("x%d", entry.getValue()));
				jButtons[i].setVisible(true);
				jLabels[i].setVisible(true);
			} else if (entry.getKey().getName() == pizza.getName()) {
				jButtons[i].setIcon(new ImageIcon(GUIfinal.class.getResource("/photo/Pizza.jpg")));
				jLabels[i].setText(String.format("x%d", entry.getValue()));
				jButtons[i].setVisible(true);
				jLabels[i].setVisible(true);
			}
			i++;
		}
	}

	/**
	 * Method reading check boxes on the pet selection panel, and adds pets to
	 * the player if selected.
	 * 
	 * @param player-
	 *            the player the pet is being added to.
	 */
	public void createPets(Player player) {

		if (chckbxPet1.isSelected()) {
			existingPetNames.add(txtPetName1.getText());
			Species newPet = new Species(txtPetName1.getText(), speciesChoices.get(1));
			player.addPet(newPet);
		}
		if (chckbxPet2.isSelected()) {
			existingPetNames.add(txtPetName2.getText());
			Species newPet = new Species(txtPetName2.getText(), speciesChoices.get(2));
			player.addPet(newPet);
		}
		if (chckbxPet3.isSelected()) {
			existingPetNames.add(txtPetName3.getText());
			Species newPet = new Species(txtPetName3.getText(), speciesChoices.get(3));
			player.addPet(newPet);
		}
		if (chckbxPet4.isSelected()) {
			existingPetNames.add(txtPetName4.getText());
			Species newPet = new Species(txtPetName4.getText(), speciesChoices.get(4));
			player.addPet(newPet);
		}
		if (chckbxPet5.isSelected()) {
			existingPetNames.add(txtPetName5.getText());
			Species newPet = new Species(txtPetName5.getText(), speciesChoices.get(5));
			player.addPet(newPet);
		}
		if (chckbxPet6.isSelected()) {
			existingPetNames.add(txtPetName6.getText());
			Species newPet = new Species(txtPetName6.getText(), speciesChoices.get(6));
			player.addPet(newPet);
		}
	}

	/**
	 * Adds a Toy to the player. Evoked the addtoy() method of the Toy class.
	 * 
	 * @param player-
	 *            the player the Toy is being added to.
	 * @param toyName
	 *            - the Toy being added.
	 */
	public void addToy(String player, String toyName) {
		Toy toy = toyChoices.get(toyName);
		Player val = players.get(player);
		val.addToy(toy);
	}

	/**
	 * Adds a player to the game environment.
	 * 
	 * @param player-
	 *            the player being added.
	 * @param i-
	 *            key value used in storing the player for iteration.
	 */
	public void addPlayer(Player player, int i) {
		players.put(i, player);
	}

	/**
	 * Adds Food objects to the player.
	 * 
	 * @param player
	 *            - the player being added to.
	 * @param foodName
	 *            - the Food object being added.
	 */
	public void addFood(String player, String foodName) {
		Food food = foodChoices.get(foodName);
		Player val = players.get(player);
		val.addFood(food);
	}

	/**
	 * Main method. Initializes all required action listeners and graphical
	 * elements in the game environment.
	 * 
	 * @param args
	 *            Not used.
	 */
	public static void main(String[] args) {

		GUIfinal newGame = new GUIfinal();
		newGame.playerButtons();
		newGame.GUIfinalConstructor();
		newGame.GUIfinalMainButtons();
		newGame.selectPetButtons();
		newGame.mainScreenButtonColours();
		newGame.feedButtons();
		newGame.playButtons();
		newGame.storeButtons();
		newGame.mouseClickActions();
		newGame.frame.setVisible(true);
		newGame.gameStart();
	}
}
