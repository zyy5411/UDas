package datastructure.trees;

import java.util.Stack;

/**
 * 树的遍历算法
 * 提供静态方法，返回实现了TreePrinter接口的类
 * @author zyy
 *
 */
public class TreePrintAlgorithm {
	public static TreePrinter preOrderAlgorithm() {
		return new TreePrinter() {
			@Override
			public void print(Tree tree) {
				TreeNode root = tree.root;
				if (null == root)
					return;
				System.out.println("\n前序遍历");
				Stack<TreeNode> stack = new Stack<TreeNode>();
				TreeNode node = root;
				stack.push(node);
				System.out.print(" " + node.data);
				while (!stack.isEmpty()) {
					while (null != node.left) {
						node = node.left;
						stack.push(node);
						System.out.print(" " + node.data);
					}
					while (null == node.right) {
						if (stack.isEmpty())
							return;
						node = stack.pop();
					}
					node = node.right;
					stack.push(node);
					System.out.print(" " + node.data);
				}
			}
		};
	}

	public static TreePrinter midOrderAlgorithm() {
		return new TreePrinter() {
			@Override
			public void print(Tree tree) {
				TreeNode root = tree.root;
				if (null == root)
					return;
				System.out.println("\n中序遍历");
				Stack<TreeNode> stack = new Stack<TreeNode>();
				stack.push(root);
				TreeNode node = root;
				while (true) {
					while (null != node.left) {
						node = node.left;
						stack.push(node);
					}
					while (null == node.right) {
						if (stack.isEmpty())
							return;
						node = stack.pop();
						System.out.print(" " + node.data);
					}
					node = node.right;
					stack.push(node);
				}
			}
		};
	}

	public static TreePrinter postOrderAlgorithm() {
		return new TreePrinter() {

			@Override
			public void print(Tree tree) {
				TreeNode root = tree.root;
				if (null == root)
					return;
				System.out.println("\n后序遍历");
				Stack<TreeNode> leftNodes = new Stack<TreeNode>();
				Stack<TreeNode> inNodes = new Stack<TreeNode>();
				TreeNode node = root;
				leftNodes.add(node);
				while (!leftNodes.isEmpty()) {
					while (null != node.left) {
						node = node.left;
						leftNodes.add(node);
					}
					while (true) {
						if (leftNodes.isEmpty())
							return;
						node = leftNodes.pop();
						if (null != node.right) {
							if (!inNodes.isEmpty() && node == inNodes.peek()) {
								inNodes.pop();
							} else {
								break;
							}
						}
						System.out.print(" " + node.data);
					}
					leftNodes.add(node);
					inNodes.add(node);
					node = node.right;
					leftNodes.add(node);
				}
			}
		};
	}

}
