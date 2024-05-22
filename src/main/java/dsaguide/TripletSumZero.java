package dsaguide;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



// GFG : https://www.geeksforgeeks.org/problems/find-triplets-with-zero-sum/1
// GFG Resource : https://www.geeksforgeeks.org/find-triplets-array-whose-sum-equal-zero/

public class TripletSumZero {
	
	public static void main(String args[]) {
		
	}
	
	// HashSet
    // TC : O(n^2)
    // SC : O(n)
	public boolean findTriplets(int arr[] , int n)
    {
        
        for(int i =0 ; i<n-2 ; i++){
            Set<Integer> set = new HashSet<>();
            for(int j =i+1 ; j< n; j++){
                int elem = -(arr[i] + arr[j]);
                if(set.contains(elem)){
                    // Triplet found {arr[i], arr[j], elem}
                    return true;
                } else{
                    set.add(arr[j]);
                }
            }
        }
        
        return false;
    }
	
	// Sorting + 2 ptr
    // TC : O(n^2)
    // SC : O(n)
	public boolean findTriplets1(int arr[] , int n)
    {
        
        Arrays.sort(arr);
        for(int i = 0; i < n-2; i++){
            int l = i+1;
            int r = n-1;
            while(l < r){
                int sum = arr[i] + arr[l] + arr[r];
                if(sum == 0){
                    l++;
                    r--;
                    return true; // replace with printing result
                }
                else if(sum < 0) // increase sum
                    l++;
                else
                    r--;
            }
        }
        
        return false;
    }
	
	

}
