class TextEditor:
    def __init__(self):
        self.left_stack = []
        self.right_stack = []

    def addText(self, text: str) -> None:
        for ch in text:
            self.left_stack.append(ch)

    def deleteText(self, k: int) -> int:
        count = 0
        while self.left_stack and k > 0:
            self.left_stack.pop()
            count += 1
            k -= 1
        return count

    def cursorLeft(self, k: int) -> str:
        while self.left_stack and k > 0:
            ch = self.left_stack.pop()
            self.right_stack.append(ch)
            k-=1
        return self.cursor_shift_str()

    def cursorRight(self, k: int) -> str:
        while self.right_stack and k > 0:
            ch = self.right_stack.pop()
            self.left_stack.append(ch)
            k-=1
        return self.cursor_shift_str()            
    
    # function to return the last min(10, len) characters to the left of the cursor
    def cursor_shift_str(self):        
        ans = []
        count = 10
        j = len(self.left_stack)-1
        while j >= 0 and count > 0:                        
            ans.append(self.left_stack[j])
            j-=1
            count -=1

        return "".join(ans[::-1])


# Your TextEditor object will be instantiated and called as such:
# obj = TextEditor()
# obj.addText(text)
# param_2 = obj.deleteText(k)
# param_3 = obj.cursorLeft(k)
# param_4 = obj.cursorRight(k)