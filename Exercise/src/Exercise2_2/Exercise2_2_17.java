package Exercise2_2;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class Exercise2_2_17 {

    private static class LinkedList<Item> implements Iterable<Item> {
        private class Node {
            Item item;
            Node next;

            Node(Item item) {
                this.item = item;
            }

        }

        private int size;
        private Node first;

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void add(Item item) {
            Node newnode = new Node(item);
            newnode.next = first;
            first = newnode;
            size++;
        }

        public Iterator<Item> iterator() {
            return new ListIterator(first);

        }

        private class ListIterator implements Iterator<Item> {
            Node current;

            public ListIterator(Node first) {
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

    }

    private static class MergeResult {
        LinkedList<Comparable>.Node newlo;
        LinkedList<Comparable>.Node newhi;
        LinkedList<Comparable>.Node afterlast;

        public MergeResult(LinkedList<Comparable>.Node newlo,
                LinkedList<Comparable>.Node newhi, LinkedList<Comparable>.Node afterlast) {
            this.newlo = newlo;
            this.newhi = newhi;
            this.afterlast = afterlast;
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static MergeResult merge(LinkedList<Comparable>.Node lo,
            LinkedList<Comparable>.Node mid,
            LinkedList<Comparable>.Node hi) {
        LinkedList<Comparable>.Node aux;
        LinkedList<Comparable>.Node i = lo, j = mid.next;
        LinkedList<Comparable>.Node newlo, newhi, afterlast;
        afterlast = hi.next;

        if (less(j.item, i.item)) {
            newlo = j;
            aux = j;
            j = j.next;
        } else {
            newlo = i;
            aux = i;
            i = i.next;
        }

        while (i != mid.next && j != hi.next) {
            if (less(j.item, i.item)) {
                aux.next = j;
                aux = j;
                j = j.next;
            } else {
                aux.next = i;
                aux = i;
                i = i.next;
            }

        }
        if (i == mid.next) {
            aux.next = j;//this is important
            newhi = hi;

        } else {
            aux.next = i;
            newhi = mid;
            mid.next = afterlast;//this is important

        }
        return new MergeResult(newlo, newhi, afterlast);

    }

    public static LinkedList<Comparable>.Node FindKey(LinkedList<Comparable>.Node current) {
        while (current.next != null) {
            if (less(current.next.item, current.item))
                return current;
            current = current.next;
        }
        return current;

    }

    public static void sort(LinkedList<Comparable> a) {

        LinkedList<Comparable>.Node lo;
        LinkedList<Comparable>.Node mid, hi;

        lo = a.first;

        while (a.size > 0) {
            mid = FindKey(lo);
            if (mid.next == null) {
                if (lo == a.first)//the linkedlist is sorted
                    break;
                else {
                    lo = a.first;//important
                    continue;
                }
            } else {
                hi = FindKey(mid.next);
                MergeResult m = merge(lo, mid, hi);
                hi = m.newhi;
                if (lo == a.first)//means that a.first might be not correct and need change
                    a.first = m.newlo;

                 //show(a);
                if (hi.next == null) {
                    lo = a.first;
                } else
                    lo = hi.next;

            }

        }

    }

    private static void show(LinkedList<Comparable> a) {
        // StdOut.print(a + " /");
        for (Comparable item : a)
            StdOut.print(item + " ");
        StdOut.println();
    }

    public static void main(String[] args) {
        LinkedList<Comparable> a = new LinkedList<>();
        a.add(5);
        a.add(3);
        a.add(6);
        a.add(2);
        a.add(1);
        a.add(4);
        a.add(9);
        a.add(8);
        a.add(7);
        show(a);
        sort(a);
        show(a);

    }

}
