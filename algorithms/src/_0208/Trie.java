package _0208;

/**
 * Implement a trie with insert, search, and startsWith methods.
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 */
class TrieNode {
    private static final int N = 'z' - 'a' + 1;

    char value;
    int count;

    TrieNode[] next;

    public TrieNode() {
        next = new TrieNode[N];
    }

    @Override
    public String toString() {
        return String.valueOf(value) + " : " + count;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void print() {
        print(root);
    }

    private void print(TrieNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            for (int i = 0; i < node.next.length; i++) {
                print(node.next[i]);
            }
        }
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        insert(word, root, 0);
    }

    private TrieNode insert(String word, TrieNode node, int depth) {
        if (node == null) {
            node = new TrieNode();
            node.value = word.charAt(depth - 1);
        }
        if (depth == word.length()) {
            node.count += 1;
            return node;
        } else {
            char c = word.charAt(depth);
            node.next[c - 'a'] = insert(word, node.next[c - 'a'], depth + 1);
        }
        return node;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = get(root, word, 0);
        return node != null && node.count > 0;
    }

    public TrieNode get(TrieNode node, String word, int depth) {
        if (node == null) {
            return null;
        }
        if (depth == word.length()) {
            return node;
        }
        char c = word.charAt(depth);
        return get(node.next[c - 'a'], word, depth + 1);
    }


    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return get(root, prefix, 0) != null;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc");
        System.out.println(trie.search("abc"));
        System.out.println(trie.search("ab"));
        trie.insert("ab");
        System.out.println(trie.search("ab"));
        trie.insert("ab");
        System.out.println(trie.search("ab"));
    }
}

