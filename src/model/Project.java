package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Project {
//	ATTRIBUTES 
	
	private Clan firstClan;
	
	public Project() {
		
	}

//	GETTERS AND SETTERS
	/**
	 * @return the firstClan
	 */
	public Clan getFirstClan() {
		return firstClan;
	}
	
	/**
	 * @param firstClan the firstClan to set
	 */
	public void setFirstClan(Clan firstClan) {
		this.firstClan = firstClan;
	}

	
//	METHODS
	
	public void saveAll() throws FileNotFoundException, IOException {
		File archile = new File("./files/WorldSerializado.arc");
		ObjectOutputStream a = new ObjectOutputStream(new FileOutputStream(archile));
		a.writeObject(firstClan);
		a.close();
	}
	

	public void chargeWorld() throws FileNotFoundException, IOException, ClassNotFoundException {
		File archive = new File("./files/WorldSerializado.arc");
		ObjectInputStream a = new ObjectInputStream(new FileInputStream(archive));
		firstClan = (Clan) a.readObject();
		a.close();
	}
	
	public void addClan() {
		
	}
	
	public void deleteClan(String name) {
		
	}
	
	/**
	 * this method convert String to Date
	 * @param date String to convert
	 * @return String converted
	 * @throws ParseException
	 */
	public Date configDate(String date) throws ParseException {
		SimpleDateFormat a = new SimpleDateFormat("dd/mm/yyyy");
		Date b = a.parse(date);
		return b;
	}

}
