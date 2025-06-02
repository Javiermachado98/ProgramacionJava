/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c_parking;

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

    public static boolean ocupacionArreglo(int[][] arreglo, int planta) {
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
            System.out.println("Digite la planta en la que quiere parquear (1-8): ");
            int plantaUsuario = sc.nextInt();
            boolean parqueado = false;
            boolean ocupacion = false;
            boolean rango;

            if (plantaUsuario >= 1 && plantaUsuario <= 8) {
                int planta = plantaUsuario - 1; // Convertir a índice 0-7
                rango = true;
                ocupacion = ocupacionArreglo(arreglo, planta);
            } else {
                System.out.println("Error: Solo tenemos plantas del 1 al 8.");
                rango = false;
            }

            if (parqueado == false && ocupacion == false && rango == true) {
                int planta = plantaUsuario - 1;
                for (int contadorLlenador = 0; contadorLlenador < NUM_DE_PARQUEADEROS; contadorLlenador++) {
                    if (parqueado == false && arreglo[planta][contadorLlenador] == 0) {
                        arreglo[planta][contadorLlenador] = 1;
                        parqueado = true;
                        System.out.println("✅ Carro aparcado en Planta " + plantaUsuario + ", espacio " + (contadorLlenador + 1));
                    }
                }
            } else {
                System.out.println("Planta ocupada o fuera de rango.");
            }

            System.out.println("¿Desea salir? Ingrese 0, otro número para continuar: ");
            int salir = sc.nextInt();
            if (salir == 0) {
                repetir = false;
            }
        }
        return false;
    }

    public static boolean sacarCoche(int[][] arreglo) {
        boolean salioCarro = false;
        System.out.println("Digite la planta en donde tiene el coche (1-8): ");
        int plantaUsuario = sc.nextInt();
        if (plantaUsuario >= 1 && plantaUsuario <= 8) {
            int planta = plantaUsuario - 1;
            for (int contadorSalida = 0; contadorSalida < NUM_DE_PARQUEADEROS; contadorSalida++) {
                if (arreglo[planta][contadorSalida] == 1 && salioCarro == false) {
                    arreglo[planta][contadorSalida] = 0;
                    System.out.println("✅ Carro retirado de Planta " + plantaUsuario + ", espacio " + (contadorSalida + 1));
                    salioCarro = true;
                }
            }
            if (!salioCarro) {
                System.out.println("⚠️ No se encontró ningún carro en la Planta " + plantaUsuario);
            }
        } else {
            System.out.println("Error: Planta fuera de rango (1-8).");
        }
        return false;
    }

    public static boolean informeOcupacion(int[][] arreglo) {
        boolean vacio = false;
        for (int contadorPlantas = 0; contadorPlantas < NUM_PLANTAS; contadorPlantas++) {
            for (int contadorCapacidad = 0; contadorCapacidad < NUM_DE_PARQUEADEROS; contadorCapacidad++) {
                if (arreglo[contadorPlantas][contadorCapacidad] == 1) {
                    vacio = true;
                } else {
                    vacio = false;
                    System.out.println("Planta " + (contadorPlantas + 1) + ", Parqueadero " + (contadorCapacidad + 1) + ": VACÍO");
                }
            }
        }
        System.out.println(Arrays.deepToString(arreglo));
        return vacio;
    }

    public static boolean plantaVacia(int[][] arreglo) {
        int contadorLleno = 0;
        int[] arregloNivelOcupacion = new int[NUM_PLANTAS];

        for (int contadorPlantas = 0; contadorPlantas < NUM_PLANTAS; contadorPlantas++) {
            for (int contadorCapacidad = 0; contadorCapacidad < NUM_DE_PARQUEADEROS; contadorCapacidad++) {
                if (arreglo[contadorPlantas][contadorCapacidad] == 1) {
                    contadorLleno++;
                }
            }
            arregloNivelOcupacion[contadorPlantas] = contadorLleno;
            contadorLleno = 0;
        }

        for (int contadorCicloCeros = 0; contadorCicloCeros < NUM_PLANTAS; contadorCicloCeros++) {
            if (arregloNivelOcupacion[contadorCicloCeros] == 0) {
                System.out.println("La Planta " + (contadorCicloCeros + 1) + " está vacía.");
            }
        }

        System.out.println("Ocupación por planta: " + Arrays.toString(arregloNivelOcupacion));
        return false;
    }

    public static int totalCoches(int[][] arreglo) {
        int contadorTotalCoches = 0;
        for (int contadorPlantas = 0; contadorPlantas < NUM_PLANTAS; contadorPlantas++) {
            for (int contadorCapacidad = 0; contadorCapacidad < NUM_DE_PARQUEADEROS; contadorCapacidad++) {
                if (arreglo[contadorPlantas][contadorCapacidad] == 1) {
                    contadorTotalCoches++;
                }
            }
        }
        System.out.println("Total de coches en el parqueadero: " + contadorTotalCoches);
        return contadorTotalCoches;
    }

    public static boolean mantenimientoPlanta(int[][] arreglo, int plantaUsuario) {
        // Validar rango 1-8
        if (plantaUsuario < 1 || plantaUsuario > 8) {
            System.out.println("Error: La planta debe ser del 1 al 8.");
            return false;
        }

        int planta = plantaUsuario - 1; // Convertir a índice 0-7
        int carrosReasignados = 0;
        boolean plantaVacia = true;

        // Verificar si la planta ya está vacía
        for (int espacio = 0; espacio < NUM_DE_PARQUEADEROS; espacio++) {
            if (arreglo[planta][espacio] == 1) {
                plantaVacia = false;
                break;
            }
        }

        if (plantaVacia) {
            System.out.println("La Planta " + plantaUsuario + " ya está vacía. No se requieren reasignaciones.");
            return false;
        }

        // Reasignar carros a otras plantas
        for (int espacio = 0; espacio < NUM_DE_PARQUEADEROS; espacio++) {
            if (arreglo[planta][espacio] == 1) {
                boolean reasignado = false;
                for (int otraPlanta = 0; otraPlanta < NUM_PLANTAS; otraPlanta++) {
                    if (otraPlanta == planta) continue; // Saltar planta en mantenimiento
                    for (int otroEspacio = 0; otroEspacio < NUM_DE_PARQUEADEROS; otroEspacio++) {
                        if (arreglo[otraPlanta][otroEspacio] == 0) {
                            arreglo[otraPlanta][otroEspacio] = 1;
                            arreglo[planta][espacio] = 0;
                            carrosReasignados++;
                            reasignado = true;
                            System.out.println("Carro reasignado de Planta " + plantaUsuario + " a Planta " + (otraPlanta + 1));
                            break;
                        }
                    }
                    if (reasignado) break;
                }
                if (!reasignado) {
                    System.out.println("¡No hay espacios libres en otras plantas!");
                    break;
                }
            }
        }

        if (carrosReasignados > 0) {
            System.out.println("✅ Se reasignaron " + carrosReasignados + " carros desde la Planta " + plantaUsuario + ".");
            return true;
        } else {
            System.out.println("⚠️ No se reasignaron carros (no hay espacios libres).");
            return false;
        }
    }

    public static boolean porcentajeOcupacion(int[][] arreglo) {
    int[] arregloNivelOcupacion = new int[NUM_PLANTAS];
    System.out.println("Porcentaje de ocupación por planta:");

    for (int contadorPlantas = 0; contadorPlantas < NUM_PLANTAS; contadorPlantas++) {
        int contadorLleno = 0;
        
        for (int contadorCapacidad = 0; contadorCapacidad < NUM_DE_PARQUEADEROS; contadorCapacidad++) {
            if (arreglo[contadorPlantas][contadorCapacidad] == 1) {
                contadorLleno++;
            }
        }
        
        // Calcular porcentaje con decimales para mayor precisión
        double porcentaje = (contadorLleno * 100.0) / NUM_DE_PARQUEADEROS;
        arregloNivelOcupacion[contadorPlantas] = (int) Math.round(porcentaje);
        
        System.out.println("Planta " + (contadorPlantas + 1) + ": " + 
                         arregloNivelOcupacion[contadorPlantas] + "% (" + 
                         contadorLleno + "/" + NUM_DE_PARQUEADEROS + " espacios ocupados)");
    }
    
    return true;
}
    public static boolean sitiosReservados(int[][] arreglo) {
    System.out.println("¿Desea marcar plantas como reservadas? (1: Sí, 0: No): ");
    int respuesta = sc.nextInt();
    
    if (respuesta == 1) {
        System.out.println("Seleccione las plantas a reservar (1-8), separadas por comas:");
        System.out.println("Ejemplo: 1,4,6,8");
        sc.nextLine(); // Limpiar buffer
        String input = sc.nextLine();
        
        String[] plantas = input.split(",");
        System.out.println("\nPlantas reservadas:");
        
        for (String plantaStr : plantas) {
            try {
                int planta = Integer.parseInt(plantaStr.trim());
                if (planta >= 1 && planta <= 8) {
                    System.out.println("Planta " + planta + " reservada");
                    // Aquí podrías marcar en el arreglo las plantas reservadas
                    // por ejemplo: arreglo[planta-1][0] = 2; // 2 para reservado
                } else {
                    System.out.println("Planta " + planta + " no válida (debe ser 1-8)");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida: " + plantaStr);
            }
        }
    } else {
        System.out.println("No se reservaron plantas.");
    }
    
    return true;
}

    public static void main(String[] args) {
        int valorMenu = 0;
        int[][] miParqueadero = new int[NUM_PLANTAS][NUM_DE_PARQUEADEROS];

        do {
            mostrarMenu();
            valorMenu = sc.nextInt();
            switch (valorMenu) {
                case OPCION_MOSTRAR_PARKING -> System.out.println(Arrays.deepToString(miParqueadero));
                case OPCION_APARCAR -> aparcarCoche(miParqueadero);
                case OPCION_SACAR_COCHE -> sacarCoche(miParqueadero);
                case OPCION_PLANTAS_LIBRES -> informeOcupacion(miParqueadero);
                case OPCION_PLANTA_MAS_VACIA -> plantaVacia(miParqueadero);
                case OPCION_TOTAL_COCHES -> totalCoches(miParqueadero);
                case OPCION_MANTENIMIENTO_PLANTA -> {
                    System.out.println("Digite la planta a poner en mantenimiento (1-8): ");
                    int plantaMantenimiento = sc.nextInt();
                    mantenimientoPlanta(miParqueadero, plantaMantenimiento);
                }
                case OPCION_PORCENTAJE_OCUPACION -> porcentajeOcupacion(miParqueadero);
                case OPCION_NO_RESERVADAS -> sitiosReservados(miParqueadero);
                case OPCION_SALIR -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }
        } while (valorMenu != 10);
    }
}