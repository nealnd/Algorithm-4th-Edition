package Exercise1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleNode<Item> {

    private static class Node<Item> {
        private Item item;
        private Node next;
        private Node previous;
    }

    private Node first;
    private Node last;

    public static <Item> Node<Item> creatNode(Item item) {
        Node a = new Node();
        a.item = item;
        return a;

    }

    // assume that a is not linked to any node
    public void HeadInsert(Node a) {

        if (first == null) {
            first = a;
            last = a;
            first.next = null;
            first.previous = null;
       

        } else if (first.next == null) {
            first = a;
            first.next = last;
            last.previous = first;

        } else {
            Node temp = first;
            first=a;
            first.previous = null;
            first.next = temp;
            temp.previous = first;
        }

    }

    // assume a is not linked to any node
    public void TailInsert(Node a) {
        if (first == null) {
            first = a;
            last = a;
            first.next = null;
            first.previous = null;

        } else if (first.next == null) {

            last = a;
            first.next = last;
            last.previous = first;
        } else {
            Node temp = last;
            last = a;
            last.next = null;
            temp.next = last;
            last.previous = temp;
        }
    }

    public void HeadDelete() {
        if (first == null)
            throw new NoSuchElementException();

        else if (first.next == null) {
            first = null;
            // last = null;

        }

        else {
            Node temp = first;
            first = first.next;
            temp = null;
        }

    }

    public void TailDelete() {
        if (last == null)
            throw new NoSuchElementException();

        else if (last.previous == null) {
            first = null;
            
        } else {
            Node temp = last;
            last = last.previous;
            temp = null;
        }
    }

    // assume a exists in the DoubleNode
    public void NodeBeforeInsert(Node a, Node b) {
        if (first == a) {
            HeadInsert(b);
        } else {
            Node temp = a.previous;
            temp.next = b;
            b.previous = temp;
            b.next = a;
            a.previous = b;
        }
    }

    // assume a exists in the DoubleNode
    public void NodeBeforeDelete(Node a) {
        if (first == a) {
            throw new NoSuchElementException();
        } else if (a.previous == first) {
            Node temp = first;
            first = a;
            temp = null;
        }

        else {
            Node temp = a.previous;
            temp.previous.next = a;
            a.previous = temp.previous;
            temp = null;
        }
    }

    // assume a exists in the doublemode
    public void NodeAfterInsert(Node a, Node b) {
        if (last == a) {
           TailInsert(b);

        }

        else {
            Node temp = a.next;
            temp.previous = b;
            b.next = temp;
            a.next = b;
            b.previous = a;
        }
    }

    public void NodeAfterDelete(Node a) {
        if (last == a) {
           throw new NoSuchElementException();
       } 
       else if (a.next == last) {
           last = a;
           a.next = null;

            
        }else {
            Node temp = a.next;
            temp.next.previous = a;
            a.next = temp.next;
            temp = null;
        }
    }

    // assume a exists in the doublenode
    public void NodeDelete(Node a) {
        if (first == a) {
            HeadDelete();

        } 
        else if(last==a)
        {
            TailDelete();
        } 
        else {
            Node temp = a.previous;
            temp.next = a.next;
            a.next.previous = temp;
            a = null;
        }
    }

    public static void main(String[] args) {
        DoubleNode<Integer> a = new DoubleNode<>();
        Node n1 = a.creatNode(1);
        a.HeadInsert(n1);
        
        Node n2 = a.creatNode(2);
        Node n3 = a.creatNode(3);
        Node n4 = a.creatNode(4);
        a.NodeAfterInsert(n1, n2);
        a.TailInsert(n3);
        a.TailInsert(n4);
        for (Node x = a.first; x != null; x = x.next) {
            System.out.println(x.item);
        }
        a.NodeAfterDelete(n1);
        for (Node x = a.first; x != null; x = x.next) {
            System.out.println(x.item);
        }
        a.NodeBeforeDelete(n4);
        for (Node x = a.first; x != null; x = x.next) {
            System.out.println(x.item);
        }

    }

}
