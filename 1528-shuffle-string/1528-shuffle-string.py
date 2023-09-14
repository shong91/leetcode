class Solution:
    def restoreString(self, s: str, indices: List[int]) -> str:
        slist = list(s)
        for i in range(len(s)):
            slist[indices[i]] = s[i]
                     
        return ''.join(slist)