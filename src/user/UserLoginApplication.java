package user;
//Rest of logic held here

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

private static UserService userService = new UserService();
private static String userEmail = null;
private static String userPassword = null;
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		//populates user array from text file
		userService.createUserArray();
		
		validateUser();
		
	}

	public static void validateUser() {
		
		boolean validLogin = false;
		int numberOfLogins = 0;
		
		//Continue while loop if valid Login is not false and number of logins is less than five
		while (!validLogin && numberOfLogins < 5) {
			
			Scanner input = new Scanner(System.in);
			
			System.out.println("Enter your email:");
			userEmail = input.nextLine();
			System.out.println("Enter your password:");
			userPassword = input.nextLine();
			
			
			//Set user equal to the validate user input method to check if it exists in the array
			User isUserValid = new User();
			isUserValid = userService.validateUserInput(userEmail, userPassword);
			
			if (isUserValid != null) { // will return null if its in the array
				
				System.out.println("Welcome " + isUserValid.getName());
				validLogin = true; //true and break out of while loop
				
				input.close();
			}
			
			else { //if it doesnt return null, user input was not in the array and will prompt this:
				
				System.out.println("Invalid login, try again");
				numberOfLogins++;
				
				//check for number of invalid login tries
				if(numberOfLogins == 5) {
					
					System.out.println("Too many failed login attempts, you are now locked out.");
				}
			}
			
		}
	}
}
