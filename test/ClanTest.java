import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exception.ExceptionRegistry;
import model.*;

class ClanTest {

	
	public void exist() throws ExceptionRegistry {
		Clan a = new Clan("power");
		Personage b = new Personage("naruto", "poderoso", null, 2.0);
		Personage c = new Personage("camilo", "poderoso", null, 2.0);
		a.addPersonage(b);
		a.addPersonage(c);
		boolean resultado = a.exist("naruto");
		assertEquals(true, resultado);
	}
	
	@Test
	public void addPersonage() throws ExceptionRegistry {
		Clan a = new Clan("power");
		Personage b = new Personage("naruto", "poderoso", null, 2.0);
		Personage c = new Personage("camilo", "poderoso", null, 2.0);
		a.addPersonage(b);
		a.addPersonage(c);
		String resultado = a.printNames();
		assertEquals("camilo naruto ", resultado);
		
	}
	
	

}
