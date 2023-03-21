N = input()
L = list(map(int,input().split()))
for i in L:
    temp = []
    for j in range(1,1+i):
        if i % j == 0:
            temp.append(j)
    if len(temp) == 2:
        L[L.index(i)] = '*'
print(L.count('*'))