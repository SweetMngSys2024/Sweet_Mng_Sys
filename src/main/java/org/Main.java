package org;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Sweet.App.FeedBack;
import Sweet.App.Massage;
import Sweet.App.MyApp;
import Sweet.App.Recipe;
import Sweet.App.User;
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
		
		//for (User user : users) {
        	System.out.println(sweetAppSys.currentUser.getUserName()+", "+sweetAppSys.currentUser.getEmail()+", "+sweetAppSys.currentUser.getPassword()+", "+sweetAppSys.currentUser.getCity());
     //   }
		
		checkUnamePassEmailCity(password, userName, email,city, scanner);
		sweetAppSys.updateUserInfo(sweetAppSys.currentUser);
		System.out.println("Your Info Updated Successfully! ");
		
		
       // for (User user : users) {
    	System.out.println(sweetAppSys.currentUser.getUserName()+", "+sweetAppSys.currentUser.getEmail()+", "+sweetAppSys.currentUser.getPassword()+", "+sweetAppSys.currentUser.getCity());
      //  }
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
        	System.out.println("Title: "+recipe.getTitle()+" ,User name: "+recipe.getUserName());
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
			  System.out.println("Write something to Search for a recipe:");
	            System.out.println("or enter 1 to Go Back.");
			 while (true) {
		          
				 String choice = input.nextLine().trim(); // Correct way to read user input
				 if(choice.isEmpty())continue;

		            if (choice.equals("1")) { 
		                return; // Go back to the previous menus
		            }

		            boolean flag=sweetAppSys.checkSearchField(choice);
		            if(flag) 
		            {
		            	sweetAppSys.displayRecipeInfo();
		            	return;
		            }
		            else {sweetAppSys.printStm("Sorry! can't find this Recipe, re-write the recipe or enter 1 to go back menu"); continue;}
		            
		        }
			
		}
	 
		
		

		private static void filterRecipes(Scanner input) {
			   System.out.println("Choose one to filter the Recipes depends on it:");
	            System.out.println("1- Egg-Free");
	            System.out.println("2- Nut-Free");
	            System.out.println("3- Gluten-Free");
	            System.out.println("4- Vegan");
	            System.out.println("5- Go Back.");
			while (true) {
	         

	            String choice = input.nextLine().trim(); 
				 if(choice.isEmpty())continue;
	            if (choice.equals("5")) {
	                return; // Go back to the previous menu
	            }
	            boolean flag=sweetAppSys.checkFilterOption(choice);
	            if(flag) 
	            {
	            	sweetAppSys.showAllFilterdRecipes(choice);
	            }
	            else {sweetAppSys.printStm("Choose correct filter type!"); }
	            System.out.println("Choose one to filter the Recipes depends on it:");
	            System.out.println("1- Egg-Free");
	            System.out.println("2- Nut-Free");
	            System.out.println("3- Gluten-Free");
	            System.out.println("4- Vegan");
	            System.out.println("5- Go Back.");
	        }
			
		}

		
		
		
		
		

		private static void checkCityAndBranch(Scanner input) {
			sweetAppSys.printStm("Here there are all branchs with their cities: (please choose one)");
			sweetAppSys.printStm("Branch 1(Nablus), Branch 2(Nablus), Branch 3(Jenin), Branch 4(Jenin)");
			while(true) {
			sweetAppSys.printStm("Write the branch that U want to buy from it:");
			sweetAppSys.printStm("Write 1 to Go Back!");
			String choice2= input.nextLine();
			if(choice2.equals("1"))return;
			boolean flag=sweetAppSys.currentOrder.checkBranch(choice2);
			if(flag)
			{
				while(true) {
				sweetAppSys.printStm("Write the city that U want to buy from it:");
				sweetAppSys.printStm("Write 1 to Go Back!");
				String choice3= input.nextLine();
				if(choice2.equals("1"))return;
				boolean flag2=sweetAppSys.currentOrder.checkCity(choice3);
				if(flag2)return;
				}
			}
			else sweetAppSys.printStm("Please write a valid branch name!");
			}
			
		}
		 
	
			
			private static void buyProduct(Scanner input) {
				System.out.println("Write something to Search for a product:");
	            System.out.println("or enter 1 to Go Back.");

				 while (true) {
			            
			            String choice = input.nextLine().trim();
						 if(choice.isEmpty())continue;
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
			            		
			            		checkCityAndBranch(input);
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
			            else {sweetAppSys.printStm("Sorry! can't find this Product, try again or enter 1 to go back"); continue;}
			            
			        }
				
			}
			
			
			

			private static void sendFeedBack(Scanner input) {
				FeedBack currentFeedBack=new FeedBack();
				System.out.println("Write the type of the feedback (Recipe,Product)...");
	            System.out.println("or enter 1 to Go Back.");
				 while (true) {
			            

			            String choice = input.nextLine().trim(); 
						 if(choice.isEmpty())continue;
			            if (choice.equals("1")) {
			                return; // Go back to the previous menu
			            }

			            boolean flag=currentFeedBack.checkType(choice);
			            if(flag) //correct type
			            {
			            	currentFeedBack.setType(choice);
			            	while(true) {
			            	System.out.println("Enter the name of the product or recipe that you want to give a feedback for it...");
			            	String choice2= input.nextLine();
			            	boolean flagProd=currentFeedBack.checkName(choice2);
			            	if(flagProd)
			            	{
			            		currentFeedBack.setProductRecipeName(choice2);
			            		while(true) {
			            		sweetAppSys.printStm("Write the massage of the feedback:");
			            		
			            		String msg= input.nextLine();
				            	boolean flagmsg=currentFeedBack.checkMsg(msg);
				            	if(flagmsg)
				            	{
				            		currentFeedBack.setMgs(msg);
				            		sweetAppSys.addFeedBack(currentFeedBack);
				            		sweetAppSys.printStm("The feedback sent successfully!!");
				            		return;
				            	}
				            	else {
				            		sweetAppSys.printStm("Don't let the massage empty!");
				            		continue;
				            	}
			            		}
				           	
			            	}
			            	else {
			            		sweetAppSys.printStm("Sorry! this product or recipe doesn't exist!");
			            		continue;
			            	}
			            	}
			            }
			            else {sweetAppSys.printStm("Please write valid type!  try again or enter 1 to go back menu"); continue;}
			        }
			}

			
			
			private static void sendMassage(Scanner input) {
				if(!sweetAppSys.currentUser.userRecievedMsgs.isEmpty()) {
				    System.out.println("*****these are all your recived messages");
					for(Massage msg: sweetAppSys.currentUser.userRecievedMsgs)System.out.println(msg.toString());}
				
				Massage currentMsg=new Massage();
				 System.out.println("Write the Branch that you want to contact with their maneger (Branch 1,Branch 2, Branch 3, Branch 4).");
		            System.out.println("or enter 1 to Go Back.");
				 while (true) {
			           

			            String uNameDest = input.nextLine().trim(); 
						 if(uNameDest.isEmpty())continue;
			            if (uNameDest.equals("1")) {
			                return; // Go back to the previous menu
			            }

			            boolean flag=currentMsg.checkuNameDest(uNameDest);
			            if(flag) //correct type
			            {
			            	currentMsg.setuNameDest(uNameDest);
			            	while(true) {
			            	System.out.println("Enter the type of the maneger (Owner, Supplier).");
			            	String type= input.nextLine();
			            	boolean flagType=currentMsg.checkDstType(type);
			            	if(flagType)
			            	{
			            		currentMsg.setTypeOfDest(type);
			            		while(true) {
			            		sweetAppSys.printStm("Write the massage of the feedback:");
			            		
			            		String msg= input.nextLine();
				            	boolean flagmsg=currentMsg.checkMsg(msg);
				            	if(flagmsg)
				            	{
				            		currentMsg.setMgs(msg);
				            		sweetAppSys.sendMsg(currentMsg);
				            		sweetAppSys.printStm("The Massage sent successfully!!");
				            		System.out.println(sweetAppSys.currentUser.userSentMsgs.toString());
				            		return;
				            	}
				            	else {
				            		sweetAppSys.printStm("Don't let the massage empty!");
				            		continue;
				            	}
			            		}
				           	
			            	}
			            	else {
			            		sweetAppSys.printStm("Please enter valid Destination type!");
			            		continue;
			            	}
			            	}
			            }
			            else {sweetAppSys.printStm("Please write valid branch name! try again or enter 1 to go back"); continue;}
			        }
				
			}
	
			private static void createOwnerSupplierAccountByAdmin(Scanner input) {
				User newUser=new User();
				System.out.println("Enter The First Name of the worker: ");
				System.out.println("or enter 1 to Go Back!");
				while(true)
				{
					
				    String firstName = input.nextLine().trim();
				    if(firstName.isEmpty())continue;
				    if(firstName.equals("1"))return;
				    if(newUser.checkFirstName(firstName)){break;}
				    else {System.out.println("please don't let first name blank! ");}	
				    System.out.println("Enter The First Name of the worker: ");
					System.out.println("or enter 1 to Go Back!");
				}
				
				System.out.println("Enter The Last Name of the worker: ");
				System.out.println("or enter 1 to Go Back!");
				while(true)
				{
					
				    String lastName = input.nextLine().trim();
				    if(lastName.isEmpty())continue;
				    if(lastName.equals("1"))return;
				    if(newUser.checkLastName(lastName)){break;}
				    else {System.out.println("please don't let last name blank! ");}	
				    System.out.println("Enter The Last Name of the worker: ");
					System.out.println("or enter 1 to Go Back!");
				}
				
				System.out.println("Enter The Password of the worker: ");
				System.out.println("or enter 1 to Go Back!");
				while(true)
				{
					
				    String password = input.nextLine().trim();
				    if(password.isEmpty())continue;
				    if(password.equals("1"))return;
				    if(newUser.checkPassword(password)){break;}
				    else {System.out.println("please don't let password blank! ");}	 
				    System.out.println("Enter The Password of the worker: ");
					System.out.println("or enter 1 to Go Back!");
				}
				
				System.out.println("Enter The User Name of the worker: ");
				System.out.println("or enter 1 to Go Back!");
				while(true)
				{
					
				    String uName = input.nextLine().trim();
				    if(uName.isEmpty())continue;
				    if(uName.equals("1"))return;
				    if(newUser.checkUserName(uName)){break;}
				    else if(newUser.userNameFlag==0){System.out.println("please don't let user name blank! ");}	    
				    else if(newUser.userNameFlag==1){System.out.println("please try another user name, this is already used! ");}	
				    System.out.println("Enter The User Name of the worker: ");
					System.out.println("or enter 1 to Go Back!");
				}
				
				System.out.println("Enter The Email of the worker: ");
				System.out.println("or enter 1 to Go Back!");
				while(true)
				{
					
				    String email = input.nextLine().trim();
				    if(email.isEmpty())continue;
				    if(email.equals("1"))return;
				    if(newUser.checkEmail(email)){break;}
				    else if(newUser.userNameFlag==0){System.out.println("please don't let user name blank! ");}	    
				    else if(newUser.userNameFlag==1){System.out.println("please write valid email format! ");}
				    System.out.println("Enter The Email of the worker: ");
					System.out.println("or enter 1 to Go Back!");
				}
				
				System.out.println("Enter The Role of the worker:(Owner,Supplier)");
				System.out.println("or enter 1 to Go Back!");
				while(true)
				{
					
				    String role = input.nextLine().trim();
				    if(role.isEmpty())continue;
				    if(role.equals("1"))return;
				    if(newUser.checkRoleType(role)){break;}
				    else {System.out.println("please write a valid role type! ");}	
				    System.out.println("Enter The Role of the worker:(Owner,Supplier)");
					System.out.println("or enter 1 to Go Back!");
				}
				
				while(true) {
					String userCity;
					String userBranch;
					
					System.out.println("Enter The Branch of the worker:(Branch 1->Nablus, Branch 2->Nablus, Branch 3->Jenin, Branch 4->Jenin)");
					System.out.println("or enter 1 to Go Back!");
				while(true)
				{
					
				    String branch = input.nextLine().trim();
				    if(branch.isEmpty())continue;
				    if(branch.equals("1"))return;
				    if(newUser.checkBranch(branch)) {userBranch=branch; break;}
				    else {System.out.println("please write a valid branch name! ");}	
				    System.out.println("Enter The Branch of the worker:(Branch 1->Nablus, Branch 2->Nablus, Branch 3->Jenin, Branch 4->Jenin)");
					System.out.println("or enter 1 to Go Back!");
				}
				
				System.out.println("Enter The City that the worker works in:(Jenin, Nablus)");
				System.out.println("or enter 1 to Go Back!");
				while(true)
				{
					
				    String city = input.nextLine().trim();
				    if(city.isEmpty())continue;
				    if(city.equals("1"))return;
				    if(newUser.checkCityBranchPosition(city)) {userCity=city; break;}
				    else {System.out.println("please write a valid city of branch location name! ");}	    
				    System.out.println("Enter The City that the worker works in:(Jenin, Nablus)");
					System.out.println("or enter 1 to Go Back!");
				}
				if(sweetAppSys.VerifyBranchInCity(userBranch, userCity))break;
				else System.out.println("This branch doen't exist in this city!!");
				
				}
				
				System.out.println("Enter The City that the worker lives in: ");
				System.out.println("or enter 1 to Go Back!");
				while(true)
				{
					
				    String userLivedCity = input.nextLine().trim();
				    if(userLivedCity.isEmpty())continue;
				    if(userLivedCity.equals("1"))return;
				    if(newUser.checkCity(userLivedCity)){break;}
				    else {System.out.println("please don't let City that the worker lives in blank! ");}	  
				    System.out.println("Enter The City that the worker lives in: ");
					System.out.println("or enter 1 to Go Back!");
				}
				
				sweetAppSys.addUser(newUser);
				System.out.println("The Worker Added Successfully!!!!");
				
			}
				
			
			
			private static void deleteAccount(Scanner input) {
				System.out.println("Enter The User Name of the user that you wants to delete his account: ");
				System.out.println("or enter 1 to Go Back!");
				while(true)
				{
				
				    String deletedUser = input.nextLine().trim();
				    if(deletedUser.isEmpty())continue;
				    if(deletedUser.equals("1"))return;
				    if(sweetAppSys.deleteUserByName(deletedUser)){System.out.println("This User account has been deleted successfully! "); break;}
				    else {System.out.println("please enter a valid user name! ");}	    
					System.out.println("Enter The User Name of the user that you wants to delete his account: ");
					System.out.println("or enter 1 to Go Back!");
				}
				//for(User user: MyApp.users) {
				//System.out.println("---- "+user.getUserName());
				//}
			}

			
			
			
			private static void getAllProfits(Scanner input) {
				double totalProfits = sweetAppSys.calculateTotalProfitsForAllCities();
				sweetAppSys.printStm("Total profits for all cities: " + totalProfits);
			    
				 System.out.println("The total financial report:::::");
				 boolean flag=sweetAppSys.showAllOrders();
				 if (!flag) sweetAppSys.printStm("There's no orders!");
					
				}



				private static void getCityProfits(Scanner input) {
					User dumpUser=new User();
					sweetAppSys.printStm("Please write one of these cities:(Jenin, Nablus)");
					System.out.println("or enter 1 to Go Back!");
					while(true)
					{
						
					    String city = input.nextLine().trim();
					    if(city.isEmpty())continue;
					    if(city.equals("1"))return;
					    if(dumpUser.checkCityBranchPosition(city)){break;}
					    else {System.out.println("please re-write the city! ");}	
					    sweetAppSys.printStm("Please write one of these cities:(Jenin, Nablus)");
						System.out.println("or enter 1 to Go Back!");
					}
					double totalProfits = sweetAppSys.calculateTotalProfitsForCity(dumpUser.getCityOwnerSupplier());
					sweetAppSys.printStm("Total profits for all branches in " + dumpUser.getCityOwnerSupplier() + ": " + totalProfits);
				    
					 System.out.println("The total financial report:::::");
					 boolean flag=sweetAppSys.showAllOrdersInCity(dumpUser.getCityOwnerSupplier());
					 if (!flag) sweetAppSys.printStm("There's no orders!");
					
				}


				private static void getBranchProfits(Scanner input) {
					User dumpUser=new User();
					sweetAppSys.printStm("Please write one of these branches:(Branch 1, Branch 2, Branch 3, Branch 4)");
					System.out.println("or enter 1 to Go Back!");
					while(true)
					{
						
					    String branch = input.nextLine().trim();
					    if(branch.isEmpty())continue;
					    if(branch.equals("1"))return;
					    if(dumpUser.checkBranch(branch)){break;}
					    else {System.out.println("please re-write the branch name! ");}	    
					    sweetAppSys.printStm("Please write one of these branches:(Branch 1, Branch 2, Branch 3, Branch 4)");
						System.out.println("or enter 1 to Go Back!");
					}
					if( dumpUser.getBranch().equals("Branch 1")||dumpUser.getBranch().equals("Branch 2"))dumpUser.setCityOwnerSupplier("Nablus");
					else if( dumpUser.getBranch().equals("Branch 3")||dumpUser.getBranch().equals("Branch 4"))dumpUser.setCityOwnerSupplier("Jenin");

					 double totalProfits = sweetAppSys.calculateTotalProfitsForBranchInCity(dumpUser.getBranch(), dumpUser.getCityOwnerSupplier());
					 sweetAppSys.printStm("Total profits for the " + dumpUser.getBranch() + " in " +  dumpUser.getCityOwnerSupplier() + " is:  " + totalProfits);
					 
					 System.out.println("The total financial report:::::");
					 boolean flag=sweetAppSys.showAllOrdersInBranch(dumpUser.getBranch());
					 if (!flag) sweetAppSys.printStm("There's no orders!");
					
				}
				
				
				private static void findBestSellingProduct(Scanner input) {

					product bestSellingProduct;
					sweetAppSys.printStm("Please write the Branch name(write one of these: Branch 1, Branch 2, Branch 3, Branch 4):");
					System.out.println("or enter 1 to Go Back!");
					while(true)
					{
						
					    String branch = input.nextLine().trim();
					    if(branch.isEmpty())continue;
					    if(branch.equals("1"))return;
					    bestSellingProduct = sweetAppSys.findBestSellingProductInBranch(branch);  
					    if (bestSellingProduct != null) {
				            System.out.println("Best-selling product in " + branch + ": " + bestSellingProduct.getpName() +
				                               " with sales count: " + bestSellingProduct.getSalesCount()+"\n\n");
				      
				        }
					    sweetAppSys.printStm("Please write the Branch name(write one of these: Branch 1, Branch 2, Branch 3, Branch 4):");
						System.out.println("or enter 1 to Go Back!");
					}
				}


				

				private static void statisticsUsers(Scanner input) {
					
					
			  	  while(true) {
			  	  System.out.println("Choose one:");
			  	  System.out.println("1- Show the statistics for all registered users in all cities.");
			  	  System.out.println("2- Show them in specific city.");
			  	  System.out.println("3- Go Back.");
			  	  
			  	  int choice2 =0;
			  	  while (true) {
			  		  choice2 = input.nextInt();
			            if (choice2 >= 1 && choice2 <= 3) {
			                break;
			            } else {
			                System.out.println("Invalid option selected.");
			            }
			            }
			  	  if(choice2==1) {
			  		  boolean flag=sweetAppSys.registerdUsersInAllCities();
			  		  if(!flag)System.out.println("The system is new! there's no one user.");
			  	  }
			  	  else if(choice2==2) {
			  		System.out.println("Please write the city you want (Like: Jenin, Nablus, Ramallah,...etc");
			  		while(true) {
			  		String city= input.nextLine().trim();
			  		if(city.isEmpty())continue;
			  		if(city.equals("1"))break;
			  		boolean validCity= sweetAppSys.checkValidCity(city);
			  		if(validCity) 
			  		{
			  			boolean numUsers=sweetAppSys.showCityUsersInfo(city);
			  			if(!numUsers)System.out.println("There's no users registerd in this city!");
			  			
			  		}
			  		else  System.out.println("The city name is invalid in our system database!");
			  		System.out.println("Please write the city you want (Like: Jenin, Nablus, Ramallah,...etc");
			  		System.out.println("Or enter 1 to go back");
			  		}
			  	  }
			  	  else if(choice2==3) {break;}
			        
			        }
				}
				

				private static void manageRecipes(Scanner input) {
					
				  	  while(true) {
				  	  System.out.println("Choose one:");
				  	  System.out.println("1- View all recipes.");
				  	  System.out.println("2- Delete a specific recipe.");
				  	  System.out.println("3- Edit a specific recipe.");
				  	  System.out.println("4- Go Back.");
				  	  
				  	  int choice2 =0;
				  	  while (true) {
				  		  choice2 = input.nextInt();
				            if (choice2 >= 1 && choice2 <= 4) {
				                break;
				            } else {
				                System.out.println("Invalid option selected.");
				            }
				            }
				  	  if(choice2==1) {sweetAppSys.ViewAllRecipes();}
				  	  else if(choice2==2) {
				  		 System.out.println("Please enter the title of the recipe that you want to delete, or just enter 1 to go back.");
				  		 while(true) {
				  	    String title = input.nextLine().trim();
				  		if(title.isEmpty())continue;
				  	     if(title.equals("1"))break;
				  	    boolean deleteRecipe=sweetAppSys.deleteRecipe(title);
				  	    if(deleteRecipe) 
				  	    {if(sweetAppSys.recipeExists(title)==null) {System.out.println("The recipe has deleted successfully."); break;}}
				  	  System.out.println("The specified recipe does not exist, re-write it or just enter 1 to go back");

				  	    }
				  	  }
				  	 else if(choice2==3)
				  	 {
				  		 Recipe updatedrecipe=null;
				  		System.out.println("Please enter the title of the recipe that you want to update its info, or just enter 1 to go back.");
				  		while(true) {
					  	String title = input.nextLine().trim();
				  		if(title.isEmpty())continue;
					  	if(title.equals("1"))break;
				  		Recipe specificRecipe=sweetAppSys.recipeExists(title);
						 if(specificRecipe!=null){
							 
					     updatedrecipe=specificRecipe;
						 
						 System.out.println("Please enter the new description of the recipe:");
						 String description = input.nextLine();	 
						 updatedrecipe.setDescription(description);
						 
						 System.out.println("Please enter the new time of the recipe:");
						 String time = input.nextLine();	 
						 updatedrecipe.setTime(time);
						 
						 while(true)
							{
								System.out.println("Please enter the new ingrediants of the recipe, or just enter 1 to go back.");
							    String ingrediants = input.nextLine();
							    if(ingrediants.equals("1"))break;
							    boolean ingrediantsFlag=updatedrecipe.checkIngrediants(ingrediants);
							    if(!ingrediantsFlag) {System.out.println("please don't let the ingrediants field blank! "); continue;}
							    System.out.println("The recipe has updated successfully!");
								System.out.println("The new recipe info: "+updatedrecipe.toString());
							    break;
							}
						 break;}
						 else {System.out.println("This recipe doesn't exist! try again or just enter 1 to go back");}
						 }
						 
				  	 }else if(choice2==4) {break;}
				        
				        }
				  	  
				}

				

