public class Length {
    private final double value;    //Value speichert den Wert einer Länge
    private final LengthUnit unit; //Unit speichert die Längeneinheit
                                   //Value und Unit können nicht mehr verändert werden
                                   //Wenn man etwas verändern will muss man ein neues Object erstellen
    /**
     * Erstellt eine neue Länge
     * @param value Value darf nicht 0 sein
     * @param unit Unit darf nicht {@code null} sein
     */
    public Length(double value,LengthUnit unit){ //Konstruktor für einen Wert und eine Einheit
        if(value == 0){ //value darf nie 0 sein da es 1. keinen Sinn macht 2. sonst durch 0 geteilt wird
            throw new IllegalArgumentException("Value cant be zero");
        }
        if(unit == null){ //unit darf nicht null sein
            throw new IllegalArgumentException("unit cant be null");
        }
        this.value = value; //Value und Unit werden auf die eingegebenen Werte gesetzt
        this.unit = unit;
    }

    /**
     * Konvertiert eine Länge in eine andere
     * @param unit unit in die man umwandeln will
     * @return Length Neues Längenobjekt in gewünschter Einheit
     */
    Length as(LengthUnit unit){
        if(unit == null){ //unit darf nicht null sein
            throw new IllegalArgumentException("unit cant be null");
        }                                                                           //Man erhält den Umrechnungsfaktor indem man die
        return new Length(value * this.unit.asMeter() / unit.asMeter(),unit); //aktuelle Einheit in Meter durch die Gewünchte Einheit
    }                                                                               //in Meter teilt. Dazu multipliziert man dann noch den Wert.

    /**
     * Addiert zwei Längen
     * @param other Länge zum dazu addieren
     * @return Ein neues Längenobjekt mit den addiertem Wert in der Einheit des orginalen Objekts
     */
    Length add(Length other){
        if(other == null){                                                  //Länge darf nicht null sein,sonst pointet man auf Null
            throw new IllegalArgumentException("darf nicht null sein");}    //Erst wird mithilfe von as() auf die selbe Recheneinheit gebracht
                                                                            //Dann können die Werte einfach addiert werden
        return new Length(value + other.as(this.unit).getValue(),unit);
    }

    @Override
    public String toString() {
        return value + unit.getSymbol();
    } //beim toString wird stat dem ganzen LengthUnit Object nur das Symbol ausgegeben

    public double getValue(){
        return value;
    } //Keine Setter da die Klasse unveränderlich ist

    public LengthUnit getUnit(){
        return unit;
    }
}

