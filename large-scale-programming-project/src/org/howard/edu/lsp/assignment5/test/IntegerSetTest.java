package org.howard.edu.lsp.assignment5.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;



import org.howard.edu.lsp.assignment5.IntegerSet;
import org.howard.edu.lsp.assignment5.IntegerSetException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;





public class IntegerSetTest {
	@Test
    @DisplayName("Testing if empty")
    public void testIsEmpty() {
       IntegerSet set1 = new IntegerSet();
       //test if true when set 1 is empty
       assertTrue(set1.isEmpty());
       //test that its false when set1 is not empty 
       set1.add(1);
       assertFalse(set1.isEmpty());
       }

	@Test
	@DisplayName("Testing the length")
	public void testLength() {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set1.add(5);
		//testing that the length of set 1 is equal to 5
		assertEquals(5, set1.length());
		assertEquals("[1, 2, 3, 4, 5]", set1.toString());
	}

	@Test
	@DisplayName("Test for equal integer sets")
	public void testEquals() {
		IntegerSet set1 = new IntegerSet();
		set1.add(0);
		set1.add(1);
		set1.add(2);
		IntegerSet set2 = new IntegerSet();
		set2.add(0);
		set2.add(1);
		set2.add(2);
		//Test for sets that are equal
		boolean val = set1.equals(set2);
		assertEquals(true, val);
		//Test when sets are unequal
		set1.add(99);
		val = set1.equals(set2);
		assertEquals(false, val);
	}

	@Test
	@DisplayName("Test for set cotaining an int")
	public void testContains() {
		IntegerSet set1 = new IntegerSet();
		set1.add(5);
		set1.add(10);
		set1.add(4);
		//test for an integer (5) which is in the integer set
		boolean val = set1.contains(5);
		assertEquals(true, val);
		//test for an integer (1) which isn't in the integer set
		val = set1.contains(1);
		assertEquals(false, val);
	}

	@Test
	@DisplayName("Test for largest integer in the set")
	public void testLargest() throws IntegerSetException {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(99);
		set1.add(5);
		//test if 99 is the largest in the set which is true 
		assertEquals(99, set1.largest());
		//ttest if 5 is the largest in the set which is false
		assertFalse(set1.largest() == 5);
	}

	@Test
	@DisplayName("Test for largest throws exception")
	public void testLargest_THROWS_EXCEPTION() {
		IntegerSet set1 = new IntegerSet();
		Exception exception = assertThrows(IntegerSetException.class, () -> {
			set1.largest();
		});
		String expectedMessage = "empty list";
		String actualMessage = exception.getMessage();
		//test that the set is empty
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	@DisplayName("Test for smallest")
	public void testSmallest() throws IntegerSetException {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(0);
		set1.smallest();
		//test that 0 is the smallest which is true
		assertEquals(0, set1.smallest());
		//test that 1 is the smallest which is false
		assertFalse(set1.smallest() == 1);

	}

	@Test
	@DisplayName("Test for smallest throws exception")
	public void testSmallest_THROWS_EXCEPTION() {
		IntegerSet set1 = new IntegerSet();
		Exception exception = assertThrows(IntegerSetException.class, () -> {
			set1.smallest();
		});
		String expectedMessage = "empty list";
		String actualMessage = exception.getMessage();
		//test that the set is empty
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	@DisplayName("Test cases for adding")
	public void testAdd() {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		IntegerSet val = set1;
		IntegerSet expected = new IntegerSet();
		expected.add(1);
		expected.add(2);
		expected.add(3);
		//Test if 1,2,3 are added to the Integer Set without being duplicated
		assertTrue(expected.equals(val));
		//Test that set1 contains 1, 2, and 3
		assertEquals("[1, 2, 3]", set1.toString());
		assertTrue(set1.contains(1));
		assertTrue(set1.contains(2));
		assertTrue(set1.contains(3));
		//Test that set1 does not contain the integer 4
		assertFalse(set1.contains(4));
	}

	@Test
	@DisplayName("Test cases for remove")
	public void testRemove() throws IntegerSetException {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set1.remove(4);
		IntegerSet expected = new IntegerSet();
		expected.add(1);
		expected.add(2);
		expected.add(3);
		//test that set1 no longer contains 4
		assertFalse(set1.contains(4));
		//test that the output of set1 after 4 is removed = the output of set2
		assertTrue(set1.equals(expected));

	}

	@Test
	@DisplayName("Test if remove throws exception")
	public void testRemove_THROWS_EXCEPTION() {
		IntegerSet set1 = new IntegerSet();
		Exception exception = assertThrows(IntegerSetException.class, () -> {
			set1.remove(1);
		});
		String expectedMessage = "empty list";
		String actualMessage = exception.getMessage();
		//test that the integer set is empty
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	@DisplayName("Test cases for union")
	public void testUnion() throws IntegerSetException {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		IntegerSet set2 = new IntegerSet();
		set2.add(3);
		set1.union(set2);
		//test that when set1 forms a union, that it is formed in the correct order
		assertEquals("[1, 2, 3]", set1.toString());
		assertNotEquals("[3, 2, 1]", set1.toString());
	}


	@Test
	@DisplayName("Test cases for intersect")
	public void testIntersect() throws IntegerSetException{
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		IntegerSet set2 = new IntegerSet();
		set2.add(2);
		set2.add(3);
		set1.intersect(set2);
		//test that 2, and 3 are the only shared integers between set1 and set2
		assertEquals("[2, 3]", set1.toString());
		assertTrue(set1.contains(2));
		assertTrue(set1.contains(3));
		assertFalse(set2.contains(4));
	}



	@Test
	@DisplayName("Test cases for difference")
	public void testDifference() throws IntegerSetException{
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		IntegerSet set2 = new IntegerSet();
		set2.add(2);
		set2.add(3);
		set1.diff(set2);
		//Test that the integers 1, and 4 aren't shared between the sets 
		assertEquals("[1, 4]", set1.toString());
		//test that 2, and 3 were the only shared integers between set1 and set2 
		assertFalse(set1.contains(2));
		assertFalse(set1.contains(3));
	}



	@Test
	@DisplayName("Test cases for toString")
	public void testToString() throws IntegerSetException {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.toString();
		//test that the set displays correctly when printed
		assertEquals("[1, 2, 3]", set1.toString());
		assertNotEquals("[3, 2, 1]", set1.toString());
	}
}