package serviceUIPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class linkMapClassTest {
linkMapClass lmc=new linkMapClass();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAddresses() {
		//asssuming device 123456 is down
		String[] res=new String[2];
		res=lmc.getAddresses();
		assertEquals("New York",res[0]);
	}

	@Test
	public void testEquip_id() {
		String[] res=new String[2];
		res=lmc.equip_id();
		assertEquals("123456",res[0]);
	}

}
