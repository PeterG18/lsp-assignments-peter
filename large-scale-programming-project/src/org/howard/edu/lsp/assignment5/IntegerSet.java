package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;
public class IntegerSet {
	private ArrayList<Integer> set = new ArrayList<Integer>();
	
	/** 
	 * to access the array list
	 * @return the arraylist set which we will use
	 */
	public ArrayList<Integer> IntegerSett(){
		return this.set;
	}
	/**
	 *empties the arraylist using the '.clear' arraylist method
	 */
	public void clear() {
		this.IntegerSett().clear();
	}
	/**
	 * Get's the size of the arrayList using arraylist '.size' method
	 * @return the length of the arrayList
	 */
	
	public int length() {
		return this.IntegerSett().size();
	}
	/**
	 * @param b is type IntegerSet
	 * Firstly if the lengths aren't the same its False
	 * then if the values and length are the same it 
	 * @returns True else False
	 */
	
	public boolean equals(IntegerSet b) {
		if (this.length() != b.length()) {
			return false;
		}
	for(int x: IntegerSett()) {
		if(!b.contains(x)) {
			return false;
		}
	}
	return true;
	}
	/**
	 * @param x is a int
	 * @return true if set has x as a value
	 */
	public boolean contains(int x) {
		
		return this.IntegerSett().contains(x);
	}
	/**
	 * finds largest element in the set
	 * @return the largest element in the set
	 * @throw IntegerSetException if the set is empty
	 */
	
	public int largest() throws IntegerSetException {
		if (this.IntegerSett().size() == 0) {
			throw new IntegerSetException("empty list");
		}
		return Collections.max(set);
	}; 
	/**
	 * finds smallest element in the set
	 * @return the smallest element in the set
	 * @throws FoundException if the set is empty
	 */
	public int smallest() throws IntegerSetException{
		if (this.IntegerSett().size() == 0) {
			throw new IntegerSetException("empty list");
		}
		return Collections.min(set);
	}; 
	
	/**
	 * if item is not in the set, add item
	 * @param item of type int
	 */
	public void add(int item) {
		// quick check if ithe set contains the item before adding
		if (!this.IntegerSett().contains(item)){
			this.IntegerSett().add(item);
			
		}
	}
	/**
	 * if item is in the set, remove
	 * @param item of type int
	 * @throws IntegerSetException 
	 */
	public void remove(int item) throws IntegerSetException {
		if (this.IntegerSett().isEmpty()){
			throw new IntegerSetException("empty list");
		}
		if (this.IntegerSett().contains(item)) {
			this.IntegerSett().remove(this.IntegerSett().indexOf(item));
		}
		
	}
	/**
	 * adds the elements of intSetb to the set that called the method, while still maintaining unique values
	 * @param intSetb is type IntegerSet
	 */
	public void union(IntegerSet intSetb) {
		if (!this.equals(intSetb)) {
			
			for (int i = 0; i < intSetb.IntegerSett().size(); i ++) {
				this.add(intSetb.IntegerSett().get(i));
			}	
		}
	}
	/**
	 * changes the elements of the set calling the method to contain values both sets contain
	 * @param intSetb is type IntegerSet
	 */
	public void intersect(IntegerSet intSetb) {
		
		int i = 0;
		while (i <IntegerSett().size()) {
			Integer x = IntegerSett().get(i);
			if (!intSetb.contains(x)) {
				IntegerSett().remove(x);
			} 
			
			else {
				i ++;
			}
		}
	}
	/**
	 * changes the elements of the set calling the method to the elements n the set but not in intSetb
	 * @param intSetb is type IntegerSet
	 */
	public void diff(IntegerSet intSetb) {
		
		if (!equals(intSetb)) {
		int i = 0;
			while (i <IntegerSett().size()) {
				Integer x = IntegerSett().get(i);
				
				if (intSetb.contains(x)) {
					IntegerSett().remove(x);
				}
				
				else {
					i ++;
				}
			}
		}
		
	}
	
	/**
	 *if the set is empty
	 * @return true if the set is empty, else false
	 */
	public boolean isEmpty() {
		return this.IntegerSett().isEmpty();
	}
	/**
	 * @return the a string version of the set
	 */
	public String toString() {
		return this.IntegerSett().toString();
	}
}


