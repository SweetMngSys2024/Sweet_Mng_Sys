package test2.ps;

import Sweet.App.MyApp;
import io.cucumber.java.en.Then;

public class userStats {

	
	MyApp sweetApp;
	

public userStats(MyApp sweetApp) {
		this.sweetApp = sweetApp;
	
	} 
 

@Then("The number of registered users in city {string} should be displayed.")
public void theNumberOfRegisteredUsersInCityShouldBeDisplayed(String city) {
	int Ucount = sweetApp.countUsersInCity(city);
    sweetApp.printStm("count Users In " + city + ": " + Ucount);
}




@Then("The number of registered users in branch {string} in city {string} should be displayed.")
public void theNumberOfRegisteredUsersInInShouldBeDisplayed(String branch, String city) {
	 int Ucount = sweetApp.countUsersInBranchInCity(branch, city);
     sweetApp.printStm("count Users In " + branch + " in " + city + ": " + Ucount);
     
}



@Then("The number of registered users in all cities should be displayed..")
public void theNumberOfRegisteredUsersInAllCitiesShouldBeDisplayed() {
	int Ucount = sweetApp.countUsersInAllCities();
    sweetApp.printStm("count Users for all cities: " + Ucount);
}







}
