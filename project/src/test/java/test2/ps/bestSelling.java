package test2.ps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import Sweet.App.MyApp;
import Sweet.App.product;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class bestSelling {

	MyApp sweetApp;
	product bestSellingProduct;

public bestSelling(MyApp sweetApp) {
		this.sweetApp = sweetApp;
	} 


	@When("the Admin searches for the best-selling products in Branch {string}")
	public void theAdminSearchesForTheBestSellingProductsIn(String branch) {
		 bestSellingProduct = sweetApp.findBestSellingProductInBranch(branch);
	}

	@Then("the system should should be displayed as the best-selling product in {string}")
	public void theSystemShouldShouldBeDisplayedAsTheBestSellingProductIn(String branch) {
        if (bestSellingProduct != null) {
            System.out.println("Best-selling product in " + branch + ": " + bestSellingProduct.getpName() +
                               " with sales count: " + bestSellingProduct.getSalesCount());
            // Example assertion
            assertEquals(branch, bestSellingProduct.getBranchName());
        } else {
            System.out.println("No best-selling product found in branch " + branch);
            assertNull("Expected product to be null", bestSellingProduct);
        }
	}

	@When("the Admin searches for the best-selling products in a non-existent branch {string}")
	public void theAdminSearchesForTheBestSellingProductsInANonExistentBranch(String branch) {
	       product bestSellingProduct = sweetApp.findBestSellingProductInBranch(branch);
	        if (bestSellingProduct == null) {
	            System.out.println("No best-selling product found in branch " + branch);
	        }
	}
}
