import math

A, B, V = map(int, input().split(' '))

d = math.ceil(V / (A-B))

i = 1
day = d

while True:
    if (d - i) * (A-B) + A >= V:
        day = d-i
    else:
        break
    i += 1

print(day+1)