import java.util.Objects;

public class Student {

	// Properties of Student
	private String firstName;
	private String lastName;
	private int studentID;
	private int credits = 0;
	private double qualityScore = 0.0;
	private double gpa = 0.0;
	
	// Student Constructor for basic student
	public Student(String firstName, String lastName, int studentID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentID = studentID;
	}
	
	// Student Constructor for legacy Student
	public Student(String firstName, String lastName, int studentID, int credits, double gpa) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentID = studentID;
		this.credits = credits;
		this.gpa = gpa;
	}
	
	// get full name of student
	public String getName() {
		return firstName + " " + lastName;
	}
	
	// get id of student
	public int getStudentID() {
		return studentID;
	}
	
	// get credits for student
	public int getCredits() {
		return credits;
	}
	
	// get GPA for student
	public double getGPA() {
		return gpa;
	}
	
	// get class standing for student
	public String getClassStanding() {
		// less than 30 credits is a freshman
		if (this.getCredits() < 30) {
			return "Freshman";
		}
		// 30 - 60 credits is a sophomore
		else if (this.getCredits() >= 30 && credits < 60) {
			return "Sophomore";
		}
		// 60 - 90 credits is a junior
		else if (this.getCredits() >= 60 && credits < 90) {
			return "Junior";
		}
		// 90 or more credits is a senior
		else if (this.getCredits() >= 90) {
			return "Senior";
		}
		return "Error";
	}
	
	// submit a student's grade
	public void submitGrade(double grade, int credits) {
		this.credits += credits;
		qualityScore += (double)credits * grade;
		gpa = (double)Math.round((qualityScore / this.credits) * 1000) / 1000;
	}
	
	// compute tuition based on credits
	public double computeTuition() {
		double tuitionPaid = 0.0;
		int remainingCredits = credits;
		while (remainingCredits > 0) {
			if (remainingCredits > 14) {
				tuitionPaid += 20000.0;
				remainingCredits -= 15;
			}
			else {
				tuitionPaid += 1333.33 * remainingCredits;
				remainingCredits = 0;
			}
		}
		return tuitionPaid;
	}
	
	// create a legacy student
	public static Student createLegacy(Student parent1, Student parent2) {
		String firstName = parent1.getName();
		String lastName = parent2.getName();
		int studentID = parent1.getStudentID() + parent2.getStudentID();
		double gpa = (parent1.getGPA() + parent2.getGPA()) / 2;
		int credits = Math.max(parent1.getCredits(), parent2.getCredits());
		
		return new Student(firstName, lastName, studentID, credits, gpa);
	}

	@Override
	public boolean equals(Object o) {
		
		if (this == o)
			return true;
		
		if (o == null)
			return false;
		
		if (getClass() != o.getClass())
			return false;
		
		Student s = (Student) o;
		
		return Objects.equals(firstName + " " + lastName, s.getName()) 
				&& getStudentID() == s.getStudentID();
	}
	
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName +
				", studentID=" + studentID + ", credits=" + credits + ", qualityScore=" + 
				qualityScore + ", gpa=" + gpa + "]";
	}
	
	public static void main(String[] args) {
		// construct a new student
		Student s = new Student("D", "S", 1);
		// submit 45 grades for student
		for (int i = 0; i < 45; i++) {
			s.submitGrade(0, 1);
			System.out.println(s);
			// print tuition paid by student
			System.out.println(s.computeTuition());
		}
	}
}
