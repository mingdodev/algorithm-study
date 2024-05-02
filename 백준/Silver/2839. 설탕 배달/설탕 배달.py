N = int(input())

# 5로 나눈 몫을 저장
n = N // 5
m = 0

while n > 0:
    if (N - 5 * n) % 3 == 0:
        m = (N - 5 * n) // 3
        break
    else:
        n -= 1

if n == 0 and N % 3 == 0:
    m = N // 3

if m == 0 and n == 0:
    print(-1)
else:
    print(m + n)