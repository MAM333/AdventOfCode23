
import java.io.*;
import java.util.*;

public class Day2_2 {
    

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
                                
                int maxBlue = 1;
                int maxGreen = 1;
                int maxRed = 1;
                  
                //Game id
                for (int i = 0; i < linea.length; ++i) {
                  String[] dados = linea[i].split(", ");

                  dados[0] = dados[0].substring(1);

                  for (int k = 0; k < dados.length; ++k) {
                    String[] numYDado = dados[k].split(" ");

                    int num = Integer.valueOf(numYDado[0]);
                    String dado = numYDado[1];

                    if (dado.equals("red") && maxRed < num) maxRed = num;
                    else if (dado.equals("green") && maxGreen < num) maxGreen = num;
                    else if (dado.equals("blue") && maxBlue < num) maxBlue = num;

                    //System.out.print(dado+".\n");
                    
                    //if (dado.equals("red")) System.out.println("pene");

                    //System.out.println("k = "+k);
                    //System.out.println(numYDado[0]);
                    //System.out.println(numYDado[1]);
                  }
                  //for (int k = 0; k < dados.length; ++k) System.out.println(dados[k]);
                }
                //System.out.println();               

                System.out.println(id + " Blue = "+maxBlue+" Green = "+ maxGreen+ " Red = " +maxRed+"\n");
                suma += maxBlue * maxGreen * maxRed;
                ++id;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return suma;
    }

    public static void main(String[] args) {

        int sumIds = calculaGames("pruebaInput.txt");
        System.out.println("La suma de los Id's es: " + sumIds);
    }
}