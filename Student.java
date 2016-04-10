package datastructure_hw1;

import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User implements Changable, Logable {
	
	String student_number = null;
	int SSN;
	String name = "you have not his/her entered yet";
	String address = null;
	String date_of_birth = null;
	int phone_number;
	String major = null;
	float gpa;
	public ArrayList<String> course_taking = new ArrayList<String>();
	public static ArrayList<Student> studentList = MainClass.studentList;
	
	public Student(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}
	
	

	// **************************PASSWORD CHECK*********************************************
	@Override
	public String findPassword(String username, ArrayList<?> mylist) {
		// find the password given a username
		String actual_password = null;
		for (int i = 0; i < mylist.size(); i++) {
            
            if (((Student) mylist.get(i)).getUsername().equals(username)) {
            	actual_password = ((Student)mylist.get(i)).getPassword();
            	break;
            }
        }
		return actual_password;
	}

	@Override
	public String requestPassword() {
		// input password
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		
		System.out.println("Enter your password: ");

		String user_password = reader.nextLine(); // Scans the next token of the input
	
		
		return user_password;
	}

	@Override
	public boolean comparePassword(String user_password, String actual_password) {
		// compare 
		if (user_password.equals(actual_password)) {
			System.out.println("Welcome, Student");
		} else {
			System.out.println("Wrong Password, please try again");
			String newPassword = requestPassword();
			comparePassword(newPassword, actual_password);
		}
		return true;

	}
	
	//************************************Login**********************************
	public int loginStudent(String username, ArrayList<Student> studentlist){
		int next = 0;
		String actual_password = findPassword(username, studentlist);
		String input_password = requestPassword();
		boolean isCorrect = comparePassword(input_password, actual_password);
		while (isCorrect == false) {
			System.out.println("Wrong Password. Please try again");
			input_password = requestPassword();
			isCorrect = comparePassword(input_password, actual_password);
		}
		int choice_student = student_interface1();
        next = student_interface1_specific(choice_student);
        // next = 21 or 0
        return next;
	}

	
	//***********************************CHANGE***********************************
	@Override
	public boolean change_password() {
		Scanner reader_admin = new Scanner(System.in);  
        System.out.println("netID: ");
		String username = reader_admin.next();
		for (int i = 0; i < studentList.size(); i++) {
			if (username.equals(studentList.get(i).getUsername()) ) {
				System.out.println("old password: ");
				String old_password = reader_admin.next();
				if (old_password.equals(studentList.get(i).getPassword())){
					System.out.println("Please enter new password: ");
					String temp_password = reader_admin.next();
					System.out.println("Please enter new password again: ");
					String second_time_password = reader_admin.next();
					if (temp_password.equals(second_time_password)) {
						studentList.get(i).setPassword(temp_password);
						System.out.println("Success");
					} else {
						System.out.println("Password does not match, please start over");
						change_password();
					}
				}
			}
		}
		
		return true;
		
		
	}


	@Override
	public void change_username() {
		Scanner reader_admin = new Scanner(System.in);  
        System.out.println("netID: ");
		String username = reader_admin.next();
		for (int i = 0; i < studentList.size(); i++) {
			if (username.equals(studentList.get(i).getUsername())) {
				System.out.println("password: ");
				String password = reader_admin.next();
				if (password.equals(studentList.get(i).getPassword())){
					System.out.println("Please enter new username: ");
					String new_username = reader_admin.next();
					studentList.get(i).setUsername(new_username);
					System.out.println("Success");
				}
			}
		}
		
	}
	
	
	//*******************************************Student Menu********************************
	public int student_interface1(){
		System.out.println("1. View All Courses");
        System.out.println("2. View Registered Courses");
        System.out.println("3. Change Password");
        System.out.println("4. Change Username");
        System.out.println("5. Add Courses");
        System.out.println("6. Remove Courses");

        Scanner reader_admin = new Scanner(System.in);  
        System.out.println("Select your choice of number: ");
		int choice = reader_admin.nextInt();
	
		while (choice != 1 && choice != 2 && choice !=3 && choice !=4 && choice !=5 && choice !=6){
			System.out.println("Invalid choice. Please select a valid number: ");
			choice =reader_admin.nextInt();
		}
		
		
		return choice;
	}
	
	
	//*******************************Student Implementation************************************
	public int student_interface1_specific(int choice){
		
		if (choice == 1){
			//view all courses
			Course.display_all_courses();
		} else if (choice == 2){
			//view my courses
			view_my_course();
		} else if (choice == 3){
			//change password
			change_password();
		} else if (choice == 4){
			//change username
			change_username();
		} else if (choice == 5) {
			//register courses	
			Scanner reader_admin = new Scanner(System.in);  
	        System.out.println("Course Names: ");
			String courseName = reader_admin.next();
			register_course(courseName);
			course_taking.add(courseName);
			
		} else if (choice == 6){
			//unregister courses
			Scanner reader_admin = new Scanner(System.in);  
	        System.out.println("Course Name: ");
			String courseName = reader_admin.next();
			unregister_course(courseName);
			course_taking.remove(courseName);
			
		} else {
			System.out.println("error");
		}
		System.out.println("Do you want to go back to your Student Center? 1. Yes 2. Logout Your Account");
		Scanner reader_admin = new Scanner(System.in);  
		int answer = reader_admin.nextInt();
		
		if (answer == 1){
			answer = 21;
		} else if (answer == 2) {
			answer = 0;
		} else {
			System.out.print("invalid choice number; automatic Logout Your Account for protection");
			answer = 0;
		}
		return answer;
	}


	
	//*******************************SPECIFIC METHOD********************************
	public static void remove_a_student() {
		Scanner reader_admin = new Scanner(System.in);  
        System.out.println("Student's netid: ");
        String student_name = reader_admin.next();
        
		for (int i = 0; i < studentList.size(); i++) {
			if (student_name.equals(studentList.get(i).getUsername())) {
				studentList.remove(i);
				break;
			}
		}
		System.out.println("successfully removed "+ student_name);
	}
	
	public static void display_all_students() {
		// display all students
		System.out.println("All Students:");
		for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i).name);
        }
	}
	
	public void view_my_course(){
		System.out.println("My courses: ");
		for (int i = 0; i < this.course_taking.size(); i++){
			System.out.println(this.course_taking.get(i));	
		}
	}
	
	//**********************REGISTER*****************************
	public void register_course(String courseName) {
		for (int j = 0; j < Course.listofCourses.size(); j++){
			// Check full, if not, add course_taking to students, number of students in class
			if (courseName.equals(Course.listofCourses.get(j).course_name)){
						
				Course.listofCourses.get(j).checkFull(courseName);
				if (Course.listofCourses.get(j).isFull == false) {
					Course.listofCourses.get(j).number_of_students_registered ++;
					Course.listofCourses.get(j).students_enrolled.add(this.getUsername());
					
					System.out.println("Successfully registered "+this.getUsername()+" to "+courseName);
				} else {
					System.out.println("Sorry, the class is FULL and you cannot be added");
				}
			}
		}
	}
	
	//**********************UNREGISTER*****************************
			public void unregister_course(String courseName) {
				for (int j = 0; j < Course.listofCourses.size(); j++){
					// Check full, if not, add course_taking to students, number of students in class
					if (courseName.equals(Course.listofCourses.get(j).course_name)){
						Course.listofCourses.get(j).number_of_students_registered --;
						Course.listofCourses.get(j).students_enrolled.remove(this);
						System.out.println("Successfully unregistered "+this.getUsername()+" to "+courseName);
						
					}
				}
			}


}
