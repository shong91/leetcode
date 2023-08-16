class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        def dfs(row, col):
            for i in range(4):
                next_row = dx[i] + row
                next_col = dy[i] + col

                if (
                    next_row < 0
                    or next_row >= m
                    or next_col < 0
                    or next_col >= n
                    or grid[next_row][next_col] == "0"
                ):
                    continue

                grid[next_row][next_col] = "0"
                dfs(next_row, next_col)

        n = len(grid[0])  # col
        m = len(grid)  # row
        answer = 0
        # visited = [[False] * n for _ in range(m)]
        # 방향 벡터
        dx = [-1, 1, 0, 0]
        dy = [0, 0, -1, 1]

        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    answer += 1
                    dfs(i, j)
                    
        return answer