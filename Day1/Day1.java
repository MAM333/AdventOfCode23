
import java.io.*;
import java.util.*;

public class Day1 {

    public static Integer calculaCalibracion(String filePath) {
        int suma = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
               char[] linea = line.toCharArray();
               int num1 = 0, num2 = 0;
               boolean encontrado = false;
               int i = 0;
               while (encontrado == false && i < linea.length) {
                    char car = linea[i];
                    if (car >= '0' && car <= '9') {
                        num1 += car - '0';
                        encontrado = true;
                    }
                    i++;
               }
                i = linea.length - 1;
                encontrado = false;
                while (encontrado == false && i >= 0) {
                    char car = linea[i];
                    if (car >= '0' && car <= '9') {
                        num2 += car - '0';
                        encontrado = true;
                    }
                    i--;
               }

               suma += num1*10 + num2;        
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return suma;
    }

    public static void main(String[] args) {

        int cal = calculaCalibracion("1EjInput.txt");
        System.out.println("La calibracion es: " + cal);
    }
}