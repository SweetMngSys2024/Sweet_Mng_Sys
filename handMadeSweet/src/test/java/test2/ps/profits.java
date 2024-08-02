package test2.ps;

import Sweet.App.MyApp;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class profits {
	MyApp sweetApp;
	

public profits(MyApp sweetApp) {
		this.sweetApp = sweetApp;
	} 


@When("selects the {string} option")
public void selectsTheOption(String option) {
	 sweetApp.printStm("Selected report option: " + option);
}

 

@When("Admin enter {string} in the city field")
public void adminEnterInTheCityField(String city) {
	boolean isCityValid = sweetApp.currentUser.checkCity(city);
	  if (!isCityValid) {
		  sweetApp.printStm("City " + city + " is valid and set.");
	  }else {
		
		  sweetApp.printStm("City " + city + " is invalid.");
	  }
}

@When("Admin enter {string} in the Branch field")
public void adminEnterInTheBranchField(String branch) {
boolean isBranchValid = sweetApp.currentUser.checkBranch(branch);
    
    if (isBranchValid) {
    	sweetApp.printStm("Branch " + branch + " is valid and set.");
    } else {
    	sweetApp.printStm("Branch " + branch + " is invalid.");
    }
}



@Then("the system should display the total profits for all branches in {string}")
public void theSystemShouldDisplayTheTotalProfitsForAllBranchesIn(String city) {
	double totalProfits = sweetApp.calculateTotalProfitsForCity(city);
    sweetApp.printStm("Total profits for all branches in " + city + ": " + totalProfits);
}



@Then("the system should display the total profits for branch {string} in {string}")
public void theSystemShouldDisplayTheTotalProfitsForBranchIn(String branch, String city) {
	  double totalProfits = sweetApp.calculateTotalProfitsForBranchInCity(branch, city);
      sweetApp.printStm("Total profits for branch " + branch + " in " + city + ": " + totalProfits);
}

@Then("the system should display the total profits for all cities")
public void theSystemShouldDisplayTheTotalProfitsForAllCities() {
	double totalProfits = sweetApp.calculateTotalProfitsForAllCities();
    sweetApp.printStm("Total profits for all cities: " + totalProfits);
}




}
