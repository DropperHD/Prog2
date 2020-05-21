public enum LengthUnit {
    MILLIMETER("mm",0.001,LengthSystem.SI ), CENTIMETER("cm", 0.01,LengthSystem.SI),
    METER("m", 1.0,LengthSystem.SI), KILOMETER("km",1000.0,LengthSystem.SI),
    ASTRONOMICAL_UNIT("au",149000000000.0,LengthSystem.SI), INCH("in",25.4e-3,LengthSystem.IMPERIAL),
    FOOT("ft",0.305,LengthSystem.IMPERIAL), YARD("yd",0.914,LengthSystem.IMPERIAL);

    private final String symbol; //Rechensymbol der Einheit (z.B. cm) nicht veränderbar
    private final double meter; //Einheit umgerechnet in Meter nicht veränderbar

    private enum LengthSystem{IMPERIAL,SI} //Enum das die zwei verschiedenen Längensysteme beinhaltet
    private final LengthSystem sys; //Hier wird dann das jeweilige System gespeichert

    /**
     * Erstellt eine neue Längeneinheit
     * @param symbol Symbol
     * @param meter Länge in meter
     * @param sys Längensystem. Kann entweder Imperial oder Metrisch sein
     */
    LengthUnit(String symbol,double meter,LengthSystem sys){
        if(symbol == null){ //Symbol darf nicht null sein
                throw new IllegalArgumentException("symbol kann nicht null sein");
        }
        if(meter == 0){ //0 macht keinen Sinn
            throw new IllegalArgumentException("meter darf nicht die Zahl 0 sein");
        }
        if(sys == null){ //sys darf auch nicht null sein
            throw new IllegalArgumentException("sys darf nicht null sein");
        }

        this.symbol = symbol; //Argumente werden übergeben
        this.meter = meter;
        this.sys = sys;
    }
    /**
     * Liefert die den Umrechungsfaktor der Einheit x zu Meter
     * @return Umrechungsfaktor zu Metern
     */
    public double asMeter(){ //das selbe wie getMeter()
        return meter;
    }

    /**
     * schaut ob eine Einheit metrisch ist
     * @return wahr falls metrisch
     */
    boolean isSI(){
        return this.sys == LengthSystem.SI; //falls sys gleich mit LengthSystem.SI wird wahr zurückgegeben
    }

    /**
     * Erstellt ein Lengthobjekt anhand einer Einheit
     * @param symbol Symbol der Einheit
     * @return Lengthunit mit den Werten die im Enum oben festgelegt wurden
     */
    public static LengthUnit fromSymbol(String symbol){ //static da das nur im Rahmen der Klasse abläuft und man kein Objekt dafür braucht
        for(LengthUnit length : LengthUnit.values()){ //für alle Längen im Enum LengthUnit wird geschaut
            if(symbol.equals(length.symbol)){   //falls das gesuchte Symbol mit dem des aktuellen übereinstimmt wird die Länge
                return length;                  //an der Stelle im Enum zurückgegeben
            }
        }
        throw new IllegalArgumentException("Symbol nicht gefunden!"); //falls das Symbol nicht im Enum ist
    }

    public String getSymbol(){
        return symbol;
    }

    public double getMeters(){ //JUnits brauchen getMeters()
        return meter;
    }
}

