import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exception.ExceptionRegistry;
import model.Clan;
import model.Personage;

class ProjectTest {

	@Test
	public void saveAllTest() throws ExceptionRegistry {
		Clan a = new Clan("power");
		Personage b = new Personage("naruto", "poderoso", null, 20);
		Personage c = new Personage("camilo", "poderoso", null, 20);
		Personage d = new Personage("vivas", "poderoso", null, 20);
		a.addPersonage(b);
		a.addPersonage(c);
		a.addPersonage(d);
	}

}
