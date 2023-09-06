from collections import deque

class Solution:
    def shortestBridge(self, grid: list[list[int]]) -> int:
        dx = [-1, 1, 0, 0]
        dy = [0, 0, -1, 1]
        n = len(grid)
        visited = set()

        def invalid(row, col):
            return row < 0 or row >= n or col < 0 or col >= n

        def dfs(row: int, col: int):
            if invalid(row, col) or not grid[row][col] or (row, col) in visited:
                return

            visited.add((row, col))

            for i in range(4):
                new_dx = row + dx[i]
                new_dy = col + dy[i]
                dfs(new_dx, new_dy)

        def bfs():
            result, queue = 0, deque(visited)
            while queue:
                for i in range(len(queue)):
                    row, col = queue.popleft()
                    for i in range(4):
                        new_dx = row + dx[i]
                        new_dy = col + dy[i]

                        if invalid(new_dx, new_dy) or (new_dx, new_dy) in visited:
                            continue

                        # new island
                        if grid[new_dx][new_dy]:
                            return result

                        queue.append((new_dx, new_dy))
                        visited.add((new_dx, new_dy))

                # 2번째 섬으로 가기 위해 바뀌어야 하는 0 의 수 +1
                result += 1

        for i in range(n):
            for j in range(n):
                if grid[i][j]:
                    # 섬 덩어리(전체 섬) 을 찾아 visited 처리
                    dfs(i, j)
                    # 다음 섬까지 가기 위해 탐색 -> 물(0) 을 섬(1) 으로 바꾸고 그 숫자를 count
                    return bfs()
        