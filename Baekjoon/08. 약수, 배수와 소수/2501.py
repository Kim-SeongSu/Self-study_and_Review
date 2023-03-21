N, K = map(int,input().split())
arr = [i for i in range(1,N+1) if N % i == 0]

arr += [0] * (10000-len(arr))
print(arr[K-1])

# try:
#     print(arr[K-1])
# except:
#     print(0)