import sys
input = sys.stdin.readline

K = int(input())
account = []
sum = 0

for i in range(K):
    n = int(input())
    if n == 0:
        # 지울 수 보장됨
        account.pop()
    else:
        account.append(n)

for i in range(len(account)):
    sum += account[i]

print(sum)