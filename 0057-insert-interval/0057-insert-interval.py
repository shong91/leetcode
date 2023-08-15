class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        intervals.append(newInterval)
        intervals.sort()

        output = [intervals[0]]

        for start, end in intervals[1:]:
            last_end = output[-1][1]
            # overlapping
            if start <= last_end:
                output[-1][1] = max(last_end, end)

            else:
                output.append([start, end])

        return output