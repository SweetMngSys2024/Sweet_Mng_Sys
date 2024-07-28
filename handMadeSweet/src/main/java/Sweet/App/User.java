package Sweet.App;

import java.util.ArrayList;

public class User {

	public String userName;
	public String password;
	public String firstName;
	public String lastName;
	public String email;
	public int userNameFlag;
	public int emailFlag;
	public String role;
	public boolean isLoggedIn;

	
	public User() {
		role="User";//just for testing my code(shams's code)
	}
	   
	public User(String username2, String password2,String role2) {
		this.userName=username2;
	    this.password=password2;
		this.role=role2;
		}
		

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}



	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + "]";
	}



	//to check if first name is valid
	public boolean checkFirstName(String fName) 
	{
		if(fName.equals("")) {return false;}
		else 
		{
			this.setFirstName(fName);
			return true;}
	}
	
	public boolean checkLastName(String lName) 
	{
		if(lName.equals("")) {return false;}
		else 
		{
			this.setLastName(lName);
			return true;}
	}
	
	public boolean checkUserName(String uName) 
	{
		boolean flag=false;
		if(uName.equals("")) {userNameFlag=0; return false;}
		else 
		{
			  ArrayList<User> users = MyApp.getUsers();
		        for (User user : users) {
		          if(user.getUserName().equals(uName)) 
		          {
		        	  flag=true;
		        	 // MyApp.printStm("this user already exist!");
		        	  userNameFlag=1; //meaning that the user name is exist
		        	  break;
		          }
		        }
			
		        if(flag==true) {return false;}
		        else {this.setUserName(uName);
				return true;}
			}
	}
	
	
	public boolean checkEmail(String email) 
	{
		if(email.equals("")) {emailFlag=0; return false;}
		else 
		{
			 if (email.endsWith("@.com")) {
				    emailFlag=1;
					return false;
		        } else {
		        	this.setEmail(email);
					return true;
		        }
		}
	}
	
	public boolean checkPassword(String password) //for sign up
	{
		if(password.equals("")) {return false;}
		else 
		{
			this.setPassword(password);
			return true;}
	}
	

	public boolean checkEmptyPassOrUname(String password,String uname) //for log in
	{
		if(password.equals("")) { return false;}
		else if(uname.equals("")) { return false;}
		else 
		   {
			return true;
			}
	}
	
	
}
