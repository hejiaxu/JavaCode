/**
 * 
 */
package com.code.syntax;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Jiaxu
 * Jun 19, 2017
 * 
 */
public class ListCopy {

	public static void main(String[] args) {
		// TODO 
		List<Integer> list = new ArrayList<>();
		
		
		//light
		List<Integer> listCopy100 = new ArrayList<>(list);
		
		List<Integer> listCopy101 = new ArrayList<>();
		listCopy101.addAll(list);
		
		Integer[] src = list.toArray(new Integer[0]);
		Integer[] dest = new Integer[src.length];
		System.arraycopy(src, 0, dest, 0, src.length);
		List<Integer> listCopy102 = Arrays.asList(dest);
		
		//deep
		List<Integer> listCopy201 = new ArrayList<>();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			listCopy201.add(integer);
		}
		
		try {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream objectOutputStream;
			objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(list);
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
			ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
			List<Integer> listCopy202 = (List<Integer>)objectInputStream.readObject();
		} catch (IOException | ClassNotFoundException e) {
			// TODO 
			e.printStackTrace();
		}
		
		
		
	}

}
