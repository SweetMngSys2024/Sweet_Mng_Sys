package test2.ps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sweet.app.MyApp;
import sweet.app.product;

public class ownerMonetorSalesTest {
	MyApp sweetApp;
	private String branch;
	private String productBranchName;
	private String bestSellingBranchName;
	 
	public ownerMonetorSalesTest (MyApp sweetApp) {
		this.sweetApp = sweetApp;
	} 
	
	
	@Given("The User role is {string}")
	public void theUserRoleIs(String role) {
		sweetApp.currentUser.setRole(role);
		boolean isOwner= sweetApp.currentUser.checkRoleType(role);
		System.out.println("Checking if user is owner: " + isOwner);
		assertEquals(true, isOwner);
	}

	

	@When("The Owner  is logged in")
	public void theOwnerIsLoggedIn() {
		if(sweetApp.currentUser.isLoggedIn==false) {
			sweetApp.currentUser.isLoggedIn=true;
		}
		System.out.println("the owner must be logged in!");
		assertEquals(true, sweetApp.currentUser.isLoggedIn);
	
	}


	@When("The {string} searches for the total sales and profits in the branch it manages")
	public void theSearchesForTheTotalSalesAndProfitsInTheBranchItManages(String owner) {
		 branch = sweetApp.getBranchOwner(owner);
		assertTrue("the branch dose not exisit!", branch != "");

	}

	@Then("the system should display the total sales and profits in this branch")
	public void theSystemShouldDisplayTheTotalSalesAndProfitsInThisBranch() {
		int expectedTotalSales = 30;    
	    double expectedProfits = 25.96; 
	    
	    double actualProfits = sweetApp.ProfitsOfBranch(branch);
	    int actualTotalSales = sweetApp.TotalSales(branch);
	    
	   assertEquals("The total sales do not match the expected value.", expectedTotalSales, actualTotalSales);
	   assertEquals("The profits do not match the expected value.", expectedProfits, actualProfits);
	}
	

	@When("The {string} searches for the total sales and profits in the branch it manages for a  product {string}")
	public void theSearchesForTheTotalSalesAndProfitsInTheBranchItManagesForAProduct(String owner, String product) {
		boolean productExistsInBranch = sweetApp.isProductAvailableInBranch(owner,product);
		assertTrue("Please enter available products!", productExistsInBranch);
		productBranchName = sweetApp.getBranchOwner(owner);
	}

	@Then("the system should display the total sales and profits in this branch for a specific product {string}")
	public void theSystemShouldDisplayTheTotalSalesAndProfitsInThisBranchForASpecificProduct(String product) {
		
		int expectedSalesProduct = 30;    
		double expectedProfitsProduct = 13.98;

		double actualProfitsProduct = sweetApp.ProfitsOfProduct(product,productBranchName);
		int actualSalesProduct = sweetApp.SalesOfProduct(product,productBranchName);

		assertEquals("The sales do not match the expected value.", expectedSalesProduct, actualSalesProduct);
		assertEquals("The profits do not match the expected value.", expectedProfitsProduct, actualProfitsProduct, 0.01); // تحديد قيمة الخطأ المسموح بها

	}

	@When("The {string} searches for the best-selling products")
	public void theSearchesForTheBestSellingProducts(String owner) {
		bestSellingBranchName=sweetApp.getBranchOwner(owner);
		  assertTrue("the branch dose not exisit!",bestSellingBranchName != "");
	}

	@Then("the system should should be displayed as the best-selling product  in this branch")
	public void theSystemShouldShouldBeDisplayedAsTheBestSellingProductInThisBranch() {
		 List<product> topThreeProducts = sweetApp.GetTopBestThreeProducts(bestSellingBranchName);

		    for (product product : topThreeProducts) {
		        System.out.println("Product Name: " + product.getpName());
		        System.out.println("Sales: " + product.getSalesCount());
		    }

		    assertTrue("The top three products list is empty!", !topThreeProducts.isEmpty());
		}

	
}
