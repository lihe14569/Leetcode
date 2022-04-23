class Codec:
    dic = {}
    
    
    def encode(self, longUrl: str) -> str:
        """Encodes a URL to a shortened URL.
        """
        self.dic[hash(longUrl)] = longUrl
        s = "http://tinyurl.com/" + str(hash(longUrl))
        return s
        

    def decode(self, shortUrl: str) -> str:
        """Decodes a shortened URL to its original URL.
        """
        idx = int(shortUrl.split("/")[-1])
        return self.dic[idx]

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(url))