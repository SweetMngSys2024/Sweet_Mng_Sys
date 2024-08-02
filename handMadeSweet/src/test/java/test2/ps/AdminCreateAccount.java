package test2.ps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Sweet.App.MyApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminCreateAccount {
 
	MyApp sweetApp;
	
	
	public AdminCreateAccount(MyApp sweetApp) {
		this.sweetApp = sweetApp;
	} 
 
@When("user enter {string} in role type  field")
public void userEnterInRoleTypeField(String roleType) {
	boolean role = sweetApp.currentUser.checkRoleType(roleType);
	if(role==true)assertTrue("check role type failed", role);
	else assertFalse("check role type passed", role);
	
}

@When("user enter {string} in branch field")
public void userEnterInBranchField(String Branch) {
	boolean branch = sweetApp.currentUser.checkRoleType(Branch);
	if(branch==true)assertTrue("check Branch failed", branch);
	else assertFalse("check Branch passed", branch);
}

@When("user enter {string} in city field")
public void userEnterInCityField(String city2) {
	boolean city = sweetApp.currentUser.checkRoleType(city2);
	if(city==true)assertTrue("check city failed", city);
	else assertFalse("check city passed", city);
}



@When("user enters {string} as branch and {string} as city")
public void userEntersAsBranchAndAsCity(String branch, String city) {
	sweetApp.currentUser.setBranch(branch);
	sweetApp.currentUser.setCity(city);
}

@Then("the branch should be valid for the city")
public void theBranchShouldBeValidForTheCity() {
	String string1=sweetApp.currentUser.getBranch();
	String string2=sweetApp.currentUser.getCity();
	boolean branchInCity = sweetApp.VerifyBranchInCity(string1, string2);
	assertTrue("Branch " + string1 + " should be in city " + string2, branchInCity);
}



}
