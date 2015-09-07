package pullDataPackage;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class pullEmailClassTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetEmail()  {
		pullEmailClass pec=new pullEmailClass();
		try {
			String res=pec.getEmail(1000000);
			System.out.println(""+res);
			assertNotNull(res);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
