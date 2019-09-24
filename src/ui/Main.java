/**
 * 
 */
package ui;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

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
			System.out.println("5. eliminar una personaje");
			System.out.println("6. eliminar una tecnica");
			option =  reader.nextInt();
		return option;
	}
	
	public void options(int i) {
		switch(i) {
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			
			break;
		case 6:
			
			break;
		}
	}
	
	

}
