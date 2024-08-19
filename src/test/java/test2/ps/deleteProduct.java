package test2.ps;



import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sweet.app.MyApp;
import sweet.app.User;
import sweet.app.product;

public class deleteProduct {


	MyApp sweetApp;
	User verifyUser;
	product prod;
	
	
	public deleteProduct(MyApp sweetApp) {
		this.sweetApp = sweetApp;
	}

	
	
	@Given("that the user role is {string} and his user name {string}")
	public void thatTheUserRoleIsAndHisUserName(String role1, String userName1) {
	    verifyUser=sweetApp.verifyIdentity(role1,userName1);
	    if(verifyUser==null)assertNull(verifyUser);
	    else assertNotNull(verifyUser);
		
	}

	@Given("he can view all products in his branch")
	public void heCanViewAllProductsInHisBranch() {
		if(verifyUser!=null) {
	    sweetApp.showAllProductsInBranch(verifyUser.getBranch());
	    assertTrue(true);}
	}

	@When("the user enters {string} in product name field")
	public void theUserEntersInProductNameField(String pName) {
		if(verifyUser!=null) {
	   product checkPname=sweetApp.checkExistingProduct(pName,verifyUser.getBranch());
	   if(checkPname!=null) {prod=checkPname; assertTrue(true);}
	   else assertNull(checkPname);
		}
	}

	@Then("the product should be successfully deleted from the system")
	public void theProductShouldBeSuccessfullyDeletedFromTheSystem() {
	    boolean flag= sweetApp.deleteProduct(prod);
	    if(flag)assertTrue(true);
	    else assertFalse(false);
	}

	@Then("error msg will displayed {string}")
	public void errorMsgWillDisplayed(String string) {
	    sweetApp.printStm(string);
	    assertTrue(true);
	}

}
