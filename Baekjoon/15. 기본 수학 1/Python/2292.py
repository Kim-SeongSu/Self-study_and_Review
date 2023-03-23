N = int(input())

A,i = 1,0
while A + i*6 < N:
    A = A+i*6
    i += 1
print(i+1)


'''
print(round(((int(input())-1)/3)**0.5)+1)
'''