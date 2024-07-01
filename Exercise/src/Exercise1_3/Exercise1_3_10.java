package Exercise1_3;
import edu.princeton.cs.algs4.Stack;

public class Exercise1_3_10 {
    public static void main(String[] args) {
        
        String s = "((1+2)*((3-4)*(5-6)))";
        Stack<String> cha = new Stack<>();
        Stack<String> opr = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '/' || s.charAt(i) == '*')
                opr.push(s.charAt(i) + "");
            else if (s.charAt(i) == ')') {
                String temp1 = cha.pop();
                String temp2 = opr.pop();
                String temp3 = cha.pop();
                cha.push(temp3 + temp1 + temp2);
            }
            else if(s.charAt(i)=='('){}
            else
                cha.push(s.charAt(i) + "");

        }
        System.out.println(cha);


    }
}
