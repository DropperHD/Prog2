package de.hawlandshut.calculus.functions;

public class OutsideOfDomainException extends RuntimeException{
    public OutsideOfDomainException(){
    }

    public OutsideOfDomainException(String name){
        System.out.print(name);
    }

}
