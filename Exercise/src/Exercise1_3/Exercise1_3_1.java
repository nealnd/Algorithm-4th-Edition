package Exercise1_3;

public class Exercise1_3_1 {
    public static class FixedCapacityStack<Item> {
        private Item[] a;
        private int N;

        @SuppressWarnings("unchecked")
        public FixedCapacityStack(int cap) {
            a = (Item[]) new Object[cap];
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public int size() {
            return N;
        }

        public boolean isFull() {
            return a.length == N;
        }

        public void push(Item item) {
            a[N++] = item;
        }

        public Item pop() {
            return a[--N];
        }

    }

    public static void main(String[] args) {
        
        FixedCapacityStack<Integer> a;
        a = new FixedCapacityStack<>(10);
        int[] b = {1,2,3,4,5,6,7,8,9,10};
        for (int i = 0; i < b.length; i++)
        {
            a.push(b[i]);
        }
        System.out.println(a.isFull());

    }

    
    
}
