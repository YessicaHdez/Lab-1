package mx.tec.lab;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OtherClassTest {

	@Test
	public void testMultiply() {
		OtherClass ot = new OtherClass();
		
		int expected = 7*8;
		assertEquals(expected,ot.multiply(7,8) );
		
	}


	@Test
	public void testMultiply_ExceptionIsThrown() {	
			OtherClass ot = new OtherClass();
		    try {
		    	ot.multiply(7,1000);     
		    } catch (UnsupportedOperationException e) {
		        assertEquals("X should be less than 1000", e.getMessage());
		    }
	}

}
