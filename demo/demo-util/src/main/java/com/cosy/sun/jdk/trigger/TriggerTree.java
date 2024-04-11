package com.cosy.sun.jdk.trigger;

/**
 * 二叉搜索树
 * @author cosy-sun
 *
 */
public class TriggerTree {

	private TreeNode root;
	private TreeNode rootClone = null;
	public int size = 0;
	
	public void add(TreeNode treeNode) {
		if(root == null) {
			root = treeNode;
			setRootclone();
			size ++;
			return ;
		}
		treeNode.getParent().getSubs().add(treeNode);
		size ++;
	}
	
	
	public void delete() {
		
	}
	
	public void setRootclone() {
		this.rootClone = this.root;
	}
	
	public TreeNode getRoot() {
		return root;
	}
	
	public TreeNode getRootclone() {
		return rootClone;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public void setRoot(TreeNode root) {
		this.root = root;
	}


	@Override
	public String toString() {
		return "TriggerTree [root=" + root + ", size=" + size + "]";
	}
	
	
	
	
	
}
