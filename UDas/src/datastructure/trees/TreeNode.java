package datastructure.trees;

public class TreeNode {

	public int data;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;

	/**
	 * @param sr
	 * @param parent
	 */
	public TreeNode(TreeConstruct sr, TreeNode parent) {
		if (sr.hasNext()) {
			try {
				if (!sr.hasNext() || !isNumber(sr.peepNextChar().charAt(0))) {
					return;
				}
				data = sr.nextInt();
				if ("(".equals(sr.peepNextChar())) {
					String next = sr.nextChar();
					if ("(".equals(next)) {
						//�����Ƿ�������Ϊ��
						if (",".equals(sr.peepNextChar()))
							left = null;
						else
							left = new TreeNode(sr, this);

						if (!",".equals(sr.nextChar()))
							System.err.println("��ô���Ƕ���");

						//�����Ƿ�������Ϊ��
						if (")".equals(sr.peepNextChar()))
							right = null;
						else
							right = new TreeNode(sr, this);
						if (!")".equals(sr.nextChar()))
							System.err.println("��ô����������");

					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	boolean isNumber(char c) {
		return c <= '9' && c >= '0';
	}

	public void printByMidOrder() {
		if (left != null)
			left.printByMidOrder();
		System.out.print(data + "  ");
		if (right != null)
			right.printByMidOrder();
	}

	public void printByPreOrder() {
		System.out.print(data + "  ");
		if (left != null)
			left.printByMidOrder();
		if (right != null)
			right.printByMidOrder();
	}

	public void printByPostOrder() {
		if (left != null)
			left.printByMidOrder();
		if (right != null)
			right.printByMidOrder();
		System.out.print(data + "  ");
	}

}
