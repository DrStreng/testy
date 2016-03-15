package leki;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class lekiTesty {

Leki l1;
Leki l2;
@Before
public void create() throws Exception {
     l1 = new Leki("Apap", 15);
     l2 = new Leki("Paracetamol", 5);
}
@Test
public void testAdd() throws Exception {
    LekiManager lekimanager =  new LekiManager();

    lekimanager.add(l1);
    ArrayList<Leki> lekis = lekimanager.getAll();
    assertEquals(lekis.size(), 1);

    lekimanager.add(l1);
    lekis = lekimanager.getAll();
    assertEquals(lekis.size(), 2);

}


	
}
