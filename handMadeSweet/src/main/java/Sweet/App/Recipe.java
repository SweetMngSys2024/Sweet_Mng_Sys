package Sweet.App;

public class Recipe {

	public String title;
	public String description;
	public String userName;
	public String ingrediants;
	public String time;
	
	//public String type; //for filtering the recipes (Vegan ,Gluten-Free,Nut-Free,Egg-Free)
	
	
	public Recipe() {}
	
	
	@Override
	public String toString() {
		return "Recipe [title=" + title + ", description=" + description + ", userName=" + userName + ", ingrediants="
				+ ingrediants + ", time=" + time + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIngrediants() {
		return ingrediants;
	}


	public void setIngrediants(String ingrediants) {
		this.ingrediants = ingrediants;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public boolean checkUserName(String uName) 
	{
		if(uName.equals("")) {return false;}
		else 
		{
			this.setUserName(uName);
			return true;}
	}
	public boolean checkTitle(String title) 
	{
		if(title.equals("")) {return false;}
		else 
		{
			this.setTitle(title);
			return true;}
	}
	public boolean checkIngrediants(String ingrediants) 
	{
		if(ingrediants.equals("")) {return false;}
		else 
		{
			this.setIngrediants(ingrediants);
			return true;}
	}
	
}
