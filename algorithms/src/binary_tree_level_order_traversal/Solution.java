package binary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null) {
			return ans;
		}
		MyQueue<TreeNode> q = new MyQueue<>();
		q.enqueue(root);
		while (!q.isEmpty()) {
			final int size = q.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.dequeue();
				list.add(node.val);
				if (node.left != null) {
					q.enqueue(node.left );
				}
				if (node.right != null) {
					q.enqueue(node.right);
				} 
			}
			ans.add(list);
		}
		return ans;
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node5 = new TreeNode(5);
		node1.left = node2;
		node1.right = node3;
		node3.right = node5;
		Solution solution = new Solution();
		System.out.println(solution.levelOrder(node1));
	}

	private class MyQueue<T> {
		private MyList<T> list = new MyList<>();
		private int size;

		public void enqueue(T val) {
			list.add(val);
			size++;
		}

		public T dequeue() {
			size--;
			return list.remove(0);
		}

		public T peek() {
			return list.get(0);
		}
		
		public boolean isEmpty() {
			return size == 0;
		}
		
		public int size() {
			return size;
		}
	}

	private class MyList<T> {
		private class Node {
			Node prev;
			T val;
			Node next;
			public Node(Node prev, T val, Node next) {
				this.prev = prev;
				this.val = val;
				this.next = next;
			}
		}

		private Node first;
		private Node last;
		private int size;

		public void add(T val) {
			Node oldLast = last;
			last = new Node(last, val, null);
			if (oldLast != null) {
				oldLast.next = last;
			}
			if (first == null) {
				first = last;
			}
			size++;
		}

		public void add(int index, T val) {
			if (index == size) {
				add(val);
			} else {
				Node x = node(index);
				Node newNode = new Node(x.prev, val, x);
				if (x.prev == null) {
					first = newNode;
				} else {
					x.prev.next = newNode;
				}
				x.prev = newNode;
				size++;
			}
		}

		public T remove(int index) {
			Node node = node(index);
			final T val = node.val;
			if (node.prev == null) {
				first = node.next;
			} else {
				node.prev.next = node.next;
			}
			if (node.next == null) {
				last = node.prev;
			} else {
				node.next.prev = node.prev;
			}
			size--;
			return val;
		}

		public T get(int index) {
			Node x = node(index);
			return x.val;
		}

		private Node node(int index) {
			int mid = size >> 1;
			if (index < mid) {
				Node x = first;
				for (int i = 0; i < index; i++) {
					x = x.next;
				}
				return x;
			} else {
				Node x = last;
				for (int i = size - 1; i > index; i--) {
					x = x.prev;
				}
				return x;
			}
		}
	}

}
