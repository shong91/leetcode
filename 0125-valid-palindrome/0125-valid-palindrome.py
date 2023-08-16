class Solution:
    def isPalindrome(self, s: str) -> bool:
        new_string = [char.lower() for char in s if char.isalnum()]
        
        for i in range(len(new_string) // 2):
            if new_string[i] != new_string[len(new_string) - 1 - i]:
                return False

        return True