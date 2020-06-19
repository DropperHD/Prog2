package de.hawlandshut.calculus;

public class Constant extends RealFunction implements Differentiable { //Konstante Funktionen sind Reelle Funktionen
    private final double c; //Konstante C                     //Funktion ist ableitbar also braucht man das Interface

    /** Erstellt neue Konstante funktion
     *
     * f(x) = c
     * @param c Konstante
     */
    public Constant(double c){
        this.c = c;
    }

    @Override
    public double evaluateAt(double x) {
        return c;                          //y von Konstanten sind immer gleich also wird einfach c returned
    }

    @Override
    public boolean inDomain(double x) {
        return true;                       //Die Definitionsmenge ist R also immer true
    }

    @Override
    public String toString() {
        return String.format("%f",c);
    }

    @Override
    public RealFunction derive() {
        return new Constant(0);         //Ableitungen von Konstanten sind immer 0
    }
}
