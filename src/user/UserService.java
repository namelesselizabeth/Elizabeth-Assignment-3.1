package user;
//Help with validating if the inputed username/password matches User Array
//Provides service of reading data from the file
//Creates the User Array

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserService {

	//User Array from Stored File,
	private static User[] users = new User[5];
	
	// Read the Data from the data.txt file
		
		public void createUserArray() throws FileNotFoundException, IOException{

			BufferedReader fileReader = null;
			
			try {
				
				fileReader = new BufferedReader(new FileReader("data.txt"));
				
				String line = null;
				int i = 0; //counter
				
				//.readLine() resets at each new line so no need to split the array further by line
				while ((line = fileReader.readLine()) != null) { //keeps looping as long as theres text
	
					users[i] = new User(line.split(",")); //splits each readLine() by comma
					//System.out.println(users[i]); //prints out each user
					i++;		
				}			
			} finally {
				
					fileReader.close();
				
			  }

		}
		
		public User validateUserInput(String username, String password) {
			
			//for every user in user array
			for (User user : users) {
				
				//username is case insensitive && password is case sensitive
				if (user.getUserName().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
					
					return user;
				}
			}
			
			return null; //null will return if user is in array
			
		}

}