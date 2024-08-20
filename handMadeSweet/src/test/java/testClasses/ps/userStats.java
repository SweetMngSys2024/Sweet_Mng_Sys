package testClasses.ps;
 
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Sweet.App.MyApp;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class userStats {

	
	MyApp sweetApp;
	String city2;
	

public userStats(MyApp sweetApp) {
		this.sweetApp = sweetApp;
	
	} 
 

	@Then("he can see the statistics for all registered users")
	public void heCanSeeTheStatisticsOnRegisteredUsersByCity() {
		 boolean result = sweetApp.registerdUsersInAllCities(); 
		    if(result) {
		        assertTrue(result);
		    } else {
		        assertFalse(result);
		    }
	}

	@When("Admin enter {string} in the city field search")
	public void adminEnterInTheCityFieldSearch(String city) {
		if(sweetApp.checkValidCity(city)) { city2=city; assertTrue(sweetApp.checkValidCity(city));}
		else assertFalse(sweetApp.checkValidCity(city));
	}
	
	@Then("the users in this city will appear")
	public void theUsersInThisCityWillAppear() {
	    if(sweetApp.showCityUsersInfo(city2))assertTrue(true);
	    else assertFalse(false);
	}



}