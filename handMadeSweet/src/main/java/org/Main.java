package org;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Sweet.App.MyApp;
import Sweet.App.Recipe;
import Sweet.App.User;
import Sweet.App.orders;
import Sweet.App.product;


public class Main {

 public static MyApp sweetAppSys=new MyApp();
	
	public static void logInProcess() 
	{
		Scanner scanner = new Scanner(System.in);
		while(true)
        {
			String userName;
			String password;
			String role;
			
			System.out.println("Enter The User Name: ");
			userName = scanner.nextLine();
			System.out.println("Enter The Password: ");
			password= scanner.nextLine();
			System.out.println("Enter The Role: ");
			role= scanner.nextLine();
			
		boolean logInFlag=sweetAppSys.currentUser.checkEmptyPassOrUname(userName, password);
		if(logInFlag==false) {System.out.println("please don't let the user name or password blank! ");}
		else 
		{
			if(sweetAppSys.authenticateUser(userName, password, role)) 
			{
				sweetAppSys.currentUser.isLoggedIn=true;
			    System.out.println("Welcome  "+sweetAppSys.currentUser.getUserName());
			    break;
			}
			else {System.out.println("please try another user name and password! "); }
		}
		}
	//	scanner.close();
	}
	
	
	public static void checkUnamePassEmailCity(String password,String userName,String email,String city,Scanner scanner) {
		while(true)
		{
			System.out.println("Enter Your Password: ");
			password = scanner.nextLine();
		    if(sweetAppSys.currentUser.checkPassword(password)){break;}
		    else {System.out.println("please don't let password blank! ");}	    
		}
		
		while(true)
		{
			System.out.println("Enter Your User Name: ");
			userName = scanner.nextLine();
		    if(sweetAppSys.currentUser.checkUserName(userName)){break;}
		    else
		    {
		    	if(sweetAppSys.currentUser.userNameFlag==0)System.out.println("please don't let user name blank! ");
		    	else if (sweetAppSys.currentUser.userNameFlag==1)System.out.println("please try another user name(this is exist in the DB)! ");
		    	
		    }	    
		}
		
		while(true)
		{
			System.out.println("Enter Your Email: ");
			email = scanner.nextLine();
		    if(sweetAppSys.currentUser.checkEmail(email)){break;}
		    else
		    {
		    	if(sweetAppSys.currentUser.emailFlag==0)System.out.println("please don't let user name blank! ");
		    	else if (sweetAppSys.currentUser.emailFlag==1)System.out.println("please try another Email! ");
		    	
		    }	    
		}
		
		 
		while(true)
		{
			System.out.println("Enter Your City: ");
			city = scanner.nextLine();
		    if(sweetAppSys.currentUser.checkCity(city)){break;}
		    else {System.out.println("please don't let city blank! ");}	    
		}
  }
	
	public static void signUpProcess() {
		Scanner scanner = new Scanner(System.in);
		
			String userName=null;
			String password=null;
			String firstName;
			String lastName;
			String email=null;
			String city=null;
			
			while(true)
			{
				System.out.println("Enter Your First Name: ");
			    firstName = scanner.nextLine();
			    if(sweetAppSys.currentUser.checkFirstName(firstName)){break;}
			    else {System.out.println("please don't let first name blank! ");}	    
			}
			
			while(true)
			{
				System.out.println("Enter Your Last Name: ");
				lastName = scanner.nextLine();
			    if(sweetAppSys.currentUser.checkLastName(lastName)){break;}
			    else {System.out.println("please don't let last name blank! ");}	    
			}
			
			checkUnamePassEmailCity(password,userName,email,city,scanner);

			sweetAppSys.addUser(sweetAppSys.currentUser);	
			System.out.println("Welcome "+sweetAppSys.currentUser.getUserName() +" To Our System!");
			System.out.println("Please Log In To The System......");
			logInProcess();
		//	scanner.close();
	
	}
	
	
	public static void editUserInfo() {
		if(sweetAppSys.currentUser.isLoggedIn==true) {
		System.out.println("Please Write Your New Information...");
		Scanner scanner = new Scanner(System.in);
		String userName=null;
		String password=null;
		String email=null;
		String city=null;
		
		ArrayList<User> users = MyApp.getUsers();
		
		for (User user : users) {
        	System.out.println(user.getUserName()+user.getEmail()+user.getPassword()+user.getCity());
        }
		
		checkUnamePassEmailCity(password, userName, email,city, scanner);
		sweetAppSys.updateUserInfo(sweetAppSys.currentUser);
		System.out.println("Your Info Updated Successfully! ");
		
		
        for (User user : users) {
        	System.out.println(user.getUserName()+user.getEmail()+user.getPassword()+user.getCity());
        }
        return;
		}
		else 	System.out.println("Please Log in first");
		logInProcess();
		
   //     scanner.close();	
        }
	
	


