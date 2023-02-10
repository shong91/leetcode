class Solution {
    public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int value = target - nums[i];
      if (map.get(value) == null) {
        map.put(nums[i], i);
      } else {
        return new int[]{map.get(value), i};
      }
    }
    return nums;
    }
}