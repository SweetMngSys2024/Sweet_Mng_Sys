package Sweet.App; 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

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
	public String city;//where the user live
	public ArrayList<Massage> userSentMsgs;
	public ArrayList<Massage> userRecievedMsgs;
	private String branch;
	private String cityOwnerSupplier;//where the user works

	 
	
	public User(String userName, String password, String role, String branch, String cityOwnerSupplier) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.branch = branch;
		this.cityOwnerSupplier = cityOwnerSupplier;
		userSentMsgs=new ArrayList<Massage>();
		userRecievedMsgs=new ArrayList<Massage>();
	}

	public User() {
		role="User";//just for testing my code(shams's code)
		userSentMsgs=new ArrayList<Massage>();
		userRecievedMsgs=new ArrayList<Massage>();
	}
	   
	public User(String username2, String password2,String role2) {
		this.userName=username2;
	    this.password=password2;
		this.role=role2;
	
		}
		


	public User(String userName, String password, String role, String city) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.city = city;
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

	public boolean checkCity(String city2) {
		if(city2.equals("")) {return false;}
		else if(city2.equals("Jenin")||city2.equals("Nablus")) {
			this.setCity(city2);
			return true;
		}else {
            return false;
        }
    }
	
	
	
	 public boolean checkRoleType(String roleType) {
	        if (roleType.equals("")) {
	            return false;
	            
	        }else if(roleType.equals("Owner")||roleType.equals("Suppliers")) {
	        	this.setRole(roleType);
	            return true;
	        } else {
	            return false;
	        }
	    }
	

	 public boolean checkBranch(String Branch) {
	        if (Branch.equals("")) {
	            return false;
	            
	        }else if(Branch.equals("Branch 1")||Branch.equals("Branch 2")||Branch.equals("Branch 3")||Branch.equals("Branch 4")) {
	        	this.setBranch(Branch);
	            return true;
	        } else {
	            return false;
	        }
	    }

	 
	 
	 
	 
	 
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCityOwnerSupplier() {
		return cityOwnerSupplier;
	}

	public void setCityOwnerSupplier(String cityOwnerSupplier) {
		this.cityOwnerSupplier = cityOwnerSupplier;
	}

	
}