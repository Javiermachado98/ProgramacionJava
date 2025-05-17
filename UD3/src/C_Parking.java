import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

public class C_Parking {

    public static final int OPCION_MOSTRAR_PARKING = 1;
    public static final int OPCION_APARCAR = 2;
    public static final int OPCION_SACAR_COCHE = 3;
    public static final int OPCION_PLANTAS_LIBRES = 4;
    public static final int OPCION_PLANTA_MAS_VACIA = 5;
    public static final int OPCION_TOTAL_COCHES = 6;
    public static final int OPCION_MANTENIMIENTO_PLANTA = 7;
    public static final int OPCION_PORCENTAJE_OCUPACION = 8;
    public static final int OPCION_NO_RESERVADAS = 9;
    public static final int OPCION_SALIR = 10;
    public static Scanner sc = new Scanner(System.in);
    public static final int NUM_PLANTAS = 8;
    public static final int NUM_DE_PARQUEADEROS = 5;

    public static void mostrarMenu() {
        System.out.println("==================================================");
        System.out.println(" Parking Monzon  ");
        System.out.println("==================================================");
        System.out.println("1.-  MOSTRAR DISPONIBILIDAD: ");
        System.out.println("2.-  APARCAR");
        System.out.println("3.-  SACAR COCHE");
        System.out.println("4.-  PLANTAS LIBRES");
        System.out.println("5.-  PLANTA MAS VACIA");
        System.out.println("6.-  TOTAL COCHES");
        System.out.println("7.-  MANTENIMIENTO PLANTA");
        System.out.println("8.-  PORCENTAJE OCUPACION");
        System.out.println("9.-  NO RESERVADAS");
        System.out.println("10.-  SALIR");
        System.out.println("==================================================");
        System.out.print("Introduce una opción: ");
    }

    public static boolean ocupacionArreglo(int[][] arreglo, int planta) { // un valor que esta dentro de una variable que esta dentro del programa
        boolean ocupacion = false;

        for (int myarreglo = 0; myarreglo < NUM_DE_PARQUEADEROS; myarreglo++) {

            if (arreglo[planta][myarreglo] == 1) {
                ocupacion = true;

            } else {
                ocupacion = false;
            }
        }

        return ocupacion;
    }

    public static boolean aparcarCoche(int[][] arreglo) {

        boolean repetir = true;
        while (repetir) {

            System.out.println("Digite la planta en la que quiere parquear: ");
            int planta = sc.nextInt();
            boolean parqueado = false;
            boolean ocupacion = false;
            boolean rango;

            if (planta >= 1 && planta <= 8) {
                planta = planta - 1;
                rango = true;
                ocupacion = ocupacionArreglo(arreglo, planta);
            } else {
                System.out.println("Solo tenemos plantas de la 1 a la 8");
                rango = false;
            }
            if (parqueado == false && ocupacion == false && rango == true) {

                if (planta >= 0 && planta < 8) {
                    for (int contadorLlenador = 0; contadorLlenador < NUM_DE_PARQUEADEROS; contadorLlenador++) {

                        if (parqueado == false && arreglo[planta][contadorLlenador] == 0) {

                            arreglo[planta][contadorLlenador] = 1;
                            parqueado = true;
                            System.out.println("Gracias por parquear su carro esta en la planta: " + planta + " en la posicion " + contadorLlenador);
                        }
                    }
                }
            } else {
                System.out.println("Planta ocupada o Planta incorrecta");
            }

            System.out.println("Desea salir ingrese 0 o escriba otro numero para seguir parqueando");
            int salir = sc.nextInt();
            if (salir == 0) {
                repetir = false;
            }

        }

        return false;
    }

    public static boolean sacarCoche(int[][] arreglo) {

        boolean salioCarro = false;
        System.out.println("Digite la planta en donde tiene el coche: ");
        int planta = sc.nextInt();
        if (planta >= 1 && planta <= 8) {
            planta = planta - 1;
            for (int contadorSalida = 0; contadorSalida < NUM_DE_PARQUEADEROS; contadorSalida++) {
                if (arreglo[planta][contadorSalida] == 1 && salioCarro == false) {
                    arreglo[planta][contadorSalida] = 0;
                    System.out.println("Gracias por usar nuestro servicio, vuelva pronto.");
                    salioCarro = true;
                }
            }
        } else {
            System.out.println("Planta fuera de rango");
        }

        return false;
    }


    public static boolean informeOcupacion(int[][] arreglo) { // un valor que esta dentro de una variable que esta dentro del programa
        boolean vacio = false;

        for (int contadorPlantas = 0; contadorPlantas < NUM_PLANTAS; contadorPlantas++) {
            for (int contadorCapacidad = 0; contadorCapacidad < NUM_DE_PARQUEADEROS; contadorCapacidad++) {

                if (arreglo[contadorPlantas][contadorCapacidad] == 1) {
                    vacio = true;

                } else {
                    vacio = false;
                    System.out.println("parqueadero: " + contadorPlantas + " Parqueadero: " + contadorCapacidad + " esta vacio ");
                }
            }
        }
        System.out.println(Arrays.deepToString(arreglo));
        return vacio;
    }

    public static boolean plantaVacia(int[][] arreglo) { // un valor que esta dentro de una variable que esta dentro del programa


        int contadorLleno = 0;
        int[] arregloNivelOcupacion = new int[NUM_PLANTAS];

        for (int contadorPlantas = 0; contadorPlantas < NUM_PLANTAS; contadorPlantas++) {
            for (int contadorCapacidad = 0; contadorCapacidad < NUM_DE_PARQUEADEROS; contadorCapacidad++) {

                if (arreglo[contadorPlantas][contadorCapacidad] == 1) {
                    contadorLleno = contadorLleno + 1;

                }
            }
            arregloNivelOcupacion[contadorPlantas] = contadorLleno;
            contadorLleno = 0;
        }
        for (int contadorCicloCeros = 0; contadorCicloCeros < NUM_PLANTAS; contadorCicloCeros++) {
            if (arregloNivelOcupacion[contadorCicloCeros] == 0) {
                System.out.println("La planta: " + contadorCicloCeros + " esta vacia");
            }
        }


        System.out.println(Arrays.toString(arregloNivelOcupacion));

        return false;
    }


