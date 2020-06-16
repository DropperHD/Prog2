package de.hawlandshut.calculus.functions;

import de.hawlandshut.calculus.Differiantiability.Differentiable;

public class Sine extends RealFunction implements Differentiable {
    private final double a,f; //Sinus kann durch zwei Zahlen verändert werden
                              //a für die Amplitude und f um zu strecken
    public Sine(double a,double f){
        this.a = a;
        this.f = f;
    }

    @Override
    public double evaluateAt(double x) {
        return a * Math.sin(x * f);         //berechnet y and der Stelle x
    }

    @Override
    public boolean inDomain(double x) {
        return true;                        //Definitionsmenge ist R also immer true
    }

    @Override
    public String toString() {
        return String.format("%f*sin(%f*x)",a,f);
    } //String im Format "a*sin(f*x)"

    @Override
    public Cosine derive() {
        return new Cosine(a*f, f);      //Die Ableitung von Sinus ist der Cosinus
    }
}
