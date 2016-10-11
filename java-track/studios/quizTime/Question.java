package quizTime;

public class Question {

	protected String question;
	protected boolean asked;
	protected boolean answeredCorrectly;
	
	public Question(String question) {
		this.question = question;
	}
	
	public String getQuestion() {
		return question;
	}

}
