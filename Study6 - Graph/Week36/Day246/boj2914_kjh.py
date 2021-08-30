import math

songAmount, targetAverage = map(int, input().split(' '))

rangeStart = songAmount * (targetAverage - 1)
rangeEnd = songAmount * targetAverage;

for melodyAmount in range(rangeStart, rangeEnd + 1):
    average = math.ceil(melodyAmount / songAmount)
    if average == targetAverage:
        print(melodyAmount)
        break;