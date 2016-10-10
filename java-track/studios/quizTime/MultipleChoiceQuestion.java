package quizTime;

public class MultipleChoiceQuestion extends Question {

	private String[] choices;
	private int answer;
	
	public MultipleChoiceQuestion(String question, String[] choices, int answer) {
		super(question);
		this.choices = choices;
		this.answer = answer;
	}
	
	public String[] getChoices() {
		return choices;
	}
	
	public int getAnswer() {
		return answer;
	}
	
}
