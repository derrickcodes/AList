import static org.junit.Assert.*;

import org.junit.Test;


public class AListTest {
	
	@Test
	public void testAList() {
		AList arraylist = new AList();
		assertEquals(0, arraylist.getLength());
	}

	@Test
	public void testAListInt() {
		AList arraylist = new AList(5);
		assertEquals(0, arraylist.getLength());
	}

	/**
	 * even though this was a boolean method in AList.java
	 * the test method should be void, I'm not returning anything
	 * assertTrue checks that ans is a boolean with a value of true
	 */
	@Test
	public void testAddObject() {
		boolean ans;	// defaults to false
		AList arraylist = new AList(3);
		arraylist.add("apple");
		arraylist.add("pear");
		ans = arraylist.add("melon");
		assertEquals("apple", arraylist.getEntry(1));
		assertEquals("pear", arraylist.getEntry(2));
		assertEquals("melon", arraylist.getEntry(3));
		assertTrue(ans);
	}
	
	/**
	 * even though this was a boolean method in AList.java
	 * the test method should be void, I'm not returning anything
	 * assertTrue checks that ans is a boolean with a value of true
	 */
	@Test
	public void testAddIntObject() {
		boolean ans;	// defaults to false
		AList arraylist = new AList(4);
		arraylist.add("apple");
		arraylist.add("pear");
		arraylist.add("melon"); 
		ans = arraylist.add(3, "orange");	// input specific value at specific location
		assertEquals("apple", arraylist.getEntry(1));
		assertEquals("pear", arraylist.getEntry(2));
		assertEquals("orange", arraylist.getEntry(3));
		assertEquals("melon", arraylist.getEntry(4));
		assertTrue(ans);
	}

	@Test
	public void testRemove() {
		AList arraylist = new AList(5);
		arraylist.add("apple");
		arraylist.add("pear");
		arraylist.add("banana");
		arraylist.add("strawberry");
		arraylist.add("blueberry");
		arraylist.remove(4);
		// test that strawberry was removed and blueberry moved down to fill the gap
		assertEquals("blueberry", arraylist.getEntry(4));
	}

	@Test
	public void testClear() {
		AList arraylist = new AList(5);
		arraylist.add("apple");
		arraylist.add("pear");
		arraylist.add("banana");
		arraylist.add("strawberry");
		arraylist.add("blueberry");
		arraylist.clear();
		// clear sets entire array to null, this verifies that
		assertEquals(null, arraylist.getEntry(1));
		assertEquals(null, arraylist.getEntry(2));
		assertEquals(null, arraylist.getEntry(3));
		assertEquals(null, arraylist.getEntry(4));
		assertEquals(null, arraylist.getEntry(5));
	}

	@Test
	public void testReplace() {
		AList arraylist = new AList(4);
		// fill array with values
		arraylist.add("apple");
		arraylist.add("pear");
		arraylist.add("banana");
		arraylist.add("strawberry");
		// replace 3rd value in array (banana) with melon then verify
		arraylist.replace(3, "melon");
		assertEquals("apple", arraylist.getEntry(1));
		assertEquals("pear", arraylist.getEntry(2));
		assertEquals("melon", arraylist.getEntry(3));
		assertEquals("strawberry", arraylist.getEntry(4));
	}

	@Test
	public void testGetEntry() {
		AList arraylist = new AList(4);
		// fill array with values
		arraylist.add("apple");
		arraylist.add("pear");
		arraylist.add("banana");
		arraylist.add("strawberry");
		assertEquals("apple", arraylist.getEntry(1));
		assertEquals("pear", arraylist.getEntry(2));
		assertEquals("banana", arraylist.getEntry(3));
		assertEquals("strawberry", arraylist.getEntry(4));
	}

	@Test
	public void testContains() {
		AList arraylist = new AList(4);
		// fill array with values
		arraylist.add("apple");
		arraylist.add("pear");
		arraylist.add("banana");
		arraylist.add("strawberry");
		assertEquals(true, arraylist.contains("pear"));
	}

	@Test
	public void testGetLength() {
		AList arraylist = new AList(5);
		// fill array with values
		arraylist.add("apple");
		arraylist.add("pear");
		arraylist.add("banana");
		arraylist.add("strawberry");
		assertEquals(4, arraylist.getLength());
		arraylist.add("melon");
		assertEquals(5, arraylist.getLength());
	}

	@Test
	public void testIsEmpty() {
		AList arraylist = new AList();
		assertEquals(true, arraylist.isEmpty());
	}

	@Test
	public void testIsFull() {
		AList arraylist = new AList(5);
		arraylist.add("apple");
		arraylist.add("pear");
		arraylist.add("banana");
		arraylist.add("strawberry");
		arraylist.add("blueberry");
		assertEquals(true, arraylist.isFull());
	}

}
