package Exercise1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

class Queue_Linked<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldlast.next = last;
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty())
            last = null;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
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
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    public static void main(String[] args) {
        Queue_Array<Integer> queue = new Queue_Array<>();
        queue.enqueue(1);
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