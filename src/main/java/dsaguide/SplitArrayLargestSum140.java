package dsaguide;

//Leetcode 140 : Hard : https://leetcode.com/problems/split-array-largest-sum/description/
//GeeksForGeeks : https://www.geeksforgeeks.org/allocate-minimum-number-pages/


public class SplitArrayLargestSum140 {

    // Range Binary Search
    // TC : O(nlogs) s= totalsum
    // SC : O(logs) s= totalsum; if recursion stack is to ignored then O(1)
    public int splitArray(int[] nums, int k) {
        int maxValue = 0;
        long totalSum = 0; // if there was one subset with all elements
        for(int num : nums){
            totalSum += num;
            maxValue = Math.max(maxValue, num);
        }
        long low = maxValue, high = totalSum;
        long mid = 0;
        // when low = high goes in infinite loop as its valid ans, high doesnot change
        // hence low < high
        while(low < high){
            mid = low + (high - low) / 2;
            if(validDivisionPossible(mid, nums, k) )
                high = mid; // as mid is a valid possibility so include it in range
            else
                low = mid + 1;
        }
        return (int) low;
    }

    private boolean validDivisionPossible(long maxPossibleSum, int[]  nums, int k){
        int totalSubsets = 1;
        long runningSum = 0;
        for(int num : nums){
            runningSum += num;
            if( runningSum > maxPossibleSum){
                totalSubsets++;
                runningSum = 0; // reset sum
                runningSum = num; // start sum for new subset

                if( totalSubsets > k)
                    return false;
            }
        }
        return true;
    }
}


