A, B = [],[]
N,M = map(int,input().split())

import numpy as np

for _ in range(N):
    A.append(list(map(int,input().split())))

for _ in range(N):
    B.append(list(map(int,input().split())))

arr_A, arr_B = np.array(A),np.array(B)
arr_A.reshape(N,M)
arr_B.reshape(N,M)

print(arr_A + arr_B)