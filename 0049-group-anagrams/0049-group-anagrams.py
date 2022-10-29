class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagram = defaultdict(list)
        for s in strs:
            anagram[tuple(sorted(s))].append(s)
        return anagram.values()   
        