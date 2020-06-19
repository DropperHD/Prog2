package de.hawlandshut.calculus;

public abstract class RealFunction {    //Abstrakte Klasse von der alle gewünschten Funktionen ableiten sollen
    /**
     * Gibt den Funktionswert an der Stelle x zurück
     *
     * @param x Eingabe für f(x)
     * @return y Wert and der gewünschten Stelle
     */
    public abstract double evaluateAt(double x);

    /**
     * Überprüft ob eine Zahl innerhalb des Definitionsbereiches einer Funktion liegt
     * @param x zu überprüfende Zahl
     * @return true wenn x im gültigen Bereich liegt
     */
    public abstract boolean inDomain(double x);
}
