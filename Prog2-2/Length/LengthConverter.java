public class LengthConverter{
    /**
     * Converts a Length into other Units
     * @param args Value, Unit, Desired Unit
     */
    public static void main(String[] args) {
        if (args.length != 3 ) {
            throw new IllegalArgumentException("too much or too little input");
        }
        Length length = new Length(Double.parseDouble(args[0]), LengthUnit.fromSymbol(args[1]));
        System.out.print(length.as(LengthUnit.fromSymbol(args[2])));
    }
}


