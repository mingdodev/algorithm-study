import sys
input = sys.stdin.readline

def isTriangle(x, y, z):
    if ((x[0]-z[0]) * (x[1]-y[1]) == (x[1]-z[1]) * (x[0]-y[0])):
        return False
    else:
        return True
    
def isRight(x, y, z):
    if (((x[0]-y[0])*(x[0]-z[0]) + (x[1]-y[1])*(x[1]-z[1]) == 0)
        or ((x[0]-y[0])*(y[0]-z[0]) + (x[1]-y[1])*(y[1]-z[1]) == 0)
        or ((y[0]-z[0])*(x[0]-z[0]) + (y[1]-z[1])*(x[1]-z[1]) == 0)):
        return True
    else:
        return False

N = int(input().rstrip())
result = 0
dots = [list(map(int, input().rstrip().split(' '))) for i in range(N)]

for i in range(N-2):
    for j in range(i+1, N-1):
        for k in range(j+1, N):
            if isRight(dots[i], dots[j], dots[k]) and isTriangle(dots[i], dots[j], dots[k]):
                result += 1
     
print(result)