package sweet.app;

import java.util.ArrayList;

public class FeedBack {

	private String uNameSrc;
	private String mgs;
	private String productRecipeName;
	private String type;
	
	public FeedBack() {
	}

	@Override
	public String toString() {
		return "FeedBack [uNameSrc=" + uNameSrc + ", mgs=" + mgs + ", productRecipeName=" + productRecipeName
				+ ", type=" + type + "]";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getuNameSrc() {
		return uNameSrc;
	}

	public void setuNameSrc(String uNameSrc) {
		this.uNameSrc = uNameSrc;
	}

	public String getMgs() {
		return mgs;
	}

	public void setMgs(String mgs) {
		this.mgs = mgs;
	}

	public String getProductRecipeName() {
		return productRecipeName;
	}

	public void setProductRecipeName(String productRecipeName) {
		this.productRecipeName = productRecipeName;
	}

	public FeedBack(String uNameSrc, String mgs, String productRecipeName) {
		this.uNameSrc = uNameSrc;
		this.mgs = mgs;
		this.productRecipeName = productRecipeName;
	}
	
	public  boolean checkType(String type) {
	   return type.equalsIgnoreCase("Recipe")||type.equalsIgnoreCase("Product");
	}
	
	public  boolean checkMsg(String msg) {
		return (!msg.equals(""));
	}

	public boolean checkNullOrEmpty(String str){
		 return (!(str == null || str.equals("")));
	}

	public boolean checkProductName(String pName){
		 ArrayList<product> prods = MyApp.getProducts();
		        for (product prod : prods) {
		            if (prod.getpName().equals(pName)) {
		                return true;
		            }
		        }
		        return false;
	}

	public boolean checkRecipeName(String rName){
		 ArrayList<Recipe> recs = MyApp.getRecipes();
		        for (Recipe rec : recs) {
		            if (rec.getTitle().equals(rName)) {
		                return true;
		            }
		        }
		        return false;
	}
	
public boolean checkName(String name) {

    if (!(checkNullOrEmpty(name) && checkNullOrEmpty(type))) {
        return false;
    }

  switch (type.toLowerCase()) {
        case "product":
            return checkProductName(name);
        case "recipe":
            return checkRecipeName(name);
        default:
            return false;
    }
}

	
	
}
