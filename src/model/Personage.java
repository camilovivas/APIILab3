package model;

import java.io.Serializable;
import java.util.Date;

public class Personage implements Serializable {
	
//	ATTRIBUTES
	private String name;
	private String personality;
	private Date date;
	private double power; 
	private Personage next;
	private Personage anterior;
	private Technique FirstTechnique;
	
//	CONSTRUCTOR
	public Personage(String name, String personality, Date date, double power) {
		this.name = name;
		this.personality = personality;
		this.date = date;
		this.power = power;
	}
	
//	GETTER AND SETTERS

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
	 * @return the personality
	 */
	public String getPersonality() {
		return personality;
	}

	/**
	 * @param personality the personality to set
	 */
	public void setPersonality(String personality) {
		this.personality = personality;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the power
	 */
	public double getPower() {
		return power;
	}

	/**
	 * @param power the power to set
	 */
	public void setPower(double power) {
		this.power = power;
	}

	/**
	 * @return the next
	 */
	public Personage getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Personage next) {
		this.next = next;
	}

	/**
	 * @return the anterior
	 */
	public Personage getAnterior() {
		return anterior;
	}

	/**
	 * @param anterior the anterior to set
	 */
	public void setAnterior(Personage anterior) {
		this.anterior = anterior;
	}

	/**
	 * @return the firstTechnique
	 */
	public Technique getFirstTechnique() {
		return FirstTechnique;
	}

	/**
	 * @param firstTechnique the firstTechnique to set
	 */
	public void setFirstTechnique(Technique firstTechnique) {
		FirstTechnique = firstTechnique;
	}

	
//	METHODS
	
	public void addTechnique(Technique a) {
		
	}
	
	
	public void organizeTechniqueWayUpward() {
		
	}
	
	
}
