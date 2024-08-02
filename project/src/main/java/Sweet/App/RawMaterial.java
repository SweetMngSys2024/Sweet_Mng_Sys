package Sweet.App;

public class RawMaterial {

    private String materialName;
    private String supplierUsername;
    private double price; 

    public RawMaterial(String materialName, String supplierUsername, double price) {
        this.materialName = materialName;
        this.supplierUsername = supplierUsername;
        this.price = price;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getSupplierUsername() {
        return supplierUsername;
    }

    public void setSupplierUsername(String supplierUsername) {
        this.supplierUsername = supplierUsername;
    }

    public double getPrice() {  
        return price;
    }

    public void setPrice(double price) {  
        this.price = price;
    }

    @Override
    public String toString() {
        return "RawMaterial [materialName=" + materialName + 
               ", supplierUsername=" + supplierUsername + 
               ", price=" + price + "]";
    }
}
