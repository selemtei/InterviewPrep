public class Search{
    
    public static int linearSearch(int[]arr, int num){
        
        for(int index = 0; index < arr.length; index++){
            if(num == arr[index]){
                return index;
            }
        }
        return -1;
    }
    
    public static void binarySearch(int num){}
    
    public static void jumpSearch(int num){}
    
    public static void interpolationSearch(int num){}
    
    public static void main(String[]args){
        
    }
}
