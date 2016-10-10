package quizTime;

public class FillInTheBlankQuestion extends Question {

	private String answer;
	
	public FillInTheBlankQuestion(String question, String answer) {
		super(question);
		this.answer = answer;
	}
	
	public String getAnswer() {
		return answer;
	}
}
