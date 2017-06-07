class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class LinkedList{
    
    Node head; 
    
    public void insertAtFirstPstn(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node secondNode = head;
        head = newNode;
        newNode.next = secondNode;
    }
    
    public void print(){
        
        if(head == null){
            System.out.println("Empty List");
        }
        
        Node currentNode = head;
        
        while(currentNode != null){
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }
    
    public static void main(String[]args){
        LinkedList obj = new LinkedList();
        obj.insertAtFirstPstn(10);
        //obj.insertAtFirstPstn(9);
        //obj.insertAtFirstPstn(4);
        //obj.insertAtFirstPstn(1);
        obj.print();
    }
}
