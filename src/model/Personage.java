package model;

import java.io.Serializable;
import java.util.Date;

import org.junit.jupiter.api.Test;

import exception.ExceptionRegistry;
import sun.text.normalizer.CharTrie.FriendAgent;

public class Personage implements Serializable {
	
//	ATTRIBUTES
	private String name;
	private String personality;
	private Date date;
	private int power; 
	private Personage next;
	private Personage anterior;
	private Technique FirstTechnique;
	
//	CONSTRUCTOR
	public Personage(String name, String personality, Date date, int power) {
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
	public int getPower() {
		return power;
	}

	/**
	 * @param power the power to set
	 */
	public void setPower(int power) {
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
	/**
	 * this method delete a technique
	 * @param name by Technique to delete
	 */
	public void deleteTechnique(String name) {
		Technique next = FirstTechnique;
		boolean found = false;
		while(next != null && !found) {
			if(next.getName().compareToIgnoreCase(name) == 0) {
				Technique temp = last(next);
				temp.setNext(next.getNext());
				next.setNext(null);
				found = true;
			}
			else {
				next = next.getNext();
			}
		}
	}
	
	/**
	 * this method add a Technique 
	 * @param a
	 * @throws ExceptionRegistry
	 */
	public void addTechnique(Technique a) throws ExceptionRegistry {
		Technique next = FirstTechnique;
		if(next == null) {
			FirstTechnique = a;
			a.setNext(null);
			power(a.getFactor());
		}
		else {
			if(exist(a.getName()) == false) {
				FirstTechnique = a;
				a.setNext(next);
				power(a.getFactor());
			}
			else {
				throw new ExceptionRegistry(a.getName());
			}
		}
	}
	
	/**
	 * this method update the power
	 * @param a factor by Technique
	 */
	public void power(int a) {
		int r = power*a;
		setPower(r);
	}
	
	/**
	 * this method check if a Technique exist
	 * @param name
	 * @return
	 */
	public boolean exist(String name) {
		Technique next = FirstTechnique;
		boolean found = false;
		while(next != null && !found) {
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
		Technique next = FirstTechnique;
		String names = "";
		while(next != null) {
			names += next.getName()+" ";
			next = next.getNext();
		}
		return names;
	}
	//TODO
	public void organizeTechniqueWayUpward() {
		Technique temp = FirstTechnique;
		Technique next =  FirstTechnique;
		Technique anterior = FirstTechnique;
		boolean yes = false;
		while(next != null) {
			yes = false;
			next = next.getNext();
			anterior = last(next);			
			while(!yes && next!= null) {// empieza desde 0 hasta que llega al anterior de next
				if(anterior.getFactor()>next.getFactor()) {
					temp= last(anterior);
					anterior.setNext(next.getNext());
					next.setNext(anterior);
					temp.setNext(next);
				}
				anterior = last(anterior);
				if(anterior == FirstTechnique) {
					yes = true;
					anterior = anterior.getNext();
				}
			}
		}
	}
		
			
		/**
		 * this method found the last Technique by another Technique 
		 * @param a Technique next
		 * @return Technique last by Technique next
		 */
		public Technique last(Technique a){
			Technique b = FirstTechnique;
			Technique retorno = null;
			boolean found = false;
			if(a == b) {
				retorno = b;
			}
			while(b!=null && !found) {
				if(b.getNext() == a) {
					found = true;
					retorno = b;
				}
				else {
					b = b.getNext();
				}
			}
			return retorno;
		}
	
	}
	
	
	

