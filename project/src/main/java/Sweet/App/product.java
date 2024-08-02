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
	 
	 
}