package NotMineProjects; // Замени на свой
import java.util.*;

public class FirstLab{

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = 0;
        String s ="";

        while (!"5".equals(s)){
            Menu();
            s = scan.next();
            x = Integer.parseInt(s);
            switch (x){
                case 1:
                    TaskA();
                    break;
                case 2:
                    TaskB();
                    break;
                case 3:
                    TaskC();
                    break;
                case 4:
                    TaskD();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Неверный ввод");
                    break;
            }
        }
        System.out.println("До свидания!");
    }
    public static void Menu()
    {
        System.out.println("1. Задание А");
        System.out.println("2. Задание В");
        System.out.println("3. Задание С");
        System.out.println("4. Задание D");
        System.out.println("5. Выход");
    }
    public static void TaskA()
    {
//        Scanner scan = new Scanner(System.in);
//        String line = scan.nextLine();
        String line = "Let's celebrate and drink some tea";
        String formatLine = line.replaceAll("\\W", " ");
        List <String> words = Arrays.asList(formatLine.split("\\s+"));

        words.sort(new LengthFirstComparator());

        System.out.println(String.format("До: %s\nПосле: %s", line, String.join(" ", words)));

    }
    public static void TaskB()
    {
//        Scanner scan = new Scanner(System.in);
//        String line = scan.nextLine();
        String line = "Leathel cluc is two blocks behind. I do weew";
        List<String> words = Arrays.asList((line.replaceAll("\\W", " ")).split("\\s+"));
        for (String word : words){
            if((word.substring(0,1).toLowerCase()).equals(word.substring(word.length() - 1).toLowerCase())){
                words.set(words.indexOf(word), "");
            }
        }

        String message = String.join(" ", words).replaceAll("\\s+", " ");
        System.out.println(String.format("До: %s\nПосле: %s", line, message));
    }
    public static void TaskC()
    {
//        Scanner scan = new Scanner(System.in);
//        String line = scan.nextLine();
        String[][] arr = {{"1", "2", "3", "4"}, {"8", "14", "15", "8", "8"}, {"4", "4", "1"}};
        String[] toSearch = {"2", "8", "4"};

        for (int i = 0; i < toSearch.length; i++){
            List <String> asList = Arrays.asList(arr[i]);
            System.out.println(String.format(
                    "Средняя встречаемость элемента %s в массиве %d: %.4f",
                    toSearch[i], i+1, (float)(Collections.frequency(asList, toSearch[i])) / arr[i].length
                    ));
        }
    }
    public static void TaskD()
    {
//        Scanner scan = new Scanner(System.in);
//        String line = scan.nextLine();
        String line = "As we can";
        String formatLine = line.replaceAll("\\W", "").toLowerCase();
        List <String> letters = Arrays.asList(formatLine.split(""));

        String letterToFind = "a";
        int occurrences = Collections.frequency(letters, letterToFind);
        System.out.println(String.format(
                "Строка: %s\nВстречено совпадений: %d\nДлина строки без пробелов: %d\nСредняя встречаемость: %.4f",
                line, occurrences, formatLine.length(), (float)occurrences / letters.size())
        );
    }
    public static class LengthFirstComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1.length()!=o2.length()) {
                return o1.length()-o2.length(); //overflow impossible since lengths are non-negative
            }
            return o1.compareTo(o2);
        }
    }
}

