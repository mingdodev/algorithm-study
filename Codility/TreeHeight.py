from extratypes import Tree  # library with types used in the task

def solution(T):
    global cnt
    cnt = 0
    tempCnt = 0

    dfs(T, tempCnt)

    return cnt

# 가지가 둘 다 존재할 때와 하나는 존재하지 않을 때를 구분
# 이전에는 둘 다 존재할 경우 먼저 탐색한 가지의 길이가 다음 가지의 길이에 영향을 미쳤음
def dfsGood(root, tempCnt):
    global cnt
    
    # or는 and를 포함하기 때문에 and인 경우를 먼저 빼줘야 case 구분이 된다.
    if root.l and root.r:
        if root.l:
            tempCnt += 1 # 우리는 이 부분을 신경써줘야 한다.
            dfs(root.l, tempCnt) # 이 작업은 최대값에만 영향을 준다
        else:
            if cnt < tempCnt:
                cnt = tempCnt

        if root.r:
            dfs(root.r, tempCnt)
        else:
            if cnt < tempCnt:
                cnt = tempCnt
    else:
        if root.l:
            tempCnt += 1
            dfs(root.l, tempCnt)
        else:
            if cnt < tempCnt:
                cnt = tempCnt

        if root.r:
            tempCnt += 1
            dfs(root.r, tempCnt)
        else:
            if cnt < tempCnt:
                cnt = tempCnt

    return cnt

def solutionWoo(T):
    # T(x, l, r)
    # 노드의 높이 ** 2 == 리프노드의 개수 (리프노드가 꽉 차있을 때)
    # 하지만 트리가 주어지기 때문에 노드를 세는 것이 더 오래 걸릴 듯
    # 재귀?
    global cnt
    cnt = 0
    tempCnt = 0

    dfs(T, tempCnt)

    return cnt

def dfs(root, tempCnt):
    global cnt

    if root.l:
        tempCnt += 1
        dfs(root.l, tempCnt)
    else:
        if cnt < tempCnt:
            cnt = tempCnt
    if root.r:
        tempCnt += 1
        dfs(root.r, tempCnt)
    else:
        if cnt < tempCnt:
            cnt = tempCnt

    return cnt