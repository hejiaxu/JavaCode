/**
 * 
 */
package com.code.syntax;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Jiaxu
 * Jun 22, 2017
 * 
 */
public class MapApi {

	public static void main(String[] args) {
		// TODO 
		Map<Integer,Integer> map = new HashMap<>();
		map.put(1, 1);
		map.put(2, 1);
		map.put(3, 1);
		
		Set<Integer> set = map.keySet();
		for (Integer key : set) {
			Integer value = map.get(key);
			System.out.print(key);
			System.out.print(value);
		}
		System.out.println();
		
		
		Set<Entry<Integer,Integer>> entrySet = map.entrySet();
		for (Entry<Integer, Integer> entry : entrySet) {
			Integer key = entry.getKey();
			Integer value = entry.getValue();

			System.out.print(key);
			System.out.print(value);
		}
		System.out.println();

		Collection<Integer> values = map.values();
		for (Integer value : values) {
			System.out.print(value);
		}
		System.out.println();

		
	}

}
