/*
 * UsoFileFacil.java
 * @author DAW 1
 */
package p03File;

import java.io.File;

/**
 *
 * @author admin
 */
public class J03UsoFile {
    
    /*
     * @param args
     */
    public static void main(String[] args) {     
            String[] list;
            
            // Windows
            // File path = new File("C:"+File.separator);
            // System.out.println("C:"+File.separator);
            
            // Linux
            File path = new File("/"+File.separator);
             System.out.println("/"+File.separator);
           
            list = path.list();
            for(int i = 0; i < list.length; i++) {
                System.out.println(list[i]);
            }
        }
    
}
