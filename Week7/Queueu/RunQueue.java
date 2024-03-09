public class RunQueue {
    public static void main(String[] args) {
        FIFOQueue queue = new FIFOQueue();
        queue.add(3);
        queue.add(7);
        queue.add(4);
        queue.add(2);
        queue.add(13);
        queue.add(6);
        queue.add(11);
        queue.clear();
        System.out.println(queue.isEmpty());
        
    }
}