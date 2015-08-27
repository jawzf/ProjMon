package serviceUIPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class jobClassGetTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetEIDown() {
		//assuming a device 123456 is down
		jobClassGet jcg=new jobClassGet();
		String[] res=new String[2];
		res=jcg.getEIDown();
		assertEquals("123456", res[0]);
		
	}

}
