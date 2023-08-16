from collections import Counter

class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        # solved O(1)
        # 같은 값 -> count++, 다른 값-> count--
        # if count == 0 -> re-set major
        response, count = 0, 0
        for num in nums:
            # initially set
            if count == 0:
                response = num
            count += 1 if num == response else -1
        return response