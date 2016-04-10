package datastructure_hw1;

import java.util.ArrayList;

public interface Logable {
	
	String findPassword(String username, ArrayList<?> mylist);
	
	String requestPassword();
	
	boolean comparePassword(String user_password, String actual_password);


}
