package model;

import java.io.Serializable;

public class Clan implements Serializable {
//	ATTRIBUTES
	private String name;
	private Personage firstPersonage;

//	CONTRUCTOR
	public Clan(String name) {
		this.name = name;
	}

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



//	GETTER AND SETTER

	
//	METHODS
}
