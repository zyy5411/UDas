package datastructure.trees;

public class Tree {

	public TreeNode root;

	/**
	 * 
	 * @param str �������������ַ�����ʹ�ö��ź����ţ����ֺͷ���֮���ÿո�ֿ�
	 */
	public Tree(String str) {
		StringReader sr = new StringReader(str);
		root = new TreeNode(sr, null);
	}

	public void printByMidOrder() {
		root.printByMidOrder();
		System.out.println();
	}

	public boolean isEmpty() {
		return root == null;
	}

	public static void main(String[] args) {
		Tree t = new Tree("8(8(9,2(4,7)),7)");
		t.printByMidOrder();
	}
}
