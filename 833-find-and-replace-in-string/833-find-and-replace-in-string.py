class Solution:
    def findReplaceString(self, s: str, indices: List[int], sources: List[str], targets: List[str]) -> str:
        dic = {}
        for i in range(len(indices)): dic[indices[i]] = i
        res = []
        i = 0
        while i < len(s):
            if i in dic and s[i: i + len(sources[dic[i]])] == sources[dic[i]]:
                res.append(targets[dic[i]])
                i += len(sources[dic[i]])
            else:
                res.append(s[i])
                i+=1
            print(i)
        return ''.join(res)
                