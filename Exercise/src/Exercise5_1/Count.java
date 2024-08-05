package Exercise5_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Count {
    private Count() {
    }

    public static void main(String[] args) {
        Alphabet alphabet = new Alphabet("ABCDR");
        final int R = alphabet.radix();
        int[] count = new int[R];
        In in = new In("Exercise\\lib\\algs4-data\\abra.txt");

        while (in.hasNextChar()) {
            char c = in.readChar();
            if (alphabet.contains(c))
                count[alphabet.toIndex(c)]++;
        }
        for (int c = 0; c < R; c++)
            StdOut.println(alphabet.toChar(c) + " " + count[c]);
    }
}
