class Node{
    int data;
    Node next;
    
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}


public class QueueLinkedList{
    
    Node front;
    Node rear;
    
    public void enqueue(int item){
        Node temp = new Node(item);
        if(isEmpty()){
            rear = temp;
            front = temp;
        }else{
            rear.next = temp;
            rear = temp;
        }
    }
    
    public void dequeue(){
        if(isEmpty()){
            return;
        }else if(front == rear){
            front = null;
            rear = null;
        }else{
            front = front.next;
        }
    }
    
    public boolean isEmpty(){
        if(front == null && rear == null){
            return true;
        }
        return false;
    }
    
    public void display(){
        Node temp = front;
        if(temp == null){
            System.out.println("Queue is empty");
            return;
        }
        
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    
    public static void main(String[]args){
        QueueLinkedList obj = new QueueLinkedList();
        obj.enqueue(12);
        obj.enqueue(4);
        obj.enqueue(9);
        obj.enqueue(6);
        obj.display();
        obj.dequeue();
        obj.dequeue();
        obj.dequeue();
        obj.dequeue();
        obj.display();
        //obj.dequeue();
    }
}