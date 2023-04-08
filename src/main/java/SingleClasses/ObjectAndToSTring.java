package SingleClasses;

public class ObjectAndToSTring {
    public static void main(String[] args) {
        Stone stone1 = new Stone("cobalt", 4.32f);
        stone1.toString();              // Same
        System.out.println(stone1);     // As this and contains hashcode
    }
}

class Stone{
    private String name;
    private float weight;

    public Stone(String name, float weight){
        this.name = name;
        this.weight = weight;
    }

    public String toString(){
        return String.format("%s - %f", name, weight);
    }

}
