import java.util.ArrayList;

/*
 * minHeap[(i - 1) / 2] returns the parent node.
 * minHeap[(i * 2) + 2] returns the right child node.
 * minHeap[(i * 2) + 1] returns the left child node.
 */

public class miniHeap {

    //static int heap[];
    static ArrayList<Integer> heap = new ArrayList<Integer>();
    private int size;
    private int max;

    public miniHeap(int max){
        this.max = max;
        this.size = 0;

        //heap = new int[this.max + 1];
    }

    private int parent(int position){
        return position/2;
    }
    private int left(int pos){
        return (2*pos);
    }
    private int right(int pos){
        return (2*pos)+1;
    }
    private void swap(int finalpos, int firstpos){
        int temp = heap.get(finalpos);
        heap.set(finalpos, firstpos);
        heap.set(firstpos, temp);
    }
    
    public static void insert(int insertMe){
        heap.add(insertMe);
    }
    public static int delete() {
        return heap.remove(0);
    }
    public static int peek(){
        return heap.get(0);
    }
}
