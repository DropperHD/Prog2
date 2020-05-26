package de.hawlandshut.calculus;

import de.hawlandshut.calculus.BinaryOperations.Addition;
import de.hawlandshut.calculus.functions.Cosine;
import de.hawlandshut.calculus.functions.Exp;
import de.hawlandshut.calculus.functions.Sine;

public class Main {

    public static void main(String[] args) {
	Plotter.plot(new Exp(), new Sine(1,1),new Cosine(1,1),new Addition(new Sine(1,1),new Cosine(1,1)));
    }
}
