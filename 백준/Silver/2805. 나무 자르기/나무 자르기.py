import sys
input = sys.stdin.readline

N, M = map(int, input().rstrip().split(' '))

trees = list(map(int, input().rstrip().split(' ')))

height_min = 0
height_max = max(trees)
good = 0

while height_max >= height_min:
    search = (height_max + height_min) // 2
    # 파이썬의 경우 반복문에서 매우 느리기 때문에 ... 이 부분 수정
    gain = sum(tree - search for tree in trees if tree > search)
    
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