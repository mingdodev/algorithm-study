N = int(input())

i = 0
while(i < N):
    result = ' ' * (N - i - 1) + '*' * (2 * i + 1)
    print(result)
    i += 1

i = N - 2
while(i >= 0):
    result = ' ' * (N - i - 1) + '*' * (2 * i + 1)
    print(result)
    i -= 1