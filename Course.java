package datastructure_hw1;

import java.util.ArrayList;
import java.util.Scanner;

public class Course {
	String course_name = null;
	String room = null;
	String course_number = null;
	int number_of_students_registered = 0;
	String meeting_time = null;
	String instructor_netID = null;
	boolean isFull = false;
	
	ArrayList<String> students_enrolled = new ArrayList<String>();
	public static ArrayList<Course> listofCourses = new ArrayList<Course>();
	
	public Course(String course_name, String netID, String room){
		this.course_name = course_name;
		this.instructor_netID = netID;
		this.room = room;
		
		for (int i = 0; i < Professor.professorList.size(); i++) {
            if (Professor.professorList.get(i).getUsername().equals(netID)) {
            	Professor.professorList.get(i).course_taught.add(course_name);
            	break;
            } else {
            	System.out.println("Sorry, your username does not exist.");
            }
        }
	}
	
	
	
	//check full, if a class has 2 students, it is full...
	public boolean checkFull(String course_name) {
		
		for (int i = 0; i < listofCourses.size(); i++) {
			if (course_name.equals(listofCourses.get(i).course_name)){
				
				if (number_of_students_registered == 2){
					isFull = true;		
				} else {
					isFull = false;
				}	
			}	
		}
		return isFull;	
	}

	public static void display_all_courses() {
		
		// display all courses
		System.out.println("All Courses:");
		for (int i = 0; i < listofCourses.size(); i++) {
            System.out.println(listofCourses.get(i).course_name);
        }
	}
	
	//**************************FULL*****************************
	public static void display_fullCourses() {
		System.out.println("Full Courses: ");
		for (int i = 0; i < listofCourses.size(); i++) {
			listofCourses.get(i).checkFull(listofCourses.get(i).course_name);
			if (listofCourses.get(i).isFull == true) {
				System.out.println(listofCourses.get(i).course_name);
			}
		}	
	}
	
	//************************REMOVE***********************
		public static void remove_a_course() {
			Scanner reader_admin = new Scanner(System.in);  
	        System.out.println("Course Name: ");
	        String course_name = reader_admin.next();
			for (int i = 0; i < listofCourses.size(); i++) {
				if (course_name.equals(listofCourses.get(i).course_name)) {
					listofCourses.remove(i);
					break;
				}
			}
			System.out.println("successfully removed "+ course_name);
		}
}
