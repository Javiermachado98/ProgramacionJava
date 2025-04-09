package EjerciciosUD1;
import java.util.Scanner;
import java.util.Locale;

public class G_Grados {
    public static void main(String[] args) {
        double gradosCelsius, gradosFahrenheit;
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        System.out.println("Ingrese la temperatura en grados Celsius");
        gradosCelsius = sc.nextDouble();
        gradosFahrenheit = (gradosCelsius * 9/5) + 32;
        System.out.println("La temperatura en grados Fahrenheit es: " + gradosFahrenheit);
    }
}

//Escribe un programa que convierta una temperatura dada en grados Celsius a Fahrenheit. Usa la fórmula: F = C * 9/5 + 32.