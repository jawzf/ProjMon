package downTime;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GetCIDTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetCid() {
		GetCID gc=new GetCID("123456");
		assertEquals("yoloyolo", gc.getCid());
	}

}
