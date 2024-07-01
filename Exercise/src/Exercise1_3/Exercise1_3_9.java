package Exercise1_3;

import edu.princeton.cs.algs4.Stack;

public class Exercise1_3_9 {

public static void main(String[] args) {
    String s = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
    Stack<String> cha = new Stack<>();
    Stack<String> opr = new Stack<>();
    String []c=s.split("\\s+");
    for(int i=0;i<c.length;i++)
    {
        if (c[i].equals("+") || c[i].equals("-" )  || c[i].equals("*" ) || c[i].equals("/")  )
            opr.push(c[i]);
        else if (c[i].equals(")")  ) {
            String temp1 = cha.pop();
            String temp2 = opr.pop();
            String temp3 = cha.pop();
            cha.push("(" + temp3 + temp2 + temp1 + ")");
        } else
            cha.push(c[i]);
    }

    System.out.println(cha);
}    
}
