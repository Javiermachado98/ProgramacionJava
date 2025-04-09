import java.io.*;

public class E02Combinacion {
    public static void main(String[] args) throws IOException {
        BufferedReader streamEntrada = null;
        BufferedReader streamEntrada2 = null;
        BufferedWriter streamSalida = null;

        try {

            streamEntrada = new BufferedReader(new FileReader("src" + File.separator + "files" + File.separator + "entrada1.txt"));
            streamEntrada2 = new BufferedReader(new FileReader("src" + File.separator + "files" + File.separator + "entrada2.txt" ));
            streamSalida = new BufferedWriter(new FileWriter("src" + File.separator + "files" + File.separator + "salidaCombinacion.txt"));

            String linea1;
            String linea2;

            while ((linea1 = streamEntrada.readLine())!= null && (linea2 = streamEntrada2.readLine())!= null ){
                streamSalida.write(linea1 + linea2);
                streamSalida.newLine();
            }

        }catch (Exception e){
            System.out.println(e);

        }finally {
            if (streamEntrada != null) {
                streamEntrada.close();
            }
            if (streamEntrada2 != null) {
                streamEntrada.close();
            }

            if (streamSalida != null) {
                streamSalida.close();
            }


        }
    }
}