package techPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class techClassGetTest {
	//Assuming Technician id T1001 is assigned job and has only 1 equip
	techClassGet tcg=new techClassGet("T1001");
	
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDbConnEid() {
		String[] res=new String[2];
				res=tcg.dbConnEid();
				
		assertEquals("123456",res[0]);
	}

	@Test
	public void testDbGetAdd() {
		String a=tcg.dbGetAdd("123456");
		assertEquals("New York",a);
	}

	

}
