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

# 함수로 기능을 분리하면 메모리와 시간 효율이 좋지 않나?
    # -> 이정도의 프로그램에서는 무시할 정도의 수준인 듯
# 최소한의 함수 호출을 위해 수정했는데 이런 식으로 하는 게 맞나?