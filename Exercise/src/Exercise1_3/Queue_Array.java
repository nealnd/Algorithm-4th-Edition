package Exercise1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue_Array<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;
    private int first = 0;
    private int last = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
            temp[i] = a[(first + i) % a.length];// this is important
        a = temp;
        first = 0;
        last = N;
    }

    public void enqueue(Item item) {
        if (N == a.length)
            resize(2 * a.length);
        a[last++] = item;
        if (last == a.length)
            last = 0;// this is important
        N++;
    }

    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");
        Item temp = a[first];
        a[first] = null;
        N--;
        first++;
        if (N > 0 && N == a.length / 4)
            resize(a.length / 2);
        return temp;
    }

    public Item peek() {
        return a[first];
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;

        public boolean hasNext() {
            return i < N;
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = a[(i + first) % a.length];
            i++;
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
