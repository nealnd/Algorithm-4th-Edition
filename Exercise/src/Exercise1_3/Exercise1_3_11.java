package Exercise1_3;

import edu.princeton.cs.algs4.Stack;

public class Exercise1_3_11 {
    public static void main(String[] args) {
        String s = "12+34-56-**";
        Stack<Integer>in=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if (s.charAt(i) == '+') {
                int temp1 = in.pop();
                int temp2 = in.pop();
                in.push(temp1 + temp2);

            } else if (s.charAt(i) == '-') {
                int temp1 = in.pop();
                int temp2 = in.pop();
                in.push(temp2 - temp1);
            } else if (s.charAt(i) == '*') {
                int temp1 = in.pop();
                int temp2 = in.pop();
                in.push(temp1 * temp2);
            } else if (s.charAt(i) == '/') {
                int temp1 = in.pop();
                int temp2 = in.pop();
                in.push(temp2 / temp1);
            } else
                in.push(Character.getNumericValue(s.charAt(i)));
        }
        System.out.println(in);
    }
}
