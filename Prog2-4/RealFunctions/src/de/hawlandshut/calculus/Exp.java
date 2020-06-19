package de.hawlandshut.calculus;

public class Exp extends RealFunction implements Differentiable { //Reelle Funktion und ableitbar
    //braucht keine Parameter oder Konstruktoren ,denn die e-Funktion ist immer gleich
    @Override
    public double evaluateAt(double x) {
        return Math.exp(x);                 //gibt e^x zurück
    }

    @Override
    public boolean inDomain(double x) {     //Definitionsmenge ist R also immer true
        return true;
    }

    @Override
    public Exp derive() {
        return this;                        //e-Funktion abgeleitet ist die e-Funktion
    }

    @Override
    public String toString() {
        return "e^x";                       //gibt immer "e^x" aus
    }
}