    public static int totalCoches(int[][] arreglo) { // un valor que esta dentro de una variable que esta dentro del programa

        int contadorTotalCoches = 0;
        for (int contadorPlantas = 0; contadorPlantas < NUM_PLANTAS; contadorPlantas++) {
            for (int contadorCapacidad = 0; contadorCapacidad < NUM_DE_PARQUEADEROS; contadorCapacidad++) {

                if (arreglo[contadorPlantas][contadorCapacidad] == 1) {
                    contadorTotalCoches = contadorTotalCoches + 1;
                }
            }
        }
        System.out.println("En el parqueadero se encuentran un total de: " + contadorTotalCoches + " coches");
        return contadorTotalCoches;
    }

    public static boolean mantinimientoPlanta(int[][] arreglo) { // un valor que esta dentro de una variable que esta dentro del programa


        System.out.println("Ingrese la planta del mantenimiento: ");
        Scanner sc = new Scanner(System.in);
        int planta = sc.nextInt();
        int contadorvacio = 0;
        boolean mantenimiento = false;

        for (int contadorPlantas = 0; contadorPlantas < NUM_PLANTAS; contadorPlantas++) {
            for (int contadorCapacidad = 0; contadorCapacidad < NUM_DE_PARQUEADEROS; contadorCapacidad++) {

                if (arreglo[planta][contadorCapacidad] == 1 && contadorvacio < 5) {
                    System.out.println("esta planta esta llena");
                    arreglo[planta][contadorCapacidad] = 0;
                    contadorvacio = contadorvacio + 1;
                    System.out.println("este es mi contador" + contadorvacio);
                    if (contadorvacio == 5) {
                        mantenimiento = true;
                    }

                }

                if (mantenimiento == true && contadorPlantas != planta) {
                    arreglo[contadorPlantas][contadorCapacidad] = 1;
                }


                System.out.println(arreglo[contadorPlantas][contadorCapacidad]);
            }


        }

        /*for (int contadorPlantas = 0; contadorPlantas < 8; contadorPlantas++) {
            for (int contadorCapacidad = 0; contadorCapacidad < 5; contadorCapacidad++) {

                if (arreglo[contadorPlantas][contadorCapacidad] == 1) {
                    contadorLleno = contadorLleno + 1;


                } else {
                    plantaVacia = false;
                    System.out.println("parqueadero: " + contadorPlantas + " Parqueadero: " + contadorCapacidad + " esta vacio ");
                }
            }
            arregloNivelOcupacion[contadorPlantas] = contadorLleno;
            contadorLleno = 0;
        }*/

        return mantenimiento;
    }

    public static boolean porcentajeOcupacion(int[][] arreglo){

        double[] arregloPorcentaje = new double[NUM_PLANTAS];

        int contadorTotalCoches = 0;
        for (int contadorPlantas = 0; contadorPlantas < NUM_PLANTAS; contadorPlantas++){
            for (int contadorCapacidad = 0; contadorCapacidad < NUM_DE_PARQUEADEROS; contadorCapacidad++){
                if (arreglo[contadorPlantas][contadorCapacidad] == 1){
                    contadorTotalCoches = contadorTotalCoches + 1;

                }
                arregloPorcentaje[contadorPlantas] = contadorTotalCoches;
            }

            arregloPorcentaje[contadorPlantas] = arregloPorcentaje[contadorPlantas] / 100;
        }
        System.out.println(Arrays.toString(arregloPorcentaje));
        return false;
    }


    public static void main(String[] args) {


        int valorMenu = 0;
        int[][] miParqueadero;
        miParqueadero = new int[NUM_PLANTAS][NUM_DE_PARQUEADEROS];

        do {
            mostrarMenu();
            valorMenu = sc.nextInt();
            switch (valorMenu) {
                case OPCION_MOSTRAR_PARKING -> {
                    System.out.println(Arrays.deepToString(miParqueadero));
                }
                case OPCION_APARCAR -> {
                    aparcarCoche(miParqueadero);
                }
                case OPCION_SACAR_COCHE -> {
                    sacarCoche(miParqueadero);

                }
                case OPCION_PLANTAS_LIBRES -> {
                    informeOcupacion(miParqueadero);

                }
                case OPCION_PLANTA_MAS_VACIA -> {

                    plantaVacia(miParqueadero);
                }
                case OPCION_TOTAL_COCHES -> {
                    totalCoches(miParqueadero);

                }
                case OPCION_MANTENIMIENTO_PLANTA -> {
                    mantinimientoPlanta(miParqueadero);
                }
                case OPCION_PORCENTAJE_OCUPACION -> {
                    porcentajeOcupacion(miParqueadero);
                }
                case OPCION_NO_RESERVADAS -> {

                }
                case OPCION_SALIR -> {

                }
            }

        }
        while (valorMenu != 10);






       /* System.out.println("Comprobar las plantas vacias: ");
        for (int contadorPlantas = 0; contadorPlantas < myplanta; contadorPlantas++){
            for (int contadorCapacidad = 0; contadorCapacidad < mycapacidad; contadorCapacidad++){
                if (miParqueadero[contadorPlantas][contadorCapacidad] == 0){

                }
            }
        }*/


    }

}


