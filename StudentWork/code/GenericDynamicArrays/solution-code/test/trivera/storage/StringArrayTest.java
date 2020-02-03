package trivera.storage;



import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * This component and its source code representation are copyright protected and
 * proprietary to Trivera Technologies, LLC, Worldwide D/B/A Trivera
 * Technologies
 *
 * This component and source code may be used for instructional and evaluation
 * purposes only. No part of this component or its source code may be sold,
 * transferred, or publicly posted, nor may it be used in a commercial or
 * production environment, without the express written consent of Trivera
 * Technologies, LLC
 *
 * Copyright (c) 2020 Trivera Technologies, LLC. http://www.triveratech.com
 * </p>
 *
 * @author Trivera Technologies Tech Team.
 */


public class StringArrayTest {

	@Test
	public void testSize() {
		ObjectArray<String> array = new ObjectArray<>();
		int size = array.size();
		assertEquals(0, size);
	}

	@Test
	public void testSize1() {
		ObjectArray<String> array = new ObjectArray<>();
		array.add("A");
		int size = array.size();

		assertEquals(1, size);
	}

	@Test
	public void testSizeAfterRemove() {
		ObjectArray<String> array = new ObjectArray<>();
		array.add("A");
		array.remove("A");
		int size = array.size();

		assertEquals(0, size);
	}

	@Test
	public void testAdd() {
		ObjectArray<String> array = new ObjectArray<>();
		for (int i = 0; i < 100; i++) {
			array.add("A");
		}
		int size = array.size();
		assertEquals(100, size);
	}

	@Test
	public void testGet() {
		ObjectArray<String> array = new ObjectArray<>();
		array.add("A");
		array.add("B");
		Object object0 = array.get(0);
		Object object1 = array.get(1);
		assertEquals(object0, "A");
		assertEquals(object1, "B");
	}

	@Test
	public void testRemove() {
		ObjectArray<String> array = new ObjectArray<>();
		array.add("A");
		array.add("B");
		array.add("B");
		array.add("C");

		array.remove("B");

		int size = array.size();
		assertEquals(2, size);
		assertEquals("A", array.get(0));
		assertEquals("C", array.get(1));
	}

	@Test
	public void testClear() {
		ObjectArray<String> array = new ObjectArray<>();
		array.add("A");
		array.add("B");
		array.clear();
		int size = array.size();
		assertEquals(0, size);
	}

	@Test
	public void testArrayReuse() {
		ObjectArray<String> array = new ObjectArray<>();
		array.add("A");
		array.add("B");
		array.clear();
		array.add("C");
		assertEquals("C", array.get(0));
	}
}
