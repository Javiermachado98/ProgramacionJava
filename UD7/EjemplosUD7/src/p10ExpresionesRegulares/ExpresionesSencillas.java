package p10ExpresionesRegulares;

import java.util.Scanner;

public class ExpresionesSencillas {
    public static void main(String[] args) {
        String palabra = "";
        Scanner sc = new Scanner(System.in);
        while (!palabra.equals("salir")) {
            palabra = sc.next();
            if (palabra.matches("[a-bA-B]\\w*")) {
                System.out.println("Cumple");
            } else {
                System.out.println("No cumple");
            }
        }
    }
}
