package mainPackage;

import java.awt.Frame;


public class Main {

	public static void main(String[] args) {
		
		//Inicio de partida, "local" para guardar todo los datos cambiables
		Create_data_local local= new Create_data_local();
		//
		new Starting_Window(local);
		
	}

}
