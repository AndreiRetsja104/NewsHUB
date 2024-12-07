/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NewsAndInformationHUB;

import java.util.ArrayList;
import java.util.List;
/**
  *NewsFeed class provides methods to fetch the latest articles, videos, and research papers.
 * each method returns a list of relevant items as sample data.
 * this class data provider for news, videos, and research.
 *  each method can be displayed in a GUI.
 * @author arets
 */
public class NewsFeed {
    
    // Data for articles List
    // Arraylist of URLs for Articles 
    public List<Article> getLatestArticles() {
        List<Article> articles = new ArrayList<>();
        articles.add(new Article("Amnesty International", "https://www.amnesty.org/en/"));
        articles.add(new Article("UNICEF", "https://www.unicef.org/"));
        articles.add(new Article("Greenpeace International", "https://www.greenpeace.org/international/"));
        articles.add(new Article("Doctors Without Borders (Médecins Sans Frontières)", "https://www.msf.org/"));
        articles.add(new Article("World Wildlife Fund (WWF)", "https://www.worldwildlife.org/"));
        articles.add(new Article("Oxfam International", "https://www.oxfam.org/en"));
        articles.add(new Article("International Red Cross and Red Crescent Movement", "https://www.icrc.org/en"));
        articles.add(new Article("Transparency International", "https://www.transparency.org/en/"));
        articles.add(new Article("Save the Children", "https://www.savethechildren.net/"));
        articles.add(new Article("CARE International", "https://www.care-international.org/"));
        return articles;
    }
        // Data for Video List
        // Arraylist of URLs for Videos 
    public List<Video> getLatestVideos() {
        List<Video> video = new ArrayList<>();
        video.add(new Video("NGO CSW65 Virtual Forum Tutorial Video Series: Advocate Tutorial", "https://www.youtube.com/watch?v=sB-wXRhpqqM"));
        video.add(new Video("What Are NGOs?", "https://www.youtube.com/watch?v=MfGoZCbdZ5g"));
        video.add(new Video("What are the world's largest NGOs?", "https://www.youtube.com/watch?v=-P7XV3mmxBE"));
        video.add(new Video("What is happening to children in Sudan? | UNICEF", "https://www.youtube.com/watch?v=UR8pQb-SZ5g"));
        video.add(new Video("UNICEF | for every child", "https://www.youtube.com/watch?v=E1xkXZs0cAQ"));
        video.add(new Video("What's the difference between the red cross, red crescent and red crystal? | Working For The ICRC", "https://www.youtube.com/watch?v=yBIS2mj0vQ4"));
        video.add(new Video("We are the American Red Cross", "https://www.youtube.com/watch?v=j3-ilgrJPLY"));
        video.add(new Video("Addressing myths about climate change", "https://www.youtube.com/watch?v=5ZzpPQvPowE"));
        video.add(new Video("Greenpeace activists put black fabric on Rishi Sunak's mansion in oil protest", "https://www.youtube.com/watch?v=pu74mQxIZVI"));
        video.add(new Video("Why I Left Greenpeace | 5 Minute Video", "https://www.youtube.com/watch?v=BpBnJq19R60"));
        video.add(new Video("UNICEF | for every child ", "https://www.youtube.com/watch?v=UR8pQb-SZ5g"));     
        return video;
    }
    // data for research paper titles to the list.
    // This list in the progress,   
    public List<String> getLatestResearch() {
        List<String> research = new ArrayList<>();
        research.add("Research Paper 1: AI in Healthcare");
        research.add("Research Paper 2: Quantum Algorithms");
        research.add("Research Paper 3: Sustainable Energy Solutions");
        System.out.println("Displaying research: " + research);   // Debug statement
        return research;
    }

}
