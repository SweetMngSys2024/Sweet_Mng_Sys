package MyApp2024_Sweet;

public class RawMaterial {

     String materialName;
     String supplierUsername;

     
    
    public RawMaterial(String materialName2, String supplierUsername2) {
        materialName = materialName2;
        supplierUsername = supplierUsername2;
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

	@Override
	public String toString() {
		return "RawMaterial [materialName=" + materialName + ", supplierUsername=" + supplierUsername + "]";
	}

}
