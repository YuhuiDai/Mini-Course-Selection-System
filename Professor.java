package datastructure_hw1;

import java.util.ArrayList;
import java.util.Scanner;

public class Professor extends User implements Changable, Logable{
	String n_number = null;
	String date_of_birth = null;
	int SSN;
	String name = "You need to enter his/her name as admin";
	String address = null;
	String office_location = null;
	int phone_number;
	public ArrayList<String> course_taught = new ArrayList<String>();
	public static ArrayList<Professor> professorList = MainClass.professorList;
	
	public Professor(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}


	// ************************************PASSWORD CHECK******************************
	@Override
	public String findPassword(String username, ArrayList<?> mylist) {
		// find the password given a username
		String actual_password = null;
		for (int i = 0; i < mylist.size(); i++) {

            if (((Professor) mylist.get(i)).getUsername().equals(username)) {
            	actual_password = ((Professor)mylist.get(i)).getPassword();
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
			System.out.println("Welcome, Professor");
		} else {
			System.out.println("Wrong Password, please try again");
			String newPassword = requestPassword();
			comparePassword(newPassword, actual_password);
		}
		return true;

	}
	
	//************************************LOGIN***************************************
	public int loginProfessor(String username, ArrayList<Professor> professorlist){
		int next = 0;
		String actual_password = findPassword(username, professorlist);
		String input_password = requestPassword();
		boolean isCorrect = comparePassword(input_password, actual_password);
		while (isCorrect == false) {
			System.out.println("Wrong Password. Please try again");
			input_password = requestPassword();
			isCorrect = comparePassword(input_password, actual_password);
		}
		int choice_professor = professor_interface1();
		next = professor_interface1_specific(choice_professor);
		
		// next = 31 or 0;
		return next;
        
	}

	//************************************CHANGE*********************************
	@Override
	public boolean change_password() {
		Scanner reader_admin = new Scanner(System.in);  
        System.out.println("netID: ");
		String username = reader_admin.next();
		for (int i = 0; i < professorList.size(); i++) {
			if (username.equals(professorList.get(i).getUsername())) {
				System.out.println("old password: ");
				String old_password = reader_admin.next();
				if (old_password.equals(professorList.get(i).getPassword())){
					System.out.println("Please enter new password: ");
					String temp_password = reader_admin.next();
					System.out.println("Please enter new password again: ");
					String second_time_password = reader_admin.next();
					if (temp_password.equals(second_time_password)) {
						professorList.get(i).setPassword(temp_password);
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
		for (int i = 0; i < professorList.size(); i++) {
			if (username.equals(professorList.get(i).getUsername())) {
				System.out.println("password: ");
				String password = reader_admin.next();
				if (password.equals(professorList.get(i).getPassword())){
					System.out.println("Please enter new username: ");
					String new_username = reader_admin.next();
					professorList.get(i).setUsername(new_username);
					System.out.println("Success");
				}
			}
		}
		
	}
	
	//*********************************Professor Menu**************************
	public int professor_interface1(){
		System.out.println("1. View Your Course(s)");
        System.out.println("2. View Your Students of a Course");
        System.out.println("3. Change Password");
        System.out.println("4. Change Username");

        Scanner reader_admin = new Scanner(System.in);  
        System.out.println("Select your choice of number: ");
		int choice = reader_admin.nextInt();
	
		while (choice != 1 && choice != 2 && choice !=3 && choice !=4){
			System.out.println("Invalid choice. Please select a valid number: ");
			choice =reader_admin.nextInt();
		}
		
		
		return choice;
	}
	
	//***************************************Professor Implementation**************************
	public int professor_interface1_specific(int choice){
		
		if (choice == 1){
			//view his courses
			view_my_course();
		} else if (choice == 2){
			//see his students
			Scanner reader_admin = new Scanner(System.in);  
	        System.out.println("Course Name: ");
	        String course_name = reader_admin.next();
	        
	        view_my_student(course_name);
	        
		} else if (choice == 3){
			//change password
			change_password();
		} else if (choice == 4){
			//change username
			change_username();
		} else {
			System.out.println("Error");
		}
		System.out.println("Do you want to go back to your Professor Center? 1. Yes 2. Logout Your Account");
		Scanner reader_admin = new Scanner(System.in);  
		int answer = reader_admin.nextInt();
		
		if (answer == 1){
			answer = 31;
		} else if (answer == 2) {
			answer = 0;
		} else {
			System.out.print("invalid choice number; automatic Logout Your Account for protection");
			answer = 0;
		}
		return answer;
	}
	
	//*******************************SPECIFIC METHOD********************************
	public static void remove_a_professor() {
		Scanner reader_admin = new Scanner(System.in);  
        System.out.println("Professor's netID: ");
        String professor_name = reader_admin.next();
        
		for (int i = 0; i < professorList.size(); i++) {
			if (professor_name.equals(professorList.get(i).getUsername())) {
				professorList.remove(i);
				break;
			}
		}
		System.out.println("successfully removed "+ professor_name);
	}
	
	public static void display_all_professors() {
			// display all professors
		System.out.println("All Professors:");
		for (int i = 0; i < professorList.size(); i++) {
            System.out.println(professorList.get(i).name);	        
        }
	}
	
	
	// 8888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
	public void view_my_course(){
		System.out.println("My Course(s):");
		for (int i = 0; i < this.course_taught.size(); i++){
			System.out.println(this.course_taught.get(i));
		}
	}
	
	public void view_my_student(String course_name){
		System.out.println(course_name + " students: ");
		for (int i = 0; i < Course.listofCourses.size(); i++){
			if (course_name.equals(Course.listofCourses.get(i).course_name) ){
				for (int j = 0; j < Course.listofCourses.get(i).students_enrolled.size(); j++){
					System.out.println(Course.listofCourses.get(i).students_enrolled.get(j));
				}
			}
			
		}
	}
}
