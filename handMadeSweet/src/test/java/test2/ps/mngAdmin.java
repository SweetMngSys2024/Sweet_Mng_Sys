package test2.ps;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse; 
import static org.junit.Assert.assertTrue;

import java.util.List;

import Sweet.App.MyApp;
import Sweet.App.RawMaterial;
import Sweet.App.User;
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
	if(sweetApp.currentUser.isLoggedIn==false) {
		sweetApp.currentUser.isLoggedIn=true;
	}
	assertTrue("the Admin must be logged in!",sweetApp.currentUser.isLoggedIn==true);
}


@When("the user deletes an account with username {string}")
public void theUserDeletesAnAccountWithUsername(String username) {
	if (sweetApp.currentUser.getRole().equals("Admin") && sweetApp.currentUser.isLoggedIn) {
		 sweetApp.deleteUserByName(username);
	}
}



@Then("the  account with username {string} should be successfully deleted from the system")
public void theAccountWithUsernameShouldBeSuccessfullyDeletedFromTheSystem(String username) {
	 assertFalse(sweetApp.userExists(username));
}
@When("the admin tries to delete an account that does not exist")
public void theAdminTriesToDeleteAnAccountThatDoesNotExist() {
	sweetApp.deleteUserByName("nonexistentUser");
	

}
@Then("the system should show the message {string}")
public void theSystemShouldShowTheMessage(String expectedMessage) {
	String actualMessage = sweetApp.getErrorMessage();
    assertTrue("Error message should match the expected message.",
               expectedMessage.equals(actualMessage));
}


@Then("View all user accounts and account type")
public void viewAllUserAccountsAndAccountType() {
	sweetApp.ViewAllUser();
}
 
@Then("View all material with name and supplier and price")
public void viewAllMaterialWithNameAndSupplierAndPrice() {
	sweetApp.viewAllMaterial();
}
}
