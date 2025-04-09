import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class E04Decodifica {


    public static boolean invalidKey(int key) {
        if (key < 1 || key > 10) {
            System.out.println("Error: Invalid key, the key must be between 1 and 10");
            return false;
        }
        return true;
    }

    public static String file(String myFile) {
        File f = new File("src" + File.separator + "files" + File.separator + myFile);
        if (f.exists()) {
            if (f.getName().startsWith("private.")) {
                System.out.println("the file exists with the prefix private.");
            } else {
                System.out.println("file does not exist with prefix private.");
            }
        } else {
            System.out.println("file does not exist");

        }
        return myFile;
    }


    public static void main(String[] args) throws IOException {
        //importante para saber la ruta de trabajo
        System.out.println("Directorio de trabajo actual: " + System.getProperty("user.dir"));
        //Siempre de primeras, si manejo args, debe ir esta comparacion por que nunca debe ser cero, aqui son 2 por que son 2 parametros

        if (args.length != 2) {
            System.out.println("Missing parameters");
            return;
        }

        int key;
        FileReader streamIn = null;
        FileWriter streamOut = null;
        String myFile = args[0];
        System.out.println("The name of my file is : " + myFile);
        key = Integer.parseInt(args[1]);

        if (!invalidKey(key)) {
            // si la clave NO es valida, se detiene el programa
            return;
        }
        file(myFile);

        try {

            streamIn = new FileReader("src" + File.separator + "files" + File.separator + myFile);
            //aqui gracias a la funcion replaceFirst pude cambiar el prefijo del nombre || preguntar por que no funciona arriba
            streamOut = new FileWriter("src" + File.separator + "files" + File.separator + myFile.replaceFirst("private.","public."));

            int c;
            while ((c = streamIn.read()) != -1) {
                streamOut.write(c - key);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //siempre se debe cerrar el buffer
            if (streamIn != null) {
                streamIn.close();
            }
            if (streamOut != null) {
                streamOut.close();
            }
        }

    }


}
