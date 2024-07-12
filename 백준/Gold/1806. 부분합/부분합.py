INF = float("inf")
ans = INF

N, S = map(int, input().split(' '))
A = list(map(int, input().split(' ')))

en = 0
tempSum = A[0]

# en에 따른 st의 움직임
for st in range(N):
    if st > 0:
        tempSum -= A[st-1]
    
    while en < N and tempSum < S :
        en += 1
        if en < N:
            tempSum += A[en]

    # en 포인터가 배열을 벗어나면 즉시 종료
    if en >= N:
        break

    # 조건을 만족하는 부분 배열의 길이 중 최소값 찾기
    ans = min(ans, en - st + 1)

if ans == INF:
    print(0)
else:
    print(ans)