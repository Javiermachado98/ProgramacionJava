package EjerciciosUD1;
import java.util.Locale;
import java.util.Scanner;


public class B_Horas {
    public static void main(String[] args) {

        double segundos, minutos, horas;
        Scanner sc = new Scanner (System.in);
        sc.useLocale(Locale.US);
        System.out.println("Ingrese los segundos: ");
        segundos = sc.nextDouble();

        minutos = ((segundos*1) / 60);
        horas = ((minutos*1) / 60);



        //minutos = min * segundos;
        //horas = minutos * hor;
        System.out.println(segundos + " segundos, son: " + minutos + " minutos y: " + horas + " horas");

    }
}

//Escribe un programa que pida una cantidad de segundos y la convierta en horas, minutos y segundos.
// 1 minuto son 60 seg //1 hora son 60 minutos