package model;

import java.io.Serializable;

import org.junit.jupiter.api.Test;

import exception.ExceptionRegistry;

public class Clan implements Serializable {
//	ATTRIBUTES
	private String name;
	private Personage firstPersonage;
	private Clan nextClan;
	private Clan anteriorClan;

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
	
/**
	 * @return the anteriorClan
	 */
	public Clan getAnteriorClan() {
		return anteriorClan;
	}

	/**
	 * @param anteriorClan the anteriorClan to set
	 */
	public void setAnteriorClan(Clan anteriorClan) {
		this.anteriorClan = anteriorClan;
	}

	//	METHODS
	/**
	 * this method delete a Personage
	 * @param name name the Personage to delete
	 */
	public void deletePersonage(String name) {
		Personage temp1 = firstPersonage;
		Personage next = firstPersonage;
		boolean found = false;
		if(exist(name)== true) {
			while(next != null &&  !found) {
				if(next.getName().compareToIgnoreCase(name)== 0) {
					if(next == temp1) {
						firstPersonage = next.getNext();
						firstPersonage.setAnterior(null);
						found = true;
					}
					else {
						Personage temp = next.getAnterior();
						temp.setNext(next.getNext());
						next.getNext().setAnterior(temp);
						next.setAnterior(null);
						next.setAnterior(null);
						found = true;
					}		
				}
				else {
					next = next.getNext();
				}
			}
		}
		else {
			//exeption
		}
	}

	/**
	 * this method add a Personage 
	 * @param a Personage to add
	 * @throws ExceptionRegistry
	 */
	public void addPersonage(Personage a) throws ExceptionRegistry { 
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
				next.setAnterior(a);
			}
			else {
				throw new ExceptionRegistry(a.getName());
			}
		}
	}
	

	public boolean exist(String name) {
		boolean found = false;
		Personage next = firstPersonage;
		while(next!=null && !found) {
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
	
	/**
	 * this method found the last Personage
	 * @return the last Personage
	 */
	public Personage last() {
		Personage next = firstPersonage;
		Personage retorno = null;
		boolean found = false;
		while(!found) {
			if(next.getNext() == null) {
				retorno = next;
				found = true;
			}
			else {
				next = next.getNext();
			}	
		}
		return retorno;
	}
	
	//TODO
	public void organizePersaonages() {
		for(Personage a = last(); a == firstPersonage; a.getAnterior()) {
			
		}
	}
}
