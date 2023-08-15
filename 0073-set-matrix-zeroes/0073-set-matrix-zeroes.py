class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:       
        m = len(matrix)
        n = len(matrix[0])
		
        first_row_has_zero = False
        first_col_has_zero = False
        
        # first_row, first_col => 기준점
        for row in range(m):
            for col in range(n):
                if matrix[row][col] == 0:
                    if row == 0:
                        first_row_has_zero = True
                    if col == 0:
                        first_col_has_zero = True
                    # first_row, first_col's value == 0    
                    matrix[row][0] = matrix[0][col] = 0
    
        # first_row, first_col 를 제외하고 for loop
        # first_row, first_col's value == 0 -> matrix[row][col] == 0
        for row in range(1, m):
            for col in range(1, n):
                matrix[row][col] = 0 if matrix[0][col] == 0 or matrix[row][0] == 0 else matrix[row][col]
        
        # update the first row and col if they're zero
        if first_row_has_zero:
            for col in range(n):
                matrix[0][col] = 0
        
        if first_col_has_zero:
            for row in range(m):
                matrix[row][0] = 0