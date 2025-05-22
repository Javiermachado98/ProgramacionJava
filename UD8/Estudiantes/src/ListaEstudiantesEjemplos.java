import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ListaEstudiantesEjemplos {
    static List<String> mylistaEstudiantes = new ArrayList<>();


    public static void llenarLista(){
        String fin;
        Scanner sc = new Scanner(System.in);
        while (true){

            System.out.println("Ingrese la letra y cero para salir: ");
            fin = sc.nextLine();


            mylistaEstudiantes.add(String.valueOf(fin));


            if (Objects.equals(fin, "c")){
                System.out.println("salio");
                System.out.println(mylistaEstudiantes.get(4));
                break;

            }

        }
    }

    public static void main(String[] args) {
        llenarLista();
    }
}
