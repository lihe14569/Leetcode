class Solution:
    def frequencySort(self, s: str) -> str:
        #bucketsort: hashtable + sort
        dic = collections.defaultdict(int)
        for c in s:
            dic[c] += 1
        res = []
        for k, v in sorted(dic.items(), key=lambda x: -x[1]):
            res += [k]*v
        return ''.join(res)