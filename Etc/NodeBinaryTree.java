
public class NodeBinaryTree {
	public static void main(String[] args) throws Exception {
		BinaryTree tree = new BinaryTree();
		tree.setRoot('A');
		tree.setLeft('A', 'B');
		tree.setRight('A', 'C');
		tree.setRight('C', 'D');
		tree.setLeft('B', 'E');
		tree.PreOrder();
		
		
		System.out.println(tree.search('A'));
	}

	static class BinaryTree {
		Node root;
		
		void PreOrder() {
			PreOrder(root);
		}
		void PreOrder(Node temp) {
			if(temp == null) {
				return;
			}
			System.out.print(temp.data + " ");
			PreOrder(temp.left);
			PreOrder(temp.right);
			
		}
		
		void setRoot(char data) {
			root = new Node(data);
		}

		void setLeft(char parent, char child) {
			Node temp = search(parent);
			if(temp != null) {
				temp.left = new Node(child);				
				return;
			}
		}

		void setRight(char parent, char child) {
			Node temp = search(parent);
			if(temp != null) {
				temp.right = new Node(child);				
				return;
			}
			System.out.println(parent + "가 음슴..");
		}
		
		Node search(char pdata) {
			return search(root,pdata);
		}

		Node search(Node temp, char pdata) {
			Node rst = null;
			if (temp != null) {
				if (temp.data == pdata) {
					return temp;
				}
				if (temp.left != null) {
					rst = search(temp.left, pdata);
				}
				if (rst == null && temp.right != null) {
					rst = search(temp.right, pdata);
				}
			}
			return rst;
		}
	}

	static class Node {
		char data;
		Node left;
		Node right;

		public Node(char data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
		}

	}
}
