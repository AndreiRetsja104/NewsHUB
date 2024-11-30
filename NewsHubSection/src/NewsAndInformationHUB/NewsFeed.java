/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NewsAndInformationHUB;

import java.util.ArrayList;
import java.util.List;
/**
  *NewsFeed class provides methods to fetch the latest articles, videos, shorts, and research papers.
 * each method returns a list of relevant items as sample data.
 * this class data provider for news, videos, shorts, and research.
 *  each method can be displayed in a GUI.
 * @author arets
 */
public class NewsFeed {
       //  data for articles List. 
    public List<String> getLatestArticles() {
        List<String> articles = new ArrayList<>();
        articles.add("Article 1: Latest News in AI");
        articles.add("Article 2: Advances in Quantum Computing");
        articles.add("Article 3: Climate Change Updates");
      //  System.out.println("Fetched articles: " + articles);  // Debug statement
        return articles;
    }
        //  data for videos List. 
    public List<String> getLatestVideos() {
        List<String> videos = new ArrayList<>();
        videos.add("Video 1: AI and Machine Learning");
        videos.add("Video 2: Understanding Quantum Physics");
        videos.add("Video 3: The Future of Renewable Energy");
      //  System.out.println("Displaying videos: " + videos);  // Debug statement
        return videos;
    }

    public List<ShortVideo> getLatestShorts() {
        List<ShortVideo> shorts = new ArrayList<>();
        shorts.add(new ShortVideo("NGO CSW65 Virtual Forum Tutorial Video Series: Advocate Tutorial", "https://www.youtube.com/watch?v=sB-wXRhpqqM"));
        shorts.add(new ShortVideo("What Are NGOs?", "https://www.youtube.com/watch?v=MfGoZCbdZ5g"));
        shorts.add(new ShortVideo("What are the world's largest NGOs?", "https://www.youtube.com/watch?v=-P7XV3mmxBE"));
        shorts.add(new ShortVideo("What is happening to children in Sudan? | UNICEF", "https://www.youtube.com/watch?v=UR8pQb-SZ5g"));
        shorts.add(new ShortVideo("UNICEF | for every child", "https://www.youtube.com/watch?v=E1xkXZs0cAQ"));
        shorts.add(new ShortVideo("What's the difference between the red cross, red crescent and red crystal? | Working For The ICRC", "https://www.youtube.com/watch?v=yBIS2mj0vQ4"));
        shorts.add(new ShortVideo("We are the American Red Cross", "https://www.youtube.com/watch?v=j3-ilgrJPLY"));
        shorts.add(new ShortVideo("Addressing myths about climate change", "https://www.youtube.com/watch?v=5ZzpPQvPowE"));
        shorts.add(new ShortVideo("Greenpeace activists put black fabric on Rishi Sunak's mansion in oil protest", "https://www.youtube.com/watch?v=pu74mQxIZVI"));
        shorts.add(new ShortVideo("Why I Left Greenpeace | 5 Minute Video", "https://www.youtube.com/watch?v=BpBnJq19R60"));
        shorts.add(new ShortVideo("UNICEF | for every child ", "https://www.youtube.com/watch?v=UR8pQb-SZ5g"));     
        return shorts;
    }
     //  data for research paper titles to the list.
    public List<String> getLatestResearch() {
        List<String> research = new ArrayList<>();
        research.add("Research Paper 1: AI in Healthcare");
        research.add("Research Paper 2: Quantum Algorithms");
        research.add("Research Paper 3: Sustainable Energy Solutions");
       // System.out.println("Displaying research: " + research);   // Debug statement
        return research;
    }

}
