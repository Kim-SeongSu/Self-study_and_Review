N,M = map(int,input().split())
bucket = list(map(str,range(1,N+1)))

for _ in range(M):
    i,j = map(int,input().split())
    bucket[i-1], bucket[j-1] = bucket[j-1] , bucket[i-1]
    
print(' '.join(bucket))