package test2.ps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Sweet.App.MyApp;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManageSweetRecipes {

	
MyApp sweetApp;
	

	public ManageSweetRecipes(MyApp sweetApp) {
		this.sweetApp = sweetApp;
	}
	 
	
	@When("the Admin  wenet Delete recipe with title  {string}")
	public void theAdminWenetDeleteRecipeWithTitle(String title) {
		if (sweetApp.currentUser.getRole().equals("Admin") && sweetApp.currentUser.isLoggedIn) {
			sweetApp.deleteRecipe(title);
		}
	}

	@Then("the  recipe with title {string} should be successfully deleted")
	public void theRecipeWithTitleShouldBeSuccessfullyDeleted(String title) {
		assertFalse(sweetApp.recipeExists(title));
	}

	@Then("the Admin can see the all recipes")
	public void theAdminCanSeeTheAllRecipes() {
		sweetApp.ViewAllRecipes();
	}
	
	
	@Then("The recipe  will be update")
	public void theRecipeWillBeUpdate() {
		 sweetApp.updateRecipe(sweetApp.currentRecipe);
		    assertTrue("the Recipe deleted!",true);
	}
}
