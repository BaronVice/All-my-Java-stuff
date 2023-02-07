package SOLID;

import lombok.Getter;
import lombok.Setter;

import java.awt.datatransfer.DataFlavor;

/** Subtypes should be replaceable by their base types */
public class LiskovSubstitutionPrincipal {
    public static void main(String[] args) {

    }
}

// Wrong, we need to avoid playAdd in premium video but not with throwing exception

//
//class NormalVideo{
//    private String title;
//    private int time, likes, views;
//
//    public double getNumberOfOursPlayed(){
//        return (time / 3600.0) * views;
//    }
//
//    public void playAdd(){
//        // random add here
//    }
//}
//
//class PremiumVideo extends NormalVideo {
//    public double depth;
//
//    @Override
//    public void playAdd(){
//        throw new RuntimeException("Can't play add in premium video");
//    }
//}

// Isn't it beautiful mow?

interface INormalVideo{
    void playAdd();
}

interface IPremiumVideo{
    void goBetterQuality();
}

abstract class Video{
    public String title;
    public int time;
    public int views;
    public int likes;

    public double getNumberOfHours(){
        return time / 3600.0 * views;
    }
}

class NormalVideo extends Video implements INormalVideo{
    @Override
    public void playAdd() {
        System.out.println("Random add played");
    }
}

class PremiumVideo extends Video implements IPremiumVideo{
    private int id;
    @Override
    public void goBetterQuality() {
        System.out.println("Oh yeah, that's a hell of a quality");
    }
}


