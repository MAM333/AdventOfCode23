import java.io.*;
import java.util.*;

public class Plantilla {

	public static Integer juego(String filePath) {

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {

			}
		}
		catch (IOException e) {
            e.printStackTrace();
        }

		return 1;
	}

	public static void main(String[] args) {
		System.out.println("El resutado es: "+juego("input.txt"));
	}
}