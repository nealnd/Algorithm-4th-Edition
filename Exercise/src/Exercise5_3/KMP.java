package Exercise5_3;

import edu.princeton.cs.algs4.StdOut;

public class KMP {
    private final int R;
    private final int m;
    private int[][] dfa;

    public KMP(String pat) {
        this.R = 256;
        this.m = pat.length();

        dfa = new int[R][m];
        dfa[pat.charAt(0)][0] = 1;
        for (int x = 0, j = 1; j < m; j++) {
            for (int c = 0; c < R; c++)
                dfa[c][j] = dfa[c][x];
            dfa[pat.charAt(j)][j] = j + 1;
            x = dfa[pat.charAt(j)][x];
        }
    }

    public int search(String txt) {
        int n = txt.length();
        int i, j;
        for (i = 0, j = 0; i < n && j < m; i++)
            j = dfa[txt.charAt(i)][j];
        if (j == m)
            return i - m;
        return n;
    }

    public KMP(char[] pattern, int R) {
        this.R = R;
        this.m = pattern.length;

        // build DFA from pattern
        int m = pattern.length;
        dfa = new int[R][m];
        dfa[pattern[0]][0] = 1;
        for (int x = 0, j = 1; j < m; j++) {
            for (int c = 0; c < R; c++)
                dfa[c][j] = dfa[c][x]; // Copy mismatch cases.
            dfa[pattern[j]][j] = j + 1; // Set match case.
            x = dfa[pattern[j]][x]; // Update restart state.
        }
    }
    
    public int search(char[] text) {

        // simulate operation of DFA on text
        int n = text.length;
        int i, j;
        for (i = 0, j = 0; i < n && j < m; i++) {
            j = dfa[text[i]][j];
        }
        if (j == m) return i - m;    // found
        return n;                    // not found
    }

    public static void main(String[] args) {
        String pat = "ABABAC";
        String txt = "BCBAABACAABABACAA";
        KMP kmp1 = new KMP(pat);
        int offset1 = kmp1.search(txt);
        StdOut.println("text:    " + txt);

        StdOut.print("pattern: ");
        for (int i = 0; i < offset1; i++)
            StdOut.print(" ");
        StdOut.println(pat);
    }
}
