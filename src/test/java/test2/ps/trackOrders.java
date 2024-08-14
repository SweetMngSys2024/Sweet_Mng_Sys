package test2.ps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import Sweet.App.MyApp;
import Sweet.App.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class trackOrders {


	MyApp sweetApp;
	User verifyUser;

	
	
	public trackOrders(MyApp sweetApp) {
		this.sweetApp = sweetApp;
	}

	
	@Given("the user role is {string} and the user name {string}")
	public void theUserRoleIsAndTheUserName(String role1, String userName1) {
		verifyUser=sweetApp.verifyIdentity(role1,userName1);
	    if(verifyUser==null)assertNull(verifyUser);
	    else assertNotNull(verifyUser);
	}

	@When("the orders list is not empty")
	public void theOrdersListIsNotEmpty() {
	    assertFalse("The orders list is empty!",MyApp.sellers.isEmpty());
	}

	@Then("the system should handle the orders with {string} status correctly")
	public void theSystemShouldHandleTheOrdersWithStatusCorrectly(String status) {
		boolean validStatus=false;
		if(verifyUser!=null) {
	     validStatus=sweetApp.handleOrderStatus(status,verifyUser.getBranch());}
		if(validStatus)assertTrue(validStatus);
		else assertFalse(validStatus);
	}

}
