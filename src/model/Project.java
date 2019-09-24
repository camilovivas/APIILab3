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

import exception.ExceptionNoFound;
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
	
	/**
	 * this method save all world in archive Serializable
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void saveAll() throws FileNotFoundException, IOException {
		File archile = new File("./file/WorldSerializado.arc");
		ObjectOutputStream a = new ObjectOutputStream(new FileOutputStream(archile));
		a.writeObject(firstClan);
		a.close();
	}
	

	/**
	 * this method read the archive Serializado 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void chargeWorld() throws FileNotFoundException, IOException, ClassNotFoundException {
		File archive = new File("./file/WorldSerializado.arc");
		ObjectInputStream a = new ObjectInputStream(new FileInputStream(archive));
		firstClan = (Clan) a.readObject();
		a.close();
	}
	
	/**
	 * this method add a Clan
	 * @param a Clan to add
	 * @throws ExceptionRegistry
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void addClan(Clan a) throws ExceptionRegistry{
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
	
	/**
	 * this method delete a Clan
	 * @param name name by Clan to delete
	 * @throws ExceptionNoFound
	 */
	public void deleteClan(String name) throws ExceptionNoFound {
		Clan next = firstClan;
		Clan temp1 = firstClan;
		boolean found = false;
		if(exist(name)== true) {
			while(next != null && !found) {
				if(next.getName().compareToIgnoreCase(name) == 0) {
					if(next == temp1) {
						firstClan = next.getNextClan();
						firstClan.setAnteriorClan(null);
						found = true;
					}
					else {
						Clan temp = next.getAnteriorClan();
						temp.setNextClan(next.getNextClan());
						next.getNextClan().setAnteriorClan(temp);
						next.setAnteriorClan(null);
						next.setNextClan(null);
						found = true;
					}
				}
				else {
					next = next.getNextClan();
				}
			}
		}
		else {
			throw new ExceptionNoFound(name);
		}
		
	}
	
	/**
	 * this method found if a clan exist
	 * @param name name by clan to search
	 * @return true if found 
	 */
	public boolean exist(String name) {
		boolean found = false;
		Clan next = firstClan;
		while(next != null && !found) {
			if(next.getName().equals(name)) {
				found = true;
			}
			else {
				next = next.getNextClan();
			}
		}
		return found;
	}
	
//	TODO
	public Clan found(String name) {
		
		return null;
	}
	
	public String printNames() {
		Clan next = firstClan;
		String names ="";
		while(next != null) {
			names += next.getName()+" "+"\n";
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
