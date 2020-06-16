package de.hawlandshut.calculus.functions;

import de.hawlandshut.calculus.Differiantiability.Differentiable;

public class Log extends RealFunction implements Differentiable { //Reelle Funktion und Ableitbar
    //braucht keine Parameter oder Konstruktoren ,denn die Log-Funktion ist immer gleich
    @Override
    public double evaluateAt(double x){ //kann OutsideOfDomainException werfen
        if (!inDomain(x))
            throw new OutsideOfDomainException("x ist nicht in der Definitionsmenge!");   //wirft Exception wenn x nicht in der Definitionsmenge ist
        return Math.log(x);                         //falls x passt wird log^x zurückgegeben
    }

    @Override
    public boolean inDomain(double x) {
        return x > 0;                               //Log ist nur für Positive Zahlen definiert
    }

    @Override
    public String toString() {                      //gibt immer "ln(x)" zurück
        return "ln(x)";
    }

    @Override
    public Log derive() {                           //die Ableitung von Log ist 1/x
        return new LogDerivative();                 //Diese ist in einer inneren Klasse defieniert
    }

    private static class LogDerivative extends Log{ //Die Klasse ist private weil nur log auf sie zugreifen soll
        @Override
        public double evaluateAt(double x) {        //gibt 1/x zurück
            return 1/x;
        }

        @Override
        public boolean inDomain(double x) {
            return x > 0;                           //Da log nur für x > 0 definiert ist muss das auch hier gelten
        }
    }
}