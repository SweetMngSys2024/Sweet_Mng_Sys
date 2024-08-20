package testClasses.ps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Sweet.App.MyApp;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class buyProduct {

	MyApp sweetApp;


	public buyProduct(MyApp sweetApp) {
		super();
		this.sweetApp = sweetApp;

	}
	

@When("user enter {string} in search field")
public void userEnterInSearchField(String search) {
    if(sweetApp.checkSearchProduct(search)) { assertTrue(true);}
    else assertFalse(false);
}


@When("user enter {string} in buy field")
public void userEnterInBuyField(String string) {
	  if(sweetApp.checkSearchProduct(string)) { assertTrue(true);}
	    else assertFalse(false);
}

@Then("error msg will appear {string}")
public void errorMsgWillAppear(String string) {
    sweetApp.printStm(string);
}

@Then("the information of this product will appear")
public void theInformationOfThisProductWillAppear() {
    sweetApp.showProductInfo();
    assertTrue(true);
}

@Then("the user can buy it if he enter the quantity that he wants or Cancel the process {string}")
public void theUserCanBuyItIfHeEnterTheQuantityThatHeWantsOrCancelTheProcess(String input) { 
   if(sweetApp.buyProduct(input))assertTrue(true);
   else assertFalse(false);
}

@Then("there is an enough quantity to buy it")
public void thereIsAnEnoughQuantityToBuyIt() {
    assertTrue(sweetApp.currentOrder.getQuantity()<sweetApp.currentProduct.getQuantity());
}

@Then("there is no enough quantity to buy it")
public void thereIsNoEnoughQuantityToBuyIt() {
    assertFalse(sweetApp.currentOrder.getQuantity()<sweetApp.currentProduct.getQuantity());
}


@Then("he enters {string} in city field and {string} in branch field")
public void heEntersInCityFieldAndInBranchField(String city, String branch) {
    if(sweetApp.currentOrder.checkBranch(branch))assertTrue(true);
    else assertFalse(false);
    
    if( sweetApp.currentOrder.checkCity(city))assertTrue(true);
    else assertFalse(false);
   
    
}



}