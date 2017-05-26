package pet_game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

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

public class GUI implements gameObjects {

	int textCounter = 1;
	JFrame frame;
	//// Initializations
	private Species globalCurrentPet;
	private String currentPlayer;
	private int numOfPlayers;
	private double gameDays;
	private double playerDaysTaken;
	private List<String> existingPetNames = new ArrayList<String>();
	// private Map<Integer, Toy> toyChoices = new HashMap<Integer, Toy>();
	// private Map<Integer, Food> foodChoices = new HashMap<Integer, Food>();
	// private Map<Integer, Species> speciesChoices = new HashMap<Integer,
	// Species>();
	// private Map<Integer, Player> players = new HashMap<Integer, Player>();

	JLabel lblWelcome = new JLabel("<html>Welcome to Pets <br> the virtual pet game!");
	JButton btnStart = new JButton("Start");
	JButton btnHelp = new JButton("Help");
	private final JPanel startPanel = new JPanel();
	private final JPanel helpPanel = new JPanel();
	private JLabel lblHelp = new JLabel("");
	private final JLabel lblContinue = new JLabel("Click to continue...\r\n");
	private final JLabel lblHelpcounter = new JLabel("");
	private final JPanel clickPanel = new JPanel();
	JPanel inputPanel = new JPanel();
	private final JLabel lblPlayerNum = new JLabel("How many players would like to play the game?");

	ButtonGroup radioGroupPlayers = new ButtonGroup();
	JRadioButton rdbtn1player = new JRadioButton("1 Player");
	JRadioButton rdbtn3players = new JRadioButton("3 Players");
	JRadioButton rdbtn2players = new JRadioButton("2 Players");

	JButton btnPlayerContinue = new JButton("Continue\n");
	private final JButton btnPlayerContinue2 = new JButton("Continue\n");
	JSpinner spinnerDayNum = new JSpinner();
	private final JPanel creationPanel = new JPanel();
	private final JLabel lblNamePrompt = new JLabel("");
	private final JTextField textFieldCreation = new JTextField();
	private final JButton btnCreationContinue = new JButton("Continue\n");
	private final JPanel panelPet = new JPanel();
	private final JLabel lblpetdetails = new JLabel("");
	JButton btnPetCounter = new JButton("Continue\n");
	private JTextField txtPetName1;
	private JTextField txtPetName2;
	private JTextField txtPetName3;
	private JTextField txtPetName4;
	private JTextField txtPetName5;
	private JTextField txtPetName6;
	private final JLabel lblSelectUpTo = new JLabel("Select up to 3.");
	JCheckBox chckbxPet1 = new JCheckBox("Select Cloud");
	JCheckBox chckbxPet2 = new JCheckBox("Select Crab");
	JCheckBox chckbxPet3 = new JCheckBox("Select Monster");
	JCheckBox chckbxPet4 = new JCheckBox("Select Penquin");
	JCheckBox chckbxPet5 = new JCheckBox("Select Robot");
	JCheckBox chckbxPet6 = new JCheckBox("Select Snake");
	JLabel lblNewLabel = new JLabel("Put pets + description here");
	JLabel lblWelcome2 = new JLabel("<html>Welcome to Pets <br>the virtual pet game!");
	JLabel lblNewLabel_2 = new JLabel("New label");
	JLabel lblBeng = new JLabel("New label");
	JLabel lblNewLabel_4 = new JLabel("New label");
	JLabel lblNewLabel_5 = new JLabel("New label");
	JLabel lblNewLabel6 = new JLabel("");
	JLabel lblNewLabel_1 = new JLabel("New label");
	private final JLabel lblBackgroundIcon = new JLabel("New label");
	private final JLabel lblBackgroundstart = new JLabel("New label");
	private final JLabel lblNewLabel_6 = new JLabel(
			"<html>Cloud: seems to care only <br> about itself,but can bring great joy to others.\n");
	private final JLabel lblNewLabel_3 = new JLabel(
			"<html>Penguin: not much to be <br>said about this black and white companion.");
	private final JLabel lblNewLabel_7 = new JLabel("<html>Crab: loyal but simple.<br> Obsessed with toys.");
	private final JLabel lblNewLabel_8 = new JLabel(
			"<html>Robot: has great personality for<br> a machine. Spends most of his time recharging his batteries.");
	private final JLabel lblNewLabel_9 = new JLabel(
			"<html>Monster: while scary looking, <br>has a gentle heart beneath the rugged fur.");
	private final JLabel lblNewLabel_10 = new JLabel(
			"<html>Snake: is as slippery as he<br> is untrustworthy. Keep a close eye on this one.\\n");
	private final JLabel lblNewLabel_11 = new JLabel("New label");
	private final JLabel lblNewLabel_12 = new JLabel("New label");

