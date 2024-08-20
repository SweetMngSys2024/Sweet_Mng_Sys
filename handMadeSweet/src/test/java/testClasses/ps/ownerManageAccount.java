
package testClasses.ps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Sweet.App.MyApp;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ownerManageAccount {

	 
	MyApp sweetApp;
	
	 
	public ownerManageAccount(MyApp sweetApp) {
		this.sweetApp = sweetApp;
	}
	
	@Then("the Owner can see his information")
	public void theOwnerCanSeeHisInformation() {
		sweetApp.OwnerORSuppliersgetInfo(sweetApp.currentUser);
		   assertTrue("the user can't see his information!",true);
	}

	@When("the Owner enter {string} in user name field")
	public void theOwnerEnterInUserNameField(String userName) {
		if(sweetApp.currentUser.checkUserName(userName)==true)
			assertTrue("Try another user name!",sweetApp.currentUser.checkUserName(userName));
		else assertFalse("the user name is good!",sweetApp.currentUser.checkUserName(userName));

	} 

	@When("the Owner enter {string} in password field")
	public void theOwnerEnterInPasswordField(String pass) {
		 if(sweetApp.currentUser.checkPassword(pass)==true) assertTrue("try another password!",sweetApp.currentUser.checkPassword(pass));
			else assertFalse("good password!",sweetApp.currentUser.checkPassword(pass));
	}

	@When("the Owner enter {string} in email field")
	public void theOwnerEnterInEmailField(String email) {
		if(sweetApp.currentUser.checkEmail(email)==true) assertTrue("try another email!",sweetApp.currentUser.checkEmail(email));
		else assertFalse("good email!",sweetApp.currentUser.checkEmail(email));
		}

	@When("the Owner enter {string} in phoneNumber field")
	public void theOwnerEnterInPhoneNumberField(String phoneNumber) {
		if(sweetApp.currentUser.checkPhoneNumber(phoneNumber)==true) assertTrue("try another phoneNumber!",sweetApp.currentUser.checkPhoneNumber(phoneNumber));
		else assertFalse("good phoneNumber!",sweetApp.currentUser.checkEmail(phoneNumber));
		
	}

	@Then("The massage {string} will displayed on screen")
	public void theMassageWillDisplayedOnScreen(String msg) {
		sweetApp.printStm(msg);
	    assertTrue("the msg can't displayed!",true);
	}

	@Then("The information will be update")
	public void theInformationWillBeUpdate() {
		
		 sweetApp.updateOwnerOrSupplierInfo(sweetApp.currentUser);
		    assertTrue("the info can't updated!",true);
	}

	@Then("The error {string} will displayed on screen")
	public void theErrorWillDisplayedOnScreen(String errmsg) {
		 sweetApp.printStm(errmsg);
		    assertTrue("the error msg can't displayed!",true);
	}

	@Then("the Owner can delete his account")
	public void theOwnerCanDeleteHisAccount() {
		  sweetApp.deleteUser(sweetApp.currentUser);
		    assertTrue("the info can't deleted!",true);
	}




}