private static void deleteFeedBack(Scanner input) {
	  while(true) {
		  
	  	  System.out.println("Please enter the sender user name:(to go back just enter 1)");
	  	  String uName=input.nextLine().trim();
	  		if(uName.isEmpty())continue;
	  		 if(uName.equals("1"))return;
	  	  System.out.println("Please enter the product/recipe name:(to go back just enter 1)");
	  	  String pName=input.nextLine().trim();
	  		if(pName.isEmpty())continue;
	  	
	  	 if(pName.equals("1"))return;
	  	boolean flag=sweetAppSys.deleteFeedBack(uName,pName);
	  	if(!flag)continue;
	  	
	  	if(sweetAppSys.FeedBackExists(uName,pName))  System.out.println("The feedback has deleted successfully!");
	  	break;
	  	  
	  }
	
}

	private static void manageFeedBacksByAdmin(Scanner input) {


	  	  while(true) {
	  	  System.out.println("Choose one:");
	  	  System.out.println("1- View all feedbacks.");
	  	  System.out.println("2- Delete a feedback.");
	  	  System.out.println("3- Go Back.");
	  	  
	  	  int choice2 =0;
	  	  while (true) {
	  		  choice2 = input.nextInt();
	            if (choice2 >= 1 && choice2 <= 3) {
	                break;
	            } else {
	                System.out.println("Invalid option selected.");
	            }
	            }
	  	  if(choice2==1) {sweetAppSys.ViewAllFeedBack();}
	  	  else if(choice2==2) {deleteFeedBack(input);}
	  	  else if(choice2==3)return;
	  	  }
		
	}



