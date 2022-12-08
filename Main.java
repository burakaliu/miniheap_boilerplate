public class Main {
    public static void main(String[] args) {
        miniHeap heap = new miniHeap(20);
        heap.insert(6);
        heap.insert(1);
        heap.insert(10);
        heap.insert(7);

        System.out.println();

        for (var i = 0; i < 20; i++){
            System.out.println(heap.heap[i] + " ");
        }
        
    }
}