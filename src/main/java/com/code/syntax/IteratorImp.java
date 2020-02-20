/**
 * 
 */
package com.code.syntax;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Jiaxu
 * Jun 26, 2017
 * 
 */
public class IteratorImp {

	public static void main(String[] args) {
		// TODO 
		Node node = new IteratorImp().new Node(),node2=node;
		for (int i = 0; i < 5; i++) {
			node.next = new IteratorImp().new Node();
			node=node.next;
		}
		List<Integer> list = new LinkedList<>();
		Iterator<Integer> iterator = list.iterator();
		
	}
	public class Node{
		int val;
		Node next;
		public Node() {
			// TODO
		}
	}
	
	public class NodeIterator{
		Node node;
		public NodeIterator(Node node) {
			// TODO
			this.node=node;
		}
		public boolean hasNext(){
			return node!=null;
		}
		public Node next(){
			Node tmp = node;
			node=node.next;
			return tmp;
		}
	}
}
