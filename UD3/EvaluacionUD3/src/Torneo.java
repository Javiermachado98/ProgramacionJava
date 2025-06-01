import java.util.Scanner;

public class Torneo {


    public static final int OPCION_SALIR = 10;
    public static void mostrarMenu() {
        System.out.println("==============");
        System.out.println("Gestion Partidos de futbol, si desea salir escriba 2");
        System.out.println("1. Agregar puntos");
        System.out.println("2. Salir y mostrar estadisticas");
        System.out.println("==============");
        System.out.println("Seleccione una opcion: ");
    }
    public static void main(String[] args) {

        int opcion;
        int equipoA = 0;
        int equipoB = 0;
        int equipoC = 0;
        int incremento1, incremento2, incremento3;
        double porcentajeA = 0;
        double porcentajeB = 0;
        double porcentajeC = 0;
        double total;


        do {
            mostrarMenu();
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();
            if (opcion == 1){
                System.out.println("Ingrese el equipo al cual le quiere añadir los puntos: \n" +
                        "1. Equipo A \n" +
                        "2. Equipo B \n" +
                        "3. Equipo C");
                int equipo = sc.nextInt();
                if(equipo == 1){
                    System.out.println("Cuantos puntos desea agregarle al equipo 1:");
                    incremento1 = sc.nextInt();
                    equipoA = equipoA + incremento1;

                } else if (equipo == 2) {
                    System.out.println("Cuantos puntos desea agregarle al equipo 2:");
                    incremento2 = sc.nextInt();
                    equipoB = equipoB + incremento2;

                } else if (equipo == 3) {
                    System.out.println("Cuantos puntos desea agregarle al equipo 3:");
                    incremento3 = sc.nextInt();
                    equipoC = equipoC + incremento3;

                }else {
                    System.out.println("Solo puede elegir uno de los 3 equipos " + equipo + " No es valido");
                }

                System.out.println("PUNTOS TOTALES: ");
                System.out.println("Equipo 1: " + equipoA);
                System.out.println("Equipo 2: " + equipoB);
                System.out.println("Equipo 3: " + equipoC);
                System.out.println("=====================");

            } else if (opcion != 2) {
                System.out.println("Opcion no valida Ingrese 1 o 2");
                
            }
        }while (opcion != 2);
        System.out.println("Gracias por usar nuestro programa");
        if (equipoA > equipoB && equipoA > equipoC){
            System.out.println("El equipo ganador es el equipo A, con un total de: " + equipoA);
        } else if (equipoB > equipoA && equipoB > equipoC) {
            System.out.println("El equipo ganador es el equipo B con un total de: " + equipoB);
        }else {
            System.out.println("El equipo ganador es el equipo C con un total de: " + equipoC);
        }

        total = equipoA + equipoB + equipoC;
        porcentajeA = (equipoA / total) * 100;
        porcentajeB = (equipoB / total) * 100;
        porcentajeC = (equipoC / total) * 100;


        System.out.println("================");
        System.out.println("Resultados");
        System.out.println("PUNTOS TOTALES: ");
        System.out.println("Equipo 1: " + equipoA);
        System.out.println("Equipo 2: " + equipoB);
        System.out.println("Equipo 3: " + equipoC);
        System.out.println("=====================");
        System.out.println("Porcentajes");
        System.out.println("Equipo 1: " + porcentajeA);
        System.out.println("Equipo 2: " + porcentajeB);
        System.out.println("Equipo 3: " + porcentajeC);


    }
}
