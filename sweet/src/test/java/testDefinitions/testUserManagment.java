package testDefinitions;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import MyApp2024_Sweet.ClassMy_App;
import MyApp2024_Sweet.RawMaterial;
import MyApp2024_Sweet.Store;
import MyApp2024_Sweet.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class testUserManagment {
	
	ClassMy_App myApp;
	

	public testUserManagment(ClassMy_App myApp) {
		super();
		this.myApp = myApp;
	}
 
    
	@Given("the admin is on the account management page")
	public void theAdminIsOnTheAccountManagementPage() {
	    assertTrue(myApp.account_management_page);
	}

	   @When("the admin clicks on {string}")
	    public void theAdminClicksOn(String action) {
	        performAction(action);
	    }

	    private void performAction(String action) {
	        if (action.equals("Create an account")) {
	        	myApp.clickCreateAccount=true;
	        } else if (action.equals("Delete an account")) {
	        	myApp.clickDeleteAccount=true;
	        } else if (action.equals("View Account")) {
	        	myApp.clickViewAccount=true;
	        } else if (action.equals("View store names")) {
	        	myApp.clickViewStoreNames=true;
	        } else if (action.equals("View raw materials")) {
	        	myApp.clickViewRawMaterials=true;
	        }
	    }

	    @Then("the admin should be on the {string} page")
	    public void theAdminShouldBeOnThePage(String pageName) {
	        verifyPage(pageName);
	    }

	    private void verifyPage(String pageName) {
	        if (pageName.equals("Create an account")) {
	            assertTrue(myApp.clickCreateAccount);
	        } else if (pageName.equals("Delete an account")) {
	            assertTrue(myApp.clickDeleteAccount);
	        } else if (pageName.equals("View Account")) {
	            assertTrue(myApp.clickViewAccount);
	        } else if (pageName.equals("View store names")) {
	            assertTrue(myApp.clickViewStoreNames);
	        } else if (pageName.equals("View raw materials")) {
	            assertTrue(myApp.clickViewRawMaterials);
	        } 
	    }
	    
	    
	    
	    @Then("the account with username {string} and type {string} should be displayed")
	    public void theAccountWithUsernameAndTypeShouldBeDisplayed(String username, String accountType) {
	        List<User> displayedAccounts = ClassMy_App.getList_users();
	        boolean isAccountDisplayed = displayedAccounts.stream()
	            .anyMatch(user -> user.getUsername().equals(username) && user.getRole().equals(accountType));
	        assertTrue("The account with username " + username + " and type " + accountType + " should be displayed.",
	                   isAccountDisplayed);
	    }
	    
	    
	        
	    @Then("the store with name {string}, city {string}, and owner {string} should be displayed")
	    public void theStoreWithNameCityAndOwnerShouldBeDisplayed(String storeName, String city, String owner) {
	        List<Store> displayedStores = ClassMy_App.getList_stores();
	        boolean isStoreDisplayed = displayedStores.stream()
	            .anyMatch(store -> store.getStoreName().equals(storeName) && 
	                                store.getCity().equals(city) && 
	                                store.getOwnerUsername().equals(owner));
	        assertTrue("The store with name " + storeName + ", city " + city + ", and owner " + owner + " should be displayed.",
	                   isStoreDisplayed);
	    }
	    
	    
	    @Then("the raw material with name {string}, and supplier {string} should be displayed")
	    public void theRawMaterialWithNameAndSupplierShouldBeDisplayed(String materialName, String supplier) {
	        List<RawMaterial> displayedMaterials = ClassMy_App.getList_rawMaterials();
	        boolean isMaterialDisplayed = displayedMaterials.stream()
	            .anyMatch(material -> material.getMaterialName().equals(materialName) && 
	                                  material.getSupplierUsername().equals(supplier));
	        assertTrue("The raw material with name " + materialName + " and supplier " + supplier + " should be displayed.",
	                   isMaterialDisplayed);
	    }
	} 
