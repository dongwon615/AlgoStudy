
public class BinarySearchTree {
	public static void main(String[] args) {
		BST tree = new BST();
		tree.insert(9);
		System.out.println(tree.search(9));
		tree.insert(5);
		tree.insert(20);
		tree.insert(2);
		tree.insert(1);
		System.out.println(tree.search(2));
		System.out.println(tree.search(7));
		tree.inOrder();
	}

	static class BST {
		int[] tree = new int[65];

		void insert(int data) {
			int idx = 1;
			while (true) {
				// null값인게 0으로 했음 현재는...
				if (tree[idx] == 0) {
					tree[idx] = data;
					break;
				}
				if (tree[idx] == data) {
					break;
				}
				if (tree[idx] > data) {
					idx = idx * 2;
				} else {
					idx = idx * 2 + 1;

				}
			}
		}

		int search(int data) {
			int idx = 1;
			while (true) {
				// null값인게 0으로 했음 현재는...
				if (tree[idx] == 0) {
					return -1;
				}
				if (tree[idx] == data) {
					return idx;
				}
				if (tree[idx] > data) {
					idx = idx * 2;
				} else {
					idx = idx * 2 + 1;

				}
			}
		}

		void inOrder() {
			inOrder(1);
		}

		void inOrder(int i) {
			if (tree[i] == 0) {
				return;
			}
			if (tree[i * 2] != 0) {
				inOrder(i * 2);
			}
			System.out.print(tree[i] + " ");
			if (tree[i * 2 + 1] != 0) {
				inOrder(i * 2 + 1);
			}

		}
	}
}
