package SingleClasses;

public class ClassesAndObjects { // Это главный класс, его имя соответствует названию файла
    public static void main(String[] args) {
        Person realHero = new Person();
        realHero.setName("Ryan Gosling");
        realHero.setAge(41);
        realHero.lastActivity(55);

        Person humanBeing = new Person();
        humanBeing.setName("MV");
        humanBeing.setAge(29);
        humanBeing.lastActivity(4);

        realHero.speak();
        humanBeing.speak();

        System.out.println(realHero.userActivity());
        System.out.println(humanBeing.userActivity());

    }
}

class Person{ // Это вспомогательный класс
    // У класса могут быть данные и действия
    private String name;
    private int age;
    private int daysOffline;

    // Setters
    public void setName(String givenName){
        if (givenName.isEmpty()){
            System.out.println("Name should contain at least one letter");
        }
        else{
            name = givenName;
        }
    }
    public void setAge(int givenAge){
        if (givenAge < 0){
            System.out.println("Age should be a positive number");
        }
        else{
            age = givenAge;
        }
    }

    // Getters
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }

    // Others
    void lastActivity(int daysPassed){
        daysOffline = daysPassed;
    }
    boolean isUserInactive(){
        return daysOffline > 31;
    }
    String userActivity(){
        return isUserInactive() ?
               String.format("%s wasn't seen for a while", name) :
               String.format("We saw %s not long ago", name);
    }
    void speak(){
        System.out.println(String.format("%s (%d) says:\nAnd you have proved to be\nA real human being\n", name, age));
    }
}
