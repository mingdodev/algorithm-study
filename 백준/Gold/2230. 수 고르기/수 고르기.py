INF = 2000000000
ans = INF

N, M = map(int, input().split(' '))
A = []

# A 입력을 배열로 받음
for i in range(N):
    A.append(int(input()))

# A 정렬
A.sort()

st = 0
en = 0

# en에 따른 st의 움직임
for st in range(N):
    # 조건에 맞는 en 설정: 차이값이 M 이상이면 en 이동 멈춤
    # en의 범위를 먼저 체크해줘야 out of index error가 발생하지 않음
    while en < N and A[en] - A[st] < M :
        en += 1

    # en 포인터가 배열을 벗어나면 즉시 종료
    if en >= N:
        break

    # 차이값 중 최소값 찾기
    ans = min(ans, A[en] - A[st])

print(ans)