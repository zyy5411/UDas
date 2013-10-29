package datastructure.trees;

import java.util.Stack;

public class DFS {

	//�ǵݹ��DFS�㷨��ǰ�����
	void dfsByPre(TreeNode root) {
		if (null == root)
			return;
		System.out.println("\nǰ�����");
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

	//�ǵݹ��DFS�㷨���������
	void dfsByMid(TreeNode root) {
		if (null == root)
			return;
		System.out.println("\n�������");
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

	//�ǵݹ��DFS�㷨���������
	void dfsByPost(TreeNode root) {
		if (null == root)
			return;
		System.out.println("\n�������");
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

	public static void main(String[] args) {

		Tree t = new Tree("8(8(9,2(4(3,0),7)),7)");
		DFS dfs = new DFS();
		dfs.dfsByPre(t.root);
		dfs.dfsByMid(t.root);
		dfs.dfsByPost(t.root);
	}

}
