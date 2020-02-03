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

public class IntegerArrayTest {

	@Test
	public void testSize() {
		ObjectArray<Integer> array = new ObjectArray<>();
		int size = array.size();
		assertEquals(0, size);
	}

	@Test
	public void testSize1() {
		ObjectArray<Integer> array = new ObjectArray<>();
		array.add(1);
		int size = array.size();

		assertEquals(1, size);
	}

	@Test
	public void testSizeAfterRemove() {
		ObjectArray<Integer> array = new ObjectArray<>();
		array.add(1);
		array.remove(1);
		int size = array.size();

		assertEquals(0, size);
	}

	@Test
	public void testAdd() {
		ObjectArray<Integer> array = new ObjectArray<>();
		for (int i = 0; i < 100; i++) {
			array.add(1);
		}
		int size = array.size();
		assertEquals(100, size);
	}

	@Test
	public void testGet() {
		ObjectArray<Integer> array = new ObjectArray<>();
		array.add(1);
		array.add(2);
		Object object0 = array.get(0);
		Object object1 = array.get(1);
		assertEquals(object0, 1);
		assertEquals(object1, 2);
	}

	@Test
	public void testRemove() {
		ObjectArray<Integer> array = new ObjectArray<>();
		array.add(1);
		array.add(2);
		array.add(2);
		array.add(3);

		array.remove(2);

		int size = array.size();
		assertEquals(2, size);
	}

	@Test
	public void testClear() {
		ObjectArray<Integer> array = new ObjectArray<>();
		array.add(1);
		array.add(2);
		array.clear();
		int size = array.size();
		assertEquals(0, size);
	}

}
