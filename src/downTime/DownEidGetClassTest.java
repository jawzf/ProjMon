package downTime;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DownEidGetClassTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetEIDown() {
		DownEidGetClass dei=new DownEidGetClass();
		String[] m=new String[30];
		m=dei.getEIDown();
		boolean s=false;
		for(int i=0;i<m.length;i++)
		{
			if(m[i].equals("123456"))
				{
				s=true;
				break;
				
					}
		}
		assertEquals(true, s);
	}

}
