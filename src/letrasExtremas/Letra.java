package letrasExtremas;

import java.util.ArrayList;

public class Letra {
	private int cantidad;
	private ArrayList<String> palabras;

	public Letra(String palabra) {
		super();
		this.cantidad = 1;
		palabras = new ArrayList<String>();
		this.palabras.add(palabra);
	}

	public void agregarPalabra(String palabra)
	{
		this.palabras.add(palabra);		
	}
	
	public void incrementar()
	{
		cantidad++;
	}
	
	public ArrayList<String> getPalabras(){
		return this.palabras;
	}
	
	public int getCantidad()
	{
		return this.cantidad;
	}

}
