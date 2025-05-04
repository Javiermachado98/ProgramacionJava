package EjerciciosUD2;
import java.util.Scanner;

public class B_radar {
    public static void main(String[] args) {
        int radar;
        Scanner sc = new Scanner (System.in);
        System.out.println("Radar Movil: ");
        radar = sc.nextInt();

        if (radar >= 0 && radar < 50){
            System.out.println("siga asi");
        }else if (radar >= 50 && radar <= 60){
            System.out.println("Cuidad, le podriamos poner una multa");
        }else if (radar > 60 && radar < 70){
            System.out.println("Sancion de 100 euros");
        }else{
            System.out.println("Sancion de 300 euros y retirada de carnet");
        }
    }
}


/*(fichero B_Radar.java). Realizar un programa que sirva para un radar móvil para la
entrada a una ciudad. Pedirá la velocidad de circulación y devolverá al usuario un mensaje de
la siguiente forma
o 0 – 50 km -> siga así
o 50-60- > Cuidado, le podríamos poner una multa
o 61-70-> Sanción de 100 euros
o > 70-> Sanción de 300 euros y retirada de carnet*/