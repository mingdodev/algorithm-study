import sys
input = sys.stdin.readline
print = sys.stdout.write

N = int(input().strip())
A = set(input().strip().split(' '))
M = int(input().strip())
B = input().strip().split(' ')

for i in B:
    if i in A:
        print('1')
    else:
        print('0')
    print('\n')