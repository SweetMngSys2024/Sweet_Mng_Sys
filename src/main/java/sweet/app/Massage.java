package sweet.app;

public class Massage {

	private String uNameSrc;
	private String uNameDest;
	private String mgs;
	private String typeOfDest;
	private String typeOfSrc;
	
	
	public Massage() {
	}

	public Massage(String uNameSrc, String uNameDest, String mgs, String typeOfDest, String typeOfSrc) {
		super();
		this.uNameSrc = uNameSrc;
		this.uNameDest = uNameDest;
		this.mgs = mgs;
		this.typeOfDest = typeOfDest;
		this.typeOfSrc = typeOfSrc;
	}




	@Override
	public String toString() {
		return "Massage [uNameSrc=" + uNameSrc + ", uNameDest=" + uNameDest + ", mgs=" + mgs + ", typeOfDest="
				+ typeOfDest + ", typeOfSrc=" + typeOfSrc + "]";
	}

	public String getTypeOfSrc() {
		return typeOfSrc;
	}

	public void setTypeOfSrc(String typeOfSrc) {
		this.typeOfSrc = typeOfSrc;
	}

	public String getuNameSrc() {
		return uNameSrc;
	}
	public void setuNameSrc(String uNameSrc) {
		this.uNameSrc = uNameSrc;
	}
	public String getuNameDest() {
		return uNameDest;
	}
	public void setuNameDest(String uNameDest) {
		this.uNameDest = uNameDest;
	}
	public String getMgs() {
		return mgs;
	}
	public void setMgs(String mgs) {
		this.mgs = mgs;
	}
	public String getTypeOfDest() {
		return typeOfDest;
	}
	public void setTypeOfDest(String typeOfDest) {
		this.typeOfDest = typeOfDest;
	}

	public boolean checkuNameDest(String uNameDest2) {
		if(uNameDest2.equals(""))return false;
		else if(uNameDest2.equals("Branch 1")||uNameDest2.equals("Branch 2")||uNameDest2.equals("Branch 3")||uNameDest2.equals("Branch 4"))return true;
		else return false;
		
	}

	public boolean checkMsg(String msg2) {
		if(msg2.equals(""))return false;
		else return true;
	}

	public boolean checkDstType(String type2) {
		if(type2.equals(""))return false;
		else if(type2.equals("Owner")||type2.equals("Supplier")||type2.equals("User"))return true;
		else return false;
	}

	
	
}
