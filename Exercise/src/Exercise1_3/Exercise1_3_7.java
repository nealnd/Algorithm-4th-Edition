package Exercise1_3;

import java.util.Iterator;

public class Exercise1_3_7 {
    public class Stack<Item> implements Iterable<Item> {

        private Item[] a = (Item[]) new Object[1];
        private int N = 0;

        public boolean isEmpty() {
            return N == 0;
        }

        public int size() {
            return N;
        }

        private void resize(int max) {
            Item[] temp = (Item[]) new Object[max];
            for (int i = 0; i < N; i++)
                temp[i] = a[i];
            a = temp;
        }

        public void push(Item item) {
            if (N == a.length)
                resize(2 * a.length);
            a[N++] = item;
        }

        public Item peek() {
            return a[N - 1];
        }

        public Item pop() {
            Item item = a[--N];
            a[N] = null;
            if (N > 0 && N == a.length / 4)
                resize(a.length / 2);
            return item;
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

    }

    public static void main(String[] args) {
        Exercise1_3_7 exercise = new Exercise1_3_7();
        Stack<Integer> a = exercise.new Stack<>();
        a.push(1);
        a.push(2);
        System.out.println(a.peek());
        a.push(3);
        System.out.println(a.peek());

        for (int i : a)
            System.out.println(i);

    }

}
