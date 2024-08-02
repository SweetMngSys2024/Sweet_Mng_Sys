package Sweet.App;

import java.util.ArrayList;
import java.util.List;
public class MyApp {

	 static public ArrayList<User> users = new ArrayList<>();
	 static public ArrayList<Recipe> recipes = new ArrayList<>();
	 static public ArrayList<orders> sellers = new ArrayList<>();
	 static public ArrayList<product> products = new ArrayList<>();
	 static public ArrayList<Massage> allMassages = new ArrayList<>();
	 static public ArrayList<FeedBack> feedBacks = new ArrayList<>();
	 static public ArrayList<RawMaterial> materials = new ArrayList<>();
	 public User currentUser;
	 public Recipe currentRecipe;
	 public product currentProduct;
	 public orders currentOrder;
	 public String errorMessage;
	

	
	 
	 public MyApp() {
		MyApp.users=new ArrayList<User>();
		MyApp.recipes=new ArrayList<Recipe>();
		this.currentUser=new User();
		MyApp.sellers=new ArrayList<orders>();
		MyApp.products=new ArrayList<product>();
		this.currentProduct=new product();
		this.currentOrder=new orders();
		MyApp.allMassages=new ArrayList<Massage>();
		MyApp.feedBacks=new ArrayList<FeedBack>();
		MyApp.materials=new ArrayList<RawMaterial>();
		 
		
		//to add data
		users.add(new User("bayan", "password123", "User","Jenin"));
		users.add(new User("ahmad", "password456", "User","Nablus"));
		users.add(new User("aya", "password789", "Admin"));
		users.add(new User("amer", "password987", "Admin"));
		users.add(new User("shams", "password654", "Owner","Branch 3","Jenin"));
		users.add(new User("raghad", "password321", "Owner","Branch 2","Nablus"));
		users.add(new User("rama", "password675", "Suppliers","Branch 1","Nablus"));
		users.add(new User("amal", "password184", "Suppliers","Branch 4","Jenin"));
		
		
		users.add(new User("amal_ahmad", "password1234", "Suppliers","Branch 3","Jenin"));
		users.add(new User("shams_imad", "password5678", "Owner","Branch 1","Nablus"));
		users.add(new User("raghad_jamal", "password910", "Owner","Branch 4","Jenin"));
		users.add(new User("rama_hasan", "password11", "Suppliers","Branch 2","Nablus"));
	        
		recipes.add(new Recipe("Chocolate Cake", "Delicious and moist chocolate cake", "Alice", "Flour, Cocoa, Sugar, Eggs, Butter", "1 hour","Nut-Free"));
		recipes.add(new Recipe("Vanilla Ice Cream", "Creamy vanilla ice cream", "Bob", "Milk, Cream, Sugar, Vanilla", "4 hours","Egg-Free"));
		recipes.add(new Recipe("Strawberry Shortcake", "Classic strawberry shortcake", "Carol", "Flour, Sugar, Strawberries, Cream", "1.5 hours","Vegan"));
		recipes.add(new Recipe("Lemon Tart", "Tangy and sweet lemon tart", "Dave", "Flour, Butter, Sugar, Lemons, Eggs", "2 hours","Gluten-Free"));
		recipes.add(new Recipe("Brownies", "Rich and fudgy brownies", "Eve", "Flour, Cocoa, Sugar, Eggs, Butter, Chocolate", "45 minutes","Nut-Free"));
    
		
		products.add(new product("Half Dark Chocolate", "Rich dark chocolate with 50% cocoa", 5.99, 100, 20, 0.1, "Chocolate Supplier A","Branch 1"));
        products.add(new product("Dark Chocolate", "Premium dark chocolate with 85% cocoa", 6.99, 50, 30, 0.15, "Chocolate Supplier B","Branch 1"));
        products.add(new product("White Chocolate", "Creamy white chocolate with vanilla", 4.99, 2, 15, 0.05, "Chocolate Supplier C","Branch 1"));
        
        
        sellers.add(new orders("Half Dark Chocolate", 2, 11.98, "on way", "bayan", "Branch 1", "Nablus"));
        sellers.add(new orders("White Chocolate", 1, 4.99, "on way", "ahmad", "Branch 2", "Nablus"));
        sellers.add(new orders("Dark Chocolate", 2, 13.98, "on way", "aya", "Branch 3", "Jenin"));
        sellers.add(new orders("Half Dark Chocolate", 3, 17.97, "on way", "amer", "Branch 4", "Jenin"));
       
		
        
        materials.add(new RawMaterial("Flour", "supplier1", 2.50));
        materials.add(new RawMaterial("Sugar", "supplier2", 1.75));
        materials.add(new RawMaterial("Cocoa", "supplier3", 3.00));
        materials.add(new RawMaterial("Eggs", "supplier4", 0.20));
        materials.add(new RawMaterial("Butter", "supplier5", 4.00));

	}
	 
