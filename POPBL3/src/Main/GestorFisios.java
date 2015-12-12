package Main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.DefaultListModel;

public class GestorFisios extends DefaultListModel<Fisio>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nombreFichero;
	public GestorFisios(String fichero) {		
		super();
		nombreFichero = fichero;
		cargarFisios(0,20);
	}
	public void guardarFisio(){
		PrintWriter fichero = null;
		Fisio objeto;
		try {
			fichero = new PrintWriter(new FileWriter("criaturas.txt"));
			for (int i = 0; i < this.size(); i++) {
				
				objeto = this.get(i);
				fichero.println(objeto.guardar());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fichero.close();
		}
	}
	public void cargarFisios(int i, int j) {
		
		int contador=1;
		BufferedReader fichero = null;
		String strArtefacto;
		String[] componentesFisio;
		Fisio agregar;
		this.removeAllElements();
		try {
			fichero = new BufferedReader(new FileReader("Fisios.txt"));
			
			while ((strArtefacto = fichero.readLine()) != null) {
				if(i>contador)
					contador++;
				else if(j>=contador){
					
				
					componentesFisio = strArtefacto.split("[$]");
				
					agregar = new Fisio(componentesFisio[0],
							componentesFisio[1],
							componentesFisio[2],
							componentesFisio[3],
							componentesFisio[4]);
	
					this.addElement(agregar);
				
				contador++;
				}
				else
					break;
			}
		} catch (FileNotFoundException e) {
			System.out.println(">Se cargara la config. inicial");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fichero.close();
			} catch (Exception e) {
			}
		}
		
	}

}