private static void addProduct(Scanner input) {
	product newProduct=new product();
	 System.out.println("Please enter the product name or enter 1 to go back.");
	while(true) {
	
	 String pName=input.nextLine().trim();
	 if(pName.isEmpty())continue;
	 if(pName.equals("1"))return;
	 boolean validProductName=sweetAppSys.checkValidProductName(pName, sweetAppSys.currentUser.getBranch());
	 if(!validProductName) {System.out.println("Invalid product name, write another one!");}
	 else {
		 newProduct.setpName(pName);
		 
		 System.out.println("Enter the description, or enter 1 to go  back to the menu.");
		 String description=input.nextLine();
		 if(description.equals("1"))return;
		 newProduct.setDescription(description);
		 
		
		 while(true) {
			 System.out.println("Enter the price, or enter 1 to go  back to the menu.");
			 String price=input.nextLine();
			 if(price.equals("1"))return;
		     boolean validPrice=newProduct.checkValidPrice(price);
		     if(!validPrice) {System.out.println("This is invalid Price!");}
		     else break;
		 }
		 

		 while(true) {
			 System.out.println("Enter the Quantity, or enter 1 to go  back to the menu.");
			 String qnt=input.nextLine();
			 if(qnt.equals("1"))return;
			 boolean validQnt=newProduct.checkValidQnt(qnt);
			 if(!validQnt){System.out.println("This is invalid Qnt!");}
		     else break;
		 }
		 
		 while(true) {
			 System.out.println("Enter the Discount, or enter 1 to go  back to the menu.");
			 String discount=input.nextLine();
			 if(discount.equals("1"))return;
			 boolean validDiscount=newProduct.checkValidDiscount(discount);
			 if(!validDiscount){System.out.println("This is invalid Discount!");}
		     else break;
		 }
		  
			newProduct.setBranchName(sweetAppSys.currentUser.getBranch());
			newProduct.setSupplier(sweetAppSys.currentUser.getUserName());
		    boolean flag=sweetAppSys.addNewProduct(newProduct);
		    if(!flag){System.out.println("The product is null!"); continue;}
		 
		 break;
	 }
	 System.out.println("Please enter the product name or enter 1 to go back.");
  }
	}


