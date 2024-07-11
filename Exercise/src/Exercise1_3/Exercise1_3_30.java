package Exercise1_3;

public class Exercise1_3_30 {
    
    private class Node {
        int item;
        Node next;

        public Node(int item, Node next) {
            this.item = item;
            this.next = next;
        }

    }

    public Node reverse(Node x)
    {
        Node first = x;
        Node reverse = null;
        while (first != null)
        {
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        return reverse;

    }


    public static void main(String[] args) {

        Exercise1_3_30 test = new Exercise1_3_30();
        Node d = test.new Node(4,null);
        Node c = test.new Node(3, d);
        Node b = test.new Node(2, c);
        Node a = test.new Node(1, b);
        for(Node x=a;x!=null;x=x.next)
        {
            System.out.println(x.item);
        }
        a=test.reverse(a);
        for(Node x=a;x!=null;x=x.next)
        {
            System.out.println(x.item);
        }


    }

}
