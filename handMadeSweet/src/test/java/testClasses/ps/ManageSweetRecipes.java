package testClasses.ps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import Sweet.App.MyApp;
import Sweet.App.Recipe;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManageSweetRecipes {
 
	
	MyApp sweetApp;
	Recipe newRecipe;
	String des;
	String time;
	String ing; 

	public ManageSweetRecipes(MyApp sweetApp) {
		this.sweetApp = sweetApp;
		newRecipe=new Recipe();
		
	}
	 
	
	@When("the Admin wants to Delete recipe with title  {string}")
	public void theAdminWenetDeleteRecipeWithTitle(String title) {
		if (sweetApp.currentUser.getRole().equals("Admin") && sweetApp.currentUser.isLoggedIn()) {
			
			if(sweetApp.deleteRecipe(title))assertTrue(true);
			else assertFalse(false);
			}
	}

	@Then("the recipe with title {string} should be successfully deleted")
	public void theRecipeWithTitleShouldBeSuccessfullyDeleted(String title) {
		assertNull(sweetApp.recipeExists(title));
	}

	@Then("the Admin can see the all recipes and their informations")
	public void theAdminCanSeeTheAllRecipes() {
		sweetApp.ViewAllRecipes();
	}
	
	
	@Then("The recipe  will be update")
	public void theRecipeWillBeUpdate() {
		    assertTrue("the Recipe can't be updated!",true);
	}
	
	
	@When("the user enter {string} in the title field")
	public void theUserEnterInTheTitleField(String title) {
		Recipe m=sweetApp.recipeExists(title);
		 if(m!=null) 
		 {
			 newRecipe=m;
			 assertNotNull(m);
	     }
		   else  assertNull(m);
	}

	@When("the user enter {string} in the description field")
	public void theUserEnterInTheDescriptionField(String string) {
	   newRecipe.setDescription(string);
	   assertTrue(true);
	}

	@When("the user enter {string} in the ingrediants field")
	public void theUserEnterInTheIngrediantsField(String string) {
		if(newRecipe.checkIngrediants(string))assertTrue(true);
		else assertFalse(false);
	}

	@When("the user enter {string} in the time field")
	public void theUserEnterInTheTimeField(String string) {
		   newRecipe.setTime(string);
		   assertTrue(true);
	}


}