	public static void shareRecipe() {
		Scanner input = new Scanner(System.in);
		Recipe newRecipe=new Recipe();
		
		String title;
		String descreption;
	    String userName;
		String ingrediants;
		String time;
		String type;
		
		System.out.println("Please fill these informations...");
		while(true) {
		System.out.println("Title:");
	    title=input.nextLine();
	    if(newRecipe.checkTitle(title))break;
	    else System.out.println("Please don't let the title blank!");
	    }
		
		while(true) {
			System.out.println("Your User Name:");
			userName=input.nextLine();
		    if(newRecipe.checkUserName(userName))break;
		    else if(newRecipe.userNameFlag==1) System.out.println("Please don't let the userName blank!");
		    else System.out.println("Please use valid userName (exist on the data base).");
		    }
		
		
		while(true) {
			System.out.println("Ingrediants:");
			ingrediants=input.nextLine();
		    if(newRecipe.checkIngrediants(ingrediants))break;
		    else System.out.println("Please don't let the ingrediants blank!");
		    }
		
		while(true) {
			System.out.println("Type (please choose one of these (Egg-Free, Nut-free, Gluten-Free, Vegan):");
			type=input.nextLine();
		    if(newRecipe.checkType(type))break;
		    else System.out.println("Please choose one of valid type!");
		    }
	    
		System.out.println("Descreption:");
	    descreption=input.nextLine();
	    newRecipe.setDescription(descreption);
	    
	    System.out.println("Time to make:");
	    time=input.nextLine();
	    newRecipe.setTime(time);
		
	    
	    sweetAppSys.addRecipe(newRecipe);
	    System.out.println("Your Recipe added successfully!");
	    
	    ArrayList<Recipe> recipes = MyApp.getRecipes() ;
	    for (Recipe recipe : recipes) {
        	System.out.println(recipe.getTitle()+recipe.getUserName());
        }
	    
	    
    //    input.close();
	    
	}

	 private static void manageAccount(Scanner input) {
	        while (true) {
	            System.out.println("Manage Your Account:");
	            System.out.println("1- Show Your Information.");
	            System.out.println("2- Edit Your Profile Info.");
	            System.out.println("3- Delete Your Profile.");
	            System.out.println("4- Go Back.");

	            int choice = input.nextInt();
	            if (choice == 4) {
	                return; // Go back to the previous menu
	            }

	            switch (choice) {
	                case 1:
	                    sweetAppSys.getInfo(sweetAppSys.currentUser);
	                    continue;
	                case 2:
	                    editUserInfo();
	                    continue;
	                case 3:
	                    sweetAppSys.deleteUser(sweetAppSys.currentUser);
	                    System.out.println("Your Account deleted successfully!");
	                    return; // After deletion, go back to the main menu
	                default:
	                    System.out.println("Invalid option selected.");
	            }
	        }
	    }



