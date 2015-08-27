package techPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class techClassPostTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDbQueries() {
		techClassPost tcp=new techClassPost("abc","abc");
		assertEquals(true, tcp.dbQueries());
	}

}
