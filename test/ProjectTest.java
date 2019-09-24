import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import exception.ExceptionRegistry;
import model.Clan;
import model.Personage;
import model.*;

class ProjectTest {

	@Test
	public void saveAllTest() throws ExceptionRegistry, FileNotFoundException, IOException {
		Project p = new Project();
		Clan a = new Clan("power");
		Personage b = new Personage("naruto", "poderoso", null, 20);
		Personage c = new Personage("camilo", "poderoso", null, 20);
		Personage d = new Personage("vivas", "poderoso", null, 20);
		a.addPersonage(b);
		a.addPersonage(c);
		a.addPersonage(d);
		p.saveAll();
	}

}
