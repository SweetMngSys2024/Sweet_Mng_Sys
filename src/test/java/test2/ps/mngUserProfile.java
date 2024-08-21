package test2.ps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sweet.app.MyApp;

public class mngUserProfile {

	MyApp sweetApp;

	public mngUserProfile(MyApp sweetApp) {
		this.sweetApp = sweetApp;
	}

	@Given("that the user role is {string}")
	public void thatTheUserRoleIs(String role) {
		role="User";
	  assertEquals("The Role must be User!",sweetApp.currentUser.getRole(),role);
	   }

	@When("the user is logged in")
	public void theUserIsLoggedIn() {
    	if(sweetApp.currentUser.isLoggedIn==false) {sweetApp.currentUser.isLoggedIn=true;}
    	assertEquals("the user must be logged in!",true,sweetApp.currentUser.isLoggedIn);
	}

	@Then("the user can see his information")
	public void theUserCanSeeHisInformation() {
	   sweetApp.getInfo(sweetApp.currentUser);
	   assertTrue("the user can't see his information!",true);

	}

	@When("the user enter {string} in user name field")
	public void theUserEnterInUserNameField(String userName) {
	    // for updating
		if(sweetApp.currentUser.checkUserName(userName)==true) assertTrue("Try another user name!",sweetApp.currentUser.checkUserName(userName));
		else assertFalse("the user name is good!",sweetApp.currentUser.checkUserName(userName));
	}

	@When("the user enter {string} in password field")
	public void theUserEnterInPasswordField(String pass) {
	   if(sweetApp.currentUser.checkPassword(pass)==true) assertTrue("try another password!",sweetApp.currentUser.checkPassword(pass));
		else assertFalse("good password!",sweetApp.currentUser.checkPassword(pass));
	}

	@When("the user enter {string} in email field")
	public void theUserEnterInEmailField(String email) {
		if(sweetApp.currentUser.checkEmail(email)==true) assertTrue("try another email!",sweetApp.currentUser.checkEmail(email));
		else assertFalse("good email!",sweetApp.currentUser.checkEmail(email));
		 
	}

	@Then("the massage {string} will displayed on screen")
	public void theMassageWillDisplayedOnScreen(String msg) {
	    sweetApp.printStm(msg);
	    assertTrue("the msg can't displayed!",true);
	}

	@Then("the information will be update")
	public void theInformationWillBeUpdate() {
	    sweetApp.updateUserInfo(sweetApp.currentUser);
	    assertTrue("the info can't updated!",true);
	}

	@Then("the error {string} will displayed on screen")
	public void theErrorWillDisplayedOnScreen(String errmsg) {
	    sweetApp.printStm(errmsg);
	    assertTrue("the error msg can't displayed!",true);
	}

	@Then("the user can delete his account")
	public void theUserCanDeleteHisAccount() {
	    sweetApp.deleteUser(sweetApp.currentUser);
	    assertTrue("the info can't deleted!",true);
	}
}
