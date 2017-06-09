class Node{
    int data;
    Node next;
    
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class StackLinkedList{
    
    Node top;
    
    public StackLinkedList(){
        top = null;
    }
    
    public void push(int item){
        Node temp = new Node(item);
        temp.next = top;
        top = temp;
    }
    
    public void pop(){
        if(top == null) return;
        top = top.next;
    }
    
    public boolean isEmpty(){
        if(top == null) return true;
        return false;
    }
    
    public int peek(){
        return top.data;
    }
    
    public void display(){
        Node temp = top;
        if(temp == null){
            System.out.println("Empty LinkedList");
            return;
        }
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    
    public static void main(String[]args){
        StackLinkedList obj = new StackLinkedList();
        obj.push(3);
        obj.push(16);
        obj.push(21);
        System.out.println(obj.isEmpty());
    }
}
