N,M = map(int,input().split())
bucket = ['0']*N

for _ in range(M):
    i,j,k = map(int,input().split())
    bucket[i-1:j] = str(k)*(k-i+1)
    # 다른 방법
    # for num in range(i-1,j):
    #     bucket[num] = str(k)
print(' '.join(bucket))