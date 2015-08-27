package responsePackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ResponseClassTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testJobUpdate() {
ResponseClass rc=new ResponseClass("123456");
assertEquals(true,rc.jobUpdate());
	}

}
