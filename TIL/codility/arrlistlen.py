def solution(A):
    tempIndex = 0
    arrLen = 0

    while A[tempIndex] != -1:
        arrLen += 1
        tempIndex = A[tempIndex]

    return arrLen + 1

A = [0] * 5
A += ['2', 3]
print(A)