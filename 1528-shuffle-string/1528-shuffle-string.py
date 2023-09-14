class Solution:
    def restoreString(self, s: str, indices: List[int]) -> str:
        i = 0
        slist = list(s)
        for indice in indices:
            slist[indice] = s[i]
            i+=1
            
            
        return ''.join(slist)