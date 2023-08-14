class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}
        for i in range(len(nums)):
            current = nums[i]
            complement = target - current
            if complement in map:
                return [i, map[complement]]
            map[current] = i
