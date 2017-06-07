class Node{
    int vertex;
    Node next;
    
    public Node(int vertex){
        this.vertex = vertex;
        this.next = null;
    }
    
    public String toString(){
        return Integer.toString(vertex);
    }
}

public class Graph{
    //this is an adjacency list representation of an undirected graph!
    int graphSize;
    //You can replace Node, with a LinkedList i.e LinkedList<Integer> [] adjList = new LinkedList[graphSize];
    Node [] adjList;
    
    public Graph(int size){
        graphSize = size;
        adjList = new Node[graphSize];
    }
    
    //since its undirected graph then we need to insert an edge two times! i.e 1->2 and 2->1
    //with a LinkedList you simply call the add method i.e adjList[src].add(dst);
    public void addEdge(int src, int dst){
        Node newNode = new Node(dst);
        //case 1:
        if(adjList[src] == null){
            adjList[src] = newNode;
        }else{
            Node temp = adjList[src];
            adjList[src] = newNode;
            newNode.next = temp;
        }
        //case 2:
        newNode = new Node(src);
        if(adjList[dst] == null){
            adjList[dst] = newNode;
        }else{
            Node temp = adjList[dst];
            adjList[dst] = newNode;
            newNode.next = temp;
        }
    }
    
    public void printGraph(){
        for(int v = 0; v < graphSize; v++){
            System.out.println("Adjacency list of vertex " + v);
            Node head = adjList[v];
            while(head != null){
                System.out.print(head.vertex + "-> ");
                head = head.next;
            }
            System.out.print("null");
            System.out.println();
        }
    }
    
    public static void main(String[]args){
        Graph obj = new Graph(5);
        obj.addEdge(0,1);
        obj.addEdge(0,4);
        obj.addEdge(1,2);
        obj.addEdge(1,3);
        obj.addEdge(1,4);
        obj.addEdge(2,3);
        obj.addEdge(3,4);
        obj.printGraph();
        //System.out.println(obj.adjList[0]);
    }
}