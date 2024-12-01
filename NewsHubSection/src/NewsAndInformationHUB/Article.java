/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NewsAndInformationHUB;

/**
 *  
 * @author arets
 */
public class Article {
    private String title;
    private String url;

    // Constructor
    public Article(String title, String url) {
        this.title = title;
        this.url = url;
    }
    // Getter the article title
    public String getTitle() {
        return title;
    }
    // Getter the article URL
    public String getUrl() {
        return url;
    }
}