N,M = map(int,input().split())
bucket = [*range(1,N+1)]

for _ in range(M):
    i,j = map(int,input().split())
    for x in range(i,j):
        temp = bucket[x-1]
        bucket[x-1] = bucket[j-1-x]
    bucket[j-1] = temp
print(' '.join(map(str,bucket)))