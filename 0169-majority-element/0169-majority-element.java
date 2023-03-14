import java.util.Map.Entry;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
          map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Entry<Integer, Integer> first = map.entrySet().stream()
            .filter(o -> o.getValue() > nums.length / 2).findFirst().get();

        return first.getKey();
    }
}