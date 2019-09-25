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
		assertEquals("power "+"\n", actual);
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
		assertEquals("galaxy "+"\n"+"power "+"\n", actual);	
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
		assertEquals("galaxy "+"\n"+"ranger "+"\n"+"power "+"\n", actual);
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
	
	@Test
	public void foundPersonageTest() throws ExceptionRegistry {
		Project p = new Project();
		Clan a = new Clan("power");
		Personage b = new Personage("naruto", "poderoso", null, 20);
		Personage c = new Personage("camilo", "poderoso", null, 20);
		Personage d = new Personage("vivas", "poderoso", null, 20);
		a.addPersonage(b);
		a.addPersonage(c);
		a.addPersonage(d);
		p.addClan(a);
		Clan a1 = new Clan("ranger");
		Personage b1 = new Personage("naruto1", "poderoso", null, 20);
		Personage c1 = new Personage("camilo1", "poderoso", null, 20);
		a.addPersonage(b1);
		a.addPersonage(c1);
		p.addClan(a1);
		Personage e = p.foundPersonage("naruto1");
		assertEquals("naruto1", e.getName());
	}
	
	@Test
	public void foundTest() throws ExceptionRegistry, ExceptionNoFound {
		Project p = new Project();
		Clan a = new Clan("power");
		Clan b = new Clan("ranger");
		Clan c = new Clan("galaxy");
		p.addClan(a);
		p.addClan(b);
		p.addClan(c);
		Clan actual = p.found("ranger");
		assertEquals("ranger", actual.getName());
	}

}
