public class WaysTOFormatString {
    public static void main(String[] args) {
    }

    public static void show(String word){
        String first = String.format("%s", word);
        String second = "%s".formatted(word);
    }
}


