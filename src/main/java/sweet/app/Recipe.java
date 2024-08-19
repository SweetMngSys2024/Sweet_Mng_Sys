package sweet.app;

import java.util.ArrayList;

public class Recipe {


	public String title;
	public String description;
	public String userName;
	public String ingrediants;
	public String time;
	
	
	public int userNameFlag=0;
	
	public String type; //for filtering the recipes (Vegan ,Gluten-Free,Nut-Free,Egg-Free)
	
	
	public Recipe() {}
	
	public Recipe(String title, String description, String userName, String ingrediants, String time,String type) {
		super();
		this.title = title;
		this.description = description;
		this.userName = userName;
		this.ingrediants = ingrediants;
		this.time = time;
		this.type=type;
	}
	
	
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
		
		if(uName.equals("")) {userNameFlag=1;return false;}
		else 
		{
			 ArrayList<User> users = MyApp.getUsers();
		        for (User user : users) {
		          if(user.getUserName().equals(uName)) 
		          {
		        	  this.setUserName(uName);
		  			  return true;
		          }
		        }userNameFlag=2; return false;
			}
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
	
	public boolean checkType(String type) 
	{
		if(type.equals("")) {return false;}
		else if(type.equals("Egg-Free")||type.equals("Nut-Free")||type.equals("Gluten-Free")||type.equals("Vegan"))
		{
			this.setType(type);
			return true;}
		else return false;
	}
	
}
