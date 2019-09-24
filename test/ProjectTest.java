import static org.junit.jupiter.api.Assertions.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import exception.ExceptionNoFound;
import exception.ExceptionRegistry;
import model.Clan;
import model.Personage;
import model.*;

class ProjectTest {

//	@Test
	public void saveAllTest() throws ExceptionRegistry, FileNotFoundException, IOException {
		Project p = new Project();
		Clan a = new Clan("power");
		p.addClan(a);
		Personage b = new Personage("naruto", "poderoso", null, 20);
		Personage c = new Personage("camilo", "poderoso", null, 20);
		Personage d = new Personage("vivas", "poderoso", null, 20);
		a.addPersonage(b);
		a.addPersonage(c);
		a.addPersonage(d);
		p.saveAll();
	}
	
//	@Test
	public void chargeWorldTest() throws FileNotFoundException, ClassNotFoundException, IOException {
		Project p = new Project();
		p.chargeWorld();
		String actual = p.printNames();
		assertEquals("power ", actual);
	}
	
	//LOS DOS METODOS QUE LES COMENTE EL @TEST ES POR QUE CADA VEZ QUE EJECUTABA EL JUNIT
	//PARA HACERLE PRUEBA A OTROS METODOS ME CAMBIABA EL ARCHIVO SERIALIZADO QUE CREEABA DESDE EL MAIN
	
	@Test
	public void deleteClanTest() throws ExceptionRegistry, ExceptionNoFound {
		Project p = new Project();
		Clan a = new Clan("power");
		Clan b = new Clan("ranger");
		Clan c = new Clan("galaxy");
		p.addClan(a);
		p.addClan(b);
		p.addClan(c);
		p.deleteClan("ranger");
		String actual = p.printNames();
		assertEquals("galaxy power ", actual);	
	}
	
	@Test
	public void addClanTest() throws ExceptionRegistry {
		Project p = new Project();
		Clan a = new Clan("power");
		Clan b = new Clan("ranger");
		Clan c = new Clan("galaxy");
		p.addClan(a);
		p.addClan(b);
		p.addClan(c);
		String actual = p.printNames();
		assertEquals("galaxy ranger power ", actual);
	}
	
	@Test
	public void existTest() throws ExceptionRegistry {
		Project p = new Project();
		Clan a = new Clan("power");
		Clan b = new Clan("ranger");
		Clan c = new Clan("galaxy");
		p.addClan(a);
		p.addClan(b);
		p.addClan(c);
		boolean actual = p.exist("ranger");
		assertTrue(actual);
	}

}
