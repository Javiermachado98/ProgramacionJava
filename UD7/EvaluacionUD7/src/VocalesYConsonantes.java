import java.io.*;

public class VocalesYConsonantes {

    public static void main(String[] args) throws IOException {

        BufferedWriter streamOut = null;
        BufferedWriter streamOut2 = null;

        try {
            streamOut = new BufferedWriter(new FileWriter("src" + File.separator + "files" + File.separator + "Consonantes.txt"));
            streamOut2 = new BufferedWriter(new FileWriter("src" + File.separator + "files" + File.separator + "vocales.txt"));

            for (char words = 'a'; words <= 'z'; words++) {
                if (words == 'a' || words == 'e' || words == 'i' || words == 'o' || words == 'u') {
                    streamOut2.write(words);
                    streamOut2.newLine();
                } else {
                    streamOut.write(words);
                    streamOut.newLine();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (streamOut != null) {
                streamOut.close();
            }
            if (streamOut2 != null) {
                streamOut2.close();
            }
        }
    }

}
