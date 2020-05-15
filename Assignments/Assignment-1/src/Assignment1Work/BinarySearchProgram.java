package Assignment1Work;

public class BinarySearchProgram {
	
	
	int binarySearch(int arr[], int low, int high, int val) 
    { 
      if(low <= high) {
    	  int mid = low+(high-low)/2;
    
    	  if(arr[mid] == val) {
    		  return mid;
    	  }
    	  if(arr[mid] > val) {
    		  return binarySearch(arr, low, mid - 1, val);
    	  }
    	  return binarySearch(arr, mid + 1, high,val);
      }
      return -1;
    } 
  
    // Driver method to test above 
    public static void main(String args[]) 
    { 
    	BinarySearchProgram ob = new BinarySearchProgram(); 
        int arr[] = { 2, 3,4,5,6,7,8,10,40, 41}; 
       // int n = arr.length; 
        int low = 0;
        int high = arr.length - 1;
        int val = 1;
        int result = ob.binarySearch(arr, low, high, val); 
        if (result == -1) 
            System.out.println("Element not present"); 
        else
            System.out.println("Element found at "
                               + "index " + result); 
    } 
}
