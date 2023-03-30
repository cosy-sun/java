package com.cosy.sun.structure.redblacktree;

import java.util.Arrays;

/**
 * 红黑树
 * 性质:
 * 	节点时红色或者黑色
 * 	根节点时黑色
 * 	每个叶节点时黑色
 * 	每个红色节点的两个子节点都是黑色的
 * 	每个节点到其他所有叶节点的路径上,黑色节点的数目是不变的,简称黑高hg
 * @author cosy-sun
 *
 */
public class RedBlackTree<V> {

	private Element<V> root;
	private int size = 0;
	@SuppressWarnings("unchecked")
	private Element<V>[] arr = new Element[8];
	private Element<V> rootClone= null;
	private Element<V> nil = new Element<>();
	
	/**
	 * 插入操作.初始时和二叉搜索树时一致的,后续需要更改节点的颜色和位置整颗书的性质,
	 * @param key
	 * @param value
	 */
	public void insert(int key, V value) {
		//首先创建一个element,并且初始化
		Element<V> element = new Element<>();
		element.color = true;//开始时红色
		element.left = element.right = element.parent = nil;
		element.key = key;
		element.value = value;
		if(this.root == null) {
			this.root = element;
		} else {
			Element<V> tmp = rootClone;
			while(rootClone!= null && rootClone.key!= key) {
				tmp = rootClone;
				if(rootClone.key > key) {
					rootClone = rootClone.left;
				} else if(rootClone.key == key) {
					System.out.println("已经存在此key,请重新输入!");
					return ;
				} else {
					rootClone = rootClone.right;
				}
			}
			if(tmp.key < key) {
				tmp.right = element;
				element.parent = tmp;
			} else {
				tmp.left = element;
				element.parent = tmp;
			}
			
		}
		insert_fixup(key, value);
		setRootClone();
		size ++;
	}
	
	/**
	 * 插入打制定位置之后重新着色
	 * 
	 * 1.当前节点是红色,当前节点的父节点是红色,当前节点的叔父节点是红色,
	 * 		将父节点设为黑色,
	 * 		叔叔节点设为黑色,
	 * 		祖父节点设为红色,
	 * 		祖父节点设为当前节点,
	 * 		继续轮询,
	 * 2.当前节点是红色,当前节点的父节点是红色,叔叔节点是黑色当前节点是其父节点的右孩子,
	 * 		父节点设为黑色,
	 * 		祖父节点设为红色,
	 * 		以祖父节点为指点进行左旋,
	 * 		继续轮询
	 * 3.当前节点的父节点是红色,叔叔节点是黑色,当前节点是父节点的左孩子
	 * 		父节点是当前的节点,
	 * 		以父节点为指点进行右旋,
	 * 		继续轮询
	 */
	public void insert_fixup(int key, V value) {
		Element<V> keyEle = searchEle(key);
		Element<V> uncleEle = null;
		while(keyEle.parent.color == true) {
			if(keyEle.parent == keyEle.parent.parent.left) {
				uncleEle = keyEle.parent.parent.right;
				if(uncleEle.color == true) {
					keyEle.parent.color = false;
					uncleEle.color = false;
					keyEle.parent.parent.color = true;
					keyEle = keyEle.parent.parent;
				} else if(keyEle == keyEle.parent.right){
					keyEle.parent.color = false;
					keyEle.parent.parent.color = true;
					keyEle = keyEle.parent.parent;
					leftRotate(keyEle.key);
				}
				keyEle.parent.color = false;
				keyEle.parent.parent.color = true;
				rightRotate(keyEle.parent.parent.key);
			} else {
				uncleEle = keyEle.parent.parent.left;
				if(uncleEle.color == true ) {
					keyEle.parent.color = uncleEle.color = false;
					keyEle.parent.parent.color = true;
					keyEle = keyEle.parent.parent;
				} else if(keyEle == keyEle.parent.left) {
					keyEle.parent.color = false;
					keyEle.parent.parent.color = true;
					keyEle = keyEle.parent.parent;
					leftRotate(keyEle.key);
				}
				keyEle.parent.color = false;
				keyEle.parent.parent.color = true;
				rightRotate(keyEle.key);
			}
		}
		//父节点不是红色,此次插入不违反红黑树的性质,可行
		//将根节点设置为黑色;
		this.root.color = false;
	}
	
	public void delete(int key) {
		//此处不想写代码,以后有空再写
		/*
		 * 删除节点key
		 * 删除叶子节点,
		 * 	叶子节点是红色,直接删除
		 * 	叶子节点是黑色,另外讨论
		 * 删除节点只有左或右子树,
		 * 	删除节点,用左右节点替换要删除的节点,同时吧左右节点颜色更改为黑色
		 * 删除节点同时有左右子树
		 * 	可以将待删除节点和他的后继节点替换,最后删除后继节点
		 * 	这种方法也就变成了删除节点是前两种情况了.
		 * 
		 * 删除叶子节点,并且叶子节点是黑色的
		 * 		1.父节点是红色,交换父节点和兄弟节点的颜色
		 * 		2.兄弟节点是红色,父节点是黑色,以父节点为轴进行旋转
		 * 			2.1.如果待删除节点是父节点的左节点,那么进行左旋
		 * 			2.2.如果待删除节点是父节点的右节点,那么进行右旋
		 * 		3.待删除节点的远亲侄子是红色,父节点颜色可红可黑,
		 * 			交换父节点和兄弟节点的颜色,设置远亲侄子颜色为黑,并且按照父节点进行旋转,
		 * 			3.1待删除节点是左节点,左旋
		 * 			3.2待删除节点是右节点,右旋
		 * 		4.待删除节点的近亲侄子是红色,父节点颜色可红可黑,兄弟节点没有右节点,否则变成3了
		 * 			交换兄弟节点和侄子节点的颜色,同时进行旋转
		 * 			4.1待删除节点是左节点,右旋
		 * 			4.2待删除节点是右节点,左旋
		 * 			旋转之后成为3的方式,然后继续进行第三种方法进行删除
		 * 		5.父节点和兄弟节点都是黑色,
		 * 			此种情况删除节点之后,把兄弟节点变成红色,
		 * 			然后从父节点往上继续查找,
		 * 				5.1如果往上查找,父节点和兄弟节点一致都是黑色,那么就直到根节点,
		 * 				5.2如果往上有其他类型,(1,4),父节点是红色或者近亲侄子节点是红色,那么处理之后就可以结束了
		 */
	}
	
