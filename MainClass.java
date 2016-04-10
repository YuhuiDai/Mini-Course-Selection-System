package datastructure_hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass{
	
	//create all lists .. here as public .. 
	public static ArrayList<Admin> adminList = new ArrayList<Admin>();
	public static ArrayList<Professor> professorList = new ArrayList<Professor>();
	public static ArrayList<Student> studentList = new ArrayList<Student>();
//	public static boolean logout_your_role = false;
	public static boolean shut_down = false;
	
	
	/*allows the user to do things in his or her own center,
	* when choosing logout from his/her center, 
	* they logout their user domain but the program does not shut down,
	* everything same in the memory, professors/students can access whenever they want 
	*/
	public static void loop_in_your_center(int next, Object obj){
		while (next != 0) {
			if (next == 11){
				int choice_admin = ((Admin) obj).admin_interface();
		        next = ((Admin) obj).admin_interface1(choice_admin);
			} else if (next == 21){
				int choice_student = ((Student) obj).student_interface1();
				next = ((Student) obj).student_interface1_specific(choice_student);
			} else if (next == 31) {
				int choice_professor = ((Professor) obj).professor_interface1();
				next = ((Professor) obj).professor_interface1_specific(choice_professor);
			} else {
				System.out.println("Error; Automatic Logout for Protection.");
				next = 0;
			}
		}
		System.out.println(" Logout Your Center");
	
	}
	
	public static int determine_identity(){
		// get the identity of the user and lead it to their respective area
		
		Scanner reader = new Scanner(System.in); 
		System.out.println("Enter 1 if you are admin, 2 if you are a student, 3 if you are a professor: ");
		int selection = reader.nextInt(); 
		while (selection != 1 && selection != 2 && selection !=3){
			
			System.out.println("Invalid choice. Please select a valid number: ");
            selection =reader.nextInt();
            
		}
		//reader.close();
		return selection;
	}
	
	public static void moving_next_menu(int selectionNumber){
		if (selectionNumber == 1) {
			//admin login
			String username = requestUsername();
			Admin my_admin = findObject_admin(username, adminList);
            int next = my_admin.loginAdmin(username, adminList);	
    		loop_in_your_center(next, my_admin);
    	
        } else if (selectionNumber == 2) {
            //student login
        	String username = requestUsername();
			Student my_student = findObject_student(username, studentList);
            int next = my_student.loginStudent(username, studentList);
            loop_in_your_center(next, my_student);
         
        } else {
            //professor login
        	String username = requestUsername();
			Professor my_professor = findObject_professor(username, professorList);
            int next = my_professor.loginProfessor(username, professorList);
            loop_in_your_center(next, my_professor);
           
        }
		
	}
	

	public static String requestUsername() {
		// ask for input password
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Enter your username: ");

		String username = new String();
				
				username = reader.next(); 

		return username;
		
	}
	
	public static Admin findObject_admin(String username, ArrayList<?> mylist) {
		// find the object given a username
		Admin my_account = null;
		for (int i = 0; i < mylist.size(); i++) {
            if (((Admin) mylist.get(i)).getUsername().equals(username)) {
            	my_account = ((Admin)mylist.get(i));
            	break;
            } else {
            	System.out.println("Sorry, your username does not exist. System Shut Down for protection");
            	System.exit(0);
            }
        }
		return my_account;
	}

	public static Student findObject_student(String username, ArrayList<Student> mylist) {
		// find the object given a username
			Student my_account = null;
				for (int i = 0; i < mylist.size(); i++) {
					
		            if (((Student) mylist.get(i)).getUsername().equals(username)) {
		            	my_account = ((Student)mylist.get(i));
		            	break;
		            } 
		        }
			if (my_account == null) {
				System.out.println("Sorry, your username does not exist. System Shut Down for protection");
            	System.exit(0);
			}
		return my_account;
	}
	
	public static Professor findObject_professor(String username, ArrayList<Professor>mylist) {
		// find the object given a username
			Professor my_account = null;
				for (int i = 0; i < mylist.size(); i++) {
		            
		            if (((Professor) mylist.get(i)).getUsername().equals(username)) {
		            	my_account = ((Professor)mylist.get(i));
		            	break;
		            } 
		            
		        }
				if (my_account == null) {
					System.out.println("Sorry, your username does not exist. System Shut Down for protection");
	            	System.exit(0);
				}
		return my_account;
	}

	
	
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@read files and instantiate students
		
		File filest = new File("student.txt");
		
		Scanner scanstudent = new Scanner(filest);
		boolean hasNextstudent = scanstudent.hasNext();

		    
		while (hasNextstudent != false) {
		    	
			//read the line
		    String username = scanstudent.next(); // get the user name
		    System.out.println(username+"Done");
		    String password = scanstudent.next(); // get the password	
		    //instantiate object based on above parameters
		    Student student = new Student(username, password);
		    studentList.add(student);
		    	
		    hasNextstudent = scanstudent.hasNext();

		}
		System.out.println(studentList.get(1).getUsername());
		scanstudent.close();
		
		
		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@ read files and instantiate professors
		File fileprof = new File("professor.txt");
		
		Scanner scanprof = new Scanner(fileprof);
		boolean hasNextprofessor = scanprof.hasNext();

		    
		while (hasNextprofessor != false) {
		    	
			//read the line
		    String username = scanprof.next(); // get the user name
		    String password = scanprof.next(); // get the password
		    	
		    //instantiate object based on above parameters
		    Professor professor = new Professor(username, password);
		    professorList.add(professor);
		    	
		    hasNextprofessor = scanprof.hasNext();

		}
		scanprof.close();
		
		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@ read files and instantiate admin
		File fileadmin = new File("admin.txt");
				
		Scanner scanadmin = new Scanner(fileadmin);
		boolean hasNextAdmin = scanadmin.hasNext();

				    
		while (hasNextAdmin != false) {
				    	
			//read the line
			String username = scanadmin.next(); // get the user name
			System.out.println(username);
			String password = scanadmin.next(); // get the password
			System.out.println(password);
				    	
			//instantiate object based on above parameters
			Admin admin = new Admin(username, password);
			adminList.add(admin);
				    	
			hasNextAdmin = scanadmin.hasNext();

		}
		scanadmin.close();
		
		do {
			// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ determine identity
			int selectionNumber = determine_identity();
			moving_next_menu(selectionNumber);
			
			//ask whether one wants to shut down the program
			Scanner reader = new Scanner(System.in);
			System.out.println("Do you want to shut down the program? 1. Yes  2. No");
			int choice = reader.nextInt();
			if (choice == 1){
				shut_down = true;
			}
		} while (shut_down == false);
		
		System.exit(0);
		
		
	}

}
