package Sweet.App;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private int userNameFlag;
	private int emailFlag;
	private String role; 
	private boolean isLoggedIn;
	private String city;//where the user live
	private List<Massage> userSentMsgs;
	private List<Massage> userRecievedMsgs;
	private String branch;
	private String cityOwnerSupplier;//where the user works
	private String phoneNumber; 
	private String nationality;
	private String dateOfBirth;

	
	 public User(String userName, String password, String role, String branch, String cityOwnerSupplier,
		     String email, String phoneNumber, String nationality, String dateOfBirth) {
		 
				super();
				this.userName = userName;
				this.password = password;
				this.role = role;
				this.branch = branch;
				this.cityOwnerSupplier = cityOwnerSupplier;
				userSentMsgs=new ArrayList<>();
				userRecievedMsgs=new ArrayList<>();
				this.email = email;
			    this.phoneNumber = phoneNumber;
			    this.nationality = nationality;
			    this.dateOfBirth = dateOfBirth;
			    }
	

	public User() {
		role="User";//just for testing my code(shams's code)
		userSentMsgs=new ArrayList<>();
		userRecievedMsgs=new ArrayList<>();
	}
	   
	public User(String username2, String password2,String role2) {
		this.userName=username2;
	    this.password=password2;
		this.role=role2;
		userSentMsgs=new ArrayList<>();
		userRecievedMsgs=new ArrayList<>();
	
		}
		


	public User(String userName, String password, String role, String city) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.city = city;
		userSentMsgs=new ArrayList<>();
		userRecievedMsgs=new ArrayList<>();
	}

	
	
	


	public void setUserRecievedMsgs(ArrayList<Massage> userRecievedMsgs) {
		this.userRecievedMsgs = userRecievedMsgs;
	}


	


	public List<Massage> getUserSentMsgs() {
		return userSentMsgs;
	}


	public void setUserSentMsgs(List<Massage> userSentMsgs) {
		this.userSentMsgs = userSentMsgs;
	}


	public List<Massage> getUserRecievedMsgs() {
		return userRecievedMsgs;
	}


	public void setUserRecievedMsgs(List<Massage> userRecievedMsgs) {
		this.userRecievedMsgs = userRecievedMsgs;
	}


	public void setUserSentMsgs(ArrayList<Massage> userSentMsgs) {
		this.userSentMsgs = userSentMsgs;
	}


	public boolean isLoggedIn() {
		return isLoggedIn;
	}


	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}


	public int getUserNameFlag() {
		return userNameFlag;
	}


	public int getEmailFlag() {
		return emailFlag;
	}


	public void setEmailFlag(int emailFlag) {
		this.emailFlag = emailFlag;
	}


	public void setUserNameFlag(int userNameFlag) {
		this.userNameFlag = userNameFlag;
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
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
			
		        if (flag) {
		            return false;
		        }
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
		 return !password.equals("") && !uname.equals("");
	}

	public boolean checkCity(String city2) {
		if(city2.equals("")) {return false;}
		else 
		{
			this.setCity(city2);
			return true;}
	}

	
	
	 public boolean checkRoleType(String roleType) {
	        if (roleType.equals("")) {
	            return false;
	            
	        }else if(roleType.equals("Owner")||roleType.equals("Supplier")) {
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

	 
	 public boolean checkCityBranchPosition(String city2) {
			if(city2.equals("")) {return false;}
			else if(city2.equals("Jenin")||city2.equals("Nablus")) {
				this.setCityOwnerSupplier(city2);
				return true;
			}else {
	            return false;
	        }
	    }
	
	 public boolean checkPhoneNumber(String phoneNumber2) {
			if(phoneNumber2.equals("")) {
				return false;
				
			}else 
			{
				
				this.setPhoneNumber(phoneNumber2);
				return true;
			}
		}
}