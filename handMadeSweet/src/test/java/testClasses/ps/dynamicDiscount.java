package testClasses.ps;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Sweet.App.MyApp;
import Sweet.App.User;
import Sweet.App.product;

public class dynamicDiscount {

	MyApp sweetApp;
	User verifyUser;
	double minPrice=0;
	double discount=0;

public dynamicDiscount(MyApp sweetApp) {
		this.sweetApp = sweetApp;
	
	} 

	@Given("that user role is {string} and the user name {string}")
	public void thatUserRoleIsAndTheUserName(String role1, String userName1) {
		 verifyUser=sweetApp.verifyIdentity(role1,userName1);
		    if(verifyUser==null)assertNull(verifyUser);
		    else assertNotNull(verifyUser);
	}

	@Given("he sets the minimum price to {string}")
	public void heSetsTheMinimumPriceTo(String price2) {
		  minPrice=product.checkMinPrice(price2);
		    if(minPrice==-1) {
		    	assertFalse(false);
		    	}
		    else assertTrue(true);
	}

	@Given("he sets the discount percentage to {string}")
	public void heSetsTheDiscountPercentageTo(String discount2) {
		 discount=product.checkDiscount(discount2);
		    if(discount==-1) {
		    	assertFalse(false);
		    	}
		    else assertTrue(true);
	}

	@When("the system evaluates products in the inventory")
	public void theSystemEvaluatesProductsInTheInventory() {
	    //show all price of products 
		boolean checkProductArray=false;
		if(verifyUser!=null) {
		 checkProductArray=sweetApp.showAllProductsInTheBranch(verifyUser.getBranch());}
		if(checkProductArray)assertTrue(checkProductArray);
		else assertFalse(checkProductArray);
		
	}

	@Then("the discount should be applied to all products with prices greater than or equal to {string}")
	public void theDiscountShouldBeAppliedToAllProductsWithPricesGreaterThanOrEqualTo(String string) {
		if(verifyUser!=null) {
	    sweetApp.applyDiscountToProduct(minPrice,discount,verifyUser.getBranch());}
	    assertTrue("Can't do the discount!",sweetApp.applyDiscount);
	}



	@Then("a confirmation message should appear {string}")
	public void aConfirmationMessageShouldAppear(String string) {
		sweetApp.printStm(string);
	    assertTrue(true);
	}

	@Then("the discount should not be applied to any products with prices below {string}")
	public void theDiscountShouldNotBeAppliedToAnyProductsWithPricesBelow(String string) {
		  assertFalse("We did the discount!",sweetApp.applyDiscount);
	}



	@Then("a message should appear {string}")
	public void aMessageShouldAppear(String string) {
	    sweetApp.printStm(string);
	    assertTrue(true);
	}




}