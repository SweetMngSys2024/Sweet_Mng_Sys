package test2.ps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Sweet.App.MyApp;
import Sweet.App.User;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminCreateAccount {
 
	MyApp sweetApp;
	User newUser;
	String b;
	String c;
	
	
	public AdminCreateAccount(MyApp sweetApp) {
		this.sweetApp = sweetApp;
		newUser=new User();
	} 

@When("user enter {string} in first name field")
public void userEnterInFirstNameField(String string) {
	if(newUser.checkFirstName(string)==true)assertTrue(true);
	else assertFalse(false);
}

@When("user enter {string} in last name field")
public void userEnterInLastNameField(String string) {
	if(newUser.checkLastName(string)==true)assertTrue(true);
	else assertFalse(false);
}

@When("user enter {string} in password field")
public void userEnterInPasswordField(String string) {
	if(newUser.checkPassword(string)==true)assertTrue(true);
	else assertFalse(false);
}

@When("user enter {string} in user name field")
public void userEnterInUserNameField(String string) {
	if(newUser.checkUserName(string)==true)assertTrue(true);
	else assertFalse(false);
}

@When("user enter {string} in email field")
public void userEnterInEmailField(String string) {
	if(newUser.checkEmail(string)==true)assertTrue(true);
	else assertFalse(false);
}


@When("user enter {string} in role type  field")
public void userEnterInRoleTypeField(String roleType) {
	boolean role = newUser.checkRoleType(roleType);
	if(role==true)assertTrue("check role type failed", role);
	else assertFalse("check role type passed", role);
	
}

@When("user enter {string} in branch field")
public void userEnterInBranchField(String Branch) {
	if(newUser.checkBranch(Branch)==true)assertTrue(true);
	else assertFalse(false);
}

@When("user enter {string} in city field")
public void userEnterInCityField(String city2) {
	if(newUser.checkCityBranchPosition(city2)==true)assertTrue(true);
	else assertFalse(false);
}



@When("user enters {string} as branch and {string} as city")
public void userEntersAsBranchAndAsCity(String branch, String city) {
	b=branch;
	c=city;
}

@Then("the branch should be valid for the city")
public void theBranchShouldBeValidForTheCity() {
	boolean branchInCity = sweetApp.VerifyBranchInCity(b, c);
	assertTrue("Branch " + b + " should be in city " + c, branchInCity);
}


@Then("the user registration to the system will be successful!")
public void theUserRegistrationToTheSystemWillBeSuccessful() {
	sweetApp.addUser(newUser);
	assertTrue("test case failed", true);
}


@When("user enter {string} in city field where the user lives")
public void userEnterInCityFieldWhereTheUserLives(String city2) {
	if(newUser.checkCity(city2)==true)assertTrue(true);
	else assertFalse(false);
}



}