/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NewsAndInformationHUB;

/**
 * Video class to store video details such as title and URL
 * @author arets
 */
public class Video {
    private String title;
    private String url;

    //Constructor  of title and URL.
    public Video(String title, String url) {
        this.title = title;
        this.url = url;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
   
    // Override method to return the title of the video.
    // Displaying video titles. 
    @Override
    public String toString() {
        return title;
    }
}