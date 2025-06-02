/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Alumno
 */
public class hazCuentas {

    public static void main(String[] args) throws IOException {

        BufferedReader streamEntrada1 = null;
        BufferedReader streamEntrada2 = null;
        BufferedReader streamEntrada3 = null;
        BufferedWriter streamSalidaCalculo = null;

        try {
            streamEntrada1 = new BufferedReader(new FileReader("src" + File.separator + "Ej01" + File.separator + "entrada1.txt"));
            streamEntrada2 = new BufferedReader(new FileReader("src" + File.separator + "Ej01" + File.separator + "entrada2.txt"));
            streamEntrada3 = new BufferedReader(new FileReader("src" + File.separator + "Ej01" + File.separator + "operandos.txt"));
            streamSalidaCalculo = new BufferedWriter(new FileWriter("src" + File.separator + "Ej01" + File.separator + "resultado.txt"));

            String c1;
            String c2;
            String c3;

            while ((c1 = streamEntrada1.readLine()) != null && (c2 = streamEntrada2.readLine()) != null && (c3 = streamEntrada3.readLine()) != null) {
                int resultado = 0;
                char calculo = c3.charAt(0);
                int num1 = Integer.parseInt(c1);
                int num2 = Integer.parseInt(c2);

                switch (calculo) {

                    case '+':
                        resultado = num1 + num2;
                        break;
                    case '-':
                        resultado = num1 - num2;
                        break;
                    case '/':
                        if (num2 != 0) {
                            resultado = num1 / num2;
                        }
                        break;
                    case '*':
                        resultado = num1 * num2;

                }

                streamSalidaCalculo.write(String.valueOf(resultado));
                streamSalidaCalculo.newLine();

            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if ((streamEntrada1 != null) && (streamEntrada2 != null) && (streamEntrada3 != null)) {
                streamEntrada1.close();
                streamEntrada2.close();
                streamEntrada3.close();

            }
            if (streamSalidaCalculo != null) {
                streamSalidaCalculo.close();
            }
        }
    }
}
