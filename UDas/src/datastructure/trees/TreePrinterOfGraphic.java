package datastructure.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 在控制台图像化输出整棵树
 *
 */

public class TreePrinterOfGraphic implements TreePrinter {

	final int unitSize = 1;
	final String blankUnit;

	public TreePrinterOfGraphic() {
		String s = "";
		for (int i = 0; i < unitSize; i++)
			s += " ";
		blankUnit = s;
	}

	@Override
	public void print(Tree tree) {
		PrinterNode printRoot = createPrinterTree(tree.root);
		printByBFS(printRoot);
	}

	// 重新创建一个封装好的树
	PrinterNode createPrinterTree(TreeNode node) {
		if (null == node) {
			return null;
		}
		PrinterNode pnode = new PrinterNode(node);
		pnode.left = createPrinterTree(node.left);
		pnode.right = createPrinterTree(node.right);
		pnode.leftMaxLen = null == pnode.left ? 0 : pnode.left.leftMaxLen
				+ pnode.left.rightMaxLen + 1;
		pnode.rightMaxLen = null == pnode.right ? 0 : pnode.right.leftMaxLen
				+ pnode.right.rightMaxLen + 1;

		return pnode;
	}

	private void printByBFS(PrinterNode root) {
		Queue<PrinterNode> queue = new LinkedList<>();
		root.position = root.leftMaxLen + 1;
		queue.offer(root);
		queue.offer(null);
		while (!(queue.size() == 1 && (null == queue.peek()))) {
			printOneLineNode(queue);
		}
	}

	//输出一行的节点值
	private void printOneLineNode(Queue<PrinterNode> queue) {
		PrinterNode node;
		node = queue.poll();
		int lastPos = 0;
		List<PrinterNode> printPos = new LinkedList<>();
		StringBuilder line = new StringBuilder();
		while (null != node) {
			for (int i = 0; i < node.position - lastPos - 1; i++) {
				line.append(getBlankUnit());
			}
			line.append(getNodeUnit(node.node.data));
			printPos.add(node);
			lastPos = node.position;

			if (null != node.left) {
				queue.offer(node.left);
				node.left.position = Math.min(node.position - 1, node.position
						- node.left.rightMaxLen - 1);
			}
			if (null != node.right) {
				queue.offer(node.right);
				node.right.position = Math.max(node.position + 1, node.position
						+ node.right.leftMaxLen + 1);
			}
			node = queue.poll();
		}
		System.out.print(line.toString() + "\n");
		queue.offer(null);
		printLink(printPos);
	}

	//紧接着节点值的下一行，输出相应的链接"/"和"\"
	private void printLink(List<PrinterNode> pos) {
		int i = 1;
		StringBuilder line = new StringBuilder();
		while (!pos.isEmpty()) {
			//
			if (pos.get(0).position == i + 1 && null != pos.get(0).left) {
				line.append(getNodeUnit("/"));
			} else if (pos.get(0).position == i - 1) {
				if (null != pos.get(0).left)
					line.append(getNodeUnit("\\"));
				pos.remove(0);
			} else {
				line.append(getBlankUnit());
			}
			i++;
		}
		System.out.println(line.toString());
	}

	//一个空白单元块
	private String getBlankUnit() {
		return blankUnit;
	}

	//一个带值的单元块
	private String getNodeUnit(String data) {
		StringBuilder sb = new StringBuilder();
		int blankLen = unitSize - data.length();
		for (int i = blankLen; i > 0; i--) {
			sb.append(" ");
		}
		sb.insert(blankLen / 2, data);
		return sb.toString();
	}

	private String getNodeUnit(int data) {
		String d = String.format("%d", data);
		return getNodeUnit(d);
	}

	private class PrinterNode {
		int leftMaxLen, rightMaxLen, position;
		PrinterNode left, right;
		TreeNode node;

		public PrinterNode(TreeNode node) {
			this.node = node;
		}

		@Override
		public String toString() {
			String s = "";
			while (leftMaxLen-- > 0) {
				s += " ";
			}
			s += node.data;
			return s;
		}
	}

	public static void main(String[] args) {

		Tree t = new Tree("8(8(9,2(4,7)),7)");
		t.printTree(new TreePrinterOfGraphic());
	}

}
