public class FIFOQueue implements Queue {
    
    private Queue<Integer> queue = new Queue<>();
    
    public void add(int value) {
        queue.add(value);
    }
    // verwijder een item uit de FIFO queue
    public int remove(int index) {
    }
        
    
    public int peek() {
        return queue.peek();
    }
   
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    
    public int size() {
        return queue.size();
    }
    
    public void print() {
        for (int number : queue) {
            System.out.println(number);
        }
    }
    
    public void clear() {
        queue.clear();
    }
 
    public void clear(int n) {
        for (int i = 0; i < n; i++) {
            queue.poll();
        }
    }
    
    public void printReverse() {
        for (int i = queue.size() - 1; i > 0; i--) {
            System.out.println(queue.get(i));
        }
    }
    // plaats een element op een bepaalde positie in de FIFO queue
    public void jumpTheQueue(int n, int value);
    // Zet de FIFO queue om naar een String
    public String toString() {
        
    }
    // Kijk of de FIFO queue gelijk is aan een andere FIFO queue
    public boolean equals(Queue q);

    public int indexOf(int value) {
        return queue.indexOf(value);
    }
    
    public int lastIndexOf(int value) {
        return queue.lastIndexOf(value);
    }
    
}