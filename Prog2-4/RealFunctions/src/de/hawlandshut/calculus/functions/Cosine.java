package de.hawlandshut.calculus.functions;

import de.hawlandshut.calculus.Differiantiability.Differentiable;

public class Cosine extends RealFunction implements Differentiable { //Cosinus ist eine Reelle Funktion und ableitbar
    private final double a,f;   //Cosinus kann durch zwei Zahlen verändert werden
                                //a für die Amplitude und f um zu strecken

    /**
     * Erstellt eine neue Cosinusfunktion
     * @param a Amplitude
     * @param f Streckung
     */
    public Cosine(double a, double f){
        this.a = a;
        this.f = f;
    }
    @Override
    public double evaluateAt(double x) {
        return a * Math.cos(x * f);         //berechnet y and der Stelle x
    }

    @Override
    public boolean inDomain(double x) {
        return true;                        //Definitionsmenge ist R also immer true
    }

    @Override
    public String toString() {
        return String.format("%f*cos(%f*x)",a,f); //String im Format "a*cos(f*x)"
    }

    @Override
    public Sine derive() {
        return new Sine(-a * f, f);             //Ableitung von Cosinus ist -Sinus
    }
}
