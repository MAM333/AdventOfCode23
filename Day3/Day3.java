import java.io.*;
import java.util.*;

public class Day3 {

	private static boolean esSimbolo(char a) {

		System.out.println(a);
		if (a >= '0' && a <= '9') return false;
		if (a == '.') return false;
		return true;
	}

	private static int calculaNumero(int i, int j, char[][] m, boolean encontrado, int fil, int col) {

		boolean fin = false;
		int num = m[i][j] - '0';
		++j;
		while (fin == false && j < col) {

			int numAct = -1;
			if (m[i][j] >= '0' && m[i][j] <= '9') {
				numAct = m[i][j] -'0'; 

				if (encontrado == false && i > 0 && esSimbolo(m[i-1][j])) encontrado = true;
				else if (encontrado == false && i < fil - 1 && esSimbolo(m[i+1][j])) encontrado = true;

				num = num*10 + numAct;
				//System.out.println(num);
			}
			else fin = true;
			++j;
		}

		if (encontrado == false && j < col) {
			if (i > 0 && esSimbolo(m[i-1][j])) encontrado = true;
			else if (i < fil - 1 && esSimbolo(m[i+1][j])) encontrado = true;
			else if (esSimbolo(m[i][j])) encontrado = true;
		}

		if (encontrado == false) num = 0;
		//System.out.println(num);
		return num;
	}

	public static Integer juego(String filePath) {

		int suma = 0;
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;

			Vector< char[] > mat = new Vector<>();
			while ((line = reader.readLine()) != null) {
				char[] linea = line.toCharArray();
				mat.add(linea);	
			}
			
			int fil = mat.size(), col = mat.elementAt(0).length;
			char[][] matriz = new char[fil][col];

			for (int i = 0; i < fil; ++i) {
				char[] linea = mat.elementAt(i);
				for (int j = 0; j < col; ++j) matriz[i][j] = linea[j];
			}

			for (int i = 0; i < fil; ++i) {

				char[] actual = matriz[i];
				boolean estoyEnNumero = false;
				for (int j = 0; j < col; ++j) {

					//System.out.println(matriz[i][j]);
					char letra = actual[j];
					if (estoyEnNumero == false && letra > '0' && letra <= '9') {
						//System.out.println(letra);
						estoyEnNumero = true;
						boolean encontrado = false;
						if (j > 0) 
						{
							
							if (esSimbolo(actual[j-1])) encontrado = true;
							else if (i > 0 && esSimbolo(matriz[i-1][j-1])) encontrado = true;
							else if (i < fil - 1 && esSimbolo(matriz[i+1][j-1])) encontrado = true; 
						}
						else if (encontrado == false && i > 0 && esSimbolo(matriz[i-1][j])) encontrado = true;
						else if (encontrado == false && i < fil - 1 && esSimbolo(matriz[i+1][j])) encontrado = true;
						
						suma += calculaNumero(i, j, matriz, encontrado, fil, col);
					}
					else if (esSimbolo(letra) || letra == '.') estoyEnNumero = false;
				}
			}
		} 
		catch (IOException e) {
            e.printStackTrace();
        }

		return suma;
	}

	public static void main(String[] args) {
		System.out.println("El resutado es: "+juego("inputP.txt"));
	}
}