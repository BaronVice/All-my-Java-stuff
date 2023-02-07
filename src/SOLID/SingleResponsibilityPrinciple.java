package SOLID;

import lombok.Data;

import javax.imageio.plugins.tiff.TIFFTag;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/** Class should have one and only one responsibility and reason to change */
public class SingleResponsibilityPrinciple {
    public static void main(String[] args) {

    }
}

// This is wrong: Video can not have an option of sending sql actions

//@Data
//class Video{
//    private String title;
//    private int time;
//    private int likes;
//    private int views;
//
//    public double getAverageLikes(){
//        return likes / (float)views;
//    }
//
//    public void sendStatistic(String url) throws SQLException {
//        Connection connection = DriverManager.getConnection(url, "root", "");
//        Statement statement = connection.createStatement();
//        String sql = "INSERT INTO Video (Title, Time, Likes, Views) VALUES (%s, %d, %d, %d)"
//                     .formatted(title, time, likes, views);
//        statement.executeUpdate(sql);
//    }
//}

// That's better

@Data
class MyVideo{
    private String title;
    private int time;
    private int likes;
    private int views;

    public double getAverageLikes(){
        return likes / (float)views;
    }
}

class VideoDAO{
   public void sendStatistic(String url, MyVideo video) throws SQLException {
        Connection connection = DriverManager.getConnection(url, "root", "");
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO Video (Title, Time, Likes, Views) VALUES (%s, %d, %d, %d)".formatted(
                     video.getTitle(), video.getTime(), video.getLikes(), video.getViews());
        statement.executeUpdate(sql);
    }
}
