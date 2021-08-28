# js도 python3도 시간초과지만 pypy3은 통과하는 매직,,
from collections import deque
import sys
input = sys.stdin.readline

def cntHackingComputerByBFS(startVertex):
    hackedComputer = [False] * (N + 1)
    queue = deque()
    queue.append(startVertex)

    hackedComputer[startVertex] = True

    while queue:
        vertex = queue.popleft()

        for nextVertex in computerGraph[vertex]:
            if hackedComputer[nextVertex] == True: continue

            queue.append(nextVertex)
            hackedComputer[nextVertex] = True

    return hackedComputer.count(True)

N, M = map(int, input().split())
computerGraph = [[] for _ in range(N + 1)]
cntOfhackingInComputer = [0] * (N + 1)

for i in range(M):
    fromVertex, toVertex = map(int, input().split())
    computerGraph[toVertex].append(fromVertex)

for i in range(1, N + 1):
    cntOfhackingInComputer[i] = cntHackingComputerByBFS(i)

for i in range(len(cntOfhackingInComputer)):
    if cntOfhackingInComputer[i] == max(cntOfhackingInComputer):
        print(i, end=" ")