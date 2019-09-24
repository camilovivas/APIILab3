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

import exception.ExceptionRegistry;

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
		File archile = new File("./file/WorldSerializado.arc");
		ObjectOutputStream a = new ObjectOutputStream(new FileOutputStream(archile));
		a.writeObject(firstClan);
		a.close();
	}
	

	public void chargeWorld() throws FileNotFoundException, IOException, ClassNotFoundException {
		File archive = new File("./file/WorldSerializado.arc");
		ObjectInputStream a = new ObjectInputStream(new FileInputStream(archive));
		firstClan = (Clan) a.readObject();
		a.close();
	}
	
	public void addClan(Clan a) throws ExceptionRegistry {
		Clan next = firstClan;
		if(next == null){
			firstClan = a;
			a.setAnteriorClan(null);
			a.setNextClan(null);
		}
		else {
			if(exist(a.getName()) == false) {
				firstClan = a;
				a.setNextClan(next);
				next.setAnteriorClan(a);
			}
			else {
				throw new ExceptionRegistry(a.getName());
			}
		}
	}
	
	public void deleteClan(String name) {
		
	}
	
	public boolean exist(String name) {
		boolean found = false;
		
		
		return found;
	}
	
	public String printNames() {
		Clan next = firstClan;
		String names ="";
		while(next != null) {
			names += next.getName();
			next = next.getNextClan();
		}
		return names;
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
