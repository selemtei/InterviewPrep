public class Queue{
    int size;
    int front;
    int rear;
    int []arr;
    
    public Queue(int size){
        this.size = size;
        this.front = -1;
        this.rear = -1;
        arr = new int[size];
    }
    
    public void enqueue(int item){
        if(rear == size - 1){
            return;
        }else if(queueIsEmpty()){
            front = front + 1; // front = 0;
        }
        //rear = rear + 1;
        //arr[rear] = item;
        arr[++rear] = item;
    }
    
    public int dequeue(){
        int temp;
        if(queueIsEmpty()){
            return 0;
        }else if(front == rear){
            temp = arr[front];
            arr[front] = 0;
            front = -1;
            rear = -1;
            return temp;
        }
       //return arr[front++]; //the beneath code is for visual purposes only!!
       int deletedItem = arr[front];
       arr[front] = 0;
       front = front + 1;
       return deletedItem;
    }
    
    public boolean queueIsEmpty(){
        if(front == -1 && rear == -1){
            return true;
        }
        return false;
    }
    
    public boolean queueIsFull(){
        if(rear == size - 1){
            return true;
        }
        return false;
    }
    
    public int peek(){
        return arr[front];
    }
    
    public void print(){
        for(int item: arr){
            System.out.print(item + " ");
        }
        System.out.println();
    }
    
    public static void main(String[]args){
        Queue obj = new Queue(6);
        //obj.enqueue(4);
        //obj.enqueue(42);
        //obj.enqueue(6);
        //obj.enqueue(9);
        obj.enqueue(82);
        
        //obj.dequeue();
        //obj.print();
        //obj.dequeue();
        //obj.dequeue();
        //obj.dequeue();
        //obj.print();
        //obj.dequeue();
        System.out.println(obj.dequeue());
        //obj.print();
        
        //System.out.println(obj.queueIsFull());
        //System.out.println(obj.queueIsEmpty());
    }
}