def solutionDebugging(K, A):
    result = []
    lenA = len(A)
    maxVal = A[0]
    minVal = A[0]
    for p in range(lenA):
        for q in range(p, lenA):
            if max(A[p:q+1])-min(A[p:q+1]) <= K:
                result.append([p,q])
    print(result)
    
    return len(result)

def solutionUsingMethod(K, A):
    result = 0
    lenA = len(A)
    
    for p in range(lenA):
        for q in range(p, lenA):
            if max(A[p:q+1])-min(A[p:q+1]) <= K:
                result += 1

    return result

# ------------- O(N**2)-------------

def solution1(K, A):
    result = 0
    lenA = len(A)
    
    for p in range(lenA):
        for q in range(p, lenA):
            if max(A[p:q+1])-min(A[p:q+1]) <= K:
                result += 1
                # 예외 처리
                if result >= 1000000000:
                    return  1000000000
            else:
                # 해당 p case는 더 이상 탐색할 필요 X
                break

    return result

# ------------- O(NlogN)-------------

# (1,3)에서 끝나면 그담 건 안 봐도 된다는 건 캐치했삼
# 반대로!! (1,3)이 포함이면 (2,3)(3,3)도 포함

def solution1(K, A):
    result = 0
    lenA = len(A)
    
    for p in range(lenA):
        for q in range(p, lenA):
            if max(A[p:q+1])-min(A[p:q+1]) <= K:
                result += 1
                # 예외 처리
                if result >= 1000000000:
                    return  1000000000
            else:
                # 해당 p case는 더 이상 탐색할 필요 X
                break

    return result

# ------------- O(N)-------------
# 네~ 구조 자체는 생각해봤던 아이디어긴 한데, 구현 어떻게?
# -> 앞뒤로 왔다갔다 하는 것이 Queue와 유사

def solutionGolden(K, A):
    N = len(A)

    # 최댓값과 최솟값, 그리고 그들의 인덱스 값
    maxQ = [0] * (N + 1)
    posmaxQ = [0] * (N + 1)
    minQ = [0] * (N + 1)
    posminQ = [0] * (N + 1)

    firstMax, lastMax = 0, -1
    firstMin, lastMin = 0, -1
    j, result = 0, 0

    for i in range(N):
        while (j < N):
            # 새로운 최댓값 추가
            while (lastMax >= firstMax and maxQ[lastMax] <= A[j]):
                lastMax -=1
            lastMax += 1
            maxQ[lastMax] = A[j]
            posmaxQ[lastMax] = j

            # 새로운 최솟값 추가
            while (lastMin >= firstMin and minQ[lastMin] >= A[j]):
                lastMin -= 1
            lastMin += 1
            minQ[lastMin] = A[j]
            posminQ[lastMin] = j

            if (maxQ[firstMax] - minQ[firstMin] <= K):
                j += 1
            else:
                break

        result += (j - i)
        if result >= 1000000000:
            return 1000000000
        if posminQ[firstMin] == i:
            firstMin += 1
        if posmaxQ[firstMax] == i:
            firstMax += 1
    
    return result

from collections import deque

def solution(K, A):
    N = len(A)
    result = 0
    maxQ = deque()
    minQ = deque()
    j = 0

    # 최댓값과 최솟값. i = 0에서 시작한다고 픽스하고 설정.

    for i in range(N):
        while j < N:
            # 가장 최근에 들어온 최댓값과 비교
            if maxQ and A[j] >= maxQ[-1]:
                maxQ.pop()
            maxQ.append(A[j])
            if A[j] <= minQ:
                minQ = A[j]
            if maxQ-minQ <= K:
                j += 1
            else:
                # (1, 3)가 가능하면 (2, 3)도 가능하다
                result += j-i
                break

        if result >= 1000000000:
                return 1000000000
    
    return result