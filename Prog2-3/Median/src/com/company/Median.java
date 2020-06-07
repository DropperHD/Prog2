package com.company;

import java.util.Arrays;

public class Median {

    public static double computeMedian(int ... ints){ //int...ints ist ein vararg und kann so viele int speichern wie man will

        if(ints == null){ //ints darf nicht null sein
            throw new IllegalArgumentException("Argument darf nicht null sein");
        }
        if(ints.length == 0){ //ints darf nicht leer sein
            throw new IllegalArgumentException("Funktion braucht Argumente");
        }

        Arrays.sort(ints); //Sortiert das Array
        switch (ints.length % 2 ){              //falls modulo 2 = 0 ist ist das Ergebniss gerade
            case 1: return ints[ints.length/2]; // gibt einfach den Wert des Eintages in der mitte zurück
            case 0: return (ints[ints.length/2-1] + ints[ints.length/2])/2.0; //gibt den mittleren Wert der beiden mittigen Einträge zurück
            default: throw new IllegalArgumentException("Irgendwas ist schief gelaufen"); //default case wird benötigt
        }
    }
}
