package sweet.app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyApp {

	 static public ArrayList<User> users;
	 static public ArrayList<Recipe> recipes;
	 static public ArrayList<orders> sellers;
	 static public ArrayList<product> products;
	 static public ArrayList<Massage> allMassages;
	 static public ArrayList<FeedBack> feedBacks;
	 static public ArrayList<RawMaterial> materials;
	 public User currentUser;
	 public Recipe currentRecipe;
	 public product currentProduct;
	 public orders currentOrder;
	 public boolean applyDiscount;
	 public int buyProductCase;

	
	private String jeninCity;
	private String nablusCity;
	private String ownerRole;
	private String supplierRole;
	private String br4;
	private String br3;
	private String br2;
	private String br1;
	private String ps;
	private String jor;
	private String filterNutFree;
	private String filterDarkChocolate;
	private static final String STATUS_ON_PENDING = "on pending";
        private static final String STATUS_ON_DELIVERED = "on delivered";
        private static final String STATUS_ON_PROCESSING = "on processing";
        private static final String STATUS_CANCELLED = "cancelled";

	private String totPriceLable;
	private String statusLable;
	private String qntLable;
	private String userNameLable;
	private String productNameLable;
	private String totPriceString;
	
	  public MyApp() {

		 users=new ArrayList<User>();
		recipes=new ArrayList<Recipe>();
		sellers=new ArrayList<orders>();
		products=new ArrayList<product>();
		allMassages=new ArrayList<Massage>();
		feedBacks=new ArrayList<FeedBack>();
		materials=new ArrayList<RawMaterial>();
		 
		this.currentUser=new User();
		this.currentProduct=new product();
		this.currentOrder=new orders();
		applyDiscount=false;
		buyProductCase=0;


		 jeninCity="Jenin";
		nablusCity="Nablus";
	        ownerRole="Owner";
		supplierRole="Supplier";

		br4="Branch 4";
		br3="Branch 3";
		br2="Branch 2";
		br1="Branch 1";
		 
		 jor="Jordan";
		 ps="Palestine";

	       filterNutFree="Nut-Free";
	       filterDarkChocolate="Half Dark Chocolate";

		totPriceLable="  Tot Price:";
		 statusLable="  Status:";
		 qntLable="  Qnt:";
		 userNameLable="User Name:";
		 productNameLable="  Product name:";

		 totPriceString=", and the total price for it: ";

		
		//to add data
		users.add(new User("bayan", "password123", "User",jeninCity));
		users.add(new User("ahmad", "password456", "User",nablusCity));
		users.add(new User("aya", "password789", "Admin"));
		users.add(new User("amer", "password987", "Admin"));
		users.add(new User("shams","password654", ownerRole, br3, jeninCity, "shams@example.com", "123-456-7890", jor, "1985-02-20"));
        users.add(new User("raghad", "password321", ownerRole, br2, nablusCity, "raghad@example.com", "234-567-8901", ps, "1987-04-15"));
        users.add(new User("rama", "password675", supplierRole, br1, nablusCity,  "rama@example.com", "345-678-9012", jor, "1990-06-30"));
        users.add(new User("amal", "password184", supplierRole, br4, jeninCity, "amal@example.com", "456-789-0123", ps, "1992-08-25"));

        users.add(new User("amal_ahmad", "password1234", supplierRole, br3, jeninCity, "amal_ahmad@example.com", "567-890-1234", jor, "1995-10-15"));
        users.add(new User("shams_imad", "password5678", ownerRole, br1, nablusCity, "shams_imad@example.com", "678-901-2345", ps, "1986-11-05"));
        users.add(new User("raghad_jamal", "password910", ownerRole, br4, jeninCity, "raghad_jamal@example.com", "789-012-3456", jor, "1988-12-01"));
        users.add(new User("rama_hasan", "password11", supplierRole, br2, nablusCity, "rama_hasan@example.com", "890-123-4567", ps, "1991-07-20"));
	        
		recipes.add(new Recipe("Chocolate Cake", "Delicious and moist chocolate cake", "Alice", "Flour, Cocoa, Sugar, Eggs, Butter", "1 hour",filterNutFree));
		recipes.add(new Recipe("Vanilla Ice Cream", "Creamy vanilla ice cream", "Bob", "Milk, Cream, Sugar, Vanilla", "4 hours","Egg-Free"));
		recipes.add(new Recipe("Strawberry Shortcake", "Classic strawberry shortcake", "Carol", "Flour, Sugar, Strawberries, Cream", "1.5 hours","Vegan"));
		recipes.add(new Recipe("Lemon Tart", "Tangy and sweet lemon tart", "Dave", "Flour, Butter, Sugar, Lemons, Eggs", "2 hours","Gluten-Free"));
		recipes.add(new Recipe("Brownies", "Rich and fudgy brownies", "Eve", "Flour, Cocoa, Sugar, Eggs, Butter, Chocolate", "45 minutes",filterNutFree));
    
		products.add(new product(filterDarkChocolate, "Rich dark chocolate with 50% cocoa", 5.99, 100, 20, 0.1, "Chocolate Supplier A",br3));
        products.add(new product("Dark Chocolate", "Premium dark chocolate with 85% cocoa", 6.99, 50, 30, 0.15, "Chocolate Supplier B",br1));
        products.add(new product("White Chocolate", "Creamy white chocolate with vanilla", 4.99, 2, 15, 0.05, "Chocolate Supplier C",br2));
        
        
        sellers.add(new orders(filterDarkChocolate, 2, 11.98, STATUS_ON_PENDING, "bayan", br1, nablusCity));
        sellers.add(new orders("White Chocolate", 1, 4.99, STATUS_ON_DELIVERED, "ahmad", br2, nablusCity));
        sellers.add(new orders("Dark Chocolate", 2, 13.98, STATUS_ON_PROCESSING, "aya", br1, nablusCity));
        sellers.add(new orders(filterDarkChocolate, 3, 17.97, STATUS_CANCELLED, "amer", br3, jeninCity));
       
        
        
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

		if(search.equals(""))return false;
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
		else if(filterOption.equals("2"))filter=filterNutFree;
		else if(filterOption.equals("3"))filter="Gluten-Free";
		else filter="Vegan";
		ArrayList <Recipe> myFilterdRecipes=MyApp.getRecipes();
		for(Recipe myRecipe:myFilterdRecipes) {
			if(myRecipe.getType().equals(filter)) 
			{
				this.currentRecipe=myRecipe;
				displayRecipeInfo();
				System.out.println("*************************");
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
		System.out.println("Branch name: "+currentProduct.getBranchName());		
	}


	public boolean buyProduct(String input) {
		int qnt;
		if(input.equalsIgnoreCase("Cancel")) {buyProductCase=1; return false;}
		else { 
		    try {
				qnt=Integer.parseInt(input);
				
		    } catch (NumberFormatException e) {
		    	buyProductCase=2; 
		        return false;
		    }
		    
		    if (qnt <= 0) {
		    	buyProductCase=3; 
		        return false;
		    }
		    
		    if (currentProduct.getQuantity() < qnt) {
		    	this.currentOrder.setQuantity(qnt);
		    	buyProductCase=4; 
		        return false;
		    }
		    setOrderDetails(qnt);
		    currentProduct.setQuantity(currentProduct.getQuantity()-qnt);
			currentProduct.setSalesCount(currentProduct.getSalesCount()+currentOrder.getQuantity());
			MyApp.sellers.add(currentOrder);
			return true;
		}
	}


	private void setOrderDetails(int qnt2) {
		currentOrder.setProductName(currentProduct.getpName());
		currentOrder.setQuantity(qnt2);
		currentOrder.setPrice((qnt2*currentProduct.getPrice())-(qnt2*currentProduct.getDiscount()*currentProduct.getPrice()));
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
	/*    System.out.println("User Sent Messages:");
	  
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
	    }  */  
	  
	}
	
	

	  
    public boolean VerifyBranchInCity(String branch, String city) {
    	if (city.equals(nablusCity)) {
            return branch.equals(br1) || branch.equals(br2);
        } else if (city.equals(jeninCity)) {
            return branch.equals(br3) || branch.equals(br4);
        }
        return false;
    	
    }
    
    
    public product findBestSellingProductInBranch(String branch) {
   	 if (branch.equals("")) {
   		 this.printStm("Error: Branch cannot be empty.");
   		 return null;
   		 }
   	 else if(branch.equals(br1)||branch.equals(br2)||branch.equals(br3)||branch.equals(br4)) {    
     product bestSellingProduct = null;
     int maxSalesCount = 0;

     for (product prod : products) {
         if (prod.getBranchName().equals(branch) && prod.getSalesCount() > maxSalesCount) {
             bestSellingProduct = prod;
             maxSalesCount = prod.getSalesCount();
         }
     }

     return bestSellingProduct;}
   
       else {  this.printStm("Error: Branch doesn't exist."); return null;}
   }

    
    public double calculateTotalProfitsForCity(String city) {
        double totalProfits = 0.0;
        for (orders order : sellers) {
            if (order.getCity().equals(city)) {
                totalProfits += order.getPrice();
            }
        }
        return totalProfits;
    }

    
    
    public double calculateTotalProfitsForBranchInCity(String branch, String city) {
        double totalProfits = 0.0;
        for (orders order : sellers) {
            if (order.getBranch().equals(branch) && order.getCity().equals(city)) {
                totalProfits += order.getPrice();
            }
        }
        return totalProfits;
    }

    
    
    public double calculateTotalProfitsForAllCities() {
        double totalProfits = 0.0;
        for (orders order : sellers) {
            totalProfits += order.getPrice();
        }
        return totalProfits;
    }
    
    public Recipe recipeExists(String title) {
    	if(title.equals(""))return null;
		 for (Recipe recipe : recipes) {
	            if (recipe.getTitle().equals(title)) {
	                return recipe;
	            }
	        }
	        return null;
	}
    
    
    
    public void ViewAllRecipes() {
    	ArrayList<Recipe> recipes = MyApp.recipes;
    	if (recipes.isEmpty()) {
    		 System.out.println("No recipes found.");
    	}else {
    		for (Recipe recipe : recipes) {
    			System.out.println(recipe.toString());
    		}
    	}
	}
    
    

	public boolean deleteRecipe(String title) {
		Recipe recipeToRemove = null;
	    for (Recipe recipe : recipes) {
	        if (recipe.getTitle().equals(title)) {
	        	recipeToRemove = recipe;
	            break;
	        }
	    }
	    if (recipeToRemove != null) {
	        MyApp.recipes.remove(recipeToRemove);
	        return true;
	    } else {
	        return false;
	    }
	}
	
	
	public boolean deleteUserByName(String name) {
	    User userToRemove = null;
	    for (User user : users) {
	        if (user.getUserName().equals(name)) {
	            userToRemove = user;
	            break;
	        }
	    }
	    if (userToRemove != null) {
	        MyApp.users.remove(userToRemove);
	        return true;
	    } else {
	    	
	       printStm("The specified account does not exist");
	       return false;
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
	 
	
	 
    public boolean ViewAllUser() {
    	
    	 ArrayList<User> users = MyApp.getUsers();
    	    
    	    if (users.isEmpty()) {
    	        System.out.println("No user accounts found.");
    	        return false;
    	    } else {
    	        for (User user : users) {
    	            System.out.println("Username: " + user.getUserName() + ", Type: " + user.getRole());
    	        }
    	        return true;
    	    }

    }
    
    
    public  boolean viewAllMaterial() {
        ArrayList<RawMaterial> materials = MyApp.materials;

        if (materials.isEmpty()) {
            System.out.println("No raw materials found.");
            return false;
        } else {
            for (RawMaterial material : materials) {

                System.out.println(material.toString());
    		}
            }
        return true;
        }
    
    
    public boolean ViewAllFeedBack() {
    	ArrayList<FeedBack> feedBack = MyApp.feedBacks;
    	if (feedBack.isEmpty()) {
    		 System.out.println("No feedBacks found.");
    		 return false;
    	}else {
    		for (FeedBack feedBacks: feedBacks) {
    			System.out.println(feedBacks.toString());
    		}
    	}return true;
	}
    
    

	public boolean deleteFeedBack(String username, String product) {
		if(users.isEmpty()|| products.isEmpty()||recipes.isEmpty()||feedBacks.isEmpty()) {
			System.out.println("No FeedBack found.");
			return false;
		}
		FeedBack feedBackToRemove =null;
		for(FeedBack feedBack : feedBacks) {
			if (feedBack.getuNameSrc().equals(username)&&feedBack.getProductRecipeName().equals(product)) {
				feedBackToRemove=feedBack;
				 break;
			}
		}
			if (feedBackToRemove != null) {
		        MyApp.feedBacks.remove(feedBackToRemove);
		        return true;
		    } else {
		       printStm("The specified feedBack does not exist");
		    }
			return false;
		}
	
	
	
	public boolean FeedBackExists(String username, String product) {
		for(FeedBack feedBack : feedBacks) {
			if (feedBack.getuNameSrc().equals(username) && feedBack.getProductRecipeName().equals(product)) {
				return true;
			}
		}
		return false;
	}


	 public boolean registerdUsersInAllCities() {
		 ArrayList<User>allUsers2=findUsersInAllCities();
		 if(allUsers2.isEmpty())return false;
		 printStm("The number of all users:"+allUsers2.size());
		 
		 findAllCities(allUsers2);
	     
	     showUsersInfo(allUsers2);
	     return true;
	      
	    }
	 
	 private void findAllCities(ArrayList<User>allUsers2) {
		 ArrayList<String>allCities=new ArrayList<>();
		 for (User user : allUsers2) {
		        String city = user.getCity(); // Assuming User has a method getCity()
		        if (!allCities.contains(city)) {
		            allCities.add(city);
		        }
		    }

		    // Now count the number of users in each city and print
		    for (String city : allCities) {
		        int userCount = 0;
		        for (User user : allUsers2) {
		            if (user.getCity().equals(city)) {
		                userCount++;
		            }
		        }
		        System.out.println("City: " + city + ", Number of registered users: " + userCount);
		    }

	}

	private void showUsersInfo(ArrayList<User> allUsers2) {
		 for(User user: allUsers2) {
				printStm("User Name : "+user.getUserName()+" ,City : "+user.getCity());
				}
	}

	public ArrayList<User> findUsersInAllCities()
	 {
		 ArrayList<User>allUsers=new ArrayList<>();
	        for (User user : users) {
	            if(user.getRole().equals("User")) 
	            {
	            	allUsers.add(user);
	            	}
	            }
	        
	        return allUsers;
	        
	 }
	    
	public boolean checkValidCity(String city) {
		if(city.equals(""))return false;
		else {
			ArrayList<String>cities=fillTheArrayOfCities();
			if(cities.contains(city))return true;
			return false;
		}
	}
    
	 private ArrayList<String> fillTheArrayOfCities() {
		
	        ArrayList<String>allCities=new ArrayList<>();
			 for (User user : users) {
				 if(user.getRole().equals("User")) {
			        String city = user.getCity(); 
			        if (!allCities.contains(city)) {
			            allCities.add(city);
			        }
			        }
			    }
			 return allCities;
	}


	public boolean showCityUsersInfo(String city2) {
		int counter=0;
		printStm("The Users For The City : "+city2+" are: ");
		for (User user : users) {
			 if(user.getRole().equals("User")&&user.getCity().equals(city2)) {
		        printStm("User Name: "+user.getUserName());
		        counter++;
		        }
		        }
		printStm("The Number of Users For The City "+city2+" is :"+counter);
		if(counter!=0)return true;
		    
		return false;
	}

	public boolean showAllOrders() {
		if(sellers.isEmpty())return false;
		for(orders order: sellers) 
		{
			printStm(userNameLable+order.getUserName()+totPriceLable+order.getPrice()+productNameLable+order.getProductName()+qntLable+order.getQuantity()+statusLable+order.getStatus());
		}return true;
	}

	public boolean showAllOrdersInBranch(String branch2) {
		if(sellers.isEmpty())return false;
		for(orders order: sellers) 
		{
			if(order.getBranch().equals(branch2)) {
			printStm(userNameLable+order.getUserName()+totPriceLable+order.getPrice()+productNameLable+order.getProductName()+qntLable+order.getQuantity()+statusLable+order.getStatus());}
		}return true;
	}

	public boolean showAllOrdersInCity(String city2) {
		if(sellers.isEmpty())return false;
		for(orders order: sellers) 
		{
			if(order.getCity().equals(city2)) {
				printStm(userNameLable+order.getUserName()+totPriceLable+order.getPrice()+productNameLable+order.getProductName()+qntLable+order.getQuantity()+statusLable+order.getStatus());}

		}return true;
	}

	public User verifyIdentity(String role1, String userName1) {
		if(role1.equals(""))return null;
		else if(role1.equals(ownerRole)||role1.equals(supplierRole)) 
		{
			for(User user: users) {
				if(user.getUserName().equals(userName1)&&(user.getRole().equals(ownerRole)||user.getRole().equals(supplierRole)))return user;
			}
			
		}
		return null;
	}

	public void showAllProductsInBranch(String branch) {
		for(product prod: products) 
		{
			if(prod.getBranchName().equals(branch)) {
				printStm("Product Details : "+ prod.toString());
			}
		}
		
	}

	public product checkExistingProduct(String pName,String branch) {
		if(pName.equals("")) return null;
		for(product prod: products) 
		{
			if(prod.getBranchName().equals(branch)&&prod.getpName().equals(pName))return prod;
		}
		return null;
	}

	public boolean deleteProduct(product prod) {
		if(products.contains(prod)) {products.remove(prod); return true;}
		return false;
	} 
	   
	public boolean checkValidProductName(String pName,String branch) {
		if(pName.equals("")) return false;
		for(product prod: products) 
		{
			if(prod.getBranchName().equals(branch)&&prod.getpName().equals(pName))return false;
		}
		return true;
	}

	public boolean addNewProduct(product newProduct) {
		if(newProduct==null)return false;
		else products.add(newProduct);
		return true;
	}

	public product findProductByName(String prodName, String branch) {
		if(prodName.equals("")) return null;
		for(product prod: products) 
		{
			if(prod.getBranchName().equals(branch)&&prod.getpName().equals(prodName))return prod;
		}
		return null;
	}

	public boolean checkValidSupplierName(String supplierName) {
		if(supplierName.equals("")) return false;
		for(User user: users) 
		{
			if(user.getUserName().equals(supplierName)&&user.getRole().equals(supplierRole))return true;
		}
		return false;
	}

	public boolean showAllProductsInTheBranch(String branch) {
		if(products.isEmpty())return false;
		for(product prod: products) 
		{
			if(prod.getBranchName().equals(branch)) {
			printStm("Product Name: "+prod.getpName()+", Price: "+prod.getPrice()+", Discount: "+prod.getDiscount());}
		}return true;
	}

	public void applyDiscountToProduct(double minPrice, double discount,String branch) {
		this.applyDiscount=true;
		for(product prod: products) 
		{
			if(prod.getPrice()>=minPrice && prod.getBranchName().equals(branch) && prod.getDiscount()<discount)prod.setDiscount(discount);
		}
	}

	public boolean checkStatus(String status){

		return status.equals(STATUS_ON_PENDING)||status.equals(STATUS_ON_DELIVERED)||status.equals(STATUS_ON_PROCESSING)||status.equals(STATUS_CANCELLED);
	}

	public void processOrderByStatus(orders order, String status)
	{
		String orderStatus=order.getStatus().toLowerCase();
		if(orderStatus.equals(STATUS_ON_PENDING)&&status.equals(STATUS_ON_PENDING)){
			 handlePendingOrder(order);
	                 order.setStatus(STATUS_ON_PROCESSING);
		}
		else if(orderStatus.equals(STATUS_ON_PROCESSING)&&status.equals(STATUS_ON_PROCESSING)){
			 handleProcessingOrder(order);
	                 order.setStatus(STATUS_ON_DELIVERED);
		}

		else if(orderStatus.equals(STATUS_ON_DELIVERED)&&status.equals(STATUS_ON_DELIVERED)){
			 handleDeliveredOrder(order);
	                order.setStatus(STATUS_CANCELLED);
		}
		else if(orderStatus.equals(STATUS_CANCELLED)&&status.equals(STATUS_CANCELLED)){
			 handleCancelledOrder(order);
		}    
	              
	          return;
	}

	
	public boolean handleOrderStatus(String status2, String branch) {
		String status=status2.toLowerCase();
		
		if(!checkStatus(status)) return false;
		

	    for (orders order : sellers) {
	        if (order.getBranch().equalsIgnoreCase(branch)) {
	        processOrderByStatus(order, status);
	        }
	    }
	    return true;
	
	}
	  
		private void handlePendingOrder(orders order) {
	        printStm("Processing pending order for " + order.getUserName()+totPriceString+order.getPrice());
	    }

	    private void handleDeliveredOrder(orders order) {
	    	printStm("Order delivered to " + order.getUserName()+totPriceString+order.getPrice());
	    }

	    private void handleProcessingOrder(orders order) {
	    	printStm("Order is being processed for " + order.getUserName()+totPriceString+order.getPrice());
	    }

	    private void handleCancelledOrder(orders order) {
	    	printStm("Order cancelled for " + order.getUserName()+totPriceString+order.getPrice());
	    }
	    
	    

		public boolean checkuNameDest(String uNameDest) {
			for(User user: users) 
			{
				if(user.getUserName().equals(uNameDest))return true;
			}return false;
		}

		
		public void addMassage(Massage currentMsg) {
			currentMsg.setTypeOfSrc(this.currentUser.getRole());
		    currentMsg.setuNameSrc(this.currentUser.getUserName());
		    MyApp.allMassages.add(currentMsg);
		    this.currentUser.userSentMsgs.add(currentMsg);

		    for (User user : MyApp.getUsers()) {
		        String userName = user.getUserName();
		        String userRole = user.getRole();
		        
		        if (currentMsg.getuNameDest() != null && userName != null && userName.equals(currentMsg.getuNameDest()) &&
		            currentMsg.getTypeOfDest() != null && userRole != null && userRole.equals(currentMsg.getTypeOfDest())) {
		            user.userRecievedMsgs.add(currentMsg);
		            break;
		        }
		    }
		    
	/*	    System.out.println("userRecievedMsgs");
		    for (User user : MyApp.getUsers()) {
		    	if(user.userRecievedMsgs!=null) 
		        for (Massage msg : user.userRecievedMsgs) {
		            System.out.println(msg.toString());
		        }
		    }   
		    
		    
		    System.out.println("userSentMsgs");
		    for (User user : MyApp.getUsers()) {
		    	if(user.userSentMsgs!=null) 
		        for (Massage msg : user.userSentMsgs) {
		            System.out.println(msg.toString());
		        }
		    }   */
		    
		}
		
		
		
		/////////////////////////////////////////////////////////////////
		public String getBranchOwner(String owner) {
			 if (owner.equals("")) {
	    		 this.printStm("Error: owner cannot be empty.");
	    		 }
			 for (User user : users) {
			        if (user.getRole().equals(ownerRole)|| user.getRole().equals(supplierRole)){
			        	 if(user.getUserName().equals(owner)){
			   //		 System.out.println("the branch owner is: " + owner + " And the branch name is:  " + user.getBranch());

			            return user.getBranch();
			        }
			    }
			 }
			    this.printStm("Owner not found or has no branch.");
			    return null;
		
		}

		public int TotalSales(String branch) {
			if (branch.equals("")) {
	    		 this.printStm("Error: branch cannot be empty.");
	    		 }
			int totalSales = 0;
			for (product prod : products) 
				 if (prod.getBranchName().equals(branch)){
					 System.out.println("Product name= " + prod.getpName() + " ,and the sales amount is: " + prod.getSalesCount());
					 totalSales +=prod.getSalesCount();
				 }
			System.out.println("Total Sales for " + branch + " is " + totalSales);
			return totalSales;
		}

		
		public double ProfitsOfBranch(String branch) {
		
			double totalProfits = 0.0;
	        for (orders order : MyApp.sellers)
	        	 if (order.getBranch().equals(branch)){
	            System.out.println("Order's product name= " + order.getProductName() + " ,and the total price= " + order.getPrice());
	            totalProfits += order.getPrice();
	        }
	        System.out.println("\n\nTotal Profit for " + branch + " is " + totalProfits);
	        return totalProfits;
		}

		public boolean isProductAvailableInBranch(String owner,String productName) {
			 if (owner == null || productName == null ) {
			        System.out.println("Invalid input: owner, productName list is null.");
			        return false;
			    }

			    String branch = getBranchOwner(owner);

			    if (branch == null) {
			        System.out.println("Branch not found for owner: " + owner);
			        return false;
			    }
			
			 for (product prod : products) {
		            if (prod.getpName().equals(productName) && prod.getBranchName().equals(branch)) {
		                System.out.println("Name: " + prod.getpName() +" in branch "+ branch );

		                return true; 
		            }
		        }
		        
		        return false;   
		    }

		public double ProfitsOfProduct(String product,String productBranchName) {
			double Profits = 0.0;
	        for (orders order : MyApp.sellers) {
	        	 if (order.getBranch().equals(productBranchName)&&order.getProductName().equals(product)){
	           Profits += order.getPrice();
	        }
	        	 }
	        System.out.println("\n\nProfit for " + product + " in "+ productBranchName+ " is " + Profits);
	        return Profits;
		}

		public int SalesOfProduct(String product,String productBranchName) {
			int Sales = 0;
			for (product prod : products) 
				 if (prod.getBranchName().equals(productBranchName)&&prod.getpName().equals(product)){
					 Sales +=prod.getSalesCount();
				 }
			System.out.println(" Sales for " + product + " in "+ productBranchName+" is " + Sales);
			return Sales;
		}

		
		
		
	
		public List<product> GetTopBestThreeProducts(String bestSellingBranchName) {
	        return products.stream()
	            .filter(p -> p.getBranchName().equals(bestSellingBranchName))
	            .sorted((p1, p2) -> Integer.compare(p2.getSalesCount(), p1.getSalesCount()))
	            .limit(3)
	            .collect(Collectors.toList());
	    }
	
		
		
		public void OwnerORSuppliersgetInfo(User user) {
			System.out.println("First Name="+this.currentUser.getFirstName());
			System.out.println("Last Name="+this.currentUser.getLastName());
			System.out.println("Password="+this.currentUser.getPassword());
			System.out.println("User Name="+this.currentUser.getUserName());
			System.out.println("Email="+this.currentUser.getEmail());
			System.out.println("Role="+this.currentUser.getRole());
			System.out.println("City="+this.currentUser.getCity());
			System.out.println("PhoneNumber="+this.currentUser.getPhoneNumber());
			System.out.println("Date Of Birth="+this.currentUser.getDateOfBirth());
			System.out.println("Nationality="+this.currentUser.getNationality());
			
		}

	
		public void updateOwnerOrSupplierInfo(User currentUser2) {
			 for (User user : MyApp.users) {
		          if(user.getUserName().equals(currentUser2.getUserName())) 
		          {
		              user.setEmail(currentUser2.getEmail());
		              user.setUserName(currentUser2.getUserName());
		              user.setPassword(currentUser2.getPassword());
		              user.setPhoneNumber(currentUser2.getPhoneNumber());
		        	  break;
		          }
		        }
			
		}

		
		
		
		

	 
}





