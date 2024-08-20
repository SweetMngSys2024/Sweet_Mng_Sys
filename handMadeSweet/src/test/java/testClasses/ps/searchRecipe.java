package testClasses.ps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Sweet.App.MyApp;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchRecipe {

	MyApp sweetApp;

public searchRecipe(MyApp sweetApp) {
		super();
		this.sweetApp = sweetApp;
	}

@When("user enter {string} in the search filed")
public void userEnterInTheSearchFiled(String search) {
   if(sweetApp.checkSearchField(search))assertTrue( sweetApp.checkSearchField(search));
   else assertFalse(sweetApp.checkSearchField(search));
}

@Then("the information of these recipe will displayed")
public void theInformationOfTheseRecipeWillDisplayed() {
    sweetApp.displayRecipeInfo();
}

@Then("this {string} will be displayed")
public void thisWillBeDisplayed(String string) {
   sweetApp.printStm(string);
}


}