package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Counter {

	private JFrame frmCounter;
	private JTextField tfCount;
	private int count = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Counter window = new Counter();
					window.frmCounter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Counter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCounter = new JFrame();
		frmCounter.setTitle("Counter");
		frmCounter.setBounds(100, 100, 450, 135);
		frmCounter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCounter.getContentPane().setLayout(null);
		
		JLabel lblCounter = new JLabel("Counter");
		lblCounter.setBounds(36, 35, 61, 16);
		frmCounter.getContentPane().add(lblCounter);
		
		tfCount = new JTextField("0");
		tfCount.setBackground(Color.LIGHT_GRAY);
		tfCount.setEditable(false);
		tfCount.setHorizontalAlignment(SwingConstants.CENTER);
		tfCount.setBounds(119, 30, 130, 26);
		frmCounter.getContentPane().add(tfCount);
		tfCount.setColumns(10);
		
		JButton btnCount = new JButton("Count");
		btnCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				tfCount.setText(count + "");
			}
		});
		btnCount.setBounds(259, 30, 117, 29);
		frmCounter.getContentPane().add(btnCount);
	}
}
