package datastructure.trees;

/**
 * use for tree's construct.
	data's format is like: "1(2(4,5(7,)),3(,6))"
 * @author zyy
 */
class TreeConstruct {
	String data;
	int index;

	public TreeConstruct(String data) {
		this.data = data;
		index = 0;
	}

	public String peepNextChar() {
		if (!hasNext())
			return "";
		return "" + data.charAt(index);
	}

	public String nextChar() {
		if (!hasNext())
			return "";
		return "" + data.charAt(index++);
	}

	public int nextInt() throws Exception {
		if (!hasNext())
			throw new Exception("end");
		char c = data.charAt(index);
		String next = "";
		while (hasNext() && c >= '0' && c <= '9') {
			next += c;
			c = data.charAt(++index);
		}
		return Integer.parseInt(next);
	}

	public String next() throws Exception {
		if (!hasNext())
			throw new Exception("end");
		char c = data.charAt(index);
		String next = "";
		if (c < '0' || c > '9') {
			index++;
			next += c;
		} else {
			while (hasNext() && c > '0' && c < '9') {
				next += c;
				c = data.charAt(++index);
			}
		}
		return next;
	}

	void print() {
		System.out.println(data.substring(index));
	}

	public boolean hasNext() {
		if (index < data.length())
			return true;
		return false;
	}
}