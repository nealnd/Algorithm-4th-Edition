package Exercise1_3;

import java.util.Scanner;


public class Exercise1_3_15 {
    
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        Queue_Array<String> queue = new Queue_Array<>();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext())
        {
            queue.enqueue(scanner.next());
        }
        int N = queue.size();
        for(int i=0;i<N-k;i++)
        {
            queue.dequeue();
        }
        System.out.println(queue.dequeue());
    }
}
