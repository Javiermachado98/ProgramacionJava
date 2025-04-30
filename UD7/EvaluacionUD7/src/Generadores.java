import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.lang.Integer.parseInt;

public class Generadores {
    public static void main(String[] args) throws IOException {

        BufferedReader streamIn = null;
        int autonomia = 0;

        try {
            streamIn = new BufferedReader(new FileReader("src" + File.separator + "files" + File.separator + "generadores.csv"));

            String linea;
            while ((linea = streamIn.readLine()) != null) {
                String[] lineas = linea.split(";");

                System.out.println(Arrays.toString(lineas));
                System.out.println("Autonomia: " + lineas[6]);

            }

    }
        catch(
    Exception e)

    {
        System.out.println(e);
    }
        finally

    {
        if (streamIn != null) {
            streamIn.close();
        }
    }


}
}
