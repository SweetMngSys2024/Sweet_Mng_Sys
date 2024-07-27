package MyApp2024_Sweet;

import java.util.ArrayList;

public class ClassMy_App {
	public static ArrayList<User> list_users = new ArrayList<>();
	public static ArrayList<Store> list_stores = new ArrayList<>();
	public static ArrayList<RawMaterial> list_rawMaterials = new ArrayList<>();

    static {
        list_users.add(new User("bayan", "password123", "User"));
        list_users.add(new User("ahmad", "password456", "User"));
        list_users.add(new User("aya", "password789", "Admin"));
        list_users.add(new User("amer", "password987", "Admin"));
        list_users.add(new User("shams", "password654", "Owner"));
        list_users.add(new User("raghad", "password321", "Owner"));
        list_users.add(new User("rama", "password675", "Suppliers"));
        list_users.add(new User("amal", "password184", "Suppliers"));
        
        
        
        
        list_stores.add(new Store("Store A", "City X", "shams"));
        list_stores.add(new Store("Store B", "City Y", "raghad"));
       
        
        
        
        list_rawMaterials.add(new RawMaterial("Material A", "rama"));
        list_rawMaterials.add(new RawMaterial("Material B", "amal"));
       
    }

    // Getters and setters
    public static ArrayList<User> getList_users() {
        return list_users;
    }

    public static void setList_users(ArrayList<User> list_users) {
        ClassMy_App.list_users = list_users;
    }

    public static ArrayList<Store> getList_stores() {
        return list_stores;
    }

    public static void setList_stores(ArrayList<Store> list_stores) {
        ClassMy_App.list_stores = list_stores;
    }

    public static ArrayList<RawMaterial> getList_rawMaterials() {
        return list_rawMaterials;
    }

    public static void setList_rawMaterials(ArrayList<RawMaterial> list_rawMaterials) {
        ClassMy_App.list_rawMaterials = list_rawMaterials;
    }
    
    
    public boolean authenticateUser(String username, String password, String role) {
        ArrayList<User> users = ClassMy_App.getList_users();
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password) && user.getRole().equals(role)) {
                return true;
            }
        }
        return false;
    }

    public boolean is_loged_in; 
    public boolean account_management_page=true;
    public boolean clickCreateAccount;
    public boolean clickDeleteAccount;
    public boolean clickViewAccount;
    public boolean clickViewStoreNames;
    public boolean clickViewRawMaterials;
}
