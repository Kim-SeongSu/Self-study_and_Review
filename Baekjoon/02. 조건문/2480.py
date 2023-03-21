A, B, C = map(int, input().split())

if A == B == C:
    print(10000 + A * 1000)
elif (A == B != C) or (A != B == C) or (A == C != B):
    print(1000 + A * 100 if A == B or A == C else 1000 + B * 100)
else:
    print(max(A,B,C)*100)