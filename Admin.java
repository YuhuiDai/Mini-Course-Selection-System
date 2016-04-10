package datastructure_hw1;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User implements Logable {
	
	public Admin(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}
	//*******************specific methods***************************
	//****************************ADD***********************
	public static void add_tolistofAllCourses(){
		
		//ask for the course info .. 
		Scanner reader_admin = new Scanner(System.in);  
        System.out.println("Course Name: ");
		String course_name = reader_admin.next();
		System.out.println("Instructor's netID: ");
		String netID = reader_admin.next();
		System.out.println("Course room: ");
		String room = reader_admin.next();
		
		Course newCourse = new Course(course_name, netID, room);

		
		// create an object temp of type course
		Course.listofCourses.add(newCourse);
	
	}
	public void add_toallStudentsList(){
		
		Scanner reader_admin = new Scanner(System.in);  
        System.out.println("Student netID: ");
		String username = reader_admin.next();
		System.out.println("Initial password: ");
		String password = reader_admin.next();
		
		Student newStudent = new Student(username,password);
		
		Student.studentList.add(newStudent);
	}

	public void add_toallProfessorsList(){
		
		//add a prof need the arraylist
		Scanner reader_admin = new Scanner(System.in);  
        System.out.println("Professor netID: ");
		String username = reader_admin.next();
		System.out.println("Initial password: ");
		String password = reader_admin.next();
		
		Professor newProfessor = new Professor(username,password);
		Professor.professorList.add(newProfessor);
	}

	//****************************EDIT***************************
	public void edit_info(Student student){
		Scanner reader_admin = new Scanner(System.in);  
        System.out.println("Select a choice to edit: 1.N-number 2.SSN 3.Name 4.Address 5.Phone Number 6.Date of Birth 7.Major 8.GPA ");
		int choice = reader_admin.nextInt();
		
		if (choice == 1) {
			Scanner reader_admin1 = new Scanner(System.in);  
	        System.out.println("N-number: ");
	        String student_number = reader_admin1.next();
			student.student_number= student_number;
	
		}else if (choice == 2){
			Scanner reader_admin2 = new Scanner(System.in);  
	        System.out.println("SSN: ");
	        int SSN = reader_admin2.nextInt();
			student.SSN= SSN;	
		
		} else if (choice == 3){
			Scanner reader_admin3 = new Scanner(System.in);  
	        System.out.println("Name: ");
	        String student_name = reader_admin3.next();
			student.name= student_name;
		
		} else if (choice == 4){
			Scanner reader_admin4 = new Scanner(System.in);  
	        System.out.println("Address: ");
	        String address = reader_admin4.next();
			student.address = address;
		
		} else if (choice == 5) {
			Scanner reader_admin5 = new Scanner(System.in);  
	        System.out.println("Phone Number: ");
	        int phone = reader_admin5.nextInt();
			student.phone_number= phone;
			
		} else if (choice == 6){
			Scanner reader_admin6 = new Scanner(System.in);  
	        System.out.println("Date of Birth: ");
	        String date_of_birth = reader_admin6.next();
			student.date_of_birth= date_of_birth;
			
		} else if (choice == 7){
			Scanner reader_admin7 = new Scanner(System.in);  
	        System.out.println("Major: ");
	        String major = reader_admin7.next();
			student.major= major;
		
		} else if (choice ==8) {
			Scanner reader_admin8 = new Scanner(System.in);  
	        System.out.println("GPA: ");
	        float gpa = reader_admin8.nextFloat();
			student.gpa= gpa;
		
		} else {
			System.out.print("error");
		}
	}
	
	public void edit_info_prof(Professor professor){
		Scanner reader_admin = new Scanner(System.in);  
        System.out.println("Select a choice to edit: 1.N-number 2.SSN 3.Name 4.Address 5.Phone Number 6.Date of Birth 7.Office Location ");
		int choice = reader_admin.nextInt();
		
		if (choice == 1) {
			Scanner reader_admin1 = new Scanner(System.in);  
	        System.out.println("N-number: ");
	        String n = reader_admin1.next();
	        professor.n_number=n;
			
		}else if (choice == 2){
			Scanner reader_admin2 = new Scanner(System.in);  
	        System.out.println("SSN: ");
	        int SSN = reader_admin2.nextInt();
			professor.SSN= SSN;	
			
		} else if (choice == 3){
			Scanner reader_admin3 = new Scanner(System.in);  
	        System.out.println("Name: ");
	        String name = reader_admin3.next();
			professor.name= name;
			
		} else if (choice == 4){
			Scanner reader_admin4 = new Scanner(System.in);  
	        System.out.println("Address: ");
	        String address = reader_admin4.next();
			professor.address = address;
		
		} else if (choice == 5) {
			Scanner reader_admin5 = new Scanner(System.in);  
	        System.out.println("Phone Number: ");
	        int phone = reader_admin5.nextInt();
			professor.phone_number= phone;
			
		} else if (choice == 6){
			Scanner reader_admin6 = new Scanner(System.in);  
	        System.out.println("Date of Birth: ");
	        String date_of_birth = reader_admin6.next();
			professor.date_of_birth= date_of_birth;
			
		} else if (choice == 7){
			Scanner reader_admin7 = new Scanner(System.in);  
	        System.out.println("Office address: ");
	        String office = reader_admin7.next();
	        professor.office_location = office;
	
		} else {
			System.out.print("error");
		}
	}
	
	public void edit_info_course(Course course){
		Scanner reader_admin = new Scanner(System.in);  
        System.out.println("Select a choice to edit: 1.Course name 2.Room 3.Course Number 4.Meeting time 5.Instructor's netID ");
		int choice = reader_admin.nextInt();
		
		if (choice == 1) {
			Scanner reader_admin1 = new Scanner(System.in);  
	        System.out.println("Course (new)name: ");
	        String n = reader_admin1.next();
	        course.course_name = n;

		}else if (choice == 2){
			Scanner reader_admin2 = new Scanner(System.in);  
	        System.out.println("Room: ");
	        String room = reader_admin2.next();
	        course.room = room;
	
		} else if (choice == 3){
			Scanner reader_admin3 = new Scanner(System.in);  
	        System.out.println("Course number: ");
	        String num = reader_admin3.next();
			course.course_number= num;
	
		} else if (choice == 4){
			Scanner reader_admin4 = new Scanner(System.in);  
	        System.out.println("Meeting time: ");
	        String time = reader_admin4.next();
			course.meeting_time = time;
	
		} else if (choice == 5) {
			Scanner reader_admin5 = new Scanner(System.in);  
	        System.out.println("Instructor netID: ");
	        String netID = reader_admin5.next();
			course.instructor_netID= netID;
			for (int i = 0; i < Professor.professorList.size(); i++) {
	            
	            if (Professor.professorList.get(i).getUsername().equals(netID)) {
	            	Professor.professorList.get(i).course_taught.add(course.course_name);
	            } else {
	            	System.out.println("Sorry, your username does not exist.");
	            }
	        }
		} else {
			System.out.print("error");
		}
	}
	
	//*********************DISPLAY COURSE TAKING*******************

	public  void display_course_taking(Student student) {
		System.out.println(student.course_taking);
	}
	
	//**********************REGISTER*****************************
	
	public void register_course(String studentName, String courseName) {
		for (int i = 0; i < Student.studentList.size(); i++) {
			if (studentName.equals(Student.studentList.get(i).getUsername())) {
				
				for (int j = 0; j < Course.listofCourses.size(); j++){
					
					// Check full, if not, add course_taking to students, number of students in class
					if (courseName.equals(Course.listofCourses.get(j).course_name)){
						
						Course.listofCourses.get(j).checkFull(courseName);
						if (Course.listofCourses.get(j).isFull == false) {
							Course.listofCourses.get(j).number_of_students_registered ++;
							Course.listofCourses.get(j).students_enrolled.add(studentName);
							Student.studentList.get(i).course_taking.add(courseName);
							System.out.println("Successfully registered "+studentName+" to "+courseName);
						} else {
							System.out.println("Sorry, the class is FULL and you cannot be added");
						}
					}
				}
				
			}
		}
	}
	
	//*****************************PASSWORD CHECK***************************************
	@Override
	public String findPassword(String username, ArrayList<?> mylist) {
		// find the password given a username
		String actual_password = null;
		for (int i = 0; i < mylist.size(); i++) {

            if (((Admin) mylist.get(i)).getUsername().equals(username)) {
            	actual_password = ((Admin)mylist.get(i)).getPassword();
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
			System.out.println("Welcome, admin");
		} else {
			System.out.println("Wrong Password, please try again");
			String newPassword = requestPassword();
			comparePassword(newPassword, actual_password);
		}
		return true;

	}
	
	//***********************************LOGIN****************************
	public int loginAdmin(String username, ArrayList<Admin> adminlist){
		int next = 0;
		String actual_password = findPassword(username, adminlist);
		String input_password = requestPassword();
		boolean isCorrect = comparePassword(input_password, actual_password);
		while (isCorrect == false) {
			System.out.println("Wrong Password. Please try again");
			input_password = requestPassword();
			isCorrect = comparePassword(input_password, actual_password);
		}
		int choice_admin = admin_interface();
        next = admin_interface1(choice_admin);
        // next = 11 or 0;
        return next;
	}
	
	
	//******************************ADMIN MAIN PAGE & ITS IMPLETMENTATION**********************
	public int admin_interface(){
		System.out.println("1.Courses Affairs");
        System.out.println("2.Students Affairs");
        System.out.println("3.Professor Affairs");
        
        Scanner reader_admin = new Scanner(System.in);  
        System.out.println("Select your choice of number: ");
		int choice_admin = reader_admin.nextInt();
	
		while (choice_admin != 1 && choice_admin != 2 && choice_admin !=3){
			System.out.println("Invalid choice. Please select a valid number: ");
			choice_admin =reader_admin.nextInt();
		}
		
		
		return choice_admin;
	}
	
	public int admin_interface1(int choice_admin){
		int next = 0;
		if (choice_admin == 1){
			int choice_admin11 = admin_interface11();
			next = admin_interface11_specific(choice_admin11);
		} else if (choice_admin == 2){
			int choice_admin12 = admin_interface12();
			next = admin_interface12_specific(choice_admin12);
		} else {
			int choice_admin13 = admin_interface13();
			next = admin_interface13_specific(choice_admin13);
		}
		return next;
	}
	
	
	//****************************ADMIN MENU*********************************
	public  int admin_interface11(){
		System.out.println("1. Add a course");
        System.out.println("2. Remove a course");
        System.out.println("3. Display all courses");
        System.out.println("4. Display all courses that are currently full");
        System.out.println("5. Edit Courses");
        System.out.println("6. Back to main menu");
        
        Scanner reader_admin = new Scanner(System.in);  
        System.out.println("Select your choice of number: ");
		int choice_admin = reader_admin.nextInt();
	
		while (choice_admin != 1 && choice_admin != 2 && choice_admin !=3 && choice_admin !=4 && choice_admin !=5 && choice_admin !=6){
			System.out.println("Invalid choice. Please select a valid number: ");
			choice_admin =reader_admin.nextInt();
		}
		
		
		return choice_admin;
	}
	
	public int admin_interface12(){
		System.out.println("1. Add a student");
        System.out.println("2. Remove a student");
        System.out.println("3. Edit Student");
        System.out.println("4. Display Student list");
        System.out.println("5. Register a Course(s) for a student");
        System.out.println("6. Display Courses(s) taken by a student");
        System.out.println("7. Back to Main Menu");
        Scanner reader_admin = new Scanner(System.in);  
        System.out.println("Select your choice of number: ");
		int choice_admin = reader_admin.nextInt();
	
		while (choice_admin != 1 && choice_admin != 2 && choice_admin !=3 && choice_admin !=4 && choice_admin !=5 && choice_admin !=6 && choice_admin !=7){
			System.out.println("Invalid choice. Please select a valid number: ");
			choice_admin =reader_admin.nextInt();
		}
		
		
		return choice_admin;
	}
	
	
	public int admin_interface13(){
		System.out.println("1. Add a professor");
        System.out.println("2. Remove a professor");
        System.out.println("3. Display all professors");
        System.out.println("4. Edit a professor");
        System.out.println("5. Back to main menu");
        
        Scanner reader_admin = new Scanner(System.in);  
        System.out.println("Select your choice of number: ");
		int choice_admin = reader_admin.nextInt();
	
		while (choice_admin != 1 && choice_admin != 2 && choice_admin !=3 && choice_admin !=4 && choice_admin !=5){
			System.out.println("Invalid choice. Please select a valid number: ");
			choice_admin =reader_admin.nextInt();
		}
		
		
		return choice_admin;
	}

	
	//*************************************ADMIN INPLEMENTATION*****************************
	public int admin_interface11_specific(int choice){
		int answer = 0;
		if (choice == 1){
			//add a course need the arraylist
			add_tolistofAllCourses();
			
		} else if (choice == 2){
			//remove a course need the arraylist
	        Course.remove_a_course();      
		
		} else if (choice == 3){
			//print all courses
			Course.display_all_courses();
			
		} else if (choice == 4){
			//print full courses
			Course.display_fullCourses();
			
		} else if (choice == 5) {
			//edit course
			Scanner reader_admin = new Scanner(System.in);  
	        System.out.println("Course name: ");
	        String course_name = reader_admin.next();
	        
	        for (int i = 0; i < Course.listofCourses.size(); i++) {
				if (course_name.equals(Course.listofCourses.get(i).course_name)) {
					edit_info_course(Course.listofCourses.get(i));
				}
			}
		} else if (choice == 6){
			//back to main admin
			answer = 11;
			
		} else {
			System.out.println("Error");
		}
		// ***********
		if (answer == 11) {
			answer = 11; 
		} else {
			System.out.println("Do you want to go back to your Admin Center? 1. Yes 2. Logout Your Account");
			Scanner reader_admin = new Scanner(System.in);  
			answer = reader_admin.nextInt();
			
			if (answer == 1){
				answer = 11;
			} else if (answer == 2) {
				answer = 0;
			} else {
				System.out.print("invalid choice number; automatic Logout Your Account for protection");
				answer = 0;
			}	
		}
		return answer;
	}
	
	public int admin_interface12_specific(int choice){
		int answer = 0;
		if (choice == 1){
			//add a student 
			add_toallStudentsList();
			
		} else if (choice == 2){
			//remove a student need the arraylist
			
	        Student.remove_a_student();
			
			
		} else if (choice == 3){
			//edit student need the arraylist
			Scanner reader_admin = new Scanner(System.in);  
	        System.out.println("Student's netid: ");
	        String username = reader_admin.next();
	        
	        for (int i = 0; i < Student.studentList.size(); i++) {
				if (username.equals(Student.studentList.get(i).getUsername())) {
					edit_info(Student.studentList.get(i));
				}
			}
			
			
		} else if (choice == 4){
			//print students need the arraylist
			Student.display_all_students();
			
		} else if (choice == 5) {
			//register course for student need the arraylist
			Scanner reader_admin = new Scanner(System.in);  
	        System.out.println("Student's netid: ");
	        String username = reader_admin.next();
	        System.out.println("Course Name: ");
	        String course_name = reader_admin.next();
	        
	        register_course(username, course_name);
			
		} else if (choice == 6){
			//display student taken courses need the arraylist
			Scanner reader_admin = new Scanner(System.in);  
	        System.out.println("Student's netid: ");
	        String username = reader_admin.next();
	        
	        for (int i = 0; i < Student.studentList.size(); i++) {
				if (username.equals(Student.studentList.get(i).getUsername())) {
					display_course_taking(Student.studentList.get(i));
				}
			}
			
		} else if (choice == 7){
			answer = 11;	
		} else {
			System.out.print("error");	
		}
		
		if (answer == 11) {
			answer = 11; 
		} else {
			System.out.println("Do you want to go back to your Admin Center? 1. Yes 2. Logout Your Account");
			Scanner reader_admin = new Scanner(System.in);  
			answer = reader_admin.nextInt();
			
			if (answer == 1){
				answer = 11;
			} else if (answer == 2) {
				answer = 0;
			} else {
				System.out.print("invalid choice number; automatic Logout Your Account for protection");
				answer = 0;
			}	
		}
		return answer;
	}
	
	public int admin_interface13_specific(int choice){
		int answer = 0;
		if (choice == 1){
			//add a prof
			add_toallProfessorsList();
			
		} else if (choice == 2){
			//remove a prof need the arraylist
	        Professor.remove_a_professor();
			
		
		} else if (choice == 3){
			//print all prof need the arraylist
			Professor.display_all_professors();
			
		} else if (choice == 4) {
			//edit professor need the arraylist
			Scanner reader_admin = new Scanner(System.in);  
	        System.out.println("Professor's netid: ");
	        String username = reader_admin.next();
	        
	        for (int i = 0; i < Professor.professorList.size(); i++) {
				if (username.equals(Professor.professorList.get(i).getUsername())) {
					edit_info_prof(Professor.professorList.get(i));
				}
			}
			
		} else if (choice == 5){
			//back to main admin
			answer = 11;
		} else {
			System.out.println("Error");
		}
		
		if (answer == 11) {
			answer = 11; 
		} else {
			System.out.println("Do you want to go back to your Admin Center? 1. Yes 2. Logout Your Account");
			Scanner reader_admin = new Scanner(System.in);  
			answer = reader_admin.nextInt();
			
			if (answer == 1){
				answer = 11;
			} else if (answer == 2) {
				answer = 0;
			} else {
				System.out.print("invalid choice number; automatic Logout Your Account for protection");
				answer = 0;
			}	
		}
		return answer;
	}

}
