package model;

import java.io.Serializable;

public class Technique implements Serializable ,Comparable<Technique>{
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

	@Override
	public int compareTo(Technique o) {
		int retorno = 0;
		int comparable = name.compareTo(o.getName());
		if(comparable<0) {
			retorno = -1;
		}
		else if(comparable == 0) {
			retorno = 0;
		}
		else {
			retorno = 1;
		}
		return retorno;
	}

	
	
	
	
}
