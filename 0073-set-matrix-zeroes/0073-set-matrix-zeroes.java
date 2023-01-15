class Solution {
    public static void setZeroes(int[][] matrix) {
    // 1. O(nm) space: copy 를 만들어 모든 배열을 순회
    // 2. O(m + n) space:
    // fixed amount of row/column 인 것에 주목.
    // => copy 를 만들 필요가 없음 => 하나의 row 용 array, column 용 array 를 사용한다.
    // => 2개의 1차원 배열만 필요하므로, O(m+n) 의 공간복잡도(메모리사용), O(mn)3 의 시간복잡도

    // 3. O(1): constant space solution!
    // => 하나의 row 용 array, column 용 array 를 사용하되, 그 배열을 매트릭스 안에 넣는다.
    // => 두 개의 일차원 배열이 겹쳐지는 부분만을 메모리로 사용
    int row = matrix.length;
    int col = matrix[0].length;

    // row/col 의 intersection; 0번째 row가 0인지 판별하는 boolean 값.
    boolean rowZero = false;

    // determine with row/col need to be zero
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        // 행렬을 순회하며 원소의 값이 0인 경우, 행렬의 각 첫번째 행과 첫번째 열에 값을 0으로 설정한다.
        if (matrix[i][j] == 0) {
          matrix[0][j] = 0;
          if (i > 0) {
            matrix[i][0] = 0;
          } else {
            rowZero = true;
          }
        }
      }
    }

    // 행렬을 재순회 하며, 첫번째 행과 첫번째 열의 값을 기준으로 행렬을 0으로 설정한다.
    // intersection row/col 은 제외하고
    for (int i = 1; i < row; i++) {
      for (int j = 1; j < col; j++) {
        if (matrix[0][j] == 0 || matrix[i][0] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    // for intersection matrix
    if (matrix[0][0] == 0) {
      for (int i = 0; i < row; i++) {
        matrix[i][0] = 0;

      }
    }

    if (rowZero) {
        for (int j = 0; j < col; j++) {
          matrix[0][j] = 0;
        }
      }

  }
}