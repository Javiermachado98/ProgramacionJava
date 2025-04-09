import java.io.*;

public class E05PalabrasCincoLetras {

    public static void main(String[] args) throws IOException {



        BufferedReader streamIn = null;
        BufferedWriter streamOut = null;

        try {

            streamIn = new BufferedReader(new FileReader("src" + File.separator + "dics" + File.separator + "a.txt"));
            streamOut = new BufferedWriter(new FileWriter("src" + File.separator + "files" + File.separator + "salida.txt"));


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
