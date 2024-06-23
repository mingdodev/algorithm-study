def solution(N):
    binN = format(N, 'b')
    maxGap = 0
    tempIndex = 0
    edges = []

    for b in binN:
        if b == '1':
            edges.append(tempIndex)
        tempIndex += 1

    # 가장자리가 존재하지 않아 gap이 없는 경우
    lenEdges = len(edges)
    if lenEdges == 0 or lenEdges == 1:
        return maxGap
    
    # maxGap 찾기 (가장자리가 있지만 gap이 0인 경우도 포함)
    for i in range(lenEdges-1):
        if maxGap < (edges[i+1]-edges[i]-1):
            maxGap = edges[i+1]-edges[i]-1

    return maxGap

print(solution(529))

# 0620