package MyApp2024_Sweet;

public class Store {

    String storeName;
    String city;
    String ownerUsername;

   
    public Store(String storeName2, String city2, String ownerUsername2) {
        storeName = storeName2;
        city = city2;
        ownerUsername = ownerUsername2;
    }

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getOwnerUsername() {
		return ownerUsername;
	}

	public void setOwnerUsername(String ownerUsername) {
		this.ownerUsername = ownerUsername;
	}

	@Override
	public String toString() {
		return "Store [storeName=" + storeName + ", city=" + city + ", ownerUsername=" + ownerUsername + "]";
	}

}
