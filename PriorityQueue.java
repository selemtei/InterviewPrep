import java.util.*;

class Task{
    String job;
    int priority;
    
    public Task(String job, int priority){
        this.job = job;
        this.priority = priority;
    }
    
    public String toString(){
        return "Job Name : " + job + "\nPriority : " + priority;
    }
}

//Here priority queue is implemented using a max heap.
public class PriorityQueue{
    private Task[] heap;
    private int currHeapSize, heapCap;
    
    public PriorityQueue(int capacity){
        this.heapCap = capacity;
        heap = new Task[this.heapCap];
        currHeapSize = 0;
    }
    
    public void clear(){
        heap = new Task[heapCap];
        currHeapSize = 0;
    }
    
    public boolean isEmpty(){
        return currHeapSize == 0;
    }
    
    public boolean isFull(){
        return currHeapSize == heapCap - 1; //I don't think we need minus one.
    }
    
    public int size(){
        return currHeapSize;
    }
    
    public void insert(String job, int priority){
        Task newJob = new Task(job, priority);
        //Check if our priorityqueue is full.
        //I suppose that we have assumed our first element in the array starts at index 1.
        heap[++currHeapSize] = newJob; //test this part of code!
        int pos = currHeapSize;
        while(pos != 1 && newJob.priority > heap[pos/2].priority){
            heap[pos] = heap[pos/2];
            pos = pos / 2;
        }
        heap[pos] = newJob;
    }
    
    public Task remove(){
        int parent, child;
        Task item, temp;
        if(isEmpty()){
            System.out.println("Heap is empty!");
            return null;
        }
        
        item = heap[1]; //we are removing the root element that starts at index 1.
        temp = heap[currHeapSize--];
        
        parent = 1;
        child = 2;
        while(child <= currHeapSize){
            if(child < currHeapSize && heap[child].priority < heap[child + 1].priority){
                child = child + 1;
            }
            
            if(temp.priority >= heap[child].priority){
                break;
            }
            
            heap[parent] = heap[child];
            parent = child;
            child = child * 2;
        }
        heap[parent] = temp;
        return item;
    }
    
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Priority Queue Test\n");   
 
        System.out.println("Enter size of priority queue ");
        PriorityQueue pq = new PriorityQueue(scan.nextInt() );
 
        char ch;
        /*  Perform Priority Queue operations */
        do{
            System.out.println("\nPriority Queue Operations\n");
            System.out.println("1. insert");
            System.out.println("2. remove");
            System.out.println("3. check empty");
            System.out.println("4. check full");
            System.out.println("5. clear");
            System.out.println("6. size");
 
            int choice = scan.nextInt();            
            switch (choice){
            case 1 : 
                System.out.println("Enter job name and priority");
                pq.insert(scan.next(), scan.nextInt() );                     
                break;                          
            case 2 : 
                System.out.println("\nJob removed \n\n"+ pq.remove()); 
                break;        
            case 3 : 
                System.out.println("\nEmpty Status : "+ pq.isEmpty() );
                break; 
            case 4 : 
                System.out.println("\nFull Status : "+ pq.isFull() );
                break; 
            case 5 : 
                System.out.println("\nPriority Queue Cleared");
                pq.clear();
                break;    
            case 6 : 
                System.out.println("\nSize = "+ pq.size() );
                break;         
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }    
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');            
    }
}