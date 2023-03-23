# 1/1                    1          +1
# 1/2 2/1                3          +2
# 3/1 2/2 1/3            6          +3
# 1/4 2/3 3/2 4/1        10         +4
# 5/1 4/2 3/3 2/4 1/5    15         +5


# 시간 초과
'''
X,count,N = int(input()),0,1
while count < X:
    result =[]
    for i in range(len(arr:=list(range(1,N+1)))):
        if N % 2 ==1:
            result.append(f'{arr[-(i+1)]}/{arr[i]}')
        else:
            result.append(f'{arr[i]}/{arr[-(i+1)]}')
    count += len(result)
    N += 1
print(result[-(count-X+1)])
'''

X = int(input())

a,b = 0,0
while a < X:  
    b += 1  
    a += b

arr = list(range(1,b+1))
i = a - X

if b % 2 == 0:
    print(f'{arr[-(i+1)]}/{arr[i]}')
else:
    print(f'{arr[i]}/{arr[-(i+1)]}')

# 런타임 에러
# print(f'{arr[-(i+1)]}/{arr[i]}' if b % 2 == 0 else {arr[i]}/{arr[-(i+1)]})