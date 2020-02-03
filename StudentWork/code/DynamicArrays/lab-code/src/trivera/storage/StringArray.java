package trivera.storage;

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
public class StringArray {


	// Internal Storage
	private String[] data = new String[5];

	/**
	 * @return The number of elements in the Dynamic Array
	 */
	public int size() {
		return 0;
	}

	/**
	 * Retrieve a String at a given position in the array
	 * 
	 * @param index
	 *            The index in the dynamic array
	 * @return The String at the given index. Will throw an Exception when an index
	 *         outside of the range of the array will be requested
	 */
	public String get(int index) {

		return null;
	}

	/**
	 * Add a String to the next available 'slot' in the array
	 * 
	 * @param string
	 *            The String to be added
	 */
	public void add(String string) {

	}

	/**
	 * Remove the given String from the Array. When the String value is present multiple times
	 * it should be removed multiple times
	 * 
	 * @param string
	 *            The String to be removed
	 */
	public void remove(String string) {

	}

	/**
	 * Remove all Strings from the dynamic array.
	 */
	public void clear() {

	}

}