		private static void searchRecipe(Scanner input) {
			 while (true) {
		            System.out.println("Write something to Search for a recipe:");
		            System.out.println("or enter 1 to Go Back.");


		            String choice = input.nextLine(); // Correct way to read user input

		            if (choice.equals("1")) { 
		                return; // Go back to the previous menus
		            }

		            boolean flag=sweetAppSys.checkSearchField(choice);
		            if(flag) 
		            {
		            	sweetAppSys.displayRecipeInfo();
		            	return;
		            }
		            else {sweetAppSys.printStm("Sorry! can't find this Recipe"); continue;}
		            
		        }
			
		}
	 
		
		

		private static void filterRecipes(Scanner input) {
			while (true) {
	            System.out.println("Choose one to filter the Recipes depends on it:");
	            System.out.println("1- Egg-Free");
	            System.out.println("2- Nut-Free");
	            System.out.println("3- Gluten-Free");
	            System.out.println("4- Vegan");
	            System.out.println("5- Go Back.");

	            String choice = input.nextLine();
	            if (choice.equals("5")) {
	                return; // Go back to the previous menu
	            }
	            boolean flag=sweetAppSys.checkFilterOption(choice);
	            if(flag) 
	            {
	            	sweetAppSys.showAllFilterdRecipes(choice);
	            }
	            else {sweetAppSys.printStm("Choose correct filter type!"); continue;}
	        }
			
		}
		
		
		
		
		private static void reportSalesAndProfit(Scanner input) {
			String branch=sweetAppSys.getBranchOwner(sweetAppSys.currentUser.getUserName());
			 
			while (true) {
	            System.out.println("sales and profits:");
	            System.out.println("1- total sales and profits in branch.");
	            System.out.println("2- total sales and profits in the branch for a specific product.");
	            System.out.println("3- Best-selling products .");
	            System.out.println("4- Go Back.");
	            
	            int choice = input.nextInt();
	            if (choice == 4) {
	                return; // Go back to the previous menu
	            }

	            switch (choice) {
	                case 1:
	                	sweetAppSys.ProfitsOfBranch(branch);
	        		    sweetAppSys.TotalSales(branch);
	                    continue;
	                case 2:
	                	ChooseProduct(input);
	                	
	                    continue;
	                case 3:
	                	List<product> topThreeProducts = sweetAppSys.GetTopBestThreeProducts(branch);
	                	 for (product product : topThreeProducts) {
	         		        System.out.println("Product Name: " + product.getpName());
	         		        System.out.println("Sales: " + product.getSalesCount());
	         		    }
	                    return; 
	                default:
	                    System.out.println("Invalid option selected.");
	            }
	           
			}
			
			
			
			
			
		}
		
      	private static void ChooseProduct(Scanner input) {
		    String branch = sweetAppSys.getBranchOwner(sweetAppSys.currentUser.getUserName());
		    
		    while (true) {
		        int numProduct = viewProductOption();
		        
		        System.out.print("Enter the number of the product: ");
		        int choice = input.nextInt();
		        
		        if (choice > 0 && choice < numProduct) {
		            int i = 1;
		            for (product product : sweetAppSys.products) {
		                if (product.getBranchName().equals(branch)) {
		                    if (product.getpName() != null) {
		                        if (i == choice) {
		                        	sweetAppSys.ProfitsOfProduct(product.getpName(),branch);
	                        	sweetAppSys.SalesOfProduct(product.getpName(),branch);
		                            return;
		                        }
		                        i++;
		                    }
		                }
		            }
		        } else if (choice == numProduct) {
		            System.out.println("Going back...");
		            return;
		        } else {
		            System.out.println("Invalid choice, please try again.");
		        }
		    }
		}

