package com.jap.oops;

import java.util.Arrays;

public class Student {
	//declare the attributes enrolledCoursesCount,studentID,studentName,enrolledCourses
	private int enrolledCoursesCount=0,studentID;
	private String studentName;
	private Course[] enrolledCourses;

	// generate the Constructor with studentId and studentName
	public Student(int studentId, String studentName) {
		this.studentID=studentId;
		this.studentName=studentName;
		this.enrolledCourses= new Course[5];
	}

	//generate the getter and setter
	public int getEnrolledCoursesCount() {
		return enrolledCoursesCount;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Course[] getEnrolledCourses() {
		return enrolledCourses;
	}
//	public String enrollInCourse(Course course) {
//		if (!isEnrolled(course)) {
//			if (enrolledCoursesCount < 5) {
//				enrolledCourses[enrolledCoursesCount] = course;
//				enrolledCoursesCount++;
//				StringBuilder enrolledCoursesList = new StringBuilder();
//				enrolledCoursesList.append(getStudentName()).append(" has been enrolled in");
//				for (int i = 0; i < enrolledCoursesCount; i++) {
//					enrolledCoursesList.append(" ").append(enrolledCourses[i].getCourseName());
//				}
//				return enrolledCoursesList.toString();
//			} else {
//				return getStudentName() + " has enrolled for maximum courses";
//			}
//		} else {
//			return getStudentName() + " is already enrolled in " + course.getCourseName();
//		}
//	}
public String enrollInCourse(Course course) {
	if (isEnrolled(course)) {
		return studentName + " is already enrolled in " + course.getCourseName();
	} else if (enrolledCoursesCount >= 5) {
		return studentName + " has enrolled for maximum courses";
	} else {
		enrolledCourses[enrolledCoursesCount++] = course;
		return studentName + " has been enrolled in " + course.getCourseName();
	}
}
	// Check if already enrolled in a course
	public boolean isEnrolled (Course course){
		for (Course enrolledCourse : enrolledCourses) {
			if (enrolledCourse != null && enrolledCourse.getCourseID() == course.getCourseID()) {
				return true;
			}
		}
		return false;

	}


	@Override
	public String toString() {
		return "Student{" +
				"enrolledCoursesCount=" + enrolledCoursesCount +
				", studentID=" + studentID +
				", studentName='" + studentName + '\'' +
				", enrolledCourses=" + Arrays.toString(enrolledCourses) +
				'}';
	}
}
