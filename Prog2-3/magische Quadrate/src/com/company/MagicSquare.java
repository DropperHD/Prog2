package com.company;

public class MagicSquare {

    /**
     * Statische Methode die ein Testquadrat erzeugt
     *
     * @return zweidimensionales int Array das 3x3 groß ist und mit gleichbleibenden Testzahlen gefüllt ist
     */
    static int[][] getExample() {
        int[] z1 = {8, 1, 6};               //Ein zweidimensionales Array ist im Prinzip nur ein Array von Arrays
        int[] z2 = {3, 5, 7};
        int[] z3 = {4, 9, 2};
        return new int[][]{z1, z2, z3};     //Deshalb werden einfach drei erstellt und in eins gepackt
    }

    /**
     * Überprüft ob ein zweidimensionales Array ein magisches Quadrat ist
     *
     * @param square magisches Quadrat (int[][]) darf nicht null sein
     * @return true wenn es sich um ein magisches Quadrat handelt
     */
    public static boolean isMagic(int[][] square) {
        checkArguments(square);                     //erst werden die Eingaben auf Korrektheit geprüft
        int magicNumber = getMagic(square);         //dann wird die magische Zahl berechnet
        return square.length == 0 || checkVertical(square, magicNumber) && checkHorizontal(square, magicNumber) && checkDiagonal(square, magicNumber);
    }                                               //falls length == 0 ist das Array leer also true

    /**
     * Überprüft Eingabe-parameter auf Richtigkeit, wirft Exeptions
     *
     * @param square die zu Testende Eingabe
     */
    private static void checkArguments(int[][] square) {
        if (square == null) {                                   //null darf nicht sein,sonst kommt es zu Nullpointern
            throw new IllegalArgumentException("square cant be null");
        }
        for (int[] rows : square) {
            if (square.length != rows.length) {                 //falls die länge der Reihen und Spalten nicht übereinstimmt wird
                throw new IllegalArgumentException("Not Quadratic"); //eine Exeption geworfen
            }
        }
    }

    /**
     * Überprüft ob ein Quadrat auf der Diagonalen mit der magicnumber übereinstimmt
     *
     * @param square      Quadrat
     * @param magicNumber magische Zahl
     * @return true wenn Diagonal und AntiDiagonal die magicnumber rauskommt
     */
    private static boolean checkDiagonal(int[][] square, int magicNumber) {
        int diagonal = 0;                //Zählervariable für diagonal
        int antidiagonal = 0;            //Zählervariable für antidiagonal
        int i = 0;
        for (int[] rows : square) {      //es wird von [0][0] auf [1][1] auf [2][2] usw gegangen und die Einträge addiert
            diagonal += rows[i];         //X 0 0    0 0 X
            i++;                         //0 X 0 -> 0 X 0
        }                                //0 0 X    X 0 0
        i = square.length - 1;           //Dann umgekehrt von [0][2] auf [1][1] auf [2][0]
        for (int[] rows : square) {
            antidiagonal += rows[i];
            i--;
        }
        return diagonal == magicNumber && antidiagonal == magicNumber;
    }

    /**
     * Überprüft in jeder Reihe ob die magische Zahl beim addieren rauskommt
     *
     * @param square      Quadrat
     * @param magicNumber magische Zahl
     * @return true wenn Horizontal die magicnumber rauskommt
     */

    private static boolean checkHorizontal(int[][] square, int magicNumber) {
        for (int[] rows : square) {      //In jeder Zeile werden alle Zahlen addiert
            int calc = 0;                //X X X    0 0 0    0 0 0
            for (int numbers : rows) {   //0 0 0 -> X X X -> 0 0 0
                calc += numbers;         //0 0 0    0 0 0    X X X
            }                            //
            if (calc != magicNumber) {
                return false;            //falls einer der Ergebnisse falsch sein sollte wird gleich returnt
            }
        }
        return true;                     //falls alle richtig sind wird true zurückgegeben
    }

    /**
     * Überprüft in jeder Spalte ob die magische Zahl beim addieren rauskommt
     *
     * @param square      Quadrat
     * @param magicNumber magische Zahl
     * @return true wenn Vertikal die magicnumber rauskommt
     */

    private static boolean checkVertical(int[][] square, int magicNumber) {
        int spaltenanzahl = 0;
        for (int numbers : square[0]) {      //Weil es ein Quadrat ist wird einfach die erste Reihe durchgegangen
            int vert = 0;                    //vert ist eine Hifsvariable die bei jeder Spalte resetet wird
            for (int[] rows : square) {      //für alle Spalten wird rows[spaltenanzahl] zusammengezählt
                vert += rows[spaltenanzahl]; // X 0 0    0 X 0     0 0 X
            }                                // X 0 0 -->0 X 0 --> 0 0 X
            if (vert != magicNumber) {       // X 0 0    0 X 0     0 0 X
                return false;
            }
            spaltenanzahl++;
        }
        return true;
    }

    private static int getMagic(int[][] square) {
        if (square.length == 0)          //falls length = 0 ist , wird nichts berechnet um ArrayOutOfBounds zu vermeiden
            return 0;                    //In der Main wird das dann nochmal abgefangen
        int magicnumber = 0;
        for (int numbers : square[0]) {  //da es immer ein Quadrat sein muss reicht es einfach die
            magicnumber += numbers;      //erste Reihe durchzugehen und alle Zahlen zusammenzurechnen
        }
        return magicnumber;
    }
}