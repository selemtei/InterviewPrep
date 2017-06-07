import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;
    
    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BSTree{
    //Node root = null; consider implementing this class while root is null... 
    public static Node insertNode(Node root, int data){
        if(root == null){//empty tree case!
            Node newNode = new Node(data);
            root = newNode;
        }else if(data <= root.data){
            root.left = insertNode(root.left, data);
        }else{
            root.right = insertNode(root.right, data);
        }
        
        return root;
    }
    
    public static boolean search(Node root, int data){
        if(root == null){
            return false;
        }
        
        if(root.data == data){
            return true;
        }else if(data <= root.data){
            return search(root.left, data);
        }else{
            return search(root.right, data);
        }
        
    }
    
    public static Node delete(Node root, int data){
        //check if tree is empty, search the data to be deleted!
        if(root == null){
            return root;
        }else if(data < root.data){
            root.left = delete(root.left, data);
        }else if(data > root.data){
            root.right = delete(root.right, data);
        }else{
            //Case 1: No child
            if(root.left == null && root.right == null){
                root = null;
                //return root;
            }else if(root.left == null){ //Case 2: One child
                //Node temp = root;
                root = root.right;
                //return root;
            }else if(root.right == null){
                root = root.left;
                //return root;
            }else{// case 3: 2 children
                Node temp = findMin(root.right); //or find max value in the right sub-tree.
                root.data = temp.data;
                root.right = delete(root.right,temp.data);
                //return root;
            }
        }
        return root;
    }
    
    public static Node findMin(Node root){
        if(root == null){//empty tree
            return null;
        }else if(root.left == null){
            return root;
        }
        
        //search in the left sub-tree.
        return findMin(root.left);
    }
    
    //Iterative solution.
    public static int findMinIter(Node root){
        //when the tree is empty throw some errors.
        if(root == null){
            return -1;
        }
        Node current = root;
        while(current.left != null){
            current = current.left;
        }
        return current.data;
    }
    
    //Iterative solution to find max. 
    public int findMax(Node root){
        if(root == null){
            return -1;
        }
        
        while(root.right != null){
            root = root.right;
        }
        return root.data;
    }
    
    //Obtains height of the tree!
    public static int findHeight(Node root){
        if(root == null){
            return -1;
        }
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    //function to check if a given binary tree is a binary search tree.
    //you could also find maximum in left subtree then compare with root.data.
    //also find minimum in right subtree then compare with root.data.
    public static boolean isBinSrchTree(Node root){//recursive approach, is of order O(n^2).
        if(root == null) return true;
        
        if(isSubTreeLesser(root.left, root.data) && isSubTreeGreater(root.right, root.data) && isBinSrchTree(root.left) && isBinSrchTree(root.right)){
            return true;
        }
        return false;
    }
    
    public static boolean isSubTreeLesser(Node root, int value){
        if(root == null)return true;
        
        if(root.data <= value && isSubTreeLesser(root.left,value) && isSubTreeLesser(root.right,value)){
            return true;
        }
        return false;
    }
    
    public static boolean isSubTreeGreater(Node root, int value){
        if(root == null) return true;
        
        if(root.data > value && isSubTreeGreater(root.right, value) && isSubTreeGreater(root.left, value)){
            return true;
        }
        return false;
    }
    
    //better function to verify is a binary tree is a BST. Is of order O(n).
    public static boolean isBinarySearchTree(Node root){
        return isBstUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public static boolean isBstUtil(Node root, int minValue, int maxValue){
        if(root == null){
            return true;
        }
        
        if(root.data > minValue && root.data < maxValue && isBstUtil(root.left,minValue,root.data) && isBstUtil(root.right,root.data,maxValue)){
            return true;
        }
        
        return false;
    }
    
    //function to obtain an inorder successor for a given node in a BST. 
    //It takes Big O(log n) or height of the tree!
    public static Node getSuccessor(Node root, int data){
        //first step, search for the passed node.
        Node current = find(root, data);
        if(current == null) return null; //data wasn't found in the tree.
        
        //case 1: Node has right sub-tree
        if(current.right != null){
            //go to the right subtree and obtain the minimum value. or go as far deep to the left subtree. 
            return findMinValue(current.right);
            
        }else{//case 2: no right subtree, walk the tree from root till current node.
            //then find the deepest ancestor for which current node will be in its left sub tree.
            Node successor = null;
            Node ancestor = root;
            while(ancestor != current){
                if(current.data < ancestor.data){
                    successor = ancestor;
                    ancestor = ancestor.left;
                }else{
                    ancestor = ancestor.right;
                }
            }
            return successor;
        }
    }
    
    public static Node findMinValue(Node root){
        if(root == null) return null;
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
    
    public static Node find(Node root, int data){
        if(root == null){
            return null;
        }
        
        if(root.data == data){
            return root;
        }else if(data <= root.data){
            return find(root.left, data);
        }else{
            return find(root.right, data);
        }
        
    }
    
    //levelOrder traversal of a binary tree. 
    public static void levelOrder(Node root){
        if(root == null){
            return;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node current = q.peek();
            System.out.print(current.data + " ");
            if(current.left != null){
                q.add(current.left);
            }
            if(current.right != null){
                q.add(current.right);
            }
            q.remove();
        }
    }
    
    //preOrder i.e root, left, right
    //inOrder i.e left, root, right
    //postOrder i.e left, right, root.
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    public static void main(String[]args){
        Node root = null;
        root = insertNode(root, 15);
        root = insertNode(root, 10);
        root = insertNode(root, 20);
        root = insertNode(root, 25);
        
        if(search(root,32)){
            System.out.println("Found your number!!");
        }else{
            System.out.println("No such number!");
        }
    }
}