	public GUI() {

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

	public void guiConstructor() {

		frame = new JFrame();
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setBounds(100, 100, 1215, 744);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		creationPanel.setLayout(null);
		lblNewLabel.setBounds(450, 74, 192, 192);
		lblSelectUpTo.setForeground(Color.WHITE);
		lblSelectUpTo.setFont(new Font("Dialog", Font.BOLD, 25));
		lblSelectUpTo.setBounds(474, 26, 246, 37);
		
				creationPanel.add(lblSelectUpTo);
		lblBeng.setBounds(98, 310, 192, 192);

		lblBeng.setIcon(new ImageIcon(GUI.class.getResource("/photo/PENG_PET.png")));
		creationPanel.add(lblBeng);
		lblNewLabel_4.setBounds(450, 310, 192, 192);

		lblNewLabel_4.setIcon(new ImageIcon(GUI.class.getResource("/photo/ROBOT_PET.png")));
		creationPanel.add(lblNewLabel_4);
		lblNewLabel_2.setBounds(801, 74, 192, 192);

		lblNewLabel_2.setIcon(new ImageIcon(GUI.class.getResource("/photo/MONSTER_PET.png")));
		creationPanel.add(lblNewLabel_2);
		lblNewLabel_1.setBounds(98, 74, 192, 192);
		lblNewLabel_1.setIcon(new ImageIcon(GUI.class.getResource("/photo/CLOUD_PET.png")));
		creationPanel.add(lblNewLabel_1);
		lblNewLabel_5.setBounds(801, 310, 192, 192);

		lblNewLabel_5.setIcon(new ImageIcon(GUI.class.getResource("/photo/SNAKE_PET.png")));
		creationPanel.add(lblNewLabel_5);
		lblNewLabel.setIcon(new ImageIcon(GUI.class.getResource("/photo/CRAB_PET-1.png")));
		creationPanel.add(lblNewLabel);
		creationPanel.add(lblNewLabel);
		textFieldCreation.setBounds(274, 513, 698, 67);
		textFieldCreation.setColumns(10);
		creationPanel.setBackground(Color.GRAY);
		creationPanel.setVisible(false);
		creationPanel.setBounds(0, 0, 1213, 718);

		frame.getContentPane().add(creationPanel);
		lblNamePrompt.setForeground(Color.WHITE);
		lblNamePrompt.setBounds(274, 579, 698, 83);

		creationPanel.add(lblNamePrompt);

		creationPanel.add(textFieldCreation);
		btnCreationContinue.setBounds(510, 622, 193, 61);

		btnCreationContinue.setVerticalAlignment(SwingConstants.BOTTOM);

		creationPanel.add(btnCreationContinue);
		btnPetCounter.setBounds(510, 622, 193, 61);

		btnPetCounter.setVisible(false);
		btnPetCounter.setVerticalAlignment(SwingConstants.BOTTOM);
		creationPanel.add(btnPetCounter);

		txtPetName1 = new JTextField();
		txtPetName1.setBounds(294, 235, 130, 31);
		txtPetName1.setText("Enter a name...");
		creationPanel.add(txtPetName1);
		txtPetName1.setColumns(10);

		txtPetName2 = new JTextField();
		txtPetName2.setBounds(652, 235, 130, 31);
		txtPetName2.setText("Enter a name...");
		txtPetName2.setColumns(10);
		creationPanel.add(txtPetName2);

		txtPetName3 = new JTextField();
		txtPetName3.setBounds(1003, 235, 130, 31);
		txtPetName3.setText("Enter a name...");
		txtPetName3.setColumns(10);
		creationPanel.add(txtPetName3);

		txtPetName4 = new JTextField();
		txtPetName4.setBounds(294, 469, 130, 31);
		txtPetName4.setText("Enter a name");
		txtPetName4.setColumns(10);
		creationPanel.add(txtPetName4);

		txtPetName5 = new JTextField();
		txtPetName5.setBounds(647, 471, 130, 31);
		txtPetName5.setText("Enter a name...");
		txtPetName5.setColumns(10);
		creationPanel.add(txtPetName5);

		txtPetName6 = new JTextField();
		txtPetName6.setBounds(1003, 471, 130, 31);
		txtPetName6.setText("Enter a name...");
		txtPetName6.setColumns(10);
		creationPanel.add(txtPetName6);
		chckbxPet1.setBounds(296, 205, 129, 23);
		creationPanel.add(chckbxPet1);
		chckbxPet2.setBounds(652, 205, 129, 23);
		creationPanel.add(chckbxPet2);
		chckbxPet3.setBounds(1004, 205, 129, 23);
		creationPanel.add(chckbxPet3);
		chckbxPet4.setBounds(296, 439, 129, 23);
		creationPanel.add(chckbxPet4);
		chckbxPet5.setBounds(648, 441, 129, 23);
		creationPanel.add(chckbxPet5);
		chckbxPet6.setBounds(1004, 441, 129, 23);
		creationPanel.add(chckbxPet6);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(294, 18, 130, 155);

		creationPanel.add(lblNewLabel_6);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(294, 268, 135, 127);

		creationPanel.add(lblNewLabel_3);
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(652, 26, 122, 125);

		creationPanel.add(lblNewLabel_7);
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(652, 268, 151, 140);

		creationPanel.add(lblNewLabel_8);
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBounds(1003, 47, 111, 125);

		creationPanel.add(lblNewLabel_9);
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setBounds(1006, 271, 119, 148);

		creationPanel.add(lblNewLabel_10);
		lblNewLabel_11.setIcon(new ImageIcon(GUI.class.getResource("/photo/Pets-Background.png")));
		lblNewLabel_11.setBounds(-58, -127, 1384, 869);

		creationPanel.add(lblNewLabel_11);

		helpPanel.setVisible(false);
		helpPanel.setBackground(Color.RED);
		helpPanel.setBounds(0, 0, 1199, 705);

		frame.getContentPane().add(helpPanel);
		helpPanel.setLayout(null);

		lblHelp.setVerticalTextPosition(SwingConstants.TOP);
		lblHelp.setVerticalAlignment(SwingConstants.TOP);

		lblHelp.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblHelp.setHorizontalTextPosition(SwingConstants.LEFT);
		lblHelp.setHorizontalAlignment(SwingConstants.LEFT);
		lblHelp.setOpaque(true);
		lblHelp.setBounds(132, 417, 935, 200);
		helpPanel.add(lblHelp);
		lblWelcome2.setForeground(Color.WHITE);
		lblWelcome2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblWelcome2.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome2.setFont(new Font("Dialog", Font.BOLD, 65));
		lblWelcome2.setBounds(245, 72, 704, 290);
		helpPanel.add(lblWelcome2);
		lblContinue.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblContinue.setOpaque(true);
		lblContinue.setBounds(132, 617, 215, 47);

		helpPanel.add(lblContinue);
		lblHelpcounter.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblHelpcounter.setOpaque(true);
		lblHelpcounter.setBounds(309, 617, 758, 47);

		helpPanel.add(lblHelpcounter);

		clickPanel.setOpaque(false);
		clickPanel.setBounds(-140, 178, 1131, 598);

		helpPanel.add(clickPanel);
		lblNewLabel_12.setIcon(new ImageIcon(GUI.class.getResource("/photo/Pets-Background.png")));
		lblNewLabel_12.setBounds(-31, -49, 1273, 850);

		helpPanel.add(lblNewLabel_12);
		panelPet.setBackground(Color.DARK_GRAY);
		panelPet.setVisible(false);
		panelPet.setBounds(0, 0, 1213, 718);

		frame.getContentPane().add(panelPet);
		panelPet.setLayout(null);
		lblpetdetails.setBackground(Color.LIGHT_GRAY);
		lblpetdetails.setOpaque(true);
		lblpetdetails.setBounds(12, 12, 607, 358);

		panelPet.add(lblpetdetails);

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
		rdbtn1player.setSelected(true);

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
		inputPanel.setBackground(Color.WHITE);
		inputPanel.setVisible(false);

		inputPanel.setBounds(0, 0, 1213, 718);
		frame.getContentPane().add(inputPanel);
		inputPanel.setLayout(null);
		rdbtn3players.setVerticalTextPosition(SwingConstants.BOTTOM);
		rdbtn3players.setHorizontalTextPosition(SwingConstants.CENTER);
		rdbtn3players.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn3players.setOpaque(false);

		rdbtn3players.setBounds(629, 427, 232, 67);
		inputPanel.add(rdbtn3players);
		rdbtn1player.setVerticalTextPosition(SwingConstants.BOTTOM);
		rdbtn1player.setHorizontalTextPosition(SwingConstants.CENTER);
		rdbtn1player.setHorizontalAlignment(SwingConstants.CENTER);

		rdbtn1player.setOpaque(false);
		rdbtn1player.setSize(new Dimension(20, 20));
		rdbtn1player.setBounds(243, 427, 232, 67);
		inputPanel.add(rdbtn1player);
		rdbtn2players.setVerticalTextPosition(SwingConstants.BOTTOM);
		rdbtn2players.setHorizontalTextPosition(SwingConstants.CENTER);
		rdbtn2players.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtn2players.setOpaque(false);
		rdbtn2players.setSize(new Dimension(20, 20));
		rdbtn2players.setBounds(429, 427, 232, 67);
		inputPanel.add(rdbtn2players);

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
		inputPanel.add(lblwelcomeToPets);

		inputPanel.add(rdbtn2players);
		lblPlayerNum.setForeground(Color.WHITE);
		lblPlayerNum.setFont(new Font("Dialog", Font.BOLD, 22));
		lblPlayerNum.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPlayerNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerNum.setBounds(253, 488, 702, 108);

		inputPanel.add(lblPlayerNum);

		btnPlayerContinue.setVerticalAlignment(SwingConstants.BOTTOM);
		btnPlayerContinue.setBounds(510, 605, 193, 78);
		inputPanel.add(btnPlayerContinue);

		btnPlayerContinue2.setVerticalAlignment(SwingConstants.BOTTOM);
		btnPlayerContinue2.setBounds(510, 622, 193, 61);

		inputPanel.add(btnPlayerContinue2);

		spinnerDayNum.setVisible(false);
		spinnerDayNum.setModel(new SpinnerNumberModel(1.0, 1.0, 19.0, 1.0));
		spinnerDayNum.setBounds(584, 470, 57, 46);
		inputPanel.add(spinnerDayNum);
		lblBackgroundIcon.setIcon(new ImageIcon(GUI.class.getResource("/photo/Pets-Background.png")));
		lblBackgroundIcon.setBounds(-19, -304, 1243, 1048);

		inputPanel.add(lblBackgroundIcon);
		startPanel.setBackground(Color.BLUE);
		startPanel.setForeground(Color.RED);
		startPanel.setBounds(0, 0, 1213, 718);

		frame.getContentPane().add(startPanel);
		startPanel.setLayout(null);

		btnHelp.setBounds(550, 542, 179, 48);
		startPanel.add(btnHelp);

		btnStart.setBounds(550, 439, 179, 48);
		startPanel.add(btnStart);
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setBackground(new Color(255, 255, 255));
		lblWelcome.setBounds(298, 99, 817, 225);
		startPanel.add(lblWelcome);
		lblWelcome.setFont(new Font("Dialog", Font.BOLD, 65));
		lblWelcome.setHorizontalTextPosition(SwingConstants.CENTER);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblBackgroundstart.setIcon(new ImageIcon(GUI.class.getResource("/photo/Pets-Background.png")));
		lblBackgroundstart.setBounds(-30, -231, 1365, 981);

		startPanel.add(lblBackgroundstart);
	}

	public void mainScreenHelper() {
		Map<Player, Integer> playerScores = new HashMap<Player, Integer>();

		for (Map.Entry<Integer, Player> entry : players.entrySet()) {
			Player val = entry.getValue();
			currentPlayer = val.getName();
			;
			playerDaysTaken = 0;
			mainSelectScreen(val);
			System.out.format("Days for %s ended, you scored a total of %d points overall, well done!", val.getName(),
					score(val));
			playerScores.put(val, score(val));
			promptEnterKey();
		}
		System.out.println("Game Over...");
		System.out.println("Total scores for game:");

		for (Player key : playerScores.keySet()) {
			System.out.format("%s: %d\n", key.getName(), playerScores.get(key));
		}
	}

	public void mainScreenText() {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("config.properties");
			// load a properties file
			prop.load(input);
			// get the property value and print it out
			System.out.println(prop.getProperty("main"));
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void mainSelectScreen(Player player) {
		String input = null;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		do {
			if (input != null) {
				System.out
						.println("\nYou have entered an invalid number," + "please enter a number between 1 and 8.\n");
				promptEnterKey();
			}
			System.out.format("Current Player: %s\n", currentPlayer);
			System.out.format("Days remaining: %1$.0f\n", (gameDays - playerDaysTaken));
			System.out.format("Current balance: $%d\n", player.getBalance());
			System.out.format("Owned pets (actions remanining):\n");
			for (Species pet : player.getPets().values()) {
				System.out.format("%s (%d)\n", pet.getName(), pet.getActions());
			}
			if (globalCurrentPet == null) {
				System.out.println("Current pet selected: NONE (select a pet to interact with it).");
			} else {
				System.out.format("Current pet selected: %s \n\n", globalCurrentPet.getName());
			}
			mainScreenText();
			input = scan.nextLine();
		}

		while (!input.matches("[1-9]" + "[0]*"));
		int intInput = Integer.parseInt(input);
		switch (intInput) {
		case 1:
			globalCurrentPet = selectPet(player);
			mainSelectScreen(player);
			break;
		case 2:
			if (globalCurrentPet == null) {
				System.out.println("You need to select a pet first!");
				promptEnterKey();
				mainSelectScreen(player);
			} else {
				System.out.println(globalCurrentPet);
				promptEnterKey();
				mainSelectScreen(player);
			}
			break;
		case 3:
			store(player);
			mainSelectScreen(player);
			break;
		case 4:
			if (globalCurrentPet == null) {
				System.out.println("You need to select a pet first!");
				promptEnterKey();
				mainSelectScreen(player);
			} else {
				if (globalCurrentPet.getActions() == 0) {
					System.out.println("Sorry! This pet has already taken 2 actions today.");
					promptEnterKey();
				} else {
					feedPet(player);
				}
				promptEnterKey();
				mainSelectScreen(player);
				break;
			}
		case 5:
			if (globalCurrentPet == null) {
				System.out.println("You need to select a pet first!");// error
																		// window
																		// in
																		// GUI
				promptEnterKey();
				mainSelectScreen(player);
			} else {
				if (globalCurrentPet.getActions() == 0) {
					System.out.println("Sorry! This pet has already taken 2 actions today.");
				} else {
					sleep();
				}
				promptEnterKey();
				mainSelectScreen(player);
			}
			break;
		case 6:
			if (globalCurrentPet == null) {
				System.out.println("You need to select a pet first!");// error
																		// window
																		// in
																		// GUI
				promptEnterKey();
				mainSelectScreen(player);
			} else {
				if (globalCurrentPet.getActions() == 0) {
					System.out.println("Sorry! This pet has already taken 2 actions today.");
					promptEnterKey();
				} else {
					play(player);
				}
				promptEnterKey();
				mainSelectScreen(player);
			}
			break;
		case 7:
			if (globalCurrentPet == null) {
				System.out.println("You need to select a pet first!");// error
																		// window
																		// in
																		// GUI
				promptEnterKey();
				mainSelectScreen(player);
			} else {
				if (globalCurrentPet.getActions() == 0) {
					System.out.println("Sorry! This pet has already taken 2 actions today.");
				} else {
					toilet();
				}
				promptEnterKey();
				mainSelectScreen(player);
			}
			break;
		case 8:
			if (globalCurrentPet == null) {
				System.out.println("You need to select a pet first!");// error
																		// window
																		// in
																		// GUI
				promptEnterKey();
				mainSelectScreen(player);
			} else {
				if (globalCurrentPet.getActions() == 0) {
					System.out.println("Sorry! This pet has already taken 2 actions today.");
				} else {
					System.out.format("%s is upset, but is now under control", globalCurrentPet);
					punish();
				}
				promptEnterKey();
				mainSelectScreen(player);
			}
			break;
		case 9:
			if (globalCurrentPet == null) {
				System.out.println("You need to select a pet first!");// error
																		// window
																		// in
																		// GUI
				promptEnterKey();
				mainSelectScreen(player);
			} else {
				if (globalCurrentPet.getActions() == 0) {
					System.out.println("Sorry! This pet has already taken 2 actions today.");
				} else {
					doctor();
				}
				promptEnterKey();
				mainSelectScreen(player);
			}
			break;
		case 10:
			endDay(player);
			playerDaysTaken++;
			System.out.println(playerDaysTaken);
			System.out.println(gameDays);
			promptEnterKey();
			if (playerDaysTaken < gameDays) {
				mainSelectScreen(player);
				break;
			}

		}
	}

	public void punish() {
		globalCurrentPet.punish();
	}

	public void doctor() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String doctorSelect = null;
		System.out.println("Doctor's Office:\n");
		System.out.println("1.Give pet medicine(cures sickness.");
		System.out.println("2.Revive pet(brings dead pets back to live)!");
		System.out.println("\n3.Quit.");

		do {
			if (doctorSelect != null) {
				System.out.println("\nYou have entered an invalid number, please try again.\n");
			}
			System.out.format("Select an action for %s.\n", globalCurrentPet.getName());
			doctorSelect = scan.nextLine();
		} while (!doctorSelect.matches("[1-3]"));
		int intDoctorSelect = Integer.parseInt(doctorSelect);

		switch (intDoctorSelect) {
		case 1:
			globalCurrentPet.heal();
//			return String.format("%s is feeling much better already!", name);
			break;
		case 2:
			globalCurrentPet.revive();
		}
	}

	public void gameStart() {
		startPanel.setVisible(true);
		helpPanel.setVisible(false);
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textCounter = 1;
				startPanel.setVisible(false);
				helpPanel.setVisible(true);
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
					startPanel.setVisible(true);
					helpPanel.setVisible(false);
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

	public void inputPlayerNum() {
		inputPanel.setVisible(true);
		startPanel.setVisible(false);
		helpPanel.setVisible(false);

		// @SuppressWarnings("resource")
		// Scanner scan = new Scanner(System.in);
		// String strPlayerNum = null;
		//
		// do{
		// if (strPlayerNum != null){
		// System.out.println("You have entered an invalid number, please enter
		// a number between 1 and 3.\n");
		// }
		// System.out.println("How many players would like to play the game?
		// (max 3).");
		// strPlayerNum = scan.nextLine();
		// }
		// while(!strPlayerNum.matches("[1-3]"));
		//
		// System.out.format("You have selected %s player/s.%n", strPlayerNum);
		// numOfPlayers = Integer.parseInt(strPlayerNum);
	}

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

	public void createPlayers() {
		textCounter = 1;
		inputPanel.setVisible(false);
		creationPanel.setVisible(true);
		String currentPlayer;
		lblNamePrompt.setText(String.format("Player %d, what is your name?", textCounter));
		//
		// Player newPlayer = new Player(name);
		// addPlayer(newPlayer);

		btnCreationContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldCreation.grabFocus();
				if (players.keySet().contains(textFieldCreation.getText())) {
					JOptionPane.showMessageDialog(frame, "That name belongs to another player, please choose another.");

				} else if (textCounter >= numOfPlayers) {
					Player newPlayerFinal = new Player(textFieldCreation.getText());
					addPlayer(newPlayerFinal, textCounter);
					textFieldCreation.setText("");
					promptPetCreation();

				} else if (textCounter == 1) {
					Player newPlayer = new Player(textFieldCreation.getText());
					addPlayer(newPlayer, 1);
					textFieldCreation.setText("");
					lblNamePrompt.setText(String.format("Player %d, what is your name?", 2));
					textCounter++;
				} else if (textCounter == 2) {
					Player newPlayer2 = new Player(textFieldCreation.getText());
					addPlayer(newPlayer2, 2);
					textFieldCreation.setText("");
					lblNamePrompt.setText(String.format("Player %d, what is your name?", 3));
					;
					textCounter++;
				} else if (textCounter == 3) {
					Player newPlayer3 = new Player(textFieldCreation.getText());
					addPlayer(newPlayer3, 3);
					textFieldCreation.setText("");
					lblNamePrompt.setText(String.format("Player %d, what is your name?", 4));
					;
					textCounter++;
				} else if (textCounter == 4) {
					Player newPlayer4 = new Player(textFieldCreation.getText());
					addPlayer(newPlayer4, 4);
					textFieldCreation.setText("");
					promptPetCreation();
					textCounter = 1;
				}

			}
		});
	}

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

	public void existingNameChecker() {

	}

	public void promptPetCreation() {
		textCounter = 1;
		textFieldCreation.setEditable(false);
		lblNamePrompt
				.setText(String.format("%s, please select up to 3 Pets to own.", players.get(textCounter).getName()));
		List<Player> playerPets = new ArrayList<Player>();
		for (Map.Entry<Integer, Player> entry : players.entrySet()) {

		}
		btnPetCounter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textCounter > numOfPlayers) {
					System.out.println("next thing");

				} else if (boxCounter() > 3 || boxCounter() == 0) {
					JOptionPane.showMessageDialog(null, "You need to select 1-3 Pets for you to own!",
							"InfoBox: " + "Warning", JOptionPane.INFORMATION_MESSAGE);
				} else if (textCounter == 1) {
					createPet(players.get(textCounter));
					textCounter++;

				} else if (textCounter == 2) {
					textCounter++;

				} else if (textCounter == 3) {
					textCounter++;

				} else if (textCounter == 4) {

				}
			}
		});
		lblSelectUpTo.setVisible(true);
		txtPetName1.setVisible(true);
		txtPetName2.setVisible(true);
		txtPetName3.setVisible(true);
		txtPetName4.setVisible(true);
		txtPetName5.setVisible(true);
		txtPetName6.setVisible(true);
		btnPetCounter.setVisible(true);
		btnCreationContinue.setVisible(false);
		lblNewLabel.setVisible(true);
		lblNewLabel_1.setVisible(true);
		lblNewLabel_2.setVisible(true);
		lblBeng.setVisible(true);
		lblNewLabel_4.setVisible(true);
		lblNewLabel_5.setVisible(true);
		lblNewLabel6.setVisible(true);
		lblNewLabel.setVisible(true);
		lblNewLabel.setVisible(true);
		lblNewLabel.setVisible(true);
		lblNewLabel.setVisible(true);
		chckbxPet1.setVisible(true);
		chckbxPet2.setVisible(true);
		chckbxPet3.setVisible(true);
		chckbxPet4.setVisible(true);
		chckbxPet5.setVisible(true);
		chckbxPet6.setVisible(true);
		// textFieldCreation.setVisible(false);
		// btnCreationContinue.setVisible(false);
		// btnPetCounter.setVisible(true);
		// int textCounter = 1;
		// spinnerPetNum.setVisible(true);
		// lblNamePrompt.setText(String.format("%s, please choose up to 3 pets
		// to own", players.get(textCounter).getName()));

		// for (Map.Entry<Integer, Player> entry : players.entrySet()){
		// Player player = entry.getValue();
		// String strPetNum = null;
		// do{
		// if (strPetNum != null){
		// System.out.println("\nYou have entered an invalid number,"
		// + "please enter a number between 1 and 3.\n");
		// }
		// System.out.format("How many pets would %s like to own? (max 3).",
		// player.name);
		// strPetNum = scan.nextLine();
		// }
		// while(!strPetNum.matches("[1-3]"));
		//
		// System.out.format("You have selected %s pet/s.\n\n", strPetNum);
		// int intPetNum = Integer.parseInt(strPetNum);
		// promptSpecies(player, intPetNum);
		// }
	}

	public void store(Player player) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String itemSelect = null;
		storeHelper();
		System.out.println(player);
		System.out.println();

		do {
			if (itemSelect != null) {
				System.out.println("\nYou have entered an invalid number, please try again.\n");
			}
			System.out.format("%s, enter an item number to add it to your inventory.\n", player.getName());
			itemSelect = scan.nextLine();
		} while (!itemSelect.matches("[1-9]" + "[0-3]*"));
		int intItemSelect = Integer.parseInt(itemSelect);

		switch (intItemSelect) {
		case 1:
			if ((player.getBalance() - cookie.getPrice()) < 0) {
				System.out.println("You don't have enough money to make this purchase");
				promptEnterKey();

			} else {
				player.addFood(cookie);
				player.setBalance((player.getBalance() - cookie.getPrice()));
			}
			store(player);
			break;
		case 2:
			if ((player.getBalance() - melon.getPrice()) < 0) {
				System.out.println("You don't have enough money to make this purchase");
				promptEnterKey();
			} else {
				player.addFood(melon);
				player.setBalance((player.getBalance() - melon.getPrice()));
			}
			store(player);
			break;
		case 3:
			if ((player.getBalance() - fish.getPrice()) < 0) {
				System.out.println("You don't have enough money to make this purchase");
				promptEnterKey();
			} else {
				player.addFood(fish);
				player.setBalance((player.getBalance() - fish.getPrice()));
			}
			store(player);
			break;
		case 4:
			if ((player.getBalance() - chocolate.getPrice()) < 0) {
				System.out.println("You don't have enough money to make this purchase");
				promptEnterKey();
			} else {
				player.addFood(chocolate);
				player.setBalance((player.getBalance() - chocolate.getPrice()));
			}
			store(player);
			break;
		case 5:
			if ((player.getBalance() - cake.getPrice()) < 0) {
				System.out.println("You don't have enough money to make this purchase");
				promptEnterKey();
			} else {
				player.addFood(cake);
				player.setBalance((player.getBalance() - cake.getPrice()));
			}
			store(player);
			break;
		case 6:
			if ((player.getBalance() - pizza.getPrice()) < 0) {
				System.out.println("You don't have enough money to make this purchase");
				promptEnterKey();
			} else {
				player.addFood(pizza);
				player.setBalance((player.getBalance() - pizza.getPrice()));
			}
			store(player);
			break;
		case 7:
			if ((player.getBalance() - yoyo.getPrice()) < 0) {
				System.out.println("You don't have enough money to make this purchase");
				promptEnterKey();
			} else {
				// yoyo
				Toy newToy = new Toy(toyChoices.get(6));
				player.addToy(newToy);
				player.setBalance((player.getBalance() - yoyo.getPrice()));
			}
			store(player);
			break;
		case 8:
			// doll
			if ((player.getBalance() - doll.getPrice()) < 0) {
				System.out.println("You don't have enough money to make this purchase");
				promptEnterKey();
			} else {
				Toy newToy = new Toy(toyChoices.get(3));
				player.addToy(newToy);
				player.setBalance((player.getBalance() - doll.getPrice()));
			}
			store(player);
			break;
		case 9:
			// bear
			if ((player.getBalance() - bear.getPrice()) < 0) {
				System.out.println("You don't have enough money to make this purchase");
				promptEnterKey();
			} else {
				Toy newToy = new Toy(toyChoices.get(1));
				player.addToy(newToy);
				player.setBalance((player.getBalance() - bear.getPrice()));
			}
			store(player);
			break;
		case 10:
			// kite
			if ((player.getBalance() - kite.getPrice()) < 0) {
				System.out.println("You don't have enough money to make this purchase");
				promptEnterKey();
			} else {
				Toy newToy = new Toy(toyChoices.get(5));
				player.addToy(newToy);
				player.setBalance((player.getBalance() - kite.getPrice()));
			}
			store(player);
			break;
		case 11:
			// boat
			if ((player.getBalance() - boat.getPrice()) < 0) {
				System.out.println("You don't have enough money to make this purchase");
				promptEnterKey();
			} else {
				Toy newToy = new Toy(toyChoices.get(2));
				player.addToy(newToy);
				player.setBalance((player.getBalance() - boat.getPrice()));
			}
			store(player);
			break;
		case 12:
			// helicopter
			if ((player.getBalance() - heli.getPrice()) < 0) {
				System.out.println("You don't have enough money to make this purchase");
				promptEnterKey();
			} else {
				Toy newToy = new Toy(toyChoices.get(4));
				player.addToy(newToy);
				player.setBalance((player.getBalance() - heli.getPrice()));
			}
			store(player);
			break;
		case 13:
			mainSelectScreen(player);
			break;
		}
	}

	public void storeHelper() {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("config.properties");
			// load a properties file
			prop.load(input);
			// get the property value and print it out
			System.out.println(prop.getProperty("store"));
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public int score(Player player) {
		int score = 0;

		for (Map.Entry<String, Species> entry : player.getPets().entrySet()) {
			Species pet = entry.getValue();
			score += pet.getHealth();
		}
		return score;
	}

	public void endDay(Player player) {
		for (Map.Entry<String, Species> entry : player.getPets().entrySet()) {
			Species pet = entry.getValue();
			pet.endDay();
			//  			   return ("Your pet died from a random illness!");
			 //  return("If the pet has not died before, he can be revived from the doctor!");
			
//			   "%s is sick! This causes your pet to waste 1 action per day.", this.name +
//			   "Your pet can be treated at the doctor's (this will use an action).");
			
//			  return String.format("%s is misbehaving! This causes your pet to lose 1 action per day.", this.name +
//					  " Your pet can be punished (this will use an action).");
		}
	}

	public void toilet() {
		globalCurrentPet.toilet();
//		return String.format("%s feels relieved.", globalCurrentPet.getName());
	}

	public void sleep() {
//		return String.format("%s feels refreshed!\n", name);
		globalCurrentPet.sleep();
	}

	public void play(Player player) {
//		return String.format("%s is feeling happier!\n", name);
		Map<Integer, Toy> currentToys = new HashMap<Integer, Toy>();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String toySelect = null;
		int i = 1;
		if (player.getToys().isEmpty()) {
			System.out.println("You don't have any toys! Visit the store to buy some.");
			promptEnterKey();
		} else {
			for (Map.Entry<Toy, Integer> entry : player.getToys().entrySet()) {
				Toy toy = entry.getKey();
				currentToys.put(i, toy);
				int val = entry.getValue();
				System.out.format("\n%d(durability). %s(%s)", i, toy.getName(), toy.getDurability());
				i++;
			}
			System.out.format("\n\n%d. quit.", 7);
			do {
				if (toySelect != null) {
					System.out.println("\nYou have entered an invalid number\n");
					promptEnterKey();
				}
				System.out.format("\nSelect a toy to give to %s.", globalCurrentPet.getName());
				toySelect = scan.nextLine();
			} while (!toySelect.matches("[1-" + (i - 1) + "]?|[7]?"));
			int inttoySelect = Integer.parseInt(toySelect);

			switch (inttoySelect) {
			case 1:
				globalCurrentPet.play(currentToys.get(1));
				if (currentToys.get(1).getDurability() < 0) {
					player.removeToy(currentToys.get(1));
					System.out.format("Your %s broke!", currentToys.get(1).getName());
				}
				break;
			case 2:
				globalCurrentPet.play(currentToys.get(2));
				if (currentToys.get(2).getDurability() < 0) {
					player.removeToy(currentToys.get(2));
					System.out.format("Your %s broke!", currentToys.get(2).getName());
				}
				break;
			case 3:
				globalCurrentPet.play(currentToys.get(3));
				if (currentToys.get(3).getDurability() < 0) {
					player.removeToy(currentToys.get(3));
					System.out.format("Your %s broke!", currentToys.get(3).getName());
				}
				break;
			case 4:
				globalCurrentPet.play(currentToys.get(4));
				if (currentToys.get(4).getDurability() < 0) {
					player.removeToy(currentToys.get(4));
					System.out.format("Your %s broke!", currentToys.get(3).getName());
				}
				break;
			case 5:
				globalCurrentPet.play(currentToys.get(5));
				if (currentToys.get(5).getDurability() < 0) {
					player.removeToy(currentToys.get(5));
					System.out.format("Your %s broke!", currentToys.get(3).getName());
					break;
				}
			case 6:
				globalCurrentPet.play(currentToys.get(6));
				if (currentToys.get(5).getDurability() < 0) {
					player.removeToy(currentToys.get(6));
					System.out.format("Your %s broke!", currentToys.get(3).getName());
					break;
				}
			case 7:
				mainSelectScreen(player);
				break;
			}

		}
	}

	public void feedPet(Player player) {
//		System.out.format("*chomp..chomp..chomp* %s enjoyed the %s!\n", globalCurrentPet.getName(), currentFood.get(1).getName());
		Map<Integer, Food> currentFood = new HashMap<Integer, Food>();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String foodSelect = null;
		int i = 1;

		if (player.getFood().isEmpty()) {
			System.out.println("You don't have any food! Visit the store to buy some.");
			promptEnterKey();
		} else {
			for (Map.Entry<Food, Integer> entry : player.getFood().entrySet()) {
				Food food = entry.getKey();
				currentFood.put(i, food);
				int val = entry.getValue();
				System.out.format("\n%d. %s x%d", i, food.getName(), val);
				i++;
			}
			System.out.format("\n%d. quit.\n", i);

			do {
				if (foodSelect != null) {
					System.out.println("\nYou have entered an invalid number\n");
				}
				System.out.format("Select an item to feed to %s.\n", globalCurrentPet.getName());
				foodSelect = scan.nextLine();
			} while (!foodSelect.matches("[1-" + i + "]"));
			int intFoodSelect = Integer.parseInt(foodSelect);

			switch (intFoodSelect) {
			case 1:
				System.out.format("*chomp..chomp..chomp* %s enjoyed the %s!\n", globalCurrentPet.getName(), currentFood.get(1).getName());
				globalCurrentPet.feed(currentFood.get(1));
				player.removeFood(currentFood.get(1));
				break;
			case 2:
				System.out.format("*chomp..chomp..chomp* %s enjoyed the %s!\n", globalCurrentPet.getName(), currentFood.get(1).getName());
				globalCurrentPet.feed(currentFood.get(2));
				player.removeFood(currentFood.get(2));
				break;
			case 3:
				globalCurrentPet.feed(currentFood.get(3));
				player.removeFood(currentFood.get(3));
				break;
			case 4:
				globalCurrentPet.feed(currentFood.get(4));
				player.removeFood(currentFood.get(4));
				break;
			case 5:
				globalCurrentPet.feed(currentFood.get(5));
				player.removeFood(currentFood.get(5));
				break;
			case 6:
				globalCurrentPet.feed(currentFood.get(6));
				player.removeFood(currentFood.get(6));
				break;
			}
		}
	}
	public void feed(Player player, Food food){

	}

	public Species selectPet(Player player) {
		String inputChoice = null;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		Map<Integer, Species> petChoices = new HashMap<Integer, Species>();
		int i = 0;

		for (Species pet : player.getPets().values()) {
			i++;
			petChoices.put(i, pet);
		}
		do {
			i = 0;
			if (inputChoice != null) {
				System.out.println("\nYou have entered an invalid number\n");
				promptEnterKey();
			}
			for (Species pet : player.getPets().values()) {
				i++;
				System.out.format("%d: %s.\n", i, pet.getName());
				petChoices.put(i, pet);
			}
			System.out.println("\nSelect a pet to interact with.");
			inputChoice = scan.nextLine();
		} while (!inputChoice.matches("[1-" + i + "]"));

		int intInputChoice = Integer.parseInt(inputChoice);
		switch (intInputChoice) {
		case 1:
			return petChoices.get(1);
		case 2:
			return petChoices.get(2);
		case 3:
			return petChoices.get(3);
		}
		System.out.println("ERROR, CODE SHOULD NEVER BE REACHED");

		return crab;
	}

	public void promptStoreSection(Player player) {
		System.out.println("Welcome to the Pet Store!");
		System.out.println("Enter 1 to view the food items for sale");
		System.out.println("Enter 2 to view the food items for sale\n");
		System.out.println(player);
	}

	public void promptSpecies(Player player, int petNum) {
		for (int i = 1; i < (petNum + 1); i++) {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			printSpeciesInfo();
			String speciesNum = null;
			do {
				if (speciesNum != null) {
					System.out.println(
							"\nYou have entered an invalid number," + "please enter a number between 1 and 6.\n");
				}
				System.out.println("To choose, enter a number from 1-6...");
				System.out.format("%s, please choose a species for Pet no.%d\n", player.name, i);
				speciesNum = scan.nextLine();
			} while (!speciesNum.matches("[1-6]"));

			int species = 0;
			int intSpeciesNum = Integer.parseInt(speciesNum);
			switch (intSpeciesNum) {
			case 1:
				species = 1;
				break;
			case 2:
				species = 2;
				break;
			case 3:
				species = 3;
				break;
			case 4:
				species = 4;
				break;
			case 5:
				species = 5;
				break;
			case 6:
				species = 6;
				break;
			}
			// createPet(player, species);
		}
	}

	public void createPet(Player player) {
		// for (int i = 1; i < 6; i++) {
		// if (chckbxPet1.isSelected()) {
		// existingPetNames.add(txtPetName1.getText());
		// Species newPet = new Species(txtPetName1.getText(),
		// speciesChoices.get(1));
		// player.addPet(newPet);
		// }
		// if (chckbxPet2.isSelected()) {
		// existingPetNames.add(txtPetName2.getText());
		// Species newPet = new Species(txtPetName2.getText(),
		// speciesChoices.get(2));
		// player.addPet(newPet);
		// }
		// if (chckbxPet3.isSelected()) {
		// existingPetNames.add(txtPetName3.getText());
		// Species newPet = new Species(txtPetName3.getText(),
		// speciesChoices.get(3));
		// player.addPet(newPet);
		// }
		// if (chckbxPet4.isSelected()) {
		// existingPetNames.add(txtPetName4.getText());
		// Species newPet = new Species(txtPetName4.getText(),
		// speciesChoices.get(4));
		// player.addPet(newPet);
		// }
		// if (chckbxPet5.isSelected()) {
		// existingPetNames.add(txtPetName5.getText());
		// Species newPet = new Species(txtPetName5.getText(),
		// speciesChoices.get(5));
		// player.addPet(newPet);
		// }
		// if (chckbxPet6.isSelected()) {
		// existingPetNames.add(txtPetName6.getText());
		// Species newPet = new Species(txtPetName6.getText(),
		// speciesChoices.get(6));
		// player.addPet(newPet);
		//// }
		// }

		// @SuppressWarnings("resource")
		// Scanner scan = new Scanner(System.in);
		// System.out.format("Enter a name for your new %s.\n",
		// speciesChoices.get(species).getSpecies());
		// String petName = scan.nextLine();
		// while (existingPetNames.contains(petName)) {
		// System.out.println("Input error. That name belongs to another pet,
		// please choose another.\n");
		// System.out
		// .println(String.format("Enter a name for your new %s.",
		// speciesChoices.get(species).getSpecies()));
		// petName = scan.next();
		// }
		// existingPetNames.add(petName);
		// Species newPet = new Species(petName, speciesChoices.get(species));
		// player.addPet(newPet);
	}

	public void publicPetHelper(Player player) {

	}

	public void printSpeciesInfo() {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("config.properties");
			// load a properties file
			prop.load(input);
			// get the property value and print it out
			System.out.println(prop.getProperty("species1"));
			System.out.println(prop.getProperty("species2"));
			System.out.println(prop.getProperty("species3"));
			System.out.println(prop.getProperty("species4"));
			System.out.println(prop.getProperty("species5"));
			System.out.println(prop.getProperty("species6"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void promptEnterKey() {
		System.out.println("\nPress \"ENTER\" to continue...");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}

	public void printPlayers() {
		for (Map.Entry<Integer, Player> entry : players.entrySet()) {
			Player val = entry.getValue();
			System.out.println("\n" + val);
		}
	}

	public void printFood() {
		for (Map.Entry<Integer, Food> entry : foodChoices.entrySet()) {
			Food val = entry.getValue();
			System.out.println("\n" + val);
		}
	}

	public void printToys() {
		for (Map.Entry<Integer, Toy> entry : toyChoices.entrySet()) {
			Toy val = entry.getValue();
			System.out.println("\n" + val);
		}
	}

	public void printPets() {
		for (Map.Entry<Integer, Species> entry : speciesChoices.entrySet()) {
			Pet val = entry.getValue();
			System.out.println("\n" + val);
		}
	}

	public void addToy(String player, String toyName) {
		Toy toy = toyChoices.get(toyName);
		Player val = players.get(player);
		val.addToy(toy);
	}

	public void addPlayer(Player player, int i) {
		players.put(i, player);
	}

	public void addFood(String player, String foodName) {
		Food food = foodChoices.get(foodName);
		Player val = players.get(player);
		val.addFood(food);
	}

	public static void main(String[] args) {

		GUI newGame = new GUI();

		newGame.guiConstructor();
		newGame.frame.setVisible(true);
		newGame.gameStart();
		// newGame.inputPlayerNum();
		// newGame.inputDayNum();
		// newGame.createPlayers();
		// newGame.promptPetCreation();
		// newGame.mainScreenHelper();

		// EventQueue.invokeLater(new Runnable() {
		// public void run() {
		// try {
		// GUI window = new GUI();
		// window.frame.setVisible(true);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// });

	}
}