	 public static ArrayList<RawMaterial> getMaterial() {
			return materials;
		}


		public static void setMaterial(ArrayList<RawMaterial> material) {
			MyApp.materials = material;
		}


	 
	public static ArrayList<User> getUsers() {
		return users;
	}

	public static void setUsers(ArrayList<User> users) {
		MyApp.users = users;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}


	public void printStm(String msg) {	  
		System.out.println(msg);		
	}
	 
	public void addUser(User user) {
		MyApp.users.add(user);
	}
	public void getInfo(User user) {
		System.out.println("First Name="+this.currentUser.getFirstName());
		System.out.println("Last Name="+this.currentUser.getLastName());
		System.out.println("Password="+this.currentUser.getPassword());
		System.out.println("User Name="+this.currentUser.getUserName());
		System.out.println("Email="+this.currentUser.getEmail());
		System.out.println("Role="+this.currentUser.getRole());
		System.out.println("City="+this.currentUser.getCity());
	}


	public void updateUserInfo(User currentUser2) {
		
	        for (User user : MyApp.users) {
	          if(user.getUserName().equals(currentUser2.getUserName())) 
	          {
	              user.setEmail(currentUser2.getEmail());
	              user.setUserName(currentUser2.getUserName());
	              user.setPassword(currentUser2.getPassword());
	        	  break;
	          }
	        }
		
	}
	
	
	
	public void updateRecipe(Recipe currentrecipes2) {
		for (Recipe recipe : MyApp.recipes) {
			if(this.currentUser.getRole()=="Admin") 
			{
				recipe.setTitle(currentrecipes2.getTitle());
				recipe.setDescription(currentrecipes2.getDescription());
				recipe.setIngrediants(currentrecipes2.getIngrediants());
				recipe.setTime(currentrecipes2.getTime());
			
				break;
			}
		}
		
	}
	
	
	public void deleteUser(User currentUser3) {
	
		MyApp.users.remove(currentUser3);
	}
	
	public void addRecipe(Recipe newRecipe) {
		MyApp.recipes.add(newRecipe);
	}


	public boolean authenticateUser(String username, String password, String role) {
	    ArrayList<User> users = MyApp.getUsers();
	    for (User user : users) {
	        if (user.getUserName().equals(username) && user.getPassword().equals(password) && user.getRole().equals(role)) {
	        	this.currentUser=user;
	        	 return true;
	           }
	        }
	        return false;
	    }


	public static ArrayList<Recipe> getRecipes() {
		return recipes;
	}


	public static void setRecipes(ArrayList<Recipe> recipes) {
		MyApp.recipes = recipes;
	}


	public boolean checkSearchField(String search) {

		if(search=="")return false;
		else {
			 ArrayList<Recipe> recipes = MyApp.getRecipes();
			    for (Recipe recipe : recipes) {
			        if (recipe.getTitle().equals(search)) {
			        	this.currentRecipe=recipe;
			        	 return true;
			           }
			        }return false;
		}
	}


	public void displayRecipeInfo() {
		System.out.println("Title: "+this.currentRecipe.getTitle());
		System.out.println("Time: "+this.currentRecipe.getTime());
		System.out.println("Description: "+this.currentRecipe.getDescription());
		System.out.println("Ingrediants: "+this.currentRecipe.getIngrediants());
		System.out.println("User Name: "+this.currentRecipe.getUserName());
		System.out.println("Type: "+this.currentRecipe.getType());
		
	}



	public boolean checkFilterOption(String choice) {
		if(choice.equals(""))return false;
		else if(choice.equals("1")||choice.equals("2")||choice.equals("3")||choice.equals("4")) {return true;}
		else return false;
		
	}


	public void showAllFilterdRecipes(String filterOption) {
		String filter;
		if(filterOption.equals("1"))filter="Egg-Free";
		else if(filterOption.equals("2"))filter="Nut-Free";
		else if(filterOption.equals("3"))filter="Gluten-Free";
		else filter="Vegan";
		ArrayList <Recipe> myFilterdRecipes=MyApp.getRecipes();
		for(Recipe myRecipe:myFilterdRecipes) {
			if(myRecipe.getType().equals(filter)) 
			{
				this.currentRecipe=myRecipe;
				displayRecipeInfo();
				System.out.println("*******************************************************");
			}
		}
		
	}


