import sys
from collections import deque

# 빠른 입력 
input = sys.stdin.readline

q = deque()
N = int(input().rstrip())
for i in range(N):
    req = input().rstrip()
    if 'push' in req:
        req = req.split(' ')
        q.append(int(req[1]))
    elif req == 'pop':
        if len(q) == 0:
            print(-1)
        else:
            print(q.popleft())
    elif req == 'size':
        print(len(q))
    elif req == 'empty':
        if len(q) == 0:
            print(1)
        else:
            print(0)
    elif req == 'front':
        if len(q) == 0:
            print(-1)
        else:
            print(q[0])
    elif req == 'back':
        if len(q) == 0:
            print(-1)
        else:
            print(q[len(q)-1])