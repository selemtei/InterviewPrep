//Tries types: Standard, Compressed, and Suffix.

import java.util.LinkedList;

class TrieNode{
    //26 represents the alphabet size.
    char character;
    LinkedList<TrieNode> childList;
    boolean isEnd;
    int count;
    
    public TrieNode(char c){
        childList = new LinkedList<TrieNode>();
        isEnd = false;
        character = c;
        count = 0;
    }
    
    public TrieNode subNode(char c){
        if(childList != null){
            for(TrieNode eachChild: childList){
                if(eachChild.character == c){
                    return eachChild;
                }
            }
        }
        return null;
    }
}

public class Trie{
    
    private TrieNode root;
    
    public Trie(){
        root = new TrieNode(' ');
    }
    
    public void insert(String word){
        if(search(word) == true){
            return;
        }
        
        TrieNode current = root;
        for(char ch: word.toCharArray()){
            TrieNode child = current.subNode(ch);
            if(child != null){
                current = child;
            }else{
                current.childList.add(new TrieNode(ch));
                current = current.subNode(ch);
            }
            current.count = current.count + 1;
        }
        current.isEnd = true;
    }
    
    public boolean search(String word){
        TrieNode current = root;
        for(char ch: word.toCharArray()){
            if(current.subNode(ch) == null){
                return false;
            }else{
                current = current.subNode(ch);
            }
        }
        
        //reached at the end of the word, we now need check if the boolean value is true that indicates the end!
        if(current.isEnd == true){
            return true;
        }
        
        return false;
    }
    
    public void remove(String word){
        if(search(word) == false){
            System.out.println(word + " does not exist in trie\n");
            return;
        }
        
        TrieNode current = root;
        for(char ch: word.toCharArray()){
            TrieNode child = current.subNode(ch);
            if(child.count == 1){
                current.childList.remove(child);
                return;
            }else{
                child.count = child.count - 1;
                current = child;
            }
        }
        current.isEnd = false;
    }
    
    public static void main(String[]args){
        
    }
}