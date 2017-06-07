public class Sorting{
    
    public static void swap(int j, int[]arr){
        int temp = arr[j];
        arr[j] = arr[j+1];
        arr[j+1] = temp;
    }
    
    public static void bubbleSort(int[]arr){
        
        for(int index = 0; index < arr.length - 1; index++){ //can use arr.length too! 
            boolean swapped = false;
            for(int j = 0; j < arr.length - 1 - index; j++){
                if(arr[j] > arr[j+1]){
                    swap(j, arr);
                    swapped = true;
                }
            }
            
            if(!swapped){
                break;
            }
        }
    }
    
    public static void insertionSort(int[]arr){
        for(int i = 1; i < arr.length; i++){
            int valueToInsert = arr[i];
            //we comparing backwards to make it easy to use zero index in the array. 
            //hole poisition is the place where value to be inserted comes from.
            int j = i - 1;
            while(j >= 0 && arr[j] > valueToInsert){
                arr[j+1] = arr[j];
                j = j - 1;
            }
            arr[j+1] = valueToInsert;
        }
    }
    
    public static void selecSwap(int minIndex, int i, int[]arr){
        int temp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = temp;
    }
    
    public static void selectionSort(int[]arr){
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            selecSwap(minIndex, i, arr);
        }
    }
    
    public static void merge(int[]leftArray, int[]rightArray, int[]arr){
        int nL = leftArray.length;
        int nR = rightArray.length;
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i < nL && j < nR){
            if(leftArray[i] <=  rightArray[j]){
                arr[k] = leftArray[i];
                i = i + 1;
            }else{
                arr[k] = rightArray[j];
                j = j + 1;
            }
            k = k + 1;
        }
        
        //the two while loops fills the remaining portion of the left or right array. 
        while(i < nL){
            arr[k] = leftArray[i];
            i = i + 1;
            k = k + 1;
        }
        
        while(j < nR){
            arr[k] = rightArray[j];
            j = j + 1;
            k = k + 1;
        }
    }
    
    public static void mergeSort(int[]arr){
        int n = arr.length;
        if(n < 2){
            return;
        }
        
        int mid = n / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[n - mid];
        
        for(int index = 0; index < mid; index++){
            leftArray[index] = arr[index];
        }
        
        for(int index = mid; index < n; index++){
            rightArray[index] = arr[index];
        }
        
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, arr);
    }
    
    public static void shellSort(int[]arr){}
    
    public static int partition(int[]arr, int start, int end){
        //we choose to pick the pivot from the end position.
        //we could come up with some other way of picking up the pivot. 
        int pivot = arr[end];
        //obtaining partnIndex in a randomized manner it lowers the prob of hitting worst case.
        int partnIndex = start;
        for(int index = start; index < end; index++){
            if(arr[index] <= pivot){
                //swap
                int temp = arr[index];
                arr[index] = arr[partnIndex]; 
                arr[partnIndex] = arr[index];
            }
        }
        //swap
        int temp = arr[partnIndex];
        arr[partnIndex] = arr[end];
        arr[end] = temp;
        return partnIndex;
    }
    
    public static void quickSort(int[]arr, int start, int end){
        //end is the lastIndex in the array. i.e arrlength - 1;
        if(start >= end){
            return;
        }
        int partnIndex = partition(arr, start, end);
        quickSort(arr, start, partnIndex - 1);
        quickSort(arr, partnIndex + 1, end);
    }
    
    public static void heapSort(){}
    
    public static void radixSort(){}
    
    public static void bucketSort(){}
    
    public static void countingSort(){}
    
    public static void combSort(){}
    
    public static void main(String[]args){
        
    }
}
