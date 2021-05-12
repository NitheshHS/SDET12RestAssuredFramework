package serializationanddesirialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializeNSFGame {
	
	public static void main(String[] args) throws Throwable {
		NFSGame nfs = new NFSGame("Nithesh", 12, 3);
		
		
		FileOutputStream fos=new FileOutputStream("./nfs.ser");
		ObjectOutputStream os=new ObjectOutputStream(fos);
		os.writeObject(nfs);
		os.close();
		System.out.println("sucess");
	}

}
