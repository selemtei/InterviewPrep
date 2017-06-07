public class BinSearchApp{
    
    //search a given number x, in a circular sorted array!
    //this method fails when the array contains duplicates. i.e 2, 2, 2, 0, 2, 2
    //to solve duplicate problem, need perform linear search. 
    //the elements in the array should be strictly unique.
    public int circularArraySearch(int[]arr, int x){
        int low = 0;
        int high = arr.length - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(x == arr[mid]){
                return mid; //Case 1: Found X.
            }
            
            if(arr[mid] <= arr[high]){ //case 2: right half is sorted.
                if(x > arr[mid] && x <= arr[high]){
                    low = mid + 1; //go search in the right sorted half.
                }else{
                    high = mid - 1;
                }
            }else{ //Case 3: Left half is sorted. 
                if(arr[low] <= x && x < arr[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
        }
        return -1; //-1 indicates that we didn't find the searched number in the array.
    }
    
    //how many times has the sorted array been rotated, in a circular sorted array?
    //return the index of the minimum element in the sorted array.
    //the index, will correspond to the number of times the array has been rotated.
    //can't have duplicates in the array.
    public int findRotationCount(int[]arr){
        int low = 0, high = arr.length;
        
        while(low <= high){
            
            if(arr[low] <= arr[high]){ //Case 1: check if the array is already sorted.
                return low;
            }
            
            int mid = low + (high - low)/2;
            int next = (mid + 1) % arr.length;
            int prev = (mid + 1 - arr.length) % arr.length;
            
            //Case 2: checks if mid element is a pivot element.
            if(arr[mid] <= arr[next] && arr[mid] <= arr[prev]){
                return mid;
            }else if(arr[mid] <= arr[high]){
                high = mid - 1;
            }else if(arr[mid] >= arr[low]){
                low = mid + 1;
            }
        }
        return -1;
    }
    
    //find count of an element in a sorted list.
    //sorted array may contain as many duplicates as there could be. 
    //worst case time --> O(logn) + O(n) = O(n) i.e when the array contains same element. i.e 2, 2, 2, 2, 2, 2, 2.
    int findCount(int[]arr, int x){
        int first = findFirstIndex(arr, x);
        int last = findLastIndex(arr, x);
        return (last - first + 1);
    }
    
    //finds first occurence of a given element.
    int findFirstIndex(int[]arr, int x){
        int low = 0; 
        int high = arr.length;
        int result = -1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(x == arr[mid]){
                result = mid;
                high = mid - 1;
            }else if(x <= arr[mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return result;
    }
    
    //finds last occurence of a given element
    int findLastIndex(int[]arr, int x){
        int low = 0; 
        int high = arr.length;
        int result = -1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(x == arr[mid]){
                result = mid;
                low = mid + 1;
            }else if(x <= arr[mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return result;
    }
    
    
    public static void main(String[]args){
        
    }
}
