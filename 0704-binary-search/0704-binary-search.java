class Solution {
    public int search(int[] nums, int target) {
        int low = 0; 
        int high = nums.length -1; 
        int mid = -1;

        while(low <= high) {
            mid = (low + high) / 2;
            
            // base case
            if (target == nums[mid]) {
              return mid;
            } 
            
            if (target > nums[mid]) {
              // start to half
             low = mid +1;
            } else {
              // half to end
             high = mid -1; 
            }
        } 
        
        return -1; 
    }
    
}