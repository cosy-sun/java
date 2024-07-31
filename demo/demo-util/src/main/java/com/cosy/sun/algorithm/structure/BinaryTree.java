package com.cosy.sun.algorithm.structure;

/**
 * 二叉搜索树
 * @author cosy-sun
 *
 */
public class BinaryTree<T extends Comparable<T>, K> {

	private Element<T, K> root;
	public int size = 0;
	private Element<T, K> rootClone = null;
	
	public void traver(T key) {
		Element<T,K> searchEle = searchEle(key);
		traversingMid(searchEle);
	}
	
	public void traver() {
		traversingMid(root);
	}
	
	public void traversingMid(Element<T, K> ele) {
		System.out.println((String)ele.getValue());
		if(ele.left == null && ele.right == null) {
		} else if (ele.left == null) {
			traversingMid(ele.right);
		} else if (ele.right == null) {
			traversingMid(ele.left);
		} else {
			traversingMid(ele.left);
			traversingMid(ele.right);
		}
	}
	/**
	 * 删除K节点
	 * @param key
	 * @return
	 */
	public K delete(T key) {
		Element<T, K> keyEle = searchEle(key);
		if(keyEle.parent == null && keyEle == root) {
			if(keyEle.right == null) {
				keyEle.left.parent = null;
				root = keyEle.left ;
				keyEle.left = null;
				setRootclone();
			} else {
				rootLeftRightNotNull(key);
			}
			return keyEle.value;
		}
		if(keyEle.left == null && keyEle.right == null) {
			if(keyEle == keyEle.parent.left) {
				keyEle.parent.left = null;
				keyEle.parent = null;
			} else {
				keyEle.parent.right = null;
				keyEle.parent = null;
			}
		}
		if(keyEle.left == null && keyEle.right != null) {
			if(keyEle == keyEle.parent.left) {
				keyEle.parent.left = keyEle.right;
				keyEle.right.parent = keyEle.parent;
			} else {
				keyEle.parent.right = keyEle.right;
				keyEle.right.parent = keyEle.parent;
			}
		}
		
		if(keyEle.right == null && keyEle.left != null) {
			if(keyEle == keyEle.parent.left) {
				keyEle.parent.left = keyEle.left;
			} else {
				keyEle.parent.right = keyEle.left;
			}
		}
	
		if(keyEle.right != null && keyEle.left != null) {
			leftRightNotNull(key);
		}
		size --;;
		return keyEle.value;
	}
	
	private void rootLeftRightNotNull(T key) {
		Element<T, K> keyEle = searchEle(key);
		Element<T, K> successor = successor(key);
		Element<T, K> keyRight = successor;
		Element<T, K> successorLeft = successor.left;
		if(keyRight == keyEle.right) {
			keyRight.left = keyEle.left;
			keyRight.parent = keyEle.parent;
			root = keyRight;
		} else {
			if(keyRight.left == null) {
				//后继节点切换到key节点
				successor.left = keyEle.left;
				successor.right = keyEle.right;
				successor.parent = keyEle.parent;
				if(keyRight.parent.right == keyRight) {
					keyRight.parent.right = null;
				} else {
					keyRight.parent.left = null;
				}
				keyRight.left = null;
				keyRight.right = null;
			} else {
				//后继节点的子节点替换后继节点,后继节点替换key节点
				successorLeft.parent = keyRight.parent;
				keyRight.parent.left = successorLeft;
				
				successor.left = keyEle.left;
				successor.right = keyEle.right;
				successor.parent = keyEle.parent;
			}
			root = successor;
		}
		setRootclone();
	}
	
	private void leftRightNotNull (T key) {

		Element<T, K> keyEle = searchEle(key);
		Element<T, K> successor = successor(key);
		Element<T, K> keyRight = successor;
		Element<T, K> successorLeft = successor.left;
		if(keyRight == keyEle.right) {
			keyRight.left = keyEle.left;
			keyRight.parent = keyEle.parent;
			if(keyEle == keyEle.parent.left) {
				keyEle.parent.left = keyRight;
			} else {
				keyEle.parent.right = keyRight;
			}
		} else {
			if(keyRight.left == null) {
				//后继节点切换到key节点
				successor.left = keyEle.left;
				successor.right = keyEle.right;
				successor.parent = keyEle.parent;
				if(keyRight.parent.right == keyRight) {
					keyRight.parent.right = null;
				} else {
					keyRight.parent.left = null;
				}
				keyRight.left = null;
				keyRight.right = null;
			} else {
				//后继节点的子节点替换后继节点,后继节点替换key节点
				successorLeft.parent = keyRight.parent;
				keyRight.parent.left = successorLeft;
				
				successor.left = keyEle.left;
				successor.right = keyEle.right;
				successor.parent = keyEle.parent;
				if(keyEle == keyEle.parent.left) {
					keyEle.parent.left = successor;;
				} else {
					keyEle.parent.right = successor;
				}
			}
		}
	
	}
	
