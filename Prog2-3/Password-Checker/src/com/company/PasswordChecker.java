package com.company;

public class PasswordChecker {

    public static boolean check(String password){
        if(password == null || password.length() < 8 ){
            return false;
        }
        char[] chararray = password.toCharArray();
        boolean hasUppercase = false ,hasLowercase = false,hasSpecialletter = false,hasNumber = false;
        for(char letters : chararray){
            if(letters >= 'A' && letters <= 'Z'){
                hasUppercase = true;
            }
            else if(letters >= 'a' && letters <= 'z'){
                hasLowercase = true;
            }
            else if(letters >= '0' && letters <= '9'){
                hasNumber = true;
            }
            else if(letters == '!' || letters == '.' || letters == '?' || letters == '#') {
                hasSpecialletter = true;
            } else{
                return false;
            }
        }
        return hasLowercase && hasUppercase && hasNumber && hasSpecialletter;
    }
}
