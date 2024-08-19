package test2.ps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sweet.app.MyApp;

public class login {
	MyApp sweetApp;
	

	public login(MyApp sweetApp) {
		this.sweetApp = sweetApp;
	}

	@Given("user is not in the sweet system")
	public void userIsNotInTheSweetSystem() {
		   assertFalse(sweetApp.currentUser.isLoggedIn);
	}

	@When("user logs in with username {string} and password {string} and role {string} logs in")
	public void userLogsInWithUsernameAndPasswordAndRoleLogsIn(String password, String username, String role) {
		  if (!(sweetApp.currentUser.checkEmptyPassOrUname(password, username))) {  
	        	sweetApp.currentUser.isLoggedIn = false;
	        } 
	        else {
	        	if(sweetApp.authenticateUser(password, username, role))sweetApp.currentUser.isLoggedIn=true;
	        //	sweetApp.currentUser.isLoggedIn = sweetApp.authenticateUser(password, username, role);
	 
	        }
	}

	@Then("the login result should be {string}")
	public void theLoginResultShouldBe(String expectedResult) {
		  if (expectedResult.equals("logged_in")) {
	            assertTrue("is logged in must be true",sweetApp.currentUser.isLoggedIn);
	        } else if (expectedResult.equals("failed_login_password")) {
	            assertFalse(sweetApp.currentUser.isLoggedIn);
	        } else if (expectedResult.equals("failed_login_username")) {
	            assertFalse(sweetApp.currentUser.isLoggedIn);
	        }
	}


}
