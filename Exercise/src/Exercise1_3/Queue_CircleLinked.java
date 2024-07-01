package Exercise1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue_CircleLinked<Item>implements Iterable<Item> {
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return last== null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        if(isEmpty())
        {
            last = new Node();
            last.item = item;
            last.next = last;
        }
        else
        {
            Node temp = new Node();
            temp.item = item;
            temp.next = last.next;
            last.next = temp;
           
        }
        N++;
    }

    public Item dequeue() {
      

        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");
        Item item = last.next.item;
        last.next = last.next.next;
        if (last.next == last)//this is important
            last = null;
        N--;
        return item;
    }


    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator(last);
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node current;

        public LinkedIterator(Node first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.next.item;
            current = current.next;
            return item;
        }
    }
    public static void main(String[] args) {
        Queue_Array<Integer> queue = new Queue_Array<>();
   
        queue.enqueue(1);
        queue.dequeue();
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        for (Integer i : queue)
            System.out.println(i);
        queue.dequeue();
        for (Integer i : queue)
            System.out.println(i);

    }
    
}
