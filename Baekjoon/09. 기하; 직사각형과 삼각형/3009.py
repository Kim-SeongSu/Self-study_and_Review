def classify(group, spot):
    if spot not in group:
        group.append(spot)
    else:
        group.remove(spot)

X,Y = [],[]
for _ in range(3):
    A, B = map(int,input().split())
    classify(X,A)
    classify(Y,B)
print(X[0],Y[0])