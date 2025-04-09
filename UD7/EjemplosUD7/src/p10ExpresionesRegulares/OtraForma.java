package p10ExpresionesRegulares;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OtraForma {

    public static void main(String[] args) {

        String palabra = "";

        String regex = "[a-bA-B]\\w*";
        Pattern pattern = Pattern.compile(regex);
        
        Scanner sc = new Scanner(System.in);
        while (!palabra.equals("salir")) {

            palabra = sc.next();
            Matcher matcher = pattern.matcher(palabra);

            if (matcher.matches()) {
                System.out.println("Cumple");
            } else {
                System.out.println("No cumple");
            }
        }

    }

}
