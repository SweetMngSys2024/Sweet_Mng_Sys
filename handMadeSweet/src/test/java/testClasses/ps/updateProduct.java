package testClasses.ps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import Sweet.App.MyApp;
import Sweet.App.User;
import Sweet.App.product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class updateProduct {
	MyApp sweetApp;
	User verifyUser;
	product  newProduct;

public updateProduct(MyApp sweetApp) {
		this.sweetApp = sweetApp;
	
	}


@Given("that the role of the user is {string} and his user name {string}")
public void thatTheRoleOfTheUserIsAndHisUserName(String role1, String userName1) {
	 verifyUser=sweetApp.verifyIdentity(role1,userName1);
	    if(verifyUser==null)assertNull(verifyUser);
	    else assertNotNull(verifyUser);
	   
}

@Given("he can see all products in his branch befor updating")
public void heCanSeeAllProductsInHisBranchBeforUpdating() {
	if(verifyUser!=null) {
	    sweetApp.showAllProductsInBranch(verifyUser.getBranch());
	    assertTrue(true);}
}

@When("he enter the product name {string} in the product name field")
public void heEnterTheProductNameInTheProductNameField(String prodName) {
	if(verifyUser!=null) {
		newProduct=sweetApp.findProductByName(prodName, verifyUser.getBranch());
	   if(newProduct==null)assertNull(newProduct);
	   else assertNotNull(newProduct);
	   }
	   
}

@When("he enter the description {string} in the description field")
public void heEnterTheDescriptionInTheDescriptionField(String string) {
	boolean validDescription= false;
	if(newProduct!=null) {
   validDescription=newProduct.checkValidDescription(string);}
  if(validDescription)assertTrue(true);
  else assertFalse(false);
}

@When("he enter the price {string} in the price field")
public void heEnterThePriceInThePriceField(String price2) {
	boolean validPrice= false;
	if(newProduct!=null) {
	 validPrice=newProduct.checkValidPrice(price2);}
    if(validPrice)assertTrue(true);
    else assertFalse(false);
}

@When("he enter the quantity {string} in the quantity field")
public void heEnterTheQuantityInTheQuantityField(String qnt2) {
	boolean validQnt= false;
	if(newProduct!=null) {
	  validQnt=newProduct.checkValidQnt(qnt2);}
	    if(validQnt)assertTrue(true);
	    else assertFalse(false);
}

@When("he enter the discount {string} in the discount field")
public void heEnterTheDiscountInTheDiscountField(String disc2) {
	boolean validDiscount= false;
	if(newProduct!=null) {
	  validDiscount=newProduct.checkValidDiscount(disc2);}
	    if(validDiscount)assertTrue(true);
	    else assertFalse(false);
}

@When("he enter the salesCount {string} in the salesCount field")
public void heEnterTheDiscountInTheSalesCountField(String salesCount) {
	boolean validSalesCount= false;
	if(newProduct!=null) {
	  validSalesCount=newProduct.checkValidSalesCount(salesCount);}
	    if(validSalesCount)assertTrue(true);
	    else assertFalse(false);
}

@When("he enter the supplier {string} in the supplier field")
public void heEnterTheSupplierInTheSupplierField(String supplierName) {
	 boolean validSupplierName=sweetApp.checkValidSupplierName(supplierName);
	    if(validSupplierName) {
	    	if(newProduct!=null) {newProduct.setSupplier(supplierName);}
	    	assertTrue(true);}
	    else assertFalse(false);
}


@Then("the product will be updated successfully to his branch")
public void theProductWillBeUpdatedSuccessfullyToHisBranch() {
    assertNotNull(newProduct);
  //  System.out.println("ghhhiiiiiiiiiiiiiiiiiiii  "+newProduct.toString());
  
}


}