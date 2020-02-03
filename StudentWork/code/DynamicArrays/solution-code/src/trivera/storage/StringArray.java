package trivera.storage;

import java.util.Arrays;

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
	// Internal counter for counting amount of Strings
	private int count;
	// Internal Storage
	private String[] data = new String[5];

	/**
	 * @return The number of elements in the Dynamic Array
	 */
	public int size() {
		return count;
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
		// When someone asks for data outside of array, Exception will be thrown
		return data[index];
	}

	/**
	 * Add a String to the next available 'slot' in the array
	 *
	 * @param string
	 *            The String to be added
	 */
	public void add(String string) {
		// Do not add null pointer
		if (string == null) {
			return;
		}

		// Add the data to the Array
		// (increase counter after add!)
		data[count++] = string;

		// When array is full, let's create bigger array
		if (count == data.length) {
			// Create array, 5 bigger than the original array
			String[] newData = new String[data.length + 5];
			// Copy the data from the old array into the new Array
			System.arraycopy(data, 0, newData, 0, data.length);
			// Move the reference to the new array to the instance variable
			this.data = newData;
		}
	}

	/**
	 * Remove the given String from the Array. When the String value is present multiple times
	 * it should be removed multiple times
	 *
	 * @param string
	 *            The String to be removed
	 */
	public void remove(String string) {
		// When param is null do nothing
		if (string == null)
			return;

		// Create a new Array with the same size as the original array
		String[] newData = new String[data.length];
		int count = 0;
		// Iterate over all Objects in the instance array
		for (String currentObject : data) {
			// Since the array only holds null pointers at the end
			// We can stop once reference is null
			if (currentObject == null) {
				break;
			}
			// When the String in the original array is NOT equal
			// To the value to remove, copy to the new array
			if (!(string.equals(currentObject))) {
				newData[count++] = currentObject;
			}
		}
		// Move the reference to the new array to the instance variable
		this.data = newData;
		// Set the instance counter to the amount of elements copied
		this.count = count;
	}

	/**
	 * Remove all Strings from the dynamic array.
	 */
	public void clear() {
		Arrays.fill(data, null);
		this.count = 0;
	}

}
