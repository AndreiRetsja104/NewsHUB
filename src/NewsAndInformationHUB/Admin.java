/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NewsAndInformationHUB;

/**
 *
 * @author seang
 */
public class Admin extends Profile {
    
    public Admin(String username, String password) {
        super(username, password, "admin");
    }

    // Admin-specific methods
    public void deleteUser(UserManager userManager, String username) {
        // Method to delete another user, accessible only to admins
    }
}
