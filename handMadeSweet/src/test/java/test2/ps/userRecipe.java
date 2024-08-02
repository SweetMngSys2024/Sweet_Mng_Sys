package test2.ps;
 
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Sweet.App.MyApp;
import Sweet.App.Recipe;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class userRecipe {

	MyApp sweetApp;
	Recipe newRecipe;

	public userRecipe(MyApp sweetApp) {
		this.sweetApp = sweetApp;
		newRecipe=new Recipe();
		
	}
	 

@When("the user enter {string} in title field")
public void theUserEnterInTitleField(String newtitle) {
   if(newRecipe.checkTitle(newtitle)==true)assertTrue(newRecipe.checkTitle(newtitle));
   else assertFalse(newRecipe.checkTitle(newtitle));
}
@When("the user enter {string} in user name field in share recipe page")
public void theUserEnterInUserNameFieldInShareRecipePage(String uname) {
	 if(newRecipe.checkUserName(uname)==true)assertTrue(newRecipe.checkUserName(uname));
	   else assertFalse(newRecipe.checkUserName(uname));
}

@When("the user enter {string} in description field")
public void theUserEnterInDescriptionField(String desc) {
   newRecipe.setDescription(desc);
}

@When("the user enter {string} in ingrediants field")
public void theUserEnterInIngrediantsField(String newingrediants) {
	  if(newRecipe.checkIngrediants(newingrediants)==true)assertTrue(newRecipe.checkIngrediants(newingrediants));
	   else assertFalse(newRecipe.checkIngrediants(newingrediants));
}

@When("the user enter {string} in time field")
public void theUserEnterInTimeField(String newtime) {
	  newRecipe.setTime(newtime);
}

@When("the user enter {string} in type field")
public void theUserEnterInTypeField(String type) {
   
    if( newRecipe.checkType(type)==true)assertTrue(true);
	else assertFalse( newRecipe.checkType(type));
}


@Then("the recipe will be added successfully")
public void theRecipeWillBeAddedSuccessfully() {
    sweetApp.addRecipe(newRecipe);
}


	
	
}