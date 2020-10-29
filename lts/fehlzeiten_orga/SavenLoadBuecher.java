package fehlzeiten_orga;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



public class SavenLoadBuecher {
	public static void laden(){
		try
        {
            FileInputStream fis = new FileInputStream("BUECHER");
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            GUI.blist = (ArrayList) ois.readObject();
 
            ois.close();
            fis.close();
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
            return;
        } 
        catch (ClassNotFoundException c) 
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
	}

    public static void speichern(){
    	 try
         {
             FileOutputStream fos = new FileOutputStream("BUECHER");
             ObjectOutputStream oos = new ObjectOutputStream(fos);
             oos.writeObject(GUI.blist);
             oos.close();
             fos.close();
         } 
         catch (IOException ioe) 
         {
             ioe.printStackTrace();
         }
    }
}

