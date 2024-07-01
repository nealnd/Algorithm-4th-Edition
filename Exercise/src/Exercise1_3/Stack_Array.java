package Exercise1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack_Array<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    public boolean isEmpty()
    {
        return N == 0;
    }

    public int size()
    {
        return N;
    }

    public void resize(int max)
    {
        @SuppressWarnings("unchecked")
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;
    }
    
    public void push(Item item)
    {
        if (N == a.length)
            resize(2 * a.length);
        a[N++] = item;
    }

    public Item pop()
    {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");
        Item temp = a[--N];
        a[N] = null;
        if (N > 0 && N ==a.length / 4)
            resize(a.length / 2);
        return temp;
    }


    @Override
    public Iterator<Item> iterator() {
        // TODO Auto-generated method stub
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            return a[--i];
        }

        public void remove() {
        }

    }
    public static void main(String[] args) {
        Stack_Array<Integer> a = new Stack_Array<>();
        a.push(1);
        a.push(1);
        a.push(2);
        a.push(3);
        for (int i : a)
            System.out.println(i);
    }
}
