public class StackArray{
    
    int arraySize;
    int []array;
    int top; //= -1;
    
    public StackArray(int arraySize){
        this.arraySize = arraySize;
        array = new int[arraySize];
        top = -1;
    }
    
    public void push(int item){
        if(top == (arraySize - 1)){
            System.out.println("stack is full!!");
            return;
        }else{
            top = top + 1;
            array[top] = item; 
        }
    }
    
    public int pop(){
        if(top == -1){
            System.out.println("Stack is already empty!!");
            return 0;
        }else{
            return array[top--];
        }
    }
    
    public void display(){
        for(int x = 0; x <= top; x++){
            System.out.print("| " + array[x] + " | ");
        }
        System.out.println();
    }
    
    public boolean isEmpty(){
        if(top == -1){
            return true;
        }
        return false;
    }
    
    public int peek(){
        return array[top];
    }
    
    public static void main(String[]args){
        StackArray stack1 = new StackArray(10);
        stack1.push(88);
        stack1.push(10);
        stack1.push(7);
        stack1.push(5);
        stack1.push(21);
        stack1.push(20);
        stack1.pop();
        stack1.display();
        stack1.push(3);
        System.out.println(stack1.peek());
        //stack1.display();
        //System.out.println(MAX_ARRAY_SIZE);
    }
}