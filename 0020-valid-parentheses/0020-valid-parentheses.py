class Solution:
    def isValid(self, s: str) -> bool:
        parentheses = dict(("()", "[]", "{}"))
        stack = []
        print(parentheses)
        for element in s:
            if element in "([{":
                # If open parentheses are present, append it to stack
                stack.append(element)
            elif len(stack) == 0 or element != parentheses[stack.pop()]:
                # If the character is closing parentheses, check that the same type opening parentheses is being pushed to the stack or not
                return False

        return len(stack) == 0