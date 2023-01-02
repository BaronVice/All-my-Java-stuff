package SingleClasses;

public class Constructors {
    public static void main(String[] args) {
        Book book1 = new Book("Java");
        Book book2 = new Book("Cython", "Ryan Gosling");

        System.out.println(book1.getInfo());
        System.out.println(book2.getInfo());

        System.out.println(Book.getBooksNumber()); // return description of SIngleClasses.Book class

    }
}

class Book{
    // Vars
    private static int booksNumber;
    private String name;
    private String author;

    // SIngleClasses.Constructors
    public Book(String name){
        this.name = name;
        this.author = "Unknown";
        booksNumber++;
    }
    public Book(String name, String author){
        this.name = name;
        this.author = author;
        booksNumber++;
    }

    // Setters
    public void setName(String name){
        this.name = name;
    }
    public void setAuthor(String author){
        this.author = author;
    }

    // Getters
    public String getName(){
        return name;
    }
    public String getAuthor(){
        return author;
    }

    // Get info func
    public String getInfo(){
        return String.format("SIngleClasses.Book named %s was written by %s", name, author);
    }

    // Get number of books func
    public static int getBooksNumber(){
        return booksNumber;
    }
}
