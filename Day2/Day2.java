
import java.io.*;
import java.util.*;

public class Day2 {
    

    public static Integer calculaGames(String filePath) {
        int suma = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int id = 1;
            while ((line = reader.readLine()) != null) {
               String[] linea = line.split(";");
               if (id < 9) linea[0] = linea[0].substring(7);
               else if (id < 100) linea[0] = linea[0].substring(8);
                else linea[0] = linea[0].substring(9);
                
                boolean esValido = true;
                
                //Game id
                for (int i = 0; i < linea.length; ++i) {
                  String[] dados = linea[i].split(", ");

                  dados[0] = dados[0].substring(1);
                  
                  for (int k = 0; k < dados.length; ++k) {
                    String[] numYDado = dados[k].split(" ");

                    int num = Integer.valueOf(numYDado[0]);
                    String dado = numYDado[1];

                    //System.out.print(dado+".\n");

                    //if (dado.equals("red")) System.out.println("pene");

                    if (dado.equals("red") && num > 12) esValido = false;
                    else if (dado.equals("green") && num > 13) esValido = false;
                    else if (dado.equals("blue") && num > 14) esValido = false;

                    //System.out.println("k = "+k);
                    //System.out.println(numYDado[0]);
                    //System.out.println(numYDado[1]);
                  }
                  //for (int k = 0; k < dados.length; ++k) System.out.println(dados[k]);
                }
                //System.out.println();               

                if (esValido) suma += id;
               ++id;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return suma;
    }

    public static void main(String[] args) {

        int sumIds = calculaGames("input.txt");
        System.out.println("La suma de los Id's es: " + sumIds);
    }
}