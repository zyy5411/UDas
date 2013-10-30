package datastructure.trees;

public class Tree {

	public enum SearchOrder {
		PREORDER, MIDORDER, POSTORDER
	}

	public TreeNode root;

	/**
	 * 
	 * @param str �������������ַ�����ʹ�ö��ź����ţ����ֺͷ���֮���ÿո�ֿ�
	 */
	public Tree(String str) {
		TreeConstruct sr = new TreeConstruct(str);
		root = new TreeNode(sr, null);
	}

	/**
	 * �ÿ��Զ����TreePrinter�������
	 * @param printer
	 */
	public void printTree(TreePrinter printer) {
		printer.print(this);
	}

	/**
	 * ���Դ��ķ�ʽ�����
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
