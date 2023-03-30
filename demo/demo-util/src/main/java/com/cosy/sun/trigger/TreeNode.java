package com.cosy.sun.trigger;

import java.util.List;

public class TreeNode {

	private TreeNode parent;
	private TreeNode left;
	private TreeNode right;
	private String key;
	private Object data;
	private List<TreeNode> subs;

	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public TreeNode(TreeNode parent, Object data, List<TreeNode> subs) {
		super();
		this.key = String.valueOf(this.hashCode());
		this.parent = parent;
		this.data = data;
		this.subs = subs;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (TreeNode tn : subs) {
			stringBuilder.append(tn.hashCode()).append(",");
		}
		String pStr = parent == null ? null : String.valueOf(parent.hashCode());
		String lStr = parent == null ? null : String.valueOf(parent.hashCode());
		String rStr = parent == null ? null : String.valueOf(parent.hashCode());
		return  "key = " + key + ", data=" + data + ", subs=" + stringBuilder + "parent=" + pStr + "left=" + lStr + "right=" + rStr + "\n";
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public List<TreeNode> getSubs() {
		return subs;
	}

	public void setSubs(List<TreeNode> subs) {
		this.subs = subs;
	}

}
