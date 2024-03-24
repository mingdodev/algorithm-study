import sys
input = sys.stdin.readline

class Stack:
    s = []
    size = 0

    def push(self, x):
        self.s.append(x)
        self.size += 1

    def printPopped(self):
        if self.isEmpty() == 0:
            result = self.s[-1]
            del self.s[-1]
            self.size -= 1
            return result
        else:
            return -1

    def printSize(self):
        return self.size
    
    def isEmpty(self):
        if self.size == 0:
            return 1
        else:
            return 0
        
    def printTop(self):
        if self.isEmpty() == 0:
            return self.s[-1]
        else:
            return -1
        
s = Stack()
N = int(input().rstrip())
for i in range(N):
    req = input().rstrip()
    if req[0] == '1':
        s.push(int(req.split(' ')[-1]))
    elif req == '2':
        print(s.printPopped())
    elif req == '3':
        print(s.printSize())
    elif req == '4':
        print(s.isEmpty())
    elif req == '5':
        print(s.printTop())
    else:
        print('잘못된 입력입니다.')