	public void delete_fixup(int key) {
		
	}
	
	public void delete_transplant(int key, int other) {
		Element<V> keyEle = searchEle(key);
		Element<V> otherEle = searchEle(other);
		if(keyEle.parent == nil) {
			this.root = otherEle;
		} else if(keyEle == keyEle.parent.left) {
			keyEle.parent.left = otherEle;
		} else {
			keyEle.parent.right = otherEle;
		}
		otherEle.parent = keyEle.parent;
	}
	
	public Element<V> successor(int key) {
		//同二叉搜索树
		Element<V> searchEle = searchEle(key);
		if(searchEle == null || searchEle.right == nil || searchEle.right == null) {
			return null;
		}
		return maxmum(key);
	}
	
	/**
	 * 红黑树的最大节点
	 * @return
	 */
	public V maxmum() {
		return maxmum(this.root.key).value;
	}
	
	/**
	 * 红黑树的最小节点
	 * @return
	 */
	public V minmum() {
		return minmum(this.root.key).value;
	}
	
	/**
	 * 某个子树的最小节点
	 * @param key
	 * @return
	 */
	public Element<V> minmum(int key) {
		Element<V> keyEle = searchEle(key);
		if(keyEle == null) {
			return null;
		}
		this.rootClone = keyEle;
		while(rootClone.left != nil) {
			rootClone = rootClone.left;
		}
		Element<V> tmp = rootClone;
		setRootClone();
		return tmp;
	}
	
	/**
	 * 某个子树的最大节点
	 * @param key
	 * @return
	 */
	public Element<V> maxmum(int key) {
		Element<V> keyEle = searchEle(key);
		if(keyEle == null) {
			return null;
		}
		this.rootClone= keyEle;
		while(rootClone.right != nil) {
			rootClone = rootClone.right;
		}
		Element<V> tmp = rootClone;
		setRootClone();
		return tmp;
	}
	
	public V search(int key) {
		return searchEle(key).value;
	}
	
	/**
	 * 依照靠近根节点的节点左旋
	 */
	public void leftRotate(int key) {
		Element<V> keyEle = searchEle(key);
		Element<V> tmpRight = keyEle.right;
		if(keyEle.right == nil || keyEle == null) {
			return;
		}
		if(tmpRight.left != nil) {
			tmpRight.left.parent = keyEle;
		}
		tmpRight.parent = keyEle.parent;
		if(keyEle.parent == nil) {
			this.root = tmpRight;
			setRootClone();
		} else if(keyEle == tmpRight.parent.left) {
			keyEle.parent.left = tmpRight;
		} else {
			keyEle.parent.right = tmpRight;
		}
		tmpRight.left = keyEle;
		keyEle.parent = tmpRight;
	}
	
	/**
	 * 依照远离根节点的节点右旋
	 * @param key
	 */
	public void rightRotate(int key) {
		Element<V> keyEle = searchEle(key);
		if(keyEle == nil || keyEle == null) {
			return ;
		}
		Element<V> tmpEle = keyEle.parent;
		
		tmpEle.left = keyEle.right;
		if(tmpEle == this.root) {
			this.root = keyEle;
			setRootClone();
		}
		keyEle.parent = tmpEle.parent;
		keyEle.right = tmpEle;
		tmpEle.parent = keyEle;
	}
	
	public void iterator() {
		Arrays.asList(arr).stream().forEach(x -> {
			System.out.println(x.value);
		});
	}
	
	/**
	 * 通过Key查照对应的element
	 * @param key
	 */
	public Element<V> searchEle(int key) {
		while(rootClone != null && rootClone.key != key) {
			if(rootClone.key < key) {
				rootClone = rootClone.right;
			} else {
				rootClone = rootClone.left;
			}
		}
		RedBlackTree<V>.Element<V> tmp = rootClone;
		setRootClone();
		return tmp;
	}
	
	public void setRootClone() {
		this.rootClone = this.root;
	}
	
	/**
	 * 节点元素
	 * 包含左右子节点,父节点, key-value键值对,红黑色(false为默认,黑色)
	 * @author cosy-sun
	 *	
	 * @param <V>
	 */
	@SuppressWarnings("hiding")
	class Element<V> {
		public int key = 0;
		public V value = null;
		public Element<V> left = null;
		public Element<V> right = null;
		public Element<V> parent = null;
		public boolean color  = false;//默认false为黑色
		
		public V getValue() {
			return this.value;
		}
		
	}
	
}

