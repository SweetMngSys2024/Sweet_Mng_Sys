package Sweet.App;

import java.util.ArrayList;

public class MyApp {

	 static public ArrayList<User> users = new ArrayList<>();
	 static public ArrayList<Recipe> recipes = new ArrayList<>();
	 public User currentUser;
	
	 
	 public MyApp() {
		MyApp.users=new ArrayList<User>(); //u must fill it with data
		MyApp.recipes=new ArrayList<Recipe>();
		this.currentUser=new User();
		
		//to add data
		//User y= new User();
	//	y.userName="bayan22";
	//	users.add(y);
		users.add(new User("bayan", "password123", "User"));
		users.add(new User("ahmad", "password456", "User"));
		users.add(new User("aya", "password789", "Admin"));
		users.add(new User("amer", "password987", "Admin"));
		users.add(new User("shams", "password654", "Owner"));
		users.add(new User("raghad", "password321", "Owner"));
		users.add(new User("rama", "password675", "Suppliers"));
		users.add(new User("amal", "password184", "Suppliers"));
	        
	        
		
	}

	 
	public static ArrayList<User> getUsers() {
		return users;
	}

	public static void setUsers(ArrayList<User> users) {
		MyApp.users = users;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}


	public void printStm(String msg) {	  
		System.out.println(msg);		
	}
	 
	public void addUser(User user) {
		MyApp.users.add(user);
	}
	public void getInfo(User user) {
		System.out.println("First Name="+this.currentUser.getFirstName());
		System.out.println("Last Name="+this.currentUser.getLastName());
		System.out.println("Password="+this.currentUser.getPassword());
		System.out.println("User Name="+this.currentUser.getUserName());
		System.out.println("Email="+this.currentUser.getEmail());
		System.out.println("Role="+this.currentUser.getRole());
	}


	public void updateUserInfo(User currentUser2) {
		
	        for (User user : MyApp.users) {
	          if(user.getUserName().equals(currentUser2.getUserName())) 
	          {
	              user.setEmail(currentUser2.getEmail());
	              user.setUserName(currentUser2.getUserName());
	              user.setPassword(currentUser2.getPassword());
	        	  break;
	          }
	        }
		
	}
	public void deleteUser(User currentUser3) {
	
		MyApp.users.remove(currentUser3);
	}
	
	public void addRecipe(Recipe newRecipe) {
		MyApp.recipes.add(newRecipe);
	}


	public boolean authenticateUser(String username, String password, String role) {
	    ArrayList<User> users = MyApp.getUsers();
	    for (User user : users) {
	        if (user.getUserName().equals(username) && user.getPassword().equals(password) && user.getRole().equals(role)) {
	        	this.currentUser=user;
	        	 return true;
	           }
	        }
	        return false;
	    }
	 
}
