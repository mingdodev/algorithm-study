from collections import deque

total = int(input())
inputLine = input().split(' ')
line = deque()
for i in inputLine:
    line.append(int(i))
waitingStack = deque()
cnt = 1

while len(line) > 0:
    if len(waitingStack) > 0:
        if waitingStack[-1] == cnt:
            waitingStack.pop()
            cnt += 1
            continue
        else:
            if line[0] == cnt:
                line.popleft()
                cnt += 1
            else:
                waitingStack.append(line.popleft())
    else:
        if line[0] == cnt:
                line.popleft()
                cnt += 1
        else:
            waitingStack.append(line.popleft())
            
# 대기열 검토
while len(waitingStack) != 0:
    if waitingStack.pop() == cnt:
        cnt += 1
    else:
        break

if cnt > total:
    print('Nice')
else:
    print('Sad')