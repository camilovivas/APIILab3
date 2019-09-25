/**
 * 
 */
package ui;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import exception.ExceptionNoFound;
import exception.ExceptionRegistry;
import model.*;;

/**
 * @author camilo
 *
 */
public class Main {
	private Project relation;
	private Scanner	reader;

	/**
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 * 
	 */
	public Main() throws FileNotFoundException, ClassNotFoundException, IOException {
		reader = new Scanner(System.in);
		relation = new Project();
		int i = menu();
		options(i);
		relation.chargeWorld();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	
	public int menu() {
		int option = 0;
			System.out.println("ingrese la opcion que desea realizar");
			System.out.println("1. registrar un Clan");
			System.out.println("2. registrar un personaje");
			System.out.println("3. registrar una tecnica");
			System.out.println("4. eliminar un clan");
			System.out.println("5. eliminar un personaje");
			System.out.println("6. eliminar una tecnica");
			option =  reader.nextInt();
		return option;
	}
	
	public void options(int i) {
		switch(i) {
		case 1:
			case1();
			break;
		case 2:
			case2();
			break;
		case 3:
			case3();
			break;
		case 4:
			case4();
			break;
		case 5:
			case5();
			break;
		case 6:
			case6();
			break;
		}
	}
	
	public void case1() {
		System.out.println("ingrese el nombre del clan");
		String name = reader.next();
		Clan a = new Clan(name);
		try {
			relation.addClan(a);
			relation.saveAll();
		} catch (ExceptionRegistry | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void case2() {
		System.out.println(relation.printNames());
		System.out.println("ingrese el nombre del clan al que quiere añadir un personaje");
		String a = reader.next();
		try {
			Clan r = relation.found(a);
			System.out.println("ingrese el nombre del personaje");
			String name = reader.next();
			System.out.println("ingrese la personalidad");
			String perso = reader.next();
			System.out.println("ingrese la fecha creacion del personaje"+"\n"+"EJEMPLO: DD/MM/YYYY");
			String b = reader.next();
			try {
				Date date = relation.configDate(b);
				System.out.println("ingerse el poder");
				int power = reader.nextInt();			
				Personage e = new Personage(name, perso, date, power);
				r.addPersonage(e);
				relation.saveAll();
			} catch (ParseException | ExceptionRegistry | IOException e) {
				e.printStackTrace();
			}
		} catch (ExceptionNoFound e) {
			e.printStackTrace();
		}
	}
	
	public void case3() {
		System.out.println("ingrese el nombre del personaje a quien se le va asignar la tecnica");
		String name = reader.next();
		Personage t= relation.foundPersonage(name);
		System.out.println("ingrese el nombre de la tecnica");
		String nameT = reader.next();
		System.out.println("ingrese el factor de la tecnica");
		int num = reader.nextInt();
		Technique a = new Technique(nameT,num);
		try {
			t.addTechnique(a);
		} catch (ExceptionRegistry e) {
			e.printStackTrace();
		}
	}
	
	public void case4() {
		System.out.println(relation.printNames());
		System.out.println("ingrese el nombre del clan que quiere eliminar");
		String name = reader.next();
		try {
			relation.deleteClan(name);
			relation.saveAll();
		} catch (ExceptionNoFound | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void case5() {
		System.out.println(relation.printNames());
		System.out.println("ingrese el nombre del clan en donde esta el personaje");
		String nameC = reader.next();
		try {
			Clan a = relation.found(nameC);
			System.out.println(a.printNames());
			System.out.println("ingrese el nombre del personaje a eliminar");
			String nameP = reader.next();
			a.deletePersonage(nameP);
			relation.saveAll();
		} catch (ExceptionNoFound | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void case6() {
		System.out.println("ingrese el nombre del personaje que le quiere eliminar una tecnica");
		String namep = reader.next();
		Personage a = relation.foundPersonage(namep);
		System.out.println(a.printNames());
		System.out.println("ingrese el nombre de la tecnica a eliminar");
		String namet = reader.next();
		try {
			a.deleteTechnique(namet);
			relation.saveAll();
		} catch (ExceptionNoFound | IOException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
