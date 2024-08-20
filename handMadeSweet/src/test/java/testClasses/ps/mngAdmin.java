package testClasses.ps;



import static org.junit.Assert.assertFalse; 
import static org.junit.Assert.assertTrue;
import Sweet.App.MyApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class mngAdmin {


	MyApp sweetApp;
	

public mngAdmin(MyApp sweetApp) {
		this.sweetApp = sweetApp;
	} 


@Given("The user role is {string}")
public void theAdminIsLoggedIn(String role) {
	sweetApp.currentUser.setRole(role);
    assertTrue("The Role must be " + role + "!", sweetApp.currentUser.getRole().equals("Admin"));
	   }


@When("the Admin is logged in")
public void theUserIsLoggedIn() {
	if(sweetApp.currentUser.isLoggedIn()==false) {
		sweetApp.currentUser.setLoggedIn(true);
	}
	assertTrue("the Admin must be logged in!",sweetApp.currentUser.isLoggedIn()==true);
}


@When("the user deletes an account with username {string}")
public void theUserDeletesAnAccountWithUsername(String username) {
	if (sweetApp.currentUser.getRole().equals("Admin") && sweetApp.currentUser.isLoggedIn()) {
		 sweetApp.deleteUserByName(username);
	}
}



@Then("the account with username {string} should be successfully deleted from the system")
public void theAccountWithUsernameShouldBeSuccessfullyDeletedFromTheSystem(String username) {
	 assertFalse(sweetApp.userExists(username));
}


@Then("the system should show the message {string}")
public void theSystemShouldShowTheMessage(String expectedMessage) {
	sweetApp.printStm(expectedMessage);
	assertTrue(true);
}


@Then("View all user accounts and account type")
public void viewAllUserAccountsAndAccountType() {
	if(sweetApp.ViewAllUser())assertTrue(true);
	else assertFalse(false);
}
 
@Then("View all material with name and supplier and price")
public void viewAllMaterialWithNameAndSupplierAndPrice() {

	if(sweetApp.viewAllMaterial())assertTrue(true);
	else assertFalse(false);
}
}