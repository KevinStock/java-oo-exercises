
public class Course {

	// Properties
	private String name;
	private int credits;
	private int seats;
	//private int remainingSeats;
	private Student[] roster;
	
	// Constructor
	public Course(String name, int credits, int seats) {
		this.name = name;
		this.credits = credits;
		this.seats = seats;
		roster = new Student[seats];
	}
	
	// get course name and return it
	public String getName() {
		return name;
	}
	
	// calculate unfilled seats for course and return it
	public int getRemainingSeats() {
		//return remainingSeats;
		int seatsTaken = 0;
		// iterate through the roster looking for filled seats
		for (int i = 0; i < roster.length; i++) {
			if (roster[i] != null) {
				seatsTaken++;
			}
		}
		return seats - seatsTaken;
	}
	
	// add a student to a course
	public boolean addStudent(Student s) {
		// check if student is already enrolled
		for (int i = 0; i < roster.length; i++) {
			if (roster[i] != null) {
				if (roster[i].getName().equals(s.getName()))
				return false;
			}
		}
		// check if there is a seat available and if so add the student
		if (getRemainingSeats() > 0) {
			roster[seats - getRemainingSeats()] = s;
			//remainingSeats--;
			return true;
		}
		else {
			return false;	
		}
	}
	
	// calculate the average GPA for all students enrolled in course
	public double averageGPA() {
		double totalGPA = 0.0;
		// iterate through all students in the roster
		for (int i = 0; i < roster.length; i++) {
			if (roster[i] != null) {
				totalGPA += roster[i].getGPA();
			}
		}
		return totalGPA / (seats - getRemainingSeats());
	}
	
	@Override
	public String toString() {
		return "Course Name: " + name + "\nCredits: " + credits;
	}

	public static void main(String[] args) {
		// construct a course with 3 seats for 3 credits
		Course c = new Course("Test Course", 3, 3);
		// construct students
		Student s = new Student("Kevin", "Stock", 1);
		Student s2 = new Student("John", "Smith", 2);
		// add student to course
		c.addStudent(s);
		c.addStudent(s2);
		// print out roster
		for (int i = 0; i < c.roster.length; i++) {
			if (c.roster[i] != null) {
				System.out.println(c.roster[i].getName());
			}
		}
		// print out course information
		System.out.println("\n" + c);
	}

}
