package com.jap.oops;

public class ProgrammingCourse extends Course {

	//declare the attributes
	private String programmingLanguage;
	// Constructor
	public ProgrammingCourse(int courseId, String courseName, String programmingLanguage) {
		super(courseId, courseName);
		this.programmingLanguage=programmingLanguage;
	}

	// Getter and setter for calculusRequired

	public String getProgrammingLanguage() {
		return programmingLanguage;
	}

	public void setProgrammingLanguage(String programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}

	// Override getCourseDetails method to provide math course details
	@Override
	public String getCourseDetails() {
		return "Programming Course Details:\n" +"Course ID: " +getCourseID() + "\n"
				+ "Course Name: " +getCourseName() + "\n"
				+"Programming Language: "+ getProgrammingLanguage();
	}
}
