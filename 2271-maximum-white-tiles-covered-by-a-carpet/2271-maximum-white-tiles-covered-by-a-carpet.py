class Solution:
    def maximumWhiteTiles(self, tiles: List[List[int]], carpetLen: int) -> int:
        #sliding window + greedy
        res, cover, n = 0, 0, len(tiles)
        tiles.sort()
        i = j = 0
        while i < n and res <= carpetLen:
            if i == j or tiles[j][0] + carpetLen > tiles[i][1]:
                cover += tiles[i][1] - tiles[i][0] + 1
                res = max(res, cover)
                i += 1
            else:
                partial = tiles[j][0] + carpetLen - tiles[i][0]
                res = max(res, cover + partial)
                cover -= tiles[j][1] - tiles[j][0] + 1
                j += 1
        return res