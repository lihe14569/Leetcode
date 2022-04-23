class Codec:
    def __init__(self):
        self.dic = {}
        self.i = 0
    
    def encode(self, longUrl: str) -> str:
        """Encodes a URL to a shortened URL.
        """
        self.dic[self.i] = longUrl
        s = "http://tinyurl.com/" + str(self.i)
        self.i += 1
        return s
        

    def decode(self, shortUrl: str) -> str:
        """Decodes a shortened URL to its original URL.
        """
        idx = int(shortUrl.split("/")[-1])
        return self.dic[idx]

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(url))