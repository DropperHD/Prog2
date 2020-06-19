package de.hawlandshut.calculus;

public class OutsideOfDomainException extends RuntimeException{            //Eigene checked Exeption
                                                                    //Konstruktoren genau wie in der Vorlesung
    public OutsideOfDomainException(String name){
        super(name);
    }
    public OutsideOfDomainException(Throwable cause){
        super(cause);
    }
    public OutsideOfDomainException(String message,Throwable cause){
        super(message,cause);
    }

}
