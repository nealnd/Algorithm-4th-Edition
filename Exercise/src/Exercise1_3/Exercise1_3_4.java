package Exercise1_3;
import edu.princeton.cs.algs4.*;


public class Exercise1_3_4 {
    public static boolean Parentheses(String a )
    {

        Stack_Array<Character> b = new Stack_Array<>();
        for (int i = 0; i < a.length();i++) {
            if (a.charAt(i) == '(' || a.charAt(i) == '[' || a.charAt(i) == '{')
                b.push(a.charAt(i));
            else if (a.charAt(i) == ')') {
                char temp = b.pop();
                if (temp != '(')
                    return false;
            } else if (a.charAt(i)== ']') {
                char temp = b.pop();
                if (temp != '[')
                    return false;
            } else if (a.charAt(i) == '}') {
                char temp = b.pop();
                if (temp != '{')
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String a = new String("[()]{[]}(){()[]}");
        System.out.println(Parentheses(a));
    }
    
}
