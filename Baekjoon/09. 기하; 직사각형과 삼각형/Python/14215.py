A = sorted(map(int,input().split()))
# print(3*A[0] if A[0] == A[1] == A[2] else 2*(A[0]+A[1])-1)

print(A[0] +A[1] + min(A[2],(A[0]+A[1]-1)))