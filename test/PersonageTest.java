import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exception.ExceptionRegistry;
import model.*;

class PersonageTest {

	@Test
	public void addTechniqueTest() throws ExceptionRegistry {
		Personage a = new Personage("naruto", "poderoso", null, 20);
		Technique b = new Technique("patada", 12);
		Technique c = new Technique("puño", 12);
		a.addTechnique(b);
		a.addTechnique(c);
		String resultado = a.printNames();
		assertEquals("puño patada ", resultado);
		
	}
	
	@Test
	public void powerTest() throws ExceptionRegistry {
		Personage a = new Personage("naruto", "poderoso", null, 20);
		Technique b = new Technique("patada", 10);
		Technique c = new Technique("puño", 10);
		a.addTechnique(b);
		a.addTechnique(c);
		int result = a.getPower();
		assertEquals(2000, result);
	}

}
