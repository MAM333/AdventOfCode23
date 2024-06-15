
import java.io.*;
import java.util.*;

public class PruebaSplit {
    
  private static boolean miraSiUno(int i, char[] l) {

    if (l[i+1] == 'n' && l[i+2] == 'e') return true;
    return false;
  }
  private static boolean miraSiDos(int i, char[] l) {
    if (l[i+1] == 'w' && l[i+2] == 'o') return true;
    return false;
  }
  private static boolean miraSiTres(int i, char[] l) {
    if (l[i+1] == 'h' && l[i+2] == 'r' && l[i+3] == 'e' && l[i+4] == 'e') 
      return true;
    return false;
  }
  private static boolean miraSiCuatro(int i, char[] l) {
    if (l[i+1] == 'o' && l[i+2] == 'u' && l[i+3] == 'r') return true;
    return false;
  }
  private static boolean miraSiCinco(int i, char[] l) {
    if (l[i+1] == 'i' && l[i+2] == 'v' && l[i+3] == 'e') return true;
    return false;
  }
  private static boolean miraSiSeis(int i, char[] l) {
    if (l[i+1] == 'i' && l[i+2] == 'x') return true;
    return false;
  }
  private static boolean miraSiSiete(int i, char[] l) {
    if (l[i+1] == 'e' && l[i+2] == 'v' && l[i+3] == 'e' && l[i+4] == 'n') return true;
    return false;
  }
  private static boolean miraSiOcho(int i, char[] l) {
    if (l[i+1] == 'i' && l[i+2] == 'g' && l[i+3] == 'h' && l[i+4] == 't') return true;
    return false;
  }
  private static boolean miraSiNueve(int i, char[] l) {
    if (l[i+1] == 'i' && l[i+2] == 'n' && l[i+3] == 'e') return true;
    return false;
  }

    public static Integer calculaCalibracion(String filePath) {
        int suma = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
               char[] linea = line.toCharArray();

               int num1 = 0, num2 = 0;
               boolean encontrado = false;
               int i = 0;
               System.out.print("El "+ i + "es: ");
               while (encontrado == false && i < linea.length) {
                    char car = linea[i];
                    if (car == 'o' && i < linea.length - 2 && miraSiUno(i, linea))
                      {num1 += 1; encontrado = true;} 
                    else if (car == 't' && i < linea.length - 2 && miraSiDos(i, linea))
                      {num1 += 2; encontrado = true;}
                    else if (car == 't' && i < linea.length - 4 && miraSiTres(i, linea))
                      {num1 += 3; encontrado = true;}
                    else if (car == 'f' && i < linea.length - 3 && miraSiCuatro(i, linea))
                      {num1 += 4; encontrado = true;}
                    else if (car == 'f' && i < linea.length - 3 && miraSiCinco(i, linea))
                      {num1 += 5; encontrado = true;}
                    else if (car == 's' && i < linea.length - 2 && miraSiSeis(i, linea))
                      {num1 += 6; encontrado = true;}
                    else if (car == 's' && i < linea.length - 4 && miraSiSiete(i, linea))
                      {num1 += 7; encontrado = true;}
                    else if (car == 'e' && i < linea.length - 4 && miraSiOcho(i, linea))
                      {num1 += 8; encontrado = true;}
                    else if (car == 'n' && i < linea.length - 3 && miraSiNueve(i, linea))
                      {num1 += 9; encontrado = true;}
                    else if (car >= '0' && car <= '9') {
                        num1 += car - '0';
                        encontrado = true;
                    }
                    i++;
               }
                i = linea.length - 1;
                encontrado = false;
                while (encontrado == false && i >= 0) {
                    char car = linea[i];
                    if (car == 'o' && i < linea.length - 2 && miraSiUno(i, linea))
                      {num2 += 1; encontrado = true;} 
                    else if (car == 't' && i < linea.length - 2 && miraSiDos(i, linea))
                      {num2 += 2; encontrado = true;}
                    else if (car == 't' && i < linea.length - 4 && miraSiTres(i, linea))
                      {num2 += 3; encontrado = true;}
                    else if (car == 'f' && i < linea.length - 3 && miraSiCuatro(i, linea))
                      {num2 += 4; encontrado = true;}
                    else if (car == 'f' && i < linea.length - 3 && miraSiCinco(i, linea))
                      {num2 += 5; encontrado = true;}
                    else if (car == 's' && i < linea.length - 2 && miraSiSeis(i, linea))
                      {num2 += 6; encontrado = true;}
                    else if (car == 's' && i < linea.length - 4 && miraSiSiete(i, linea))
                      {num2 += 7; encontrado = true;}
                    else if (car == 'e' && i < linea.length - 4 && miraSiOcho(i, linea))
                      {num2 += 8; encontrado = true;}
                    else if (car == 'n' && i < linea.length - 3 && miraSiNueve(i, linea))
                      {num2 += 9; encontrado = true;}
                    else if (car >= '0' && car <= '9') {
                        num2 += car - '0';
                        encontrado = true;
                    }
                    i--;
               }

               suma += num1*10 + num2;    
               System.out.println(num1*10 + num2);    
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return suma;
    }

    public static void main(String[] args) {

        int cal = calculaCalibracion("pruebaSplit.txt");
        System.out.println("La calibracion es: " + cal);
    }
}