package UpCastDownCast;

public class Animal {
    private int id;

    public Animal(){
        this.id = -1;
    }

    public Animal(int id){
        this.id = id;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }

    public String toString(){
        return String.valueOf(id);
    }


    public void eat(){
        System.out.println("Your pet is eating");
    }
}
