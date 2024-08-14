package Sweet.App;

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
		if(type.equals(""))return false;
		else if(type.equalsIgnoreCase("Recipe")||type.equalsIgnoreCase("Product")) {return true;}
		else return false;
	}
	public  boolean checkMsg(String msg) {
		if(msg.equals(""))return false;
		else return true;
	}
	public  boolean checkName(String name) {
		  if (name == null || name.equals("")) return false;
		    if (type == null || type.equals("")) return false;

		    if (type.equalsIgnoreCase("Product")) {
		        ArrayList<product> prods = MyApp.getProducts();
		        for (product prod : prods) {
		            if (prod.getpName().equals(name)) {
		                return true;
		            }
		        }
		        return false;
		    } else if (type.equalsIgnoreCase("Recipe")) {
		        ArrayList<Recipe> recs = MyApp.getRecipes();
		        for (Recipe rec : recs) {
		            if (rec.getTitle().equals(name)) {
		                return true;
		            }
		        }
		        return false;
		    } else {
		        return false;
		    }
	
	}
	
}
