class TextEditor:

    def __init__(self):
        self.left = []
        self.right = []

    def addText(self, text: str) -> None:
        for c in text:
            self.left.append(c)

    def deleteText(self, k: int) -> int:
        cnt = 0
        while self.left and k > 0:
            c = self.left.pop()
            cnt += 1
            k -= 1
        return cnt 

    def cursorLeft(self, k: int) -> str:
        while self.left and k > 0:
            c = self.left.pop()
            self.right.append(c)
            k -= 1
        return self.shift_left_str()

    def cursorRight(self, k: int) -> str:
        while self.right and k > 0:
            c = self.right.pop()
            self.left.append(c)
            k -= 1
        return self.shift_left_str()
    
    def shift_left_str(self):
        res = []
        cursor = len(self.left) - 1
        cnt = 10
        while cursor >= 0 and cnt > 0:
            res.append(self.left[cursor])
            cursor -= 1
            cnt -= 1
        return ''.join(res[::-1])


# Your TextEditor object will be instantiated and called as such:
# obj = TextEditor()
# obj.addText(text)
# param_2 = obj.deleteText(k)
# param_3 = obj.cursorLeft(k)
# param_4 = obj.cursorRight(k)