	public static ArrayList<orders> getSellers() {
		return sellers;
	}
	public static void setSellers(ArrayList<orders> sellers) {
		MyApp.sellers = sellers;
	}
	public static ArrayList<product> getProducts() {
		return products;
	}
	public static void setProducts(ArrayList<product> products) {
		MyApp.products = products;
	}


	public boolean checkSearchProduct(String search) {
		
		if(search.equals(""))return false;
		else {
			ArrayList<product> myProd=MyApp.getProducts();
			for(product currentProd:myProd) {
				if(currentProd.getpName().equals(search)) {currentProduct=currentProd; return true;}
			}
			return false;
		}
	}


	public void showProductInfo() {
		System.out.println("Product name: "+currentProduct.getpName());
		System.out.println("Product Price: "+currentProduct.getPrice());
		System.out.println("Description: "+currentProduct.getDescription());
		System.out.println("Discount: "+currentProduct.getDiscount());
		System.out.println("Supplier name: "+currentProduct.getSupplier());		
	}


	public boolean buyProduct(String input) {
		int qnt;
		if(input.equals("Cancle"))return false;
		else { 
		    try {
				qnt=Integer.parseInt(input);
				
		    } catch (NumberFormatException e) {
		        return false;
		    }
		    
		    if (qnt <= 0) {
		        return false;
		    }
		    
		    if (currentProduct.getQuantity() < qnt) {
		    	this.currentOrder.setQuantity(qnt);
		        return false;
		    }
		    setOrderDetials(qnt);
		    currentProduct.setQuantity(currentProduct.getQuantity()-qnt);
			currentProduct.setSalesCount(currentProduct.getSalesCount()+currentOrder.getQuantity());
			MyApp.sellers.add(currentOrder);
			return true;
		}
	}


	private void setOrderDetials(int qnt2) {
		currentOrder.setProductName(currentProduct.getpName());
		currentOrder.setQuantity(qnt2);
		currentOrder.setPrice(qnt2*currentProduct.getPrice());
		currentOrder.setStatus("on way");
		currentOrder.setUserName(currentUser.getUserName());		
	}


	public void addFeedBack(FeedBack currentFeedBack) {
		currentFeedBack.setuNameSrc(this.currentUser.getUserName());
		MyApp.feedBacks.add(currentFeedBack);
		
	}

	public void sendMsg(Massage currentMsg) {
	    currentMsg.setTypeOfSrc(this.currentUser.getRole());
	    currentMsg.setuNameSrc(this.currentUser.getUserName());
	    MyApp.allMassages.add(currentMsg);
	    this.currentUser.userSentMsgs.add(currentMsg);

	    for (User user : MyApp.getUsers()) {
	        String userBranch = user.getBranch();
	        String userRole = user.getRole();
	        
	        if (currentMsg.getuNameDest() != null && userBranch != null && userBranch.equals(currentMsg.getuNameDest()) &&
	            currentMsg.getTypeOfDest() != null && userRole != null && userRole.equals(currentMsg.getTypeOfDest())) {
	            user.userRecievedMsgs.add(currentMsg);
	            break;
	        }
	    }
	    
	   
	 // Print the arrays
	    System.out.println("User Sent Messages:");
	  
	    for (Massage msg : this.currentUser.userSentMsgs) {
            System.out.println(msg);
        }

	    System.out.println("User Received Messages:");
	    for (User user : MyApp.getUsers()) {
	    	if(user.userRecievedMsgs!=null) 
	        for (Massage msg : user.userRecievedMsgs) {
	            System.out.println(msg);
	            System.out.println(user.getUserName());
	        }
	    }
	    
	  
	}
	
	
	
