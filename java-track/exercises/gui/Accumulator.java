package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;

public class Accumulator extends Frame implements ActionListener {

	private JFrame frmAccumulator;
	private JTextField tfInput;
	private JTextField tfOutput;
	private int sum = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accumulator window = new Accumulator();
					window.frmAccumulator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Accumulator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAccumulator = new JFrame();
		frmAccumulator.setTitle("Accumulator");
		frmAccumulator.setBounds(100, 100, 350, 120);
		frmAccumulator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccumulator.getContentPane().setLayout(null);
		
		JLabel lblInput = new JLabel("Enter an integer");
		lblInput.setBounds(31, 24, 105, 16);
		frmAccumulator.getContentPane().add(lblInput);
		
		tfInput = new JTextField();
		tfInput.setBounds(140, 19, 130, 26);
		frmAccumulator.getContentPane().add(tfInput);
		tfInput.setColumns(10);
		
		tfInput.addActionListener(this);
		
		JLabel lblOutput = new JLabel("Accumulated sum is");
		lblOutput.setBounds(6, 48, 130, 16);
		frmAccumulator.getContentPane().add(lblOutput);
		
		tfOutput = new JTextField();
		tfOutput.setBackground(Color.LIGHT_GRAY);
		tfOutput.setEditable(false);
		tfOutput.setBounds(140, 43, 130, 26);
		frmAccumulator.getContentPane().add(tfOutput);
		tfOutput.setColumns(10);
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		int numberIn = Integer.parseInt(tfInput.getText());
		sum += numberIn;
		tfInput.setText("");
		tfOutput.setText(sum + "");
	}

}
