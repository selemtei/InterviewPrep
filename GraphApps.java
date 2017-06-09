import java.util.LinkedList;
import java.util.Iterator;
import java.io.*;

public class GraphApps{
    
    private int noVertices;
    private LinkedList<Integer> [] adjList;
    
    GraphApps(int v){
        this.noVertices = v;
        adjList = new LinkedList[v];
        for(int index = 0; index < v; index++){
            adjList[index] = new LinkedList();
        }
    }
    
    void addEdge(int v, int w){
        adjList[v].add(w);
    }
    
    //It doesn't print all nodes if the graph is disconnected!
    void breadthFirstSearch(int s){
        boolean visited[] = new boolean[noVertices];
        
        //create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
        
        //mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);
        
        while(queue.size() != 0){
            
            //Dequeue a vertex from queue and print it.
            s = queue.poll();
            System.out.print(s + " ");
            
            //Obtain all adjacent vertices of the dequeued vertex s.
            //If a adjacent has not been visited, then mark it visited and enqueue it.
            Iterator<Integer> i = adjList[s].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
            
        }
        
    }
    
    //prints all the nodes even if the graph is disconnected!
    //an helper function to DFS() method.
    void DFSUtil(int v, boolean visited[]){
        visited[noVertices] = true;
        System.out.print(v + " ");
        
        Iterator<Integer> i = adjList[v].listIterator();
        while(i.hasNext()){
            int n = i.next();
            if(!visited[n]){
                DFSUtil(n, visited);
            }
        }
    }
    
    void DFS(){
        boolean visited[] = new boolean[noVertices];
        
        for(int index = 0; index < noVertices; index++){
            if(visited[index] == false){
                DFSUtil(index, visited);
            }
        }
    }
    
    //Depth First Search Traversal
    void DepthFSUtil(int v, boolean visited[]){
        visited[v] = true;
        System.out.print(v + " ");
        
        Iterator<Integer> i = adjList[v].listIterator();
        while(i.hasNext()){
            int n = i.next();
            if(!visited[n]){
                DFSUtil(n, visited);
            }
        }
    }
    
    //depth first search, doesn't take into account unconected graphs.
    void DepthFS(int v){
        boolean visited[] = new boolean[noVertices];
        DFSUtil(v, visited);
    }
    
    //takes into account unconnected graphs.
    void DepthFirstSearch(){
        boolean visited[] = new boolean[noVertices];
        for(int index = 0; index < noVertices; index++){
            if(visited[index] == false){
                DepthFSUtil(index, visited);
            }
        }
    }
    
    public static void main(String[]args){
        GraphApps g = new GraphApps(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.breadthFirstSearch(2);
    }
}
