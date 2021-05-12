package serializationanddesirialization;

import java.io.Serializable;

public class NFSGame implements Serializable{

	String name;
	int level;
	int ammo;
	public NFSGame(String name, int level, int ammo) {
		super();
		this.name = name;
		this.level = level;
		this.ammo = ammo;
	}
	
	
}
