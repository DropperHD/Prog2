package com.company;

public class PasswordChecker {
    /**
     * Checkt ein Passwort auf Gültigkeit
     *
     * @param password String Passwort sollte mindestens 8 Buchstaben, einen Kleinbuchstaben,einen Großbuchstaben, eine Zahl,
     *                 und ein Sonderzeichen haben
     * @return true falls das Passwort passt
     */
    public static boolean check(String password){
        if(password == null || password.length() < 8 ){ //falls es kleiner als 8 oder null ist wird returned
            return false;
        }
        char[] chararray = password.toCharArray(); //String wird in ein Chararray transformiert
        boolean hasUppercase = false ,hasLowercase = false,hasSpecialletter = false,hasNumber = false; //Bedingungen werden initalisiert
        for(char letters : chararray){            //dann wird für jeden der Buchstaben im Array geschaut ob er eine Bedingung erfüllt
            if(letters >= 'A' && letters <= 'Z'){ //Großbuchstaben
                hasUppercase = true;
            }
            else if(letters >= 'a' && letters <= 'z'){ //Kleinbuchstaben
                hasLowercase = true;
            }
            else if(letters >= '0' && letters <= '9'){ //Zahlen
                hasNumber = true;
            }
            else if(letters == '!' || letters == '.' || letters == '?' || letters == '#') { //Sonderzeichen
                hasSpecialletter = true;
            } else{
                return false; //falls nichts davon zutrifft ist der Buchstabe ungültig und das ganze Passwort ist falsch
            }
        }
        return hasLowercase && hasUppercase && hasNumber && hasSpecialletter; //falls alle Bedingungen erfüllt sind wird true returned
    }
}
