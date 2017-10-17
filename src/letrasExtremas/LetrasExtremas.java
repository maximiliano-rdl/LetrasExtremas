package letrasExtremas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LetrasExtremas {

	private static Scanner sc;
	private static PrintWriter escribir;
	
	public static void main(String[] args) {
		File lectura = new File("EXTREMAS.IN");
		try {
			sc = new Scanner(lectura);
		} catch (FileNotFoundException e) {
			System.out.println("No pudo abrirse el archivio");
			e.printStackTrace();
		}

		int cantidad = sc.nextInt();
		sc.nextLine();
		Map<Character, Letra> listado = new HashMap<Character, Letra>();
		Character caracter = null, anterior;
		String palabra;

		for (int i = 0; i < cantidad; i++) {
			palabra = new String(sc.nextLine());
			caracter = new Character(palabra.charAt(0));
			anterior = caracter;

			insertarLista(caracter, palabra, listado);

			caracter = new Character(palabra.charAt(palabra.length() - 1));

			if (caracter.equals(anterior)) {
				listado.get(caracter).incrementar();
			} else {
				insertarLista(caracter, palabra, listado);
			}
		}
		sc.close();

		Character maximo = new Character(caracter);

		for (Map.Entry<Character, Letra> entry : listado.entrySet()) {
			Character key = entry.getKey();
			Letra value = entry.getValue();

			if (value.getCantidad() >= listado.get(maximo).getCantidad())
				maximo = key;
		}

		try {
			escribir = new PrintWriter(new FileWriter("EXTREMAS.OUT"));
		} catch (IOException e) {
			System.out.println("No se pudo crear el achivo");
			e.printStackTrace();
		}
		
		escribir.println(maximo);
		
		for (String p : listado.get(maximo).getPalabras()) {
			escribir.println(p);
		}
		escribir.close();
	}

	private static void insertarLista(Character caracter, String palabra, Map<Character, Letra> listado) {
		if (listado.containsKey(caracter)) {
			listado.get(caracter).incrementar();
			listado.get(caracter).agregarPalabra(palabra);
		} else {
			listado.put(caracter, new Letra(palabra));
		}
	}

}
