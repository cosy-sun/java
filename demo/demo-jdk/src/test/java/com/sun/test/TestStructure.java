package com.sun.test;

import java.util.Arrays;
import java.util.UUID;

import org.junit.Test;

import com.sun.structure.Queue;
import com.sun.structure.Stack;
import com.sun.structure.binaryTree.BinaryTree;
import com.sun.structure.binaryTree.ExtendsIntee;
import com.sun.structure.dymaicprograming.LongestCommonSubsequene;

public class TestStructure{

	@Test
	public void lcs() {
		String a = "sunzhenhuaaaa111";
		String b = "sunzhhuaenhuaaaa";
		LongestCommonSubsequene lcs = new LongestCommonSubsequene();
		int[][] findLcs = lcs.findLcs(a, b);
		lcs.backtracking(a, b, findLcs);
		lcs.findContinueLcs(a, b);
	}
	
	@Test
	public void binaryTree() {
		BinaryTree<ExtendsIntee, String> binaryTree = new BinaryTree<>();
//		ExtendsIntee test0 = new ExtendsIntee(1);
//		ExtendsIntee test1 = new ExtendsIntee(2);
//		ExtendsIntee test2 = new ExtendsIntee(3);
//		binaryTree.insert(test1, "test1");
//		binaryTree.insert(test0, "test0");
//		binaryTree.insert(test2, "test2");
		for(int i = 0; i < 10000; i ++) {
			UUID randomUUID = UUID.randomUUID();
			String sequence = randomUUID.toString().replaceAll("-", "").substring(25);
			int parseInt = Integer.parseInt(sequence, 16);
//			System.out.println(parseInt + "   "+ String.valueOf(i));
			binaryTree.insert(new ExtendsIntee(parseInt), String.valueOf(i));
			
		}
//		System.out.println(binaryTree.successor(test0).getValue());
//		System.out.println(binaryTree.successor(test1).getValue());
//		System.out.println(binaryTree.successor(test2));
//		System.out.println(binaryTree.getRoot());
//		binaryTree.delete(test0);
//		System.out.println(binaryTree.getRoot());
		binaryTree.traver();
		
	}
	
	@Test
	public void queue() {
		Queue<TestStructure> queue = new Queue<>();
		for(int i = 0; i < 10; i ++) {
			queue.enqueue(new TestStructure());
			System.out.println(queue.size());
			System.out.println(Arrays.toString(queue.getQueue()));
		}
		System.out.println(queue.dequeue());
		queue.clear();
		System.out.println(Arrays.toString(queue.getQueue()));
		
	}
	
	@Test
	public void stack() {
		Stack<TestStructure> stack = new Stack<>();
		stack.push(new TestStructure());
		stack.push(new TestStructure());
		stack.push(new TestStructure());
		stack.push(new TestStructure());
		System.out.println(Arrays.toString(stack.get()));
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println(Arrays.toString(stack.get()));
		stack.clear();
		System.out.println(Arrays.toString(stack.get()));
	}
}
