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
		if(type.equals(""))return false;
		else if(type.equalsIgnoreCase("Recipe")||type.equalsIgnoreCase("Product")) {return true;}
		else return false;
	}
	public  boolean checkMsg(String msg) {
		if(msg.equals(""))return false;
		else return true;
	}

	public boolean checkName(String name) {
    if (isNullOrEmpty(name) || isNullOrEmpty(type)) {
        return false;
    }

    if (type.equalsIgnoreCase("Product")) {
        return checkIfNameExists(MyApp.getProducts(), name);
    } else if (type.equalsIgnoreCase("Recipe")) {
        return checkIfNameExists(MyApp.getRecipes(), name);
    }

    return false;
}

private boolean isNullOrEmpty(String str) {
    return str == null || str.equals("");
}

private <T> boolean checkIfNameExists(ArrayList<T> items, String name) {
    for (T item : items) {
        if (item instanceof product && ((product) item).getpName().equals(name)) {
            return true;
        } else if (item instanceof Recipe && ((Recipe) item).getTitle().equals(name)) {
            return true;
        }
    }
    return false;
}
	
}
