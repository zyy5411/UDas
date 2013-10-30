package datastructure.trees;

public class Tree {

	public enum SearchOrder {
		PREORDER, MIDORDER, POSTORDER
	}

	public TreeNode root;

	/**
	 * 
	 * @param str 用来描述数的字符串，使用逗号和括号，数字和符号之间用空格分开
	 */
	public Tree(String str) {
		TreeConstruct sr = new TreeConstruct(str);
		root = new TreeNode(sr, null);
	}

	/**
	 * 用可自定义的TreePrinter来输出树
	 * @param printer
	 */
	public void printTree(TreePrinter printer) {
		printer.print(this);
	}

	/**
	 * 用自带的方式输出树
	 * @param orderType
	 */
	public void printTree(SearchOrder orderType) {

		switch (orderType) {
		case PREORDER:
			root.printByPreOrder();
			break;
		case MIDORDER:
			root.printByMidOrder();
			break;
		case POSTORDER:
			root.printByPostOrder();
			break;
		default:
			break;
		}
		System.out.println();
	}

	public boolean isEmpty() {
		return root == null;
	}

	public static void main(String[] args) {
		Tree t = new Tree("8(8(9,2(4,7)),7)");
		//		t.printTree(SearchOrder.MIDORDER);
		t.printTree(TreePrintAlgorithm.preOrderAlgorithm());
		t.printTree(TreePrintAlgorithm.midOrderAlgorithm());
		t.printTree(TreePrintAlgorithm.postOrderAlgorithm());
		t.printTree(new TreePrinterOfGraphic());
	}
}
