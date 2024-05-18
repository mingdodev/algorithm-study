import sys
input = sys.stdin.readline

N, M = map(int, input().rstrip().split(' '))

trees = list(map(int, input().rstrip().split(' ')))

height_min = 0
height_max = max(trees)
good = 0

# 아 같은 경우까지 체크해줘야 good 값이 업데이트 되겠구나
while height_max >= height_min:
    gain = 0
    search = (height_max + height_min) // 2

    for i in range(N):
        # 음수이면 값을 버려야 함
        if (trees[i] - search) > 0:
            gain += (trees[i] - search)
    
    if gain == M:
        good = search
        break
    elif gain > M:
        # 현재 값보다 더 큰 값을 탐색해야 함(더 위에서 잘라야 얻는 양이 적음)
        good = search
        height_min = search + 1
    else:
        height_max = search - 1

print(good)