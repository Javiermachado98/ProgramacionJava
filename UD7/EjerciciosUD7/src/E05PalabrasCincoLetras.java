import java.io.*;
import java.util.Arrays;

public class E05PalabrasCincoLetras {

    public static void main(String[] args) throws IOException {

        BufferedReader streamIn = null;
        BufferedWriter streamOut = null;
        BufferedReader streamIn2 = null;

        try {
            streamOut = new BufferedWriter(new FileWriter("src" + File.separator + "files" + File.separator + "salida.txt"));

            for (char words = 'a'; words <= 'z'; words++) {
                streamIn = new BufferedReader(new FileReader("src" + File.separator + "dics" + File.separator + words + ".txt"));
                streamIn2 = new BufferedReader(new FileReader("src" + File.separator + "dics" + File.separator + "ñ.txt"));

                String word;
                String wordEnie;
                while ((word = streamIn.readLine()) != null) {

                    if (word.length() == 5) {

                        streamOut.write(word);
                        streamOut.newLine();

                    }
                }
                while ((wordEnie = streamIn2.readLine()) != null) {

                    if (wordEnie.length() == 5) {

                        streamOut.write(wordEnie);
                        streamOut.newLine();

                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (streamIn != null) {
                streamIn.close();
            }
            if (streamOut != null) {
                streamOut.close();
            }
            if (streamOut != null) {
                streamOut.close();
            }

        }

    }


}