	    private static int viewProductOption() {
		String branch=sweetAppSys.getBranchOwner(sweetAppSys.currentUser.getUserName());
        int i=1;
        boolean branchHasProducts = false;
        System.out.println("Choose Product:");
	     for (product product : sweetAppSys.products) {
        	 if (product.getBranchName().equals(branch)) {
        		 if(product.getpName()!=null) {
        			
            System.out.println(i+"- "+product.getpName());
            i++;
           
            branchHasProducts = true;
        	 }
        	 }
        }	 
        	 if (!branchHasProducts) {
        	        System.out.println(branch+" does not have any products.");
        	        
        	    } else {
        	    	System.out.println(i+"- Go Back.");
                    
        	    }
		return i;
	}

	    private static void manageYorAccount(Scanner input) {
	    	 while (true) {
		            System.out.println("Manage Your Account:");
		            System.out.println("1- Show Your Information.");
		            System.out.println("2- Edit Your Profile Info.");
		            System.out.println("3- Delete Your Profile.");
		            System.out.println("4- Go Back.");

		            int choice = input.nextInt();
		            if (choice == 4) {
		                return; // Go back to the previous menu
		            }

		            switch (choice) {
		                case 1:
		                	sweetAppSys.OwnerORSuppliersgetInfo(sweetAppSys.currentUser);
		                    continue;
		                case 2:
		                	EditOwnerOrSupplierInfo();
		                    continue;
		                case 3:
		                	sweetAppSys.deleteUser(sweetAppSys.currentUser);
		                	  System.out.println("Your Account deleted successfully!");
		                    return; 
		                default:
		                    System.out.println("Invalid option selected.");
		            }
		        }
			
		}
	    
		private static void EditOwnerOrSupplierInfo() {
		
			
			if(sweetAppSys.currentUser.isLoggedIn==true) {
				System.out.println("Please Write Your New Information...");
				Scanner scanner = new Scanner(System.in);
				String userName=null;
				String password=null;
				String email=null;
				String city=null;
				String phoneNumber=null;
				ArrayList<User> users = MyApp.getUsers();
				
				for (User user : users) {
		        	System.out.println(user.getUserName()+user.getEmail()+user.getPassword()+user.getCity());
		        }
				
				checkUnamePassEmailCityPhoneNumber(password, userName, email,city, phoneNumber, scanner);
				sweetAppSys.updateUserInfo(sweetAppSys.currentUser);
				System.out.println("Your Info Updated Successfully! ");
				
				
		        for (User user : users) {
		        	System.out.println(user.getUserName()+user.getEmail()+user.getPassword()+user.getCity()+user.getPhoneNumber());
		        }
		        return;
				}
				else 	System.out.println("Please Log in first");
				logInProcess();
				
		
		}
	
		public static void checkUnamePassEmailCityPhoneNumber(String password,String userName,String email,String city,String phoneNumber,Scanner scanner) {
			while(true)
			{
				System.out.println("Enter Your Password: ");
				password = scanner.nextLine();
			    if(sweetAppSys.currentUser.checkPassword(password)){break;}
			    else {System.out.println("please don't let password blank! ");}	    
			}
			
			while(true)
			{
				System.out.println("Enter Your User Name: ");
				userName = scanner.nextLine();
			    if(sweetAppSys.currentUser.checkUserName(userName)){break;}
			    else
			    {
			    	if(sweetAppSys.currentUser.userNameFlag==0)System.out.println("please don't let user name blank! ");
			    	else if (sweetAppSys.currentUser.userNameFlag==1)System.out.println("please try another user name(this is exist in the DB)! ");
			    	
			    }	    
			}
			
			while(true)
			{
				System.out.println("Enter Your Email: ");
				email = scanner.nextLine();
			    if(sweetAppSys.currentUser.checkEmail(email)){break;}
			    else
			    {
			    	if(sweetAppSys.currentUser.emailFlag==0)System.out.println("please don't let user name blank! ");
			    	else if (sweetAppSys.currentUser.emailFlag==1)System.out.println("please try another Email! ");
			    	
			    }	    
			}
			
			
			while(true)
			{
				System.out.println("Enter Your City: ");
				city = scanner.nextLine();
			    if(sweetAppSys.currentUser.checkCity(city)){break;}
			    else {System.out.println("please don't let city blank! ");}	    
			}
			
			
			while(true)
			{
				System.out.println("Enter Your phoneNumber: ");
				phoneNumber = scanner.nextLine();
			    if(sweetAppSys.currentUser.checkPhoneNumber(phoneNumber)){break;}
			    else {System.out.println("please don't let phoneNumber blank! ");}	    
			}
		}

