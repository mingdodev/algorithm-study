def solution1(A):
    uniqueCnt = 0
    lenA = len(A)

    for i in range(lenA):
        uniqueCnt = 0
        for j in range(lenA):
            # 비교 대상이 아닌 아이템들 중
            if j != i:
                if A[i] == A[j]:
                    break
                # 중복이 아닐 경우를 체크
                uniqueCnt += 1

        # unique하다면 해당 값을 리턴
        if uniqueCnt == lenA - 1:
            return A[i]

    # unique한 값이 없는 경우 -1을 리턴
    return -1

def solution2(A):
    B = A.copy()

    while len(B) != 0:
        initLen = len(B)
        searchVal = B[0]
        # b와 동일한 값 모두 제거
        B[:] = (val for val in B if val != B[0])
        afterLen = len(B)
        # 자기 자신만 제거되었다면 현재 탐색값은 unique
        if initLen - 1 == afterLen:
            return searchVal

    # unique한 값이 존재하지 않는 경우
    return -1

# 둘 다 시간 복잡도가 O(N**2)