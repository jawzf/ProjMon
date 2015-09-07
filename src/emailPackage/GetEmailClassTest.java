package emailPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GetEmailClassTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetEmail() {
		GetEmailClass gec=new GetEmailClass(77777);
		assertEquals("jokuriackal@gmail.com",gec.getEmail());
	}

}
