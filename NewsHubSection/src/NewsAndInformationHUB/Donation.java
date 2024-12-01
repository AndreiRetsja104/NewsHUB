/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NewsAndInformationHUB;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arets
 */
public class Donation {
    // Attributes
    private String name;
    private String phone;
    private String email;
    private float donationAmount;
    private List<NGOList> preferredNGOs;

    // Constructor
    public Donation() {
        this.preferredNGOs = new ArrayList<>(); // the preferredNGOs list
    }
        
    //  Method to fill the donation form
    public void fillForm(String userName, String userPhone, String userEmail, float donationAmount) {
        this.name = userName;
        this.phone = userPhone;
        this.email = userEmail;
        this.donationAmount = donationAmount;
    }

    public List<NGOList> suggestNGOs() {
        // Suggests NGOs based on some logic, if needed
        return preferredNGOs;
    }

    //Constructor to initialize donation details
    public Donation(String name, String phone, String email, float donationAmount, List<NGOList> preferredNGOs) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.donationAmount = donationAmount;
        this.preferredNGOs = preferredNGOs;
    }

    // Getters and Setters
    public String getUserName() { 
        return name; 
    }
    
    public void setUserName(String userName) { 
        this.name = userName; 
    }

    public String getUserPhone() { 
        return phone; 
    }
    
    public void setUserPhone(String userPhone) { 
        this.phone = userPhone; 
    }

    public String getUserEmail() { 
        return email; 
    }
    
    public void setUserEmail(String userEmail) { 
        this.email = userEmail; 
    }

    //Getter method for donation amount.
    public float getDonationAmount() { 
        return donationAmount; 
    }
    
    // Setter method for donation amount.
    public void setDonationAmount(float donationAmount) { 
        this.donationAmount = donationAmount; 
    }
    
    //Getter method for preferred NGOs
    public List<NGOList> getPreferredNGOs() { 
        return preferredNGOs; 
    }
    
    //Setter method for preferred NGOs
    public void setPreferredNGOs(List<NGOList> preferredNGOs) { 
        this.preferredNGOs = preferredNGOs; 
    }

}
    

