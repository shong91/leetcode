class Solution {
    
  public boolean isOverlap(int[] a, int[] b) {
    return a[0] <= b[1] && b[0] <= a[1];

  }

  public int mergeInterval(int[] a, int[] b) {
//     return new int[]{Math.min(a[0], b[0]), Math.max(a[1], b[1])};
    return Math.max(a[1], b[1]);
  }

  public int[][] merge(int[][] intervals) {
    // 배열을 오름차순 정렬한 뒤 시작
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    LinkedList<int[]> merged = new LinkedList<>();
    for (int[] interval : intervals) {
      if (merged.isEmpty() || !isOverlap(merged.getLast(), interval)) {
        merged.add(interval);
      } else {
        merged.getLast()[1] = mergeInterval(merged.getLast(), interval);
      }
    }

    return merged.toArray(new int[merged.size()][]);
  }

  public int[][] insert(int[][] intervals, int[] newInterval) {
    boolean isIntervalInserted = false;
    List<int[]> list = new ArrayList<>(Arrays.asList(intervals));

    for (int i = 0; i < intervals.length; i++) {
        if (newInterval[0] < intervals[i][0]) {
            // Found the position, insert the interval and break from the loop.
            list.add(i, newInterval);
            isIntervalInserted = true;
            break;
        }
    }

    // If there is no interval with a greater value of start value,
    // then the interval must be inserted at the end of the list.
    if (!isIntervalInserted) {
        list.add(newInterval);
    }

    int[][] newIntervals =list.toArray(new int[list.size()][2]);
    return merge(newIntervals);
  }
}