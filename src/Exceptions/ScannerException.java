package Exceptions;

public class ScannerException extends Exception {
    public ScannerException(){
        super();
    }
    public ScannerException(String description){
        super(description);
    }
}
