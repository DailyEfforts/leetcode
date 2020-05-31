package algorithm._0111;

public class Solution {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.left = node5;
        Solution solution = new Solution();
        int miniDepth = solution.minDepth(node1);
        System.out.println("miniDepth: " + miniDepth);
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        MyQueue<TreeNode> q = new MyQueue<>();
        q.enqueue(root);

        int count = 0;
        while (!q.isEmpty()) {
            final int size = q.size();
            count++;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.dequeue();
                if (node.left != null) {
                    q.enqueue(node.left);
                }
                if (node.right != null) {
                    q.enqueue(node.right);
                }
                if (node.left == null && node.right == null) {
                    return count;
                }
            }
        }

        return 0;
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

        public class MyList<T> {
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
        }
    }

}
