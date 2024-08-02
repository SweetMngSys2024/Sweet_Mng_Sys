package test2.ps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Sweet.App.MyApp;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class filterRecipe {
	
	MyApp sweetApp;
	String filterOption;
	

	public filterRecipe(MyApp sweetApp) {
		super();
		this.sweetApp = sweetApp;
	}

	@When("user enter {string}")
	public void userEnter(String choice) {
	   if(sweetApp.checkFilterOption(choice)) {filterOption=choice; assertTrue(true);}
	   else assertFalse(false);
	}
	

	@Then("this {string} will displayed")
	public void thisWillDisplayed(String string) {
	    sweetApp.printStm(string);
	}

	@Then("all recipes of this type will displayed")
	public void allRecipesOfThisTypeWillDisplayed() {
	    sweetApp.showAllFilterdRecipes(filterOption);	}


}