N,M = map(int,input().split())
bucket = [*range(1,N+1)]

for _ in range(M):
    i,j = map(int,input().split())
    front, change, back = bucket[:i-1], bucket[i-1:j], bucket[j:]
    change.reverse()
    bucket = front + change + back
    
print(' '.join(map(str,bucket)))


'''
f = lambda : map(int,input().split())
N,M = f()
bucket = [*range(1,n+1)]
for _ in range(m):
    i,j =f()
    bucket[i-1:j] = bucket[i-1:j][::-1]
print(*bucket)
'''