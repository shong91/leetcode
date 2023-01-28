class Solution {

  static int[] dr = {-1, 1, 0, 0};
  static int[] dc = {0, 0, -1, 1};
  
    public int orangesRotting(int[][] grid) {
    int min = 0; 
    int row = grid.length;
    int col = grid[0].length;
    Queue<int[]> queue = new LinkedList<>();

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == 2) { // 상한 오렌지의 위치를 저장
          queue.offer(new int[]{i, j});
        }
      }
    }

    while (!queue.isEmpty()) {
     int initial = queue.size();
            
     while(initial > 0) {
         initial--;
         int[] q = queue.poll();
         for (int i = 0; i < 4; i++) {
            int newr = q[0] + dr[i];
            int newc = q[1] + dc[i];
            // if fresh orange in range
            if (0 <= newr && newr < row
                && 0 <= newc && newc < col
                && grid[newr][newc] == 1) {
              queue.offer(new int[]{newr, newc});
              grid[newr][newc] = 2;

            }
          }
    }
        
    if (queue.size() > 0 ) { // 새로 오염된 오렌지가 존재한다면 시간 증가
        min++;
    }
            
    }

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == 1) {
          return -1;
        }

      }
    }
    return min;
  }
}