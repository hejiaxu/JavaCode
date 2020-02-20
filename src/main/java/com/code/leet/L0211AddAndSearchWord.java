/**
 * 
 */
package com.code.leet;

/**
 * Jiaxu
 * Nov 7, 2016
 * 
 */
public class L0211AddAndSearchWord {

	public static void main(String[] args) {
		// TODO 
		L0211AddAndSearchWord addAndSearchWord = new L0211AddAndSearchWord();
		WordDictionary wordDictionary = addAndSearchWord.new WordDictionary();
		wordDictionary.addWord("ab");
//		wordDictionary.addWord("aaa");
//		wordDictionary.addWord("aba");
//		wordDictionary.addWord("baa");
//		wordDictionary.addWord("aa");
//		wordDictionary.addWord("and");
//		wordDictionary.addWord("an");
//		wordDictionary.addWord("add");
//		//addWord("a"),addWord("a"),search("."),search("a"),search("aa"),search("a"),search(".a"),search("a.")
//		//addWord("at"),addWord("and"),addWord("an"),addWord("add"),search("a"),search(".at"),addWord("bat"),search(".at"),search("an."),search("a.d."),search("b."),search("a.d"),search(".")
//		//addWord("at"),addWord("and"),addWord("an"),addWord("add"),search("a"),search(".at"),addWord("bat"),search(".at"),search("an."),search("a.d."),search("b."),search("a.d"),search(".")
//		boolean search = wordDictionary.search("a.d");
//		System.out.println(search);
//		boolean search2 = wordDictionary.search(".at");
//		System.out.println(search2);
		boolean search3 = wordDictionary.search("a.");
		System.out.println(search3);
//		boolean search4 = wordDictionary.search(".a");
//		System.out.println(search4);
//		boolean search5 = wordDictionary.search("an.");
//		System.out.println(search5);
//		boolean search6 = wordDictionary.search("bat");
//		System.out.println(search6);
//		boolean search7 = wordDictionary.search("a.b.");
//		System.out.println(search7);
//		boolean search8 = wordDictionary.search("abd.");
//		System.out.println(search8);
//		boolean search9 = wordDictionary.search("b.");
//		System.out.println(search9);
//		wordDictionary.addWord("at");wordDictionary.addWord("and");wordDictionary.addWord("an");wordDictionary.addWord("add");
//		wordDictionary.search("a");wordDictionary.search(".at");wordDictionary.addWord("bat");wordDictionary.search(".at");wordDictionary.search("an.");wordDictionary.search("a.d.");wordDictionary.search("b.");wordDictionary.search("a.d");
//		wordDictionary.search(".");

	}
	
//	//33ms
//	public class WordDictionary {
//	    private TrieNode root;
//
//	    public WordDictionary() {  
//	    	root = new TrieNode();
//	    }
//
//        public void addWord(String word) {
//	    	TrieNode tmp=root;
//	    	char[] charArray = word.toCharArray();
//	    	for (int i = 0; i < charArray.length; i++) {
//	    		if (null == tmp.nodes[charArray[i]-'a']) {
//	    			tmp.nodes[charArray[i]-'a'] = new TrieNode();
//				}
//	    		tmp = tmp.nodes[charArray[i]-'a'];
//			}
//	    	tmp.nodes[26] = new TrieNode();
//	    }
//	    public boolean searchRe(TrieNode tmp, char[] charArray, int m, int n ) {
//	    	if (m == n) {
//				if(null != tmp.nodes[26])return true;
//			}else{
//				if ('.' != charArray[m]) {
//					if (null == tmp.nodes[charArray[m]-'a']) {
//						return false;
//					}
//					return searchRe(tmp.nodes[charArray[m]-'a'],charArray,m+1,n);
//				}else{
//					for (int j = 0; j < 26; j++) {
//						if (null != tmp.nodes[j]) {
//							if( searchRe(tmp.nodes[j],charArray,m+1,n))return true;
//						}
//						
//					}
//				}
//			}
//	    	
//	    	return false;
//	    }
//
//	    
//	    // Returns if the word is in the trie.
//	    public boolean search(String word) {
//	    	char[] charArray = word.toCharArray();
//	    	return searchRe(root,charArray,0,charArray.length);
//	    }
//	    class TrieNode {
//		    // Initialize your data structure here.
//			TrieNode[] nodes;
//		    public TrieNode() {
//		        nodes = new TrieNode[27];
//		    }
//		}
//
//	}

	
	//31ms
	public class WordDictionary {

	    private class WordNode {
	        boolean isLeaf = false;
	        WordNode[] children = new WordNode[26];
	    }

	    private WordNode root = new WordNode();

	    // Adds a word into the data structure.
	    public void addWord(String word) {
	        WordNode node = root;
	        for (int i = 0; i < word.length(); i++) {
	            char c = word.charAt(i);
	            if (node.children[c - 'a'] == null) {
	                node.children[c - 'a'] = new WordNode();
	            }
	            node = node.children[c - 'a'];
	        }
	        node.isLeaf = true;
	    }

	    // Returns if the word is in the data structure. A word could
	    // contain the dot character '.' to represent any one letter.
	    public boolean search(String word) {
	        return search(word, 0, root);
	    }

	    private boolean search(String word, int index, WordNode node) {
	        if (index == word.length()) {
	            return node.isLeaf;
	        }

	        for (int i = index; i < word.length(); i++) {
	            char c = word.charAt(i);
	            if (c == '.') {
	                for (WordNode child : node.children) {
	                    if (child != null) {
	                        if (search(word, i + 1, child)) {
	                            return true;
	                        }
	                    }
	                }
	                return false;
	            } else {
	                if (node.children[c - 'a'] == null) {
	                    return false;
	                }
	                node = node.children[c - 'a'];
	            }
	        }

	        return node.isLeaf;
	    }
	}
	
}
