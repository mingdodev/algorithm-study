import sys
input = sys.stdin.readline

def isPerfect(n):
    divisors = []
    sum = 0
    # 자기 자신이 아닌 약수 찾기
    for i in range(1, n):
        if n % i == 0:
            divisors.append(i)
            sum += i
        if sum > n:
            return False
    
    if sum == n:
        return divisors
    return False

while True:
    n = int(input().rstrip())

    if n == -1:
        break

    result = isPerfect(n)
    if result:
        print(n, '= ', end='')
        print(*result, sep=' + ')
    else:
        print(n, 'is NOT perfect.')