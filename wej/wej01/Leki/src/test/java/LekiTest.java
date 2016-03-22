import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

public class LekiTest {
	
	LekiManager lm = new LekiManager();
	
	Leki l1 = new Leki("Apap","Paracetamol",15.01,2012);
	Leki l2 = new Leki("Cerutin","Witamina",5.5,2015);
	
	@Test
	public void checkList(){
		assertTrue(lm.getAll().isEmpty());
	}
	
	@Test
	public void addToList(){
		lm.add(l1);
		List<Leki> lekis = lm.getAll();
		assertEquals(lekis.size(),1);
	}
	
	@Test
	public void getAllTest(){
		lm.add(l1);
		lm.add(l2);
		
		assertFalse(lm.getAll().isEmpty());
		assertEquals(lm.getAll().size(),2);
		assertEquals(l1,lm.getAll().get(0));
		assertEquals(l2,lm.getAll().get(1));
		assertEquals("Apap",lm.getAll().get(0).nazwa);
		assertNotEquals(lm.getAll().size(),3);
		
		Date now = new Date();   
		assertNotEquals(now.getYear(),lm.getAll().get(0).rokProdukcji);
		
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testException(){
		//lm.add(l1);
		lm.getAll().get(0);
	}
	@Test
	public void testRemove(){
		lm.add(l1);
		assertFalse(lm.getAll().isEmpty());
		lm.remove(l1);
		assertTrue(lm.getAll().isEmpty());
	}
}
