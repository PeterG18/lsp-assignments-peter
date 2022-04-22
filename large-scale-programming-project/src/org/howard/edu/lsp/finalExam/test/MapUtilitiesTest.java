package org.howard.edu.lsp.finalExam.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.howard.edu.lsp.finalExam.MapUtilities;
import org.howard.edu.lsp.finalExam.NullMapException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MapUtilitiesTest {
	@Test
	@DisplayName("Test for counting equal key/val pairs ")
	public void commonKeyValuePairs() throws NullMapException {

		HashMap<String, String> map1 = new HashMap<>();
		// same as the tables in the test doc
		map1.put("Alice","Healthy");
		map1.put("Mary", "Ecastic");
		map1.put("Bob","Happy");
		map1.put("Chuck", "Fine");
		map1.put("Felix", "Sick");
		 
		
		HashMap<String, String> map2 = new HashMap<>();
		 
		map2.put("Mary", "Ecastic");
		map2.put("Felix", "Healthy");
		map2.put("Ricardo", "Superb");
		map2.put("Tam", "Fine");
		map2.put("Bob", "Happy");
		
		HashMap<String, String> map3 = new HashMap<>();
		HashMap<String, String> map4 = new HashMap<>();
		
		HashMap<String, String> map5 = new HashMap<>();
		map5.put("Felix", "Sick");
		map5.put("Chuck", "not fine");
		// true
		assertEquals(MapUtilities.commonKeyValuePairs(map1,map2),2);
//		checks Empty hashmap
		assertEquals(MapUtilities.commonKeyValuePairs(map1,map3),0);
		assertEquals(MapUtilities.commonKeyValuePairs(map3,map4),0);
//		check when hashmaps are different sizes
		assertEquals(MapUtilities.commonKeyValuePairs(map1,map5),1);
		assertEquals(MapUtilities.commonKeyValuePairs(map5,map1),1);
		
	}
	
	@Test
	@DisplayName("testcommonKeyValuePairs throws exception")
	public void testCommonKeyValuePairs_exception() {
		HashMap<String, String> map1 = null;
		HashMap<String,String> map2 = null;
		HashMap<String, String> map3 = new HashMap<>();
		map3.put("Peter", "Fast");

		//		checks when both the hashmap is null.
		Exception exception1 = assertThrows(NullMapException.class, ()->{
			MapUtilities.commonKeyValuePairs(map1,map2);
		});
		String expectedMessage = "at least one hashmap is null";
		String actualMessage = exception1.getMessage();
		//checks when one hashmap is null
		Exception exception2 = assertThrows(NullMapException.class, ()->{
			MapUtilities.commonKeyValuePairs(map1,map2);
		});
		String expected = "One or both maps are null!";
		String actual = exception2.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));
		assertTrue(actual.contains(expected));
	}

}