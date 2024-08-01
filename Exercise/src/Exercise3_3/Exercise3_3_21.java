package Exercise3_3;

import edu.princeton.cs.algs4.StdOut;

public class Exercise3_3_21 {
    public static void main(String[] args) {
        RedBlackBST<Character, Integer> st = new RedBlackBST<>();
        String s = "EASYQUTION";
        for (int i = 0; i < s.length(); i++) {
            st.put(s.charAt(i), i);
        }
        
        for (Character item : st.levelOrder())
            StdOut.println(item + " " + st.get(item));
        StdOut.println();

        for (Character item : st.keys())
            StdOut.println(item + " " + st.get(item));
    }
    
}