	public void insert(T[] keys) {
		for(T key : keys) {
			insert(key, null);
		}
	}
	
	/**
	 * 插入
	 * @param key
	 * @param value
	 */
	public void insert(T key, K value) {
		if(key == null) {
			return ;
		}
		Element<T, K> ele = new Element<>(key, value);
		ele.left = null;
		ele.right = null;
		if(root == null) {
			root = ele;
			root.parent = null;
			setRootclone();
			size ++;
			return ;
		}
		Element<T, K> tmp = null;
		while(rootClone != null) {
			tmp = rootClone;
			if(rootClone.key.compareTo(ele.key) > 0) {
				rootClone = rootClone.left;
			} else {
				rootClone = rootClone.right;
			}
		}
		if(tmp.key.compareTo(ele.key) < 0) {
			tmp.right = ele;
			ele.parent = tmp;
		} else {
			tmp.left = ele;
			ele.parent = tmp;
		}
		size ++;
		this.rootClone = this.root;
	}
	
	public Element<T, K> successor(T key) {//某元素的后继
		Element<T, K> searchEle = searchEle(key);
		if(searchEle == null) {
			return null;
		}
		
		if(searchEle.right != null) {
			return minmum(searchEle.right.key);
		}
		
		Element<T, K> tmp = searchEle.parent;
		while(tmp != null && searchEle == tmp.right) {
			searchEle = tmp;
			tmp = tmp.parent;
		}
		return tmp;
	}
	
	
	
	public Element<T, K> maxmum(T key) {
		Element<T,K> searchEle = searchEle(key);
		this.rootClone = searchEle;
		while (rootClone != null && rootClone.right != null) {
			rootClone = rootClone.right;
		}
		Element<T, K> tmp = rootClone;  
		setRootclone();
		return tmp;
	}

	public Element<T, K> maxEle(T key) {
		Element<T, K> searchEle = searchEle(key);
		this.rootClone = searchEle;
		Element<T, K> maxmum = maxmum(key);
		setRootclone();
		return maxmum;
	}

	public Element<T, K> minmum(T key) {
		Element<T, K> searchEle = searchEle(key);
		this.rootClone = searchEle;
		Element<T,K> mixmum = minEle(key);
		setRootclone();
		return mixmum;
	}
	
	public Element<T, K> minEle(T key) {
		Element<T,K> searchEle = searchEle(key);
		this.rootClone = searchEle;
		while (rootClone != null && rootClone.left != null) {
			rootClone = rootClone.left;
		}
		Element<T, K> tmp = rootClone;
		setRootclone();
		return tmp;
	}
	
	public void setRootclone() {
		this.rootClone = this.root;
	}
	
	public K searchTwo(T key) {
		while(rootClone != null && rootClone.key.compareTo(key) != 0) {
			if(rootClone.key.compareTo(key) < 0) {
				rootClone = rootClone.left;
			} else {
				rootClone = rootClone.right;
			}
		}
		setRootclone();
		return rootClone.value;
	}
	
	public K search(T key) {
		if(rootClone != null) {
			if(rootClone.key == key) {
				setRootclone();
				return rootClone.value;
			}
			if(rootClone.key.compareTo(key) < 0) {
				this.rootClone = rootClone.left;
				search(key);
			} else {
				this.rootClone = rootClone.right;
				search(key);
			}
			setRootclone();
		}
		return null;
	}
	
	public Element<T, K> searchEle(T key) {
		while(rootClone != null && rootClone.key.compareTo(key) != 0) {
			if(rootClone.key.compareTo(key) > 0) {
				rootClone = rootClone.left;
			} else {
				rootClone = rootClone.right;
			}
		}
		Element<T, K> tmp = rootClone;
		setRootclone();
		return tmp;
	}
	
	public K getRoot() {
		return root.getValue();
	}
	
	public K getRootclone() {
		return rootClone.getValue();
	}
	public class Element<T extends Comparable<T>, K>{

		Element<T, K> left;
		Element<T, K> right;
		Element<T, K> parent;
		T key;
		K value;
		public Element(T key, K value) {
			this.key = key;
			this.value = value;
		}
		public K getValue() {
			return value;
		}
	}

}
