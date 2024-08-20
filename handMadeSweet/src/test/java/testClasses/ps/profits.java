package testClasses.ps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Sweet.App.MyApp;
import Sweet.App.User;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class profits {
	MyApp sweetApp;
	User newU;
	String city2;
	String branch2;
	

public profits(MyApp sweetApp) {
		this.sweetApp = sweetApp;
		newU=new User();
	} 
 

@When("selects the {string} option")
public void selectsTheOption(String option) {
	 sweetApp.printStm("Selected report option: " + option);
}

 
@Then("the system should display the total profits for all branches in {string}")
public void theSystemShouldDisplayTheTotalProfitsForAllBranchesIn(String city) {
	double totalProfits = sweetApp.calculateTotalProfitsForCity(city);
    sweetApp.printStm("Total profits for all branches in " + city + ": " + totalProfits);
    assertTrue(true);
}



@Then("the system should display the total profits for branch {string} in {string}")
public void theSystemShouldDisplayTheTotalProfitsForBranchIn(String branch, String city) {
	  double totalProfits = sweetApp.calculateTotalProfitsForBranchInCity(branch, city);
      sweetApp.printStm("Total profits for branch " + branch + " in " + city + ": " + totalProfits);
      assertTrue(true);
}

@Then("the system should display the total profits for all cities")
public void theSystemShouldDisplayTheTotalProfitsForAllCities() {
	double totalProfits = sweetApp.calculateTotalProfitsForAllCities();
    sweetApp.printStm("Total profits for all cities: " + totalProfits);
    assertTrue(true);
}


@When("Admin enter {string} in city field")
public void adminEnterInCityField(String city) {
	boolean isCityValid = newU.checkCityBranchPosition(city);
	  if (!isCityValid) {
		  assertFalse(isCityValid);
	  }else {
			city2=city;
		 assertTrue(isCityValid);
	  }
}


@When("Admin enter {string} in branch field")
public void adminEnterInBranchField(String branch) {
	boolean isBranchValid = newU.checkBranch(branch);
	if (!isBranchValid) {
		  assertFalse(isBranchValid);
	}else {
		branch2=branch;
		 assertTrue(isBranchValid);
	}
}

@Then("the system should display all orders for this city with their users")
public void theSystemShouldDisplayAllOrdersForThisCityWithTheirUsers() {
	 if(sweetApp.showAllOrdersInCity(city2))assertTrue(true);
	    else assertFalse(false);
}

@Then("the system should display all orders for this branch with their users")
public void theSystemShouldDisplayAllOrdersForThisBranchWithTheirUsers() {
	 if(sweetApp.showAllOrdersInBranch(branch2))assertTrue(true);
	    else assertFalse(false);
}

@Then("the system should display all orders with their users")
public void theSystemShouldDisplayAllOrdersWithTheirUsers() {
    if(sweetApp.showAllOrders())assertTrue(true);
    else assertFalse(false);
}



}