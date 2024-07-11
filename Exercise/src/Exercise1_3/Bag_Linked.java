package Exercise1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag_Linked<Item> implements Iterable<Item> {
    private Node<Item> first;
    private int n;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public boolean isEmpty()
    {
        return first == null;
    }
public int size()
{
    return n;

}

public void add(Item item)
{
    Node oldfirst = first;
    first = new Node<>();
    first.item = item;
    first.next = oldfirst;
    n++;
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
            Item item = (Item) current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Bag_Linked<Integer> a = new Bag_Linked<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        for(Integer i:a)
        System.out.println(i);
        


    }
    
}
