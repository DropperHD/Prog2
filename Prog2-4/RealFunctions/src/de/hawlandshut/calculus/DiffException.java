package de.hawlandshut.calculus;
                                                                //Exeption genau wie in der Vorlesung
public class DiffException extends Exception {                  //Eigene Exeptions leiten von Expetion ab
                                                                //serialVersionUID wird nicht benötigt bei mir
    public DiffException(String message){super(message);}       //erster Konstruktor mit Message
    public DiffException(Throwable cause){super(cause);}        //zweiter mit Cause
    public DiffException(String message,Throwable cause){       //dritter mit beiden
        super(message,cause);
    }
}
