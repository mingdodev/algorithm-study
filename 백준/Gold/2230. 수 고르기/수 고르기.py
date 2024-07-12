# 두 수의 차이 최소값 초기화
INF = float("inf")
ans = INF

# N, M 입력
N, M = map(int, input().split(' '))

# A 입력 배열로 받기
A = []
for i in range(N):
    A.append(int(input()))

# A 정렬
A.sort()

# en에 따른 st의 움직임
en = 0
for st in range(N):
    # 조건에 맞는 en 설정: 차이값이 M 이상이면 en 이동 멈춤
    while en < N and A[en] - A[st] < M :
        en += 1

    # en 포인터가 배열을 벗어나면 즉시 종료
    if en >= N:
        break

    # 차이값 중 최소값 찾기
    ans = min(ans, A[en] - A[st])

# 정답 출력
print(ans)