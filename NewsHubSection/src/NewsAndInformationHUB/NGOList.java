/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NewsAndInformationHUB;

import java.util.ArrayList;
import java.util.List;

/**
 * Here is presents the List of the popular NGO 
 * This class Is Inherited to the Donation.java class    
 * @author arets
 */
public class NGOList extends Donation {
    //Atribute
    private List<String> ngoList;
    
    public NGOList(){
        this.ngoList = initializeNGOList();
        
    }
     // Method to initialize the list of NGOs
    private List<String> initializeNGOList() {
        List<String> ngos = new ArrayList<>();     // List of NGO 
        ngos.add("Save the Children");           // 1 
        ngos.add("Red Cross");                   // 2
        ngos.add("World Wildlife Fund");         // 3
        ngos.add("Doctors Without Borders");     // 4
        ngos.add("UNICEF");                      // 5
        ngos.add("Greenpeace");                  // 6
        ngos.add("Amnesty International");       // 7
        ngos.add("Oxfam");                       // 8
        ngos.add("Habitat for Humanity");        // 9
        ngos.add("The Salvation Army");          // 10
    //  ^^^^^ if need to add more row >>>> ngos.add(""); <<<<<
        return ngos;
    }

    // Getter for ngoList
    public List<String> getNgoList() {
        return ngoList;
    }

    // Optional Setter for ngoList, if you want the list to be modifiable
    public void setNgoList(List<String> ngoList) {
        this.ngoList = ngoList;
    }

    // specific to NGOList, if needed
    public void displayNGOs() {
        // display the list of NGOs in the application
        for (String ngo : ngoList) {
            System.out.println(ngo);
        }
    }
    
}
