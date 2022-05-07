class Solution:
    def frequencySort(self, s: str) -> str:
        #bucketsort: hashtable + heap
        dic = collections.defaultdict(int)
        for c in s:
            dic[c] += 1
        res = []
        pq = []
        for k, v in dic.items():
            heapq.heappush(pq, (-v, k))
        while pq:
            v, c= heapq.heappop(pq)
            res += [c]*-v
        return ''.join(res)