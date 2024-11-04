package com.jap.oops;

import java.util.Arrays;

public abstract class Course {
	//declare the attributes courseID,courseName,enrolledStudents,enrolledStudentsCount
	private int courseID,enrolledStudentCount;
	private String courseName;
	int maxStudents;
	private Student[]enrolledStudents;
	// Constructor that accepts only courseId and courseName
	public Course(int courseId, String courseName){
		this.courseID=courseId;
		this.courseName=courseName;
		maxStudents=10;
		this.enrolledStudents=new Student[maxStudents];
		this.enrolledStudentCount=0;
	}
	// Assuming a maximum of 10 enrolled students initially

	// Getter and Setter Methods

	public int getEnrolledStudentCount() {
		return enrolledStudentCount;
	}

	public void setEnrolledStudentCount(int enrolledStudentCount) {
		this.enrolledStudentCount = enrolledStudentCount;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Student[] getEnrolledStudents() {
		return enrolledStudents;
	}

	public void setEnrolledStudents(Student[] enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}

	public String addStudent(Student student) {
		if(enrolledStudentCount >= maxStudents) {
			return "Maximum students enrolled. Cannot add more students.";
		}
		if(isEnrolled(student)) {
			return student.getStudentName() + " has already been added to the course: " + courseName;
		}
		this.enrolledStudents[enrolledStudentCount] = student;
		student.enrollInCourse(this);
		enrolledStudentCount++;

		return student.getStudentName() + " has been added to the course: " + courseName;
	}
	public boolean isEnrolled(Student student) {
		for (Student enrolledStudent : enrolledStudents) {
			if (enrolledStudent != null && enrolledStudent.equals(student.getStudentName())) {
				return true;
			}
		}
		return false;
	}

	// Method to view enrolled students in the course
	public String viewEnrolledStudents() {
		StringBuilder enrolledStudentsList = new StringBuilder();
		enrolledStudentsList.append("Students Enrolled in the course ").append(getCourseName()).append(":\n");

		for (int i = 0; i < enrolledStudentCount; i++) {
			enrolledStudentsList.append(i + 1).append(".").append(enrolledStudents[i]).append("\n");
		}

		return enrolledStudentsList.toString();
	}

	// Abstract method to get specific course details (to be implemented by derived classes)
	public abstract String getCourseDetails();
}
