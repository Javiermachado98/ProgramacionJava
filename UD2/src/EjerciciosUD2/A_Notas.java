package EjerciciosUD2;
import java.util.Scanner;
import java.util.Locale;

public class A_Notas {

    public static void main(String[] args) {
        double nota;

        Scanner sc  = new Scanner(System.in);
        sc.useLocale(Locale.US);
        System.out.println("Ingrese la nota: ");
        nota = sc.nextDouble();
        if (nota < 5 ){
            System.out.println("Suspendio");
        }else if (nota >= 5 && nota < 6 ) {
            System.out.println("suficiente");
        } else if (nota >= 6 && nota < 7){
            System.out.println("aprobado");
        } else if (nota >= 7 && nota < 9){
            System.out.println("notable");
        } else if (nota >= 9 && nota <= 10){
            System.out.println("sobresaliente");
        } else
            System.out.println("La nota debe estar entre 5 y 10");
    }
}