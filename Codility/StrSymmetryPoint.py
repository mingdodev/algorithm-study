A = "racecar"
k = len(A) // 2

print(A[-1:k:-1])
print(k)
l = 7 / 2
print(l)
if 'rac' == 'rac':
    print("ye")

# O(length(S))

def solution(S):
    # 문자열 비교
    # 기준 문자의 왼쪽과 오른쪽을 비교
    # 왼, 오의 크기는 동일해야 한다. 즉 기준 문자는 가운데 인덱스
    # 문자열의 크기가 짝수이면 안 됨
    # 문자열의 크기가 홀수일 때, 기준 문자 인덱스 k는 len(S) // 2
    # S[:k] == S[-1:k-1:-1]
    # 24m

    N = len(S)

    if N % 2 == 0:
        return -1
    else:
        k = N // 2
        if S[:k] == S[-1:k:-1]:
            return k

    return -1