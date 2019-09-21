package model;

import java.io.Serializable;

public class Technique implements Serializable{
//	ATTRIBUTES
	private String name;
	private int factor;
	private Technique next;

//CONSTRUCTOR
	public Technique(String name, int factor) {
		this.name = name;
		this.factor = factor;
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
	 * @return the factor
	 */
	public int getFactor() {
		return factor;
	}

	/**
	 * @param factor the factor to set
	 */
	public void setFactor(int factor) {
		this.factor = factor;
	}

	/**
	 * @return the next
	 */
	public Technique getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Technique next) {
		this.next = next;
	}

	
	
	
	
}
