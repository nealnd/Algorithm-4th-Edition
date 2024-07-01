package Exercise1_3;

import java.util.Stack;
import edu.princeton.cs.algs4.*;

public class Exercise1_3_2 {
    
    public static void main(String[] args) {
        Stack<String> a = new Stack<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                a.push(item);
            else if (!a.isEmpty())
                StdOut.print(a.pop() + " ");

        }
        StdOut.println("(" + a.size() + " left on stack)");
    }
    
    


}
// was best times of the was the it (1 left on stack)