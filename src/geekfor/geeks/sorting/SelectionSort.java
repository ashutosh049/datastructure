package geekfor.geeks.sorting;
public class SelectionSort {
 public static void main(String[] args) {
  new SelectionSort();
 }
  
 public SelectionSort() {
  int[] arr=new int[]{64,2,1,22,11};
   
  System.out.println("Before Sorting...");
  printArray(arr);
   
  selectionSort(arr);
   
  System.out.println("\nAfter Sorting...");
  printArray(arr);
 }
  
 //Iterate from 0 to n.
 //While working for position 0, Search smallest element in array[0 to n] and put it at position 0.
 //While working for position 1, Search smallest element in array[1 to n] and put it at position 1.
 //While working for position 2, Search smallest element in array[2 to n] and put it at position 2.
 //and so on.
 private void selectionSort(int[] arr){
  for (int i = 0; i < arr.length-1; i++) {
    
   //variable to store index of smallest element and initially let smallest element be i.
   int minimumTillNow = i; 
    
   for (int j = i+1; j < arr.length; j++) {
    if(arr[minimumTillNow] > arr[j]){
     minimumTillNow = j;
    }
   }
    
   //Checking if smallest initialized and found is same. if yes then there is no swapping done.
   //So in that case no need to swap
   if(minimumTillNow != i){ // 
    int temp = arr[minimumTillNow];
    arr[minimumTillNow] = arr[i];
    arr[i] = temp;
   }
  }
 }
  
 private void printArray(int arr[]){
  for (int i = 0; i < arr.length; i++) {
   System.out.print(arr[i] + " ");
  }
 }
  
}