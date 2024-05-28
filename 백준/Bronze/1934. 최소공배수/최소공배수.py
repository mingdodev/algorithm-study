from collections import deque
import sys
input = sys.stdin.readline
print = sys.stdout.write

T = int(input().rstrip())
result = deque()

for _ in range(T):
    A, B = list(map(int, input().rstrip().split(' ')))
    axb = A * B

    # 최대공약수 구하기
    R = A % B
    if R == 0:
        result.append(str(axb // B))
    else:
        if A > B:
            while R != 0:
                R = A % B
                A = B
                B = R
            # 최소공배수 구하기
            result.append(str(axb // A))
        elif A == B:
            result.append(str(A))
        else:
            while R != 0:
                R = B % A
                B = A
                A = R
            result.append(str(axb // B))

for i in result:
    print(i)
    print('\n')