private static void deleteProduct(Scanner input) {
	
	 System.out.println("\nThe all product in your branch are:");
	 sweetAppSys.showAllProductsInBranch(sweetAppSys.currentUser.getBranch());
	 
	 System.out.println("\n\n*********************\n\n");
	 
	 System.out.println("Please write the product name that you want to delete:");
	 System.out.println("Or enter one to go back menu");
	 while(true) {
	
	 String deletedProduct=input.nextLine().trim();
		if (deletedProduct.isEmpty()) {
            continue;
        }
	 if(deletedProduct.equals("1"))return;
	 
	 product checkPname=sweetAppSys.checkExistingProduct(deletedProduct,sweetAppSys.currentUser.getBranch());
	 if(checkPname!=null) {
		 boolean flag= sweetAppSys.deleteProduct(checkPname);
		    if(flag) {
		       System.out.println("This product has deleted successfully!");
		       break;
		    }
		    else System.out.println("Sorry! can't find this product!"); 
	 }
	 else System.out.println("This product doesn't exist to delete it !");
	 
	 System.out.println("Please write the product name that you want to delete:");
	 System.out.println("Or enter one to go back menu");

	 }
	 
}


private static void updateProduct(Scanner input) {
	 System.out.println("\nThe all product in your branch are:");
	 sweetAppSys.showAllProductsInBranch(sweetAppSys.currentUser.getBranch());
	 
	 System.out.println("\n\n*********************\n\n");
	 
	 product newProduct;
	 System.out.println("Please write the product name that you want to update:");
	 System.out.println("Or enter one to go back menu");
	 while(true) {
		 
		 String updatedProduct=input.nextLine().trim();
			if (updatedProduct.isEmpty()) {
	            continue;
	        }
		 if(updatedProduct.equals("1"))return;
		 
		 newProduct=sweetAppSys.findProductByName(updatedProduct, sweetAppSys.currentUser.getBranch());
		 if(newProduct==null) { System.out.println("This product doesn't exist, try another one!"); System.out.println("\nPlease write the product name that you want to update:");
		 System.out.println("Or enter one to go back menu"); continue;}
		 break;
	 }
	 while(true) {
	 System.out.println("Choose one to update:");
	 System.out.println("1- Update the description.");
	 System.out.println("2- Update the price.");
	 System.out.println("3- Update the quantity.");
	 System.out.println("4- Update the discount.");
	 System.out.println("5- Update the salesCount.");
	 System.out.println("6- Update the supplier name.");
	 System.out.println("7- Go back.");
	 
	 int option;
	 while (true) {
		 option=input.nextInt();
         if (option >= 1 && option <= 7) {
             break;
         } else {
             System.out.println("Invalid option selected.");
         }
     }
	 if(option==7)return;
	 else if(option==1) {
		 System.out.println("The old description was:"+newProduct.getDescription()+", and the new will be:");
		 
		 while(true) 
		 {
			 String description=input.nextLine().trim();
				if (description.isEmpty()) {
		            continue;
		        }
			 if(description.equals("1"))break;
			boolean validDescription=newProduct.checkValidDescription(description);
			if(!validDescription) {System.out.println("Don't let the description empty! try again or enter 1 to go back to the menu...");}
			else { System.out.println("The decription has updated successfully!"); break;} } }
	 
	 else if(option==2)
	 {
		 System.out.println("The old price was:"+newProduct.getPrice()+", and the new will be:");
		 while(true) 
		 {
			 String price=input.nextLine().trim();
				if (price.isEmpty()) {
		            continue;
		        }
			 if(price.equals("1"))break;
			boolean validPrice=newProduct.checkValidPrice(price);
			if(!validPrice) {System.out.println("Invalid price! try again or enter 1 to go back to the menu...");}
			else { System.out.println("The price has updated successfully!"); break;} }  }
	 
	 
	 else if(option==3) {
		 System.out.println("The old qnt was:"+newProduct.getQuantity()+", and the new will be:");
		 while(true) 
		 {
			 String quantity=input.nextLine().trim();
				if (quantity.isEmpty()) {
		            continue;
		        }
			 if(quantity.equals("1"))break;
			boolean validQnt=newProduct.checkValidQnt(quantity);
			if(!validQnt) {System.out.println("Invalid quantity! try again or enter 1 to go back to the menu...");}
			else { System.out.println("The Qunatity has updated successfully!"); break;} } }
	 
	 
	 else if(option==4) { 
		System.out.println("The old discount was:"+newProduct.getDiscount()+", and the new will be:");
	 while(true) 
	 {
		 String discount=input.nextLine().trim();
			if (discount.isEmpty()) {
	            continue;
	        }
		 if(discount.equals("1"))break;
		boolean validDiscount=newProduct.checkValidDiscount(discount);
		if(!validDiscount) {System.out.println("Invalid discount! try again or enter 1 to go back to the menu...");}
		else { System.out.println("The discount has updated successfully!"); break;} } }
	 
	 
	 else if(option==5) {
		 System.out.println("The old sales count was:"+newProduct.getSalesCount()+", and the new will be:");
		 while(true) 
		 {
			 String salesCount=input.nextLine().trim();
				if (salesCount.isEmpty()) {
		            continue;
		        }
			 if(salesCount.equals("1"))break;
			boolean validSalesCount=newProduct.checkValidSalesCount(salesCount);
			if(!validSalesCount) {System.out.println("Invalid sales count! try again or enter 1 to go back to the menu...");}
			else { System.out.println("The sales count has updated successfully!"); break;} }  }
	 
	 
	 else if(option==6) {
		 System.out.println("The old supplier name was:"+newProduct.getSupplier()+", and the new will be:");
		 while(true) 
		 {
			 String supplierName=input.nextLine().trim();
				if (supplierName.isEmpty()) {
		            continue;
		        }
			 if(supplierName.equals("1"))break;
			boolean validSupplierName=sweetAppSys.checkValidSupplierName(supplierName);
			if(!validSupplierName) {System.out.println("This supplier name doesn't exist in out system database! try again or enter 1 to go back to the menu...");}
			else {newProduct.setSupplier(supplierName);  System.out.println("The supplier name has updated successfully!"); break;} } 
	 }
	 }
	
}

	private static void manageProducts(Scanner input) {
		 System.out.println("To manage products, please choose one:");
		 System.out.println("1- Add a product.");
		 System.out.println("2- Delete a product.");
		 System.out.println("3- Update a product.");
		 System.out.println("4- Go Back.");
		 
		 int option;
		 while (true) {
			 option = input.nextInt();
             if (option >= 1 && option <= 4) {
                 break;
             } else {
                 System.out.println("Invalid option selected.");
             }
         }
		 
		 if(option==1) {addProduct(input);}
		 else if(option==2) {deleteProduct(input);}
		 else if(option==3) {updateProduct(input); }
		 else if(option==4) {return;}
		 }
		
	
	
	private static void applyDiscount(Scanner input) {
		double minPrice=0.0;
		System.out.println("Write the minimum price that you want to apply the discount on it:");
		String price;
		while(true) {
			price=input.nextLine().trim();
			if (price.isEmpty()) {
	            continue;
	        }
			if(price.equals("1"))return;
			minPrice=product.checkMinPrice(price);
			if(minPrice!=-1) break;
		}
		
		System.out.println("Enter the discount to apply (e.g., 0.15 for 15%, 0.5 for 50%):");
		String discount;
		double appliedDiscount=0.0;
		while(true) {
			discount=input.nextLine().trim();
			if (discount.isEmpty()) {
	            continue;
	        }
			if(discount.equals("1"))return;
			appliedDiscount=product.checkDiscount(discount);
			if(appliedDiscount!=-1) break;
		
		}
		System.out.println("\n\nThen the all product befor discount are:");
		boolean checkProductArray=sweetAppSys.showAllProductsInTheBranch(sweetAppSys.currentUser.getBranch());
		if(!checkProductArray)System.out.println("There's no product!!!");
		
		sweetAppSys.applayDiscount(minPrice,appliedDiscount,sweetAppSys.currentUser.getBranch());
		
		System.out.println("\n\nThen the all product after discount are:");
		boolean checkProductArray2=sweetAppSys.showAllProductsInTheBranch(sweetAppSys.currentUser.getBranch());
		if(!checkProductArray2)System.out.println("There's no product!!!");
		
	}



	private static void messagingSystem(Scanner input) {

		if(!sweetAppSys.currentUser.userRecievedMsgs.isEmpty()) {
	    System.out.println("*****these are all your recived messages");
		for(Massage msg: sweetAppSys.currentUser.userRecievedMsgs)System.out.println(msg.toString());}
		
		Massage currentMsg=new Massage();
		System.out.println("\n**Please write the User Name of the account that you want to send the message to it:");
		while(true) {
			String uName=input.nextLine().trim();
			if (uName.isEmpty()) {
	            continue;
	        }
			if(uName.equals("1"))return;
		    if(sweetAppSys.checkuNameDest(uName)) {currentMsg.setuNameDest(uName); break;}
		    System.out.println("Invalid user name, try another one, or enter 1 to go back to the menu...");
		}
		
		System.out.println("Please write the message that you want to sent:");
		while(true) {
			String msg=input.nextLine().trim();
			if (msg.isEmpty()) {
	            continue;
	        }
			if(msg.equals("1"))return;
			if( currentMsg.checkMsg(msg)) {
				currentMsg.setMgs(msg); break;}
		    System.out.println("Don't let the massage empty, you can also enter 1 to go back...");
		}
		
		System.out.println("Please write the type of user that you want to contact with (Owner, Supplier, User):");
		while(true) {
			String type=input.nextLine().trim();
			if (type.isEmpty()) {
	            continue;
	        }
			if(type.equals("1"))return;
			if( currentMsg.checkDstType(type)) {currentMsg.setTypeOfDest(type); break;}
		    System.out.println("Invlid type, re-write it or you can enter 1 to go back...");
		}
		
		 sweetAppSys.addMassage(currentMsg);
		 System.out.println("The message has sent successfully!");
		
	}


	private static void trackOrders(Scanner input) {
	
		while(true) {
		System.out.println("To track you branch orders, please choose the order's status that you want to track:");
		System.out.println("1- on pending.");
		System.out.println("2- on processing.");
		System.out.println("3- on delivered.");
		System.out.println("4- cancelled.");
		System.out.println("5- Go back to menu.");
		 
		 int option;
		 while (true) {
			 option = input.nextInt();
            if (option >= 1 && option <= 5) {
                break;
            } else { System.out.println("Invalid option selected.");   }   } 
		 
		 if(option==5)return;
		 else if(option==1) 
		 {
			sweetAppSys.handleOrderStatus("on pending",sweetAppSys.currentUser.getBranch());
			System.out.println("Handling On Pending orders done successfully!"); 
		 }
		 else if(option==2) 
		 {sweetAppSys.handleOrderStatus("on processing",sweetAppSys.currentUser.getBranch());
			System.out.println("Handling On Processing orders done successfully!"); 
		 } 
		 else if(option==3) 
		 {
			 sweetAppSys.handleOrderStatus("on delivered",sweetAppSys.currentUser.getBranch());
				System.out.println("Handling On Delivered orders done successfully!"); 
		 }
		 else if(option==4) 
		 {
			 sweetAppSys.handleOrderStatus("cancelled",sweetAppSys.currentUser.getBranch());
				System.out.println("Handling Cancelled orders done successfully!"); 
		 }
		 
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
            System.out.println("******Note: You are in : "+sweetAppSys.currentUser.getBranch());
            
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
         		        System.out.println("Sales count of this product: " + product.getSalesCount());
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

    private static void manageYourAccount(Scanner input) {
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
			
		//	for (User user : users) {
	        	System.out.println(sweetAppSys.currentUser.toString());
	   //     }
			
			checkUnamePassEmailCityPhoneNumber(password, userName, email,city, phoneNumber, scanner);
			sweetAppSys.updateUserInfo(sweetAppSys.currentUser);
			System.out.println("Your Info Updated Successfully! ");
			
			
	        //for (User user : users) {
	        	System.out.println(sweetAppSys.currentUser.toString());
	       // }
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
                    System.out.println("7- Send Feedback to the Admin");
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
                        sendMassage(input);
                    	continue;
                    }
                    else if (choice == 7) {
                        sendFeedBack(input);
                    	continue;
                    }
                } 
                else if(sweetAppSys.currentUser.getRole().equals("Owner")||sweetAppSys.currentUser.getRole().equals("Supplier"))
                {
                	 System.out.println("Welcome " + sweetAppSys.currentUser.getRole() + ", please choose what you want to do:");
                	 System.out.println("1- Add, update, and remove available products.");
                     System.out.println("2- Monitor sales and profits and best-selling products.");
                     System.out.println("3- Apply discount.");
                     System.out.println("4- Messaging system.");
                     System.out.println("5- Manage your Account.");
                     System.out.println("6- Process and track orders.");
                     System.out.println("7- Log out.");
                     System.out.println("8- Go Back to Main Menu.");
                     
                     choice = 0;
                     while (true) {
                         choice = input.nextInt();
                         if (choice >= 1 && choice <= 8) {
                             break;
                         } else {
                             System.out.println("Invalid option selected.");
                         }
                     }

                     if (choice == 7) {
                         sweetAppSys.currentUser.isLoggedIn = false;
                         System.out.println("Logged out successfully.");
                         break; 
                     } else if (choice == 8) {
                         break; 
                     }else if (choice==1) {manageProducts(input);}
                     else if(choice==2) {reportSalesAndProfit(input);}
                     else if(choice==3) {applyDiscount(input);}
                     else if(choice==4) {messagingSystem(input);}
                     else if(choice==5) {manageYourAccount(input);}
                     else if(choice==6) {trackOrders(input);}
                     
                }
                ///////////////////////////////////////////////////////
                else if(sweetAppSys.currentUser.getRole().equals("Admin"))
                {
                	  System.out.println("Welcome Admin, please choose what you want to do:");
                      System.out.println("1- Manage Accounts.");
                      System.out.println("2- Monitor profits.");
                      System.out.println("3- Identify best-selling products in each store.");
                      System.out.println("4- Display statistics on registered users by City.");
                      System.out.println("5- Manage Recipes.");
                      System.out.println("6- Manage Feedbacks.");
                      System.out.println("7- Log out.");
                      System.out.println("8- Go Back to Main Menu.");

                      choice = 0;
                      while (true) {
                          choice = input.nextInt();
                          if (choice >= 1 && choice <= 8) {
                              break;
                          } else {
                              System.out.println("Invalid option selected.");
                          }
                      }

                      if (choice == 7) {
                          sweetAppSys.currentUser.isLoggedIn = false;
                          System.out.println("Logged out successfully.");
                          break; 
                      } else if (choice == 8) {
                          break; 
                      } else if (choice == 1) {
                    	  
                    	  while(true) {
                    	  System.out.println("Choose one:");
                    	  System.out.println("1- Create Owner/Supplier account.");
                    	  System.out.println("2- Delete an account.");
                    	  System.out.println("3- View all accounts.");
                    	  System.out.println("4- View raw materials.");
                    	  System.out.println("5- Go Back.");
                    	  
                    	  int choice2 =0;
                    	  while (true) {
                    		  choice2 = input.nextInt();
                              if (choice2 >= 1 && choice2 <= 5) {
                                  break;
                              } else {
                                  System.out.println("Invalid option selected.");
                              }
                              }
                    	  if(choice2==1) {createOwnerSupplierAccountByAdmin(input);}
                    	  if(choice2==2) {deleteAccount(input);}
                    	  if(choice2==3) {sweetAppSys.ViewAllUser();}
                    	  if(choice2==4) {sweetAppSys.viewAllMaterial();}
                    	  if(choice2==5) {break;}
                          
                          }
                      }
                      else if (choice == 2) {

                    	  while(true) {
                    	  System.out.println("Choose one:");
                    	  System.out.println("1- Branch Profit Report.");
                    	  System.out.println("2- City Profit Report.");
                    	  System.out.println("3- Overall Profit Report.");
                    	  System.out.println("4- Go Back.");
                    	  
                    	  int choice2 =0;
                    	  while (true) {
                    		  choice2 = input.nextInt();
                              if (choice2 >= 1 && choice2 <= 4) {
                                  break;
                              } else {
                                  System.out.println("Invalid option selected.");
                              }
                              }
                    	  if(choice2==1) {getBranchProfits(input);}
                    	  if(choice2==2) {getCityProfits(input);}
                    	  if(choice2==3) {getAllProfits(input);}
                    	  if(choice2==4) {break;}
                          
                          }
                      }
                      else if(choice==3) {findBestSellingProduct(input);}
                      else if(choice==4) {statisticsUsers(input);}
                      else if(choice==5) {manageRecipes(input);}
                      else if(choice==6) {manageFeedBacksByAdmin(input);}
                      
                }
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
/////////////////////////////////////
	
}
