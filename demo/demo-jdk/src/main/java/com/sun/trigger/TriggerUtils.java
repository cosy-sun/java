package com.sun.trigger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.structure.binaryTree.BinaryTree;

public class TriggerUtils {

//	public static void mapToDb(Map<String, Object> map) {
//		Map<String, TreeNode> data = (Map<String, TreeNode>) map.get("data");
//		TreeNode treeNode = (TreeNode) data.get(map.get("root"));
//	}
//	
//	public static String mapToExpression(Map<String, Object> map) {
//		StringBuilder builder= new StringBuilder();
//		@SuppressWarnings("unchecked")
//		Map<String, TreeNode> data = (Map<String, TreeNode>) map.get("data");
//		TreeNode treeNode = (TreeNode) data.get(map.get("root"));
//		parseMap(treeNode, data, builder, true);
//		return builder.toString();
//	}
//	
//	private static void parseMap(TreeNode treeNode, Map<String, TreeNode> map, StringBuilder builder, boolean isFirst) {
//		if(treeNode.getData() instanceof String) {
//			// caozuofu
//			List<TreeNode> subs = treeNode.getSubs();
//			builder.append("(");
//			for(int i =0;i < subs.size(); i ++) {
//				TreeNode tn = subs.get(i);
//				if(!(tn.getData() instanceof ConditionBean)) {
//					TreeNode parent2 = tn.getParent();
//					int hashCode = parent2.hashCode();
//					TreeNode parent = map.get(String.valueOf(hashCode));
//					builder.append(parent == null ? "":treeNode.getData());
//				}
//				parseMap(tn, map, builder, i == 0 ? true: false);
//			}
//			builder.append(")");
//		} else if (treeNode.getData() instanceof ConditionBean) {
//			ConditionBean bean = ((ConditionBean) treeNode.getData());
//			TreeNode parent2 = treeNode.getParent();
//			int hashCode = parent2.hashCode();
//			TreeNode parent = map.get(String.valueOf(hashCode));
//			StringBuilder stringBuilder = new StringBuilder();
//			stringBuilder
//				.append(isFirst? "" : parent.getData())
//				.append("(")
//				.append(bean.getLeft()).append(" ")
//				.append(bean.getOperator()).append(" ")
//				.append(bean.getRight())
//				.append(")")
//				;
//			builder.append(stringBuilder);
//		}
//		
//	}
//	
//	public static Map<String, Object> parseJsonToMap(String expression) {
//		JSONObject exprJson = JSONObject.parseObject(expression);
//		Map<String, TreeNode> hashMap = new HashMap<>();
//		String parse = parse(exprJson, hashMap, true, null);
//		HashMap<String, Object> hashMap2 = new HashMap<>();
//		hashMap2.put("root", parse);
//		hashMap2.put("data", hashMap);
//		return hashMap2;
//	}
//	
//	private static String parse(JSONObject json, Map<String, TreeNode> map, boolean isFirst, TreeNode parent) {
//		String root = null;
//		String condition = json.getString("condition");
//		JSONArray rules = json.getJSONArray("rules");
//		if(condition == null) {
//			// 条件表达式
//			ConditionBean javaObject = json.toJavaObject(ConditionBean.class);
//			TreeNode treeNode = new TreeNode(parent, javaObject, new ArrayList<>());
//			if(isFirst) {
//				root = String.valueOf(treeNode.hashCode());
//				map.put(String.valueOf(treeNode.hashCode()), treeNode);
//			} else {
//				map.put(String.valueOf(treeNode.hashCode()), treeNode);
//				parent.getSubs().add(treeNode);
//			}
//		} else {
//			TreeNode treeNode = new TreeNode(parent, condition, new ArrayList<>());
//			if(isFirst) {
//				root = String.valueOf(treeNode.hashCode());
//				map.put(String.valueOf(treeNode.hashCode()), treeNode);
//			} else {
//				map.put(String.valueOf(treeNode.hashCode()), treeNode);
//				parent.getSubs().add(treeNode);
//			}
//			for(Object o : rules) {
//				JSONObject js = (JSONObject) o;
//				parse(js, map, false, treeNode);
//			}
//		}
//		return root;
//		
//	}

	public static TriggerTree parseJsonToTree(String expression) {
		JSONObject exprJson = JSONObject.parseObject(expression);
		TriggerTree triggerTree = new TriggerTree();
		jsonToTree(exprJson, triggerTree, null);
		return triggerTree;
	}

	private static void jsonToTree(JSONObject json, TriggerTree triggerTree, TreeNode parent) {
		String condition = json.getString("condition");
		JSONArray rules = json.getJSONArray("rules");
		if (condition == null) {
			// 条件表达式
			ConditionBean javaObject = json.toJavaObject(ConditionBean.class);
			TreeNode treeNode = new TreeNode(parent, javaObject, new ArrayList<>());
			triggerTree.add(treeNode);
		} else {
			TreeNode treeNode = new TreeNode(parent, condition, new ArrayList<>());
			triggerTree.add(treeNode);
			for (Object o : rules) {
				JSONObject js = (JSONObject) o;
				jsonToTree(js, triggerTree, treeNode);
			}
		}
	}
	
	public static String treeToExpression(TriggerTree triggerTree) {
		StringBuilder builder = new StringBuilder();
		TreeNode root = triggerTree.getRoot();
		parseTree(root, root, builder, true);
		return builder.toString();
	}

	private static void parseTree(TreeNode treeNode, TreeNode root, StringBuilder builder, boolean isFirst) {
		if (treeNode.getData() instanceof String) {
			// caozuofu
			List<TreeNode> subs = treeNode.getSubs();
			builder.append("(");
			for (int i = 0; i < subs.size(); i++) {
				TreeNode tn = subs.get(i);
				if (!(tn.getData() instanceof ConditionBean)) {
					TreeNode parent = tn.getParent();
					builder.append(i ==0 ? "" : treeNode.getData());
				}
				parseTree(tn, root, builder, i == 0 ? true: false);
			}
			builder.append(")");
		} else if (treeNode.getData() instanceof ConditionBean) {
			ConditionBean bean = ((ConditionBean) treeNode.getData());
			TreeNode parent = treeNode.getParent();
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder
				.append(isFirst ? "" : parent.getData())
				.append("(")
				.append(bean.getLeft())
				.append(" ")
				.append(bean.getOperator())
				.append(" ")
				.append(bean.getRight())
				.append(")");
			builder.append(stringBuilder);
		}

	}

	public static void mapToTree(TreeNode treeNode, Map<String, TreeNode> map, BinaryTree<String, Object> tree) {

	}

}
