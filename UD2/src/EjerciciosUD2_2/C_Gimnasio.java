package EjerciciosUD2_2;
import java.util.Scanner;
import java.util.Locale;

public class C_Gimnasio {
    public static void main(String[] args) {
        gimnasio();
    }

    public static void gimnasio() {
        double altura, peso, imc, pesoMedio = 0, pesoMenor = 0, pesoMayor = 0;
        int mesMayor = 0, mesMenor = 0;

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        System.out.println("Ingrese la altura: ");
        altura = sc.nextDouble();

        for (int meses = 1; meses <= 12; meses++) {
            System.out.println("Ingrese la peso del mes: " + meses);
            peso = sc.nextDouble();
            pesoMedio = pesoMedio + peso;

            if (meses == 1) {
                pesoMenor = peso;
            } else if (peso < pesoMenor) {
                pesoMenor = peso;
                System.out.println("Nuevo peso menor registrado: " + pesoMenor);
                mesMenor = meses;
            }
            if (peso > pesoMayor) {
                pesoMayor = peso;
                System.out.println("Peso mayor: " + pesoMayor);
                mesMayor = meses;
            }

            if (meses == 12){
                imc = peso / (altura * altura);
                System.out.println("imc del mes de diciembre: " + imc);
                pesoMedio = pesoMedio / meses;
            }
        }
        System.out.println("El peso promedio es: " + pesoMedio);
        System.out.println("El peso mayor fue: " + pesoMayor + " en el mes: " + mesMayor);
        System.out.println("El peso menor fue: " + pesoMenor + " en el mes: " + mesMenor);
    }
}
