package Exercise1_3;
import edu.princeton.cs.algs4.*;

public class Exercise1_3_6 {
public static void main(String[] args) {
    Queue_Array<String>q=new Queue_Array<>();
    q.enqueue("a");
    q.enqueue("b");
    q.enqueue("c");
    for(String s:q)
        System.out.println(s);
    System.out.println("--------------------------");
    
    Stack_Array<String> stack = new Stack_Array<>();
    while(!q.isEmpty())
        stack.push(q.dequeue());
    while(!stack.isEmpty())
        q.enqueue(stack.pop());
    
        for(String s:q)
        System.out.println(s);
}
    
    
}
