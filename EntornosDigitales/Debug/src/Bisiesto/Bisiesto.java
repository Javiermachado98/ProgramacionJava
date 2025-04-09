package Bisiesto;

public class Bisiesto {
    /*
     * Para saber si un año es bisiesto. Un año es bisiesto si es divisible por
     * cuatro, excepto si es divisible por 100. Tambien sera bisiesto si es
     * divisible por 400
     */
    public boolean esBisiesto(int year) {
        if ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0)))
            return true;
        else
            return false;
    }
}