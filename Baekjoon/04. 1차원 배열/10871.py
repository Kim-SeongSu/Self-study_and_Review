'''
N, X = map(int,input().split())

A = map(int,input().split())
B =''
for x in A:
    if x < X:
        B += f'{x} '

print(B)
'''

N, X = map(int,input().split())
A = ' '.join([i for i in input().split() if int(i) < X])
print(A)