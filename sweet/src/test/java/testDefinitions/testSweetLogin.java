package testDefinitions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import MyApp2024_Sweet.ClassMy_App;
import MyApp2024_Sweet.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class testSweetLogin {

    ClassMy_App myApp;

    public testSweetLogin(ClassMy_App myApp) {
        super();
        this.myApp = myApp;
    }
    

    
    

    @Given("user is not in the sweet system")
    public void userIsNotInTheSweetSystem() {
        assertFalse(myApp.is_loged_in);
    }

    @When("user logs in with username {string} and password {string} and role {string} logs in")
    public void userLogsInWithUsernameAndPasswordAndRoleLogsIn(String username, String password, String role) {
        if (username.isEmpty() || password.isEmpty()) {
            
            myApp.is_loged_in = false;
        } else {
            myApp.is_loged_in = myApp.authenticateUser(username, password, role);
        }
    }

    @Then("the login result should be {string}")
    public void theLoginResultShouldBe(String expectedResult) {
        if (expectedResult.equals("logged_in")) {
            assertTrue(myApp.is_loged_in);
        } else if (expectedResult.equals("failed_login_password")) {
            assertFalse(myApp.is_loged_in);
        } else if (expectedResult.equals("failed_login_username")) {
            assertFalse(myApp.is_loged_in);
        }
    }

    @Then("an error message should appear {string}")
    public void anErrorMessageShouldAppear(String errorMessage) {
       
        if (errorMessage.equals("please enter your username")) {
        	assertFalse(myApp.is_loged_in);
        } else if (errorMessage.equals("please enter your password")) {
        	assertFalse(myApp.is_loged_in);
        }
    }

 
}
