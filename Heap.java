import java.util.Arrays;
//this class represents a Min Heap!
public class Heap{
    int heapArr[];
    int maxSize;
    int currSize;
    
    public Heap(int size){
        heapArr = new int[size];
        maxSize = size;
        currSize = 0;
    }
    
    //If you want your heap to always be re-sizing then we use the beneath method.
    private void ensureExtraCapacity(){
        if(currSize == maxSize){
            maxSize = maxSize * 2;
            heapArr = Arrays.copyOf(heapArr, maxSize);
        }
    }
    
    public int parent(int index){
        return (index - 1)/2;
    }
    
    public int left(int index){
        return (2*index + 1);
    }
    
    public int right(int index){
        return (2*index + 2);
    }
    
    public int getMin(){
        return heapArr[0];
    }
    
    public void swap(int x, int y){
        //Try to modularize code with this method in the parts below that are commented as swap elements. 
    }
    
    public void insertKey(int k){
        if(currSize == maxSize){
            System.out.println("Overflow, Couldn't insert key!");
            return;
        }
        
        //First insert the new key at the end of the heap(for our case the heap is implemented as an array!)
        currSize++;
        int index = currSize - 1;
        heapArr[index] = k;
        
        //Fix the min heap property if it is violated.
        while(index != 0 && heapArr[parent(index)] > heapArr[index]){
            //swap the elements
            int temp = heapArr[index];
            heapArr[index] = heapArr[parent(index)];
            heapArr[parent(index)] = temp;
            index = parent(index);
        }
    }
    
    //Decreases value of key at index, index to newVal.
    //It is assumed that newVal is smaller than heapArr[index]
    public void decreaseKey(int index, int newValue){
        heapArr[index] = newValue;
        while(index != 0 && heapArr[parent(index)] > heapArr[index]){
            //swap the elements
            int temp = heapArr[index];
            heapArr[index] = heapArr[parent(index)];
            heapArr[parent(index)] = temp;
            index = parent(index);
        }
    }
    
    //A recursive method to heapify a subtree with root at given index.
    //The method assumes that the subtrees are already heapified.
    public void minHeapify(int index){
        int leftChild = left(index);
        int rightChild = right(index);
        int smallest = index; //smallestChild
        
        if(leftChild < currSize && heapArr[leftChild] < heapArr[index]){
            smallest = leftChild;
        }
        
        if(rightChild < currSize && heapArr[rightChild] < heapArr[smallest]){
            smallest = rightChild;
        }
        
        if(smallest != index){
            //swap the given elements
            int temp = heapArr[index];
            heapArr[index] = heapArr[smallest];
            heapArr[smallest] = temp;
            minHeapify(smallest); //recursively heapify!
        }
    }
    
    //Removes minimum element or root from the min heap.
    public int extractMin(){
        //I think should only be size == 0
        if(currSize <= 0){
            return Integer.MAX_VALUE;
        }
        
        if(currSize == 1){
            currSize = currSize - 1;
            return heapArr[0];
        }
        
        //Store the minimum value, and remove it from the heap.
        int root = heapArr[0];
        heapArr[0] = heapArr[currSize - 1];
        currSize = currSize - 1;
        minHeapify(0); //miniHeapify from the root i.e index = 0.
        return root;
    }
    
    //The function deletes key at index i. 
    //It first reduced value to minus inifinite, then calls extractMin().
    public void deleteKey(int index){
        decreaseKey(index, Integer.MIN_VALUE);
        extractMin();
    }
    
    public static void main(String[]args){
        Heap h = new Heap(10);
        h.insertKey(3);
        h.insertKey(2);
        h.deleteKey(1);
        h.insertKey(15);
        h.insertKey(5);
        h.insertKey(4);
        h.insertKey(45);
        System.out.println(h.getMin());
    }
}