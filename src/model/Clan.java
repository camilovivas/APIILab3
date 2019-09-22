package model;

import java.io.Serializable;
import exception.*;

public class Clan implements Serializable {
//	ATTRIBUTES
	private String name;
	private Personage firstPersonage;
	private Clan nextClan;

//	CONTRUCTOR
	public Clan(String name) {
		this.name = name;
	}

//	GETTER AND SETTER
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the firstPersonage
	 */
	public Personage getFirstPersonage() {
		return firstPersonage;
	}

	/**
	 * @param firstPersonage the firstPersonage to set
	 */
	public void setFirstPersonage(Personage firstPersonage) {
		this.firstPersonage = firstPersonage;
	}
	
	/**
	 * @return the nextClan
	 */
	public Clan getNextClan() {
		return nextClan;
	}
	
	/**
	 * @param nextClan the nextClan to set
	 */
	public void setNextClan(Clan nextClan) {
		this.nextClan = nextClan;
	}
	
//	METHODS
	

	public void addPersonage(Personage a)throws ExceptionRegistry {
		Personage next = firstPersonage;
		if(next ==null) {
			firstPersonage = a;
			a.setAnterior(null);
			a.setNext(null);
		}
		else {
			if(exist(a.getName()) == false) {
				firstPersonage = a;
				a.setNext(next);
				a.setAnterior(null);
			}
			else {
				throw new ExceptionRegistry(a.getName());
			}
		}
	}
	

	public boolean exist(String name) {
		boolean found = false;
		Personage next = firstPersonage;
		while(next!=null) {
			if(next.getName().equals(name)) {
				found = true;
			}
			else {
				next = next.getNext();
			}
		}
		return found;
	}
	
	public String printNames() {
		String names = "";
		Personage next = firstPersonage;
		while(next!= null) {
			names += next.getName()+" ";
			next = next.getNext();
		}
		
		return names;
	}
}
