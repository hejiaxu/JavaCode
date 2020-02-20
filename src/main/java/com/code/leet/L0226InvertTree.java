package com.code.leet;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * Invert a binary tree.
 4
 /   \
 2     7
 / \   / \
 1   3 6   9
 to
 4
 /   \
 7     2
 / \   / \
 9   6 3   1
 */
public class L0226InvertTree {
	public static void main(String[] args) {
		// TODO 

	}
	
	//0ms
	public TreeNode invertTree(TreeNode root){
		if (null == root) {
			return root;
		}
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}
	//0ms
	public TreeNode invertTree2(TreeNode root){
		if (null == root) {
			return root;
		}
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		root.left = right;
		root.right = left;
		return root;
	}
	//
	 public TreeNode invertTree3(TreeNode root) {
        if(root == null) return root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
        }
        return root;
    }
	 
	public TreeNode invertTree4(TreeNode root){
		 if (null == root) {
				return null;
			}
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(root);
			
			while(!queue.isEmpty()){
			    TreeNode node  = queue.poll();
			    if (null == node) {
					continue;
				}
				queue.offer(node.left);
				queue.offer(node.right);
				swap(node);
			}
		return root;
	}
	 
	 
	private void swap(TreeNode node) {
		TreeNode tmp = node.left;
		node.left = node.right;
		node.right = tmp;
	}


	//	Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
