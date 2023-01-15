class Solution {
   public static int search(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    int mid;

    while (low <= high) {
      mid = (low + high) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      if (nums[mid] < target) {
        // binary search - left
        low = mid + 1;
      } else {
        // binary search - right
        high = mid - 1;
      }
    }

    return -1;
  }
}