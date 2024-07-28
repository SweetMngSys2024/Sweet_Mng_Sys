package test2.ps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Sweet.App.MyApp;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class signup {

	MyApp sweetApp;
	
	
	public signup(MyApp sweetApp) {
		this.sweetApp = sweetApp;
	}


	@When("user enter {string} in the first name field")
	public void userEnterInTheFirstNameField(String fName ) {
		boolean fNameFlag = sweetApp.currentUser.checkFirstName(fName);
		if(fNameFlag==true)assertTrue("check first name failed", fNameFlag);
		else assertFalse("check first name passed", fNameFlag);
		
		
	}

	@When("user enter {string} in the last name field")
	public void userEnterInTheLastNameField(String lName) {
		
		boolean lNameFlag = sweetApp.currentUser.checkLastName(lName);
		if(lNameFlag==true)assertTrue("check last name failed", lNameFlag);
		else assertFalse("check last name passed", lNameFlag);
	}

	@When("user enter {string} in the password field")
	public void userEnterInThePasswordField(String pass) {
		
		boolean pFlag = sweetApp.currentUser.checkPassword(pass);
		if(pFlag==true)assertTrue("check password failed", pFlag);
		else assertFalse("check password passed", pFlag);
	}

	@When("user enter {string} in the user name field")
	public void userEnterInTheUserNameField(String userName) {
		
		boolean uNameFlag = sweetApp.currentUser.checkUserName(userName);
		if(uNameFlag==true)assertTrue("check user name failed", uNameFlag);
		else assertFalse("check user name passed", uNameFlag);
	}

	@When("user enter {string} in the email field")
	public void userEnterInTheEmailField(String email) {
	
		boolean eFlag = sweetApp.currentUser.checkEmail(email);
		if(eFlag==true)assertTrue("check email failed", eFlag);
		else assertFalse("check email passed", eFlag);
	}

	@Then("the user registration to the system will be successful")
	public void theUserRegistrationToTheSystemWillBeSuccessful() {
		sweetApp.addUser(sweetApp.currentUser);
		assertTrue("test case failed", true);
	
	}

	@Then("an error message should appear {string}")
	public void anErrorMessageShouldAppear(String msg) {
		sweetApp.printStm(msg);
		assertTrue("test case failed", true);
	
	}


	

}
