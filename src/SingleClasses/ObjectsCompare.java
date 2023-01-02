package SingleClasses;

public class ObjectsCompare {
    public static void main(String[] args) {
        Animal animal1 = new Animal(1);
        Animal animal2 = new Animal(1);

        // Сравнение ссылок на объекты (False)
        System.out.println(animal1 == animal2);
        //System.out.println(animal1.equals(animal2)); // То же самое до переопределения метода equals

        // После переопределения equals (True)
        System.out.println(animal1.equals(animal2));

        String first = "Haha";
        String second = "Haha";
        
        System.out.println(first.equals(second));

    }
}

class Animal{
    private int id;

    public Animal(){
    }
    public Animal(int id){
        this.id = id;
    }

    public boolean equals(Object obj){
        Animal otherAnimal = (Animal) obj;
        return this.id == otherAnimal.id;
    }
}
