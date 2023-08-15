class Solution:
    def climbStairs(self, n: int) -> int:
        step_1, step_2 = 1, 1

        for i in range(n - 1):
            temp = step_1
            step_1 = step_1 + step_2
            step_2 = temp

        return step_1
