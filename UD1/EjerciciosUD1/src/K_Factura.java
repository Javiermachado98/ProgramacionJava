package EjerciciosUD1;
import java.util.Scanner;
import java.util.Locale;

public class K_Factura {
    public static void main(String[] args) {
        final double precio = 0.0940;
        final double termino = 0.1496;
        final double impuesto = 0.05113;
        final double valorDia = 0.017753;
        final int dias = 30;
        double potenciaContratada, consumo, potenciaFacturada, energiaFacturada, impuestoTotal, contadorDias, iva, total;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la potencia contratada (el numero de kW): ");
        potenciaContratada = sc.nextDouble();
        System.out.println("Ingrese el consumo (numero de kWh consumidos): ");
        consumo = sc.nextDouble();

        potenciaFacturada = (potenciaContratada * precio * dias);
        System.out.println("Valor de la potencia en la factura: " + potenciaFacturada);

        energiaFacturada = (consumo * termino);
        System.out.println("La energia facturada es la siguiente: " + energiaFacturada);

        impuestoTotal = (impuesto * (potenciaFacturada + energiaFacturada));
        System.out.println("El impuesto total del valor es: " + impuestoTotal);

        contadorDias = (valorDia * dias);
        System.out.println("Valor del contador por dia: " + contadorDias);

        iva = (potenciaFacturada + energiaFacturada + impuestoTotal + contadorDias) * 0.1;
        total = (potenciaFacturada + energiaFacturada + impuestoTotal + contadorDias + iva);
        System.out.println("El iva es: " + iva);
        System.out.println("El total de la factura es: " + total);
    }

}