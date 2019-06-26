package DataStructures;

public class MinHeap {
    private int[] heap;
    private int capacity;
    private int size;

    MinHeap(int n){
        this.capacity=n;
        this.size=0;
        heap=new int[n];
    }

    int parent(int i){
        return (i-1)/2;
    }

    int left(int i){
        return (2*i)+1;
    }
    int right(int i){
        return (2*i)+2;
    }

    void add(int i){
        if(size>capacity) return ;
        int current=size;
        heap[size++]=i;

        while(heap[parent(current)]> heap[current]){
            swap(current, parent(current));
            current=parent(current);
        }
    }

    boolean isChild(int i){
        return i > size / 2 && i < size;
    }

    void swap(int i, int j){
        int temp=heap[i];
        heap[i]=heap[j];
        heap[j]=temp;
    }

    int remove(){
        int popped= heap[0];
        heap[0]=heap[--size];
        minHeapify(0);

    }

    void minHeapify(int i){
        if(!isChild(i)){

            if(heap[i]> heap[left(i)]) {
                swap(i, left(i));
                minHeapify(left(i));
            }
            else if(heap[i] > heap[right(i)]){
                swap(i, right(i));
                minHeapify(right(i));
            }
        }
    }

    void minHeapify(){
        for(int i=size/2;i>=0;i--){
            minHeapify(i);
        }
    }

}
