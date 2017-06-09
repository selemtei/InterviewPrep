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
   
    public void insert(int data){
        Node newNode = new Node(data);
        newNode.data = data;
        if(head != null){
            newNode.next = head;
        }
        head = newNode;
    }
    
    public void traverse(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    
    public int LinkedListLength(){
        Node temp = head;
        int counter = 0;
        while(temp != null){
            counter = counter + 1;
            temp = temp.next;
        }
       return (counter + 1);
    }
    
    public void delete(){
        if(head == null){
            System.out.println("LinkedList is already empty!");
            return;
        }
        head = head.next;
    }
    
    
    public void insertingAtNthPostn(int data, int position){
        if(position > 0 && (position <= LinkedListLength())){
            Node newNode = new Node(data);
            newNode.data = data;
            if(position == 1){
                newNode.next = head;
                head = newNode;
                return;
            }
        
            Node temp = head;
            for(int index = 0; index < (position - 2); index++){
                temp = temp.next;
            }
        
            newNode.next = temp.next;
            temp.next = newNode;
            return;
        }
        
        System.out.println("Sorry, your entry is out of bound!");
    }
    
    
    public void deletionAtNthPostn(int position){ // just make sure the inputed numbers are within range...
        if(position == 1){
            head = head.next;
            return;
        }
        
        Node prevNode = head;
        for(int index = 0; index < (position - 2); index++){
            prevNode = prevNode.next;
        }
        Node nodeToDelete = prevNode.next;
        prevNode.next = nodeToDelete.next;
    }
    
    public static void main(String[]args){
        LinkedList obj = new LinkedList();
        obj.insertingAtNthPostn(3,1);
        obj.insertingAtNthPostn(4,2);
        obj.insertingAtNthPostn(5,3);
        obj.insertingAtNthPostn(6,4);
        obj.traverse();
        obj.deletionAtNthPostn(1);
        obj.traverse();
    }
}