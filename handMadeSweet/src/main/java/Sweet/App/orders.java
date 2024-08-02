
package Sweet.App;

public class orders {

    private String productName;
    private int quantity;
    private double price;
    private String status;
    private String userName;
    private String branch;
    private String city;
    
     
	public orders(String productName, int quantity, double price, String status, String userName, String branch,
			String city) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.status = status;
		this.userName = userName;
		this.branch = branch;
		this.city = city;
	}
	public orders() {
		
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public boolean checkBranch(String branch2) {
		if(branch2.equals(""))return false;
		else if(branch2.equals("Branch 1")||branch2.equals("Branch 2")) {this.setBranch(branch2); return true;}
		else {return false;}
		
	}
	
	public boolean checkCity(String city2) {
		if(city2.equals(""))return false;
		else if(city2.equals("Jenin")||city2.equals("Nablus")) {this.setCity(city2); return true;}
		else {return false;}
		
	}

}
