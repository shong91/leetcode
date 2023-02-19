class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    int[] direction_x = new int[]{0, 0, -1, 1}; // 상 하 좌 우
    int[] direction_y = new int[]{-1, 1, 0, 0};

    Stack<int[]> stack = new Stack();
    int initColor = image[sr][sc];
    stack.push(new int[]{sr, sc});
    image[sr][sc] = color;

    while (!stack.isEmpty()) {
      int[] srsc = stack.pop();
      for (int i = 0; i < direction_x.length; i++) {
        if (srsc[0] + direction_x[i] >= 0 && srsc[0] + direction_x[i] < image.length
            && srsc[1] + direction_y[i] >= 0 && srsc[1] + direction_y[i] < image[0].length) {
          // move to 4-directionally connected pixels
          sr = srsc[0] + direction_x[i];
          sc = srsc[1] + direction_y[i];

          // flood fill and push to stack
          if (image[sr][sc] == initColor
             && image[sr][sc] != color) {

            stack.push(new int[]{sr, sc});
            image[sr][sc] = color;
          }
        }
      }
    }

    return image;
  }
}