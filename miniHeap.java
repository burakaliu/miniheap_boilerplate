import java.text.ParseException;

import java.util.ArrayList;

/*
 * minHeap[(i - 1) / 2] returns the parent node.
 * minHeap[(i * 2) + 2] returns the right child node.
 * minHeap[(i * 2) + 1] returns the left child node.
 */

public class miniHeap {

    static public int heap[];
    static private int size;
    static private int index;

    public miniHeap(int max){
        this.size = max;
        this.index = 0;
        heap = new int[this.size];
    }

    private static int parent(int position){ //get parent node
        return (position-1)/2;
    }
    private static int left(int pos){ //get left child node
        return (2*pos)+1;
    }
    private static int right(int pos){ //get right child node
        return (2*pos)+2;
    }
    private static void swap(int finalpos, int firstpos){ //swap a node from first pos to final pos 
        int temp = heap[finalpos];
        heap[finalpos] = heap[firstpos];
        heap[firstpos] = temp;
    }
    private static boolean isLeaf(int i) { //check wether a node is a leaf
		if (right(i) >= size || left(i) >= size) {
			return true;
		}
		return false;
	}
    private static void heapify(int i){ //sift the heap into a proper min heap
        if (!isLeaf(i)) { //not a leaf
			if (heap[i] > heap[left(i)] || heap[i] > heap[right(i)]) { //right or left child node is smaller than the parent
				if (heap[left(i)] < heap[right(i)]) { //if left child is less than right child
					swap(i, left(i));
					heapify(left(i));
				} else { 
					swap(i, right(i));
					heapify(right(i));
				}
			}
		}
    }
    
    public static void insert(int insertMe){
        //if no more space available
        if (index >= size) {
			return;
		}
        heap[index] = insertMe;
        int curr = index;

        while (heap[curr] < heap[parent(curr)]){
            swap(parent(curr), curr);
            curr = parent(curr);
        }
        index++;
    }
    public static int delete() {
        int popped = heap[0];
		heap[0] = heap[--index];
		heapify(0);
		return popped;
    }
    public static int peek(){
        return heap[0];
    }
}
