import java.io.*;

public class E03Codifica {

    //creo mi funcion clave y compruebo que este dentro de los valores

    public static boolean claveValida(int clave) {
        if (clave < 1 || clave > 10) {
            System.out.println("Error: clave invalida");
            return false;
        }
        return true;
    }

    //Crear mi objeto file y comprobar si existe
    public static String file(String archivo) {
        File f = new File("src" + File.separator + "files" + File.separator + archivo);
        if (f.exists()) {
            System.out.println("El archivo si existe");
            return archivo;
        } else {
            System.out.println("El archivo no existe");
        }
        return archivo;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Directorio de trabajo actual: " + System.getProperty("user.dir"));
        //Siempre de primeras, si manejo args, debe ir esta comparacion por que nunca debe ser cero, aqui son 2 por que son 2 parametros
        if (args.length != 2) {
            System.out.println("Faltan parametros");
            return;
        }

        int clave;
        FileReader streamEntrada = null;
        FileWriter streamSalida = null;

        String archivo = args[0];
        System.out.println("El nombre de mi archivo es: " + archivo);
        clave = Integer.parseInt(args[1]);

        if (!claveValida(clave)) {
            // Si la clave NO es válida, se detiene el programa
            return;
        }
        file(archivo);

        try {
            //mi variable streamentrada el buffer la busca entre la carpeta src luego files y lo encuentra
            streamEntrada = new FileReader("src" + File.separator + "files" + File.separator + archivo);
            streamSalida = new FileWriter("src" + File.separator + "files" + File.separator + "private."+archivo);

            int c;
            while ((c = streamEntrada.read()) != -1) {
                streamSalida.write(c + clave);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            // Siempre se debe cerrar el buffer
            if (streamEntrada != null) {
                streamEntrada.close();
            }
            if (streamSalida != null) {
                streamSalida.close();
            }

        }
    }

}