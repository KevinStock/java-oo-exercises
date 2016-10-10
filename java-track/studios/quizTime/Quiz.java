package quizTime;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Quiz {

	private JFrame quizFrame;
	private JTextField questionTxt;
	private JRadioButton rdbtnChoice1;
	private JRadioButton rdbtnChoice2;
	private JRadioButton rdbtnChoice3;
	private JRadioButton rdbtnChoice4;
	private JTextField answerTxt;
	private JPanel startPanel;
	private JPanel questionPanel;
	private JPanel answerPanel;
	private ArrayList<MultipleChoiceQuestion> questions;
	private int currentQuestionIndex;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quiz window = new Quiz();
					window.quizFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Quiz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		quizFrame = new JFrame();
		quizFrame.setTitle("Quiz Time!");
		quizFrame.setBounds(100, 100, 450, 300);
		quizFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		quizFrame.getContentPane().setLayout(new CardLayout(0, 0));
		
		final JPanel startPanel = new JPanel();
		quizFrame.getContentPane().add(startPanel, "name_126014186470050");
		startPanel.setLayout(null);
		startPanel.setVisible(true);
		
		final JPanel questionPanel = new JPanel();
		quizFrame.getContentPane().add(questionPanel, "name_126018314606866");
		questionPanel.setLayout(null);
		questionPanel.setVisible(false);
		
		final JPanel answerPanel = new JPanel();
		quizFrame.getContentPane().add(answerPanel, "name_126021047254383");
		answerPanel.setLayout(null);
		answerPanel.setVisible(false);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				questionPanel.setVisible(true);
				startPanel.setVisible(false);
				displayQuestion();
			}
		});
		btnStart.setBounds(164, 110, 117, 29);
		startPanel.add(btnStart);
		
		JLabel lblQuizTime = new JLabel("Quiz Time!");
		lblQuizTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuizTime.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		lblQuizTime.setBounds(6, 56, 438, 42);
		startPanel.add(lblQuizTime);
		
		questionTxt = new JTextField();
		questionTxt.setBackground(Color.LIGHT_GRAY);
		questionTxt.setEditable(false);
		questionTxt.setBounds(6, 6, 438, 68);
		questionPanel.add(questionTxt);
		questionTxt.setColumns(10);
		
		final ButtonGroup choiceGroup = new ButtonGroup();
		rdbtnChoice1 = new JRadioButton("New radio button");
		rdbtnChoice1.setBounds(6, 96, 141, 23);
		choiceGroup.add(rdbtnChoice1);
		questionPanel.add(rdbtnChoice1);
		
		rdbtnChoice2 = new JRadioButton("New radio button");
		rdbtnChoice2.setBounds(6, 131, 141, 23);
		choiceGroup.add(rdbtnChoice2);
		questionPanel.add(rdbtnChoice2);
		
		rdbtnChoice3 = new JRadioButton("New radio button");
		rdbtnChoice3.setBounds(240, 96, 141, 23);
		choiceGroup.add(rdbtnChoice3);
		questionPanel.add(rdbtnChoice3);
		
		rdbtnChoice4 = new JRadioButton("New radio button");
		rdbtnChoice4.setBounds(240, 131, 141, 23);
		choiceGroup.add(rdbtnChoice4);
		questionPanel.add(rdbtnChoice4);
		
		JButton btnSubmitAnswer = new JButton("Submit Answer");
		btnSubmitAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answerPanel.setVisible(true);
				questionPanel.setVisible(false);
				choiceGroup.getSelection();
			}
		});
		btnSubmitAnswer.setBounds(148, 205, 127, 29);
		questionPanel.add(btnSubmitAnswer);
		
		answerTxt = new JTextField();
		answerTxt.setEditable(false);
		answerTxt.setBackground(Color.LIGHT_GRAY);
		answerTxt.setBounds(6, 6, 438, 84);
		answerPanel.add(answerTxt);
		answerTxt.setColumns(10);
		
		JButton btnNextQuestion = new JButton("Next Question");
		btnNextQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answerPanel.setVisible(false);
				questionPanel.setVisible(true);
			}
		});
		btnNextQuestion.setBounds(170, 212, 117, 29);
		answerPanel.add(btnNextQuestion);
		
		createQuestions();
	}
	
	private void createQuestions() {
		questions = new ArrayList<MultipleChoiceQuestion>();
		MultipleChoiceQuestion q1 = new MultipleChoiceQuestion("What is the air-speed velocity of an unladen swallow?",
																new String[] {"12", "24", "African or European", "2"},
																3);
		MultipleChoiceQuestion q2 = new MultipleChoiceQuestion("What is your name?",
																new String[] {"John", "Henry", "George", "Sir Lancelot of Camelot"},
																4);
		questions.add(q1);
		questions.add(q2);	
	}
	
	private MultipleChoiceQuestion pickQuestion() {
		int qIndex = (int)(Math.random() * questions.size());
		currentQuestionIndex = qIndex;
		return questions.get(qIndex);
	}
	
	private void displayQuestion() {
		MultipleChoiceQuestion q = pickQuestion();
		questionTxt.setText(q.question);
		String[] choices = q.getChoices();
		rdbtnChoice1.setText(choices[0]);
		rdbtnChoice2.setText(choices[1]);
		rdbtnChoice3.setText(choices[2]);
		rdbtnChoice4.setText(choices[3]);
	}
	
	private boolean checkAnswer() {
		
		return true;
	}
}
