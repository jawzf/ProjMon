package emailPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SendEmailClassTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSend() {
 SendEmailClass sec=new SendEmailClass(77777);
 assertEquals( true,sec.send("hi"));
	}

}