		public static void processAndTrackOrders() {
		    System.out.println("Processing and tracking orders...");
		    
		    if(sweetAppSys.sellers.isEmpty()) {
		        System.out.println("No orders to process.");
		        return;
		    }
		    for(orders order : sweetAppSys.sellers) {
		        processOrder(order); 
		    }
		    
		    System.out.println("All orders have been processed.");
		}
		
		
		public static void processOrder(orders order) {
			switch (order.getStatus()) {
	        case "on pending":
	            System.out.println("Processing pending order: " + order.getOrderId());
	            break;
	        case "on deliverd":
	            System.out.println("Processing delivered order: " + order.getOrderId());
	            break;
	        case "on processing":
	            System.out.println("Processing order in progress: " + order.getOrderId());
	            break;
	        case "cancelled":
	            System.out.println("Processing cancelled order: " + order.getOrderId());
	            break;
	        default:
	            System.out.println("Error: Unknown order status for order: " + order.getOrderId());
	            break;
	    }
			
		}
	/////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to our Sweet Management System, please choose one:");
            System.out.println("1- Sign Up");
            System.out.println("2- Log in");

            int choice = 0;
            while (true) {
                choice = input.nextInt();
                if (choice == 1 || choice == 2) {
                    break;
                } else {
                    System.out.println("Invalid option selected.");
                }
            }

            if (choice == 2) {
                logInProcess();
            } else if (choice == 1) {
                signUpProcess();
            }

            while (sweetAppSys.currentUser != null && sweetAppSys.currentUser.isLoggedIn) {
                if (sweetAppSys.currentUser.getRole().equals("User")) {
                    System.out.println("Welcome User, please choose what you want to do:");
                    System.out.println("1- Manage Your Account.");
                    System.out.println("2- Post and share personal dessert creations.");
                    System.out.println("3- Search for a recipe.");
                    System.out.println("4- Filter recipes.");
                    System.out.println("5- Buy a product or Search for a product.");
                    System.out.println("6- Send Massage to Owner or Supplier.");
                    System.out.println("7- Send Massage to the Admin");
                    System.out.println("8- Log out.");
                    System.out.println("9- Go Back to Main Menu.");

                    choice = 0;
                    while (true) {
                        choice = input.nextInt();
                        if (choice >= 1 && choice <= 9) {
                            break;
                        } else {
                            System.out.println("Invalid option selected.");
                        }
                    }

                    if (choice == 8) {
                        sweetAppSys.currentUser.isLoggedIn = false;
                        System.out.println("Logged out successfully.");
                        break; // Go back to the main menu (breaks the second interface loop)
                    } else if (choice == 9) {
                        break; // Go back to the main menu (continues the outer loop)
                    } else if (choice == 1) {
                        manageAccount(input);
                        if(MyApp.users.contains(sweetAppSys.currentUser))continue;
                        else break;
                    } else if (choice == 2) {
                        shareRecipe();continue;
                    } else if (choice == 3) {
                        searchRecipe(input); 
                        continue;
                    } else if (choice == 4) {
                        filterRecipes(input);
                    	continue;
                    }
                    else if (choice == 5) {
                    	buyProduct(input);
                    	continue;
                    }
                    else if (choice == 6) {
                       // sendMassage();
                    	continue;
                    }
                    else if (choice == 7) {
                       // SendFeedBack();
                    	continue;
                    }
                } 
                else if (sweetAppSys.currentUser.getRole().equals("Owner") || sweetAppSys.currentUser.getRole().equals("Suppliers")) {
                    System.out.println("Welcome " + sweetAppSys.currentUser.getRole() + ", please choose what you want to do:");
                    System.out.println("1- Add, update, and remove available products.");
                    System.out.println("2- Monitor sales and profits and best-selling products.");
                    System.out.println("3- Apply discount.");
                    System.out.println("4- Messaging system.");
                    System.out.println("5- Manage your Account.");
                    System.out.println("6- Process and track orders.");
                    System.out.println("7- Log out.");
                    System.out.println("8- Go Back to Main Menu.");

                    int choice1 = 0;
                    while (true) {
                        choice1 = input.nextInt();
                        if (choice1 >= 1 && choice1 <= 8) {
                            break;
                        } else {
                            System.out.println("Invalid option selected. Please choose again.");
                        }
                    }

                    switch (choice1) {
                        case 1:
                            // Call method to handle adding, updating, and removing products
                            break;
                        case 2:
                            reportSalesAndProfit(input);
                            break;
                        case 3:
                            // Call method to apply discount
                            break;
                        case 4:
                            // Call method for messaging system
                            break;
                        case 5:
                        	manageYorAccount(input);
                            if(MyApp.users.contains(sweetAppSys.currentUser))continue;
                            break;
                        case 6:
                        	processAndTrackOrders();
                            break;
                        case 7:
                            sweetAppSys.currentUser.isLoggedIn = false;
                            System.out.println("Logged out successfully.");
                            break;
                        case 8:
                            // Go back to the main menu
                            break;
                        default:
                            System.out.println("Invalid option selected.");
                            break;
                    }
                }

            
                      
                
                else if(sweetAppSys.currentUser.getRole().equals("Admin")) {}
                else {
                	System.out.println("Invalid choice!");
                	break;
                	}
            }
   
