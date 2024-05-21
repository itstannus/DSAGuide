package dsaguide;

import java.util.HashMap;
import java.util.Map;

public class MaximumIndex {

}

// GeeksforGeeks : https://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/


class Solution {

    // Brute force 2 ptr approach
    // TC : O(n^2)
    // SC : O(1)
    // 1115 /1125 test cases passed
    int maxIndexDiff(int arr[], int n) {
        int max = 0;
        for(int j = n-1; j>=1; j--){
            for(int i = 0 ; i < j ; i++){
                if(arr[i] <= arr[j] && max < j-i){
                    max = j - i;
                    break;
                }
                    
            }
        }
        return max;
    }
    
    // Binary Search
    // TC : O(nlogn)
    // SC : O(n)
    int maxIndexDiff1(int arr[], int n) {
        int max = 0;
        
        //step 1 : maxFromEnd forms decreasing order arr
        int[] maxFromEnd= new int[n];
        maxFromEnd[n-1] = arr[n-1];
        for(int i = n-2; i >=0; i--)
            maxFromEnd[i] = Math.max( maxFromEnd[i+1], arr[i]);
            
         // step2 : apply binary search for every element to find the righmost elem greater than itself
         for(int i = 0; i<n; i++){
             int low = i+1, high = n-1;
             int j = i; // points to the same elem first, j-i =0
             while(low <= high){
                 int mid = low + (high -low)/2;
                 if(arr[i] <= maxFromEnd[mid]){
                     j = mid;
                     low = mid+1 ; // Continue finding the rightmost max elem
                 } else {
                     high = mid - 1;
                 }
             }
             max = Math.max( max, j-i);
         }
         
        return max;
    }
    
    // right max[] and left min[]
    // TC : O(n)
    // SC : O(n)
    int maxIndexDiff2(int arr[], int n) {
        int max = 0;
        
        // as we want max/longest j-i length we cal
        // maxFromEnd[] and minFromStart[]
        int[] maxFromEnd = new int[n];
        int[] minFromStart = new int[n];
        
        maxFromEnd[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--)
            maxFromEnd[i] = Math.max( maxFromEnd[i+1], arr[i]);
        
        minFromStart[0] = arr[0];
        for(int i =1 ; i<n ; i++)
            minFromStart[i] = Math.min(minFromStart[i-1], arr[i]);
            
        int i= 0 , j=0;
        while(i <n && j<n){
            if(maxFromEnd[j] >= minFromStart[i]){
                max = Math.max(max, j-i);
                j++; // Look further right for max length
            } else{
                i++; // increase lowere value & check j further
            }
        }
        
        return max;
    }
}