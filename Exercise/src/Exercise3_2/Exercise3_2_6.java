package Exercise3_2;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Exercise3_2_6<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int size;
        private int height;

        public Node(Key key, Value val, int size,int height) {
            this.key = key;
            this.val = val;
            this.size = size;
            this.height=height;
        }
    }

    public Exercise3_2_6() {

    }

    private int size(Node x) {
        if (x == null)
            return 0;
        else
            return x.size;
    }

    public int size() {
        return size(root);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private Value get(Node x, Key key) {
        if (key == null)
            throw new IllegalArgumentException("calls get() with a null key");
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return get(x.left, key);
        else if (cmp > 0)
            return get(x.right, key);
        else
            return x.val;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Node min(Node x) {
        if (x.left == null)
            return x;
        else
            return min(x.left);
    }

    public Key min() {
        if (isEmpty())
            throw new NoSuchElementException("calls min() with empty symbol table");
        return min(root).key;
    }

    private Node max(Node x) {
        if (x.right == null)
            return x;
        else
            return max(x.right);
    }

    public Key max() {
        if (isEmpty())
            throw new NoSuchElementException("calls max() with empty symbol table");
        return max(root).key;
    }

    private Node deleteMin(Node x) {
        if (x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        x.height=Math.max(height(x.left),height(x.right))+1;
        return x;
    }

    public void deleteMin() {
        if (isEmpty())
            throw new NoSuchElementException("Symbol table underflow");
        root = deleteMin(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null)
            return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        x.height=Math.max(height(x.left),height(x.right))+1;
        return x;
    }

    public void deleteMax() {
        if (isEmpty())
            throw new NoSuchElementException("Symbol table underflow");
        root = deleteMax(root);

    }

    private Node delete(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = delete(x.left, key);
        else if (cmp > 0)
            x.right = delete(x.right, key);
        else {
            if (x.right == null)
                return x.left;
            if (x.left == null)
                return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        x.height=Math.max(height(x.left),height(x.right))+1;
        
        return x;
    }

    public void delete(Key key) {
        if (key == null)
            throw new IllegalArgumentException("calls delete() with a null key");
        root = delete(root, key);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null)
            return new Node(key, val, 1,1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, val);
        else if (cmp > 0)
            x.right = put(x.right, key, val);
        else
            x.val = val;
        x.size = 1 + size(x.left) + size(x.right);
        x.height=Math.max(height(x.left),height(x.right))+1;
        return x;
    }

    public void put(Key key, Value val) {
        if (key == null)
            throw new IllegalArgumentException("calls put()with a null key");
        if (val == null) {
            delete(key);
            return;
        }
        root = put(root, key, val);
    }

    public boolean contains(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    private Node floor(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)
            return x;
        if (cmp < 0)
            return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null)
            return t;
        else
            return x;
    }

    public Key floor(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to floor() is null");
        if (isEmpty())
            throw new NoSuchElementException("calls floor() with empty symbol table");
        Node x = floor(root, key);
        if (x == null)
            throw new NoSuchElementException("argument to floor() is too small");
        else
            return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)
            return x;
        if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null)
                return t;
            else
                return x;
        }
        return ceiling(x.right, key);
    }

    public Key ceiling(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to ceiling() is null");
        if (isEmpty())
            throw new NoSuchElementException("calls ceiling() with empty symbol table");
        Node x = ceiling(root, key);
        if (x == null)
            throw new NoSuchElementException("argument to ceiling() is too large");
        else
            return x.key;
    }

    private Key select(Node x, int rank) {
        if (x == null)
            return null;
        int leftSize = size(x.left);
        if (leftSize > rank)
            return select(x.left, rank);
        else if (leftSize < rank)
            return select(x.right, rank - leftSize - 1);
        else
            return x.key;
    }

    public Key select(int rank) {
        if (rank < 0 || rank >= size()) {
            throw new IllegalArgumentException("argument to select() is invalid: " + rank);
        }
        return select(root, rank);
    }

    private int rank(Key key, Node x) {
        if (x == null)
            return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return rank(key, x.left);
        else if (cmp > 0)
            return 1 + size(x.left) + rank(key, x.right);
        else
            return size(x.left);
    }

    public int rank(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to rank() is null");
        return rank(key, root);
    }

    public Iterable<Key> keys() {
        if (isEmpty())
            return new Queue<Key>();
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null)
            throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null)
            throw new IllegalArgumentException("Second argument to keys() is null");
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null)
            return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0)
            keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0)
            queue.enqueue(x.key);
        if (cmphi > 0)
            keys(x.right, queue, lo, hi);
    }

    public int size(Key lo, Key hi) {
        if (lo == null)
            throw new IllegalArgumentException("first argument to size() is null");
        if (hi == null)
            throw new IllegalArgumentException("second argument to size() is null");
        if (lo.compareTo(hi) > 0)
            return 0;
        if (contains(hi))
            return rank(hi) - rank(lo) + 1;
        else
            return rank(hi) - rank(lo);
    }

    public int height() {
        return height(root);
    }

    private int height(Node x) {
        if (x == null)
            return 0;
        return x.height;
    }

    public Iterable<Key> levelOrder() {
        Queue<Key> keys = new Queue<Key>();
        Queue<Node> queue = new Queue<Node>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node x = queue.dequeue();
            if (x == null)
                continue;
            keys.enqueue(x.key);
            queue.enqueue(x.left);
            queue.enqueue(x.right);

        }
        return keys;
    }

    public static void main(String[] args) {
        Exercise3_2_6<Character, Integer> st = new Exercise3_2_6<>();
        String s = "EASYQUESTION";
        for (int i = 0; i < s.length(); i++) {
            st.put(s.charAt(i), i + 1);
        }
        for (Character item : st.levelOrder())
            StdOut.println(item + " " + st.get(item));
        StdOut.println();

        for (Character item : st.keys())
            StdOut.println(item + " " + st.get(item));

        StdOut.println();

        
        StdOut.println("size: "+st.size());
        StdOut.println("height: "+st.height());
        StdOut.println("min: " + st.min());
        StdOut.println("max: " + st.max());
        StdOut.println("floor: " + st.floor('G'));
        StdOut.println("ceiling: " + st.ceiling('G'));
        StdOut.println("select: " + st.select(3));
        StdOut.println("rank: " + st.rank('N'));
        st.delete('N');
        StdOut.println("After delete N, the tree: ");
        for (Character item : st.levelOrder())
            StdOut.println(item + " " + st.get(item));
        StdOut.println();

        StdOut.println("After delete min,the tree: ");
        st.deleteMin();
        for (Character item : st.levelOrder())
            StdOut.println(item + " " + st.get(item));
        StdOut.println();

        StdOut.println("After delete max,the tree: ");
        st.deleteMax();
        for (Character item : st.levelOrder())
            StdOut.println(item + " " + st.get(item));
        StdOut.println();

    }
}
