package serializationanddesirialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DesirealizeNFSGame {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis=new FileInputStream("./nfs.ser");
		ObjectInputStream os=new ObjectInputStream(fis);
		NFSGame obj = (NFSGame)os.readObject();
		System.out.println(obj.name);
		System.out.println(obj.level);
		System.out.println(obj.ammo);
		os.close();
	}
}
