/**
 * 
 */
package com.code.leet;

/**
 Implement a trie with insert, search, and startsWith methods.

 Note:
 You may assume that all inputs are consist of lowercase letters a-z.
 */
public class L0208ImplementTriePrefixTree {

	public static void main(String[] args) {
		// TODO 

	}
	//17 ms
	public class Trie {
	    private TrieNode root;

	    public Trie() {
	    	root = new TrieNode();
	    }

	    // Inserts a word into the trie.
	    public void insert(String word) {
	    	TrieNode tmp=root;
	    	char[] charArray = word.toCharArray();
	    	for (int i = 0; i < charArray.length; i++) {
	    		if (null == tmp.nodes[charArray[i]-'a']) {
	    			tmp.nodes[charArray[i]-'a'] = new TrieNode();
				}
	    		tmp = tmp.nodes[charArray[i]-'a'];
			}
	    	tmp.nodes[26] = new TrieNode();
	    }

	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	    	TrieNode tmp=root;
	    	char[] charArray = word.toCharArray();
	    	for (int i = 0; i < charArray.length; i++) {
	    		if (null == tmp.nodes[charArray[i]-'a']) {
	    			return false;
				}
	    		tmp = tmp.nodes[charArray[i]-'a'];
			}
	    	if (null == tmp.nodes[26]) {
				return false;
			}
	        return true;
	    }

	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
	    	TrieNode tmp=root;
	    	char[] charArray = prefix.toCharArray();
	    	for (int i = 0; i < charArray.length; i++) {
	    		if (null == tmp.nodes[charArray[i]-'a']) {
	    			return false;
				}
	    		tmp = tmp.nodes[charArray[i]-'a'];
			}
	        return true;
	    }
	}

	class TrieNode {
	    // Initialize your data structure here.
		TrieNode[] nodes;
	    public TrieNode() {
	        nodes = new TrieNode[27];
	    }
	}
	
	//27ms
	class TrieNode2

	{
		// Initialize your data structure here.
		TrieNode2[] nodes;
		boolean isWord = false;
		public TrieNode2() {
			nodes = new TrieNode2[26];
		}
	}
	public class Trie2 {
		private TrieNode2 root;
		
		public Trie2() {
			root = new TrieNode2();
		}
		
		// Inserts a word into the trie.
		public void insert(String word) {
			TrieNode2 tmp=root;
			char[] charArray = word.toCharArray();
			for (int i = 0; i < charArray.length; i++) {
				if (null == tmp.nodes[charArray[i]-'a']) {
					tmp.nodes[charArray[i]-'a'] = new TrieNode2();
				}
				tmp = tmp.nodes[charArray[i]-'a'];
			}
			tmp.isWord = true;
		}
		
		// Returns if the word is in the trie.
		public boolean search(String word) {
			TrieNode2 tmp=root;
			char[] charArray = word.toCharArray();
			for (int i = 0; i < charArray.length; i++) {
				if (null == tmp.nodes[charArray[i]-'a']) {
					return false;
				}
				tmp = tmp.nodes[charArray[i]-'a'];
			}
			if (tmp.isWord != true) {
				return false;
			}
			return true;
		}
		
		// Returns if there is any word in the trie
		// that starts with the given prefix.
		public boolean startsWith(String prefix) {
			TrieNode2 tmp=root;
			char[] charArray = prefix.toCharArray();
			for (int i = 0; i < charArray.length; i++) {
				if (null == tmp.nodes[charArray[i]-'a']) {
					return false;
				}
				tmp = tmp.nodes[charArray[i]-'a'];
			}
			return true;
		}
	}
}
