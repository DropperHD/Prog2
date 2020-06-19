package de.hawlandshut.calculus;

import de.hawlandshut.calculus.*;

public class Main {

    public static void main(String[] args) { //neuer Plotter mit ein paar Funktionen
	Plotter.plot(new Exp(), new Sine(1,1),new Cosine(1,1),new Addition(new Sine(1,1),new Cosine(1,1)));
    }
}