	public void deleteUserByName(String name) {
	    User userToRemove = null;
	    for (User user : users) {
	        if (user.getUserName().equals(name)) {
	            userToRemove = user;
	            break;
	        }
	    }
	    if (userToRemove != null) {
	        MyApp.users.remove(userToRemove);
	    } else {
	        setErrorMessage("The specified account does not exist");
	    }
	}
	
	
	public void deleteRecipe(String title) {
		Recipe recipeToRemove = null;
	    for (Recipe recipe : recipes) {
	        if (recipe.getTitle().equals(title)) {
	        	recipeToRemove = recipe;
	            break;
	        }
	    }
	    if (recipeToRemove != null) {
	        MyApp.recipes.remove(recipeToRemove);
	    } else {
	        setErrorMessage("The specified (recipe does not exist");
	    }
	}
	
	
	public boolean userExists(String name) {
	        for (User user : users) {
	            if (user.getUserName().equals(name)) {
	                return true;
	            }
	        }
	        return false;
	    }
	 
	
	
	
	public boolean recipeExists(String title) {
		 for (Recipe recipe : recipes) {
	            if (recipe.getTitle().equals(title)) {
	                return true;
	            }
	        }
	        return false;
	}
	
	
	  public String getErrorMessage() {
	        return errorMessage;
	    }

	    public void setErrorMessage(String message) {
	        this.errorMessage = message;
	    }
	    
	    
	    
	    
	    
	    public  void viewAllMaterial() {
	        List<RawMaterial> materials = MyApp.materials;

	        if (materials.isEmpty()) {
	            System.out.println("No raw materials found.");
	        } else {
	            for (RawMaterial material : materials) {

	                System.out.println(material.toString());
	    		}
	            }
	        }
	    
	    
	    
	    
	    public void ViewAllRecipes() {
	    	List<Recipe> recipes = MyApp.recipes;
	    	if (recipes.isEmpty()) {
	    		 System.out.println("No recipes found.");
	    	}else {
	    		for (Recipe recipe : recipes) {
	    			System.out.println(recipe.toString());
	    		}
	    	}
		}
	    
	    
	    public  void ViewAllUser() {
	    	
	    	 List<User> users = MyApp.getUsers();
	    	    
	    	    if (users.isEmpty()) {
	    	        System.out.println("No user accounts found.");
	    	    } else {
	    	        for (User user : users) {
	    	            System.out.println("Username: " + user.getUserName() + ", Type: " + user.getRole());
	    	        }
	    	    }
	
	    }
	    
	    
	    
	 

	    
	    
	    public static boolean VerifyBranchInCity(String branch, String city) {
	    	if (city.equals("Nablus")) {
	            return branch.equals("Branch 1") || branch.equals("Branch 2");
	        } else if (city.equals("Jenin")) {
	            return branch.equals("Branch 3") || branch.equals("Branch 4");
	        }
	        return false;
	    	
	    }
	    
	    
	    
	    
	    
	    
	    public double calculateTotalProfitsForCity(String city) {
	        double totalProfits = 0.0;
	        for (orders order : this.sellers) {
	            if (order.getCity().equals(city)) {
	                totalProfits += order.getPrice();
	            }
	        }
	        return totalProfits;
	    }

	    
	    
	    public double calculateTotalProfitsForBranchInCity(String branch, String city) {
	        double totalProfits = 0.0;
	        for (orders order : this.sellers) {
	            if (order.getBranch().equals(branch) && order.getCity().equals(city)) {
	                totalProfits += order.getPrice();
	            }
	        }
	        return totalProfits;
	    }

	    
	    
	    public double calculateTotalProfitsForAllCities() {
	        double totalProfits = 0.0;
	        for (orders order : this.sellers) {
	            totalProfits += order.getPrice();
	        }
	        return totalProfits;
	    }
	    
	    
	    
	    
	    public int countUsersInCity(String city) {
	        int userCount = 0;
	        for (orders order : this.sellers) {
	            if (order.getCity().equals(city)) {
	                userCount++;
	            }
	        }
	        return userCount;
	    } 
	    
	    
	    
	    
	    public int countUsersInBranchInCity(String branch, String city) {
	        int userCount = 0;
	        for (orders order : this.sellers) {
	            if (order.getBranch().equals(branch) && order.getCity().equals(city)) {
	                userCount++;
	            }
	        }
	        return userCount;
	    }
	    
	    
	  
	    public int countUsersInAllCities() {
	        int userCount = 0;
	        for (orders order : this.sellers) {
	            userCount++;
	        }
	        return userCount;
	    }
	    
	    

	    public product findBestSellingProductInBranch(String branch) {
	    	 if (branch.equals("")) {
	    		 this.printStm("Error: Branch cannot be empty.");
	    		 }
	        product bestSellingProduct = null;
	        int maxSalesCount = 0;

	        for (product prod : products) {
	            if (prod.getBranchName().equals(branch) && prod.getSalesCount() > maxSalesCount) {
	                bestSellingProduct = prod;
	                maxSalesCount = prod.getSalesCount();
	            }
	        }

	        return bestSellingProduct;
	    }

	

		
		
}
	 