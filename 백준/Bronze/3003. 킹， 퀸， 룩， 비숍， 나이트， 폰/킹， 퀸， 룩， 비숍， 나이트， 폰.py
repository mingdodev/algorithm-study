set = input()
set = set.split(' ')

fullSet = [1, 1, 2, 2, 2, 8]

def checkSet(set):
    neededSet = []
    for i in range(6):
        neededSet.append(fullSet[i] - int(set[i]))
    return neededSet

result = checkSet(set)
for i in range(6):
    print(result[i], end=' ')