import math
A, B, V = map(int,input().split())
print(math.ceil((V-A)/(A-B)) +1)


'''
a,b,h = map(int,input().split())
print((h-b-1)//(a-b)+1)
'''