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

public class addProduct {
	MyApp sweetApp;
	User verifyUser;
	product  newProduct;

public addProduct(MyApp sweetApp) {
		this.sweetApp = sweetApp;
		newProduct=new product();
	} 

@Given("that the user role is {string} and the user name {string}")
public void thatTheUserRoleIsAndTheUserName(String role1, String userName1) {
	 verifyUser=sweetApp.verifyIdentity(role1,userName1);
	    if(verifyUser==null)assertNull(verifyUser);
	    else assertNotNull(verifyUser);
}

@When("he enter the product name {string} in product name field")
public void heEnterTheProductNameInProductNameField(String prodName) {
	if(verifyUser!=null) {
    boolean validProductName=sweetApp.checkValidProductName(prodName, verifyUser.getBranch());
    if(validProductName) {
    	newProduct.setpName(prodName);
    	assertTrue(true);
    	}
    else assertFalse(false);
    }
}

@When("he enter the description {string} in description field")
public void heEnterTheDescriptionInDescriptionField(String string) {
    newProduct.setDescription(string);
    assertTrue(true);
}

@When("he enter the price {string} in price field")
public void heEnterThePriceInPriceField(String price2) {
    boolean validPrice=newProduct.checkValidPrice(price2);
    if(validPrice)assertTrue(true);
    else assertFalse(false);
}

@When("he enter the quantity {string} in quantity field")
public void heEnterTheQuantityInQuantityField(String qnt2) {
	  boolean validQnt=newProduct.checkValidQnt(qnt2);
	    if(validQnt)assertTrue(true);
	    else assertFalse(false);
}


@When("he enter the discount {string} in discount field")
public void heEnterTheDiscountInDiscountField(String disc2) {
	 boolean validDiscount=newProduct.checkValidDiscount(disc2);
	    if(validDiscount)assertTrue(true);
	    else assertFalse(false);
}


@Then("the product will be added successfully to his branch")
public void theProductWillBeAddedSuccessfullyToHisBranch() {
	if(verifyUser!=null) {
	newProduct.setBranchName(verifyUser.getBranch());
	newProduct.setSupplier(verifyUser.getUserName());
    boolean flag=sweetApp.addNewProduct(newProduct);
    if(flag)assertTrue(flag);
    else assertFalse(flag);}
}


}
