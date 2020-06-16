package de.hawlandshut.calculus.functions;

import de.hawlandshut.calculus.Differiantiability.Differentiable;

public class CubicPolynomial extends RealFunction implements Differentiable { //Ein Polynom ist eine Reelle Funktion und ableitbar
    private final double a,b,c,d; //a für x^3 b für x^2 c für x^1 und d für x^0

    /**
     * Erstellt neue Quadratische Polynomfunktion
     * @param a wie oft x hoch 3
     * @param b wie oft x hoch 2
     * @param c wie oft x hoch 1
     * @param d wie oft x hoch 0
     */
    public CubicPolynomial(double a, double b, double c, double d) {
        this.b = b;
        this.c = c;
        this.d = d;
        this.a = a;
    }

    @Override
    public double evaluateAt(double x) {
        return a * x * x * x + b * x * x + c * x + d; //errechnet y durch einsetzen in die Funktion
    }
    @Override
    public boolean inDomain(double x) {
        return true;                                  //Definitionsmenge ist R also immer true
    }

    @Override
    public String toString() {
        return String.format("%f*x^3+%f*x^2+%f*x+%f",a,b,c,d); //Gibt String im Format "ax^3+bx^2+cx^1+d"
    }

    @Override
    public RealFunction derive() {
        if (a != 0 || b != 0)
            return new CubicPolynomial(0,3*a,2*b,c); //Die Ableitung eines Polynoms ist ein Polynom
        else if (c != 0)
            return new Constant(c); //falls nur noch c und d übrig sind ist die Ableitung f(x) = c
        else
            return new Constant(0); //falls nur d vorhanden ist (also eine Konstante) ist die Ableitung 0
    }
}
