package com.jap.oops;

import java.util.Scanner;

public class StudentManagementSystem {
	static void displayMenu(Scanner scanner, Student[] students, Course[] courses) {
		System.out.println("1 for: Enroll Students for the courses");
		System.out.println("2 for: View the Enrollments details of the students");
		System.out.println("3 for: Explore Course details");
		System.out.println("4 for: Exit");
		int choose= scanner.nextInt();
		System.out.println("Enter your choice: "+choose);
		int reChoose;
		for(int i=choose;i<5&&i>0;i=reChoose){
			switch (choose){
				case 1:
					enrollStudentInCourse(getStudent(scanner, students),getCourse(scanner,courses));
					break;
				case 2:
					viewStudentEnrollmentDetails(getStudent(scanner, students),students);
					break;
				case 3:
					viewEnrolledStudentsInCourse(getCourse(scanner, courses),courses);
					break;
				case 4:
					System.out.println("you are exited form the course.");
					break;
				default :
					System.out.println("please enter the valid number");
			}
			reChoose= scanner.nextInt();
		}
	}

	private static Student getStudent(Scanner scanner, Student[] students) {
		System.out.print("Enter student ID: ");
		int studentID = scanner.nextInt();

		// Iterate through the array of students to find the matching student
		for (Student student : students) {
			if (student != null && student.getStudentID() == studentID) {
				return student; // Return the student object if found
			}
		}

		// If no student with the given ID is found, display a message and return null
		System.out.println("Student with ID " + studentID + " not found.");
		return null;
	}

	private static Course getCourse(Scanner scanner, Course[] courses) {
		System.out.print("Enter course ID: ");
		int courseID = scanner.nextInt();

		// Iterate through the array of courses to find the matching course
		for (Course course : courses) {
			if (course != null && course.getCourseID() == courseID) {
				return course; // Return the course object if found
			}
		}

		// If no course with the given ID is found, display a message and return null
		System.out.println("Course with ID " + courseID + " not found.");
		return null;
	}

	public static boolean enrollStudentInCourse(Student selectedStudent, Course selectedCourse) {
		// Check if the selected student and course are not null
		if (selectedStudent != null && selectedCourse != null) {
			// Attempt to enroll the student in the course
			String enrollmentResult = selectedStudent.enrollInCourse(selectedCourse);

			// If the enrollment was successful, return true
			if (enrollmentResult != null && !enrollmentResult.isEmpty()) {
				System.out.println(enrollmentResult); // Optionally, print enrollment message
				return true;
			}
		}

		// If enrollment failed or selectedStudent/selectedCourse is null, return false
		return false;
	}

	public static String viewStudentEnrollmentDetails(Student selectedStudent, Student[] students) {
		if (selectedStudent != null) {
			StringBuilder enrollmentDetails = new StringBuilder();
			enrollmentDetails.append("\nView Enrollment Details:\n");
			enrollmentDetails.append("Enrollment Details for ").append(selectedStudent.getStudentName()).append(":\n");

			// Iterate through the enrolled courses of the selected student
			for (Course course : selectedStudent.getEnrolledCourses()) {
				if (course != null) {
					enrollmentDetails.append(course.getCourseDetails()).append("\n-----------------------\n");
				}
			}
			return enrollmentDetails.toString();
		}
		// If selectedStudent is null, return an empty string
		return "";
	}
	
	public static String viewEnrolledStudentsInCourse(Course selectedCourse, Course[] courses) {
		if (selectedCourse == null) {
			return "Invalid course.";
		}
		StringBuilder enrolledStudents = new StringBuilder("Students Enrolled in the course ").append(selectedCourse.getCourseName()).append(":\n");
		Student[] enrolledStudentsArray = selectedCourse.getEnrolledStudents();
		int count = 1;
		for (Student student : enrolledStudentsArray) {
			if (student != null) {
				enrolledStudents.append(count).append(".").append(student.getStudentName()).append("\n");
				count++;
			}
		}

		return enrolledStudents.toString();
	}
}