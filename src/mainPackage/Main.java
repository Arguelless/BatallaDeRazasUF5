package mainPackage;

import java.awt.Frame;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Main {

	public static void main(String[] args) {
		
		//Inicio de partida, "local" para guardar todo los datos cambiables
		Create_data_local local= new Create_data_local();
		//
		/*
		new Set_bot_character(local) ;
		System.out.println(local.toString());
		*/
		new Starting_Window(local);
		//new Play_window(local);
		

	}

}
