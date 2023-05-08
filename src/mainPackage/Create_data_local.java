package mainPackage;

import java.util.ArrayList;
import java.util.Arrays;


//clase necesaria, te guardara todo el progreso durante la partida
//Al final de batallas se guardara en bdd
public class Create_data_local {
	private Characters jugador;
	private Characters bot;
	private Weapons jugador_w;
	private Weapons bot_w;
	private Characters_name jugador_c_name;
	private Characters_name bot_c_name;
	
	
	public Characters_name getJugador_c_name() {
		return jugador_c_name;
	}



	public void setJugador_c_name(Characters_name jugador_c_name) {
		this.jugador_c_name = jugador_c_name;
	}



	public Characters_name getBot_c_name() {
		return bot_c_name;
	}



	public void setBot_c_name(Characters_name bot_c_name) {
		this.bot_c_name = bot_c_name;
	}



	public Characters getJugador() {
		return jugador;
	}



	@Override
	public String toString() {
		return "Create_data_local [jugador=" + jugador + ", bot=" + bot + ", jugador_w=" + jugador_w + ", bot_w="
				+ bot_w + ", jugador_c_name=" + jugador_c_name + ", bot_c_name=" + bot_c_name + "]";
	}
	
	public String toString(String qqq) {
		return "Create_data_local [bot=" + bot + ", bot_w="
				+ bot_w + ", bot_c_name=" + bot_c_name + "]";
	}


	public Weapons getJugador_w() {
		return jugador_w;
	}



	public void setJugador_w(Weapons jugador_w) {
		this.jugador_w = jugador_w;
	}



	public Weapons getBot_w() {
		return bot_w;
	}



	public void setBot_w(Weapons bot_w) {
		this.bot_w = bot_w;
	}



	public void setJugador(Characters jugador) {
		this.jugador = jugador;
	}



	public Characters getBot() {
		return bot;
	}



	public void setBot(Characters bot) {
		this.bot = bot;
	}


	

}
//
