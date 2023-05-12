package mainPackage;

public class Traslate_class {
	private Player userPlayer;
	private Weapon userWeapon;
	private Create_data_local local;
	public Traslate_class(Create_data_local local) {
		this.local=local;

		userPlayer = new Player(local.getIdWarriorHuman());
		userPlayer.setWeapon(local.getJugador_w().getWeapon());
	}
	public Player getUserPlayer() {
		return userPlayer;
	}
	public void setUserPlayer(Player userPlayer) {
		this.userPlayer = userPlayer;
	}
	public Weapon getUserWeapon() {
		return userWeapon;
	}
	public void setUserWeapon(Weapon userWeapon) {
		this.userWeapon = userWeapon;
	}
}
