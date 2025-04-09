package EjerciciosUD1;
import java.util.Scanner;


public class H_Guiñote {

    public static void main(String[] args) {
        int numeroAses, numeroTreses, numeroReyes, numeroSotas, numeroCaballos, numeroDeDoses, numeroDeCuatros, numeroDeCincos, numeroDeSeises, numeroDeSietes, numeroDeCantos20, numeroDeCantos40;
        int puntos, cantos, puntosFinal;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero de Ases: ");
        numeroAses = sc.nextInt();
        System.out.println("Ingrese el numero de Treses: ");
        numeroTreses = sc.nextInt();
        System.out.println("Ingrese el numero de Reyes: ");
        numeroReyes = sc.nextInt();
        System.out.println("Ingrese el numero de Sotas: ");
        numeroSotas = sc.nextInt();
        System.out.println("Ingrese el numero de Caballos: ");
        numeroCaballos = sc.nextInt();
        System.out.println("Ingrese el numero de Doses: ");
        numeroDeDoses = sc.nextInt();
        System.out.println("Ingrese el numero de Cuatros: ");
        numeroDeCuatros = sc.nextInt();
        System.out.println("Ingrese el numero de Cincos: ");
        numeroDeCincos = sc.nextInt();
        System.out.println("Ingrese el numero de Seises: ");
        numeroDeSeises = sc.nextInt();
        System.out.println("Ingrese el numero de Sietes: ");
        numeroDeSietes = sc.nextInt();
        System.out.println("Ingrese el numero de Cantos de 20: ");
        numeroDeCantos20 = sc.nextInt();
        System.out.println("Ingrese el numero de Cantos de 40: ");
        numeroDeCantos40 = sc.nextInt();

        puntos = ((numeroAses * 11) + (numeroTreses * 10) + (numeroSotas * 3) + (numeroCaballos * 2) + (numeroReyes * 4) + (numeroDeCantos20*20) + (numeroDeCantos40 *40));
        System.out.println("Cantidad de puntos totales: " + puntos);

        System.out.println(numeroDeCantos40 == 1 ? "TOC TOC" : "Aun no cantas 40");



    }

}

//expresionCondicional ? valor1 : valor2;
//precio = edad < 18 ? 0 : IMPORTE_TOTAL;
