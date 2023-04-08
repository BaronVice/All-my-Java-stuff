package Enum;

public class EnumExample {

    public static void main(String[] args) {

        Season season = Season.FALL;
        // Object -> Enum -> Season
        System.out.println(season instanceof Enum);
        System.out.println(season.getClass());

        switch (season){
            case FALL -> System.out.println("Getting colder");
            case SPRING -> System.out.println("Getting warmer");
            case SUMMER -> System.out.println("Warm weather");
            case WINTER -> System.out.println("Cold weather");
        }
        System.out.println();

        for (Cereals cereal : Cereals.values()){
            System.out.println(cereal.toString());
        }

    }
}
