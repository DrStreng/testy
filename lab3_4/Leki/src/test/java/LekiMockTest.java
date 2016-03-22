import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import org.easymock.EasyMockRule;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class LekiMockTest {
    @Rule
    public EasyMockRule mocks = new EasyMockRule(this);

    @Mock
    private IMyList mock;

    @TestSubject
    private ILekiManager manager = new LekiManager(mock);

    Leki l1;
    Leki l2;
    Leki l3;

    @Before
    public void setUp() throws Exception {
         l1 = new Leki("Apap","Paracetamol",15.01,2012);
         l2 = new Leki("Cerutin","Witamina",5.5,2015);
         l3 = new Leki("Cotam","Paracetamol",1.01,2011);
    }

    @Test
    public void addTest() {
        mock.add(l1);
        expectLastCall();
        expect(mock.size()).andReturn(1);
        expect(mock.getAll()).andReturn(mock);
        replay(mock);
        manager.add(l1);
        assertEquals(1, manager.getAll().size());
        verify(mock);
    }



}
