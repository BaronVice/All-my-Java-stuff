package NestedClass;

public class EmptyFuelException extends Exception{
    public EmptyFuelException(){
        super();
    }
    public EmptyFuelException(String description){
        super(description);
    }
}
