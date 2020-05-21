public class LengthConverter{
    /**
     * Rechnet eine Länge in eine andere um und gibt sie auf der Konsole aus
     * @param args Wert, Einheit, gewünschte Einheit
     */
    public static void main(String[] args) {
        if (args.length != 3 ) { //Programm braucht genau 3 Inputs
            throw new IllegalArgumentException("Programm braucht 3 Inputs");
        }
        Length length = new Length(Double.parseDouble(args[0]), LengthUnit.fromSymbol(args[1])); //Neues Length Object wird erstellt
        System.out.print(length.as(LengthUnit.fromSymbol(args[2])));                             //Args 2 muss in double umgewandelt werden,
    }                                                                                            //da es noch ein String ist.
}


