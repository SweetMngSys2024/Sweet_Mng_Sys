package Sweet.App;

public class product {
	 
	 private String pName;
	 private String description;
	 private double price;
	 private int quantity;
	 private int salesCount;
	 private double discount;
	 private String supplier;
	 private String branchName;
	 
	 
	 
	public product() {
	  salesCount=0;
	}
	public product(String pName, String description, double price, int quantity, int salesCount, double discount,
			String supplier,String branchName) {
		
		this.pName = pName;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.salesCount = salesCount;
		this.discount = discount;
		this.supplier = supplier;
		this.branchName=branchName;
	}
	@Override
	public String toString() {
		return "product [pName=" + pName + ", description=" + description + ", price=" + price + ", quantity="
				+ quantity + ", salesCount=" + salesCount + ", discount=" + discount + ", supplier=" + supplier
				+ ", branchName=" + branchName + "]";
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSalesCount() {
		return salesCount;
	}
	public void setSalesCount(int salesCount) {
		this.salesCount = salesCount;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public boolean checkValidPrice(String price2) {
		if(price2.equals(""))return false;
		else {
			 try {
			        double p=Double.parseDouble(price2);
			        this.setPrice(p);
			        return true;
			    } catch (NumberFormatException e) {
			        return false;
			    }
		}
	}
	public boolean checkValidQnt(String qnt2) {
		if(qnt2.equals(""))return false;
		else {
			 try {
			        int p=Integer.parseInt(qnt2);
			        this.setQuantity(p);
			        return true;
			    } catch (NumberFormatException e) {
			        return false;
			    }
		}
	}
	
	public boolean checkValidDiscount(String disc2) {
		if(disc2.equals(""))return false;
		else {
			 try {
				   double p=Double.parseDouble(disc2);
			        this.setDiscount(p);
			        return true;
			    } catch (NumberFormatException e) {
			        return false;
			    }
		}
	}
	public boolean checkValidDescription(String desctiption2) {
		if(desctiption2.equals(""))return false;
		else {
			this.setDescription(desctiption2);
			return true;
		}
			
	}
	public boolean checkValidSalesCount(String salesCount2) {
		if(salesCount2.equals(""))return false;
		else {
			 try {
			        int p=Integer.parseInt(salesCount2);
			        this.setSalesCount(p);
			        return true;
			    } catch (NumberFormatException e) {
			        return false;
			    }
		}
	}
	static public double checkMinPrice(String price2) {
		if(price2.equals("")) { System.out.println("Don't let price field empty!"); return -1;}
		else {
			 try {
			        double p=Double.parseDouble(price2);
			        return p;
			    } catch (NumberFormatException e) {
			    	System.out.println("Enter a number in the price field!");
			        return -1;
			    }
		}
	}
	public static double checkDiscount(String discount2) {
		if(discount2.equals("")) 
		{
			System.out.println("Don't let discount field empty!");
			return -1;}
		else {
			double p;
			 try {
			        p=Double.parseDouble(discount2);
			        if(p<0 || p>1) {System.out.println("Don't enter 100%(=1) or more or negative percentage!"); return -1;}
			    } catch (NumberFormatException e) {
			    	System.out.println("Enter a number in the discount field!");
			        return -1;
			    }
			 return p;
		}
	}
	
	 
	 
}