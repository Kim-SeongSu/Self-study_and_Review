A,B = [], []
for _ in range(9):
    A.append(max(row:=list(map(int,input().split()))))
    B.append(row.index(max(row))+1)
print(max(A))
print(A.index(max(A))+1, B[A.index(max(A))])


'''
L=*map(int,open(0).read().split()),
a=L.index(M:=max(L))
print(M,a//9+1,a%9+1)
'''