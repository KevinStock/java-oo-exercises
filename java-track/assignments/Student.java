
public class Student {

	private String firstName;
	private String lastName;
	private int studentID;
	private int credits = 0;
	private double qualityScore = 0.0;
	private double gpa = 0.0;
	
	public Student(String firstName, String lastName, int studentID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentID = studentID;
	}
	
	public Student(String firstName, String lastName, int studentID, int credits, double gpa) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentID = studentID;
		this.credits = credits;
		this.gpa = gpa;
	}
	
	public String getName() {
		return firstName + " " + lastName;
	}
	
	public int getStudentID() {
		return studentID;
	}
	
	public int getCredits() {
		return credits;
	}
	
	public double getGPA() {
		return gpa;
	}
	
	public String getClassStanding() {
		if (credits < 30) {
			return "Freshman";
		}
		else if (credits >= 30 && credits < 60) {
			return "Sophomore";
		}
		else if (credits >= 60 && credits < 90) {
			return "Junior";
		}
		else if (credits >= 90) {
			return "Senior";
		}
		return "";
	}
	
	public void submitGrade(double grade, int credits) {
		this.credits += credits;
		qualityScore += (double)credits * grade;
		gpa = (double)Math.round((qualityScore / this.credits) * 1000) / 1000;
	}
	
	public double computeTuition() {
		double tuitionPaid = 20000.0;
		int remainingCredits = credits;

		while (remainingCredits > 15) {
			tuitionPaid += 20000.0;
			remainingCredits -= 15;
		}

		return tuitionPaid;
	}
	
	public Student createLegacy(Student ss) {
		String firstName = this.getName();
		String lastName = ss.getName();
		int studentID = this.getStudentID() + ss.getStudentID();
		double gpa = (this.getGPA() + ss.getGPA()) / 2;
		int credits = Math.max(this.getCredits(), ss.getCredits());
		
		return new Student(firstName, lastName, studentID, credits, gpa);
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", studentID=" + studentID + ", credits="
				+ credits + ", qualityScore=" + qualityScore + ", gpa=" + gpa + "]";
	}
	
	public static void main(String[] args) {
		Student s = new Student("D", "S", 1);
		for (int i = 0; i < 45; i++) {
			s.submitGrade(0, 1);
			System.out.println(s);
			System.out.println(s.computeTuition());
		}
	}
}
