/**
 * 
 */
package com.code.syntax;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Jiaxu
 * May 10, 2017
 * 
 */
public class Sets implements Comparator<Sets> {

	public static void main(String[] args) {
		// TODO 
		TreeSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(1);
		treeSet.add(3);
		treeSet.add(7);
		treeSet.add(2);
		treeSet.add(5);
		for (Iterator iterator = treeSet.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			
		}
		for (Integer integer : treeSet) {
			System.out.println(integer);
		}
		System.out.println(treeSet);
		
	}
	int a;
	@Override
	public int compare(Sets o1, Sets o2) {
		// TODO 
		if (o1.a>o2.a) {
			return 1;
		}
		return 0;
	}

}
