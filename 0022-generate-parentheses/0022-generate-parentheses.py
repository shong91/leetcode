class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        def dfs(n, open, close, answer):
            # base condition
            if open == close and open == n:
                list.append(answer)

            if open < n:
                dfs(n, open + 1, close, answer + "(")

            if open > close:
                dfs(n, open, close + 1, answer + ")")

        # n pairs == n open Parenthesis, n close Parenthesis
        list = []
        dfs(n, 0, 0, "")

        return list
