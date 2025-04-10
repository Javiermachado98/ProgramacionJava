import java.io.*;
import java.util.Arrays;

public class E05PalabrasCincoLetras {

    public static void main(String[] args) throws IOException {



        BufferedReader streamIn = null;
        BufferedWriter streamOut = null;

        try {

            streamIn = new BufferedReader(new FileReader("src" + File.separator + "dics" + File.separator + "a.txt"));
            streamOut = new BufferedWriter(new FileWriter("src" + File.separator + "files" + File.separator + "salida.txt"));

            String word;
            while ((word = streamIn.readLine()) != null){
                String [] words = word.split("");

                if (words.length == 5){
                    System.out.println(words.length + "caracteres");
                    System.out.println(Arrays.toString(words));
                    streamOut.write(Arrays.toString(words));
                    streamOut.newLine();
                }


            }




        } catch (Exception e) {
            System.out.println(e);
        }finally {
            if (streamIn != null) {
                streamIn.close();
            }
            if (streamOut != null) {
                streamOut.close();
            }

        }

    }


}
