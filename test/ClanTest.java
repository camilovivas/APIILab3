import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exception.ExceptionNoFound;
import exception.ExceptionRegistry;
import model.*;

class ClanTest {

	@Test
	public void existTest() throws ExceptionRegistry  {
		Clan a = new Clan("power");
		Personage b = new Personage("naruto", "poderoso", null, 20);
		Personage c = new Personage("camilo", "poderoso", null, 20);
		a.addPersonage(b);
		a.addPersonage(c);
		boolean resultado = a.exist("naruto");
		assertTrue( resultado) ;
	}
	
	@Test
	public void addPersonageTest() throws ExceptionRegistry {
		Clan a = new Clan("power");
		Personage b = new Personage("naruto", "poderoso", null, 20);
		Personage c = new Personage("camilo", "poderoso", null, 20);
		a.addPersonage(b);
		a.addPersonage(c);
		String resultado = a.printNames();
		assertEquals("camilo naruto ", resultado);
		
	}
	
	@Test
	public void lastTest() throws ExceptionRegistry {
		Clan a = new Clan("power");
		Personage b = new Personage("naruto", "poderoso", null, 20);
		Personage c = new Personage("camilo", "poderoso", null, 20);
		a.addPersonage(b);
		a.addPersonage(c);
		Personage result = a.last();
		assertEquals("naruto", result.getName());
	}
	
	@Test
	public void deletePersonageTest() throws ExceptionRegistry, ExceptionNoFound {
		Clan a = new Clan("power");
		Personage b = new Personage("naruto", "poderoso", null, 20);
		Personage c = new Personage("camilo", "poderoso", null, 20);
		Personage d = new Personage("vivas", "poderoso", null, 20);
		a.addPersonage(b);
		a.addPersonage(c);
		a.addPersonage(d);
		a.deletePersonage("vivas");
		String actual = a.printNames();
		assertEquals("camilo naruto ", actual);
	}
	
	@Test
	public void deletePersonageTest2() throws ExceptionRegistry, ExceptionNoFound {
		Clan a = new Clan("power");
		Personage b = new Personage("naruto", "poderoso", null, 20);
		Personage c = new Personage("camilo", "poderoso", null, 20);
		Personage d = new Personage("vivas", "poderoso", null, 20);
		a.addPersonage(b);
		a.addPersonage(c);
		a.addPersonage(d);
		a.deletePersonage("camilo");
		String actual = a.printNames();
		assertEquals("vivas naruto ", actual);
	}
	
	
	
	

}
