package robots;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RobotMenu2 {

	private JFrame frmRobotMenu;
	private DefaultListModel<Robot> listModel;
	private JList<Robot> robotList;
	private JButton btnMoveRobot;
	private JButton btnRotateRobot;
	private JButton btnComputeDistance;
	private JButton btnDeleteRobot;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RobotMenu2 window = new RobotMenu2();
					window.frmRobotMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RobotMenu2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRobotMenu = new JFrame();
		frmRobotMenu.setTitle("Robot Menu");
		frmRobotMenu.setBounds(100, 100, 500, 200);
		frmRobotMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRobotMenu.getContentPane().setLayout(null);
		
		listModel = new DefaultListModel<Robot>();
		robotList = new JList<Robot>(listModel);
		robotList.setBounds(168, 6, 326, 166);
		frmRobotMenu.getContentPane().add(robotList);
		
		// initialize with 2 already created robots
		Robot robot1 = new Robot("Kevin", new int[] {3, 3}, 2, 'N');
		Robot robot2 = new Robot("Joel", new int[] {6, 8}, 3, 'E');
		listModel.add(listModel.size(), robot1);
		listModel.add(listModel.size(), robot2);
		
		// create a new robot
		JButton btnCreateRobot = new JButton("Create a Robot");
		btnCreateRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = (String)JOptionPane.showInputDialog(
						frmRobotMenu,
						"What is the robot's name?",
						"Robot Name Dialog", JOptionPane.PLAIN_MESSAGE,
						null,
						null,
						"");
				int posX = getPositiveValue("What is the robot's starting X Position?",
											"Robot X Position Dialog");
				int posY = getPositiveValue("What is the robot's starting Y Position?",
											"Robot Y Position Dialog");
				int speed = getPositiveValue("What is the robot's speed?",
											 "Robot Speed Dialog");
				char orientation = getOrientation("What is the robot's orientation? (N, E, S, W)",
												  "Robot's Orientation Dialog");
				Robot robot = new Robot(name, new int[] {posX, posY}, speed, orientation);
				listModel.add(listModel.size(), robot);
				btnUpdate();
			}
		});
		btnCreateRobot.setBounds(6, 6, 150, 30);
		frmRobotMenu.getContentPane().add(btnCreateRobot);
		
		// move an existing robot
		btnMoveRobot = new JButton("Move Robot");
		btnMoveRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected = robotList.getSelectedIndex();
				if (selected >= 0) {
					listModel.get(selected).moveRobot();	
				}
				else {
					JOptionPane.showMessageDialog(
							frmRobotMenu,
							"Please select a robot.",
							"Selection Error", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnMoveRobot.setBounds(6, 33, 150, 30);
		frmRobotMenu.getContentPane().add(btnMoveRobot);
		
		
		// rotate an existing robot
		btnRotateRobot = new JButton("Rotate Robot");
		btnRotateRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected = robotList.getSelectedIndex();
				if (selected >= 0) {
					listModel.get(selected).rotate();
				}
				else {
					JOptionPane.showMessageDialog(
							frmRobotMenu,
							"Please select a robot.",
							"Selection Error", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnRotateRobot.setBounds(6, 59, 150, 30);
		frmRobotMenu.getContentPane().add(btnRotateRobot);
		
		// compute the distance between two robots
		btnComputeDistance = new JButton("Compute Distance");
		btnComputeDistance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] selected = robotList.getSelectedIndices();
				if (selected.length == 2) {
					Robot r1 = listModel.get(selected[0]);
					Robot r2 = listModel.get(selected[1]);
					double distance = r1.getDistance(r2);
					JOptionPane.showMessageDialog(
							frmRobotMenu,
							(r1.name + " is " + distance + " from " + r2.name),
							"Distance", JOptionPane.PLAIN_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(
							frmRobotMenu,
							"Please select 2 robots to compute the distance.",
							"Selection Error", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnComputeDistance.setBounds(6, 85, 150, 30);
		frmRobotMenu.getContentPane().add(btnComputeDistance);
		
		// delete existing robots
		btnDeleteRobot = new JButton("Delete Robot");
		btnDeleteRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] selected = robotList.getSelectedIndices();
				for (int i = 0; i < selected.length; i++) {
					//robotList.remove(selected[i]);
					listModel.remove(selected[i]);
				}
				btnUpdate();
			}
		});
		btnDeleteRobot.setBounds(6, 127, 150, 30);
		frmRobotMenu.getContentPane().add(btnDeleteRobot);
		
		btnUpdate();
	}

	// get a positive integer from the user
	private int getPositiveValue(String prompt, String title) {
		String s = (String)JOptionPane.showInputDialog(
				frmRobotMenu,
				prompt,
				title, JOptionPane.PLAIN_MESSAGE,
				null,
				null,
				"");
		int sint = Integer.parseInt(s);
		while (sint < 0) {
			s = (String)JOptionPane.showInputDialog(
					frmRobotMenu,
					prompt + "\nPlease provide a positive integer.",
					title, JOptionPane.PLAIN_MESSAGE,
					null,
					null,
					"");
			sint = Integer.parseInt(s);
		}
		return sint;
	}
	
	// get a valid orientation from the user
	private char getOrientation(String prompt, String title) {
		String s = (String)JOptionPane.showInputDialog(
				frmRobotMenu,
				"What is the robot's orientation? (N, E, S, W)",
				"Robot's Orientation Dialog", JOptionPane.PLAIN_MESSAGE,
				null,
				null,
				"");
		char orientation = s.charAt(0);
		String expectedChars = ("NESW");
		while (expectedChars.indexOf(orientation) < 0) {
			s = (String)JOptionPane.showInputDialog(
					frmRobotMenu,
					"What is the robot's orientation? (N, E, S, W)\nPlease provide a valid orientation.",
					"Robot's Orientation Dialog", JOptionPane.PLAIN_MESSAGE,
					null,
					null,
					"");
			orientation = s.charAt(0);
		}
		return orientation;
	}

	// udpates btn status as appropriate
	private void btnUpdate() {
		if (listModel.size() > 0) {
			btnMoveRobot.setEnabled(true);
			btnRotateRobot.setEnabled(true);
			if (listModel.size() > 1) {
				btnComputeDistance.setEnabled(true);
			}
			else {
				btnComputeDistance.setEnabled(false);
			}
			btnDeleteRobot.setEnabled(true);
		}
		else {
			btnMoveRobot.setEnabled(false);
			btnRotateRobot.setEnabled(false);
		}
	}
	
}
