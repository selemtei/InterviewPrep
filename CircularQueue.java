public class CircularQueue{
    
    int size;
    int front, rear;
    int []arr;
    
    public CircularQueue(int size){
        this.size = size;
        this.front = -1;
        this.rear = -1;
        arr = new int[size];
    }
    
    public void enqueue(int item){
        if(((rear + 1) % size) == front){
            return;
        }else if(queueIsEmpty()){
            front = 0;
            rear = 0;
        }else{
            rear = (rear + 1) % size;
        }
        arr[rear] = item; 
    }
    
    public int dequeue(){
        if(queueIsEmpty()){
            return 0;
        }else if(front == rear){
            int temp = arr[front];
            front = -1;
            rear = -1;
            return temp;
        }
        
        int deletedNum = arr[front];
        front = (front + 1) % size;
        return deletedNum;
    }
    
    public boolean queueIsEmpty(){
        if(front == -1 && rear == -1){
            return true;
        }
        return false;
    }
    
    public int peek(){ //returns the first element in the queue
        return arr[front];
    }
    
    public void print(){
        for(int item : arr){
            System.out.print(item + " ");
        }
        System.out.println();
    }
    
    public static void main(String[]args){
        CircularQueue obj = new CircularQueue(4);
        obj.enqueue(2);
        obj.enqueue(3);
        obj.print();
        obj.dequeue();
        obj.print();
    }
}
