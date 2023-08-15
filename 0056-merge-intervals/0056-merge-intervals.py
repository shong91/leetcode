class Solution:
    def merge(self, intervals: list[list[int]]) -> list[list[int]]:
        # priorityQueue sort
        intervals.sort(key=lambda i: i[0])
        
        # avoid edge case
        output = [intervals[0]]

        for start, end in intervals[1:]:
            # most recently added interval's end
            last_end = output[-1][1]

            # overlapping
            if start <= last_end:
                output[-1][1] = max(last_end, end)
            else:
                output.append([start, end])

        return output