            // Check if user wants to exit the program
            System.out.println("Do you want to exit the program? (yes/no)");
            String exitChoice = input.next();
            if (exitChoice.equalsIgnoreCase("yes")) {
                break;
            }
        }

        input.close();
    }

 





/////////////////////////////////////////	
	
	private static void buyProduct(Scanner input) {
		 while (true) {
	            System.out.println("Write something to Search for a product:");
	            System.out.println("or enter 1 to Go Back.");

	            String choice = input.nextLine();
	            if (choice.equals("1")) {
	                return; // Go back to the previous menu
	            }

	            boolean flag=sweetAppSys.checkSearchProduct(choice);
	            if(flag) 
	            {
	            	sweetAppSys.showProductInfo();
	            	System.out.println("Enter the quantity that you want to buy from this product or just write Cancle.");
	            	String choice2= input.nextLine();
	            	boolean flagProd=sweetAppSys.buyProduct(choice2);
	            	if(flagProd)
	            	{
	            		sweetAppSys.printStm("Your order has been added successfully! Thank U for buying from our store...");
	            		sweetAppSys.printStm("Your order details:");
	            		sweetAppSys.printStm(sweetAppSys.currentOrder.toString()); 
	            	}
	            	else {
	            		if(sweetAppSys.buyProductCase==1) {sweetAppSys.printStm("You Cancelld the operation!");}//Cancel
	            		else if(sweetAppSys.buyProductCase==2) {sweetAppSys.printStm("Please enter a number!");}//not valid input, not integer
	            		else if(sweetAppSys.buyProductCase==3) {sweetAppSys.printStm("Don't enter a negative value!");}//negative qnt
	            		else if(sweetAppSys.buyProductCase==4) {sweetAppSys.printStm("Sorry! this product have quantity smaller than you want.");}//qnt greater than the product qnt
	            		continue;
	            	}
	         
	            	
	            }
	            else {sweetAppSys.printStm("Sorry! can't find this Product"); continue;}
	            
	        }
		
	}
	
	
	
	
	
}