package model.exceptions;

public class DomainException extends Exception {
    private static final long seriaLVersionUID = 1L;
    
    public DomainException (String msg){
        super(msg);
    }
}
