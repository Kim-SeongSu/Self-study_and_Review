# S = ['']*10000

# for _ in range(int(input())):
#     x,y = map(int,input().split())
#     for i in range(x,x+10):
#         for j in range(y,y+10):
#             S[(i-1)*100+(j-1)] = '*'

# print(S.count('*'))



S = [[0]*100 for _ in range(100)]

for _ in range(int(input())):
    x,y = map(int,input().split())
    for i in range(x,x+10):
        for j in range(y,y+10):
            S[i-1][j-1] = 1

result = 0
for i in S:
    result += sum(i)
print(result)