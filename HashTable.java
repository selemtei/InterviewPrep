import java.util.ArrayList;

class Node<K, V>{
    K key;
    V value;
    Node<K, V> next;
    
    public Node(K key, V value){
        this.key = key;
        this.value = value;
    }
}

public class HashTable<K,V>{
    private ArrayList<Node<K,V>> hashArray;
    private int currArrCap;
    private int currArrSize;
    
    public HashTable(){
        hashArray = new ArrayList<>();
        currArrCap = 10;
        currArrSize = 0;
        //initializes the ArrayList with values, otherwise will produce errors!
        for(int index = 0; index < currArrCap; index++){
            hashArray.add(null);
        }
    }
    
    public int size(){
        return currArrSize;
    }
    
    public boolean isEmpty(){
        return size() == 0;
    }
    
    //implementation of hash function, it returns an index for a given key. 
    private int getHashIndex(K key){
        int hashCode = key.hashCode();
        int index = hashCode % currArrCap;
        return index;
    }
    
    public V delete(K key){
        int hashIndex = getHashIndex(key);
        Node<K,V> head = hashArray.get(hashIndex);
        Node<K,V> previousNode = null;
        
        //No value is at the computed index!
        if(head == null){
            return null;
        }
        
        while(head != null){
            
            //we found the key
            if(head.key.equals(key)){
                currArrSize--;
                //Now delete the key,value pair.
                if(previousNode != null){
                    previousNode.next = head.next;
                }else{
                    //head.next should be replaced by null.
                    hashArray.set(hashIndex, head.next);
                }
                break;
            }
            previousNode = head;
            head = head.next;
        }
        return head.value;
    }
    
    public V search(K key){
        int hashIndex = getHashIndex(key);
        Node<K,V> head = hashArray.get(hashIndex);
        
        //perform the search inside the hashtable
        while(head != null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        //No key was found!
        return null;
    }
    
    public void insert(K key, V value){
        //Obtain the head of the given chain!
        int hashIndex = getHashIndex(key);
        Node<K,V> head = hashArray.get(hashIndex);
        Node<K,V> newNode = new Node<K,V>(key,value);
        
        //is the key already present? Because we don't allow duplicates in hashTables.
        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        
        //Insert key in the chain!
        currArrSize = currArrSize + 1;
        head = hashArray.get(hashIndex);
        newNode.next = head;
        hashArray.set(hashIndex, newNode);
        
        //Once load factor goes beyond the threshold then double the hash table size.
        if((1.0 * currArrSize) / currArrCap >= 0.7){
            ArrayList<Node<K,V>> temp = hashArray;
            hashArray = new ArrayList<>();
            currArrCap = currArrCap * 2;
            currArrSize = 0;
            for(int index = 0; index < currArrCap; index++){
                hashArray.add(null);
            }
            
            for(Node<K,V> headNode: temp){
                while(headNode != null){
                    insert(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }
    
    public static void main(String[]args){
        HashTable<String, Integer> hashObj = new HashTable<String, Integer>();
        //System.out.println(hashObj.hashArray.get(0)); 
        System.out.println("Separate Chaining HashTable!");
        hashObj.insert("one", 1);
        hashObj.insert("two", 2);
        hashObj.insert("three", 3);
        hashObj.insert("four", 4);
        hashObj.delete("three");
        System.out.println(hashObj.size());
        System.out.println(hashObj.isEmpty());
    }
}