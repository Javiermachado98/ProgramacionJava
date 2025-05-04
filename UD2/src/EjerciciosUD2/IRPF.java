package EjerciciosUD2;
import java.util.Scanner;

public class IRPF {
    public static void main(String[] args) {

        double salario, retencion;
        Scanner sc = new Scanner (System.in);
        System.out.println("Ingrese tu salario: ");
        salario = sc.nextDouble();

        if (salario < 12450){
            retencion = 19;
        } else if (salario < 20000){
            retencion = 24;
        } else if (salario < 35200){
            retencion = 37;
        } else if (salario < 60000){
            retencion = 45;
        } else {
            retencion = 47;
        }
        System.out.println("El porcentaje de retencion es del " + retencion + "%");


    }
}
