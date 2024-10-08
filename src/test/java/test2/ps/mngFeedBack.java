package test2.ps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sweet.app.MyApp;
 
public class mngFeedBack {
	MyApp sweetApp; 
	

	public mngFeedBack(MyApp sweetApp) {
		this.sweetApp = sweetApp;
	}
	
	@Then("the Admin can see all feedback")
	public void theAdminCanSeeAllFeedback() {
		if(sweetApp.ViewAllFeedBack())assertTrue(sweetApp.ViewAllFeedBack());
		assertFalse(sweetApp.ViewAllFeedBack());
	}

	@When("the Admin wants to delete feedback with username {string} on product {string}")
	public void theAdminWantsToDeleteFeedbackWithUsernameOnProduct(String username, String product) {
		if (sweetApp.currentUser.getRole().equals("Admin") && sweetApp.currentUser.isLoggedIn) {
			 sweetApp.deleteFeedBack(username,product);
		}
	}
 
	@Then("the feedback with username {string} on product {string} should be successfully deleted")
	public void theFeedbackWithUsernameOnProductShouldBeSuccessfullyDeleted(String username, String product) {
		 assertFalse(sweetApp.FeedBackExists(username,product));
	}


}